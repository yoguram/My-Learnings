package salesforce;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunity {

	public static void main(String[] args) throws InterruptedException {

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

		// Click on New
		WebElement newOpp = driver.findElement(By.xpath("//div[@title='New']"));
		newOpp.click();

		// Send the Date
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(dt);
		WebElement date = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		date.click();
		date.sendKeys(strDate);

//		String oldWindow = driver.getWindowHandle();
//		System.out.println(oldWindow);
//		
//		Set<String> allWindowHandles = driver.getWindowHandles();
//        Iterator<String> iterator = allWindowHandles.iterator();
//
//        // Here we will check if child window has other child windows and will fetch the heading of the child window
//        while (iterator.hasNext()) {
//            String ChildWindow = iterator.next();
//            System.out.println(ChildWindow);
//                if (!oldWindow.equalsIgnoreCase(ChildWindow)) {
//                driver.switchTo().window(ChildWindow);
//                driver.findElement(By.xpath("//button[@title='OK']")).click();
//                }
//                
//            }
		// Click on save button
		WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
		if (save.isDisplayed()) {
			driver.executeScript("arguments[0].click();", save);
		} else {
			WebElement okButton = driver.findElement(By.xpath("//button[@title='OK']"));
			if (okButton.isDisplayed()) {
				okButton.click();
				save.click();
			}
		}
//		// Handling the Alert
//		String text = driver.switchTo().alert().getText();
//		System.out.println(text);
//		driver.switchTo().alert().dismiss();
//
//		if (text.contains("snag")) {
//			System.out.println("Alert Verified");
//		} else
//			System.out.println("Alert not handled");
		
		// Verifying alert message
		WebElement snag = driver.findElement(By.xpath("//h2[@title='We hit a snag.']"));
		if(snag.isDisplayed()) {
		System.out.println("Alert came for not filling the required details");
		}
		
		//Enter the Opportunity name
		WebElement oName = driver.findElement(By.xpath("//input[@name='Name']"));
		oName.sendKeys("Create Opportunity");
		
		// Set the Stage
		WebElement stage = driver.findElement(By.xpath("//button[contains(@aria-label,'Stage')]/span"));
		stage.click();
		driver.findElement(By.xpath("//span[@title='Qualification']")).click();
		
		//Clicking on the save button
		save.click();
		
		// Verifying the message
		String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(text);
		if(text.contains("created")) {
			System.out.println("New Opportunity Created");
		}else {
			System.out.println("New Opportunity not Created");
		}
	
		

	}

}
