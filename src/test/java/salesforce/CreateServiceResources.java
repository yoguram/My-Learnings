package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateServiceResources extends BaseClass {

	@Test
	public void createService() throws InterruptedException {
		executor = (JavascriptExecutor) driver;
		actions = new Actions(driver);
		Thread.sleep(5000);
		// Click on the Global Actions SVG icon
		WebElement action = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		executor.executeScript("arguments[0].click();", action);

		// Click on View All
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		viewAll.click();

		Thread.sleep(1500);
		// click on Select Services
		WebElement services = driver.findElement(By.xpath("//p[text()='Service Resources']"));
		executor.executeScript("arguments[0].scrollIntoView(true)", services);
		Thread.sleep(1000);
		services.click();

		// click the action button

		Thread.sleep(2000);
		WebElement optionss = driver.findElement(By.xpath("//div[contains(@class ,'forceVirtual')]"));
		optionss.click();

		// Edit the name of the services
		WebElement edit = driver.findElement(By.xpath("//div[text()='Edit']"));
		actions.click(edit).build().perform();

		String changedName = "Ram";
		WebElement enterName = driver.findElement(By.xpath("//label/following-sibling::input[@type='text']"));
		enterName.clear();
		enterName.sendKeys(changedName);

		// Save the name
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		Thread.sleep(1000);

		// Verify the saved name

		String name = driver
				.findElement(By.xpath("//a[@title='fg fgf']/parent::span/parent::td/preceding-sibling::th/span/a"))
				.getText();
		
		System.out.println(name);

		if (name.equals(changedName)) {
			System.out.println("Name is Changed");
		}

	}

}
