package salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteWorkType {

	@Test
	public void deleteWorkType() throws InterruptedException {
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

		// Delete the worktypes
		WebElement deleteFirst = driver.findElement(By.xpath("//tbody/tr/td[5]/span/div"));
		deleteFirst.click();
		WebElement delete = driver.findElement(By.xpath("//a[@title='Delete']"));
		delete.click();

		// Delete WorkType		
		WebElement deleteit = driver.findElement(By.xpath("//span[text()='Delete']"));
		deleteit.click();
		
		// Verify error message
		String text = driver.findElement(By.xpath("//div[contains(@class,'forceToastMessage')]")).getText();
		System.out.println(text);
		if (text.contains("deleted.")) {
			System.out.println("Workitem deleted");
		} else
			System.out.println("Workitem not deleted");
	}

}
