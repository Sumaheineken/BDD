package com.heineken.HAT.runner;

/**
 * Created by mohana on 4/10/2019.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/MasterData"}, plugin = {
        "pretty", "html:target/reports/cucumber"}, glue = "com.heineken.HAT.stepDefinitions"
)
public class RunCucumber {
}