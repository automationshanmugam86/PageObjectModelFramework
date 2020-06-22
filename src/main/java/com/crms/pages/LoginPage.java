package com.crms.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crms.base.TestBase;

public class LoginPage extends TestBase{
	
	
	// we are using page factory to declare Page Objects for Login Page
	//Ignoring driver.findElement(By.xpath()) and implementing @FindBy
	
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[1]/div/a/span[2]")
	WebElement crmlogo;
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement login;
	
	@FindBy(name="email")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath= "//div[contains(text(), 'Login')]")
	WebElement LoginButton;
	
	//constructor of LoginPage is called to initialize the page objects
	
	public LoginPage()
	{
	
     PageFactory.initElements(driver,this);
	}
	
	//Login Page Methods
	
	public String checkLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public boolean checkCrmImage()
	{
		return crmlogo.isDisplayed();
	}
	

	public HomePage Login(String uname, String pword)
	{
		login.click();
		userName.sendKeys(uname);
		Password.sendKeys(pword);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",LoginButton);
		return new HomePage();
		
	}
	
	
	
}
