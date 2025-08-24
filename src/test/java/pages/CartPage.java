package pages;

import java.util.List;

import base.ProjectSpecificationMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends ProjectSpecificationMethods {

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tbody[@id='tbodyid']//tr/td[2]")
	public List<WebElement> cartProductTitles;


	@FindBy(xpath = "//tbody[@id='tbodyid']//tr/td[3]")
	public List<WebElement> cartProductPrices;


	@FindBy(id = "totalp")
	WebElement totalPrice;


	@FindBy(xpath = "//a[text()='Delete']")
	WebElement deleteButton;

	@FindBy(xpath = "//button[text()='Place Order']")
	public WebElement placeOrderButton;


	public boolean isProductInCart(String productName) {
		for (WebElement title : cartProductTitles) {
			if (title.getText().equalsIgnoreCase(productName)) {
				return true;
			}
		}
		return false;
	}
	public int getTotalPrice() {
		try {
			return Integer.parseInt(totalPrice.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public int calculateSumOfPrices() {
		int sum = 0;
		for (WebElement price : cartProductPrices) {
			try {
				sum += Integer.parseInt(price.getText());
			} catch (NumberFormatException e) {
				// skip
			}
		}
		return sum;
	}

	public void deleteFirstProduct() {
		deleteButton.click();
	}
}