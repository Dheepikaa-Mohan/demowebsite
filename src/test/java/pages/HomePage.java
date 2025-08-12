package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods {
	@FindBy(xpath="//a[text()='Phones']")
	WebElement phonesLink;
	@FindBy(xpath="//a[text()='Laptops']")
	WebElement laptopsLink;
	@FindBy(xpath="//a[text()='Monitors']")
	 WebElement monitorsLink;
	 @FindBy(css = "#tbodyid .card-title")
	    List<WebElement> productTitles;
	 @FindBy(id = "navbarExample")
	    WebElement navbar;

	    @FindBy(xpath="//a[text()='Home ']")
	    WebElement homeLink;

	    @FindBy(xpath="//a[text()='Cart']")
	    WebElement cartLink;

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    public void clickCategory(String category) {
	        switch (category.toLowerCase()) {
	            case "phones": phonesLink.click(); break;
	            case "laptops": laptopsLink.click(); break;
	            case "monitors": monitorsLink.click(); break;
	        }
	    }
	    public List<WebElement> getDisplayedProducts() {
	        return productTitles;
	    }

	    public void clickProductByName(String name) {
	        driver.findElement(By.linkText(name)).click();
	    }
	    public void navigateToHome() {
	        homeLink.click();
	    }

	    public void navigateToCart() {
	        cartLink.click();
	    }
}

	