package com.hipages.test.steps;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.hipages.test.library.ReadPropertiesFile;
import com.hipages.test.library.ThinkTime;
import com.hipages.test.library.Utils;
import com.hipages.test.pagefactory.GoogleObjectRepository;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import net.thucydides.core.annotations.Step;

public class GoogleEndUserSteps {

	private ThinkTime thinkTime = new ThinkTime();
	private WebDriver driver = null;
	private Actions actions;
	Properties properties = ReadPropertiesFile.getProperty();

	public GoogleObjectRepository googleObjectRepository;

	@Step("I navigate to Google home page")
	public void is_on_the_home_page(WebDriver driver) {

		this.driver = driver;
		this.actions = new Actions(driver);
		driver.navigate().to(properties.getProperty("googleHomePageUrl"));
		googleObjectRepository = PageFactory.initElements(driver, GoogleObjectRepository.class);
	}

	@Step("I enter search word {0}")
	public void looks_for(String word) throws Throwable {

		assertTrue(Utils.isDisplayed(googleObjectRepository.searchField));
		assertTrue(googleObjectRepository.searchField.isEnabled());
		googleObjectRepository.searchField.sendKeys(word);
	}

	@Step("Verify that search results are displayed")
	public void verify_search_results() {

		assertTrue(!(googleObjectRepository.googleSearchResult.size() == 0));
	}

	@Step("Click on voice search button")
	public void clickVoiceSearch(WebDriver driver) {

		Utils.doWait(5000);
		googleObjectRepository.searchByVoice.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("alert : " + alert.getText());
		alert.accept();
		Utils.doWait(3000);

	}

	@Step("mouseover voice serach button")
	public void mouseOverVoiceText(WebDriver driver) throws Throwable {

		Thread.sleep(5000);
		Action mouseOverSearch = actions.moveToElement(googleObjectRepository.searchByVoice).build();
		mouseOverSearch.perform();
		Thread.sleep(3000);

	}

	@Step("verify mouse over text")
	public void verifyMouseOverText(WebDriver driver) {

		assertThat(googleObjectRepository.moseOverText.getAttribute("aria-label"), is(equalTo("Search by voice")));
		StringUtils.equalsIgnoreCase(googleObjectRepository.moseOverText.getAttribute("aria-label"), "Search by voice");

	}

	@Step("Verify Google search buttons label and navigation")
	public void verifyGoogleSearchButtons(WebDriver driver) {

		assertThat(googleObjectRepository.googleSearchButton.getAttribute("aria-label"), is(equalTo("Google Search")));

		assertThat(googleObjectRepository.googleFeelingLuckyButton.getAttribute("aria-label"),
				is(equalTo("I'm Feeling Lucky")));
		Utils.doClick(actions, googleObjectRepository.googleFeelingLuckyButton);
		String targetIamFeelingLuckyUrl = "https://www.google.com/doodles";
		assertThat(driver.getCurrentUrl(), is(equalTo(targetIamFeelingLuckyUrl)));
		driver.navigate().back();

	}

	@Step("Verify the header links by clicking")
	public void verifyGoogleHearder(WebDriver driver) {

		Map<String, String> expectedHeaderLinks = new HashMap<String, String>();
		expectedHeaderLinks.put("Gmail", "ServiceLogin");
		expectedHeaderLinks.put("Images", "img");
		expectedHeaderLinks.put("Google apps", "www.google.com");
		expectedHeaderLinks.put("More", "www.google.com");
		expectedHeaderLinks.put("Even more from Google", "www.google.com");
		expectedHeaderLinks.put("Sign in", "ServiceLogin");

		List<WebElement> actualHeaderLinks = googleObjectRepository.headerLinks;
		verifyLabelsAndUrls(expectedHeaderLinks, actualHeaderLinks);

	}

	@Step("Assert on labels and the target links")
	public void verifyLabelsAndUrls(Map<String, String> expectedHeaderLinks, List<WebElement> actualHeaderLinks) {
		for (int i = 0; i < actualHeaderLinks.size();) {

			String actualLabel = "";
			if (i == 2) {
				actualLabel = actualHeaderLinks.get(i).getAttribute("title");
			} else {
				actualLabel = actualHeaderLinks.get(i).getText();
			}

			assertTrue(expectedHeaderLinks.get(actualLabel) != null);
			Utils.doWait(2000);
			WebElement headerLink = actualHeaderLinks.get(i);
			thinkTime.WebDriverWaitToBeClickable(driver, headerLink);
			Utils.doClick(actions, headerLink);
			String currentUrl = driver.getCurrentUrl();
			Utils.doWait(2000);
			assertTrue(currentUrl.contains(expectedHeaderLinks.get(actualLabel)));
			if (i == 0 || i == 1 || i == 5) {
				driver.navigate().back();
			}
			i++;
		}
	}
}
