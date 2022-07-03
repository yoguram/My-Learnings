package salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewRefund extends BaseClass {

	@Test
	public void newRefund() throws InterruptedException {
		
		executor = (JavascriptExecutor) driver; 
		
		Thread.sleep(5000);
		// Click on the Global Actions SVG icon
		WebElement action = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		executor.executeScript("arguments[0].click();", action);

		// Click on View All
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		viewAll.click();

		// Click on Service Console
		WebElement serviceConsole = driver.findElement(By.xpath("//p[text()='Service Console']"));
		serviceConsole.click();
		
		// Click on the dropdown
		WebElement dropdown = driver.findElement(By.xpath("//button[@title='Show Navigation Menu']"));
		dropdown.click();
		
		// Click on the refund
		WebElement refund = driver.findElement(By.xpath("//span[text()='Refunds']"));
		refund.click();
		
		Thread.sleep(3000);
		
		// Click on new button
		WebElement newRefund = driver.findElement(By.xpath("//div[@title='New']"));
		newRefund.click();
		
		//Click on Account
		WebElement account = driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']"));
		account.click();
		account.sendKeys("Ram");
		driver.findElement(By.xpath("//div[@title='Ram']")).click();
		
		//Click on the status filter
		WebElement status = driver.findElement(By.xpath("//span[text()='Status']/parent::span/parent::div/div"));
		status.click();
		
		//Select the status as cancelled
		WebElement cancelled = driver.findElement(By.xpath("//a[@title='Canceled']"));
		cancelled.click();
		
		//Enter the amount
		WebElement amount = driver.findElement(By.xpath("//input[@class='input uiInputSmartNumber']"));
		amount.click();
		amount.sendKeys("5000");
		
		//Set the Reference Type
		WebElement reference = driver.findElement(By.xpath("//span[text()='Type']/parent::span/parent::div/div"));
		reference.click();
		WebElement referenced = driver.findElement(By.xpath("//a[@title='Referenced']"));
		referenced.click();
		
		//Set the Processing Mode
		WebElement mode = driver.findElement(By.xpath("//span[text()='Processing Mode']/parent::span/parent::div/div"));
		mode.click();
		WebElement external = driver.findElement(By.xpath("//a[@title='External']"));
		external.click();
		
		//Save the Refund
		WebElement save = driver.findElement(By.xpath("//button[@title='Save']"));
		save.click();
		
//		//Verify the refund created
//		String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
//		System.out.println(text);
//		if(text.contains("created")) {
//			System.out.println("New Refund Created");
//		}else {
//			System.out.println("New Refund not Created");
//		}
		
	}

}
