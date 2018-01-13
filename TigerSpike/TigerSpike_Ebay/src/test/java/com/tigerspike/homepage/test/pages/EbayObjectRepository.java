package com.tigerspike.homepage.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tigerspike.homepage.test.library.Synchronize;




public class EbayObjectRepository {
	

	public static WebElement element;
	 WebDriver driver;
	
	@FindBy(css = "button#gh-shop-a")
	WebElement shopByCategoryButton;	
	
	@FindBy(css = "table#gh-sbc td li")
	List<WebElement> categoriesList;
	
	@FindBy(css = "img[alt='Bicycles']")
	WebElement shopBySubCategory;
	
	@FindBy(css = "div#w5-xCarousel-x-carousel-items li>a")
	List<WebElement>  brands;
	
	@FindBy(css ="a.s-item__link")
	List<WebElement> items;
	
	public  WebElement shopByCategoryButton() {
		
		return shopByCategoryButton;
	}
	
public  WebElement shopBySubCategoryButton() {
		
		return shopBySubCategory;
	}
	
	public  void clickShopByCategoryButton(String shopByCategory) {
		Synchronize.fluentWaitToBeVisible(driver, shopByCategoryButton);
		shopByCategoryButton.click();
		
	}
	
	public List<WebElement> getCategories()
	{
		return categoriesList;
	}
	
	public List<WebElement> getBrands()
	{
		return brands;
	}
	
	public List<WebElement> getItems()
	{
		return items;
	}
	
	public void clickCategory(String category) {
		List<WebElement> categoryList = getCategories();
		for(WebElement categoryToClick:categoryList) {
			System.out.println("category:" + categoryToClick.getText());
			if(categoryToClick.getText().equalsIgnoreCase(category)) {
				Actions actions = new Actions(driver);
				actions.moveToElement(categoryToClick).click().build().perform();
				categoryToClick.findElement(By.tagName("a")).click();
				 break;
			}
		}
	}
	
	public List<WebElement> getSearchResult(){
		return categoriesList;
	}
	
	public EbayObjectRepository(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
