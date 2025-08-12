package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.LogInPage;

public class TC_005_NavigationTest extends ProjectSpecificationMethods{
	
	
@Test
public void testBrowsePhones() {
	LogInPage loginPage=new LogInPage(driver);
    loginPage.openLoginPage();
    loginPage.login("saimadhi123", "saimadhi123");
    HomePage homePage=new HomePage(driver);
	homePage.clickCategory("Phones");
	
    Assert.assertTrue(homePage.getDisplayedProducts().size() > 0);
}
}
