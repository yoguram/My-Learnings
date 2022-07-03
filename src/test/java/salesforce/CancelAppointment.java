package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

public class CancelAppointment extends BaseClass {
	@Test
	public void cancelAppointments() throws InterruptedException {
		executor = (JavascriptExecutor) driver;
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Click on the Global Actions SVG icon
		WebElement action = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		executor.executeScript("arguments[0].click();", action);

		// Click on View All
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		viewAll.click();

		Thread.sleep(1500);
		// click on Service Appointments
		WebElement services = driver.findElement(By.xpath("//p[text()='Service Appointments']"));
		executor.executeScript("arguments[0].scrollIntoView(true)", services);
		Thread.sleep(1000);
		services.click();

		// Change the view and cancel appointment

		driver.findElement(By.xpath("//span[text()='Service Appointments']/following::span[text()='Recently Viewed']"))
				.click();
		driver.findElement(By.xpath("//span[text()='All Service Appointments']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).click();
		String id = "SA-0076";
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(id);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(Keys.ENTER);

		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[text()='Show Actions']/preceding-sibling::span")).click();
		driver.findElement(By.xpath("//a[@title = 'Cancel Service Appointment']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Confirm Cancellation']")).click();
		Thread.sleep(2000);
		// Verify the cancellation
		String status = driver
				.findElement(By.xpath(
						"//tr/th/span/a[text()='" + id + "']//parent::span/parent::th//following::td[4]/span/span"))
				.getText();
		System.out.println(status);
		if (status.equals("Canceled")) {
			System.out.println("Appointment is cancelled");
		}
	}
}
