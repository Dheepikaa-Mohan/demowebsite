package pages;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.ProjectSpecificationMethods;

public class OrderPage extends ProjectSpecificationMethods {
	   WebDriverWait wait;
	
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
	    WebElement OKButton;
	    
	    @FindBy(xpath = "//p[@class='lead text-muted ']") 
		WebElement confirmationText;

	    public OrderPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    }
	    public void clickPurchase() {
			wait.until(ExpectedConditions.elementToBeClickable(purchaseBtn)).click();
		}
	    public String getAlertMessage() {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String message = alert.getText();
			alert.accept();
			return message;
		}
	    public void placeOrder(String name, String country, String city, String card, String month, String year) {
	        nameField.sendKeys(name);
	        countryField.sendKeys(country);
	        cityField.sendKeys(city);
	        cardField.sendKeys(card);
	        monthField.sendKeys(month);
	        yearField.sendKeys(year);
	    }
	    public String getConfirmationMessage() {
			return wait.until(ExpectedConditions.visibilityOf(confirmationText)).getText();
		}

		public void clickOKBtn() {
			wait.until(ExpectedConditions.elementToBeClickable(OKButton)).click();
		}
	}
	    









