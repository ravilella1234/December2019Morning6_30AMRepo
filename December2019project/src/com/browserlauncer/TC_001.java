package com.browserlauncer;

public class TC_001 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		
		init();
		
		launchBrowser("firefoxbrowser");
		
		launchUrl("amazonurl");
		
	}

}
