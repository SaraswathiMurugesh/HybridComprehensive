package pageObject;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import exceptions.PageObjectException;
import reusableComponents.WebDriverSupport;
import uiStore.TwitterUI;
import utilities.ExtentLogUtilities;

public class Twitter extends TwitterUI {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public Twitter(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void twitter(String Twittertitle) throws PageObjectException, Exception {
	try {
	
	WebDriverSupport.click(driver, twitter, "homepage","twitter icon", log, test);
	Thread.sleep(5000);
	Set<String> ids=driver.getWindowHandles();
	Iterator<String> it=ids.iterator();
	String parentid=it.next();
	String childid=it.next();
	Thread.sleep(10000);
	driver.switchTo().window(childid);
	Thread.sleep(10000);
	System.out.println(driver.getTitle());
	if(Twittertitle.equalsIgnoreCase(driver.getTitle())){

        ExtentLogUtilities.pass(driver, test, "Twitter page opened"+Twittertitle, log);
        driver.close();
     }else {
  	   ExtentLogUtilities.fail(driver, test, "Twitter page not opened"+Twittertitle, log);
  	   throw new PageObjectException("page not opened");
     }
		
	Thread.sleep(5000);
	driver.switchTo().window(parentid);
	
	}catch(Exception e) {
		throw new PageObjectException(e.getMessage());
	}
	
}
}