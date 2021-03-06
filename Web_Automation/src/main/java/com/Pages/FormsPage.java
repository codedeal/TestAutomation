package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Setup.TestBase;
import com.Utility.Log;

public class FormsPage extends TestBase
{
	 @FindBy(how=How.XPATH,using="//div[contains(@class,'col-md-6') and contains(text(),'Please')]")
	 WebElement headingOfPage;
	 
	 @FindBy(how=How.XPATH,using="//*[@id='app']/div/div/div[2]/div[1]/div/div/div[2]/span/div/div[2]/div[2]")
	 WebElement seperatoricon;
	 @FindBy(how=How.XPATH,using="//span[text()='Practice Form']")
	 WebElement practiceForm;
	 
	 @FindBy(how=How.XPATH,using="//input[@id='firstName']")
	 WebElement firstName;
	 @FindBy(how=How.XPATH,using="//input[@id='lastName']")
	 WebElement lastName;
	 @FindBy(how=How.XPATH,using="//input[@id='userNumber']")
	 WebElement mobileNumber;
	 @FindBy(how=How.XPATH,using="//input[@id='userEmail']")
	 WebElement userEmail;
	 
	 @FindBy(how=How.XPATH,using="//input[@id='subjectsInput']")
	 WebElement userSubjects;
	 
	 @FindBy(how=How.XPATH,using="//textarea[@id='currentAddress']")
	 WebElement currentAddress;
	 
	 @FindBy(how=How.XPATH,using="//button[@id='submit']")
	 WebElement submit;
	  public FormsPage() {
			// TODO Auto-generated constructor stub
			  PageFactory.initElements(driver, this);
			  
		   }
	  
	  
	  
	  
	  public String titleOfPage()
	  {
		  return driver.getTitle();
	  }
     
	  public String objectiveOfPage()
	  {
		  return action.getText(headingOfPage);
	  }
	  
	  public void SwitchToPracticeForm()
	  {
		  action.Clickelement(seperatoricon);
		  action.Clickelement(practiceForm);
	  }
	  
	  public void fillthePerform()
	  {
		  Log.info("Input user Data");
		  action.setText(firstName, "Ram");
		  action.setText(lastName, "Singh");
		  action.setText(userEmail, "Ram456@gmail.com");
		  action.setText(mobileNumber, "4567890");
		  action.setText(currentAddress, "abc 123 Bangalore");
		  action.scrollToElement();
		  Log.info("finished Inputing User data");
		  action.Clickelement(submit);
	  }
	  
	  
}
