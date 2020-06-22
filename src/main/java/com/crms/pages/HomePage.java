package com.crms.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crms.base.TestBase;

public class HomePage extends TestBase{
	
	
	//we are using page factory to declare page objects for HomePage
	//Ignoring driver.findElement(By.Xpath) and implementing @FindBy
	
	@FindBy(xpath="//div[contains(text(), 'Contacts activity stream')]")
	WebElement homePageText;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement calendarLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath ="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//constructor of Homepage is called to initialize page objects
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Methods of the HomePage
	
	public boolean checkHomePageExists()
	{
		return homePageText.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public CalendarPage clickOnCalendarLink()
	{
		calendarLink.click();
		return new CalendarPage();
	}

	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}
}
