package com.cafetownsend.test.java.step;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Step;

public class CafeTownSendDeleteStep {
	
	private CafeTownSendCommonStep cafeTownSendCommonStep;
	private static WebDriver driver;
	
	

	public void setCafeTownSendCommonStep(CafeTownSendCommonStep cafeTownSendCommonStep, WebDriver driver) {
		this.cafeTownSendCommonStep = cafeTownSendCommonStep;
		CafeTownSendDeleteStep.driver = driver;
	}
	@Step("I click {0} on the Alert")
	public static void handleAlert(String alertOption) {
		try{
			Alert alert = driver.switchTo().alert();
			if(alertOption.equalsIgnoreCase("ok")){
				alert.accept();
			}
			else{
				alert.dismiss();
			}
		}catch(Exception e){
			System.out.println("No Alert present");
		}
	}
	
	@Step("I Verify {0} employee got deleted")	
	public void iVerifyEmployeeDelete(String employee) {
		cafeTownSendCommonStep.iVerifyEmployee(employee);		
	}
}
