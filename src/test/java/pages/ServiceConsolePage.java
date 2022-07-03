package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import salesforce.BaseClass;

public class ServiceConsolePage extends BaseClass {
	
	public static String id,searchedId;

	public ServiceConsolePage verifyrecordAfterCreating() {
		id = driver.findElement(By.xpath("//div[text()='Service Appointment']/following::div/span")).getText();
		System.out.println(id);
		System.out.println(id + " is Created");
		return this;
	}
	
	public NewServicePage clickNewButton() {
		driver.findElement(By.xpath("//div[@title='New']")).click();
		return new NewServicePage();
	}
	
	public ServiceConsolePage searchRecords() {
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(id + Keys.ENTER);
		return this;
	}
	
	public ServiceConsolePage verifyRecordAfterSearching() {
		searchedId = driver.findElement(By.xpath("//tbody/tr/th//a")).getText();
		if (id.equals(searchedId)) {
			System.out.println("Created Appointment is Verified");
		}
		return this;
	}
}
