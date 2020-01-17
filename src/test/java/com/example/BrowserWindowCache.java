package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.config.ConfigCache;
import com.example.config.Configuration;

public class BrowserWindowCache {
    private final Configuration config;

    private static Map<String, List<WebDriver>> windowsByUser = null;
    private WebDriver activeWindow = null;

    public BrowserWindowCache(ConfigCache configCache) {
        this.config = configCache.get();

        if (this.windowsByUser == null) {
            this.windowsByUser = new HashMap<>();
        }
    }

    public WebDriver getWindowFor(String username) {
        return this.getWindowFor(username, 0);
    }

    public WebDriver getWindowFor(String username, int windowIndex) {
        List<WebDriver> windowList = this.windowsByUser.computeIfAbsent(username, u -> new ArrayList<>());

        if (windowList.isEmpty()) {
            windowList.add(createNewWindowFor(username));
        }

        if (windowIndex > windowList.size()) {
            throw new RuntimeException(String.format("Trying to access tab %d for user '%s' but only %d tabs are present", windowIndex, username, windowList.size()));
        }

        return windowList.get(windowIndex);
    }

    public WebDriver createNewWindowFor(String username) {
        System.setProperty("webdriver.chrome.driver", config.getBrowser().getWebdriverExecutable());

        ChromeOptions opt = new ChromeOptions();
        opt.setBinary("/usr/bin/chromium");

        return new ChromeDriver(opt);
    }

    public WebDriver getActiveWindow() {
        return this.activeWindow;
    }

    public void setActiveWindow(String username) {
        this.setActiveWindow(username, 0);
    }

    public void setActiveWindow(String username, int windowIndex) {
        this.activeWindow = this.getWindowFor(username, windowIndex);
    }

    public void setActiveWindow(WebDriver window) {
        this.activeWindow = window;
    }
}
