package com.sinnerSchrader.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.sinnerSchrader.qa.base.TestBase;
import com.sinnerSchrader.qa.testCases.SinnerSchraderTest;
import com.sinnerSchrader.qa.util.GenericActions;
import com.sinnerSchrader.qa.util.Global;

public class LoginPage extends TestBase {
	
	//Page ObjectRepository
		public static By txtAuthmsg = By.xpath("//div[@class= 'example']/p");	

		// Initializing the elements with the help of page factory

	public LoginPage() {
		PageFactory.initElements(driver, this);
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}
	
	/**
	 * Description: This method is used to handle the Basic Auth and verifies the Congratulations msg and print on Extending report.
	 * Keywords: waitForElementVisible, getText
	 * return: boolean	  
	 */
	public boolean logIn() throws InterruptedException, IOException {

		Global.bStatus = GenericActions.waitForElementVisible(driver, txtAuthmsg, Global.timeOut);
		if (Global.bStatus == true) {
			String authMsg = GenericActions.getText(driver, txtAuthmsg, Global.timeOut);
			if(authMsg.contains("Congratulations")) {
			SinnerSchraderTest.extentTest.log(LogStatus.INFO, " Basic Auth is successfull : "+authMsg);
			}
			
			return true;
		}
				
		else {
			SinnerSchraderTest.extentTest.log(LogStatus.INFO, " Basic Auth is not successfull ");

		}
		return true;
		}
	
}
