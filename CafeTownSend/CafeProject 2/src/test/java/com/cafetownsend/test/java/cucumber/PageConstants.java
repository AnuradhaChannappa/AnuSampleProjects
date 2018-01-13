package com.cafetownsend.test.java.cucumber;

public enum PageConstants {
	
	AngularJS("AngularJS","https://angularjs.org/"),
	CoffeeScript("CoffeeScript","http://coffeescript.org/"),	
	Bourbon("Bourbon","http://bourbon.io/"),
	Rails("Rails","http://rubyonrails.org/"),
	Get_Source_Code("Get Source Code","https://github.com/sectore/CafeTownsend-Angular-Rails"),
	Jens_Krause("Jens Krause","http://www.jkrause.io/");
	
	private String pageName;
	private String pageUrl;
	
	PageConstants(String pageName,String pageUrl){
		this.pageName=pageName;
		this.pageUrl=pageUrl;
	}
	
	public String getPageName(){
		return pageName;
	}
	
	public String getPageUrl(){
		return pageUrl;
	}
	
	public static PageConstants getPageConstant(String pageName){
		
		for(PageConstants pc:PageConstants.values()){
			if(pc.getPageName().equalsIgnoreCase(pageName))
			{
				return pc;
			}
		}
		
		return null;
		
	}
	
	/*public static void main(String[] str){
		System.out.println(getPageConstant("Rails").getPageUrl());
	}*/

}
