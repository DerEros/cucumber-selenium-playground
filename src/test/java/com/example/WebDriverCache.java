package com.example;

import org.openqa.selenium.WebDriver;

public class WebDriverCache {
    private static WebDriver driver;

    public WebDriverCache() {}

    public void set(WebDriver driver) {
        if (this.driver == null) {
            this.driver = driver;
        }
    }

    public void setOrUpdate(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver get() { 
        return this.driver;
    }
}
