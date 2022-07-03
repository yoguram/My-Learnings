package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;

import salesforce.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage enterUsername(String username) {
		
		// Enter the username
		
		driver.findElement(By.id("username")).sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String pwd) {	
		// Enter the password
		driver.findElement(By.id("password")).sendKeys(pwd);
		return this;
	}
		// Login to the application
	public HomePage clickLoginButton() {
		driver.findElement(By.id("Login")).click();
		return new HomePage();
		
	}

}
