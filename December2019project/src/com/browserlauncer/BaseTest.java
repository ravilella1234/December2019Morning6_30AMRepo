package com.browserlauncer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static Properties p;
	public static Properties or;
	
	public static FileInputStream fis;
	public static Properties prop;
	public static Properties envprop;
	
	public static ExtentReports report;
	public static ExtentTest test;
	
	public static String screenshotFileName=null;
	
	
	public static void init() throws Exception
	{
		fis=new FileInputStream(projectPath+"//data.properties");
		p=new Properties();
		p.load(fis);
		
		fis=new FileInputStream(projectPath+"//or.properties");
		or=new Properties();
		or.load(fis);
		
		fis=new FileInputStream(projectPath+"//environment.properties");
		prop=new Properties();
		prop.load(fis);
		String e = prop.getProperty("env");
		System.out.println(e);
		
		fis=new FileInputStream(projectPath+"//"+e+".properties");
		envprop=new Properties();
		envprop.load(fis);
		String val = envprop.getProperty("amazonurl");
		System.out.println(val);
		
		fis=new FileInputStream(projectPath+"//log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		report = ExtentManager.getInstance();
		
	}
	
	public static void launchBrowser(String browser)
	{
		if(p.getProperty(browser).equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
			
			ChromeOptions option=new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");

			//disable notifications
			option.addArguments("--disable-notifications");
			
			
			driver=new ChromeDriver(option);
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath+"//drivers//geckodriver.exe");
			
			ProfilesIni p=new ProfilesIni();
			FirefoxProfile profile = p.getProfile("ravilella");
			
			//disable notifications
			profile.setPreference("dom.webnotifications.enabled", false);
			
			FirefoxOptions option=new FirefoxOptions();
			option.setProfile(profile);
			
			driver=new FirefoxDriver(option);
		}
		
	}
	
	public static void launchUrl(String url)
	{
		//driver.get(p.getProperty(url));
		//driver.navigate().to(p.getProperty(url));
		driver.navigate().to(envprop.getProperty(url));
		driver.manage().window().maximize();
	}
	
	
	public static void selectDropItem(String locatorKey, String item) {
		getElement(locatorKey).sendKeys(or.getProperty(item));
		//driver.findElement(By.id(locatorKey)).sendKeys(item);
	}
	
	public static void clickElement(String locatorKey) {
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(locatorKey)).click();
	}

	public static void typeValue(String locatorKey, String value) {
		getElement(locatorKey).sendKeys(or.getProperty(value));
		//driver.findElement(By.id(locatorKey)).sendKeys(value);
	}

	public static WebElement getElement(String locatorKey) 
	{
		WebElement element=null;
		
		if(locatorKey.endsWith("_id")) {
			element=driver.findElement(By.id(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element=driver.findElement(By.name(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element=driver.findElement(By.className(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element=driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element=driver.findElement(By.linkText(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element=driver.findElement(By.partialLinkText(or.getProperty(locatorKey)));
		}
		
		return element;
	}

	
	// ***************************   Verifications    *******************************
	
	public static boolean verifyElement(String expectedLink) 
	{
		String actualLink =driver.findElement(By.xpath("//a[contains(text(),'AmazonBasics')]")).getAttribute("innerHTML");

		System.out.println("Actual Link : "+ actualLink);
		System.out.println("Expected Link : "+ expectedLink);
		
		if(actualLink.contains(expectedLink))
			return true;
		else
			return false;
	}
	
	//  **************************  Reportings  *********************************************
	
	public static void reportSuccess(String successMsg) 
	{
		test.log(LogStatus.PASS, successMsg);
	}

	public static void reportFailure(String failureMsg) 
	{
		test.log(LogStatus.FAIL, failureMsg);
		takeScreenshot();
	}
	
	public static void takeScreenshot() 
	{
		Date dt=new Date();
		screenshotFileName = dt.toString().replace(":", "_").replace(" ", "_")+".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(scrFile, new File(projectPath+"//failure//"+screenshotFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//put screen shot file in extent reports
		test.log(LogStatus.INFO, "Screenshot --> "+ test.addScreenCapture(projectPath+"//failure//"+screenshotFileName));
	}

}
