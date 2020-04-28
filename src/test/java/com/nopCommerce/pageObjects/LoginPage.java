package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="Email") 
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(name="Password") 
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath = "//input[@value='Log in']") 
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(linkText="Logout") 
	@CacheLookup
	WebElement lnklogout;
	
	public void setusername(String uname)
	{
		txtemail.clear();
		txtemail.sendKeys(uname);
	}
	
	public void setpassword(String pwrd)
	{
		txtpassword.clear();
		txtpassword.sendKeys(pwrd);
	}
	
	public void clickLogin() 
	{
		btnlogin.click();
	}
	
	public void clickLogout()
	{
		lnklogout.click();
	}
	
	

}
