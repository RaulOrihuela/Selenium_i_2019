package mx.itesm.testing.util.drivers;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract class WebDriverDecorator implements WebDriver{
	protected WebDriver myDriver;
	
	public WebDriverDecorator(WebDriver myDriver){
		this.myDriver = myDriver;
	}
	
	public void close() {
		myDriver.close();
	}

	public WebElement findElement(By arg0) {
		return myDriver.findElement(arg0);
	}

	public List<WebElement> findElements(By arg0) {
		return myDriver.findElements(arg0);
	}

	public void get(String arg0) {
		myDriver.get(arg0);
	}

	public String getCurrentUrl() {
		return myDriver.getCurrentUrl();
	}

	public String getPageSource() {
		return myDriver.getPageSource();
	}

	public String getTitle() {
		return myDriver.getTitle();
	}

	public String getWindowHandle() {
		return myDriver.getWindowHandle();
	}

	public Set<String> getWindowHandles() {
		return myDriver.getWindowHandles();
	}

	public Options manage() {
		return myDriver.manage();
	}

	public Navigation navigate() {
		return myDriver.navigate();
	}

	public void quit() {
		myDriver.quit();
	}

	public TargetLocator switchTo() {
		return myDriver.switchTo();
	}
}
