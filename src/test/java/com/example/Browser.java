package com.example;

import io.cucumber.java.en.*;

import com.example.config.ConfigCache;
import com.example.BrowserWindowCache;

public class Browser {
    private final BrowserWindowCache browserWindowCache;
    private final ConfigCache configCache;

    public Browser(BrowserWindowCache browserWindowCache, 
            ConfigCache configCache) {
        this.browserWindowCache = browserWindowCache;
        this.configCache = configCache;
    }

    @Given("a browser window") 
    public void openBrowser() {
        browserWindowCache.setActiveWindow("foouser");
    }

    @Given("any number of browser windows")
    public void anyNumberOfWindows() {}

    @When("closing all browser windows")
    public void closeBrowserWindows() {
        BrowserWindowCache.closeAll();
    }

    @Then("{int} browser windows remain open")
    public void checkOpenWindows(int number) {
        //TODO: implement
    }
}
