package salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateChart {

	@Test
	public void createChart() throws InterruptedException {
		// Open Browser
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
				driver.executeScript("arguments[0].click();", viewAll);

				// Click on Service Console
				WebElement serviceConsole = driver.findElement(By.xpath("//p[text()='Service Console']"));
				driver.executeScript("arguments[0].click();", serviceConsole);
				
				// Click on the dropdown
				WebElement dropdown = driver.findElement(By.xpath("//button[@title='Show Navigation Menu']"));
				dropdown.click();
				
				// Click on the refund
				WebElement refund = driver.findElement(By.xpath("//span[text()='Refunds']"));
				refund.click();
				
				// Select all refunds
				WebElement recents = driver.findElement(By.xpath("//span[text()='Recently Viewed']"));
				recents.click();
				WebElement allRefunds  = driver.findElement(By.xpath("//span[text()='All']"));
				allRefunds.click();
				
				Thread.sleep(2000);
				
				// Click on show charts
				WebElement charts = driver.findElement(By.xpath("//span[text()='Show charts']"));
				driver.executeScript("arguments[0].click();", charts);
				
				//Create New chart
				WebElement settings = driver.findElement(By.xpath("//span[text()='Settings']"));
				driver.executeScript("arguments[0].click();", settings);
				WebElement newChart = driver.findElement(By.xpath("//a[@title='New Chart']"));
				newChart.click();

				// Give the chart name
				WebElement chartName = driver.findElement(By.xpath("//abbr[text()='*']/parent::label/following-sibling::div/input"));
				chartName.click();
				chartName.sendKeys("New Chart");
				
				//Set the Chart type
				WebElement chartType = driver.findElement(By.xpath("//span[text()='Chart Type']/parent::span/following-sibling::div//a"));
				driver.executeScript("arguments[0].click();", chartType);
				WebElement type = driver.findElement(By.xpath("//li[@role='presentation' and @class='uiMenuItem uiRadioMenuItem']//a[@title='Vertical Bar Chart']"));
				wait.until(ExpectedConditions.elementToBeClickable(type));
				type.click();
						
				// Set the aggregate type
				WebElement aggType = driver.findElement(By.xpath("//span[text()='Aggregate Type']/parent::span/following-sibling::div//a"));
				aggType.click();
				WebElement agg = driver.findElement(By.xpath("//a[@title='Average']"));
				agg.click();
				
				// Set the aggregate field
				WebElement aggField = driver.findElement(By.xpath("//span[text()='Aggregate Field']/parent::span/following-sibling::div//a"));
				aggField.click();
				WebElement aggr = driver.findElement(By.xpath("//a[@title='Amount']"));
				aggr.click();
				
				// Set the Grouping field
				WebElement groupField = driver.findElement(By.xpath("//span[text()='Grouping Field']/parent::span/following-sibling::div//a"));
				groupField.click();
				WebElement group = driver.findElement(By.xpath("//a[@title='Account']"));
				group.click();
				
				Thread.sleep(2000);
				
				if(driver.findElement(By.xpath("//div[@id='auraError']")).isDisplayed()){
					driver.findElement(By.xpath("//span[text()='OK']")).click();
				}
				else {
					System.out.println("Error not came");
				}
				
				//Save the chart
				WebElement save = driver.findElement(By.xpath("//span[text()='Save']"));
				driver.executeScript("arguments[0].click();",save);
				
				// Change the chart again
				settings.click();
				driver.findElement(By.xpath("[@title='Donut Chart']")).click();
				
	}

}
