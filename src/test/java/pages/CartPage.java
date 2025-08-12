package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class CartPage extends ProjectSpecificationMethods {
	    @FindBy(xpath = "//a[text()='Delete']")
	    List<WebElement> deleteButtons;

	    @FindBy(id = "totalp")
	    WebElement totalPrice;

	    public CartPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public int getProductCount() {
	        return deleteButtons.size();
	    }

	    public void deleteFirstProduct() {
	        if (!deleteButtons.isEmpty()) {
	            deleteButtons.get(0).click();
	        }
	    }

	    public String getTotalAmount() {
	        return totalPrice.getText();
	    }
	}
