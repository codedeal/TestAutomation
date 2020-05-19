package com.SmokeSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pages.DraggablePage;
import com.Pages.DroppablePage;
import com.Pages.HomePage;
import com.Pages.ResizablePage;
import com.Pages.SelectablePage;
import com.Pages.SortablePage;
import com.Setup.TestBase;
import com.Utility.Log;

public class HomePageTest extends TestBase
{
	
	HomePage homePage;
	SelectablePage selectablePage;
	SortablePage sortablePage;
	ResizablePage resizablePage;
	DraggablePage draggablePage;
	DroppablePage droppablePage;
	
	

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void Initliaze()
	{
	
		initialization();
		
		//Log.info("****************************** Starting test cases execution  *****************************************");
		homePage = new HomePage();
		
		
	}
	

    
   @Test
   public void performDragandDrop()
   {
	 
	  Log.info("in performing drag and drop");
	  droppablePage= homePage.naviageteToDroppablePage();
	  droppablePage.dragDrop();
   }
   
   @Test
   public void performSortingDescending()
   {
	  Log.info("in performSorting");
	  sortablePage= homePage.naviageteToSortablePage();
	  sortablePage.printListOfItem();
	  sortablePage.sortinDescendingOrder();
	  
   }
   
   @Test(priority=1)
   public void resizeTheBox()
   {
	   Log.info("inresizing the box");
	   resizablePage=homePage.naviageteToResizablePage();
	   resizablePage.resizeTheBox();
	   wait(10000);
	   Log.info("resizing the box completed");
	   
   }
   
   @Test
   public void someFailedTestCase()
   {
	   Log.info("some failed testcase");
	   DroppablePage page=homePage.naviageteToDroppablePage();
	   Assert.assertEquals("true", "false");
   }
    
    @AfterMethod
	public void tearDown(){
    	wait(10);
    	Log.debug("Ending Driver Session");
		driver.quit();
	}
    
    @DataProvider(parallel=true)
	public Object[][] getData()
	{
		Object data[][]=new Object[1][0];
		
		data[0][0]="chrome";
		data[1][0]="firefox";
		return data;
	}
}
