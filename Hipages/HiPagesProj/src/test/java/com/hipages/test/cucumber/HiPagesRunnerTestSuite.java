package com.hipages.test.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/com/hipages/feature/",tags ={"~@ignore"})


public class HiPagesRunnerTestSuite {

}
