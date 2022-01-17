package uiStore;

import org.openqa.selenium.By;

public class LocalUI {

	
	public static By local=By.xpath("//span[contains(text(),'Local')]");
	public static By close=By.xpath("//body/app-root[@id='approot']/mat-sidenav-container[1]/mat-sidenav-content[1]/app-home[1]/div[1]/app-home-container[1]/div[1]/div[1]/div[2]/app-local[1]/div[1]/form[1]/div[1]/a[1]/img[1]");
	public static By fromlocal=By.xpath("//input[@placeholder='Start typing city - e.g. Bangalore']");
    public static By select=By.xpath("//button[contains(text(),'Select Car')]");
    public static By selectcar=By.xpath("//button[contains(text(),'Select')]");
    public static By bookingdetails=By.xpath("//body/app-root[@id='approot']/mat-sidenav-container[1]/mat-sidenav-content[1]/app-booking[1]/div[2]/app-booking-summary[1]/div[1]/ngb-accordion[1]/div[1]/div[1]/button[1]/span[1]");
	public static By home=By.linkText("Home");
}
	
