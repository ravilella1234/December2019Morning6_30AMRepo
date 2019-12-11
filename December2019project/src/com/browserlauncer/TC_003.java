package com.browserlauncer;

public class TC_003 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launchBrowser("chromebrowser");
		
		launchUrl("axisbankurl");
		
		driver.manage().window().maximize();

	}

}
