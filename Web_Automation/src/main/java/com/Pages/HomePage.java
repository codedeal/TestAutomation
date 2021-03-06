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
	 
	// @FindBy(how=How.XPATH,using="//div[@class='card-body']/h5[text()='Forms']//parent::div")
	 @FindBy(how=How.XPATH,using="//*[@id='app']/div/div/div[2]/div/div[2]/div/div[2]")
	 WebElement forms;
	 @FindBy(how=How.XPATH,using="//*[@id='app']/div/div/div[2]/div/div[4]/div/div[1]")
	 WebElement widgets;
	 @FindBy(how=How.XPATH,using="//*[@id='app']/div/div/div[2]/div/div[1]/div/div[2]")
	 WebElement elementsDrop;
	 @FindBy(how=How.XPATH,using="//*[@id='app']/div/div/div[2]/div/div[3]")
	 WebElement alertsPage;
	 
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
	  
	  public FormsPage naviageteToFormsPage()
	  {
		  log.info("navigate to Forms Page");
		  action.scrollToElement();
		  action.Clickelement(forms);
		  return new FormsPage();
	  }
	  
	  public WidgetPage naviageteToWidgetPage()
	  {
		  log.info("navigate to Widget Page");
		  action.scrollToElement();
		  action.Clickelement(widgets);
		  return new WidgetPage();
	  }
	  
	  public ElementsPage naviageteToElementssPage()
	  {
		  log.info("navigate to Elements Page");
		//  action.scrollToElement();
		  action.Clickelement(elementsDrop);
		  return new ElementsPage();
	  }
	  
	  public AlertsPage naviageteToAlertsPage()
	  {
		  log.info("navigate to Alerts Page");
		  action.scrollToElement();
		  action.Clickelement(alertsPage);
		  return new AlertsPage();
	  }
}
