package com.SmokeSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.HomePage;
import com.Pages.WidgetPage;
import com.Setup.TestBase;
import com.Utility.Log;

public class WidgetPageTest extends TestBase
{
	HomePage homePage;
	public WidgetPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Initliaze()
	{
	
		initialization();
		homePage = new HomePage();
	
	}
	@Test
	public void changeSlider()
	{
		Log.info("Changing the slider");
		WidgetPage wPage=homePage.naviageteToWidgetPage();
	
		wPage.selectSlider();
		
		Assert.assertEquals(wPage.getHeaderOfPage(), "Slider");
		wPage.setSliderValue("70");
		
		
	}
	@Test
	public void changeProgressBar()
	{
		Log.info("Changing the progrssBar");
		WidgetPage wPage=homePage.naviageteToWidgetPage();
		wPage.selectProgrssbar();
		Assert.assertEquals(wPage.getHeaderOfPage(), "Progress Bar");
		wPage.setProgressBarValue("58");
		Assert.assertEquals(wPage.getProgressBarCurrentValue(), "5");
	}
	
	 @AfterMethod
		public void tearDown(){
	    	wait(10);
	    	Log.debug("Ending Driver Session");
			driver.quit();
		}
}