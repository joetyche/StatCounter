package io.github.joetyche.playerdata;

import java.util.UUID;
import io.github.joetyche.playerdata.storage.PlayerStatCache;
import io.github.joetyche.playerdata.storage.PlayerStatSql;
import io.github.joetyche.util.StatCounterConfig;

public class PlayerStatController {

    private PlayerStatCache playerStatCache;
    private PlayerStatSql playerStatSql;

    private StatCounterConfig statCounterConfig;

    public PlayerStatController(StatCounterConfig statCounterConfig,
            PlayerStatCache playerStatCache, PlayerStatSql playerStatSql) {
        this.statCounterConfig = statCounterConfig;
        this.playerStatCache = playerStatCache;
        this.playerStatSql = playerStatSql;
    }

    /**
     * Updates the Sql & Cache with the provided parameters
     * 
     * @param uuid The user's UUID
     * @param statID The desired statistic ID to update
     * @param value The value to set
     */
    public void setStat(UUID uuid, long statID, double value) {
        // TODO: In future, can do configurable option whether to upload to SQL
        // every time stats are set, periodically, etc.
        // For now, assume every time.
        // Upload stat data to SQL
        playerStatSql.setStat(uuid, statID, value);

        // Set in local HashMap too:
        playerStatCache.setStat(uuid, statID, value);
    }

    /**
     * Queries the desired statistic from the cache or loads it into the cache if it is not present
     * 
     * @param uuid The user's UUID
     * @param statID The desired statistic ID to query
     * @param defaultValue The value to return if none is set
     * @return double The value for this user's queried stat
     */
    public double getStat(UUID uuid, long statID, double defaultValue) {
        // If stat not present in local HashMap
        if (!playerStatCache.playerHasStatLoaded(uuid, statID)) {
            // Download stat data from SQL
            double storedSQLValue = playerStatSql.getStat(uuid, statID, defaultValue);

            // Set in cache:
            playerStatCache.setStat(uuid, statID, storedSQLValue);
        }

        // Return stat data
        return playerStatCache.getStat(uuid, statID, defaultValue);
    }

    /**
     * Queries the desired statistic from the cache or loads it into the cache if it is not present
     * - uses the configured default return value
     * 
     * @param uuid The user's UUID
     * @param statID The desired statistic ID to query
     * @param defaultValue The value to return if none is set
     * @return double The value for this user's queried stat
     */
    public double getStat(UUID uuid, long statID) {
        return getStat(uuid, statID, statCounterConfig.getDefaultStatValue());
    }

}
