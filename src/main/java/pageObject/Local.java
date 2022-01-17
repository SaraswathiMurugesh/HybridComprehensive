package pageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import exceptions.PageObjectException;
import exceptions.ReusableComponentException;
import reusableComponents.WebDriverSupport;
import uiStore.LocalUI;
import utilities.ExtentLogUtilities;
public class Local extends LocalUI {

		WebDriver driver;
		Logger log;
		ExtentTest test;

		public Local(WebDriver driver, Logger log, ExtentTest test) throws Exception {
			this.driver = driver;
			this.test = test;
			this.log = log;
		}

		public void local(String localfro) throws ReusableComponentException, Exception {
			try {
				WebDriverSupport.click(driver, local, "local", "place", log, test);
				WebDriverSupport.click(driver, close, "close", "closed", log, test);
				WebDriverSupport.click(driver, fromlocal, "from", "place", log, test);
				WebDriverSupport.sendKeys(driver, fromlocal, "from", "place", log, test,localfro);
				WebDriverSupport.click(driver, select, "select", "selected", log, test);
				Thread.sleep(5000);
				WebDriverSupport.click(driver, selectcar, "select", "selected", log, test);
				
				if(driver.findElement(bookingdetails).isDisplayed())
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
