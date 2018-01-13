package com.cafetownsend.test.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThinkTime {
	public ThinkTime()
	{
		System.out.println("Think time constructor");
	}
	
	public void waits(WebDriver driver, By by)
	{
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	
	
	public void waitUnitlVisible(WebDriver driver,By by)
	{
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	public void waits(WebDriver driver,WebElement element)
	{
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waits(WebDriver driver,List<WebElement> elements)
	{
		(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	

public void waitToBeClickable(WebDriver driver, WebElement webElement)
{
	(new WebDriverWait(driver, 120)).until(ExpectedConditions.elementToBeClickable(webElement));
}

public void sleep(long millis)
{
	try{
		Thread.sleep(millis);
	}catch(InterruptedException e)
	{
		e.printStackTrace();
	}
}
}
