package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		googleSearch();
	}

	public static void googleSearch() throws InterruptedException {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath +"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		Thread.sleep(1000);

		GoogleSearchPage.searchBox(driver).sendKeys("Automation Testing ");

		Thread.sleep(1000);

		GoogleSearchPage.Gmailbutton(driver).click();

		Thread.sleep(1000);

		driver.close();
	}

}
