package com.tigerspike.homepage.test.steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tigerspike.homepage.test.library.ReadPropertiesFile;
import com.tigerspike.homepage.test.pages.EbayObjectRepository;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.thucydides.core.annotations.Step;

public class EndUserSearchSteps {

	public WebDriver driver = null;
	Properties properties = ReadPropertiesFile.getProperty();
	public EbayObjectRepository ebayObjectRepository;
	public static String optionSelected;

	@Step("I navigate to Ebay home page")
	public void is_on_the_home_page(WebDriver driver) {

		driver.navigate().to(properties.getProperty("ebayHomePageUrl"));
		this.driver = driver;
		ebayObjectRepository = new EbayObjectRepository(driver);

	}

	@Step("I select category {0}")
	public void selectCategory(String category) throws Throwable {
		Thread.sleep(5000);
		ebayObjectRepository.shopByCategoryButton().click();
		Thread.sleep(4000);
		ebayObjectRepository.clickCategory(category);
	}

	@Step("I select sub category {0}")
	public void select_sub_category(String subCategory) throws Throwable {

		ebayObjectRepository.shopBySubCategoryButton().click();

	}

	@Step("I select top 5 brands and one item from each brand")
	public void select_brand_items() throws IOException, InterruptedException {
		String path = "./src/test/java/com/tigerspike/homepage/test/drivers/BrandItems.xlsx";
		String sheet = "Sheet1";

		XSSFWorkbook excelWorkBook;
		XSSFSheet excelWSheet;

		try {
			FileInputStream excelFile = new FileInputStream(path);
			excelWorkBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWorkBook.getSheet(sheet);

			for (int i = 1; i <= 5; i++) {

				List<WebElement> brands = ebayObjectRepository.getBrands();
				for (WebElement brand : brands) {
					String selectBrand = excelWSheet.getRow(i).getCell(0).getStringCellValue().trim();

					if (brand.getText().equalsIgnoreCase(selectBrand)) {
						brand.click();
						String selectedItem = excelWSheet.getRow(i).getCell(1).getStringCellValue().trim();
						selectItem(selectedItem);
						break;
					}
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectItem(String itemToClick) throws InterruptedException {
		// click on buy it now tab
		driver.findElements(By.cssSelector("div.tabs.tabs--faux.srp-format-tabs li")).get(2).click();

		List<WebElement> items = ebayObjectRepository.getItems();
		for (WebElement item : items) {

			if (item.getText().equalsIgnoreCase(itemToClick)) {
				item.click();
				driver.findElements(By.xpath("//*[contains(text(),'Add to cart')]")).get(0).click();
				Thread.sleep(2000);
				driver.navigate().back();

				driver.findElement(By.xpath("//span[contains(text(),'Bicycles')]")).click();
				Thread.sleep(2000);
				return;
			}
		}

	}

	public static void main(String[] arg) throws IOException {
		// select_brand_items();
	}

}
