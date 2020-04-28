package com.nopCommerce.testCase;

import java.io.IOException;

import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.testBase.BaseClass;

public class Tc_Logintest_001 extends BaseClass
{
	@Test
	public void Logintest() throws IOException
	{
		logger.info("************LoginTest001***********");
		driver.get(configpropobj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		logger.info("************Sending Data***********");
		lp.setusername(configpropobj.getProperty("useremail"));
		lp.setpassword(configpropobj.getProperty("password"));
		logger.info("********clicking on loginbutton**********");
		lp.clickLogin();
		logger.info("***********Validating the Test**********");
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		if(exp_title.equals(act_title))
		{
			logger.info("**********Login Test Passed********");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("***********Login Test Failed************");
			CaptureScreen(driver,"Logintest");
			Assert.assertTrue(false);
		}
		}
	


}
