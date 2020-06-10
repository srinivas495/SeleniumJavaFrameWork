import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {

	public static void main(String[] args) throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath :"+ projectPath);
		
		//System.setProperty("webdriver.gecko.driver", projectPath +"\\drivers\\geckodriver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		
		System.setProperty("webdriver.chrome.driver", projectPath +"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		WebElement textbox = driver.findElement(By.name("q"));
		Thread.sleep(3000);
		textbox.sendKeys("A B C D");
		
		List<WebElement> ListofWebElements = driver.findElements(By.xpath("//input"));
		Thread.sleep(3000);
		int count = ListofWebElements.size();
		System.out.println("ListofWebElements Count : " + count);
		
		driver.close();
		
	}
}
