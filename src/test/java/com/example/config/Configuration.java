package com.example.config;

import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.Config;

import com.example.config.BrowserConfig;

public class Configuration {
    private static boolean configInitialized;

    private BrowserConfig browserConfig;

    public Configuration() {
        if (!configInitialized) {
            this.loadConfig();
        }
    }

    public void loadConfig() {
       Config c = ConfigFactory.load(); 
       browserConfig = ConfigBeanFactory.create(c.getConfig("browser"), BrowserConfig.class);
    }

    public BrowserConfig getBrowserConfig() { return this.browserConfig; }
}
