package io.github.joetyche.playerdata;

import java.util.UUID;

public interface IPlayerStatController {

    public void setStat(UUID uuid, long statID, double value);

    public double getStat(UUID uuid, long statID, double defaultValue);

    public double getStat(UUID uuid, long statID);

}
