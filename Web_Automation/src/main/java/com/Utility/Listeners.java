package com.Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Setup.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listeners extends TestBase implements ITestListener
{
	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"/Reports/extent.html");
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {

		ExtentTest test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
        testReport.set(test);
		log.info("Test Started   "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {

		log.info("Test Succeded   "+result.getName());
	}

	public void onTestFailure(ITestResult result) {

		log.error("Test Failed  "+result.getName());
	}

	public void onTestSkipped(ITestResult result) {


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	public void onStart(ITestContext context) {


		System.out.println("This is onStart method  " +context.getOutputDirectory());

	}

	public void onFinish(ITestContext context) {

		log.info("This is onFinish method  " +context.getPassedTests());
		log.info("This is onFinish method  " +context.getFailedTests());
	}


}
