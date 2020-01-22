package com.POM;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excelLibraries.BaseTest;

public class POM_002 extends BaseTest
{
 
	Login obj;
	
  @BeforeTest
  public void startProcess() throws Exception 
  {
	  init();
	  launchBrowser("chromebrowser");
	  launchUrl("automationurl");
  }
  
  
  @Test
  public void login() 
  {
	  obj = new Login(driver);
	  obj.customerLogin();
	  Assert.assertEquals(obj.validateCustomer(), "Authentication failed");
  }
  
  
  @Test
  public void registration()
  {
	  
  }

  @AfterTest
  public void endProcess() 
  {
	  
  }

}
