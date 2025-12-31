package Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;

public class ExtentReport extends BaseClass implements ITestListener{
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/MyExtentReport.html");
		sparkreporter.config().setDocumentTitle("Automtion Test Report");
		sparkreporter.config().setReportName("Extent reports");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		extent.setSystemInfo("Host Name", "Local Name");
		extent.setSystemInfo("Environment", "QA team");
		extent.setSystemInfo("Tester Name", "Asmit");
		extent.setSystemInfo("OS", "Windows11");
		extent.setSystemInfo("Browser Name", "Chrome");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test case Passes is: "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed is:" + result.getName());
		test.log(Status.FAIL, "Test Case Failed cause is:" + result.getThrowable());

        String testName = result.getName();
        try {
			Screenshot.takeScreenshot(driver, testName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test= extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped is: "+result.getName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}	
}
