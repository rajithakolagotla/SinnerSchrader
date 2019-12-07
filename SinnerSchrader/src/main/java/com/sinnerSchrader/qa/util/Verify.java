package com.sinnerSchrader.qa.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Verify {

	private static Logger logger = Logger.getLogger(Verify.class);
	private static WebElement element;
	private static boolean bStatus;	

	/**
	 * Description: This method is used to verify whether element is displayed on the webpage or not.If the element is displayed it returns True otherwise False
	 *Parameters: WebDriver driver,By locator
	 *return: boolean
	 *Method Name: isElementVisible
	 */

	public static boolean isElementVisible(WebDriver driver,By locator)
	{
		try {
			bStatus = driver.findElement(locator).isDisplayed();
			return bStatus;
		} catch (Exception e) {
			logger.info("Exception raised in verifyElementVisible method"+e.getMessage());
			return false;
		}
	}

	/**
	 * Description: This method is used to verify whether element is enabled on the webpage or not.If the element is enabled it returns True otherwise False
	 *Parameters: WebDriver driver,By locator
	 *return: boolean
	 *Method Name: isElementEnabled
	 */

	public static boolean isElementEnabled(WebDriver driver,By locator)
	{
		try {
			bStatus = driver.findElement(locator).isEnabled();
			return bStatus;
		} catch (Exception e) {
			logger.info("Exception raised in isElementEnabled method"+e.getMessage());
			return false;
		}
	}

	/**
	 * Description: This method is used to verify whether element is selected on the webpage or not.If the element is selected it returns True otherwise False
	 *Parameters: WebDriver driver,By locator
	 *return: boolean
	 *Method Name: isElementSelected
	 */

	public static boolean isElementSelected(WebDriver driver,By locator)
	{
		try {
			bStatus = driver.findElement(locator).isSelected();
			return bStatus;
		} catch (Exception e) {
			logger.info("Exception raised in isElementSelected method"+e.getMessage());
			return false;
		}
	}

	/**
	 * Description: This method is used to verify whether element is present on the webpage or not.If the element is present it returns True otherwise False
	 *Parameters: WebDriver driver,By locator
	 *return: boolean
	 *Method Name: isElementPresent
	 */

	public static boolean isElementPresent(WebDriver driver,By locator)
	{
		try {
			element = driver.findElement(locator);
			if(element != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			logger.info("Exception raised in isElementPresent method"+e.getMessage());
			return false;
		}
	}
}