package com.sinnerSchrader.qa.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sinnerSchrader.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static Select dropdown;
	public static WebDriverWait wait;
	public static Logger logger = Logger.getLogger("Wait");
	public static String errorMsg = "";
	public static String appErrorMsg = "";

	public static Actions act = new Actions(driver);

	
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	public static void selectDropDown(WebElement element) {
		dropdown = new Select(element);
	}
public static void upload(By locator, String filepath) {
	driver.findElement(locator).sendKeys(filepath);
}

	public static boolean waitForElementPresence(WebDriver wDriver,
			By objLocator, long iTimeout) {
		try {
			wait = new WebDriverWait(wDriver, iTimeout);
			wait.until(ExpectedConditions.presenceOfElementLocated(objLocator));
			logger.info("element " + objLocator + " is present after waiting.");
			return true;
		} catch (Exception e) {
			errorMsg = e.getMessage();
			logger.warn("element " + objLocator
					+ " is not present after waiting " + iTimeout + ".");
		}
		return false;
	}
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	public static boolean switchToWindowByIndex(WebDriver wDriver,
			int iWindowIndex) {
		Set<String> windows = wDriver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		int iSize = windows.size();
		if (iSize > 1) {
			if (iWindowIndex < iSize) {
				String[] arrWin = new String[iSize];
				int inc = 0;
				while (itr.hasNext()) {
					arrWin[inc] = itr.next().toString();
					inc++;
				}
				wDriver.switchTo().window(arrWin[iWindowIndex]);
				return true;
			}
			errorMsg = iWindowIndex
					+ " is greater than windows count " + iSize;
			return false;
		}
		errorMsg = "only one window is available";
		return false;
	}

	
	public static boolean waitForElementVisibility(WebDriver wDriver,
			By objLocator, long iTimeout) {
		try {
			wait = new WebDriverWait(wDriver, iTimeout);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(objLocator));
			logger.info("element " + objLocator + " is visible after waiting.");
			return true;
		} catch (Exception e) {
			errorMsg = e.getMessage();
			logger.warn("element " + objLocator
					+ " is not present after waiting " + iTimeout + " secs.");
		}
		return false;
	}

	
}