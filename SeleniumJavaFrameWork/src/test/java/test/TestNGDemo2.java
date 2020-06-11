package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo2 {

	WebDriver driver = null;
	@BeforeTest
	public void setUpTest( ){

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath +"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

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
	
	@Test
	public void googleSearch2() throws InterruptedException {


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
		driver.quit();
	}
}
