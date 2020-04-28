package com.nopCommerce.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.AddCustomer;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.SearchCustomer;
import com.nopCommerce.testBase.BaseClass;

public class Tc_SearchCustomerbyName_005 extends BaseClass {
@Test
public void SearchCustomerbyName() throws IOException, InterruptedException {

	logger.info("************Test Started SearchCustomerbyName_005***********");
	
	driver.get(configpropobj.getProperty("baseURL"));
	LoginPage lp = new LoginPage(driver);
	lp.setusername(configpropobj.getProperty("useremail"));
	lp.setpassword(configpropobj.getProperty("password"));
	lp.clickLogin();
	
	logger.info("*****Clicking on Customers menu************");
	
	AddCustomer ac = new AddCustomer(driver);
	ac.ClickonCustomer_menu();
	ac.clickCustomer();
	
	
	
	
	SearchCustomer searchcust= new SearchCustomer(driver);
	searchcust.setFirstName("John")	;
	searchcust.setLastName("Smith");
	
	searchcust.clickSearch();
	Thread.sleep(3000);
	
	boolean Status=searchcust.searchCustomerByName("John Smith");
	if(Status==true)
	{
		logger.info("*****Search Customer passed************");
		Assert.assertTrue(true);
		}
	else
	{
		logger.info("****************Searching customer failed***********");
		CaptureScreen(driver,"SearchCustomerbyName");
		Assert.assertTrue(false);
		
	}
		
	
}
	
	
	
	
	
}
