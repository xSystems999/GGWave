package me.logicologist.ggwave.utils;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Config {

    private static Config instance;
    private final Plugin plugin;
    private String ggWaveStart;
    private String ggWaveEnd;

    public Config(Plugin plugin) {
        this.plugin = plugin;
        instance = this;
    }

    public Config setup() {
        this.plugin.saveDefaultConfig();
        return this;
    }

    public Config load() {
        Utils.log("Loading config settings...");
        FileConfiguration cfg = getConfig();
        this.ggWaveStart = cfg.getString("messages.start");
        this.ggWaveEnd = cfg.getString("messages.end");
        Utils.log("Successfully loaded config settings!");
        return this;
    }

    public FileConfiguration getConfig() {
        return this.plugin.getConfig();
    }

    public static Config getInstance() {
        return instance;
    }

    public String getGGWaveStart() {
        return this.ggWaveStart;
    }

    public String getGgWaveEnd() {
        return this.ggWaveEnd;
    }
}
