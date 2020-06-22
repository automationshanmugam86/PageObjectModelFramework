package com.crms.testScripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crms.base.BrowserInitialization;
import com.crms.base.TestBase;
import com.crms.pages.HomePage;
import com.crms.pages.LoginPage;
import com.crms.utils.CommonUtils;

public class LoginPageTest extends TestBase{
	
	private static Logger log = Logger.getLogger(LoginPageTest.class);
	
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp()
	{
		BrowserInitialization.browserInitialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginPage.checkLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		log.info("Login Test First test case executed");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest()
	{
	boolean flag=loginPage.checkCrmImage();
	Assert.assertTrue(flag);
	log.info("Login Second First test case executed");
	}
	
	@DataProvider                                     
    
	public Object[][] readData() throws Exception     
	{                                                 
		     Object data[][]= CommonUtils.getData(); 
		     return data;                             
	}                                                 
	
	
	@Test(priority=3, dataProvider="readData")
	public void loginTest(String username, String password)
	{
		homePage = loginPage.Login(username, password);
		log.info("Login Test Third test case executed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
