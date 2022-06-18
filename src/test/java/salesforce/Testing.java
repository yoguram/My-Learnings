package salesforce;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {

	public static void main(String[] args) throws ParseException, InterruptedException {
		
		// Open Browser
		WebDriverManager.chromedriver().setup();

		// Disable Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.setExperimentalOption("debuggerAddress", "localhost:9014");

		// Chrome Instance
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy, hh:mm aa");
//		String date1 = "6/4/2022, 10:01 AM";
//		String date2 = "6/4/2022, 10:24 PM";
//		
//		Date parse = formatter.parse(date1);
//		Date parse2 = formatter.parse(date2);
	
//		Date firstDate = formatter.parse(date1);
//		Date secondDate = formatter.parse(date2);
//		System.out.println(firstDate);
//		System.out.println(secondDate);
//		
		//int compareTo = parse.compareTo(parse2);
		//System.out.println(compareTo);
//		System.out.println(firstDate);
//		System.out.println(secondDate);
		
//		int compareTo = firstDate.compareTo(secondDate);
//		System.out.println(compareTo);
		
//		String one = "Ram";
//		String two = "Ran";
//		System.out.println(one.compareTo(two));
		
//		Date dt = new Date();
//		dt = Calendar.getInstance().getTime();
//		SimpleDateFormat formater = new SimpleDateFormat("MM/dd/yyy");
//		String format = formater.format(dt);
		
//		//Set the Date
//		WebElement calendar = driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']"));
//		calendar.click();
//		WebElement nextMonth = driver.findElement(By.xpath("//a[@class='navLink nextMonth']"));
//		nextMonth.click();
		
		

				
				// Set the Date
		
		driver.findElement(By.xpath("//button[@title='Save']/span")).click();

		
		
		

	}

}
