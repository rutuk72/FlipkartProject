package com.cyient.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUser {
	
	@DataProvider
	public Object[][] validCredentialExcelData() throws IOException{
Object[][] main= ExcelData.getSheet("src/test/resources/testdata/userdata.xlsx","Sheet1" );
return main;
		
	}
	
	@DataProvider
	public Object[][] citynamedata() throws IOException{
Object[][] main= ExcelData.getSheet("src/test/resources/testdata/userdata.xlsx","Sheet2" );
return main;
		
	}


}
