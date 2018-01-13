package com.hipages.test.pagefactory;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleObjectRepository {
	
	
	@FindBy(css = "input#lst-ib")
	public WebElement searchField;	
	
	@FindBy(css = "ul.sbsb_b>li")
	public List<WebElement> googleSearchResult;
	
	@FindBy(css = "span.gsri_a")
	public WebElement searchByVoice;
	
	@FindBy( css = "button#spchb")
	public WebElement searchByVoiceButton;
	
	@FindBy( css = "div.gb_je.gb_R.gb_Dg.gb_ug a")
	public List<WebElement> headerIconsGmailImages;
	
	@FindBy( css = "img#hplogo")
	public WebElement googleLogo;
	
	@FindBy ( css = "a.gsst_a")
	public WebElement moseOverText;
	
	@FindBy (css = "input[name=btnK]")
	public WebElement googleSearchButton;
	
	@FindBy ( css = "input[name=btnI]" )
	public WebElement googleFeelingLuckyButton;
	
	@FindBy ( css = "div.gb_kb.gb_Dg.gb_R.gb_Cg.gb_Hg.gb_T div>div>a")
	public List<WebElement> headerLinks;
	
	
 
	
}
