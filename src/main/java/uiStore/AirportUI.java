package uiStore;

import org.openqa.selenium.By;

public class AirportUI {

	
	public static By airport=By.xpath("//span[contains(text(),'Airport')]");

	public static By close=By.xpath("//body/app-root[@id='approot']/mat-sidenav-container[1]/mat-sidenav-content[1]/app-home[1]/div[1]/app-home-container[1]/div[1]/div[1]/div[2]/app-local[1]/div[1]/form[1]/div[1]/a[1]/img[1]");
	public static By from=By.xpath("//input[@id='fromCityList']");
	public static By city=By.xpath("//input[@placeholder='Start typing city - e.g. Cochin']");
   public static By trip=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-local/div/form/div[2]/div/select");
   public static By drop=By.xpath("//input[@id='search_places']");
   public static By address=By.xpath("//span[contains(text(),'Temple Tree Apartments')]");
   public static By select=By.xpath("//button[contains(text(),'Select Car')]");
   public static By selectcar=By.xpath("//button[contains(text(),'Select')]");
   public static By home=By.linkText("Home");


}