package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Setup.TestBase;

public class ResizablePage  extends TestBase
{
	 @FindBy(how=How.XPATH,using="//div[contains(@class,'ui-icon-gripsmall-diagonal-se')]")
	 WebElement resizeElement;
	public ResizablePage() {
		// TODO Auto-generated constructor stub
		  PageFactory.initElements(driver, this);
	}
	
	public void resizeTheBox()
	{
	      action.dragAndDrop(resizeElement, 100, 50);
	}
}
