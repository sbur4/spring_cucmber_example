package com.epam.gym.bdd.steps;

import com.epam.gym.web.controller.ReportsController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ReportsControllerStep {
    @Autowired
    private ReportsController reportsController;
    @Autowired
    private MockMvc mockMvc;
    private ResultActions resultActions;

    @Given("the application is running")
    public void theApplicationIsRunning() {
        // Nothing to do here, the Spring context will start up
    }

    @When("I send a GET request with message {string}")
    public void iSendAGetRequestWithMessage(String txt) throws Exception {
        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/message/send/" + txt)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Then("the response should be {string}")
    public void theResponseShouldBe(String response) throws Exception {
        resultActions.andExpect(status().isOk())
                .andExpect(content().string(is(response)));
    }
}