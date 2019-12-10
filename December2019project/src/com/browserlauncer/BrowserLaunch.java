package com.browserlauncer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Desktop\\selenium jars\\chromedriver.exe" );
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\selenium jars\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.bestbuy.com");
		
		//webdriver.chrome.driver
		//webdriver.gecko.driver
		//webdriver.ie.driver
		//webdriver.edge.driver
		
		
		
	}

}
