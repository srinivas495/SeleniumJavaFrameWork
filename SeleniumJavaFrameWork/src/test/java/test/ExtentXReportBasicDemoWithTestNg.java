package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentXReportBasicDemoWithTestNg {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver = null;

	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extentReportTestNG.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	
	}
	
	@BeforeTest
	public void setUpTest( ){

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath +"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

	}
	@Test
	public void test1() throws IOException {
		ExtentTest test = extent.createTest("Google validation");
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info(details)");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}
	@Test
	public void test2() throws IOException {
		ExtentTest test = extent.createTest("FB validation");
		driver.manage().window().maximize();
		driver.get("https://www.fb.com/");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info(details)");
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
	}
	
	@AfterSuite
	public void tearDown() {

		extent.flush();
	}

}
