package tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.SignUpPage;

public class TC_001_SignUpTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() throws IOException {
		sheetname="SignUpSheet";
	}
@Test(dataProvider = "readData")
	public void signuptest(String username, String password) {
	new HomePage(driver)
	.openSignUpPage();
	new SignUpPage(driver)
	.enterCredentials(username, password)
	.clickSignUp();
}}