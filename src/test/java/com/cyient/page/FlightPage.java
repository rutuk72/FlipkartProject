package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightPage {
	
	private WebDriver driver;

	private By Flightlocator= By.xpath("//img[@alt='Travel']");
	private By Roundtriplocator=By.xpath("//div[@data-checked='false']");
	private By searchtriplocator=By.xpath("//button[@type='button']");
	
	private By originerrorlocator=By.xpath("//div[normalize-space()='origin cannot be empty']");
	private By destinationerrorlocator=By.xpath("//div[normalize-space()='destination cannot be empty']");
	private By citylocator=By.xpath("//input[@name='0-departcity']");
	private By closewindowlocator=By.xpath("//button[contains(text(),'✕')]");
	
	

	public FlightPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickonflight() {
		driver.findElement(Flightlocator).click();
	}
	
	public void clikonroundtrip() {
		driver.findElement(Roundtriplocator).click();
	}
	
	public void clickonsearch() {
		driver.findElement(searchtriplocator).click();
		
	}
	
	public String originerror() {
		String errorone=driver.findElement(originerrorlocator).getText();
		return errorone;
	}
	
	public String destinationerror() {
		String errortwo=driver.findElement(destinationerrorlocator).getText();
		return errortwo;
	}
	
	
	public void entercity(String city) {
		driver.findElement(citylocator).sendKeys(city);
	}
	
	public void closewindow() {
		driver.findElement(closewindowlocator).click();
	}

}
