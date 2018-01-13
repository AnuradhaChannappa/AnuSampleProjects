package com.cafetownsend.test.library;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SetDriver {

	private static SetDriver setDriver;
	private WebDriver driver;

	public static SetDriver getInstance() {
		if (setDriver == null) {
			setDriver = new SetDriver();
		}
		return setDriver;
	}

	public WebDriver set(String runEnv) {

		if (driver != null) {
			return driver;
		}

		try {

			String downloadFilePath = System.getProperty("java.io.tmpdir");
			System.out.println("downloadFilePath:" + downloadFilePath);

			if (runEnv.equals("Chrome")) {
				System.out.println("set chrome");
				setChromeDriver(runEnv);

				// Download Setting
				Map<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("download.default_directory", downloadFilePath);

				System.out.println("chromePrefs: " + chromePrefs);
				System.out.println("Download File path is;" + downloadFilePath.toString());

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);

				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setCapability(ChromeOptions.CAPABILITY, options);

				driver = new ChromeDriver(cap);
			} else if (runEnv.equalsIgnoreCase("firefox")) {

				driver = new FirefoxDriver();
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return driver;

	}

	private void setChromeDriver(String browserName) {
		
			if(System.getProperty("os.name").contains("Mac OS")) {
					if(browserName.equalsIgnoreCase("Chrome")) {
						System.out.println("picking up the chrome driver on MAC....");
						System.setProperty("webdriver.chrome.driver", "src/test/java/com/cafetownsend/test/drivers/chromedriver");		
						driver=new ChromeDriver();	
					}
			}
			else if(System.getProperty("os.name").contains("Win")) {
				if(browserName.equalsIgnoreCase("Chrome")) {
					System.out.println("picking up the chrome driver on Windows....");
					System.setProperty("webdriver.chrome.driver", "src/test/java/com/cafetownsend/test/drivers/chromedriver.exe");		
					driver=new ChromeDriver();	
				}
		}
	}
}

