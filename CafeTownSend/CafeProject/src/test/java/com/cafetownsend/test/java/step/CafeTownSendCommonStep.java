package com.cafetownsend.test.java.step;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.cafetownsend.test.library.ManageProperties;
import com.cafetownsend.test.pagefactory.CafeTownSendPageFactory;
import com.cafetownsend.test.library.ThinkTime;
import com.cafetownsend.test.library.Utils;
import com.cafetownsend.test.java.cucumber.PageConstants;

import com.cafetownsend.test.java.step.CafeTownSendDeleteStep;

import net.thucydides.core.annotations.Step;

public class CafeTownSendCommonStep {

	protected static WebDriver driver;
	protected ManageProperties mp;
	protected Properties rp;
	protected CafeTownSendPageFactory cafeTownSendPageFactory;
	protected ThinkTime thinkTime;
	protected Actions actions;
	protected PageConstants pageConstants;

	protected String userName;
	public static String buttonClicked;

	public CafeTownSendCommonStep() {
		mp = new ManageProperties();
		rp = mp.read();
	}

	@Step("I am on {1} Page")
	public void iGoToLoginPage(WebDriver driver, String pageName) {
		CafeTownSendCommonStep.driver = driver;
		pageName = rp.getProperty("cafeTownSendUrl");
		driver.navigate().to(pageName);
	}

	@Step("I Enter UserName as {0}")
	public void iEnterUserName(String userName) {
		this.userName = userName;
		Utils.doWait(2000);
		init_PageFactory(driver);
		Utils.doWait(5000);
		cafeTownSendPageFactory.loginUserName.sendKeys(userName);
	}

	public void init_PageFactory(WebDriver driver) {
		Utils.doWait(5000);
		driver.switchTo().defaultContent();
		cafeTownSendPageFactory = PageFactory.initElements(driver, CafeTownSendPageFactory.class);
	}

	@Step("I enter password")
	public void iEnterPassword(String password) {
		Utils.doWait(2000);
		init_PageFactory(driver);
		Utils.doWait(5000);
		cafeTownSendPageFactory.loginPassword.sendKeys(password);
	}

	@Step("I click on {0} Button")
	public void iClickButton(String button) {
		Utils.doWait(2000);
		init_PageFactory(driver);
		Utils.doWait(5000);
		if (button.equalsIgnoreCase("Login")) {
			cafeTownSendPageFactory.loginButton.click();
			CafeTownSendDeleteStep.handleAlert("cancel");
		}
		if(button.equalsIgnoreCase("Logout")){
			cafeTownSendPageFactory.mainLogoutUpdateDeleteButtons.get(0).click();
		}
		if (button.equalsIgnoreCase("create")) {
			cafeTownSendPageFactory.createEditDeleteButtons.get(0).click();			
		}
		if (button.equalsIgnoreCase("delete")) {
			cafeTownSendPageFactory.createEditDeleteButtons.get(2).click();
			buttonClicked="delete";
		}
		if (button.equalsIgnoreCase("edit")) {
			cafeTownSendPageFactory.createEditDeleteButtons.get(1).click();
		}
		
		// Utils.doClick(actions, cafeTownSendPageFactory.loginButton);
	}

	@Step("I am verifying the PageTitle,User logged , the buttons and Footer links")
	public void verifyPage() {
		iVerifyPageTitle();
		iVerifyHelloUser();
		iVerifyButtons();
		iVerifyFooter();
	}

	public void iVerifyFooter() {
		Utils.doWait(5000);
		init_PageFactory(driver);
		Utils.doWait(3000);
		String currenPageUrl = driver.getCurrentUrl();
		for (int i = 1; i < cafeTownSendPageFactory.footerLinks.size(); i++) {
			String actualName = cafeTownSendPageFactory.footerLinks.get(i).getText();
			PageConstants pageConstants = PageConstants.getPageConstant(actualName);
			String expectedUrl = pageConstants.getPageUrl();
			cafeTownSendPageFactory.footerLinks.get(i).click();
			Utils.doWait(4000);
			Assert.assertTrue("Assert Url", driver.getCurrentUrl().trim().equals(expectedUrl.trim()));
			// driver.navigate().back();
			driver.navigate().to(currenPageUrl);
			Utils.doWait(2000);
		}
	}

	public void iVerifyButtons() {
		String create = rp.getProperty("createButtonLabel");
		String edit = rp.getProperty("editButtonLabel");
		String delete = rp.getProperty("deleteButtonLabel");
		String logout = rp.getProperty("logoutButtonLabel");

		Assert.assertTrue("Create button label", cafeTownSendPageFactory.createEditDeleteButtons.get(0).getText().equals(create));
		Assert.assertTrue("Edit button label", cafeTownSendPageFactory.createEditDeleteButtons.get(1).getText().equals(edit));
		Assert.assertTrue("Delete button label", cafeTownSendPageFactory.createEditDeleteButtons.get(2).getText().equals(delete));
		Assert.assertTrue("Logout Button label", cafeTownSendPageFactory.mainLogoutUpdateDeleteButtons.get(0).getText().equals(logout));

		Assert.assertTrue("Create Button is Enabled", cafeTownSendPageFactory.createEditDeleteButtons.get(0).isEnabled());
		Assert.assertTrue("Logout Button is Enabled", cafeTownSendPageFactory.mainLogoutUpdateDeleteButtons.get(0).isEnabled());

		iVerifyEditDeleteButton();
	}

	public void iVerifyEditDeleteButton() {
		for (WebElement emp : cafeTownSendPageFactory.employeeSelected) {
			if (emp.getAttribute("class").contains("active")) {
				System.out.println("Assert enabled for edit and delete button");
				Assert.assertTrue("Edit button is enabled", cafeTownSendPageFactory.createEditDeleteButtons.get(0).isEnabled());
				Assert.assertTrue("Delete Button is enabled", cafeTownSendPageFactory.createEditDeleteButtons.get(2).isEnabled());
				return;
			} else {
				System.out.println("Assert disabled for edit and delete button");
				Assert.assertTrue("Edit button is disabled",
						cafeTownSendPageFactory.createEditDeleteButtons.get(1).getAttribute("class").contains("disabled"));
				Assert.assertTrue("Delete Button is disabled",
						cafeTownSendPageFactory.createEditDeleteButtons.get(2).getAttribute("class").contains("disabled"));
				return;
			}
		}
	}

	public void iVerifyHelloUser() {
		Utils.doWait(5000);
		init_PageFactory(driver);
		Utils.doWait(3000);
		String actualText;
		String expectedText;
		expectedText = "Hello " + userName;
		actualText = cafeTownSendPageFactory.helloUser.getText();
		Assert.assertTrue("Greeting check", actualText.equalsIgnoreCase(expectedText.trim()));
	}

	public void iVerifyPageTitle() {
		Utils.doWait(5000);
		init_PageFactory(driver);
		// System.out.println(driver.getTitle());
		Utils.doWait(5000);
		String expectedWindowTitle = rp.getProperty("windowTitle");
		Assert.assertTrue("WindowTitle", driver.getTitle().equalsIgnoreCase(expectedWindowTitle));
	}

	@Step("I select employee{0} from list of available employees")
	public Boolean iSelectAnEmployee(String employee) {
		init_PageFactory(driver);
		Utils.doWait(5000);
		for (WebElement emp : cafeTownSendPageFactory.employeeSelected) {
			if (emp.getText().trim().equalsIgnoreCase(employee)) {
				System.out.println("found employee clicking");
				// Utils.doClick(actions, emp);--This errors
				emp.click();
				return true;
			}
		}
		return false;
	}

	public void iVerifyEmployee(String employee) {		
		if(buttonClicked.equalsIgnoreCase("add")){
			Assert.assertTrue("Employee created", iSelectAnEmployee(employee));
			return;
			}
			if(buttonClicked.equalsIgnoreCase("delete")){
				System.out.println("emp not found:"+iSelectAnEmployee(employee));
				
				Boolean empStatus = iSelectAnEmployee(employee);
				System.out.println("empStatus:" + empStatus);
				//Assert.assertTrue("Employee deleted", !iSelectAnEmployee(employee));
				return;
			}		
	}
}
