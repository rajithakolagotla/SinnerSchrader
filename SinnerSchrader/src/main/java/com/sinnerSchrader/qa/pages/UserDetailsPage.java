package com.sinnerSchrader.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.sinnerSchrader.qa.base.TestBase;
import com.sinnerSchrader.qa.testCases.SinnerSchraderTest;
import com.sinnerSchrader.qa.util.GenericActions;
import com.sinnerSchrader.qa.util.Global;

public class UserDetailsPage extends TestBase {
	//Page ObjectRepository
	public static By imgUsers = By.xpath("//div[@class = 'example']/div");	
	public static By viewProfile = By.xpath("//h1");

	// Initializing the elements with the help of page factory
	public UserDetailsPage() {
		PageFactory.initElements(driver, this);
		driver.get(prop.getProperty("UserDetailsUrl"));

	}

	/**
	 * Description: This method is used to  mouseover on pictures and get the user details and view the user profile by clicking on View Profile link
	 * It asserts the number of users and user details(Name) and print on Extending report.
	 * Keywords: getWebElements, waitForElementVisible,getText
	 * return: boolean	  
	 */

	public boolean viewUserDetails() throws IOException {
		try {
			driver.get(prop.getProperty("UserDetailsUrl"));

			List<WebElement> usersList = GenericActions.getWebElements(imgUsers, driver, Global.timeOut);
			System.out.println(usersList.size());

			for(int i=1; i<=usersList.size();i++ ) {
				System.out.println(usersList);
				Global.bStatus = GenericActions.waitForElementVisible(driver, imgUsers, Global.timeOut);
				System.out.println(Global.bStatus);
				Actions act = new Actions(driver);
				WebElement ele = driver.findElement(By.xpath("//div[@class = 'example']/div["+i+"]"));
				System.out.println("viewUserDetails");
				act.moveToElement(ele).click().build().perform();
				String userName  = driver.findElement(By.xpath("//div[@class = 'example']/div["+i+"]/div/h5")).getText();
				SinnerSchraderTest.extentTest.log(LogStatus.INFO, "User"+i+" : "+userName);
				driver.findElement(By.xpath("//div[@class = 'example']/div["+i+"]/div/a")).click();
				String UserDetails = GenericActions.getText(driver, viewProfile, Global.timeOut);
				if(UserDetails.contains("Not Found")) {
					SinnerSchraderTest.extentTest.log(LogStatus.INFO, "User"+i+" : "+UserDetails);
					driver.navigate().back();
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
