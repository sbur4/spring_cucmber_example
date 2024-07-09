package com.epam.gym.bdd.config;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("resources/features")  // or  @SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value = "src/test/resources/features") // or  @ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value = "src.test.resources.features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.epam.gym.bdd.steps") // or @ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com/epam/gym/bdd/steps")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@SmokeTest") // todo check
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report/cucumber.html")
public class CucumberIntegrationTestRunner {
}