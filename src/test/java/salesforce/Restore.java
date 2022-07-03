package salesforce;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Restore {
	@Test (invocationCount=2)
	public void restoreStatus() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://app2.syscloud.com");
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("googlessobutton")));
		driver.findElement(By.id("googlessobutton")).click();
		
		driver.findElement(By.id("identifierId")).click();
		driver.findElement(By.id("identifierId")).sendKeys("admin@gedu.demo.cybersecurityorg.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='password']//input")).click();
		driver.findElement(By.xpath("//div[@id='password']//input")).sendKeys("Syscloud123!@");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Google Workspace')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'gedu')]")).click();
		
		
		driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Restore & Export Report']")).click();
		
		String count = driver.findElement(By.xpath("//div[@id='restoreCount']")).getText();
		String endDate = driver.findElement(By.xpath("//span[@data-cy='backup_restoresandexports_enddate']")).getText();
		
		System.out.println(count +"\n"+ endDate);
				
		
		
	}

		
}
