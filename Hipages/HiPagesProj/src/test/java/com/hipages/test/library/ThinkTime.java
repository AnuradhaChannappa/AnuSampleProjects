package com.hipages.test.library;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Function;

public class ThinkTime {

	public void fluentWaitToBeVisible(WebDriver driver, final WebElement element) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver driver) {
				if (element.isDisplayed()) {
					return true;
				}
				return false;
			}

		};
		wait.until(function);

	}

	public void WebDriverWaitToBeVisible(WebDriver driver, List<WebElement> listElement) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listElement));

	}

	public void WebDriverWaitToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
