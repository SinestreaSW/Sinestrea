package org.sinestrea.sinestrea;

import net.dv8tion.jda.api.JDABuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sinestrea.sinestrea.settings.Settings;
import org.sinestrea.sinestrea.settings.SettingsManager;

public class Sinestrea {
    private final static Logger LOGGER = LoggerFactory.getLogger("Sinestrea");

    public static void main(String[] args) {
        try {
            Settings settings = SettingsManager.getInstance().getSettings();
            JDABuilder jdaBuilder = JDABuilder.createDefault(settings.getBotToken());
            jdaBuilder.addEventListeners(new Listener());
            jdaBuilder.build();
        } catch (IllegalArgumentException e) {
            LOGGER.error("No login details provided! Please provide a 'BotToken' in the Config.json");
            System.exit(1);
        }
    }
}
