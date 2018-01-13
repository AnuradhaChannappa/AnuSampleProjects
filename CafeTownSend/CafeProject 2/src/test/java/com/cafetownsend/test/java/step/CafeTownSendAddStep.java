package com.cafetownsend.test.java.step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class CafeTownSendAddStep {

	private CafeTownSendCommonStep cafeTownSendCommonStep;
	private static WebDriver driver;

	public void setCafeTownSendCommonStep(CafeTownSendCommonStep cafeTownSendCommonStep, WebDriver driver) {
		this.cafeTownSendCommonStep = cafeTownSendCommonStep;
		CafeTownSendAddStep.driver = driver;
	}

	@Step("I enter {0} as first name")
	public void enterFirstName(String firstName) {
		iEnterAddEmployee("First Name:", firstName);
	}

	private void iEnterAddEmployee(String field, String detail) {
		cafeTownSendCommonStep.init_PageFactory(driver);
		for (WebElement ele : cafeTownSendCommonStep.cafeTownSendPageFactory.employeeDetails
				.findElements(By.tagName("label"))) {
			if (ele.findElement(By.tagName("span")).getText().equalsIgnoreCase(field)) {
				ele.findElement(By.tagName("input")).sendKeys(detail);
				return;
			}
		}
	}

	@Step("I enter {0} as last name")
	public void enterLastName(String lastName) {
		iEnterAddEmployee("Last Name:", lastName);
	}

	@Step("I enter {0} as startDate")
	public void enterStartDate(String startDate) {
		iEnterAddEmployee("Start Date:", startDate);
	}

	@Step("I enter {0} as email")
	public void enterEmail(String email) {
		iEnterAddEmployee("Email:", email);
	}
	
	@Step("I Verify {0} employee got created")
	public void iVerifyNewEmployee(String employee) {
		cafeTownSendCommonStep.iVerifyEmployee(employee);
	}
	@Step("I click on add button")
	public void iClickButton(String button) {
		cafeTownSendCommonStep.init_PageFactory(driver);
		cafeTownSendCommonStep.cafeTownSendPageFactory.addUpdateDeleteButtons.findElements(By.tagName("button")).get(0).click();
		CafeTownSendCommonStep.buttonClicked="add";		
	}
}
