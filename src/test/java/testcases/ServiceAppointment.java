package testcases;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ServiceConsolePage;
import salesforce.BaseClass;

public class ServiceAppointment extends BaseClass {

	@Test
	public void serviceAppointment() {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String name = "Ram";
		cal.add(Calendar.DATE, 5);
		String date = formatter.format(cal.getTime());
		HomePage login = new HomePage();
		login.clickMoreOptions().clickViewAllButton().clickServiceAppointment().clickNewButton().enterDescription()
				.enterAccountName(name).enterEarliestDatePermitted().enterdueDate(date).saveAccount().verifyrecordAfterCreating();
		
		login.clickMoreOptions().clickViewAllButton().clickServiceAppointment().searchRecords().verifyRecordAfterSearching();
	}
}