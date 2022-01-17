package pageObject;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import exceptions.PageObjectException;
import reusableComponents.WebDriverSupport;
import uiStore.CorporateUI;
import utilities.ExtentLogUtilities;

public class Corporate extends CorporateUI{

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public Corporate(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void corporate(String corporatename, String corporatecompany,String corporatemail,String phonenumber) throws PageObjectException, Exception {
	try {
	WebDriverSupport.click(driver, corporatecar, "click","link", log, test);
	Set<String>ids=driver.getWindowHandles();
	Iterator<String> it=ids.iterator();
	String parentid=it.next();
	String childid=it.next();
	Thread.sleep(5000);
	driver.switchTo().window(childid);
	Thread.sleep(5000);
	
	WebDriverSupport.click(driver, name, "send", "name", log, test);
	WebDriverSupport.sendKeys(driver, name, "send","name", log, test,corporatename);
	WebDriverSupport.click(driver, company, "select", "company", log, test);
	WebDriverSupport.sendKeys(driver, company, "select", "company", log, test, corporatecompany);
	WebDriverSupport.click(driver, email, "select", "email", log, test);
	WebDriverSupport.sendKeys(driver, email, "select", "emaily", log, test, corporatemail);
	WebDriverSupport.click(driver, phoneno, "select", "phoneno", log, test);
	WebDriverSupport.sendKeys(driver, phoneno, "select", "phonenno", log, test, phonenumber);
	
	WebDriverSupport.click(driver, volume, "business", "volume", log, test);
	
	Select dd=new Select(driver.findElement(volume));
	dd.selectByValue("100000to500000");
	
	WebDriverSupport.click(driver, submit, "submit", "button", log, test);
	
	if(driver.findElement(msg).isDisplayed()){

          ExtentLogUtilities.pass(driver, test, "Message displayed", log);
          driver.close();
       }else {
    	   ExtentLogUtilities.fail(driver, test, "Message not display", log);
       }
		
	driver.switchTo().window(parentid);
	
//	WebDriverSupport.click(driver,travelagent, "Travelagent", "icon", log, test);
	Thread.sleep(2000);
	}catch(Exception e) {
		throw new PageObjectException(e.getMessage());
	}
}}
