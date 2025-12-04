package org.example.javafxandjdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public  class ConfigLoader {
    private Properties props = new Properties();

    public ConfigLoader() {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return props.getProperty("db.username");
    }

    public String getPassword() {
        return props.getProperty("db.password");
    }
}
