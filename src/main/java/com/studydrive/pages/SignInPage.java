package com.studydrive.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignInPage {
	
	WebDriver driver;
		
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
  public void launchPage() throws InterruptedException {						
		driver.get("https://www.studydrive.net/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}
   		
  public void clickAcceptButton() throws AWTException {
  Robot robot = new Robot();
  for (int i = 0; i <7; i++) {
      robot.keyPress(KeyEvent.VK_TAB); 
      robot.keyRelease(KeyEvent.VK_TAB); 
  }  
  robot.keyPress(KeyEvent.VK_ENTER);
  robot.keyRelease(KeyEvent.VK_ENTER);  
  
  if ("Studydrive - Free university study notes and summaries".equals(driver.getTitle())) {
	    System.out.println("We are on the home page");
	} else {
	    System.out.println("We are not on the home page");
	}	  
  }
   
  @FindBy(xpath = "//button[text()='Log in']")
	WebElement logIn;
  
  @FindBy(xpath = "//input[@type='email']")
	WebElement emailAddress;

  @FindBy(xpath = "//input[@type='password']")
 	WebElement password;
  
  @FindBy(xpath = "(//button[normalize-space()='Log in'])[2]")
	WebElement submit;
  
  @FindBy(id = "username")
	WebElement userName;
  
  @FindBy(xpath = "//div[@class='w-full inline-flex items-center']")
	WebElement gender;
  
  @FindBy(xpath = "//button[@class='btn btn-cta-surfaced btn-sm neutral self-end w-full py-3']")
	WebElement continueButton;    
  
  @FindBy(xpath = "//input[@placeholder='Enter university name']")
	WebElement universityNumberEntry;
  
  @FindBy(xpath = "//input[@placeholder='Select field of study']")
	WebElement selectFieldOfStudy;
  
  @FindBy(xpath = "//input[@placeholder='Select study program']")
	WebElement selectprogramToStudy;
  
  @FindBy(xpath = "//input[@placeholder='Select your starting semester']")
	WebElement selectSemister;
  
  @FindBy(xpath = "//span[@class='text-white-100']")
	WebElement submitProfile;
  
  @FindBy(xpath = "//i[@class='icon icon-add-file h-7 w-7 text-white-100']")
 	WebElement upload;
    
  @FindBy(xpath = "//button[normalize-space()='Send verification again']")
	WebElement verification;
  
  @FindBy(xpath = "//button[@id='courses-button']")
 	WebElement courseButton;
  
  @FindBy(xpath = "//span[@class='float-left icon icon-add w-5 h-5 text-blue-600']")
	WebElement clickAddButton;

  @FindBy(xpath = "(//div[@class='container'])[2]//child::a[text()='Quality Assurance']")
	WebElement viewCourse;
  
  @FindBy(xpath = "(//button[normalize-space()='Join course']")
	WebElement joinCourse;
  
  public NewsFeedPage signUp(String email, String pasword) {	
	  new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(logIn)).click();
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  emailAddress.sendKeys(email);
	  password.sendKeys(pasword);	
	  submit.click();
	  return new NewsFeedPage();
	  
  }
  
/*  public void genderSetUp() {		  
	  userName.clear();
	  userName.sendKeys("Amrutha Shekar");
	  gender.click();
	  continueButton.click();
	  
  }
  
  public void setUniversity() throws InterruptedException {	
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", universityNumberEntry);
	  new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(universityNumberEntry)).sendKeys("987654321");
	  Thread.sleep(3000);
	  universityNumberEntry.sendKeys("987654321");
	  new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(universityNumberEntry))
	  Thread.sleep(3000);
	  universityNumberEntry.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(2000);	  
	  universityNumberEntry.sendKeys(Keys.ENTER);	  
	  selectFieldOfStudy.sendKeys("Engineering");
	  Thread.sleep(2000);	  
	  selectFieldOfStudy.sendKeys(Keys.ENTER);
	  selectprogramToStudy.sendKeys("Engineering");
	  Thread.sleep(2000);	  
	  selectprogramToStudy.sendKeys(Keys.ENTER);
	  selectSemister.sendKeys("2023");
	  Thread.sleep(2000);
	  selectSemister.sendKeys(Keys.ARROW_DOWN);
	  selectSemister.sendKeys(Keys.ENTER);
	  submitProfile.click();
	  universityNumberEntry.clear();
	  universityNumberEntry.sendKeys("987654321");
	  gender.click();
	  continueButton.click();	  
  } 
  
  public void verifyEmail() {	  
	  upload.click();
	  verification.click();  } */
  
  public void joinCourse() throws InterruptedException {
	  courseButton.click();
	  clickAddButton.click();
	  viewCourse.click();
	  if ("Quality Assurance at 987654321 - Studydrive".equals(driver.getTitle())) {
		    System.out.println("We are on the join course page");
		} else {
		    System.out.println("We are not on the join course page");
		}
	  new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(joinCourse)).click();
	  joinCourse.click();
	  
  }
  
	  
  }
 

