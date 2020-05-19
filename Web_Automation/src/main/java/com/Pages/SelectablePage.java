package com.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Setup.TestBase;

public class SelectablePage extends TestBase
{
	@FindBys( @FindBy(how = How.XPATH, using = "//li[contains(@class,'ui-widget')]"))
	private List<WebElement> itemList;
  public SelectablePage() 
  {
	// TODO Auto-generated constructor stub
	  PageFactory.initElements(driver, this);
  }
  
  public void selectItemandPrintName(int index)
  {
	  log.info("select item "+index);
	  itemList.get(index).click();
	  
  }
}
