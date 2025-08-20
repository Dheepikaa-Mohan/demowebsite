package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class LogInPage extends ProjectSpecificationMethods {
	WebDriverWait wait;

	    @FindBy(id = "login2")
	    public WebElement loginBtn;

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
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    }

	    public LogInPage openLoginPage() {
	        loginBtn.click();
	        return this;
	    }

	    public void login(String username, String password) {
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        loginButton.click();
	    }
	    public String getPasswordFieldType() {
	        return passwordField.getAttribute("type");
	    }

	    public boolean isLoggedIn() {
	        return loggedInUser.isDisplayed();
	    }
	    public String getAlertMessage() {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			alert.accept();
			return alertText;
		}
	}

