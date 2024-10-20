package org.sinestrea.sinestrea.settings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SettingsManager {
    private static SettingsManager instance;
    private Settings settings;

    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final Path CONFIG_FILE = new File(".").toPath().resolve("Config.json");
    private final static Logger LOGGER = LoggerFactory.getLogger("SettingsManager");

    public SettingsManager()
    {
        if (!CONFIG_FILE.toFile().exists()) {
            LOGGER.error("Config.json not found");
            System.exit(1);
        }

        try {
            BufferedReader reader = Files.newBufferedReader(CONFIG_FILE, StandardCharsets.UTF_8);
            this.settings = GSON.fromJson(reader, Settings.class);
            reader.close();
            LOGGER.info("Settings loaded");
        } catch (IOException e) {
            LOGGER.info("Failed loading settings");
            e.printStackTrace();
        }
    }

    public static SettingsManager getInstance()
    {
        if (instance == null) {
            instance = new SettingsManager();
        }
        return instance;
    }

    public Settings getSettings()
    {
        return settings;
    }
}
