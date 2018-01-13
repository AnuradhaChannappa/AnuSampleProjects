package com.hipages.test.steps;

import cucumber.api.Scenario;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class TwitterAPISteps {

	@Steps
	TwitterAPISteps twitterSteps;

	private Scenario currentScenario;
	private Properties prop;
	private static String consumerKey = " ";
	private static String consumerSecret = " ";
	private static String token = " ";
	private static String tokenSecret = " ";
	private static String resource = "";

	@Step("Verify the status code {0}")
	public void verifyStatusCode(int statusCode) {

		consumerKey = prop.getProperty("consumerKey");
		consumerSecret = prop.getProperty("consumerSecret");
		token = prop.getProperty("token");
		tokenSecret = prop.getProperty("tokenSecret");

		if (currentScenario.getName().contains("search")) {
			resource = "search/tweets.json?q=test if the search endpoint works";
		} else if (currentScenario.getName().contains("timeline")) {
			resource = "statuses/home_timeline.json";
		}

		SerenityRest.rest().given().auth().oauth(consumerKey, consumerSecret, token, tokenSecret).when().get(resource)
				.then().statusCode(statusCode);
	}

	public void setValues(Scenario currentScenario, Properties prop) {

		this.currentScenario = currentScenario;
		this.prop = prop;

	}

	@Step("Serach for {0} latest tweets having {1}")
	public void searchForTweetsWith(int noOfTweets, String tweetsHaving) {

		if (StringUtils.contains(tweetsHaving, "hipages")) {
			resource = "search/tweets.json?q=hipages";
			System.out.println("hipages resource:" + resource);
		} else if (StringUtils.contains(tweetsHaving, "@hipages")) {
			resource = "search/tweets.json?q=%40hipages";
			System.out.println("@hipages resource:" + resource);
		} else if (StringUtils.contains(tweetsHaving, "#hipages")) {
			resource = "search/tweets.json?q=%23hipages";
			System.out.println("#hipages resource:" + resource);
		}

		SerenityRest.rest().given().auth().oauth(consumerKey, consumerSecret, token, tokenSecret)
				.queryParam("count", noOfTweets).when().get(resource);
	}

	@Step("I verify the tweets listed")
	public void verifyTweetsListed() {

		SerenityRest.then().assertThat().statusCode(200);

	}

}
