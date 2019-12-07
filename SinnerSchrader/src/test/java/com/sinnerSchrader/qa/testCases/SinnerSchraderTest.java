package com.sinnerSchrader.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sinnerSchrader.qa.base.TestBase;
import com.sinnerSchrader.qa.pages.BrokenImagesPage;
import com.sinnerSchrader.qa.pages.HorizontalSliderPage;
import com.sinnerSchrader.qa.pages.LoginPage;
import com.sinnerSchrader.qa.pages.UserDetailsPage;
import com.sinnerSchrader.qa.util.Global;
import com.sinnerSchrader.qa.util.TestUtil;

public class SinnerSchraderTest extends TestBase {

	HorizontalSliderPage horizontalSliderPage;
	UserDetailsPage userDetailsPage;
	BrokenImagesPage brokenImagesPage;
	LoginPage loginPage;
	
	public ExtentReports extent;
	public static ExtentTest extentTest;
	public static ITestResult result;

	public SinnerSchraderTest() {
		super();
	}

	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"//Results//sinnerSchraderReport.html", true);
	}

	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}

	
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initilazation();
		horizontalSliderPage = new HorizontalSliderPage(); 
		userDetailsPage = new UserDetailsPage();
		brokenImagesPage = new BrokenImagesPage();
		loginPage = new LoginPage();
	}

	@Test(priority = 0)
	public void brokenImagesTest() throws Exception {
		extentTest = extent.startTest("brokenImagesPagetest");
		Global.bStatus = brokenImagesPage.BrokenImages();
		
		Assert.assertTrue(Global.bStatus);
	}
	@Test(priority = 1)
	public void loginTest() throws Exception {
		extentTest = extent.startTest("loginPagetest");
		Global.bStatus = loginPage.logIn();
		Assert.assertTrue(Global.bStatus);
	}

	@Test(priority = 2)
	public void horizontalSliderTest() throws Exception {
		extentTest = extent.startTest("horizontalSliderPagetest");
		Global.bStatus = horizontalSliderPage.horizontalSlider();
		
		Assert.assertTrue(Global.bStatus);
	}
		@Test(priority = 3)
	public void UserDetailsTest() throws Exception {
		extentTest = extent.startTest("UserDetailsPagetest");
		Global.bStatus = userDetailsPage.viewUserDetails();
		
		Assert.assertTrue(Global.bStatus);
	}
		

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {


		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.SKIP, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
			String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
		}
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
	}
	
	
	
	
	
}
