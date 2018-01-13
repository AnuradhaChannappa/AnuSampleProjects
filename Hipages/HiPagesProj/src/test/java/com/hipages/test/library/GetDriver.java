package com.hipages.test.library;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetDriver {

	private static WebDriver driver = null;

	public static WebDriver set(String runEnv) {

		if (driver != null) {
			return driver;
		}
		try {

			if (runEnv.equalsIgnoreCase("Chrome")) {

				setChromeDriver();
				driver = new ChromeDriver();

			}
			if (runEnv.equalsIgnoreCase("Firefox")) {
				setFirefoxDriver();
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} catch (Exception e) {
			System.out.println(e);
		}
		return driver;

	}

	private static void setChromeDriver() {

		String os = System.getProperty("os.name");
		if (os.contains("Mac OS")) {
			System.out.println("picking up the chrome driver on MAC....");
			System.setProperty("webdriver.chrome.driver", "src/test/java/com/hipages/test/mac/drivers/chromedriver");
		} else if (os.contains("Win")) {
			System.setProperty("webdriver.chrome.driver on Windows...",
					"src/test/java/com/hipages/test/win/drivers/chromedriver.exe");
		} else {
			System.out.println("picking up the ubuntu driver on Linux...");
			System.setProperty("webdriver.chrome.driver",
					"src/test/java/com/hipages/test/ubuntu/drivers/chromedriver-linux");
		}
	}

	private static void setFirefoxDriver() {
		String os = System.getProperty("os.name");
		if (os.contains("Mac OS")) {
			System.setProperty("webdriver.gecko.driver", "src/test/java/com/hipages/test/mac/drivers/geckodriver");
		} else if (os.contains("Win")) {
			System.setProperty("webdriver.gecko.driver", "src/test/java/com/hipages/test/win/divers/geckodriver.exe");
		} else {
			System.out.println("picking up the ubuntu driver....");
			System.setProperty("webdriver.gecko.driver",
					"src/test/java/com/hipages/test/ubuntu/drivers/geckodriver.exe");
		}
	}

	public static void close() {
		if (driver == null) {
			return;
		}
		synchronized (driver) {
			driver.close();
			driver.quit();
			driver = null;
		}
		
	}

}
