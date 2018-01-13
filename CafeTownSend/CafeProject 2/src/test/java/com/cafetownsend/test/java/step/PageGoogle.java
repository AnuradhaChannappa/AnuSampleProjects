package com.cafetownsend.test.java.step;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Step;

public class PageGoogle {
	
	@Step("I am on {1} page")
	public void iGotoPage(WebDriver driver,String pageName){
		driver.navigate().to("http://www.google.com");
		
	}

}
