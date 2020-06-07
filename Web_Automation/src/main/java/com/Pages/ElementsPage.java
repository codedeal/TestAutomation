package com.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Setup.TestBase;

public class ElementsPage  extends TestBase
{
	 @FindBy(how=How.XPATH,using="//*[@id='app']/div/div/div[2]/div[1]/div/div/div[1]/span/div/div[1]/span")
	 WebElement elementsDropDown;
	 
	 @FindBy(how=How.XPATH,using="//span[text()='Check Box']")
	 WebElement checkBox;
	 
	 @FindBy(how=How.XPATH,using="//div[@class='main-header']")
		WebElement mainHeader;
	 
	 @FindBy(how=How.XPATH,using="//*[@id='tree-node']/ol/li/span/button")
	 WebElement homeButtonArrow;
	 
	 @FindBy(how=How.XPATH,using="//*[@id='tree-node']/ol/li/ol/li[2]/span/button")
	 WebElement documentButtonArrow;
	 
	 @FindBy(how=How.XPATH,using="//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/span/label/span[1]")
	 WebElement officeCheckBox;
	 
	 @FindBy(how=How.XPATH,using="//*[@id='result']/span")
	 List<WebElement> result;
	 
	public ElementsPage()
	{
		  PageFactory.initElements(driver, this);
	}
	
	public String titleOfPage()
	{
		return driver.getTitle();
	}
	
	public void openElementsDropDown()
	{
		action.Clickelement(elementsDropDown);
	}
	
	public void selectCheckBoxItemInElement()
	{
		action.scrollToElement(checkBox);
		action.Clickelement(checkBox);
	}
	public String getHeaderOfPage()
	{
		return action.getText(mainHeader);
	}
	
	public void clickHomeButtonArrow()
	{
		homeButtonArrow.click();
	}
	
	public void clickDocumentButtonArrow()
	{
		documentButtonArrow.click();
	}
	
	public void officeCheckBox()
	{
		officeCheckBox.click();
	}
	
	public String printResult()
	{
		String res="";
		for(WebElement ele:result)
		{
			res+=ele.getText();
		}
		return res;
	}
}
