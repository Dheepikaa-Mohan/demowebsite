package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.LogInPage;
public class TC_002_LogInTest extends ProjectSpecificationMethods {

	 @Test(priority = 1)
	    public void testLoginValidCredentials(){
		 
		    LogInPage loginPage=new LogInPage(driver);
	        loginPage.openLoginPage();
	        loginPage.login("saimadhi123", "saimadhi123");
	       
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       	 WebElement isLoggedIn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
	        Assert.assertTrue(loginPage.isLoggedIn(), "Login failed with valid credentials.");
	    }
	 @Test(priority = 2)
	    public void testLoginInvalidPassword() {
		 LogInPage loginPage=new LogInPage(driver);
	
	        loginPage.openLoginPage();
	        loginPage.login("saimadhi123", "sai");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
	        String alertMsg = loginPage.getAlertMessage();
	        Assert.assertEquals(alertMsg, "Wrong password.", "Invalid password alert mismatch.");
	    }
	 
	 @Test(priority = 3)
	    public void testLoginEmptyFields() {
		 LogInPage loginPage=new LogInPage(driver);
	        loginPage.openLoginPage();
	        loginPage.login("", "");
	        Alert alert = driver.switchTo().alert();
	        Assert.assertTrue(alert.getText().contains("Please fill"), "Empty field alert missing.");
	        alert.accept();
	    }
	 @Test(priority = 4)
	    public void testPasswordFieldIsMasked() {
		 LogInPage loginPage=new LogInPage(driver);
		 loginPage.openLoginPage();
		 loginPage.login("saimadhi123", "saimadhi123");
	        String typeAttribute = loginPage.getPasswordFieldType();
	        Assert.assertEquals(typeAttribute, "password", "Password input is not masked.");
	    }}
	 
	 
	 