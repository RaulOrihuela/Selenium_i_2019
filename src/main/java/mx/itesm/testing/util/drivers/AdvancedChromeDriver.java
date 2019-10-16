package mx.itesm.testing.util.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdvancedChromeDriver {
	public static WebDriver getDriver(AdvancedChromeOption Option){
		try {
			System.setProperty("webdriver.chrome.driver", "libs\\seleniumLib\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			switch(Option){
				case Microphone:
					options.addArguments("use-fake-ui-for-media-stream");
					break;
				default:
					break;
			}
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			return driver;
		} catch (Exception ignored){ return null; }
	}
}
