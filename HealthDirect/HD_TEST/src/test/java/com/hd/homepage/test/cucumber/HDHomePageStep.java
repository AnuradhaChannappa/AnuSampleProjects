package com.hd.homepage.test.cucumber;

import org.openqa.selenium.WebDriver;

import com.hd.homepage.test.library.GetDriver;
import com.hd.homepage.test.steps.EndUserSearchSteps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class HDHomePageStep {
	
	private String browserName;
	private WebDriver driver;
	
	 @Steps EndUserSearchSteps endUserSearchSteps ;
	 
	 
	 @Before
	 public void doBefore() {
		 
		 browserName = System.getProperty("Browser");
		 if(!browserName.equals(null)) {
			 driver = GetDriver.GetBrowser(browserName);
		 }
	 }

	    @Given("the user is on the Health Direct home page")
	    public void givenTheUserIsOnTheHealthDirectHomePage() {
	        endUserSearchSteps.is_on_the_home_page(driver);
	    }
	    
	    @When("the user looks up the suggestion for '(.*)'")
	    public void whenTheUserLooksUpTheSuggestionOf(String word) throws Throwable {
	        endUserSearchSteps.looks_for(word);
	    }
	    
	    @When("the user mouse over the search field")
	    public void whenTheUserMouseOverSearchField() throws Throwable {
	    	endUserSearchSteps.mouse_hover_serach_field();
	    }

	    @Then("they should see the suggestion '(.*)'")
	    public void thenTheyShouldSeeASuggestionContainingTheWord(String suggestion) {
	        endUserSearchSteps.should_see_suggestions_for(suggestion);
	    }
	    
	    @When("they see the suggestion '(.*)'")
	    public void whenTheySeeASuggestionContainingTheWord(String suggestion) {
	        endUserSearchSteps.should_see_suggestions_for(suggestion);
	    }
	    
	    @When("they click on '(.*)' option")
	    public void whenTheyClickOnOption(String option) throws Throwable {
	        endUserSearchSteps.click_on_option(option);
	    }
	    
	    
	    @Then("they should not see any suggestions")
	    public void thenTheyShouldNotSeeASuggestions() {
	        endUserSearchSteps.should_not_see_suggestions();
	    }	
	    
	    
	    @Then("verify placeholder and tooltip")
	    public void thenVerifyPlaceholderAndTooltip() {
	    	endUserSearchSteps.verify_placeholder_tooltip();
	    }	
	    @Then("they should see the suggestions with '(.*)' as bold")
	    public void thenTheyShouldSeeASuggestionContainingTheWordBold(String suggestion) {
	        endUserSearchSteps.should_see_suggestions_for_bold(suggestion);
	    }
	    
	    @Then("verify the search result page")
	    public void thenVerifySearchResultPage() {
	        endUserSearchSteps.verify_serach_result_page();
	    }

	 @After
	 public void tearDown() {
		//driver.close(); 
		 
	 }
	
}