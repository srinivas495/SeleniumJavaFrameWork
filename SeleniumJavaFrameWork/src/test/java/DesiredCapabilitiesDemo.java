import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {

	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("ignoreProtectedModeSettings", true);
		System.out.println("projectPath :"+ projectPath);
		System.setProperty("webdriver.ie.driver", projectPath +"/drivers/iedriver/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver(cap);

		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		WebElement textbox = driver.findElement(By.name("q"));
		Thread.sleep(3000);
		textbox.sendKeys("A B C D");
		driver.close();
		driver.quit();
	}

}
