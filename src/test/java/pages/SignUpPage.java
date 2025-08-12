package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class SignUpPage extends ProjectSpecificationMethods {
	 @FindBy(id = "signin2")
	    WebElement signUpPage;
		@FindBy(xpath="//input[@id=\"sign-username\"]")
    WebElement usernameField;

    @FindBy(xpath="//input[@id=\"sign-password\"]")
    WebElement passwordField;

    @FindBy(xpath ="//button[text()='Sign up']")
    WebElement signUpButton;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }
    public SignUpPage openSignUpPage() {
        signUpPage.click();
        return this;
    }
    public SignUpPage enterCredentials(String username, String password) {
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }
    public SignUpPage clickSignUp() {
    	signUpButton.click(); 
    	return this;
    }
    public String getAlertMessage() {
        try {
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            alert.accept();
            return message;
        } catch (NoAlertPresentException e) {
            return null;
        }}}