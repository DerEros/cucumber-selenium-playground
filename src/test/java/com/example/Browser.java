package com.example;

import io.cucumber.java.en.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.example.config.Configuration;

public class Browser {
    private final WebDriverCache webDriverCache;

    public Browser(WebDriverCache webDriverCache, Configuration config) {
        this.webDriverCache = webDriverCache;
        System.out.println(config.getBrowserConfig().getWebdriverExecutable());
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
