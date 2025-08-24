package base;

import java.io.IOException;

import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utility;

public class ProjectSpecificationMethods extends Utility {
	@BeforeSuite
	public void createReport() {
		ExtentSparkReporter reporter=new ExtentSparkReporter("C:\\Users\\surya\\eclipse-workspace\\demowebsite\\src\\test\\resources\\testOutput\\demoblaze_testReport.html");
		reporter.config().setReportName("DemoBlaze Shop Test Report");
		 extent=new ExtentReports();
		 extent.attachReporter(reporter);
	}
	@BeforeClass
	public void testDetails() {
		test=extent.createTest(testName,testDescription);
		test.assignAuthor(testAuthor);
	}
	@Parameters({"browser","url"})
	@BeforeMethod
	public void browserLaunchAndUrlLoad(String browser,String url) {
		launchBrowserAndLoadUrl(browser,url);
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
	@AfterSuite
	public void closeReport() {
		extent.flush();
	
}
}


