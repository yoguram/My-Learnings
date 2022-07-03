package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import salesforce.BaseClass;

public class HomePage extends BaseClass {

	public HomePage clickMoreOptions() {
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public AppLauncher clickViewAllButton() {
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='View All']")));
		return new AppLauncher();

	}

}
