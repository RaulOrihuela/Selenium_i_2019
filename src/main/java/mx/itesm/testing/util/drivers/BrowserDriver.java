package mx.itesm.testing.util.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDriver {
    private WebDriver driver;

    private BrowserDriver(BrowserOption browser){
        try {
            switch (browser){
                case Chrome:
                    System.setProperty("webdriver.chrome.driver", "libs\\seleniumLib\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case Firefox:
                    System.setProperty("webdriver.gecko.driver", "libs\\seleniumLib\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case InternetExplorer:
                    System.setProperty("webdriver.ie.driver", "libs\\seleniumLib\\IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    break;
            }
            driver.manage().window().maximize();
        } catch (Exception ignored){ }
    }

    public static WebDriver getDriver(BrowserOption browser){ return new BrowserDriver(browser).driver; }
}
