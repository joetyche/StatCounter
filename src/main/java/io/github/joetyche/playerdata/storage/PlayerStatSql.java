package io.github.joetyche.playerdata.storage;

import java.util.UUID;

/**
 * This class handles the uploading and downloading of player's data to and from the SQL database,
 * whilst also updating the map cache.
 */
public class PlayerStatSql implements IPlayerStatStorage {

    @Override
    public void setStat(UUID uuid, long statID, double value) {
        // TODO: Set stat data in SQL
    }

    @Override
    public double getStat(UUID uuid, long statID, double defaultValue) {
        // TODO: Retrieve stat data from SQL
        return 0;
    }
}
