package com.FreeCRM.Report_Generation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport_Generation extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void extentReportSetup() {
		//location of the extent report
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname = "FreeCRM - TestReport"+timeStamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" +repname);
		htmlReporter.loadConfig(System.getProperty("user.dir") + "/extent-config.xml");

		htmlReporter.config().setDocumentTitle("FreeCRM Application Automation Report"); // Tittle of Report
		htmlReporter.config().setReportName("Functional Test Automation Extent Report V4"); // Name of the report

		htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report

		// General information releated to application
		extent = new ExtentReports();  //create object of ExtentReports
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Application Name", "FreeCRM - Application");
		extent.setSystemInfo("User Name", "Mallanagoud");
		extent.setSystemInfo("Envirnoment", "TEST-ENV");
	}

	public void onTestSuccess(ITestResult reult)
	{
		test  = extent.createTest(reult.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(reult.getName(), ExtentColor.GREEN));	
	}
	public void onTestSkipped(ITestResult reult)
	{
		test  = extent.createTest(reult.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(reult.getName(), ExtentColor.ORANGE));	
	}

	public void onTestFailure(ITestResult reult)
	{
		test  = extent.createTest(reult.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(reult.getName(), ExtentColor.RED));

		String screenshotpath = System.getProperty("user.dir") + "\\ScreenShots\\" +reult.getName()+ ".png" ;

		File file = new File(screenshotpath);

		if (file.exists())
		{
			try 
			{
				test.fail("Screenshot is Below : - "+test.addScreenCaptureFromPath(screenshotpath));
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}	
		}	
	}

	//		public void onFinish(ITestContext context)
	//		{
	//			extent.flush();	
	//			extent.close();
	//		}
}
//	public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
//		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//
//		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
//		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
//		File finalDestination = new File(destination);
//		FileUtils.copyFile(source, finalDestination);
//		return destination;
//}

