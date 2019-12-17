package com.browserlauncer;

import com.relevantcodes.extentreports.LogStatus;

public class TC_005 extends BaseTest 
{
	

	public static void main(String[] args) throws Exception 
	{
		
		init();
		test=report.startTest("TC_005");
		test.log(LogStatus.INFO, "initializing the Properties files (data, or, envronments, log4jconfig) ........");
		
		launchBrowser("chromebrowser");
		test.log(LogStatus.INFO, "Opened the browser :- " + p.getProperty("chromebrowser"));
		
		launchUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to URl :- " + p.getProperty("amazonurl"));
		
		selectDropItem("amazondropbox_id","amazondropvalue");
		test.log(LogStatus.PASS, "Selected the option :- " + or.getProperty("amazondropvalue") + " by using the locator:- " + or.getProperty("amazondropbox_id"));
		
		typeValue("amazonsearchtext_name","amazonsearchtext");
		test.log(LogStatus.FAIL, "Entered the text :- " + or.getProperty("amazonsearchtext") + " by using the locator :- " + or.getProperty("amazonsearchtext_name"));
		
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.SKIP, "Clicked on Element by using the Locator :- " + or.getProperty("amazonsearchbutton_xpath"));
		
		
		report.endTest(test);
		report.flush();
	}

	

}
