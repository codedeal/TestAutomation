package com.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Setup.TestBase;

public class SortablePage  extends TestBase
{
	 @FindBys({ @FindBy(how=How.XPATH,using="//*[@id='sortable']/descendant::span")})
	 List<WebElement> listOfitems;
	 
	 @FindBy(how=How.XPATH,using="//*[@id='sortable']/descendant::span[7]")
	 WebElement elementIndexLast;
	 @FindBy(how=How.XPATH,using="//*[@id='sortable']/descendant::span[1]")
	 WebElement elementIndexFirst;
	public SortablePage() {
		// TODO Auto-generated constructor stub
		  PageFactory.initElements(driver, this);
	}
	
	public void printListOfItem()
	{
		for (WebElement item : listOfitems) 
		{
			log.info(item.getText());
			
		}
	}
	public void sortinDescendingOrder()
	{
		log.info(elementIndexLast.getText());
		log.info(elementIndexFirst.getText());
		
		action.draganddrop(elementIndexLast, elementIndexFirst);
	}
}
