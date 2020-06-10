package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePageObjects {
	WebDriver driver = null;

	By textBox_Search = By.name("q");
	By GmailButton = By.xpath("//a[contains(text(),'Gmail')]");

	public GooglePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void setTextinSearch(String text) {
		driver.findElement(textBox_Search).sendKeys(text);
	}

	public void ClickOnGmailButton() {
		driver.findElement(GmailButton).click();
	}
}
