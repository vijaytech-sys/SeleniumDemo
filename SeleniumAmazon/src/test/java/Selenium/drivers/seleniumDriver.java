package Selenium.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import Selenium.utilities.utility;

public class seleniumDriver {

	public static By getByType (WebDriver driver, String locator, String locatorType) {
		By result=null;
		String LocatorType=locatorType.toLowerCase();
		if (LocatorType.equals("id")) {
			result=By.id(locator);
			if (result!=null) {
				utility.getInfoLogReport("***********Element has been identified by locator: "+locatorType+" ***********");
			}else {
				utility.getErrorLogReport("***********Element is not identified by locator: "+locatorType+" ***********", driver);
			}
			return result;
		}
		else if (LocatorType.equals("name")) {
			result=By.name(locator);if (result!=null) {
				utility.getInfoLogReport("***********Element has been identified by locator: "+locatorType+" ***********");
			}else {
				utility.getErrorLogReport("***********Element is not identified by locator: "+locatorType+" ***********", driver);
			}
			return result;
		}
		else if (LocatorType.equals("class")) {
			result=By.className(locator);
			if (result!=null) {
				utility.getInfoLogReport("***********Element has been identified by locator: "+locatorType+" ***********");
			}else {
				utility.getErrorLogReport("***********Element is not identified by locator: "+locatorType+" ***********", driver);
			}
			return result;
		}
		else if (LocatorType.equals("xpath")) {
			result=By.xpath(locator);
			if (result!=null) {
				utility.getInfoLogReport("***********Element has been identified by locator: "+locatorType+" ***********");
			}else {
				utility.getErrorLogReport("***********Element is not identified by locator: "+locatorType+" ***********", driver);
			}
			return result;
		}
		else if (LocatorType.equals("cssselector")) {
			result=By.cssSelector(locator);
			if (result!=null) {
				utility.getInfoLogReport("***********Element has been identified by locator: "+locatorType+" ***********");
			}else {
				utility.getErrorLogReport("***********Element is not identified by locator: "+locatorType+" ***********", driver);
			}
			return result;
		}
		else if (LocatorType.equals("tagname")) {
			result=By.tagName(locator);
			if (result!=null) {
				utility.getInfoLogReport("***********Element has been identified by locator: "+locatorType+" ***********");
			}else {
				utility.getErrorLogReport("***********Element is not identified by locator: "+locatorType+" ***********", driver);
			}
			return result;
		}
		else if (LocatorType.equals("linktext")) {
			result=By.linkText(locator);
			if (result!=null) {
				utility.getInfoLogReport("***********Element has been identified by locator: "+locatorType+" ***********");
			}else {
				utility.getErrorLogReport("***********Element is not identified by locator: "+locatorType+" ***********", driver);
			}
			return result;
		}
		return result;	
	}
	
	public static WebElement findElement (WebDriver driver, String locator, String locatorType) {
		By byType =getByType(driver, locator, locatorType);
		WebElement element =driver.findElement(byType);
		if (element!=null) {
			utility.getInfoLogReport("***********Element has been identified by locator: "+locator+" ***********");
		}else {
			utility.getErrorLogReport("***********Element is not identified by locator: "+locator+" ***********", driver);
		}
		return element;
	}
	
	public static void Clear (WebDriver driver, String locator, String locatorType) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele!=null) {
			utility.getInfoLogReport("***********Element has been identified by locator: "+locator+" ***********");
			ele.clear();
		}else {
			utility.getErrorLogReport("***********Element is not identified by locator: "+locator+" ***********", driver);
		}		
	}
	
	public static void SendKeys (WebDriver driver, String locator, String locatorType, String value) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele!=null) {
			utility.getInfoLogReport("***********Element has been identified by locator: "+locator+" ***********");
			ele.sendKeys(value);
		}else {
			utility.getErrorLogReport("***********Element is not identified by locator: "+locator+" ***********", driver);
		}	
	}
	
	public static void SendKeysEnter (WebDriver driver, String locator, String locatorType) {
		WebElement ele =findElement(driver, locator, locatorType);
		
		if (ele!=null) {
			utility.getInfoLogReport("***********Element has been identified by locator: "+locator+" ***********");
			ele.sendKeys(Keys.ENTER);
		}else {
			utility.getErrorLogReport("***********Element is not identified by locator: "+locator+" ***********", driver);
		}	
	}
	
	public static void Click (WebDriver driver, String locator, String locatorType) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele!=null) {
			utility.getInfoLogReport("***********Element has been identified by locator: "+locator+" ***********");
			ele.click();
		}else {
			utility.getErrorLogReport("***********Element is not identified by locator: "+locator+" ***********", driver);
		}		
	}
	
	public static void SelectByIndex (WebDriver driver, String locator, String locatorType, int indexValue) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele!=null) {
			utility.getInfoLogReport("***********Element has been identified by locator: "+locator+" ***********");
			Select option = new Select(ele);
			option.selectByIndex(indexValue);
		}else {
			utility.getErrorLogReport("***********Element is not identified by locator: "+locator+" ***********", driver);	
		}
	}
	
	public static void SelectByValue (WebDriver driver, String locator, String locatorType, String Value) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele!=null) {
			utility.getInfoLogReport("***********Element has been identified by locator: "+locator+" ***********");
			Select option = new Select(ele);
			option.selectByValue(Value);
		}else {
			utility.getErrorLogReport("***********Element is not identified by locator: "+locator+" ***********", driver);	
		}	
	}
	
	public static void SelectByVisibleText (WebDriver driver, String locator, String locatorType, String VisibleText) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele!=null) {
			utility.getInfoLogReport("***********Element has been identified by locator: "+locator+" ***********");
			Select option = new Select(ele);
			option.selectByVisibleText(VisibleText);
		}else {
			utility.getErrorLogReport("***********Element is not identified by locator: "+locator+" ***********", driver);	
		}		
	}
	
	public static void actionClick (WebDriver driver, String locator, String locatorType) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele!=null) {
			utility.getInfoLogReport("***********Element has been identified by locator: "+locator+" ***********");
			Actions action = new Actions(driver);
			action.click(ele).build().perform();
		}else {
			utility.getErrorLogReport("***********Element is not identified by locator: "+locator+" ***********", driver);	
		}	
	}
	
	public static void actionMoveToElement (WebDriver driver, String locator, String locatorType) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele!=null) {
			utility.getInfoLogReport("***********Element has been identified by locator: "+locator+" ***********");
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
		}else {
			utility.getErrorLogReport("***********Element is not identified by locator: "+locator+" ***********", driver);	
		}	
	}
	
	public static void actionDoubleClick (WebDriver driver, String locator, String locatorType) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele!=null) {
			utility.getInfoLogReport("***********Element has been identified by locator: "+locator+" ***********");
			Actions action = new Actions(driver);
			action.doubleClick(ele).build().perform();
		}else {
			utility.getErrorLogReport("***********Element is not identified by locator: "+locator+" ***********", driver);	
		}
	}
	
	public static void actionContextClick (WebDriver driver, String locator, String locatorType) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele!=null) {
			utility.getInfoLogReport("***********Element has been identified by locator: "+locator+" ***********");
			Actions action = new Actions(driver);
			action.contextClick(ele).build().perform();
		}else {
			utility.getErrorLogReport("***********Element is not identified by locator: "+locator+" ***********", driver);	
		}	
	}
	
	public static void actionDragAndDrop (WebDriver driver, String fromLocator, String toLocator, String locatorType) {
		WebElement FromLocator =findElement(driver, fromLocator, locatorType);
		WebElement ToLocator =findElement(driver, toLocator, locatorType);
		if (FromLocator!=null || ToLocator!=null) {
			utility.getInfoLogReport("***********Element has been identified by locator: "+fromLocator+" OR "+toLocator+"***********");
			Actions action = new Actions(driver);
			action.dragAndDrop(FromLocator, ToLocator).build().perform();
		}else {
			utility.getErrorLogReport("***********Element is not identified by locator: "+fromLocator+" OR "+toLocator+" ***********", driver);	
		}	
	}
	
	public static void validateTextDisplayed (WebDriver driver,String locator, String locatorType, String text, String message) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele.getText().contains(text)) {
			//System.out.println(message);
			utility.getInfoLogReport(message);
		}else {
			utility.getErrorLogReport("***********Text is not identified by locator: "+locator+" ***********", driver);
		}
	}
	
	public static void validateElementDisplayed (WebDriver driver,String locator, String locatorType, String message) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele.isDisplayed()) {
			//System.out.println(message);
			utility.getInfoLogReport(message);
		}else {
			utility.getErrorLogReport("***********Element is not displayed by locator: "+locator+" ***********", driver);
		}
	}
	
	public static void validateElementEnabled (WebDriver driver,String locator, String locatorType, String text, String message) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele.isEnabled()) {
			//System.out.println(message);
			utility.getInfoLogReport(message);
		}else {
			utility.getErrorLogReport("***********Element is not enabled by locator: "+locator+" ***********", driver);
		}
	}
	
	public static void validateElementSelected (WebDriver driver,String locator, String locatorType, String text, String message) {
		WebElement ele =findElement(driver, locator, locatorType);
		if (ele.isSelected()) {
			//System.out.println(message);
			utility.getInfoLogReport(message);
		}else {
			utility.getErrorLogReport("***********Element is not selected by locator: "+locator+" ***********", driver);
		}
	}
	
	public static void implicitWait (WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
}