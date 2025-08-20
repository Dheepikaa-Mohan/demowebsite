package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.LogInPage;
import pages.ProductPage;
import pages.SignUpPage;

public class TC_006_UiTest extends ProjectSpecificationMethods {
@Test(priority = 1)
public void verifyProductTileAlignment() throws InterruptedException {
	HomePage homepg=new HomePage(driver);
    LogInPage loginPage=new LogInPage(driver);
    loginPage.openLoginPage();
    loginPage.login("saimadhi123", "saimadhi123");
    int y1 = homepg.productCard1.getLocation().getY();
    int y2 = homepg.productCard2.getLocation().getY();
    Assert.assertEquals(y1, y2, "Product tiles are not horizontally aligned");
}
@Test(priority = 2)
public void verifyActionButtonsVisibility() {
	HomePage homepg=new HomePage(driver);
    LogInPage loginPage=new LogInPage(driver);
    SignUpPage signUpPage=new SignUpPage(driver);
    loginPage.openLoginPage();
    loginPage.login("saimadhi123", "saimadhi123");
    Assert.assertTrue(loginPage.loginBtn.isDisplayed() && loginPage.loginBtn.isEnabled(), "Login button not visible or clickable");
    Assert.assertTrue(signUpPage.signUpBtn.isDisplayed() && signUpPage.signUpBtn.isEnabled(), "Signup button not visible or clickable");
}
@Test(priority = 3)
public void verifyAlertStyling() throws InterruptedException {
	HomePage homepg=new HomePage(driver);
    LogInPage loginPage=new LogInPage(driver);
    ProductPage productPage=new ProductPage(driver);
    loginPage.openLoginPage();
    loginPage.login("sakthi1605", "sakthi1605");
    Thread.sleep(5000);
    productPage.selectProduct1();
    productPage.addToCart();
    Thread.sleep(2000);
    Alert alert = driver.switchTo().alert();
    Assert.assertTrue(alert.getText().length() > 0, "Alert text is empty");
    alert.accept();
}
}
