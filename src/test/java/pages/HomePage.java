package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods {
	WebDriverWait wait;
	@FindBy(xpath="//div[@id='tbodyid']/div[contains(@class, 'col-lg-4')][1]")
	public WebElement productCard1;
	@FindBy(xpath="//div[@id='tbodyid']/div[contains(@class, 'col-lg-4')][2]")
	public WebElement productCard2;
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
    @FindBy(xpath="//a[text()='Contact']")
    WebElement contactLink;
	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    }
	    public boolean isHomePageDisplayed() {
			return driver.getCurrentUrl().equalsIgnoreCase("https://www.demoblaze.com/index.html");
		}
        public void clickCart() {
			wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
		}

		public void clickContact() {
			wait.until(ExpectedConditions.elementToBeClickable(contactLink)).click();
		}
	    public void navigateToHome() {
	        homeLink.click();
	    }
        public void navigateToCart() {
	        cartLink.click();
	    }
}

	