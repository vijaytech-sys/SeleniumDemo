package Selenium.pages.cart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Selenium.drivers.seleniumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class cart {
	static String delete_link_xpath="//*[@class='a-color-link' and @data-action='delete' and @name='submit.delete.af848f64-7469-41f1-8bed-c251817d49bd']";
	static String saveForLater_link_xpath="//*[@class='a-row sc-action-links']//*[@class='a-color-link' and @data-action='save-for-later' and @name='submit.save-for-later.b1561922-b458-4da7-9252-9eb278966855']";
	static String proceedToBuy_btn_xpath="//*[@class='a-button-input' and @value='Proceed to checkout']";
	
	public static void click_deleteItemLinkOnCartPage(WebDriver driver) {
		/*WebElement element=driver.findElement(By.xpath(delete_link_xpath));		
		element.click();*/
		seleniumDriver.Click(driver, delete_link_xpath, "xpath");
	}
	
	public static void click_saveItemLinkOnCartPage(WebDriver driver) {
		/*WebElement element=driver.findElement(By.xpath(saveForLater_link_xpath));
		element.click();*/
		seleniumDriver.Click(driver, saveForLater_link_xpath, "xpath");
	}
	
	public static void click_proceedToBuyButtonOnCartPage(WebDriver driver) {
		seleniumDriver.Click(driver, proceedToBuy_btn_xpath, "xpath");
	}
}