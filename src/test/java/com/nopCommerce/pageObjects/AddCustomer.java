package com.nopCommerce.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {
	WebElement listitem;
	WebDriver ldriver;

	public AddCustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	By lnkCustomer_menu = By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	By lnkCustomer = By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	By btnadd = By.xpath("//a[@class='btn bg-blue']");
	By txtemail = By.xpath("//input[@id='Email']");
	By txtpass = By.xpath("//input[@id='Password']");
	By txtfirstname = By.xpath("//input[@id='FirstName']");
	By txtlastname = By.xpath("//input[@id='LastName']");
	By txtCompany = By.id("Company");
	By drpmgrOfVendor = By.xpath("//*[@id='VendorId']");
	By rdmgender = By.id("Gender_Male");
	By rdfgender = By.id("Gender_Female");
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	By txtcustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	By txtAdmincoment = By.xpath("//textarea[@id='AdminComment']");
	By btnSave = By.xpath("//button[@name='save']");
	By txtmsg = By.xpath("//div[@class='alert alert-success alert-dismissable']");
	

	// Action Methods//

	public void ClickonCustomer_menu() {
		ldriver.findElement(lnkCustomer_menu).click();
	}

	public void clickCustomer() {
		ldriver.findElement(lnkCustomer).click();
	}

	public void btnadd() {
		ldriver.findElement(btnadd).click();
	}

	public void setemail(String email) {
		ldriver.findElement(txtemail).sendKeys(email);
	}

	public void setPassword(String password) {
		ldriver.findElement(txtpass).sendKeys(password);
	}

	public void setCustomerRoles(String role) throws InterruptedException 
	{
	
		ldriver.findElement(txtcustomerRoles).click();
	
		Thread.sleep(3000);
		
		if(role.equals("Registered"))
		{
			listitem=ldriver.findElement(lstitemRegistered); 
		}
		else if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(lstitemAdministrators); 
		}
		else if(role.equals("Guests"))
		{
			// Here user can be Registered (or) Guest, only one
			ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click(); //delete registered
			listitem=ldriver.findElement(lstitemGuests);
		}
		else if(role.equals("Vendors"))
		{
			listitem=ldriver.findElement(lstitemVendors);
		}
		else
		{
			listitem=ldriver.findElement(lstitemGuests);
		}
				
		//listitem.click();  //Not working
		
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
}
	
//	public void setManagerOfVendor(String value)
//	{
//		Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
//		drp.selectByVisibleText(value);
//	}
	
	public void setVendor(String Value) {
		Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(Value);
	}

	
	public void setGender(String Gender) {
		if (Gender.equals("Male")) {
			ldriver.findElement(rdmgender).click();
		} else if (Gender.equals("Female")) {
			ldriver.findElement(rdfgender).click();
		} else {
			ldriver.findElement(rdfgender).click();
		}

	}

	public void setFirstName(String fname) {
		ldriver.findElement(txtfirstname).sendKeys(fname);
	}

	public void setLastName(String lname) {
		ldriver.findElement(txtlastname).sendKeys(lname);
	}

	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}

	public void setCompanyName(String comname) {
		ldriver.findElement(txtCompany).sendKeys(comname);
	}

	public void setAdminContent(String content) {
		ldriver.findElement(txtAdmincoment).sendKeys(content);
	}

	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
	}
	
	
	
	public boolean Verificationoftxtmsg() {
		String msg = ldriver.findElement(txtmsg).getText();
		if (msg.contains("The new customer has been added successfully")) {
			return true;
		} else {
			return false;
		}
	}

}
