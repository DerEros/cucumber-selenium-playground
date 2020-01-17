package com.example;

import io.cucumber.java.en.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.WebDriver;

public class WikipediaSteps {
    private final BrowserWindowCache browserWindowCache;
    private WebDriver window;

    public WikipediaSteps(BrowserWindowCache browserWindowCache) {
        this.browserWindowCache = browserWindowCache;
        this.window = browserWindowCache.getActiveWindow();
    }

    @When("navigating to {string}")
    public void navigateTo(String url) {
        window.get(url);
    }
    
    @Then("the page title is {string}")
    public void verifyTitle(String expectedTitle) {
        assertThat(window.getTitle(), equalTo(expectedTitle));
    }
}
