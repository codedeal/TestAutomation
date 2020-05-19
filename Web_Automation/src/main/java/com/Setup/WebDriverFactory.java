package com.Setup;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.Utility.TestUtil;

public class WebDriverFactory 
{
	private static EnvironmentPropertiesReader configProperty = EnvironmentPropertiesReader.getInstance();
	public static WebDriver getDriverInstance()
	{
		return get(); 
	}
	
	private static WebDriver get()
	{
		WebDriver driver=null;
		try {
			driver = getWebDriver();
//		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return driver;
	}
	


	private static WebDriver getWebDriver() throws MalformedURLException
	{
		WebDriver driver = null;

		
		if(configProperty.getProperty("browser").equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "/Users/Upendra/Purpose/IDE_Automation/Web_Automation/resources/chromedriver");	
			driver = new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "/Users/Upendra/Purpose/IDE_Automation/Web_Automation/resources/chromedriver");
			driver = new FirefoxDriver();
			 
		}
		return driver;
	}


	

}
