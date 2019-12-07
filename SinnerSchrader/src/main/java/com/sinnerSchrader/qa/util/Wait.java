package com.sinnerSchrader.qa.util;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	private static WebDriverWait wait = null;
	private static Logger logger = Logger.getLogger(Wait.class);
	private static WebElement element;
	/**
	 * Description: This method is used to wait until element is visible on given time wait.If the element is visible in given time it returns True otherwise False
	 *Parameters: WebDriver driver,By locator,int timeOut
	 *return: boolean
	 *Method Name: waitForElementVisible
	 */

	public static boolean waitForElementVisible(WebDriver driver,By locator,int timeOut)
	{
		try {
			wait = new WebDriverWait(driver, timeOut);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			if(element != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			logger.info("Exception raised in waitForElementVisible method"+e.getMessage());
			return false;
		}
	}

	/**
	 * Description: This method is used to wait until element is clickable on given time wait.If the element is clickable in given time it returns True otherwise False
	 *Parameters: WebDriver driver,By locator,int timeOut
	 *return: boolean
	 *Method Name: waitForElementClickable
	 */

	public static boolean waitForElementClickable(WebDriver driver,By locator,int timeOut)
	{
		try {
			wait = new WebDriverWait(driver, timeOut);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			if(element != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			logger.info("Exception raised in waitForElementClickable method"+e.getMessage());
			return false;
		}
	}

	/**
	 * Description: This method is used to wait until page is loaded. It returns true if page is loaded completely otherwise false
	 *Parameters: WebDriver driver,int timeOut
	 *return: boolean
	 *Method Name: waitForPageLoad
	 */
	public static boolean waitForPageLoad(WebDriver driver,int timeWait)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			for (int i=1; i<timeWait; i++){ 
				try {
					if (js.executeScript("return document.readyState").toString().equals("complete")){ 
						return true;
					}
				}catch (Exception e) {
					continue;
				} 
			}
			return false;
		}
		catch(Exception ex)
		{
			logger.info("Exception Raised in waitForPageLoad method:"+ex.getMessage());
			return false;
		}
	}

	/**
	 * Description: This method is used to wait until given timeout
	 *Parameters: int timeOut
	 *Method Name: wait
	 */
	public static void wait(int timeWait)
	{
		try
		{
			Thread.sleep(timeWait*1000);
		}
		catch(Exception ex)
		{
			logger.info("Exception in wait method"+ex.getMessage());
		}
	}
	/**
	 * Description: This method is used to wait until element is invisible in given timeout. It returns true if element is invisible otherwise false
	 *Parameters: WebDriver driver,By objLocator,int timeWait
	 *Method Name: waitForElementInvisibility
	 */
	public static boolean waitForElementInvisibility(WebDriver driver,By locator,int timeWait)
	{
		try
		{
			for(int i = 1; i <= timeWait ; i++)
			{
				Wait.wait(1);
				boolean bStatus = Verify.isElementVisible(driver,locator);
				if(!bStatus)
					return true;
			}
			return false;
		}
		catch(Exception ex)
		{
			logger.info("Exception raised in waitForElementInvisibility method"+ex.getMessage());
			return false;
		}
	}
	
	/**
	 * Description: This method is used to wait until element is present in given timeout. It returns true if element is present otherwise false
	 *Parameters: WebDriver driver,By objLocator,int timeWait
	 *Method Name: waitForElementPresent
	 */
	public static boolean waitForElementPresent(WebDriver driver,By locator,int timeWait)
	{
		try
		{
			wait = new WebDriverWait(driver, timeWait);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			if(element != null)
				return true;
			else
				return false;
		}
		catch(Exception ex)
		{
			logger.info("Exception raised in waitForElementPresent method"+ex.getMessage());
			return false;
		}
	}
}