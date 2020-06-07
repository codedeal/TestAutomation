package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Setup.TestBase;

public class AlertsPage extends TestBase
{
	
	@FindBy(how=How.XPATH,using="//div[@class='main-header']")
	WebElement mainHeader;
	
	 @FindBy(how=How.XPATH,using="//span[text()='Browser Windows']")
	 WebElement browserWindows;
	 
	 @FindBy(how=How.XPATH,using="//button[text()='New Tab' and @id='tabButton']")
	 WebElement newTabButton;
	 @FindBy(how=How.XPATH,using="//button[text()='New Window' and @id='windowButton']")
	 WebElement newWindowButton;
	 @FindBy(how=How.XPATH,using="//button[text()='New Window Message' and @id='messageWindowButton']")
	 WebElement newWindowMessage;
	 
	 @FindBy(how=How.XPATH,using="//span[text()='Alerts']")
	 WebElement alertDropDown;
	 
	 @FindBy(how=How.XPATH,using="//button[@id='alertButton']")
	 WebElement alertButton;
	 
	 @FindBy(how=How.XPATH,using="//button[@id='timerAlertButton']")
	 WebElement alertButtonTimer;
	 
	 @FindBy(how=How.XPATH,using="//button[@id='promtButton']")
	 WebElement alertButtonPromt;
	 
		public AlertsPage() 
		{
			PageFactory.initElements(driver, this);
		}
	
	  public String titleOfPage()
	  {
		  return driver.getTitle();
	  }
	  
	  public void scrollToAlert()
	  {
		  action.scrollToElement(alertDropDown);
		  action.Clickelement(alertDropDown);
	  }
	  
	  public void scrollToBrowserWindow()
	  {
		  action.scrollToElement(browserWindows);
		  action.Clickelement(browserWindows);
	  }
	  
	  public String navigateToNewTab()
	  {
		  action.Clickelement(newTabButton);
		  action.switchWindowHandle();
		  return driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
	  }
	  
	  public String navigateToNewWindow()
	  {
		  action.Clickelement(newWindowButton);
		  action.switchWindowHandle();
		  return driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
	  }
	  
	  public String navigateToNewWindowMessage()
	  {
		  action.Clickelement(newWindowMessage);
		  action.switchWindowHandle();
		  return driver.findElement(By.xpath("/html/body")).getText();
	  }
	  
	  public void openNewTabThrougBrowserWindow()
	  {
		  
	  }
	  public void clickButtonToSeeAlert()
	  {
		  action.Clickelement(alertButton);
	  }
     
	  public void clickButtonToSeeAlertTimer()
	  {
		  action.Clickelement(alertButtonTimer);
	  }
     
	  public void clickButtonToSeeAlertPrompt()
	  {
		  action.scrollToElement(alertButtonPromt);
		  action.Clickelement(alertButtonPromt);
	  }
	  
	  public String objectiveOfPage()
	  {
		  return action.getText(mainHeader);
	  }
}
