package com.browserlauncer;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static Properties p;
	
	public static FileInputStream fis;
	public static Properties prop;
	public static Properties envprop;
	
	
	public static void init() throws Exception
	{
		fis=new FileInputStream(projectPath+"//data.properties");
		p=new Properties();
		p.load(fis);
		
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
	}

}
