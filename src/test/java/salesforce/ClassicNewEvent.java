package salesforce;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassicNewEvent extends BaseClass {
	
	public void newClassicEvent() throws InterruptedException  {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		actions = new Actions(driver);
		Alert alert;
		// Click on the Profile button and switch to classic view
		WebElement profile = driver.findElement(By.xpath("//div[contains(@class,'branding-user')]"));
		wait.until(ExpectedConditions.elementToBeClickable(profile));
		profile.click();
		
		driver.findElement(By.xpath("//a[text()='Switch to Salesforce Classic']")).click();
		
		
		
	}

}
