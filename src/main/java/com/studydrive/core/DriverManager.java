package com.studydrive.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    
    	System.out.println("****************Driver*************"+configurationManager.properties.getProperty("firefox.driver.path"));
		if(driver == null) driver = createDriver();
		return driver;

    }

    public WebDriver createDriver() {
    	
        switch (driverType) {	    
        case FIREFOX : 
/*       	FirefoxOptions firefoxOptions=new FirefoxOptions();
        	firefoxOptions.setAcceptInsecureCerts(true);
        	firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        	firefoxOptions.addArguments("use-fake-ui-for-media-stream");
        	//firefoxOptions.addPreference("permissions.default.microphone", 1);
        	//firefoxOptions.addPreference("permissions.default.camera", 1);
        	firefoxOptions.addPreference("media.navigator.permission.disabled",true); 
        	driver = new FirefoxDriver(firefoxOptions);*/
        	System.setProperty("webdriver.firefox.driver",configurationManager.properties.getProperty("firefox.driver.path"));
        	driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	System.setProperty("webdriver.chrome.driver",configurationManager.properties.getProperty("chrome.driver.path"));
//        	ChromeOptions options = new ChromeOptions();
//        	options.setAcceptInsecureCerts(true);
//            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//            options.addArguments("use-fake-ui-for-media-stream");
//            options.addArguments("test");
            //below lines from 55 to 60 is for headless browser support 
//            options.addArguments("--headless");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--disable-extensions");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--window-size=1580,1280");
//       	driver = new ChromeDriver(options);
        	driver = new ChromeDriver();
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
