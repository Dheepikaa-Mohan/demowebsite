package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods {

	 @FindBy(id = "signin2")
	    WebElement signUpPage;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	public void openSignUpPage() {
        signUpPage.click();
    }
}
