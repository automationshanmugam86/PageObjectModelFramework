package com.crms.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crms.base.BrowserInitialization;
import com.crms.base.TestBase;
import com.crms.pages.CalendarPage;
import com.crms.pages.HomePage;
import com.crms.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	CalendarPage calendarPage;
	
	@BeforeMethod
	
	public void setUp()
	{
		BrowserInitialization.browserInitialization();
		loginPage = new LoginPage();
		homePage= loginPage.Login(username, password);
		
	}
	
	@Test(priority=1)
	public void verifyHomePageText() throws Exception
	{
		int num1 = 0;
        int num2 = 62 / num1;
		Assert.assertTrue(homePage.checkHomePageExists());
		
	}
	
	//@Test(priority=2)
	
	public void verifyCalendarLink()
	{
		calendarPage = homePage.clickOnCalendarLink();
	}
	

	@AfterMethod
	public void tearDown()
	{
     driver.quit();		
	}
}
