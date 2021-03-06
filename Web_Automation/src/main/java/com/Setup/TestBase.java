package com.Setup;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import com.Actions.Action;
import com.Utility.Log;
import com.Utility.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public Logger log = Logger.getLogger(this.getClass());
	//public static Log log;
	public static Action action;
	public static EnvironmentPropertiesReader configProperty = EnvironmentPropertiesReader.getInstance();
	public TestBase()
	{

	}
    
	public static void initialization()
	{
		
		driver = WebDriverFactory.getDriverInstance();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(configProperty.getProperty("url"));
		action= new Action(driver);
	}

	public void wait(int timeout)
	{
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public void wait(WebElement element, int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void wait(WebElement element, int timeout,int frequency)
	{
		Wait wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(frequency))
				.ignoring(NoSuchElementException.class);

	}

	public void sleep(int miliSeconds)
	{
		try {

			Thread.sleep(miliSeconds);
		} 
		catch (InterruptedException e) {
			log.error((e.getMessage()));
			e.printStackTrace();
		}
	}

}
