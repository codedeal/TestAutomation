package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Setup.TestBase;

public class DroppablePage  extends TestBase
{
	 @FindBy(how=How.XPATH,using="//div[@id='draggable']")
	 WebElement source;
	 @FindBy(how=How.XPATH,using="//div[@id='droppable']")
	 WebElement destination;
	public DroppablePage() {
		// TODO Auto-generated constructor stub
		  PageFactory.initElements(driver, this);
	}
	
	public void dragDrop()
	{
		log.info("doing drag and drop");
		action.draganddrop(source, destination);
	}
}
