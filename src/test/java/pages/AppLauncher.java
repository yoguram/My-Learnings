package pages;

import org.openqa.selenium.By;

import salesforce.BaseClass;

public class AppLauncher extends BaseClass {
	
	public ServiceConsolePage clickServiceAppointment() {
		 driver.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//p[text()='Service Appointments']")));
		 driver.findElement(By.xpath("//p[text()='Service Appointments']")).click();		
		return new ServiceConsolePage();
	}

}
