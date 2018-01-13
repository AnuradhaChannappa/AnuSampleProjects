package com.cafetownsend.test.java.cucumber;




import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/com/cafetownsend/test/cuke/feature/CafeTownSendLoginTest.feature")
public class DefinitionTestSuite {

}
