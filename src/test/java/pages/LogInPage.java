package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class LogInPage extends ProjectSpecificationMethods {
	   

	    @FindBy(id = "login2")
	    WebElement loginPage;

	    @FindBy(id = "loginusername")
	    WebElement usernameField;

	    @FindBy(id = "loginpassword")
	    WebElement passwordField;

	    @FindBy(xpath = "//button[text()='Log in']")
	    WebElement loginButton;

	    @FindBy(id = "nameofuser")
	    WebElement loggedInUser;

	    public LogInPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public LogInPage openLoginPage() {
	        loginPage.click();
	        return this;
	    }

	    public void login(String username, String password) {
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        loginButton.click();
	    }
	    public String getAlertMessage() {
	        try {
	            Alert alert = driver.switchTo().alert();
	            String message = alert.getText();
	            alert.accept();
	            return message;
	        } catch (NoAlertPresentException e) {
	            return null;
	        }}
	    public String getPasswordFieldType() {
	        return passwordField.getAttribute("type");
	    }

	    public boolean isLoggedIn() {
	        return loggedInUser.isDisplayed();
	    }
	}

