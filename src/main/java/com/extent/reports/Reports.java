package com.extent.reports;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crms.base.TestBase;
import com.crms.utils.CommonUtils;






public class Reports implements ITestListener {

	
	//private static ExtentReports extent;
	
	static String fileName = CommonUtils.getTimeStamp();
	
	private static ExtentReports extent = Reports.createInstance(System.getProperty("user.dir")+ "\\TestReports\\"+fileName+ ".html");
	
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	

	public void onTestStart(ITestResult result) {

	
		ExtentTest test = extent.createTest(result.getTestClass().getName()+"Executing Test Cases of: "+result.getMethod().getMethodName());
        testReport.set(test);
        

	}

	public void onTestSuccess(ITestResult result) {

		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
		

	}

	public void onTestFailure(ITestResult result) {

	
		
		
		String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception occured during Execution:to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		
		try {

			CommonUtils.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Failure Screenshot" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(CommonUtils.screenshotName)
							.build());
		} catch (IOException e) {

		}
		
		String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);

	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		

	}

	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}

	}
	
	public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(fileName);
        htmlReport.config().setTheme(Theme.STANDARD);
        htmlReport.config().setDocumentTitle(fileName);
        htmlReport.config().setEncoding("utf-8");
        htmlReport.config().setReportName(fileName);
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReport);
        extent.setSystemInfo("Automation Tester", "Shanmugam");
        extent.setSystemInfo("Organization", "QACreators");
        extent.setSystemInfo("Build no", "version 1.0");
        
        
        return extent;
    }
}
