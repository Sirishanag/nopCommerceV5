package com.nopCommerce.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.AddCustomer;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.SearchCustomer;
import com.nopCommerce.testBase.BaseClass;

public class Tc_SearchCustomerbyEmail_004 extends BaseClass {
	@Test
	public void SearchCustomerbyEmail() throws IOException, InterruptedException {

		logger.info("************Test Started SearchCustomerbyEmail_004***********");
		
		driver.get(configpropobj.getProperty("baseURL"));
		LoginPage lp = new LoginPage(driver);
		lp.setusername(configpropobj.getProperty("useremail"));
		lp.setpassword(configpropobj.getProperty("password"));
		lp.clickLogin();
		
		logger.info("*****Clicking on Customers menu************");
		
		AddCustomer ac = new AddCustomer(driver);
		ac.ClickonCustomer_menu();
		ac.clickCustomer();
		SearchCustomer serachcust=new SearchCustomer(driver);
		serachcust.setEmail("victoria_victoria@nopCommerce.com");
		
		serachcust.clickSearch();
		
		Thread.sleep(5000);
		
		boolean status=serachcust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	
	
		
}

}