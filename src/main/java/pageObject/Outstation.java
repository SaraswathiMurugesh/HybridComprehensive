package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import exceptions.PageObjectException;
import exceptions.ReusableComponentException;
import reusableComponents.WebDriverSupport;
import uiStore.OutstationUI;
import utilities.ExtentLogUtilities;

public class Outstation extends OutstationUI {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public Outstation(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void outstation(String fro,String too) throws ReusableComponentException, Exception {
		try {
			WebDriverSupport.click(driver, from, "from", " from place", log, test);
			WebDriverSupport.sendKeys(driver, from, "from", "place", log, test, fro);
			WebDriverSupport.click(driver, to, "to", "place", log, test);
			WebDriverSupport.sendKeys(driver, to, "to", "place", log, test,too);
			WebDriverSupport.click(driver, desti, "to", "place", log, test);
			
		/*	WebDriverSupport.click(driver, calendar, "calendar", "click", log, test);
			WebDriverSupport.click(driver, date, "date", "click", log, test);
			
	        WebDriverSupport.click(driver, pickup, "time", "click", log, test);
			Select dd=new Select(driver.findElement(pickup));
			dd.selectByVisibleText("12:45 AM");
			*/
			WebDriverSupport.click(driver, select, "select", "selected", log, test);
			
			if(driver.findElement(verify).isDisplayed())
			{
				ExtentLogUtilities.pass(driver, test,"Successfully verified", log);
			}
			else {
				ExtentLogUtilities.fail(driver, test, "Verify failed", log);
			}
			
			WebDriverSupport.click(driver, home, "homepage", "Selected", log, test);
			}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
}

