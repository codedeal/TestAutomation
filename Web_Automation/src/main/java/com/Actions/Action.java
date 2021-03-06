package com.Actions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Setup.TestBase;

public class Action extends TestBase
{
	Actions action ;
	WebDriver driver;
	
	public Action(WebDriver driver)
	{
		this.driver=driver;
		action = new Actions(driver);
		
	}
  
     
	public  void draganddrop(WebElement source, WebElement destination)
	{
		wait(10);
		action.dragAndDrop(source, destination).build().perform();
		
	}
	
	public void doubleClick(WebElement element)
	{
		action.doubleClick(element).perform();
	}
	
	public void rightClick(WebElement element)
	{
		action.contextClick(element).perform();
	}
	
	public void Clickelement(WebElement element)
	{
		element.click();
	}
	
	public String getText(WebElement element)
	{
		return element.getText();
	}
	

	
	public void setText(WebElement element, String Text)
	{
		element.sendKeys(Text);
	}
	
	public void switchWindowHandle()
	{
		Set handles = driver.getWindowHandles();
		 
        System.out.println(handles);

        // Pass a window handle to the other window

        for (String handle1 : driver.getWindowHandles()) {

         System.out.println(handle1);

         driver.switchTo().window(handle1);

         }
	}
	
	public int numberOfIFrame()
	{
		 JavascriptExecutor exe = (JavascriptExecutor) driver;
		 Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		 System.out.println("Number of iframes on the page are " + numberOfFrames);
		 return numberOfIFrame();
	}
	
	public int numberOfIFrameByTag()
	{
		//By finding all the web elements using iframe tag
		 List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		 System.out.println("The total number of iframes are " + iframeElements.size());
		 return iframeElements.size();
	}
	
	public void switchToFrame(int frameNumber)
	{
		driver.switchTo().frame(frameNumber);
	}
	
	public void switchToFrame(String frameNameOrId)
	{
		driver.switchTo().frame(frameNameOrId);
	}
	
	public void switchToFrame(WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	public void frametoWebPage()
	{
		driver.switchTo().defaultContent();
	}
	
	public void acceptAlertOK()
	{
		driver.switchTo().alert().accept();
	}
	
	public void scrollToElement(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);	
	}
	
	public void scrollToElement(WebElement element,int index)
	{
		while(!element.isDisplayed())
		{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250)");
		}
	}
	public void scrollToElementUp(WebElement element,int index)
	{
		while(!element.isDisplayed())
		{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, -150)");
		}
	}
	
	public String getAttributeData(WebElement element)
	{
		return element.getAttribute("title"); 
	}
	
	public void setDateAndTime(int day, int month,int year)
	{
		
	}
	
	public void moveSlider(WebElement element)
	{
		action.dragAndDropBy(element, 30, 0).build().perform();
	}
	
	public void moveDialogBox()
	{
		
	}
	
	public void pressEnter(WebElement element)
	{
		element.sendKeys(Keys.ENTER);
	}
	
	public void scrollToElement()
	{
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
	}


	public void dragAndDrop(WebElement resizeElement, int i, int j) 
	{
		action.dragAndDropBy(resizeElement, 100, 100).perform();;
		
	}
	
	public void navigateSliderForward(WebElement slider,double value)
	{
		   double minValue = Double.parseDouble(slider.getAttribute("min"));
		    double maxValue = Double.parseDouble(slider.getAttribute("max"));
		    int sliderH = slider.getSize().height;
		    int sliderW = slider.getSize().width;
		    System.out.println(sliderH);
		    System.out.println(sliderW);
		  //  action.moveToElement(slider, (int) (value * sliderW / (maxValue - minValue)), sliderH / 2).click().build().perform();
		//action.dragAndDropBy(slider, (int) (value * sliderW / (maxValue - minValue)), 0).perform();
	    action .clickAndHold(slider).moveByOffset(99,0).release().perform();  
	}
	public void navigateSliderBackWard(WebElement slider)
	{
		//action.dragAndDropBy(slider, -1, 0).perform();
		// action .clickAndHold(slider).moveByOffset(-5,0).release().perform();  
		 int PixelsToMove = GetPixelsToMove(slider, 2, 100, 0);
		 action.clickAndHold(slider).moveByOffset((-(int)(slider.getSize().width/2)), 0).moveByOffset(PixelsToMove, 0).release().perform();
	}
	
	public static int GetPixelsToMove(WebElement Slider, int Amount, int SliderMax, int SliderMin)
    {
        int pixels = 0;
        double tempPixels = Slider.getSize().width;
        tempPixels = tempPixels / (SliderMax - SliderMin);
        tempPixels = tempPixels * (Amount - SliderMin);
        pixels = (int)(tempPixels);
        return pixels;
    }
   
	public String getalertText()
	{
		return driver.switchTo().alert().getText();
	}
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndSendData(String data)
	{
		driver.switchTo().alert();
		driver.switchTo().alert().sendKeys(data);
	}
	
	public String getDataSwtInAlertPrompt()
	{
		return (String) ((JavascriptExecutor) driver).executeScript("return window.promptResponse");
	}
}
