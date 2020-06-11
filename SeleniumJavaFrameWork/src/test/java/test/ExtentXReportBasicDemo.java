package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentXReportBasicDemo {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test1 = extent.createTest("Google Search box validation");
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath +"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.com/");
		test1.pass("Navigate Google.com");
		driver.findElement(By.name("q")).sendKeys("ABC");
		test1.pass("Enter Text in the search box");
		driver.close();
		
		driver.quit();
		test1.pass("Close the broswer");
		test1.info("Test Complted");
		
		extent.flush();

	}

}
