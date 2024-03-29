package com.sinnerSchrader.qa.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.sinnerSchrader.qa.base.TestBase;
import com.sinnerSchrader.qa.testCases.SinnerSchraderTest;
import com.sinnerSchrader.qa.util.GenericActions;
import com.sinnerSchrader.qa.util.Global;

public class BrokenImagesPage extends TestBase {

	//Page ObjectRepository
	public static By imgCount = By.tagName("img");	

	// Initializing the elements with the help of page factory
	public BrokenImagesPage() {
		PageFactory.initElements(driver, this);
		driver.get(prop.getProperty("brokenImagesUrl"));

	}

	/**
	 * Description: This method is used to identify the Broken Images 
	 * It asserts the total number of images and verifies Broken Images and print on Extending report.
	 * Keywords: getWebElements, getResponseCode,getAttribute
	 * return: boolean	  
	 */
	public boolean BrokenImages() {
		List<WebElement> imagesList = GenericActions.getWebElements(imgCount, driver, Global.timeOut);
		SinnerSchraderTest.extentTest.log(LogStatus.INFO, "Total number of Images on page: "+imagesList.size());
		try {
			for (WebElement ele : imagesList) {

				HttpURLConnection conn = (HttpURLConnection) new URL(ele.getAttribute("src")).openConnection();
				conn.setRequestMethod("GET");
				int responceCode = conn.getResponseCode();
				if (responceCode != 200) {
					SinnerSchraderTest.extentTest.log(LogStatus.INFO, ele.getAttribute("src")+" is the Broken Image");

				} 
				else {
					SinnerSchraderTest.extentTest.log(LogStatus.INFO, ele.getAttribute("src")+" is the Normal Image");
				}

			}
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;

		}

	}
}

