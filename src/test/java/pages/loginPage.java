package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class loginPage {
	
	WebDriver driver = BaseClass.driver;
	ExtentTest test = BaseClass.test;
	
	
	//============================ WebElements ===============================	
	
	@FindBy(className="login")
	WebElement loginlink;
	
	@FindBy(name="user_login")
	WebElement Username;
	
	@FindBy(name="user_pwd")
	WebElement password;
	
	@FindBy(className="rememberMe")
	WebElement Remer;
	
	@FindBy(name="btn_login")
	WebElement loginbtn;
	
	@FindBy(tagName="a")
	WebElement links;
	
	@FindBy(tagName= "msg_box")
	WebElement id;
	
	public loginPage () {
		PageFactory.initElements(driver, this);
	}
	
	//======================== Functions ===========================================
	
	public void LoginFunction (String usernameval, String passwrdval) {

		
	    WebDriverWait wait= new WebDriverWait(driver,50);   //add WebDriver driver = BaseClass.driver inside the LoginFunction and we can avoid creating separate obj for individual tests

		 wait.until(ExpectedConditions.elementToBeClickable(loginlink));
		
		// This is explicit wait //
		     loginlink.click();	 
test.log(LogStatus.PASS, "Click on loginlink, loginlink clicked successfully");
		 
		 Remer.click();  
		 test.log(LogStatus.PASS, "Click on Remer, Remer clicked successfully");
		 Username.sendKeys(usernameval);
		 test.log(LogStatus.PASS, "click on usernameval, usernameval clicked sucessfully");
		 password.sendKeys(passwrdval);
		 test.log(LogStatus.PASS, "click on passwrdval, passwrdval clicked sucessfully");
		 loginbtn.click();
         test.log(LogStatus.PASS, "click on loginbtn, loginbtn clicked sucessfully");
         links.getSize();
 		 test.log(LogStatus.PASS, "click on links, links clicked sucessfully");
	}
	
	
	public void UICheck () {
		
		Assert.assertTrue(Username.isDisplayed());
	}
}
