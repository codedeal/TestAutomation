package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Setup.TestBase;
import com.Utility.Log;

public class WidgetPage  extends TestBase
{

	@FindBy(how=How.XPATH,using="//span[text()='Slider']")
	WebElement slider;

	@FindBy(how=How.XPATH,using="//div[@class='main-header']")
	WebElement mainHeader;

	@FindBy(how=How.XPATH,using="//*[@id='sliderContainer']/div[1]/span/input")
	WebElement sliderbar;
	
	@FindBy(how=How.XPATH,using="//span[text()='Progress Bar']")
	WebElement progressBar;
	
	@FindBy(how=How.XPATH,using="//*[@id='progressBar']/div")
	WebElement progressBarContainer;
	
	@FindBy(how=How.XPATH,using="//button[@id='startStopButton']")
	WebElement startStopButton;
	
	@FindBy(how=How.XPATH,using="//button[@id='resetButton']")
	WebElement resetButton;

	public WidgetPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public String titleOfPage()
	{
		return driver.getTitle();
	}

	public void selectSlider()
	{
		action.wait(2000);
		action.scrollToElement(slider);
		slider.click();
	}
	
	public void selectProgrssbar()
	{
		action.wait(2000);
		action.scrollToElement(progressBar);
		progressBar.click();
		
	}
	public String getHeaderOfPage()
	{
		return action.getText(mainHeader);
	}
	
	public void setSliderValue(String value)
	{
		if(getSliderCurrentValue()==value)
			return;
		else if(Integer.parseInt(value)>Integer.parseInt(getSliderCurrentValue()))
		{	
			action.navigateSliderForward(sliderbar,Double.parseDouble(value));
			setSliderValue(value);
		
		}else if(Integer.parseInt(value)<Integer.parseInt(getSliderCurrentValue()))
		{
	        	action.navigateSliderBackWard(sliderbar);
				setSliderValue(value);
		}
	
	}
	
	public void setProgressBarValue(String value)
	{
		action.scrollToElementUp(mainHeader, 0);
		startStopButton.click();
		 action.wait(100000000);
		
	    startStopButton.click();
	   
	}

	public String getProgressBarCurrentValue() {
		
		Log.info(progressBarContainer.getAttribute("aria-valuenow"));
		return progressBarContainer.getAttribute("aria-valuenow");
	}

	private String getSliderCurrentValue() {
		
		Log.info(sliderbar.getAttribute("value"));
		return sliderbar.getAttribute("value");
		
	}
}