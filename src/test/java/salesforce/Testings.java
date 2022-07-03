package salesforce;

import java.io.IOException;
import java.sql.Time;
import org.testng.annotations.Test;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterGroups;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelData;

public class Testings extends ExcelData {
@Test(dataProvider="readdata")
public void getData(String url, String username, String password) {
	System.out.println(url);
	System.out.println(username);
	System.out.println(password);

}
}
