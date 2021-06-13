package com.cyient.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.Browser;
import com.cyient.page.LoginProcessPage;
import com.cyient.page.LoginProcessPage;
import com.cyient.page.TelevisionSelect;
import com.cyient.utilities.DataProviderUser;
import com.cyient.page.LoginProcessPage;

public class PlaceOrder extends Browser {

	@Test(dataProvider = "validCredentialExcelData", dataProviderClass = DataProviderUser.class)
	public void LoginAndOrder(String username, String password, String expectedname) throws InterruptedException {

		LoginProcessPage obj = new LoginProcessPage(driver);

		// Enter username and password
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickOnLogin();

		// Validate actual and expected username
		String actualname = obj.getusertitle();
		System.out.println(actualname);
		Assert.assertEquals(actualname, expectedname);

		// search for television
		obj.selecttv("Television");
		obj.clickOnSearch();

		// new page object creation
		TelevisionSelect tvs = new TelevisionSelect(driver);
		Thread.sleep(2000);

		// selecting Mi brand and tv
		tvs.selectBrand();
		Thread.sleep(5000);
		tvs.selectTv();
		Thread.sleep(3000);

		// Handling and moving new tab
		Set<String> tabsession = driver.getWindowHandles();
		for (String tabs : tabsession) {
			System.out.println(tabsession);
			driver.switchTo().window(tabs);

		}

		Thread.sleep(3000);
		tvs.deletPin();

		// entering pin and check for that pincode
		tvs.enterpinone("411002");
		tvs.checkpin();
		Thread.sleep(2000);

		// Add to cart item
		tvs.addtocart();
		Thread.sleep(2000);

		// FOR SCROLLING
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");

		// Save for later
		Thread.sleep(2000);
		tvs.saveforlater();
		Thread.sleep(3000);

		// Move to cart
		js.executeScript("window.scrollBy(0,350)", "");
		tvs.movetocart();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-350)", "");

		// Change old pin
		tvs.changepin("600053");
		
		// check for new pin
		tvs.checknewpin();

		// Validate tv name 
		String actualtvname = tvs.validtvname();
		System.out.println(actualtvname);
		String expectedtvname = "Mi Q1 138.8 cm (55 inch) QLED Ultra HD (4K) Smart Android TV";
		Assert.assertEquals(actualtvname, expectedtvname);

		//validate tv price
		String actualtvprice = tvs.validtvprice();
		System.out.println(actualtvprice);
		String expectedtvprice = "₹57,999";
		Assert.assertEquals(actualtvprice, expectedtvprice);
		
		//Remove item from cart for multiple test run
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		tvs.removetv();
		

	}

}
