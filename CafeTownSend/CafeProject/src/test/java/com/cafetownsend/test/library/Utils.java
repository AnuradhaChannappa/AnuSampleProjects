package com.cafetownsend.test.library;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Utils {
private static String currentBrowser;
	
	public static void setCurrentBrowser(){
		currentBrowser = System.getProperty("runEnv");
		
		if(currentBrowser.equalsIgnoreCase(null)){
			currentBrowser="Chrome";
		}
	}
	
	public Utils()
	{
		System.out.println("Utils constructor");
	}
	
	public static void doWait(long ms)
	{
		try{
			Thread.sleep(ms);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static void doClick(Actions actions, WebElement clickObject) {
	
		doWait(3000);
		actions.click(clickObject).build().perform();
		
	}

	

	public static String getElementText(WebElement element) {
		
		if(isCurrentRunEnv("Firefox"))
		{
			System.out.println("Util getElementText:  Firefox");
			return element.getAttribute("textContent").trim();
			//return element.getAttribute("innerText").trim();
		}
		else
		{
			return element.getAttribute("innerText").trim();
		}
	}

	private static boolean isCurrentRunEnv(String browserName) {
			
		return StringUtils.containsIgnoreCase(currentBrowser,browserName);
		
	}

}
