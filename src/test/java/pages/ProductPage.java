package pages;




import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class ProductPage extends ProjectSpecificationMethods {
	@FindBy(css = ".name")
    WebElement productName;

    @FindBy(css = ".price-container")
    WebElement productPrice;

    @FindBy(css = "#more-information")
    WebElement productDescription;
    //-------------------
	@FindBy(xpath="//a[text()='Nokia lumia 1520']")
	WebElement productLink;
	 @FindBy(xpath = "//a[text()='Add to cart']")
	    WebElement addToCartBtn;

	    public ProductPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    public boolean isProductDetailVisible() {
	        return productName.isDisplayed() && productPrice.isDisplayed() && productDescription.isDisplayed();
	    }
	    public void selectProduct1() {
	    	productLink.click();
	    	}
	    public void addToCart() {
	        addToCartBtn.click();
	    }

	    public String getAlertMessage() {
	        Alert alert = driver.switchTo().alert();
	        String msg = alert.getText();
	        alert.accept();
	        return msg;
	    }
	}


