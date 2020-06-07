package com.SmokeSuite;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.ElementsPage;
import com.Pages.HomePage;
import com.Setup.TestBase;
import com.Utility.Log;

public class ElementsPageTest extends TestBase
{
	HomePage homePage;
	public ElementsPageTest()
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
	public void selectOfficeCheckBox()
	{
		   Log.info("Select element --- ");
		   ElementsPage elementsPage= homePage.naviageteToElementssPage();
		   Log.asserts(elementsPage.titleOfPage(),"ToolsQA");
		   elementsPage.openElementsDropDown();
		   elementsPage.selectCheckBoxItemInElement();
		   Log.asserts(elementsPage.getHeaderOfPage(),"Check Box");
		   elementsPage.clickHomeButtonArrow();
		   elementsPage.clickDocumentButtonArrow();
		   elementsPage.officeCheckBox();
		   Log.info(elementsPage.printResult());
		  
	}
	
	 @AfterMethod
		public void tearDown(){
	    	wait(10);
	    	Log.debug("Ending Driver Session");
			driver.quit();
		}
}
