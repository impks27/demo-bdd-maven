package com.example.demobddmaven;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources/features/bag.feature", plugin = {"pretty", "html:target/cucumber"})
@CucumberOptions(features = "src/test/resources/features/bag.feature", plugin = {"pretty", "html:target/cucumber", "json:target/surefire-reports/cucumber.json"})
public class DemoBddMavenIntegrationTests {

}
