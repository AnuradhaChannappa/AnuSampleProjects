package com.hipages.test.library;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	public static void doClick(Actions actions, WebElement clickObject) {
		Utils.doWait(2000);
		if (isCurrentRunEnv("Chrome")) {
			System.out.println("Clicking for chrome");
			actions.click(clickObject).build().perform();
		} else {
			clickObject.click();
		}
	}

	public static void doMouseHover(Actions actions, WebElement element) {
		Utils.doWait(2000);
		if (isCurrentRunEnv("Chrome")) {

			actions.moveToElement(element).build().perform();
		} else {
			actions.moveToElement(element);
		}
	}

	public static boolean isCurrentRunEnv(String browserName) {
		return StringUtils.containsIgnoreCase(System.getProperty("Browser"), browserName);
	}
public static void handleChromeAlert(WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver,5);
	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	alert.accept();
	
}
	public static boolean isDisplayed(WebElement element) {

		return element.isDisplayed();
	}
	
	

	public static void navigateBack(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("history.go(-1)");
	}

	public static void doWait(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
