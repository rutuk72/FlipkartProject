package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginProcessPage {
	
	private By loginlocator=By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']");
	private By usernamelocator= By.xpath("//input[@class='_2IX_2- VJZDxU']");
	private By passwordlocator= By.xpath("//input[@type='password']");
	private By usertitlelocator=By.xpath("//div[contains(text(),'Rutwik')]");
	private By searchboxlocator=By.xpath("//input[@placeholder='Search for products, brands and more']");
	
	private By searchlocator=By.xpath("//button[@type='submit']//*[local-name()='svg']");
			
//	private By tvlocator=By.xpath("//img[@alt='Appliances']");
//	private By televisionlocator=By.xpath("//a[text()='Televisions']");
	private WebDriver driver;
	
	//driver
	

	public LoginProcessPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void clickOnLogin()
	{
		driver.findElement(loginlocator).click();
	}
	
	public void enterusername(String username) {
		driver.findElement(usernamelocator).sendKeys(username);
	}


	public void enterpassword(String password) {
		driver.findElement(passwordlocator).sendKeys(password);
	}
	
	public String getusertitle() {
		String actualname= driver.findElement(usertitlelocator).getText();	
		return actualname;
		
	}
	
	
	public void selecttv(String tv) {
		driver.findElement(searchboxlocator).sendKeys(tv);
	
	}
	
	public void clickOnSearch() {
		driver.findElement(searchlocator).click();
		
	}
	

	
	
	
}
