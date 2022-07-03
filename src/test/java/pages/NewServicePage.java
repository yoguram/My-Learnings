package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import salesforce.BaseClass;

public class NewServicePage extends BaseClass {

	public String name;

	public NewServicePage enterDescription() {
		driver.findElement(By.xpath("//span[text()='Description']/parent::label/following::textarea"))
				.sendKeys("Creating Service Appointments");
		return this;
	}

	public NewServicePage searchAccounts() {
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		return this;
	}

	public NewServicePage enterAccountName(String name) {
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).sendKeys(name);
		List<WebElement> searchedNames = driver.findElements(By.xpath("//li/a/div[2]/div/mark"));
		for (WebElement webElement : searchedNames) {
			String uiname = webElement.getText();
			if (uiname.equalsIgnoreCase(name)) {
				webElement.click();
				break;
			}
		}
		return this;
	}

	public NewServicePage createNewAccount() {
		driver.findElement(By.xpath("//span[text()='New Account']")).click();
		return this;
	}
//
//	public NewServicepage enterAccountName() {
//		name = "Ramachandran";
//		driver.findElement(By.xpath("//span[text()='Account Name']/parent::label/following::input[1]")).sendKeys(name);
//		return this;
//	}

	public NewServicePage clickSaveButton() {
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
		return this;
	}

	public NewServicePage verifyPatentRecord() {
		if (driver.findElement(By.xpath("//span[text()='" + name + "']")).getText().equals(name)) {
			System.out.println("Patient record is verified");
		}
		return this;
	}

	public NewServicePage enterEarliestDatePermitted() {
		driver.findElement(By.xpath("//span[text()='Earliest Start Permitted']/parent::legend/following::div//input"))
				.click();
		driver.findElement(By.xpath("//span[contains(@class,'selectedDate')]")).click();
		return this;
	}

	public NewServicePage enterdueDate(String duedate) {
		driver.findElement(By.xpath("//input[@data-interactive-lib-uid='10']")).sendKeys(duedate);
		return this;
	}

	public ServiceConsolePage saveAccount() {
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		return new ServiceConsolePage();
	}
}
