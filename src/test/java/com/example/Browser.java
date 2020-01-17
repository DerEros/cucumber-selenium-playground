package com.example;

import io.cucumber.java.en.*;

import com.example.config.ConfigCache;
import com.example.config.Configuration;
import com.example.BrowserWindowCache;

public class Browser {
    private final BrowserWindowCache browserWindowCache;
    private final Configuration config;

    public Browser(BrowserWindowCache browserWindowCache, ConfigCache configCache) {
        this.browserWindowCache = browserWindowCache;
        this.config = configCache.get();
    }

    @Given("a browser window") 
    public void openBrowser() {
        browserWindowCache.setActiveWindow("foouser");
    }
}
