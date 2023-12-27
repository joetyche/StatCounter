package io.github.joetyche.util;

import org.bukkit.configuration.file.FileConfiguration;
import io.github.joetyche.StatCounter;
import io.github.joetyche.playerdata.storage.database.SqlLogin;

public class StatCounterConfig {

    private FileConfiguration getConfig() {
        return plugin.getConfig();
    }

    private StatCounter plugin;
    private final String DB_CONFIG_PATH = "Database.";

    public StatCounterConfig(StatCounter plugin) {
        this.plugin = plugin;
    }

    public int getDefaultStatValue() {
        return getConfig().getInt("Default stat value", 0);
    }

    public String getDbString(String key) {
        return getConfig().getString(DB_CONFIG_PATH + key);
    }

}
