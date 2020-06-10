package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.ManifestReading.SealBaseLocator;
import pages.GooglePageObjects;



public class GoogleSearchPageTest {
	
	private static WebDriver driver = null;
	public static void main(String[] args) {
		googleSearchTest();
	}
	
	public static void googleSearchTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath +"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		GooglePageObjects searchObj = new GooglePageObjects(driver);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		searchObj.setTextinSearch("ABCD");
		searchObj.ClickOnGmailButton();
		driver.close();
	} 
}
