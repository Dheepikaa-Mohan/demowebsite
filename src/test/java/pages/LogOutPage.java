package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class LogOutPage extends ProjectSpecificationMethods {
	WebDriver driver;
	WebDriverWait wait;
	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@FindBy(id = "logout2")
	WebElement logoutBtn;

	@FindBy(id = "login2")
	WebElement loginBtn;

	public void clickLogout() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
	}

	public boolean isLoginButtonVisible() {
		return wait.until(ExpectedConditions.visibilityOf(loginBtn)).isDisplayed();
	}
}
