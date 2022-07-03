package salesforce;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelData;

public class BaseClass {
	public static EdgeDriver driver;
	public static JavascriptExecutor executor;
	public ChromeOptions options;
	public static WebDriverWait wait;
	public Actions actions;
	public Alert alert;

	@Parameters({ "url", "username", "password" })
	@BeforeMethod
	public void startBrowser(String url, String uname, String pwd) {
		// Open Browser
		WebDriverManager.edgedriver().setup();

		// Disable Notification
		

		// Chrome Instance
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// FluentWait wait = new
		// FluentWait(driver).withTimeout(Duration.ofMillis(5000)).pollingEvery(Duration.ofMillis(250));

		// Load the salesforce url
		driver.get(url);

		// Maximizing the window
		driver.manage().window().maximize();

		// Enter the username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(uname);

		// Enter the password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(pwd);

		// Login to the application
		WebElement login = driver.findElement(By.id("Login"));

		login.click();
	}

	@AfterSuite
	public void closeBrowser() {
		try {
			Thread.sleep(5000);
		driver.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
