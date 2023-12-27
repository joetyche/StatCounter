package io.github.joetyche.playerdata.storage;

import java.util.UUID;
import co.aikar.idb.BukkitDB;
import co.aikar.idb.Database;
import io.github.joetyche.StatCounter;
import io.github.joetyche.util.StatCounterConfig;

/**
 * Handles the uploading and downloading of player's data to and from the SQL database.
 * 
 * @author Tyche
 * @version 1.0
 * @since 1.0
 */
public class PlayerStatSql implements IPlayerStatStorage {

    private Database sqlDb;

    public void loadDB(StatCounter plugin, StatCounterConfig statCounterConfig) {
        sqlDb = BukkitDB.createHikariDatabase(plugin, statCounterConfig.getDbString("dbUser"),
                statCounterConfig.getDbString("dbPass"), statCounterConfig.getDbString("dbName"),
                statCounterConfig.getDbString("hostAndPort"));
    }


    /**
     * @param uuid The user's UUID
     * @param statID The desired statistic ID to update
     * @param value The value to set
     */
    @Override
    public void setStat(UUID uuid, long statID, double value) {
        // TODO: Create prepared statement with these parameters
        // TODO: insert into, values, on duplicate key, set
    }

    /**
     * @param uuid The user's UUID
     * @param statID The desired statistic ID to update
     * @param modifier What to modify the existing value by
     */
    public void updateStat(UUID uuid, long statID, double modifier) {
        // TODO: Create prepared statement with these parameters
        // TODO: insert into, modifier, on duplicate key,
        // if modifier > 0 use +, if modifier < 0 use -
        // update column = column +/- modifier
    }


    /**
     * @param uuid The user's UUID
     * @param statID The desired statistic ID to query
     * @param defaultValue The value to return if none is set
     * @return double The value for this user's queried stat
     */
    @Override
    public double getStat(UUID uuid, long statID, double defaultValue) {
        // TODO: Retrieve stat data from SQL
        return 0;
    }
}
