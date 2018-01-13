package com.hd.homepage.test.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hd.homepage.test.library.Synchronize;


public class HDObjectRepository {
	

	public static WebElement element;
	 WebDriver driver;
	
	@FindBy(css = "li.ng-scope.desktop-only>form>input")
	WebElement hdHomePageSearch;	
	
	@FindBy(css = "form[id='search-form-node-desktop-mode']>ul>li")
	List<WebElement> hdHomePageSearchResult;
	
	
	@FindBy(css = "main.main_content-article-text h1")
	WebElement hdHomePageSearchResultsHeading;
	
	public  WebElement searchTextBox() {
		
		return hdHomePageSearch;
	}
	
	public  void fillSearchTextBox(String searchText) {
		Synchronize.fluentWaitToBeVisible(driver, hdHomePageSearch);
		hdHomePageSearch.click();
		hdHomePageSearch.sendKeys(searchText);
	}
	
	public WebElement getSearchResultHeading()
	{
		return hdHomePageSearchResultsHeading;
	}
	
	public List<WebElement> getSearchResult(){
		return hdHomePageSearchResult;
	}
	
	public HDObjectRepository(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
