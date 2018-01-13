package com.cafetownsend.test.java.cucumber;

import org.openqa.selenium.WebDriver;

import com.cafetownsend.test.java.step.CafeTownSendDeleteStep;
import com.cafetownsend.test.java.step.CafeTownSendEditStep;
import com.cafetownsend.test.java.step.CafeTownSendAddStep;
import com.cafetownsend.test.java.step.CafeTownSendCommonStep;
import com.cafetownsend.test.library.SetDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CafeTownSendStep {

	private String runEnv;
	private WebDriver driver;

	private SetDriver setDriver;

	@Steps private CafeTownSendCommonStep cafeTownSendCommonSteps;
	@Steps private CafeTownSendAddStep cafeTownSendAddSteps;
	@Steps private CafeTownSendDeleteStep cafeTownSendDeleteSteps;
	@Steps private CafeTownSendEditStep cafeTownSendEditSteps;

	@Before
	public void doBefore() {
		setDriver = SetDriver.getInstance();
		runEnv = System.getProperty("runEnv");
		driver = setDriver.set(runEnv);
	}

	@Given("^I go to \"(.*?)\" Page$")
	public void i_go_to_Login_Page(String pageName) throws Throwable {
		cafeTownSendCommonSteps.iGoToLoginPage(driver, pageName);
	}

	@When("^I Enter \"(.*?)\" as Username$")
	public void i_enter_userName(String userName) throws Throwable {
		cafeTownSendCommonSteps.iEnterUserName(userName);
	}

	@When("^I Enter \"(.*?)\" as Password$")
	public void i_enter_password(String password) throws Throwable {
		cafeTownSendCommonSteps.iEnterPassword(password);
	}

	@When("^I click on \"(.*?)\" Button$")
	public void i_click_Button(String button) {
		cafeTownSendCommonSteps.iClickButton(button);
		if (button.equals("Create")) {
			cafeTownSendAddSteps.setCafeTownSendCommonStep(cafeTownSendCommonSteps, driver);
		}
		if (button.equals("Edit")) {
			cafeTownSendEditSteps.setCafeTownSendCommonStep(cafeTownSendCommonSteps, driver);
		}
		if (button.equals("Delete")) {
			cafeTownSendDeleteSteps.setCafeTownSendCommonStep(cafeTownSendCommonSteps, driver);
		}
		
	}

	@When("^I select employee \"(.*?)\"$")
	public void i_select_employee(String employee) throws Throwable {
		cafeTownSendCommonSteps.iSelectAnEmployee(employee);
	}

	@Then("^I verify the page$")
	public void i_verify_page() throws Throwable {
		cafeTownSendCommonSteps.verifyPage();
	}

	@Then("^I verify the Edit Delete Button$")
	public void i_verify_Edit_DeleteButton() throws Throwable {
		cafeTownSendCommonSteps.iVerifyEditDeleteButton();
	}

	@When("^I Enter \"(.*?)\" as FirstName$")
	public void i_Enter_FirstName(String firstName) throws Throwable {

		cafeTownSendAddSteps.enterFirstName(firstName);
	}

	@When("^I Enter \"(.*?)\" as LastName$")
	public void i_Enter_LastName(String lastName) throws Throwable {
		cafeTownSendAddSteps.enterLastName(lastName);
	}

	@When("^I Enter \"(.*?)\" as StartDate$")
	public void i_Enter_StartDate(String startDate) throws Throwable {
		cafeTownSendAddSteps.enterStartDate(startDate);		
	}

	@When("^I Enter \"(.*?)\" as Email$")
	public void i_Enter_Email(String email) throws Throwable {
		cafeTownSendAddSteps.enterEmail(email);
	}

	@Then("I verify \"(.*?)\" Employee$")
	public void i_Verify_Employee(String Employee) throws Throwable {
		if(CafeTownSendCommonStep.buttonClicked.equalsIgnoreCase("create")){
		cafeTownSendAddSteps.iVerifyNewEmployee(Employee);
		}
		if(CafeTownSendCommonStep.buttonClicked.equalsIgnoreCase("delete")){
			cafeTownSendDeleteSteps.iVerifyEmployeeDelete(Employee);
		}
	}
	@When("^I click \"(.*?)\" on Alert$")
	public void i_Click_Ok_On_Alert(String alertOption) throws Throwable{
		CafeTownSendDeleteStep.handleAlert(alertOption);
	}
	
	@Then("^I verify \"(.*?)\" employee details$")	        
	public void i_verify_employeeDetails(String empName) throws Throwable{
		cafeTownSendEditSteps.iVerifyDisplayedEmployee(empName);
	}
	
	@When("^I click on \"(.*?)\" Button on Edit Page$")
	public void i_click_on_Button_Edit_page(String button) {
		cafeTownSendEditSteps.iClickButton(button);
	}
	
	@When("^I click on \"(.*?)\" Button on Create Page$")
	public void i_click_on_Button_Create_page(String button) {
		cafeTownSendAddSteps.iClickButton(button);
	}
	
}