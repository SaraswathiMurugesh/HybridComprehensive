package uiStore;

import org.openqa.selenium.By;

public class OutstationUI {

	
	public static By from=By.xpath("//input[@id='fromCityList']");
	public static By to=By.xpath("//input[@placeholder='Start typing city - e.g. Mysore']");
	public static By desti=By.xpath("//span[contains(text(),'Chennai Central, Chennai')]");
	
	public static By calendar=By.xpath("//body/app-root[@id='approot']/mat-sidenav-container[1]/mat-sidenav-content[1]/app-home[1]/div[1]/app-home-container[1]/div[1]/div[1]/div[2]/app-outstation[1]/div[1]/form[1]/div[3]/div[1]/div[1]/p-calendar[1]/span[1]/input[1]");
	public static By date=By.xpath("//span[contains(text(),'20')]");
	public static By pickup=By.xpath("//select[@id='pickUpTime']");
	
	public static By select=By.xpath("//button[contains(text(),'Select Car')]");
	public static By verify=By.xpath("//header/div[1]/div[2]/div[1]/div[1]");
	public static By home=By.linkText("Home");
	//[@formcontrolname='departureDateControl']
}
//span[contains(text(),'15')]
	//input[@placeholder='dd-mm-yyyy']