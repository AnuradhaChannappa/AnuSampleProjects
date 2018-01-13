package com.hipages.test.cucumber;

import org.openqa.selenium.WebDriver;
import com.hipages.test.library.GetDriver;
import com.hipages.test.steps.GoogleEndUserSteps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GoogleStepDef {

	private String browserName;
	private WebDriver driver = null;

	@Steps
	GoogleEndUserSteps googleEndUserSteps;

	@Before
	public void doBefore() {

		browserName = System.getProperty("Browser");
		if (!browserName.equals(null)) {
			driver = GetDriver.set(browserName);
			System.out.println("driver:" + driver);
		}
	}

	@Given("^the user is on Google search page$")
	public void givenTheUserIsOnTheGoogletHomePage() throws Throwable {
		googleEndUserSteps.is_on_the_home_page(driver);
	}

	@When("^the user enters text \"(.*?)\"$")
	public void whenTheUserSearchForText(String word) throws Throwable {
		googleEndUserSteps.looks_for(word);
	}

	@Then("^verify the search result$")
	public void verifySearchResults() throws Throwable {

		googleEndUserSteps.verify_search_results();
	}

	@When("^the user clicks on voice search$")
	public void clickOnVoiceSearch() throws Throwable {
		googleEndUserSteps.clickVoiceSearch(driver);
	}

	@When("^the user mouse over voice search$")
	public void mouseOverVoiceSearch() throws Throwable {
		googleEndUserSteps.verifyMouseOverText(driver);
	}

	@Then("^Verify the mouse over text$")
	public void verifyPlaceHolder() throws Throwable {
		googleEndUserSteps.verifyMouseOverText(driver);
	}

	@Then("^verify google search buttons$")
	public void verifyGoogleSearchButtons() throws Throwable {
		googleEndUserSteps.verifyGoogleSearchButtons(driver);
	}

	@Then("^verify google header buttons$")
	public void verifyHeader() throws Throwable {
		googleEndUserSteps.verifyGoogleHearder(driver);
	}

	@After
	public void tearDown() {
		GetDriver.close();
	}
	
}
