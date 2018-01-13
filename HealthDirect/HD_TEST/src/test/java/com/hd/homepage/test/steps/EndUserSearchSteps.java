package com.hd.homepage.test.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.hd.homepage.test.library.ReadPropertiesFile;
import com.hd.homepage.test.library.Synchronize;
import com.hd.homepage.test.pages.HDObjectRepository;

import org.junit.Assert;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;

public class EndUserSearchSteps {

	public WebDriver driver = null;
	Properties properties = ReadPropertiesFile.getProperty();
	public HDObjectRepository hdObjectRepository;
	public static String optionSelected;

	@Step("I navigate to Health Direct home page")
	public void is_on_the_home_page(WebDriver driver) {

		driver.navigate().to(properties.getProperty("hdHomePageUrl"));
		this.driver = driver;
		hdObjectRepository = new HDObjectRepository(driver);

	}

	@Step("I enter search word")
	public void looks_for(String word) throws Throwable {
		hdObjectRepository.fillSearchTextBox(word);
	}

	@Step("I assert for valid search suggestion")
	public void should_see_suggestions_for(String suggestion) {

		ArrayList<String> actualOptionsListed = new ArrayList<>();
		List<WebElement> searchSuggestions = hdObjectRepository.getSearchResult();
		for (WebElement option : searchSuggestions) {
			actualOptionsListed.add(option.getText().trim());
		}
		try {
			assertThat("Search List for suggestion:",
					actualOptionsListed.stream().anyMatch(suggestion::equalsIgnoreCase));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("I assert for search text{0} to be bold")
	public void should_see_suggestions_for_bold(String suggestion) {

		ArrayList<String> actualOptionsListed = new ArrayList<>();
		List<WebElement> searchSuggestions = hdObjectRepository.getSearchResult();
		for (WebElement option : searchSuggestions) {
			actualOptionsListed.add(option.getText().trim());
			if (option.getText().trim().toLowerCase().contains(suggestion.toLowerCase())) {
				String boldExpected = option.findElement(By.tagName("strong")).getText();
				assertThat("Search word is bold:", !boldExpected.equals(null));
			}
		}
	}

	@Step("I assert for place holder text and tooltip")
	public void verify_placeholder_tooltip() {

		assertThat("place holder text:", properties.getProperty("placeHolder").trim()
				.equalsIgnoreCase(hdObjectRepository.searchTextBox().getAttribute("placeholder")));
		assertThat("Tool tip text:", properties.getProperty("toolTip").trim()
				.equalsIgnoreCase(hdObjectRepository.searchTextBox().getAttribute("title")));

	}

	@Step("I mouse hover the search field")
	public void mouse_hover_serach_field() throws Throwable {
		
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		Action mouseOverSearch = actions.moveToElement(hdObjectRepository.searchTextBox()).build();
		mouseOverSearch.perform();		
		Thread.sleep(3000);
		
	}

	@Step("I assert no suggestions found for invalid search")
	public void should_not_see_suggestions() {
		
		List<WebElement> searchSuggestions = hdObjectRepository.getSearchResult();
		assertThat("Search list for invalid search:", searchSuggestions.isEmpty());

	}

	@Step("I select an option {0}")
	public void click_on_option(String optiontoSelect) {

		List<WebElement> searchSuggestions = hdObjectRepository.getSearchResult();
		Synchronize.WebDriverWaitToBeVisible(driver, searchSuggestions);
		for (WebElement option : searchSuggestions) {
			
			if (option.getText().trim().equalsIgnoreCase(optiontoSelect.trim())) {
				option.click();
				optionSelected = optiontoSelect;
				return;
			}
		}
	}

	@Step("I verify serach result page title")
	public void verify_serach_result_page() {

		String expectedHeading = "Search results for: \"" + optionSelected + "\"";
		Assert.assertEquals(expectedHeading, hdObjectRepository.getSearchResultHeading().getText());
	}
}
