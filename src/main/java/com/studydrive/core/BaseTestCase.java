package com.studydrive.core;

import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class BaseTestCase {
	
	static Date now = new Date();
	public static String TimeStamp = now.toString().replace(":", "-");
	public static WebDriver driver;

	DriverManager driverManager = new DriverManager();
	public static String baseurl="";
	
	@BeforeTest
	public void beforeTest() {
		driver = driverManager.getDriver();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().deleteAllCookies();		
	}
		
	@AfterTest
	public void afterTest() {
		driverManager.quitDriver();
	} 
}
