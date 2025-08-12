package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class OrderPage extends ProjectSpecificationMethods {
        @FindBy(xpath = "//button[text()='Place Order']")
	    WebElement placeOrderBtn;

	    @FindBy(xpath="//input[@id=\"name\"]")
	    WebElement nameField;

	    @FindBy(xpath="//input[@id=\"country\"]")
	    WebElement countryField;

	    @FindBy(xpath="//input[@id=\"city\"]")
	    WebElement cityField;

	    @FindBy(xpath="//input[@id=\"card\"]")
	    WebElement cardField;

	    @FindBy(xpath="//input[@id=\"month\"]")
	    WebElement monthField;

	    @FindBy(xpath="//input[@id=\"year\"]")
	    WebElement yearField;

	    @FindBy(xpath = "//button[text()='Purchase']")
	    WebElement purchaseBtn;

	    @FindBy(xpath="//button[text()='OK']")
	    WebElement confirmationPopup;

	    public OrderPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void placeOrder(String name, String country, String city, String card, String month, String year) {
	        placeOrderBtn.click();
	        nameField.sendKeys(name);
	        countryField.sendKeys(country);
	        cityField.sendKeys(city);
	        cardField.sendKeys(card);
	        monthField.sendKeys(month);
	        yearField.sendKeys(year);
	        purchaseBtn.click();
	        confirmationPopup.click();
	    }}
	    









