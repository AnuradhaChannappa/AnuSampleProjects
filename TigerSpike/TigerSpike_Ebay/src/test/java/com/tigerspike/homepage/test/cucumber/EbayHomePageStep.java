package com.tigerspike.homepage.test.cucumber;

import org.openqa.selenium.WebDriver;

import com.tigerspike.homepage.test.steps.EndUserSearchSteps;
import com.tigerspike.homepage.test.library.GetDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class EbayHomePageStep {
	
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

	    @Given("^the user is on the Ebay home page$")
	    public void givenTheUserIsOnTheHealthDirectHomePage() {
	    endUserSearchSteps.is_on_the_home_page(driver);
	    }
	    
	    @When("^the user selects category '(.*)'$")
	    public void whenTheUserShopByCategory(String category) throws Throwable {
	       endUserSearchSteps.selectCategory(category);
	    }
	    
	    @When("the user shop by sub category '(.*)'$")
	    public void whenTheUserSelectsSubCategory(String subCategory) throws Throwable {
	    	endUserSearchSteps.select_sub_category(subCategory);
	    }
	    
	    @When("the user selects brand and items")
	    public void whenTheUserSelectsBrandIems() throws Throwable {
	    		endUserSearchSteps.select_brand_items();
	    }
	    

	 @After
	 public void tearDown() {
		//driver.close(); 
		 
	 }
	
}