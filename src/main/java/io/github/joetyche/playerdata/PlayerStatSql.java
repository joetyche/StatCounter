package io.github.joetyche.playerdata;

import java.util.UUID;
import io.github.joetyche.util.StatCounterConfig;

/**
 * This class handles the uploading and downloading of player's data to and from the SQL database,
 * whilst also updating the map cache.
 */
public class PlayerStatSql extends PlayerStatCache {

    private StatCounterConfig statCounterConfig;


    public PlayerStatSql(StatCounterConfig statCounterConfig) {
        this.statCounterConfig = statCounterConfig;
    }

    @Override
    public void setStat(UUID uuid, long statID, double value) {
        // TODO: In future, can do configurable option whether to upload to SQL
        // every time stats are set, periodically, etc.
        // For now, assume every time.
        // Upload stat data to SQL
        setStatSQL(uuid, statID, value);

        // Set in local HashMap too:
        super.setStat(uuid, statID, value);
    }

    @Override
    public double getStat(UUID uuid, long statID, double defaultValue) {
        // If stat not present in local HashMap
        if (!super.playerHasStatLoaded(uuid, statID)) {
            // Download stat data from SQL
            double storedSQLValue = getStatSQL(uuid, statID, defaultValue);

            // Set in local HashMap too:
            super.setStat(uuid, statID, storedSQLValue);
        }

        // Return stat data
        return super.getStat(uuid, statID, defaultValue);
    }

    @Override
    public double getStat(UUID uuid, long statID) {
        return getStat(uuid, statID, statCounterConfig.getDefaultStatValue());
    }

    private void setStatSQL(UUID uuid, long statID, double value) {
        // TODO: Set stat data in SQL
    }


    public double getStatSQL(UUID uuid, long statID, double defaultvalue) {
        // TODO: Retrieve stat data from SQL
        return 0;
    }

}
