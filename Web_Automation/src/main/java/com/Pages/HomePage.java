package com.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import com.Setup.TestBase;

public class HomePage extends TestBase
{
	 @FindBy(how=How.XPATH,using="//a[text()='Sortable']")
	 WebElement sortTable;
	 @FindBy(how=How.XPATH,using="//a[text()='Droppable']")
	 WebElement droppable;
	 @FindBy(how=How.XPATH,using="//a[text()='Draggable']")
	 WebElement dragable;
	 @FindBy(how=How.XPATH,using="//a[text()='Selectable']")
	 WebElement selectable;
	 @FindBy(how=How.XPATH,using="//a[text()='Resizable']")
	 WebElement resizable;
	 
	  public HomePage() {
		// TODO Auto-generated constructor stub
		  PageFactory.initElements(driver, this);
		  
	   }
      
	  public SortablePage naviageteToSortablePage()
	  {
		  log.info("navigate to Sortable Page");
		  action.Clickelement(sortTable);
		  return new SortablePage();
	  }
      
	  public DroppablePage naviageteToDroppablePage()
	  {
		  log.info("navigate to Droppable Page");
		  action.Clickelement(droppable);
		  return new DroppablePage();
	  }
	  
	  public DraggablePage naviageteToDraggablePage()
	  {
		  log.info("navigate to Draggable Page");
		  action.Clickelement(dragable);
		  return new DraggablePage();
	  }
	  
	  public ResizablePage naviageteToResizablePage()
	  {
		  log.info("navigate to Resiszable Page");
		  action.Clickelement(resizable);
		  return new ResizablePage();
	  }
	  
	  public SelectablePage naviageteToSelectablePage()
	  {
		  log.info("navigate to Selectable Page");
		  action.Clickelement(selectable);
		  return new SelectablePage();
	  }
}
