package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import exceptions.PageObjectException;
import reusableComponents.WebDriverSupport;
import uiStore.RoundtripUI;
import utilities.ExtentLogUtilities;

public class Roundtrip extends RoundtripUI{

		WebDriver driver;
		Logger log;
		ExtentTest test;

		public Roundtrip(WebDriver driver, Logger log, ExtentTest test) throws Exception {
			this.driver = driver;
			this.test = test;
			this.log = log;
		}

		public void roundtrip() throws PageObjectException, Exception {
		try {
		WebDriverSupport.click(driver,outstation, "click","outstation", log, test);
		WebDriverSupport.click(driver,radio, "click","radiobutton", log, test);
    // WebDriverSupport.click(driver, close, "close", "closed", log, test);
	//	WebDriverSupport.click(driver, from, "from", " from place", log, test);
	//	WebDriverSupport.sendKeys(driver, from, "from", "place", log, test, fro);
	//	WebDriverSupport.click(driver, to, "to", "place", log, test);
	//	WebDriverSupport.sendKeys(driver, to, "to", "place", log, test,too);
	//	WebDriverSupport.click(driver, desti, "to", "place", log, test);
		
	/*	WebDriverSupport.click(driver, pickup, "time", "click", log, test);
		
		Select dd=new Select(driver.findElement(pickup));
		dd.selectByVisibleText("12:45 AM");
		
		WebDriverSupport.click(driver, returncalendar, "return", "selected", log, test);
		WebDriverSupport.click(driver, date, "return", "date", log, test);*/
		
		WebDriverSupport.click(driver, select, "select", "selected", log, test);
		WebDriverSupport.click(driver, selectcar, "select", "selected", log, test);
		
		if(driver.findElement(bookingdetails).isDisplayed())
		{
			ExtentLogUtilities.pass(driver, test,"Successfully verified", log);
		}
		else {
			ExtentLogUtilities.fail(driver, test, "Verify failed", log);
		}
		
		WebDriverSupport.click(driver, home, "homepage", "Selected", log, test);
		
		
		}catch(Exception e) {
			throw new PageObjectException(e.getMessage());
		}
}}
