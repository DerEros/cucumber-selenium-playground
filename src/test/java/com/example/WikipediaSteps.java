package com.example;

import io.cucumber.java.en.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.WebDriver;

public class WikipediaSteps {
    private WebDriverCache webDriverCache;
    private WebDriver driver;

    public WikipediaSteps(WebDriverCache webDriverCache) {
        this.webDriverCache = webDriverCache;
        this.driver = webDriverCache.get();
    }

    @When("navigating to {string}")
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    @Then("the page title is {string}")
    public void verifyTitle(String expectedTitle) {
        assertThat(driver.getTitle(), equalTo(expectedTitle));
    }
}
