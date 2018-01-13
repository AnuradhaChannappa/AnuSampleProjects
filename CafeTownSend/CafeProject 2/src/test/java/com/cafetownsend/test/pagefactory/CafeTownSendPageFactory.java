package com.cafetownsend.test.pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CafeTownSendPageFactory {
	@FindBy(css = "div.main-view-container>form#login-form input[type='text']")
	public WebElement loginUserName;

	@FindBy(css = "div.main-view-container>form#login-form input[type='password']")
	public WebElement loginPassword;

	@FindBy(css = "div.main-view-container>form#login-form button")
	public WebElement loginButton;

	@FindBy(css = "div.main-view-employees p#greetings")
	public WebElement helloUser;
	
	@FindBy(css = "main-button")
	public List<WebElement> mainLogoutUpdateDeleteButtons;
	
	@FindBy(css = "ul#sub-nav>li")
	public List<WebElement> createEditDeleteButtons;

	/*@FindBy(css = "ul#sub-nav>li>a#bAdd")
	public WebElement createButton;

	@FindBy(css = "ul#sub-nav>li>a#bEdit")
	public WebElement editButton;

	@FindBy(css = "ul#sub-nav>li>a#bDelete")
	public WebElement deleteButton;*/

	@FindBy(css = "div.main-view>footer>p>a")
	public List<WebElement> footerLinks;

	@FindBy(css = ".subButton.bCancel")
	public WebElement cancelButton;

	@FindBy(css = "div.main-view-container ul#employee-list>li")
	public List<WebElement> employeeSelected;

	@FindBy(css = "form[name='employeeForm']")
	public WebElement employeeDetails;

	@FindBy(css = "form[name='employeeForm'] div.formFooter")
	public WebElement addUpdateDeleteButtons;
	
	@FindBy(css = ".subButton.bBack")
	public WebElement backButton;
	
	
}
