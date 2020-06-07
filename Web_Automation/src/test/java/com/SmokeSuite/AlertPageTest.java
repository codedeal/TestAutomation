package com.SmokeSuite;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.AlertsPage;
import com.Pages.HomePage;
import com.Setup.TestBase;
import com.Utility.Log;

public class AlertPageTest extends TestBase
{
	public AlertPageTest()
	{
		super();
		
	}
	HomePage homePage;
	@BeforeMethod
	public void Initliaze()
	{
	
		initialization();
		homePage = new HomePage();
	}
	
	@Test
	public void testSimpleAlertButton()
	{
		AlertsPage page=homePage.naviageteToAlertsPage();
		Log.asserts(page.objectiveOfPage(),"Alerts, Frame & Windows");
		page.scrollToAlert();
		page.clickButtonToSeeAlert();
		Log.asserts(action.getalertText(), "You clicked a button");
		action.acceptAlert();
		
	}
	

	@Test
	public void testSimpleAlertButtonTimer()
	{
		AlertsPage page=homePage.naviageteToAlertsPage();
		Log.asserts(page.objectiveOfPage(),"Alerts, Frame & Windows");
		page.scrollToAlert();
		page.clickButtonToSeeAlertTimer();
		new WebDriverWait(driver, 15).until(ExpectedConditions.alertIsPresent());
		Log.asserts(action.getalertText(), "This alert appeared after 5 seconds");
		action.acceptAlert();
		
	}
	
	@Test
	public void testSimpleAlertButtonPromt()
	{
		AlertsPage page=homePage.naviageteToAlertsPage();
		Log.asserts(page.objectiveOfPage(),"Alerts, Frame & Windows");
		page.scrollToAlert();
	
		
		page.clickButtonToSeeAlertPrompt();
		new WebDriverWait(driver, 15).until(ExpectedConditions.alertIsPresent());
		action.switchToAlertAndSendData("Some name");
	
	
		Log.asserts(action.getDataSwtInAlertPrompt(), "Please enter your name");
		action.acceptAlert();
		
	}
	
	@Test
	public void testnewTabInBrowserWindows()
	{
		AlertsPage page=homePage.naviageteToAlertsPage();
		Log.asserts(page.objectiveOfPage(),"Alerts, Frame & Windows");
		page.scrollToBrowserWindow();
		Log.asserts(page.objectiveOfPage(), "Browser Windows");
		Log.asserts( page.navigateToNewTab(), "This is a sample page");
	
		
	}
	
	@Test
	public void testnewWindowInBrowserWindows()
	{
		AlertsPage page=homePage.naviageteToAlertsPage();
		Log.asserts(page.objectiveOfPage(),"Alerts, Frame & Windows");
		page.scrollToBrowserWindow();
	
		Log.asserts(page.objectiveOfPage(), "Browser Windows");
		Log.asserts( page.navigateToNewWindow(), "This is a sample page");
       
	
		
	}
	
	@Test
	public void testnewWindowMessageInBrowserWindows()
	{
		AlertsPage page=homePage.naviageteToAlertsPage();
		Log.asserts(page.objectiveOfPage(),"Alerts, Frame & Windows");
	
		page.scrollToBrowserWindow();
		Log.asserts(page.objectiveOfPage(), "Browser Windows");
		
		driver.switchTo().defaultContent();
 
	
		
	}
	
	@AfterMethod
	public void tearDown(){
    	wait(10);
    	Log.debug("Ending Driver Session");
		driver.quit();
	}
	
}
