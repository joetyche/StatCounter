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

    public void setStat(UUID uuid, long statID, double value) {
        // TODO: In future, can do configurable option whether to upload to SQL
        // every time stats are set, periodically, etc.
        // For now, assume every time.
        // Upload stat data to SQL
        playerStatSql.setStat(uuid, statID, value);

        // Set in local HashMap too:
        playerStatCache.setStat(uuid, statID, value);
    }

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

    public double getStat(UUID uuid, long statID) {
        return getStat(uuid, statID, statCounterConfig.getDefaultStatValue());
    }

}
