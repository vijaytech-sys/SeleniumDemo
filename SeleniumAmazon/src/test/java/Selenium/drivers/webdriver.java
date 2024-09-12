package Selenium.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webdriver {
	static String browserType="webdriver.chrome.driver";
	static String browserPath="C:\\Users\\vgayakwad\\eclipse-workspace\\SeleniumAmazon\\src\\test\\java\\Selenium\\configFiles\\chromedriver\\chromedriver.exe";
	static String URL="https://www.amazon.in/";
	public static WebDriver setUp() {
		System.setProperty(browserType, browserPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}
}