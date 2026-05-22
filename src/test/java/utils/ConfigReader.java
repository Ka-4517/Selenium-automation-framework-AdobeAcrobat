package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop = new Properties();

    static {
        try {
            InputStream configStream = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config/config.properties");

            InputStream testDataStream = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config/testdata.properties");

            // fallback if classpath fails
            if (configStream == null) {
                configStream = new FileInputStream(
                        System.getProperty("user.dir") + "/src/test/resources/config/config.properties"
                );
            }

            if (testDataStream == null) {
                testDataStream = new FileInputStream(
                        System.getProperty("user.dir") + "/src/test/resources/config/testdata.properties"
                );
            }

            prop.load(configStream);
            prop.load(testDataStream);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config files", e);
        }
    }

    public static String get(String key) {
        String value = prop.getProperty(key);

        if (value == null) {
            throw new RuntimeException("Key not found: " + key);
        }

        return value;
    }
}