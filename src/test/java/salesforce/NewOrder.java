package salesforce;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewOrder {

	public static void main(String[] args) throws InterruptedException {
		// // Open Browser
		WebDriverManager.chromedriver().setup();

		// Disable Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Chrome Instance
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// Load the salesforce url
		driver.get("https://login.salesforce.com/");

		// Maximizing the window
		driver.manage().window().maximize();

		// Enter the username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("makaia@testleaf.com");

		// Enter the password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("BootcampSel@123");

		// Login to the application
		WebElement login = driver.findElement(By.id("Login"));
		login.click();

		// Click on the Global Actions SVG icon
		WebElement action = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		driver.executeScript("arguments[0].click();", action);

		// Click on View All
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		viewAll.click();

		// Click on Service Console
		WebElement serviceConsole = driver.findElement(By.xpath("//p[text()='Service Console']"));
		serviceConsole.click();

		// Click on the dropdown
		WebElement dropdown = driver.findElement(By.xpath("//button[@title='Show Navigation Menu']"));
		dropdown.click();

		// Click on Orders
		WebElement orders = driver.findElement(By.xpath("//span[text()='Orders']"));
		orders.click();

		Thread.sleep(1500);

		// Click on new button
		WebElement newOrder = driver.findElement(By.xpath("//div[@title='New']"));
		newOrder.click();

		// Enter the account name
		WebElement accountName = driver
				.findElement(By.xpath("//span[text()='Account Name']/parent::label/parent::div/div//input"));
		accountName.click();
		accountName.sendKeys("Ram");
		driver.findElement(By.xpath("//mark[text()='Ram']")).click();

		// Set the contracts
		WebElement contract = driver.findElement(By.xpath("//input[@placeholder='Search Contracts...']"));
		contract.click();
		contract.sendKeys("00000276");
		driver.findElement(By.xpath("//div[contains(@title,'276')]")).click();

		// Set the Status
		WebElement status = driver.findElement(By.xpath("//span[text()='Status']/parent::span/parent::div/div//a"));
		status.click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[text()='Draft']")).click();

		// Set the Date
		WebElement calendar = driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']"));
		calendar.click();
		WebElement nextMonth = driver.findElement(By.xpath("//a[@class='navLink nextMonth']"));
		nextMonth.click();

		List<WebElement> dates = driver.findElements(By.xpath("//tbody/tr[@class='calRow']"));
		int rows = dates.size();
		for (int i = 1; i <= rows; i++) {
			List<WebElement> date = driver.findElements(By.xpath("//tbody/tr[@class='calRow'][" + i + "]/td"));
			int columns = date.size();
			for (int j = 1; j <= columns; j++) {
				WebElement selectedDate = driver
						.findElement(By.xpath("//tbody/tr[@class='calRow'][" + i + "]/td[" + j + "]/span"));
				if (selectedDate.getText().equals("10")) {
					selectedDate.click();
					break;

				}

			}
		}

		Thread.sleep(5000);
		// Save the Order
		WebElement save = driver.findElement(By.xpath("//button[@title='Save']/span"));
		wait.until(ExpectedConditions.elementToBeClickable(save));
		save.click();
		
	}

}
