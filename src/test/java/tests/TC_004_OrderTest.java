package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.CartPage;
import pages.HomePage;
import pages.LogInPage;
import pages.OrderPage;
import pages.ProductPage;

public class TC_004_OrderTest extends ProjectSpecificationMethods {
	
	@Test
public void validDetailsTest() throws InterruptedException {
	LogInPage loginPage=new LogInPage(driver);
	ProductPage productPage=new ProductPage(driver);
	CartPage cartPage=new CartPage(driver);
    HomePage homepg=new HomePage(driver);
    OrderPage orderpg=new OrderPage(driver);
    
    loginPage.openLoginPage();
    loginPage.login("sakthi1505", "sakthi1505");
    Thread.sleep(5000);
    productPage.selectProduct1();
    productPage.addToCart();

    String alert1 = loginPage.getAlertMessage();
    Assert.assertEquals(alert1, "Product added.");
    homepg.navigateToCart();
    Thread.sleep(5000);
    cartPage.placeOrderButton.click();
	orderpg.placeOrder("Sakthi","India","Chennai","9876 9864 9621 7432", "12", "2025");
	orderpg.clickPurchase();
	
	String confirmationPopUp = orderpg.getConfirmationMessage();
	assertTrue(confirmationPopUp.contains("Id"));
	assertTrue(confirmationPopUp.contains("Amount"));
	System.out.println("Order Confirmation" + confirmationPopUp);
	orderpg.clickOKBtn();
}
	
@Test
	public void emptyFormTest() throws InterruptedException {
		LogInPage loginPage=new LogInPage(driver);
		CartPage cartPage=new CartPage(driver);
	    HomePage homepg=new HomePage(driver);
	    OrderPage orderpg=new OrderPage(driver);
	 loginPage.openLoginPage();
	 loginPage.login("abc@123","abc@123"); 
	 Thread.sleep(2000);
	 homepg.navigateToCart();
	 cartPage.placeOrderButton.click();
	 orderpg.placeOrder("","","","","","");
	 orderpg.clickPurchase();
	 Thread.sleep(2000);
	 String alertMessage = orderpg.getAlertMessage();
    assertEquals(alertMessage, "Please fill out Name and Creditcard.", "Missing field alert not displayed.");
}

}