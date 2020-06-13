package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNGDemo {

	WebDriver driver = null;
	public static String browserName = null;
	@BeforeTest
	public void setUpTest( ){
		
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath +"/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath +"\\drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

	}
	
	@Test
	public void googleSearch() throws InterruptedException {


		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("Automation Testing Step by step");
		//driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		//driver.quit();
		PropertiesFile.setProperties();
	}
}
