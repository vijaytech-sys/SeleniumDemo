package Selenium.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import Selenium.drivers.seleniumDriver;
import org.openqa.selenium.By;

public class homePage {

	static String accountList_link_xpath="//*[@id='nav-link-accountList']";
	static String searchDropDownBox_dropdown_xpath="//*[@id='searchDropdownBox']";
	
	public static void searchCategoryfromDropdownList (WebDriver driver, String Category) {
		/*WebElement element =driver.findElement(By.xpath(searchDropDownBox_dropdown_xpath));
		Select category = new Select(element);
		category.selectByVisibleText(Category);*/
		seleniumDriver.SelectByVisibleText(driver, searchDropDownBox_dropdown_xpath, "xpath", Category);
	}
	
	public static void hoverOnAccountAndList (WebDriver driver) {
		/*WebElement element =driver.findElement(By.xpath(accountList_link_xpath));
		Actions action = new Actions(driver);
		action.click(element).build().perform();*/
		seleniumDriver.actionMoveToElement(driver, accountList_link_xpath, "xpath");
	}
	
	///******* Validation Block *********//////
	public static void verifyUserIsOnHomePage (WebDriver driver) {
		/*WebElement element =driver.findElement(By.xpath(accountList_link_xpath));
		if (element.isDisplayed()){
			System.out.println("User is on Home Page");
		}*/
		seleniumDriver.validateElementDisplayed(driver, accountList_link_xpath, "xpath", "User is on Amazon Home Page");
	}	
}