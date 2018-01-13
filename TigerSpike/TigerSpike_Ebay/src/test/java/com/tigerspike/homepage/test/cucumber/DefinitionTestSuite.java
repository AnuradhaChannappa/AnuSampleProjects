package com.tigerspike.homepage.test.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/EBay_HomePage/SearchAddItems.feature")
public class DefinitionTestSuite {}
