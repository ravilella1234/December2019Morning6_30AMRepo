package com.browserlauncer;

public class TC_004 extends BaseTest 
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launchBrowser("chromebrowser");
		
		launchUrl("amazonurl");
		
		selectDropItem("searchDropdownBox","Books");
		
		typeValue("field-keywords","Harry Potter");
		
		clickElement("//div[contains(@class,'nav-search-submit nav-sprite')]//input[contains(@class,'nav-input')]");
		
		
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//div[contains(@class,'nav-search-submit nav-sprite')]//input[contains(@class,'nav-input')]")).click();

	}

	

}
