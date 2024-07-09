package com.epam.gym.bdd.steps;

import com.epam.gym.web.dto.SimpleDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SendDtoControllerStep {
    @Autowired
    private MockMvc mockMvc;
    private MvcResult result;
    private SimpleDto sentDto;
    private final ObjectMapper objectMapper = new ObjectMapper();

//    @Given("the application is running")
//    public void theApplicationIsRunning() {
//        // Nothing to do here, the Spring context will start up
//    }

    @When("I send a POST request with the following DTO")
    public void sendPostRequestWithDto(DataTable dataTable) throws Exception {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        List<String> languages = dataTable.cells().get(1).subList(2, dataTable.cells().get(0).size());//
        SimpleDto simpleDto = SimpleDto.builder()
                .name(dataTable.cell(1, 0))
                .age(Long.parseLong(dataTable.cell(1, 1)))
                .lang(languages)
                .build();
        String jsonDto = objectMapper.writeValueAsString(simpleDto);
        result = mockMvc.perform(get("/message/send/dto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonDto))
                .andExpect(status().isOk())
                .andReturn();
        sentDto = simpleDto;
    }

    @Then("the response should have the following DTO")
    public void checkResponseDto(DataTable dataTable) throws Exception {
        List<String> expectedLang = dataTable.cells().get(1).subList(2, dataTable.cells().get(0).size());
        SimpleDto expectedSimpleDto = SimpleDto.builder()
                .name(dataTable.cell(1, 0))
                .age(Long.valueOf(dataTable.cell(1, 1)))
                .lang(expectedLang)
                .build();
        String content = result.getResponse().getContentAsString();
        SimpleDto responseDto = objectMapper.readValue(content, SimpleDto.class);
        assertEquals(expectedSimpleDto, responseDto);
    }
}
