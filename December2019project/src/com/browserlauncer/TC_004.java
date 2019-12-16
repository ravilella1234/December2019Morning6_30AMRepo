package com.browserlauncer;

import org.apache.log4j.Logger;

public class TC_004 extends BaseTest 
{
	private static final Logger log=Logger.getLogger(TC_004.class);
	

	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("initializing the Properties files (data, or, envronments, log4jconfig) ........");
		
		launchBrowser("chromebrowser");
		log.info("Opened the browser :- " + p.getProperty("chromebrowser"));
		
		launchUrl("amazonurl");
		log.info("Navigated to URl :- " + p.getProperty("amazonurl"));
		
		selectDropItem("amazondropbox_id","amazondropvalue");
		log.info("Selected the option :- " + or.getProperty("amazondropvalue") + " by using the locator:- " + or.getProperty("amazondropbox_id"));
		
		typeValue("amazonsearchtext_name","amazonsearchtext");
		log.info("Entered the text :- " + or.getProperty("amazonsearchtext") + " by using the locator :- " + or.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on Element by using the Locator :- " + or.getProperty("amazonsearchbutton_xpath"));
		
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//div[contains(@class,'nav-search-submit nav-sprite')]//input[contains(@class,'nav-input')]")).click();

	}

	

}
