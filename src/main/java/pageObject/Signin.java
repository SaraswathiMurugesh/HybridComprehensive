package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import exceptions.ReusableComponentException;
import reusableComponents.WebDriverSupport;
import uiStore.SigninUI;
import utilities.ExtentLogUtilities;
import exceptions.PageObjectException;
import com.relevantcodes.extentreports.ExtentTest;

public class Signin extends SigninUI {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public Signin(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void login(String uid,String pw) throws ReusableComponentException, Exception {
		try {
			
			WebDriverSupport.click(driver, signin, "Homepage","signin", log, test);
			Thread.sleep(5000);
			WebDriverSupport.sendKeys(driver, email, "Account Log in","Email", log, test, uid);
		    WebDriverSupport.sendKeys(driver, password, "Account Log in", "Password", log, test, pw);
		    WebDriverSupport.click(driver, loginbutton, "Account Log in", "Signin button", log, test);
		   if(driver.findElement(myacc).isDisplayed())
		   {
			   ExtentLogUtilities.pass(driver, test,"Successfully Logged in", log);
		   }else
		   {
			   ExtentLogUtilities.fail(driver, test, "Failed to Login", log);
		   }
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
}