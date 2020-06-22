package com.crms.testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	
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
	
	
	@DataProvider 
	
	public Object[][] readData() throws Exception
	{
		     Object data[][]= dataProvider.getData();
		     return data;
	}
	
	
	@Test(priority=1, dataProvider= "readData")
	public void data(String userName, String password)
	{
		System.out.println("Username:::"+userName);
		System.out.println("Password:::"+password);
		
	}

}