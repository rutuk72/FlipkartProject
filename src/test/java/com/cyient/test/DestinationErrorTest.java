package com.cyient.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.Browser;
import com.cyient.page.FlightPage;
import com.cyient.page.LoginProcessPage;
import com.cyient.utilities.DataProviderUser;

public class DestinationErrorTest extends Browser {
	

	@Test(dataProvider = "citynamedata", dataProviderClass = DataProviderUser.class)
	
	public void destinationErrorTest(String city) throws InterruptedException {
		
		
		FlightPage main = new FlightPage(driver);
		main.closewindow();
		
		Thread.sleep(5000);
		main.clickonflight();
		
		Thread.sleep(3000);
		
		//Enter city into origin
		
		main.entercity(city);
		
		//click on search
		main.clickonsearch();
		
		//Destination error validation
		String expecteddestinationerror="destination cannot be empty";
		String actualdestinationerror=main.destinationerror();
		System.out.println(actualdestinationerror);
		Assert.assertEquals(actualdestinationerror, expecteddestinationerror);
		
		
	}


}
