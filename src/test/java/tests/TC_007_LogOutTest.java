package tests;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethods;
import pages.LogInPage;
import pages.LogOutPage;

public class TC_007_LogOutTest extends ProjectSpecificationMethods{
	@BeforeTest
	public void setup() {
		testName="LogOut Test";
		testDescription="Testing the LogOut functionality";
		testAuthor=" Dheepikaa M G ";
	}
	
	@Test
	public void testLogOut() throws InterruptedException {
		LogInPage loginPage=new LogInPage(driver);
		LogOutPage logOutPg=new LogOutPage(driver);
		loginPage.openLoginPage();
	    loginPage.login("sakthi1505", "sakthi1505");
	    Thread.sleep(5000);
	    logOutPg.clickLogout();
		
	    assertTrue(driver.getCurrentUrl().contains("index.html"), "Not redirected to homepage after logout");
        assertTrue(logOutPg.isLoginButtonVisible(), "Login button not visible after logout");
	}
	
	
}
