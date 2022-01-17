package runner;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import exceptions.ApplicationException;
import exceptions.UtilityException;
import pageObject.Signin;
import pageObject.Twitter;
import pageObject.Logout;
import pageObject.ValidateTitle;
import pageObject.Airport;
import pageObject.DownloadApp;
import pageObject.Local;
import pageObject.Outstation;
import pageObject.Roundtrip;
import pageObject.Corporate;
import reusableComponents.Base;
import utilities.ExtentLogUtilities;
import utilities.GetProperties;

//import com.mindtree.pageObject.ValidPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class RentalCar extends Base{
		static Logger log;
		static ExtentTest test;
		static ExtentReports report;

		public RentalCar() throws UtilityException, Exception {
			super();
		}

		@BeforeTest()
		public void initializeDriver() throws ApplicationException {
			try {
				report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "ExtentReportResults-"
						+ System.currentTimeMillis() + "-.html");
				log = Logger.getLogger(RentalCar.class.getName());
				driver = initialize();
				test = report.startTest("Home Page");
				driver.get(GetProperties.get.getProperty("url"));
				driver.manage().window().maximize();
				 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				ExtentLogUtilities.pass(driver, test, "URL Opened", log);
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				throw new ApplicationException(e.getMessage());
			}
		}
		
		@Test(priority = 1,dataProvider = "getTitle")
		public void validateTitle(String title) throws ApplicationException {
			test = report.startTest("Validate Title");
			try {
				new ValidateTitle(driver, log, test).validate(title);
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}
		@DataProvider
		public Object[] getTitle() {
			Object data[] = new Object[1];
			data[0] = get.getProperty("title");
			return data;
		}
		
		@Test(priority = 2,dataProvider ="getData")
		public void Login(String uid,String pw) throws ApplicationException {
			test = report.startTest("Log in");
			try {
				new Signin(driver, log, test).login(uid,pw);
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}
	

		@DataProvider
		public Object[] getData() {
			Object data[][]=new Object[1][2];
			data[0][0]=excelData.get("id");
			data[0][1]=excelData.get("pw");
			return data;		
		}
		
		@Test(priority = 3,dataProvider ="getData1")
		public void outstation(String fro,String too) throws ApplicationException {
			test = report.startTest("Out station");
			try {
				new Outstation(driver, log, test).outstation(fro,too);
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}

		@DataProvider
		public Object[] getData1() {
			Object data[][]=new Object[1][2];
			data[0][0]=excelData.get("fro");
			data[0][1]=excelData.get("too");
			return data;		
		}
		
		@Test(priority = 4,dataProvider ="getData2")
		public void local(String localfro) throws ApplicationException {
			test = report.startTest("Local");
			try {
				new Local(driver, log, test).local(localfro);
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}

		@DataProvider
		public Object[] getData2() {
			Object data[][]=new Object[1][1];
			data[0][0]=excelData.get("localfro");
			return data;		
		}
		
		@Test(priority = 5,dataProvider ="getData3")
		public void airport(String dropplace) throws ApplicationException {
			test = report.startTest("Airport");
			try {
				new Airport(driver, log, test).airport(dropplace);
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}

		@DataProvider
		public Object[] getData3() {
			Object data[][]=new Object[1][1];
			data[0][0]=excelData.get("dropplace");
			return data;		
		}
		
		@Test(priority = 6, dataProvider="getData4")
		public void Download(String id,String pw) throws ApplicationException {
			test = report.startTest("Playstore");
			try {
				new DownloadApp(driver, log, test).download(id,pw);
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}
		
		@DataProvider
		public Object[] getData4() {
			Object data[][]=new Object[1][2];
			data[0][0]=excelData.get("id");
			data[0][1]=excelData.get("pw");
			return data;		
		}
		
		@Test(priority = 7, dataProvider="getData5")
		public void Corporate(String corporatename, String corporatecompany,String corporatemail,String phonenumber) throws ApplicationException {
			test = report.startTest("Corporate");
			try {
				new Corporate(driver, log, test).corporate(corporatename,corporatecompany,corporatemail,phonenumber);
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}
		
		@DataProvider
		public Object[] getData5() {
			Object data[][]=new Object[1][4];
			data[0][0]=excelData.get("corporatename");
			data[0][1]=excelData.get("corporatecompany");
			data[0][2]=excelData.get("corporatemail");
			data[0][3]=excelData.get("phonenumber");
			return data;		
		}
		
		@Test(priority = 8)
		public void roundtrip() throws ApplicationException {
			test = report.startTest("Round trip");
			try {
				new Roundtrip(driver, log, test).roundtrip();
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}

	/*	@DataProvider
		public Object[] getData6() {
			Object data[][]=new Object[1][2];
			data[0][0]=excelData.get("fro");
			data[0][1]=excelData.get("too");
			return data;		
		}*/
		
		@Test(priority = 9,dataProvider = "getData7")
		public void TwitterTitle(String Twittertitle) throws ApplicationException {
			test = report.startTest("Twitter Title");
			try {
				new Twitter(driver, log, test).twitter(Twittertitle);
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}
		
		@DataProvider
		public Object[] getData7() {
			Object data[][]=new Object[1][1];
			data[0][0]=excelData.get("Twittertitle");
			return data;		
		}
		
		@Test(priority = 10)
		public void Logout() throws ApplicationException {
			test = report.startTest("Logout");
			try {
				new Logout(driver, log, test).logout();
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}
		
		@AfterTest
		public void closeInstance() {
			driver.close();
		}

}
