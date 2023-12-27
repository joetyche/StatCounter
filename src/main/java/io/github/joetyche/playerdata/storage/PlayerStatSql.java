package io.github.joetyche.playerdata.storage;

import java.util.UUID;

/**
 * Handles the uploading and downloading of player's data to and from the SQL database.
 * 
 * @author Tyche
 * @version 1.0
 * @since 1.0
 */
public class PlayerStatSql implements IPlayerStatStorage {


    /**
     * @param uuid The user's UUID
     * @param statID The desired statistic ID to update
     * @param value The value to set
     */
    @Override
    public void setStat(UUID uuid, long statID, double value) {
        // TODO: Set stat data in SQL
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
