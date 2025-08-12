package tests;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.LogInPage;
import pages.SignUpPage;
public class TC_001_SignUpTest extends ProjectSpecificationMethods {
	@Test(priority = 1)
    public void testSignUpWithNewUser() {
       SignUpPage signUpPage = new SignUpPage(driver);
		
        signUpPage.openSignUpPage();
        signUpPage.enterCredentials("pranitharadhi", "Pranitha@123");
        signUpPage.clickSignUp();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
        String alertMsg = signUpPage.getAlertMessage();
        Assert.assertEquals(alertMsg, "Sign up successful.", "Unexpected signup success message.");
    }
	 @Test(priority = 2)
	    public void testSignUpWithExistingUser() {
		 SignUpPage signUpPage = new SignUpPage(driver);
	        signUpPage.openSignUpPage();
	        signUpPage.enterCredentials("saimadhi123", "saimadhi123");
	        signUpPage.clickSignUp();
            
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
	        String alertMsg = signUpPage.getAlertMessage();
	        Assert.assertEquals(alertMsg,"This user already exist.", "Alert for existing user not displayed.");
	    }
@Test(priority = 3)
public void testSignUpWithEmptyFields() {
	SignUpPage signUpPage = new SignUpPage(driver);
    signUpPage.openSignUpPage();
    signUpPage.enterCredentials("", "");
    signUpPage.clickSignUp();
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.alertIsPresent());
    String alertMsg = signUpPage.getAlertMessage();
    Assert.assertTrue(alertMsg.contains("Please fill out Username and Password"), "Empty field validation failed.");
}
}

	 