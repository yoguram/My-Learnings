package salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditWorkType {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogur\\Learning Selenium\\MavenProject\\drivers\\chromedriver.exe");

		// Open Browser
		WebDriverManager.chromedriver().setup();

		// Disable Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Chrome Instance
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

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

		// Click on Worktypes
		WebElement workType = driver.findElement(By.xpath("//span//p[text()='Work Types']"));
		driver.executeScript("arguments[0].scrollIntoView(true)", workType);
		workType.click();

		// Edit the worktypes
		WebElement editFirst = driver.findElement(By.xpath("//tbody/tr/td[5]/span/div"));
		editFirst.click();
		WebElement editClick = driver.findElement(By.xpath("//a[@title='Edit']"));
		editClick.click();

		// Set the Time Frame

		WebElement start = driver
				.findElement(By.xpath("//span[text()='Timeframe Start']/parent::label/parent::div/input"));
		start.clear();
		start.sendKeys("9");
		WebElement end = driver.findElement(By.xpath("//span[text()='Timeframe End']/parent::label/parent::div/input"));
		end.clear();
		end.sendKeys("15");

		// Click on Save button

		WebElement save = driver.findElement(By.xpath("//button[@title='Save']"));
		driver.executeScript("arguments[0].click();", save);

		// Verifying alert message
		String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(text);
		if (text.contains("saved")) {
			System.out.println("WorkItem Updated");
		} else
			System.out.println("No Workitem updated");
	}

}
