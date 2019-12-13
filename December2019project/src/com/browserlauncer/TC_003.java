package com.browserlauncer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_003 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launchBrowser("chromebrowser");
		
		launchUrl("amazonurl");
		
		/*
		 * WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));
		 * loc.sendKeys("samsung");
		 * 
		 * Thread.sleep(3000);
		 * 
		 * loc.clear();
		 * 
		 * driver.findElement(By.name("field-keywords")).sendKeys("philips");
		 * 
		 * //driver.findElement(By.className("nav-input")).clear();
		 * 
		 * driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		 * 
		 * 
		 * driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("sony");
		 */
		
		
		//driver.findElement(By.linkText("AmazonBasics")).click();
		
		//driver.findElement(By.partialLinkText("AmazonBas")).click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++)
		{	
			if(!links.get(i).getText().isEmpty())
			{
				System.out.println(links.get(i).getText());
			}
			
		}

	}

}
