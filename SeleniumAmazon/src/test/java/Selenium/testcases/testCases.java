package Selenium.testcases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import Selenium.drivers.webdriver;
import Selenium.pages.homePage;
import Selenium.pages.login.login;
import Selenium.pages.login.signup;
import Selenium.pages.login.validate_OTP;
import Selenium.utilities.utility;

public class testCases {
	static WebDriver driver;
	
	@BeforeClass
	public static WebDriver initialize(){		
		driver=webdriver.setUp();
		return driver;
	}
	
	@Test(priority=1)
	public static void TC_01_Verify_AmazonApplicationIsLaunched() {
		try {
			utility.handleExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage.verifyUserIsOnHomePage(driver);
	}
	
	@Test(priority=2)
	public static void TC_02_Verify_UserShouldContinueOnSignUpPage() {
		//try {
			//String mobileNumber = utility.handleExcel();
			String mobileNumber="6353292862";
			login.ClickSignInLinkAndContinueOnSignUpPage(driver,mobileNumber);
		}/*catch 	(IOException e) {
			e.printStackTrace();
		}
	}*/
	
	@Test(priority=3)
	public static void TC_03_Verify_UserShouldContinueOnOTPPage() {
		try {
			String mobileNumber = utility.handleExcel();
			String yourName = utility.handleExcel();
			String password = utility.handleExcel();
			login.ClickSignInLinkAndContinueOnSignUpPage(driver,mobileNumber);
			signup.enterDetailsOnSignUpPage(driver,"6353292862","Vijay","Test@123");
			//signup.enterDetailsOnSignUpPage(driver,mobileNumber,yourName,password);	
		}catch 	(IOException e) {
			e.printStackTrace();
		}
	}
		
}