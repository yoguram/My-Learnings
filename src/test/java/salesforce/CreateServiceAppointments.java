package salesforce;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.bouncycastle.math.ec.ZSignedDigitR2LMultiplier;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateServiceAppointments extends BaseClass {

	@Test
	public void createServiceAppointments() throws InterruptedException {
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

		// Click on New

		driver.findElement(By.xpath("//div[@title='New']")).click();

		// Enter the Description
		driver.findElement(By.xpath("//span[text()='Description']/parent::label/following::textarea"))
				.sendKeys("Creating Service Appointments");

		// Create new accounts

		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		driver.findElement(By.xpath("//span[text()='New Account']")).click();
		String name = "Ramachandran";
		driver.findElement(By.xpath("//span[text()='Account Name']/parent::label/following::input")).sendKeys(name);
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();

		// Verify record
		if (driver.findElement(By.xpath("//span[text()='" + name + "']")).getText().equals(name)) {
			System.out.println("Patient record is verified");
		}

		// Enter the Dates
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String startdate = formatter.format(cal.getTime());
		driver.findElement(By.xpath("//span[text()='Earliest Start Permitted']/parent::legend/following::div//input"))
				.click();
		driver.findElement(By.xpath("//span[contains(@class,'selectedDate')]")).click();
		cal.add(Calendar.DATE, 5);
		String duedate = formatter.format(cal.getTime());
		driver.findElement(By.xpath("//input[@data-interactive-lib-uid='10']")).sendKeys(duedate);
		driver.findElement(By.xpath("//button[@title='Save']")).click();

		// Verify the record
		String id = driver.findElement(By.xpath("//div[text()='Service Appointment']/following::div/span")).getText();
		System.out.println(id + " is Created");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//viewAll.click();
		Thread.sleep(1000);
		
		executor.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//p[text()='Service Appointments']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[text()='Service Appointments']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(id + Keys.ENTER);
		
		String searchedId = driver.findElement(By.xpath("//tbody/tr/th//a")).getText();
	

		if (id.equals(searchedId)) {
			System.out.println("Verified");
		}
	}

}
