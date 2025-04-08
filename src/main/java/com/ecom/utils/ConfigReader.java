package com.ecom.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();
    private static final String CONFIG_PATH = "src/main/resources/config/config.properties";

    static {
        try {
            FileInputStream input = new FileInputStream(CONFIG_PATH);
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
} 