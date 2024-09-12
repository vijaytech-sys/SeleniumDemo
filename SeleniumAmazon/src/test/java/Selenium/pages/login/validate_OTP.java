package Selenium.pages.login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Selenium.drivers.seleniumDriver;

import org.openqa.selenium.By;

public class validate_OTP {
	static String verifyMobileNumber_title_xpath="//*[contains(text(), 'Verify mobile number')]";
	static String enterOTP_txt_xpath="//*[@id='auth-pv-enter-code']";
	static String createYourAmazonAccount_btn_xpath="//*[@id='auth-verify-button']";
	
	
	///******* Validation Block *********//////
	public static void verify_mobileNumberTitleOnVerificationPage(WebDriver driver) {
		/*WebElement element=driver.findElement(By.xpath(verifyMobileNumber_title_xpath));
		if (element.getText().contains("Verify mobile number")) {
			System.out.println("Verify Mobile Number Title is present on Verification Page.");
		}*/
		seleniumDriver.validateTextDisplayed(driver, verifyMobileNumber_title_xpath, "xpath", "Verify mobile number","Verify Mobile Number Title is present on Verification Page.");
	}
	
	public static void enter_OTPOnVerificationPage(WebDriver driver, String OTP) {
		Selenium.drivers.seleniumDriver.SendKeys(driver, enterOTP_txt_xpath, "xpath", OTP);
	}
	
	public static void click_createYourAmazonAccountButton_OnVerificationPage(WebDriver driver) {
		Selenium.drivers.seleniumDriver.Click(driver, createYourAmazonAccount_btn_xpath, "xpath");
	}
}