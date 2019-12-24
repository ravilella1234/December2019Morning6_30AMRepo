package com.browserlauncer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class TC_006 extends BaseTest
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
		
		/*
		 * //String actualLink =
		 * driver.findElement(By.xpath("//a[contains(text(),'AmazonBasics')]")).getText(
		 * ); String actualLink =
		 * driver.findElement(By.xpath("//a[contains(text(),'AmazonBasics')]")).
		 * getAttribute("innerHTML"); String expectedLink="AmazonBa";
		 * 
		 * System.out.println("Actual Link : "+ actualLink);
		 * System.out.println("Expected Link : "+ expectedLink);
		 * 
		 * //if(actualLink.equals(expectedLink))
		 * //if(actualLink.equalsIgnoreCase(expectedLink))
		 * if(actualLink.contains(expectedLink))
		 * System.out.println("Both links are equal...."); else
		 * System.out.println("Both links are not equal....");
		 */
		
		
		/*
		 * WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));
		 * 
		 * loc.sendKeys("sony"); String val = loc.getAttribute("value");
		 * System.out.println("Text is :" + val);
		 */
		
		
		String actualLink =driver.findElement(By.xpath("//a[contains(text(),'AmazonBasics')]")).getText();  
		String expectedLink="AmazonBasic";
		
		System.out.println("Actual Link : "+ actualLink);
		System.out.println("Expected Link : "+ expectedLink);
		
		//Assert.assertEquals(actualLink, expectedLink);
		//Assert.assertTrue(actualLink.equals(expectedLink), "Both links are not equal....");
		
		SoftAssert s=new SoftAssert();
		//s.assertEquals(actualLink, expectedLink);
		s.assertTrue(actualLink.equals(expectedLink), "Both links are not equal....");
		
		s.assertTrue(false, "err1");
		
		s.assertTrue(true, "err2");
		
		s.assertTrue(false, "err3");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sony");
		
		s.assertAll();
	}

}
