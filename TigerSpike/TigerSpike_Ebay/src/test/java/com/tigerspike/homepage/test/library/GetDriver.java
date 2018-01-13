package com.tigerspike.homepage.test.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetDriver {
	
	private static WebDriver driver=null;

	public static WebDriver GetBrowser(String browserName) {

		if (driver != null) {
			return driver;
		}

		try {
			if(browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./src/test/java/com/tigerspike/homepage/test/drivers/chromedriver_mac");				
				driver=new ChromeDriver();			
			}
			else if(browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "./src/test/java/com/tigerspike/homepage/test/drivers/geckodriver.exe");				
				driver=new FirefoxDriver();			
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
	}	
	
}
