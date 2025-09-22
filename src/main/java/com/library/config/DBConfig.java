package com.library.config;

import java.io.InputStream;
import java.util.Properties;

public class DBConfig {

    private static Properties props = new Properties();

    static {
        try (InputStream in = DBConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in != null) {
                props.load(in);
            } else {
                System.err.println("config.properties not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return props.getProperty("db.url");
    }

    public static String getUsername() {
        return props.getProperty("db.username");
    }

    public static String getPassword() {
        return props.getProperty("db.password");
    }
}
