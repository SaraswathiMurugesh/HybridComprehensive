package uiStore;

import org.openqa.selenium.By;

public class CorporateUI {
	
	public static By corporatecar=By.linkText("Corporate Car Rental");
	public static By name=By.xpath("//input[@placeholder='Name*']");
	public static By company=By.xpath("//input[@placeholder='Company Name*']");
	public static By email=By.xpath("//input[@placeholder='Email Address*']");
	public static By phoneno=By.xpath("//input[@placeholder='Phone Number*']");
	public static By volume=By.xpath("//body/app-root[@id='approot']/mat-sidenav-container[1]/mat-sidenav-content[1]/app-corporate-car-rental-agency-india[1]/div[1]/div[2]/form[1]/div[5]/div[2]/select[1]");
	//public static By click=By.xpath("//option[contains(text(),'₹ 100,000 to ₹ 500,000')]");
	public static By submit=By.xpath("//span[contains(text(),'Submit')]");
	public static By msg=By.xpath("//div[contains(text(),'Thank You for Enquiring with us! Our Representativ')]");

}
