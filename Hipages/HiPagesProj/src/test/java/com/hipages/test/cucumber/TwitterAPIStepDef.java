package com.hipages.test.cucumber;

import java.util.Properties;

import com.hipages.test.library.ReadPropertiesFile;
import com.hipages.test.steps.TwitterAPISteps;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.thucydides.core.annotations.Steps;

public class TwitterAPIStepDef {

	public Scenario currentScenario;
	private Properties prop;

	@Steps
	TwitterAPISteps twitterSteps;

	@Before
	public void doBefore(Scenario scenario) {

		currentScenario = scenario;
		prop = ReadPropertiesFile.getProperty();
		RestAssured.baseURI = prop.getProperty("twitterBaseUri");

	}

	@When("^I send a GET request to the twitter endpoint,then I must get back a valid status code \"(.*?)\"$")
	public void verify_status_code_200_for_searchpoint(int statusCode) {

		twitterSteps.setValues(currentScenario, prop);
		twitterSteps.verifyStatusCode(statusCode);
	}

	@When("^I search for (.*) tweets containing (.*)$")
	public void search_for_tweets_containing(int noOfTweets, String tweetsHaving) {
		twitterSteps.searchForTweetsWith(noOfTweets, tweetsHaving);
	}

	@Then("^I verify that the tweets are listed$")
	public void verify_tweets_listed() {
		twitterSteps.verifyTweetsListed();
	}

}
