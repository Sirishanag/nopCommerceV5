package com.nopCommerce.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce.Utilits.XLutils;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.testBase.BaseClass;

public class Tc_LoginDDT_002  extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void LoginTest(String uname,String Pwd,String exp) throws InterruptedException
	{
		driver.get(configpropobj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		logger.info("************Sending Data***********");
		lp.setusername(uname);
		lp.setpassword(Pwd);
		logger.info("********clicking on loginbutton**********");
		lp.clickLogin();
		Thread.sleep(3000);
		
		String exp_title="Dashboard / nopCommerce administration123";
		String act_title=driver.getTitle();
		
		if(exp_title.equals(act_title)) 
		{
			if(exp.equals("Pass"))
			{
				logger.info("********Login Passed**********");
				lp.clickLogout();
				Assert.assertTrue(true);
				}
			else if(exp.equals("Fail"))
			{
				logger.warn("*****************Login Failed*****************");
				lp.clickLogout();
				Assert.assertTrue(false);
			}
			else if (!exp_title.equals(act_title))
			{
				if(exp.equals("Pass"))
				{
					logger.info("********Login Failed**********");
					Assert.assertTrue(false);
					}
				else if(exp.equals("Fail"))
				{
					logger.warn("*****************Login passed*****************");
					Assert.assertTrue(true);
				}
			
			}
		}
		logger.info("****************DataDriven Test Finishad****************");
		
	}
	@DataProvider(name="LoginData")
	public String[][] getdata() throws IOException
	{
		String path=System.getProperty("user.dir")+"//TestData//Logindata.xlsx";
		int row=XLutils.getRowCount(path, "sheet1");
		int cell=XLutils.getCellCount(path, "sheet1", 1);
		String logindata[][]=new String[row][cell];
		for(int r=1;r<=row;r++) 
		{
			for(int c=0;c<cell;c++) 
			{
				logindata[r-1][c]=XLutils.getCellData(path, "sheet1", r, c);
			}
		}
		return logindata;
		
		
		
	}

	
	
}
