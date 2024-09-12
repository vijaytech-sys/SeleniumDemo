package Selenium.pages.login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Selenium.drivers.seleniumDriver;
import Selenium.pages.homePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class login {
	static String signin_link_xpath="//*[@class='nav-action-signin-button' and @data-nav-ref='nav_signin']";
	static String mobileNumber_txt_xpath="//*[@id='ap_email']";
	static String continue_btn_xpath="//*[@id='continue' and @type='submit']";
	static String enterMobileNumber_title_xpath="//*[@class='a-spacing-micro a-text-bold']";
	static String proceedToCreateAccount_btn_xpath="//*[@id='intention-submit-button']";
	
	public static void click_signInLink(WebDriver driver) {
		Selenium.drivers.seleniumDriver.Click(driver, signin_link_xpath, "xpath");
	}
	
	///******* Validation Block *********//////
	public static void verify_mobileNumberTitleOnLoginPage(WebDriver driver) {
		/*WebElement element=driver.findElement(By.xpath(enterMobileNumber_title_xpath));
		if (element.isDisplayed()) {
			System.out.println("Mobile Number Title is present on Login Page");
		}*/
		seleniumDriver.validateElementDisplayed(driver, enterMobileNumber_title_xpath, "xpath", "Mobile Number Title is present on Login Page.");
	}
	
	public static void enter_mobileNumberOnLoginPage(WebDriver driver, String mobileNumber){
		Selenium.drivers.seleniumDriver.SendKeys(driver, mobileNumber_txt_xpath, "xpath", mobileNumber);
	}
	
	public static void click_ContinueButtonOnLoginPage(WebDriver driver){
		Selenium.drivers.seleniumDriver.Click(driver, continue_btn_xpath, "xpath");
	}
	
	public static void click_ProceedToCreateAccountOnLoginPage(WebDriver driver){
		Selenium.drivers.seleniumDriver.Click(driver, proceedToCreateAccount_btn_xpath, "xpath");
	}
	
	//************ Functional Block ***************////
	public static void ClickSignInLinkAndContinueOnSignUpPage(WebDriver driver, String mobileNumber) {
		seleniumDriver.implicitWait(driver, 10);
		homePage.hoverOnAccountAndList(driver);
		click_signInLink(driver);
		seleniumDriver.implicitWait(driver, 5);
		enter_mobileNumberOnLoginPage(driver,mobileNumber);
		click_ContinueButtonOnLoginPage(driver);
		seleniumDriver.implicitWait(driver, 5);
		click_ProceedToCreateAccountOnLoginPage(driver);
		seleniumDriver.implicitWait(driver, 5);
	}
}