package com.studydrive.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.studydrive.core.ConfigurationManager;
import com.studydrive.enums.DriverType;

public class DriverManager {
	
	private WebDriver driver;
	private static DriverType driverType;
	ConfigurationManager configurationManager=new ConfigurationManager();
    
    public DriverManager() {    	
    	driverType=configurationManager.getBrowser();
    }

    public WebDriver getDriver() {   	
		if(driver == null) driver = createDriver();
		return driver;

    }

    public WebDriver createDriver() {    	
        switch (driverType) {	    
        case FIREFOX : 
        	System.setProperty("webdriver.firefox.driver",configurationManager.properties.getProperty("firefox.driver.path"));
        	driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	System.setProperty("webdriver.chrome.driver",configurationManager.properties.getProperty("chrome.driver.path"));
        	ChromeOptions options = new ChromeOptions();
        	options.addArguments("--remote-allow-origins=*");
        	WebDriver driver = new ChromeDriver(options);
        	driver = new ChromeDriver(options);
    		break;
        case INTERNETEXPLORER : 
        	System.setProperty("webdriver.ie.driver",configurationManager.properties.getProperty("ie.driver.path"));
        	driver = new InternetExplorerDriver();
    		break;    		
		default:
			System.setProperty("webdriver.chrome.driver",configurationManager.properties.getProperty("chrome.driver.path"));
        	driver = new ChromeDriver();
        	break;
        }
		return driver;
    }
    
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
