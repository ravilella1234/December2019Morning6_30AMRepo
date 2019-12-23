package com.browserlauncer;

import com.relevantcodes.extentreports.LogStatus;

public class TC_007 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test=report.startTest("TC_007");
		test.log(LogStatus.INFO, "initializing the Properties files (data, or, envronments, log4jconfig) ........");
		
		launchBrowser("chromebrowser");
		test.log(LogStatus.INFO, "Opened the browser :- " + p.getProperty("chromebrowser"));
		
		launchUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to URl :- " + p.getProperty("amazonurl"));
		
		String expectedLink="Amazonba";
		if(!verifyElement(expectedLink))
			reportFailure("Both Links are not Equal.......");
		else
			reportSuccess("Both Links are Equal.......");
		
		report.endTest(test);
		report.flush();
		
	}

}
