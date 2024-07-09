package com.epam.gym.bdd.config;

import com.epam.gym.web.DemoApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@AutoConfigureMockMvc
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {DemoApplication.class, CucumberIntegrationTestRunner.class})
public class SpringIntegrationTest {
}