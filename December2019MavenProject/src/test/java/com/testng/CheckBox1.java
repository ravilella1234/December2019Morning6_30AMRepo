package com.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.December2019MavenProject.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class CheckBox1 extends BaseTest
{
  
	@BeforeMethod
	@Parameters("browser")
	  public void beforeMethod(String btype) throws Exception 
	  {
		init();
		test=report.startTest("CheckBox1");
		test.log(LogStatus.INFO, "initializing the Properties files (data, or, envronments, log4jconfig) ........");
		
		launchBrowser(btype);
		test.log(LogStatus.INFO, "Opened the browser :- " + p.getProperty("chromebrowser"));
		
		launchUrl("checkboxurl");
		test.log(LogStatus.INFO, "Navigated to URl :- " + p.getProperty("checkboxurl"));
	  }
	  
	  
	@Test
	public void checkboxTest()
	{
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for(int i=0;i<check.size();i++)
		{
			System.out.println(check.get(i).getAttribute("value")+"--"+check.get(i).getAttribute("checked"));
			//System.out.println(check.get(i).isSelected());
		}
	}
 

  @AfterMethod
  public void afterMethod() 
  {
	  closeBrowser();
	  report.endTest(test);
	  report.flush();
  }

}
