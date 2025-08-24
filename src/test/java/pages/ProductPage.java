package pages;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class ProductPage extends ProjectSpecificationMethods {
	WebDriverWait wait;
	@FindBy(xpath="//a[text()='Nokia lumia 1520']")
	WebElement productLink3;
	@FindBy(xpath = "//a[text()='Add to cart']")
	    WebElement addToCartBtn;
    @FindBy(xpath="//a[text()='Samsung galaxy s6']")
    WebElement productLink1;
    @FindBy(xpath="//a[text()='Iphone 6 32gb']")
    WebElement productLink2;
    @FindBy(xpath="//a[text()='Sony vaio i5']")
    WebElement productLink4;
    @FindBy(linkText = "Phones")
	WebElement phonesCategories;
    @FindBy(xpath = "//h4[@class='card-title']/a")
	List<WebElement> productTitles;
    @FindBy(xpath = "//h2[@class='name']")
	WebElement productTitle;
   @FindBy(xpath = "//h3[@class='price-container']")
	WebElement productPrice;
   @FindBy(xpath = "//div[@id='more-information']/p")
	WebElement productDescription;

	    public ProductPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	    public List<String> getVisibleProductTitles() {
			wait.until(ExpectedConditions.visibilityOfAllElements(productTitles));
			List<String> titles = new ArrayList<>();
			for (WebElement product : productTitles) {
				titles.add(product.getText().trim());
			}
			return titles;
		}
	    public void selectProduct1() {
	    	productLink1.click();
	    	}
	    public void selectProduct2() {
	    	productLink2.click();
	    	}
	    public void selectProduct3() {
	    	productLink3.click();
	    	}
	    public void selectProduct4() {
	    	productLink4.click();
	    	}
	    public void addToCart() {
	        addToCartBtn.click();
	    }
	    public String getProductTitle() {
			return wait.until(ExpectedConditions.visibilityOf(productTitle)).getText().trim();
		}

		public String getProductPrice() {
			return wait.until(ExpectedConditions.visibilityOf(productPrice)).getText().trim();
		}

		public String getProductDescription() {
			return wait.until(ExpectedConditions.visibilityOf(productDescription)).getText().trim();
		}
		public void clickPhones() {
			wait.until(ExpectedConditions.elementToBeClickable(phonesCategories)).click();

		}
	    public String getAlertMessage() {
	        Alert alert = driver.switchTo().alert();
	        String msg = alert.getText();
	        alert.accept();
	        return msg;
	    }
	}






