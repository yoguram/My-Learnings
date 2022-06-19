package salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCase {

	@Test
	public void deleteCase() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogur\\Learning Selenium\\MavenProject\\drivers\\chromedriver.exe");

		// Open Browser
		WebDriverManager.chromedriver().setup();

		// Disable Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Chrome Instance
		ChromeDriver driver = new ChromeDriver(options);

		// Implicit wait
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
		action.click();

		// Search For Cases
		WebElement searchinaction = driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']"));
		searchinaction.sendKeys("Cases");

		// Click on View All
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		viewAll.click();

		// Click on Sales
		WebElement newCase = driver.findElement(By.xpath("//p[text()='Sales']"));
		newCase.click();

		// Click on the Cases Menu
		WebElement cases = driver.findElement(By.xpath("//span[text()='Cases']"));
		driver.executeScript("arguments[0].click();", cases);

		// Delete the Case
		WebElement actions = driver.findElement(By.xpath(
				"//*[@id=\"brandBand_1\"]/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[7]/span/div/a/span/span[1]"));
		actions.click();
		WebElement delete = driver.findElement(By.xpath("//a[@title= 'Delete']"));
		delete.click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		
		// Verifying the message
				String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
				System.out.println(text);
				if(text.contains("deleted")) {
					System.out.println("Case deleted");
				}else
					System.out.println("Unable to delete the case");
		

	}

}
