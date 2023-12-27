package io.github.joetyche.playerdata.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;

/**
 * This class provides a HashMap of UUIDs against statMaps (a map of stat IDs to values). It's
 * purpose is to reduce SQL queries by caching results.
 */
public abstract class PlayerStatCache implements IPlayerStatStorage {

    private final HashMap<UUID, Map<Long, Double>> playerStatMap;


    public PlayerStatCache() {
        playerStatMap = new HashMap<>();
    }


    @Override
    public void setStat(UUID uuid, long statID, double value) {
        // If player is not in playerStatMap, create empty HashMap for them now and store it
        if (playerStatMap.containsKey(uuid)) {
            playerStatMap.put(uuid, new HashMap<>());
        }

        // Get player's map
        Map<Long, Double> statMap = playerStatMap.get(uuid);
        if (statMap == null) {
            // Warn if still not found
            Bukkit.getLogger()
                    .warning("MapPlayerStatController tried to set " + statID + " to " + value
                            + " for " + uuid
                            + ", but could not find the player's statMap in the playerStatMap");
            return;
        }

        // Update player's stats
        statMap.put(statID, value);
    }

    @Override
    public double getStat(UUID uuid, long statID, double defaultValue) {
        Map<Long, Double> statMap = playerStatMap.get(uuid);
        if (statMap != null) {
            if (statMap.containsKey(statID)) {
                // If key is present, return the value
                return statMap.get(statID);
            }
        }
        // If the player is not stored in the map or the key is not present
        // return the default value
        return defaultValue;
    }

    public boolean playerHasStatLoaded(UUID uuid, long statID) {
        return playerStatMap.containsKey(uuid) ? playerStatMap.get(uuid).containsKey(statID)
                : false;
    }

}
