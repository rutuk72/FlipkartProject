package com.cyient.test;

import org.testng.Assert;
import com.cyient.page.LoginProcessPage;
import org.testng.annotations.Test;

import com.cyient.base.Browser;
import com.cyient.page.FlightPage;

import com.cyient.page.LoginProcessPage;
import com.cyient.utilities.DataProviderUser;

public class FlightErrorTest extends Browser {

	@Test(dataProvider = "validCredentialExcelData", dataProviderClass = DataProviderUser.class)
	public void roundTripErrorTest(String username, String password, String expectedname) throws InterruptedException {
		
		//Login
		LoginProcessPage obj = new LoginProcessPage(driver);
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickOnLogin();

		FlightPage main = new FlightPage(driver);
		
		Thread.sleep(5000);
		
		//Click on Flight
		main.clickonflight();
		Thread.sleep(3000);

		//click on round trip
		

		main.clikonroundtrip();
		
		//click on search
		main.clickonsearch();
		
		//origin error validation
		String expectedoriginerror="origin cannot be empty";
		String actualoriginerror =main.originerror();
		System.out.println(actualoriginerror);
		Assert.assertEquals(actualoriginerror, expectedoriginerror);
		
		//Destination error validation
		String expecteddestinationerror="destination cannot be empty";
		String actualdestinationerror=main.destinationerror();
		System.out.println(actualdestinationerror);
		Assert.assertEquals(actualdestinationerror, expecteddestinationerror);
		
	
	}
	
	
	
}
