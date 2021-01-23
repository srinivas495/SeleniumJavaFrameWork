package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assessment {
	
	private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath +"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
/*
   1.Launch the URL & Do a Product search
   2.Select any product & Add that to the cart
   3.Place Order & Login to the application
   4.Select Address & Select Payment option
   5.Remove the product from the cart
*/
		//Launch the URL
		  driver.get("https://www.amazon.in/");
		//driver.get("https://www.amazon.in/Notebook-i5-10210U-Windows-Graphics-XMA1901-FC/dp/B089F3WL8T/ref=sr_1_1_sspa?dchild=1&keywords=laptops&qid=1607158720&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUExVkM2Sk5HTzdMVjk3JmVuY3J5cHRlZElkPUEwMjE1MDA3MzE1ODNXQk9GSFdZRSZlbmNyeXB0ZWRBZElkPUEwMjc4MDg0MUxGTTlUNFY4OThQTSZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU=");
		//Do a Product search
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptops");
		
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-text\"]/input")).click();
		
		//Select any product
		driver.findElement(By.xpath("//*[@class='a-link-normal a-text-normal']")).click();
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    //driver.close();
	    //driver.switchTo().window(tabs2.get(0));
			
		//driver.close();
		
		Thread.sleep(5000);
		//Add that to the cart
		driver.findElement(By.cssSelector("input[id='add-to-cart-button']")).click();
		Thread.sleep(3000);
		
		// No thanks button
		driver.findElement(By.cssSelector("input[aria-labelledby='btnVasModalSkip-announce']")).click();
		
		// Proceed to Buy
		driver.findElement(By.xpath("//*[@class='a-button-inner']")).click();
		
		driver.findElement(By.name("proceedToRetailCheckout")).click();
		
		// Enter MobileNumber
		driver.findElement(By.id("ap_email")).sendKeys("9871536225");
		// Click on continue
		driver.findElement(By.id("continue")).click();
		// Enter password
		driver.findElement(By.id("ap_password")).sendKeys("9871536225sS@");
		// Click on sigin button
		driver.findElement(By.id("signInSubmit")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		
		
		//Enter FullName
		driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Ramesh");
		// PhoneNumber
		driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("916304159152");
		// Pincode
		driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("500018");
		//Flat, House no
		driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("102");
		//Area, Colony
		driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("Hyd");
		//Landmark
		//driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("RR Peta");
		
		//driver.findElement(By.xpath("//*[@class='a-button-text a-declarative']")).click();
		//Select state = new Select(driver.findElement(By.xpath("//*[@class='a-dropdown-prompt']")));
		//state.selectByVisibleText("UTTAR PRADESH");
		
		Select AddressType = new Select(driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-addr-details-address-type-and-business-hours\"]/span/span")));
		AddressType.selectByVisibleText(" Home (7 am – 9 pm delivery) ");
		
		//driver.findElement(By.xpath("//*[@class='a-button-input']")).click();
	}

}
