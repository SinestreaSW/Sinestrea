package org.sinestrea.sinestrea;

import net.dv8tion.jda.api.JDABuilder;

public class Sinestrea {
    public static void main(String[] args) {
        try {
            Settings settings = SettingsManager.getInstance().getSettings();
            JDABuilder jdaBuilder = JDABuilder.createDefault(settings.getBotToken());
            jdaBuilder.addEventListeners(new Listener());
            jdaBuilder.build();
        } catch (IllegalArgumentException e) {
            System.out.println("[Sinestrea] : No login details provided! Please provide a 'BotToken' in the Config.json");
            System.exit(1);
        }
    }
}
