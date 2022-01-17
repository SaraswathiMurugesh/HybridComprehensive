package reusableComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import exceptions.UtilityException;
import utilities.ExcelSheetRead;

public class Base extends ExcelSheetRead {

	public Base() throws UtilityException, Exception {
		super();
	}

	static public WebDriver driver;

	public static WebDriver initialize() throws Exception {
		if (driver == null) {
			if (get.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + get.getProperty("path"));
				ChromeOptions opt = new ChromeOptions();
				opt.addArguments("--disable-notifications");
				driver = new ChromeDriver(opt);
			}
		}
		return driver;
	}
}


/*package reusableComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
		
	public static WebDriver driver;
	public Properties prop;
		
	public WebDriver initializeDriver() throws IOException
	{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\JARVIS\\eclipse-workspace-new\\Assessment\\src\\main\\resources\\config.properties");
			prop.load(fis);
			String browserName=prop.getProperty("browser");
			if(browserName.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\JARVIS\\eclipse-workspace-new\\Assessment\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
		}
}
*/