package io.github.joetyche.util;

import org.bukkit.configuration.file.FileConfiguration;
import io.github.joetyche.StatCounter;

public class StatCounterConfig {

    private FileConfiguration getConfig() {
        return plugin.getConfig();
    }

    private StatCounter plugin;

    public StatCounterConfig(StatCounter plugin) {
        this.plugin = plugin;
    }

    public int getDefaultStatValue() {
        return getConfig().getInt("Default stat value", 0);
    }

}
