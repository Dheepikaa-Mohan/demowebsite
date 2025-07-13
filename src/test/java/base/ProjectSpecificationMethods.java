package base;

import java.io.IOException;

import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.Utility;

public class ProjectSpecificationMethods extends Utility {
	@BeforeMethod
	public void browserLaunchAndUrlLoad() {
		launchBrowserAndLoadUrl("chrome","https://www.demoblaze.com/");
}
@AfterMethod
public void closeBrowser() {
    try {
        if (driver != null) {
            driver.quit(); 
        }
    } catch (NoSuchSessionException e) {
        System.out.println("Browser session already closed.");
    }
}

@DataProvider(name="readData")
public String[][] dataRead() throws IOException {
	
	return readExcel(sheetname);
}
}

