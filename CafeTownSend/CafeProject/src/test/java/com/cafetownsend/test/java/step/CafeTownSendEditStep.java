package com.cafetownsend.test.java.step;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.Step;

public class CafeTownSendEditStep {
	private CafeTownSendCommonStep cafeTownSendCommonStep;
	private static WebDriver driver;

	public void setCafeTownSendCommonStep(CafeTownSendCommonStep cafeTownSendCommonStep, WebDriver driver) {
		this.cafeTownSendCommonStep = cafeTownSendCommonStep;
		CafeTownSendEditStep.driver = driver;
	}

	@Step("I verify displayed employee details")
	public void iVerifyDisplayedEmployee(String empName) {
		cafeTownSendCommonStep.init_PageFactory(driver);
		
		for (WebElement ele : cafeTownSendCommonStep.cafeTownSendPageFactory.employeeDetails
				.findElements(By.tagName("label"))) {
			String []expectedName = empName.split("\\s");
			if (ele.findElement(By.tagName("span")).getText().equalsIgnoreCase("First Name")) {
				String actualFirstName = ele.findElement(By.tagName("input")).getText();				
				Assert.assertTrue("First Name matches", expectedName[0].equals(actualFirstName));
				break;
			}
			if (ele.findElement(By.tagName("span")).getText().equalsIgnoreCase("Second Name")) {
				String actualSecondName = ele.findElement(By.tagName("input")).getText();				
				Assert.assertTrue("Second Name matches", expectedName[1].equals(actualSecondName));
				break;
		}					
		}
	}
@Step("I {0} from Edit page")
	public void iClickButton(String button) {
		cafeTownSendCommonStep.init_PageFactory(driver);
		CafeTownSendCommonStep.buttonClicked="delete";
		cafeTownSendCommonStep.cafeTownSendPageFactory.addUpdateDeleteButtons.findElement(By.tagName("p")).click();	
	}
}
