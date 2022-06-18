package salesforce;

import org.openqa.selenium.By.ById;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateCase {
	
	public static void main (String args[]) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yogur\\Learning Selenium\\MavenProject\\drivers\\chromedriver.exe");
		
		
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
		
		//Maximizing the window
		driver.manage().window().maximize();
		
		// Enter the username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("makaia@testleaf.com");
		
		// Enter the password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("BootcampSel@123");
		
		//Login to the application
		WebElement login = driver.findElement(By.id("Login"));
		login.click();		
		
		//Click on the Global Actions SVG icon
		WebElement action = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		action.click();
		
		// Search For Cases
		WebElement searchinaction = driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']"));
		searchinaction.sendKeys("Cases");
		
		// Click on the Cases
		WebElement cases = driver.findElement(By.xpath("//b[text()='Cases']"));
		cases.click();
			
		//Click on the new case
		WebElement newCase = driver.findElement(By.xpath("//div[@title='New']"));
		newCase.click();
		
		//Choose the Contacts
		
		WebElement contacts = driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']"));
		contacts.click();
		WebElement choose = driver.findElement(By.xpath("//div[contains(text(),'Venkat')]"));
		choose.click();
			
		//Set the Status
		WebElement status = driver.findElement(By.xpath("//button[@aria-haspopup='listbox']"));
		status.click();
		WebElement escalated = driver.findElement(By.xpath("//span[text()='Escalated']"));
		escalated.click();	
		
		//Select the Case Origin
		WebElement caseOrigin = driver.findElement(By.xpath("//span[text()='Case Origin']/following::div"));
		caseOrigin.click();
		WebElement email = driver.findElement(By.xpath("//a[@title='Email']"));
		email.click();
		
		//Enter the Subject
		
		WebElement subject = driver.findElement(By.xpath("//span[text()='Subject']/parent::label/following-sibling::input"));
		subject.click();
		subject.sendKeys("Testing");
			
		// Enter the Description
		WebElement description = driver.findElement(By.xpath("//textarea"));
		description.click();
		description.sendKeys("dummy");
		
		// Save the cases
		WebElement save = driver.findElement(By.xpath("//span[text()='Save']"));
		driver.executeScript("arguments[0].click();", save);
		
		// Verifying the message
		String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(text);
		if(text.contains("saved")) {
			System.out.println("New Case Created");
		}else
			System.out.println("New Case not Created");
		}

}
