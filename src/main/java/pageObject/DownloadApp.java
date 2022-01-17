package pageObject;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import exceptions.PageObjectException;
import reusableComponents.WebDriverSupport;
import uiStore.DownloadappUI;
import utilities.ExtentLogUtilities;

public class DownloadApp  extends DownloadappUI{

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public DownloadApp(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void download(String id, String pw) throws PageObjectException, Exception {
	try {
	WebDriverSupport.click(driver, appicon, "click","Downloadicon", log, test);
	Set<String>ids=driver.getWindowHandles();
	Iterator<String> it=ids.iterator();
	String parentid=it.next();
	String childid=it.next();
	Thread.sleep(5000);
	driver.switchTo().window(childid);
	Thread.sleep(5000);
	
	if(driver.findElement(playstore).isDisplayed()){

          ExtentLogUtilities.pass(driver, test, "Playstore detail shown", log);
          driver.close();
       }else {
    	   ExtentLogUtilities.fail(driver, test, "App detail not shown", log);
       }
		
	driver.switchTo().window(parentid);
	
	WebDriverSupport.click(driver,travelagent, "Travelagent", "icon", log, test);
	Thread.sleep(2000);
	Set<String>idss=driver.getWindowHandles();
	Iterator<String> it1=idss.iterator();
	String parentid1=it1.next();
	String childid1=it1.next();
	Thread.sleep(5000);
	driver.switchTo().window(childid1);
	Thread.sleep(5000);
	WebDriverSupport.click(driver, login, "login", "button", log, test);
	WebDriverSupport.sendKeys(driver, email, "account log in", "email", log, test, id);
	WebDriverSupport.sendKeys(driver, password, "account log in", "password", log, test, pw);
	WebDriverSupport.click(driver, loginbutton, "account log in", "login", log, test);
	
	if(driver.findElement(alert).isDisplayed()){

        ExtentLogUtilities.pass(driver, test, "Alert shown", log);
        driver.close();
     }else {
  	   ExtentLogUtilities.fail(driver, test, "Alert not shown", log);
     }
		
	driver.switchTo().window(parentid1);
	
	}
	catch(Exception e) {
		throw new PageObjectException(e.getMessage());
	}
	}
}