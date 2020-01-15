package com.example;

import io.cucumber.java.en.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    private final WebDriverCache webDriverCache;

    public Browser(WebDriverCache webDriverCache) {
        this.webDriverCache = webDriverCache;
    }

    @Given("a browser window") 
    public void openBrowser() {
        if (webDriverCache.get() == null) {
            System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");

            ChromeOptions opt = new ChromeOptions();
            opt.setBinary("/usr/bin/chromium");

            WebDriver driver = new ChromeDriver(opt);
            webDriverCache.set(driver);
        }
    }
}
