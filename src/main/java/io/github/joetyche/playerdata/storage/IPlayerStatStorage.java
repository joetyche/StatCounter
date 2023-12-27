package io.github.joetyche.playerdata.storage;

import java.util.UUID;

/**
 * Interface to be implemented by classes which manage the storage of player stat data
 */
public interface IPlayerStatStorage {

    public void setStat(UUID uuid, long statID, double value);

    public double getStat(UUID uuid, long statID, double defaultValue);

}
