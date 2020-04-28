package com.nopCommerce.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.AddCustomer;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.testBase.BaseClass;

public class Tc_AddnewCustomer_003 extends BaseClass {

	@Test
	public void AddnewCustomer() throws InterruptedException

	{
		logger.info("************Login***********");
		driver.get(configpropobj.getProperty("baseURL"));
		LoginPage lp = new LoginPage(driver);
		lp.setusername(configpropobj.getProperty("useremail"));
		lp.setpassword(configpropobj.getProperty("password"));
		lp.clickLogin();
		logger.info("***************Adding New Customer**************");
		AddCustomer ac = new AddCustomer(driver);
		ac.ClickonCustomer_menu();
		ac.clickCustomer();
		ac.btnadd();
		String email = randomstring() + "@gmail.com";
		ac.setemail(email);
		ac.setPassword("asder");
		
		ac.setCustomerRoles("Vendors");
		Thread.sleep(3000);
		ac.setVendor("Vendor 2");
		Thread.sleep(3000);
		ac.setGender("Female");
		ac.setFirstName("Sirisha");
		ac.setLastName("Naga");
		ac.setDob("04/26/1986");
		ac.setCompanyName("amazon");
		Thread.sleep(3000);
		
		ac.setAdminContent("WelCome");
		ac.clickOnSave();
		Thread.sleep(2000);
		
		
		logger.info("*******************Verification****************");
		if (ac.Verificationoftxtmsg()) {
			logger.info("****************Test Passed******************");
			Assert.assertTrue(true);
		} else {

			logger.warn("************Test Failed******************");
			Assert.assertTrue(false);
		}

	}

}
