package com.hd.homepage.test.library;

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
			if(System.getProperty("os.name").contains("Mac OS")) {
					if(browserName.equalsIgnoreCase("Chrome")) {
						System.out.println("picking up the chrome driver on MAC....");
						System.setProperty("webdriver.chrome.driver", "src/test/java/com/hd/homepage/test/drivers/chromedriver");		
						driver=new ChromeDriver();	
					}
			}
			if(System.getProperty("os").contains("win")) {
				if(browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "src/test/java/com/hd/homepage/test/drivers/chromedriver.exe");
				driver=new ChromeDriver();
				}
				else if(browserName.equalsIgnoreCase("Firefox")) {
					System.setProperty("webdriver.gecko.driver", "src/test/java/com/hd/homepage/test/drivers/geckodriver.exe");				
					driver=new FirefoxDriver();			
				}
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
	}	
	
}
