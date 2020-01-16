package com.example.config;

import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.Config;

import com.example.config.Configuration;

public class ConfigCache {
    private static Configuration config;

    public ConfigCache() {
        if (config == null) {
            config = loadConfig();
        }
    }

    private Configuration loadConfig() {
        Config c = ConfigFactory.load();
        return ConfigBeanFactory.create(c, Configuration.class);
    }

    public Configuration get() { return this.config; }
}
