package tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.CartPage;
import pages.HomePage;
import pages.LogInPage;
import pages.OrderPage;
import pages.ProductPage;

public class TC_005_NavigationTest extends ProjectSpecificationMethods{	
@Test
public void testBrowsing() throws InterruptedException {
	LogInPage loginPage=new LogInPage(driver);
	ProductPage productPage=new ProductPage(driver);
	CartPage cartPage=new CartPage(driver);
    HomePage homepg=new HomePage(driver);
    OrderPage orderpg=new OrderPage(driver);
    
    loginPage.openLoginPage();
    loginPage.login("saimadhi123", "saimadhi123");
    Thread.sleep(2000);
    productPage.clickPhones();
    Thread.sleep(1000);
	List<String> phoneProducts = productPage.getVisibleProductTitles();
	List<String> expectedPhones = List.of("Samsung galaxy s6", "Nokia lumia 1520", "Nexus 6",
			"Sony xperia z5", "HTC One M9", "Iphone 6 32gb", "Samsung galaxy s7");
	for (String title : phoneProducts) {
		assertTrue(expectedPhones.contains(title), " Unexpected product in Phones category: " + title);
	}
	productPage.selectProduct1();
	String title = productPage.getProductTitle();
	String price = productPage.getProductPrice();
	String description = productPage.getProductDescription();
	
	System.out.println("Product Title is: " + title);
	System.out.println("Product Price is: " + price);
	System.out.println("Product Description: " + description);
	
	homepg.navigateToHome();
	assertTrue(homepg.isHomePageDisplayed(), "Home page not displayed");
	
	homepg.navigateToCart();
	assertTrue(driver.getCurrentUrl().contains("cart"), "Cart page not displayed");
	
	homepg.clickContact();
	Thread.sleep(2000);
	WebElement contactTitle = driver.findElement(By.xpath("//h5[text()='New message']"));
    String actualTitle = contactTitle.getText();
    Assert.assertEquals("New message",actualTitle,"Contact did not open properly" );
	
	
}}