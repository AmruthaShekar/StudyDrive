package com.studydrive.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.studydrive.core.BaseTestCase;

import com.studydrive.pages.SignInPage;

public class SignInPageTest extends BaseTestCase {
	
	@Parameters({"email", "password"})
	@Test
	public void firstTest(String email, String password ) throws InterruptedException, AWTException {
				
		SignInPage sip = new SignInPage(driver);
		sip.launchPage();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		sip.clickAcceptButton();
		sip.signUp(email, password);
/*		sip.genderSetUp();
		sip.setUniversity();
		sip.upDoc(); */
		sip.joinCourse();
		
	}
}
