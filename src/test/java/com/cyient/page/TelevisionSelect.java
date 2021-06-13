package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TelevisionSelect {
	
	private By milocator= By.xpath("//div[@title='Mi']//div[@class='_24_Dny']");
	private By tvlocator= By.xpath("//div[normalize-space()='Mi Q1 138.8 cm (55 inch) QLED Ultra HD (4K) Smart Android TV']");
	private By pinlocator= By.xpath("//input[@id='pincodeInputId']");
	private By addtocartlocator=By.xpath("//button[normalize-space()='ADD TO CART']");
	private By checkpinlocator= By.xpath("//span[@class='_2P_LDn']");
	private By saveforlaterlocator= By.xpath("//div[normalize-space()='Save for later']");
	private By movetocartlocator= By.xpath("//div[normalize-space()='Move to cart']");
	private By clickonoldpinlocator= By.xpath("//div[@class='_3gc7Vf']");
	private By enternewpinlocator =By.xpath("//input[@placeholder='Enter delivery pincode']");
	private By checknewpinlocator =By.xpath("//span[@class='UgLoKg']");
	private By validtvnamelocator =By.xpath("//a[contains(text(),'Mi Q1 138.8 cm (55 inch) QLED Ultra HD (4K) Smart ')]");
	private By checktvpricelocator =By.xpath("//span[@class='_2-ut7f _1WpvJ7']");
	private By removetvlocator =By.xpath("//div[normalize-space()='Remove']");
	
private WebDriver driver;
	
	
	public TelevisionSelect(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void selectBrand() {
		
		driver.findElement(milocator).click();
	}
	
	public void selectTv() {
		driver.findElement(tvlocator).click();
	}
	
	
	public void deletPin() {
		driver.findElement(pinlocator).clear();
	}
	
	public void enterpinone(String pin) {
		driver.findElement(pinlocator).sendKeys(pin);
		
	}
	
	public void checkpin() {
		driver.findElement(checkpinlocator).click();
	}
	

	
	public void addtocart() {
		driver.findElement(addtocartlocator).click();
	}
	
	public void saveforlater() {
		driver.findElement(saveforlaterlocator).click();
	}
	
	public void movetocart() {
		driver.findElement(movetocartlocator).click();
	}
	
	public void changepin(String pin) throws InterruptedException {
		driver.findElement(clickonoldpinlocator).click();
		Thread.sleep(1000);
		driver.findElement(enternewpinlocator).sendKeys(pin);
	}
	
	public void checknewpin() {
		driver.findElement(checknewpinlocator).click();
	}
	
	public String validtvname() {
		String tvname = driver.findElement(validtvnamelocator).getText();
	
		return tvname;	
	}
	
	public String validtvprice() {
		String tvprice=driver.findElement(checktvpricelocator).getText();
		return tvprice;
	}
	
	public void removetv() {
		driver.findElement(removetvlocator).click();
	}
	

}
