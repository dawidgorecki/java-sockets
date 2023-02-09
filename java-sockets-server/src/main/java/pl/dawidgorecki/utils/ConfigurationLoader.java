package pl.dawidgorecki.utils;

import pl.dawidgorecki.App;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationLoader {
    private static final String CONFIG_FILENAME = "config.properties";

    private ConfigurationLoader() {
    }

    public static Properties loadProperties() {
        Properties config = new Properties();

        try (InputStream input = App.class.getClassLoader().getResourceAsStream(CONFIG_FILENAME)) {
            if (input == null) {
                throw new RuntimeException("Unable to find " + CONFIG_FILENAME);
            }

            config.load(input);
            return config;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
