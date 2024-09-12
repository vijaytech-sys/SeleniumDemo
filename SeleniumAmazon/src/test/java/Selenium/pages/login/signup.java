package Selenium.pages.login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import Selenium.drivers.seleniumDriver;
import Selenium.pages.login.validate_OTP;

public class signup {
	
	static String mobileNumber_text_xpath="//*[@name='email' and @placeholder='Mobile number']";	
	static String name_text_xpath="//*[@name='customerName']";
	static String password_text_id="ap_password";
	static String verifyMobileNumber_btn_id="continue";
	static String createAccount_title_xpath="//*[contains(text(), 'Create Account')]";
	static String mobileNumber_label_xpath="//*[@for='ap_phone_number']";
	static String yourName_label_xpath="//*[@for='ap_customer_name']";
	static String password_label_xpath="//*[@for='ap_password']";
	static String phoneNumberMissingAlert_text_xpath="//*[@id='auth-phoneNumber-missing-alert']";
	static String yourNameMissingAlert_text_xpath="//*[@id='auth-customerName-missing-alert']";
	static String passwordMissingAlert_text_xpath="//*[@id='auth-password-missing-alert']";
	static String phoneNumberInvalidAlert_text_xpath="//*[@id='auth-phoneNumber-invalid-phone-alert']";
	static String passwordInvalidAlert_text_xpath="//*[@id='auth-password-invalid-password-alert']";
	
	public static void enter_mobileNumberOnSignUpPage(WebDriver driver, String mobileNumber) {
		seleniumDriver.Clear(driver, mobileNumber_text_xpath, "xpath");
		seleniumDriver.SendKeys(driver, mobileNumber_text_xpath, "xpath", mobileNumber);
	}
	
	public static void enter_yourNameOnSignUpPage(WebDriver driver, String yourName) {		
		seleniumDriver.SendKeys(driver, name_text_xpath, "xpath", yourName);
	}
	
	public static void enter_passwordOnSignUpPage(WebDriver driver, String password) {
		seleniumDriver.SendKeys(driver, password_text_id, "id", password);
	}
	
	public static void click_verifyMobileNumberButtonOnSignUpPage(WebDriver driver) {
		seleniumDriver.Click(driver, verifyMobileNumber_btn_id, "id");

	}
	///******* Validation Block *********//////
	public static void verify_createAccountTitleOnSignUpPage(WebDriver driver) {
		/*WebElement element=driver.findElement(By.xpath(createAccount_title_xpath));
		if (element.getText().contains("Create Account")) {
			System.out.println("Create Account Title is present on Sign Up Page");
		}*/
		seleniumDriver.validateTextDisplayed(driver, createAccount_title_xpath, "xpath", "Create Account", "Create Account Title is present on Sign Up Page.");
	}
	
	public static void verify_allLabelsOnSignUpPage(WebDriver driver) {
		/*WebElement element1=driver.findElement(By.xpath(mobileNumber_label_xpath));
		if (element1.isDisplayed()) {
			System.out.println("Mobile Number Label is present on Sign Up Page");
		}*/
		seleniumDriver.validateElementDisplayed(driver, mobileNumber_label_xpath, "xpath", "Mobile Number Label is present on Sign Up Page.");
		seleniumDriver.validateElementDisplayed(driver, yourName_label_xpath, "xpath", "Your Name Label is present on Sign Up Page.");
		seleniumDriver.validateElementDisplayed(driver, password_label_xpath, "xpath", "Password Label is present on Sign Up Page.");

	}
	
	public static void verify_MissingPhoneNumberOnSignUpPage(WebDriver driver, String mobileNumber) {
		enter_mobileNumberOnSignUpPage(driver, mobileNumber);
		/*WebElement element=driver.findElement(By.xpath(phoneNumberMissingAlert_text_xpath));
		if (element.isDisplayed()) {
			System.out.println("Enter your mobile number validation message is displayed on Sign Up Page");
		}*/
		seleniumDriver.validateElementDisplayed(driver, phoneNumberMissingAlert_text_xpath, "xpath", "Enter your mobile number validation message is displayed on Sign Up Page.");
	}
	
	public static void verify_InvalidPhoneNumberOnSignUpPage(WebDriver driver, String mobileNumber) {
		enter_mobileNumberOnSignUpPage(driver, mobileNumber);
		seleniumDriver.validateElementDisplayed(driver, phoneNumberInvalidAlert_text_xpath, "xpath", "Invalid mobile number validation message is displayed on Sign Up Page.");
	}
	
	public static void verify_MissingYourNameOnSignUpPage(WebDriver driver, String yourName) {
		enter_yourNameOnSignUpPage(driver, yourName);
		seleniumDriver.validateElementDisplayed(driver, yourNameMissingAlert_text_xpath, "xpath", "Enter your name validation message is displayed on Sign Up Page.");
	}
	
	public static void verify_MissingPasswordOnSignUpPage(WebDriver driver, String password) {
		enter_passwordOnSignUpPage(driver, password);
		seleniumDriver.validateElementDisplayed(driver, passwordMissingAlert_text_xpath, "xpath", "Enter password validation message is displayed on Sign Up Page.");
	}
	
	public static void verify_InvalidPasswordOnSignUpPage(WebDriver driver, String password) {
		enter_passwordOnSignUpPage(driver, password);
		seleniumDriver.validateElementDisplayed(driver, passwordInvalidAlert_text_xpath, "xpath", "Invalid password validation message is displayed on Sign Up Page.");
	}
		
	//************ Functional Block ***************////
	public static void enterDetailsOnSignUpPage(WebDriver driver, String mobileNumber, String yourName, String password) {
		enter_mobileNumberOnSignUpPage(driver, mobileNumber);
		enter_yourNameOnSignUpPage(driver, yourName);
		enter_passwordOnSignUpPage(driver, password);
		click_verifyMobileNumberButtonOnSignUpPage(driver);
		seleniumDriver.implicitWait(driver, 5);
		validate_OTP.verify_mobileNumberTitleOnVerificationPage(driver);
	}
}