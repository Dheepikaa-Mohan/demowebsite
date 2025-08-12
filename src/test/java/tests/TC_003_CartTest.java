package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.CartPage;
import pages.HomePage;
import pages.LogInPage;
import pages.ProductPage;

public class TC_003_CartTest extends ProjectSpecificationMethods {
	
@Test(priority=0)

public void testAddProductToCart() throws InterruptedException {
	LogInPage loginPage=new LogInPage(driver);
	ProductPage productPage=new ProductPage(driver);
	CartPage cartPage=new CartPage(driver);
    
	loginPage.openLoginPage();
    loginPage.login("saimadhi123", "saimadhi123");
   Thread.sleep(5000);
  //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  // WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Nokia lumia 1520']")));

    productPage.selectProduct1();
    productPage.addToCart();
    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait1.until(ExpectedConditions.alertIsPresent());
    Alert alert = driver.switchTo().alert();
    Assert.assertEquals(alert.getText(), "Product added.");
    alert.accept();
}

@Test(priority=1)
public void cardItemsDisplayed() {
	HomePage homePage=new HomePage(driver);
	CartPage cartPage=new CartPage(driver);
     homePage.navigateToCart();	
     
}}