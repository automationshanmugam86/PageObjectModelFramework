package com.crms.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserInitialization extends TestBase {
	
	public BrowserInitialization()
	{
		
	}
	
	public static void browserInitialization()
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:/JarFilesDownload/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "F:/JarFilesDownload/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		//webdriver instance waits for 10 or 20 seconds for every page to get loaded 
		//before throwing exeption. If the page is not loaded in 20 seconds of time,
		//then it throws TimedoutException at runtime.
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		//implicit wait 
		
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
		
		driver.get(url);
		
		
		
	}

}
