package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import exceptions.PageObjectException;
import exceptions.ReusableComponentException;
import reusableComponents.WebDriverSupport;
import uiStore.AirportUI;

public class Airport extends AirportUI{

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public Airport(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void airport(String dropplace) throws ReusableComponentException, Exception {
		try {
			WebDriverSupport.click(driver, airport, "airport", "button", log, test);
		//	WebDriverSupport.click(driver, close, "close", "closed", log, test);
		//	Thread.sleep(3000);
		//	WebDriverSupport.click(driver, from, "from", "place", log, test);
		//	WebDriverSupport.click(driver, city, "from", "place", log, test);
		//	WebDriverSupport.sendKeys(driver, city, "from", "place", log, test,cityfro);
			WebDriverSupport.click(driver, trip, "trip", "selected", log, test);
			
			Select dd=new Select(driver.findElement(trip));
			dd.selectByValue("pick_airport");
			WebDriverSupport.click(driver, drop, "Airport page", "Drop bar", log, test);
			WebDriverSupport.sendKeys(driver, drop,"Airport page","dropdown", log, test, dropplace);
			WebDriverSupport.click(driver, address, "Address", "click", log, test);
			WebDriverSupport.click(driver, select, "select", "selected", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, selectcar, "select", "selected", log, test);
			WebDriverSupport.click(driver, home, "homepage", "Selected", log, test);
			}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}

}

