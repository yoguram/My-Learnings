package salesforce;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpportunitySorting {
	
	public static void main(String[] args) throws InterruptedException, ParseException {

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

		// Click on Sales
		WebElement newCase = driver.findElement(By.xpath("//p[text()='Sales']"));
		newCase.click();

		// Click on Opportunity tab
		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunity);
		
		//Set the Table View
		WebElement option = driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon slds-button_icon-more'])[2]"));
		option.click();
		WebElement table = driver.findElement(By.xpath("//*[@id='brandBand_1']/div/div/div/div/div[1]/div[2]/div[3]/div[2]/div/div/ul/li[1]/a/span"));
		table.click();
		
		//Sort the date
		WebElement sort = driver.findElement(By.xpath("//span[text()='Close Date']"));
		driver.executeScript("arguments[0].click();", sort);
		WebElement first = driver.findElement(By.xpath("//tbody/tr/td[6]/span/span/span"));
		WebElement second = driver.findElement(By.xpath("//tbody/tr[2]/td[6]/span/span/span"));
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date firstDate = formatter.parse(driver.findElement(By.xpath("//tbody/tr/td[6]/span/span/span")).getText());
		Date secondDate = formatter.parse(driver.findElement(By.xpath("//tbody/tr/td[6]/span/span/span")).getText());
		
		int compareTo = firstDate.compareTo(secondDate);
		if (compareTo<=0)
		{
			System.out.println("It is sorted");
		}else {
			driver.executeScript("arguments[0].click();", sort);
			System.out.println("Now it is sorted");
		}
		
		
		
		
		
		
		
		
		
	}

}
