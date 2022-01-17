package uiStore;

import org.openqa.selenium.By;

public class RoundtripUI {

	public static By outstation=By.xpath("//span[contains(text(),'Outstation')]");

	public static By radio=By.xpath("//label[contains(text(),'Round Trip')]");
	public static By close=By.xpath("//body/app-root[@id='approot']/mat-sidenav-container[1]/mat-sidenav-content[1]/app-home[1]/div[1]/app-home-container[1]/div[1]/div[1]/div[2]/app-local[1]/div[1]/form[1]/div[1]/a[1]/img[1]");
	public static By from=By.xpath("//input[@id='fromCityList']");
	public static By to=By.xpath("//input[@placeholder='Start typing city - e.g. Mysore']");
	public static By desti=By.xpath("//span[contains(text(),'Chennai Central, Chennai')]");
	public static By select=By.xpath("//button[contains(text(),'Select Car')]");
	public static By pickup=By.xpath("//select[@id='pickUpTime']");
    public static By selectcar=By.xpath("//button[contains(text(),'Select')]");
	public static By bookingdetails=By.xpath("//body/app-root[@id='approot']/mat-sidenav-container[1]/mat-sidenav-content[1]/app-booking[1]/div[2]/app-booking-summary[1]/div[1]/ngb-accordion[1]/div[1]/div[1]/button[1]/span[1]");
	public static By home=By.linkText("Home");
	public static By returncalendar=By.xpath("//body/app-root[@id='approot']/mat-sidenav-container[1]/mat-sidenav-content[1]/app-home[1]/div[1]/app-home-container[1]/div[1]/div[1]/div[2]/app-outstation[1]/div[1]/form[1]/div[3]/div[2]/div[1]/p-calendar[1]/span[1]/input[1]");
	public static By date=By.xpath("//span[contains(text(),'23')]");
	//span[contains(text(),'15')]
	//input[@placeholder='dd-mm-yyyy']
	//formcontrolname=returnDateControl
}
