package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import exceptions.PageObjectException;
import exceptions.ReusableComponentException;
import reusableComponents.WebDriverSupport;
import uiStore.LogoutUI;
import utilities.ExtentLogUtilities;

public class Logout extends LogoutUI{

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public Logout(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void logout() throws ReusableComponentException, Exception {
		try {
			
			WebDriverSupport.click(driver, myacc, "Homepage","myacc", log, test);
			Thread.sleep(5000);
		    WebDriverSupport.click(driver, logout, "Account Log out", "logout button", log, test);
		   if(driver.findElement(signin).isDisplayed())
		   {
			   ExtentLogUtilities.pass(driver, test,"Successfully Logged out", log);
		   }else
		   {
			   ExtentLogUtilities.fail(driver, test, "Failed to Logout", log);
		   }
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
}

