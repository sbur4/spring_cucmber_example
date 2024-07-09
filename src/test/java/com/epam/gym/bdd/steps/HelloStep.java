package com.epam.gym.bdd.steps;

import com.epam.gym.web.service.IsItFriday;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloStep {
    private String today;
    private String actualAnswer;

    @Given("today is {string}")
    public void todayIs(String today) {
        this.today = today;
    }

    @When("I ask whether it's Friday yet")
    public void iAskWhetherItSFridayYet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void iShouldBeTold(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}
