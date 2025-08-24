package tests;

import base.ProjectSpecificationMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LogInPage;
import pages.ProductPage;
import static org.testng.Assert.*;

import java.io.IOException;

public class TC_003_CartTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		testName="Cart Test";
		testDescription="Testing the cart functionality by adding products";
		testAuthor=" Dheepikaa M G ";
	}

	@Test()
	public void testFullCartFlow() throws InterruptedException {

		LogInPage loginPage=new LogInPage(driver);
		ProductPage productPage=new ProductPage(driver);
		CartPage cartPage=new CartPage(driver);
	    HomePage homepg=new HomePage(driver);
		loginPage.openLoginPage();
	    loginPage.login("saimadhi123", "saimadhi123");
	    Thread.sleep(5000);
	  
	    productPage.selectProduct1();
	    productPage.addToCart();

	    String alert1 = loginPage.getAlertMessage();
	    Assert.assertEquals(alert1, "Product added.");
	   
        homepg.navigateToHome();
		
	    productPage.selectProduct2();
	    productPage.addToCart();
	    String alert2 = loginPage.getAlertMessage();
	    Assert.assertEquals(alert2, "Product added.");
	    
		homepg.navigateToCart();
		
		for (int i = 0; i < cartPage.cartProductTitles.size(); i++) {
			String title = cartPage.cartProductTitles.get(i).getText();
			String price = cartPage.cartProductPrices.get(i).getText();
			System.out.println("Product: " + title + " | Price: $" + price);
		}

		int expectedSum = cartPage.calculateSumOfPrices();
		int actualTotal = cartPage.getTotalPrice();
		System.out.println("Total before deletion: $" + actualTotal);
		assertEquals(actualTotal, expectedSum, "Total price mismatch for 2 items.");

		cartPage.deleteFirstProduct();
		Thread.sleep(3000);
		int updatedTotal = cartPage.getTotalPrice();
		System.out.println("Total after deletion: $" + updatedTotal);
		assertTrue(updatedTotal < actualTotal, "Total not updated after deletion.");
	    
		homepg.navigateToHome();
		Thread.sleep(2000); 
		productPage.selectProduct3();
	    productPage.addToCart();
	    String alert3 = loginPage.getAlertMessage();
	    Assert.assertEquals(alert3, "Product added.");
	    
	    homepg.navigateToHome();
	    Thread.sleep(2000);
		productPage.selectProduct4();
	    productPage.addToCart();
	    String alert4 = loginPage.getAlertMessage();
	    Assert.assertEquals(alert4, "Product added.");
	    
	    homepg.navigateToCart();
	    Thread.sleep(2000);
	    int finalTotal=cartPage.getTotalPrice();
	    System.out.println("Total After Adding Two Items is:$"+finalTotal);
	    assertTrue(finalTotal>updatedTotal,"Total not updated");
	}
	
}