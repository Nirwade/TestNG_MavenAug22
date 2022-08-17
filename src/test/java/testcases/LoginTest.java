package testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.loginPage;

public class LoginTest extends BaseClass {
	

	@Test
	public void loginFailureTest() {
		
		//test = report.startTest("loginFailureTest");
		
	loginPage p1 = new loginPage ();
			
			p1.LoginFunction ("1234@gmail.com",  "SfegBdx@l123"); // creating an abject of login page
		  
						
		 WebElement Errmsg = driver.findElement(By.id("msg_box"));
		 String Actualmsg = Errmsg.getText();
		 String Expectmgs = "The email or password you have entered is invalid.";
		 
		Assert.assertEquals(Expectmgs, Actualmsg);
		
		// report.endTest(test);
		
	}
		
		
		@Test
		public void loginSuccessTest () {
		
			loginPage p1 = new loginPage ();

			p1.LoginFunction ("nirwadeshashi@gmail.com",  "Shashi@123");
	  
		}
		
	
	@Test
	@Parameters({"param1","param2"})
	public void ParameterizedTest(String UserNameVal,String PasswordVal) {
		
		loginPage p1 = new loginPage();
		p1.LoginFunction(UserNameVal, PasswordVal);
		
	}
	
	@Test
	public void ExternalDataTest() {
		
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		loginPage p1 = new loginPage();
		p1.LoginFunction(UserNameVal, PasswordVal);
		
	}
	
	@Test
	public void LinkList () {
		List <WebElement> links = driver.findElements(By.tagName("a"));
		loginPage p1 = new loginPage();
		System.out.println("Total number of links are  ..." + links.size());
		test.log(LogStatus.PASS, "click on links, links clicked sucessfully");

		for(WebElement ref:links) {
			System.out.println(ref.getAttribute("href"));
			
		}
	
	}
}
	


