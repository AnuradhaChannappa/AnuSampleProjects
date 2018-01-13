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

	// http://stackoverflow.com/questions/7279887/what-is-the-use-of-a-private-static-variable-in-java

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
System.out.println("Inside try");
			String downloadFilePath = System.getProperty("java.io.tmpdir");
			System.out.println("downloadFilePath:" + downloadFilePath);

			if (runEnv == null || runEnv.length() == 0) {
				System.out.println("Use bamboo configured web browser");
			} else if (runEnv.equals("Chrome")) {
				System.out.println("set chrome");
				setChromeDriver();
				
				//Download Setting
				Map<String, Object> chromePrefs = new HashMap<String,Object>();
				chromePrefs.put("download.default_directory", downloadFilePath);
				
				System.out.println("chromePrefs: " + chromePrefs);
				System.out.println("Download File path is;" + downloadFilePath.toString());
			
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				
				
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			
			
			driver=new ChromeDriver(cap);
			}
			else if(runEnv.equalsIgnoreCase("firefox")){
				/*FirefoxProfile profile = new FirefoxProfile();
				
				profile.setPreference("browser.download.folderList", 2);
				profile.setPreference("browser.download.dir", downloadFilePath);*/
				
				System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Downloads\\geckodriver.exe");
				//driver = new FirefoxDriver(profile);
				driver = new FirefoxDriver();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return driver;

	}

	private void setChromeDriver() {
		String os = System.getProperty("os.name");
		System.out.println("Os: " + os);
		if (os.equals("mac os")) {
			System.setProperty("webdriver.chrome.driver", "");
		} else {
			System.out.println("Setting chrome");
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Downloads\\chromedriver.exe");
		}

	}


}
