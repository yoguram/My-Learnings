package salesforce;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewClassicEvent extends BaseClass {
	
	@Test
	public void newClassicEvent() throws InterruptedException  {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		actions = new Actions(driver);
		Alert alert;
		// Click on the Profile button and switch to classic view
		WebElement profile = driver.findElement(By.xpath("//div[contains(@class,'branding-user')]"));
		wait.until(ExpectedConditions.elementToBeClickable(profile));
		profile.click();
		
		driver.findElement(By.xpath("//a[text()='Switch to Salesforce Classic']")).click();
		
		// Goto Reports section and create new dashboard
		
		
		driver.findElement(By.xpath("//a[text()='Reports']")).click();
		
		driver.findElement(By.xpath("//input[@value='New Dashboard...']")).click();
		Thread.sleep(2000);
		WebElement medium = driver.findElement(By.xpath("//em/button[text()='Medium']"));		
		wait.until(ExpectedConditions.elementToBeClickable(medium));
		medium.click();
		
		WebElement wide = driver.findElement(By.xpath("//span[text()='Wide']"));
		wait.until(ExpectedConditions.elementToBeClickable(wide)).click();
		
		Actions actions = new Actions(driver);
		WebElement from = driver.findElement(By.xpath("//img[@id='analytics:chart-pie']"));		
		WebElement to = driver.findElement(By.xpath("//div[contains(@class,'canvasItemNewComponentDropZone')]/div[@id='ext-gen142']"));
		actions.dragAndDropBy(from, 11, 227).build().perform();
			
		driver.findElement(By.xpath("//textarea[@id='dash_description']")).click();
		driver.findElement(By.xpath("//textarea[@id='dash_description']")).sendKeys("Description chart");
		
		
		driver.findElement(By.xpath("//input[@value='Edit Header']")).click();
		driver.findElement(By.xpath("//input[@value='Edit Header']")).sendKeys("Header");
		
		driver.findElement(By.xpath("//input[@value='Edit Footer']")).click();
		driver.findElement(By.xpath("//input[@value='Edit Footer']")).sendKeys("Footer");
		
		actions.dragAndDrop(driver.findElement(By.xpath("//img[@id='analytics:chart-bar']")), to).build().perform();
		
		driver.findElement(By.xpath("//span[text()='Horizontal Bar Chart']/parent::div/following::div//input[@value='Edit Header']")).click();
		driver.findElement(By.xpath("//span[text()='Horizontal Bar Chart']/parent::div/following::div//input[@value='Edit Header']")).sendKeys("Horizontal chart Header");
		
		driver.findElement(By.xpath("//span[text()='Horizontal Bar Chart']/parent::div/following::div//input[@value='Edit Footer']")).click();
		driver.findElement(By.xpath("//span[text()='Horizontal Bar Chart']/parent::div/following::div//input[@value='Edit Footer']")).sendKeys("Horizontal chart Footer");
		
		// Delete pie chart and save the dashboard
		driver.findElement(By.xpath("//img[@title='Delete']")).click();
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		// Verify the error message
		
		alert = driver.switchTo().alert();
		
		String error = alert.getText();
		
		if(error.contains("Error")) {
			System.out.println("Error occured");
		}
		
		alert.dismiss();
		
		driver.findElement(By.xpath("//a[@class='switch-to-lightning']")).click();
		
		
	}

}
