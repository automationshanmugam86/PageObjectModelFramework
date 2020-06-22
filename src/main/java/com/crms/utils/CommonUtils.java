package com.crms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crms.base.TestBase;

public class CommonUtils extends TestBase {
	
	//public static String screenshotPath;
	public static String screenshotName;
	
	public static Object[][] getData() throws Exception                                        
	{                                                                                          
     String path="F:\\AllFrameworks\\CRMTEST\\src\\main\\resources\\TestData\\TestData.xlsx";  
     FileInputStream excelFile = new FileInputStream(path);                                    
     XSSFWorkbook excelWBook = new XSSFWorkbook(excelFile);                                    
     XSSFSheet excelWsheet = excelWBook.getSheet("LoginDataUser");                             
     //totalNumberof row count                                                                 
     int totalRowCount = excelWsheet.getLastRowNum();                                          
     //totalNumberof COlumn count                                                              
     int totalColCount = excelWsheet.getRow(0).getLastCellNum();                               
                                                                                               
     Object[][] testData = new Object[totalRowCount][totalColCount];                           
                                                                                               
     for(int x=0;x<totalRowCount;x++)                                                          
     {                                                                                         
    	 for(int z=0;z<totalColCount;z++)                                                      
    	 {                                                                                     
    		 testData[x][z]=excelWsheet.getRow(x+1).getCell(z).toString();                     
    	 }                                                                                     
     }                                                                                         
   return testData;                                                                            
 }             
	
	public static void captureScreenshot() {

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileName = CommonUtils.getTimeStamp();
		screenshotName = fileName+ ".jpg" ;
		//screenshotName = CommonUtils.getTimeStamp();
        try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\TestReports\\"+screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	
	
	  public static String getTimeStamp(){
			Date date = new Date();
			String timeStampString = DateFormat.getDateTimeInstance(
		            DateFormat.MEDIUM, DateFormat.SHORT).format(date)
					.replace(" ", "_")
					.replace(",", "")
					.replace(":", "_");
			return timeStampString;
		}

	
		

}
