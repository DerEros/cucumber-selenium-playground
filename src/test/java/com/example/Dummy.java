package com.example;

import io.cucumber.java.en.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Dummy {
    int num = 0;

    @Given("a dummy test")
    public void initTest() {
        num = 0;
    }

    @When("number is {int}")
    public void numberGiven(int n) {
        num = n;
    }

    @Then("number is stored as {int}")
    public void numberStored(int n) {
        assertThat(num, equalTo(n));
    }
}
