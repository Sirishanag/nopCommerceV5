package com.nopCommerce.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public WebDriver driver;
	public Properties configpropobj;
	public Logger logger=LogManager.getLogger(this.getClass());
		
	@BeforeClass
	@Parameters("browser")
	
	public  void setup(String br) throws IOException
	{
		
		//Load Properties.config file
		configpropobj=new Properties();
		FileInputStream configpfile =new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		configpropobj.load(configpfile);
		
		
		if(br.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
    
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	
	
    //Capture ScreenShot//
	
	public void CaptureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Scr=ts.getScreenshotAs(OutputType.FILE);
		File tar=new File(System.getProperty("user.dir")+"\\Screenshots"+"\\tname"+".png");
		FileUtils.copyFile(Scr, tar);
	}

	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return(generatedstring);
	}
	
	public String randomnumber()
	{
		String generatedstring1=RandomStringUtils.randomNumeric(7);
		return(generatedstring1);
	}
	
	
	
	
	
	
	
	
}



