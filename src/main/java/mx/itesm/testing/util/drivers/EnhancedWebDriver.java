package mx.itesm.testing.util.drivers;

import java.io.FileWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnhancedWebDriver extends WebDriverDecorator {

	public EnhancedWebDriver(WebDriver myDriver) {
		super(myDriver);
	}
	public Boolean printSourcePage(String outputFileName){
		try {
			FileWriter writer = new FileWriter(outputFileName);
			writer.write(myDriver.getPageSource());
			writer.close();
			return true;
		} catch (Exception ex){
			System.out.println("Couldn't print");
			return false;
		}
	}
	public String waitForTitleChange(String currentTitle){
		try{
			(new WebDriverWait(myDriver, 30)).until(ExpectedConditions.not(ExpectedConditions.titleIs(currentTitle)));
		} catch (Exception Ex){
			System.out.println("Title did not change");
		}
		return myDriver.getTitle();
	}
	public String waitForTitleChange(String currentTitle, long timeOutInSeconds){
		try{
			(new WebDriverWait(myDriver, timeOutInSeconds)).until(ExpectedConditions.not(ExpectedConditions.titleIs(currentTitle)));
		} catch (Exception Ex){
			System.out.println("Title did not change");
		}
		return myDriver.getTitle();
	}
	public boolean waitForElementToDisappear(By myLocator, int attempts, long intervalInMs){
		WebElement element = findDynamicElement(myLocator,1);
		int i = 0;
		while (element!=null && i<attempts){
			i++;
			element = findDynamicElement(myLocator,1,intervalInMs);
		}
		return (element==null);
	}
	public boolean clickLink(WebElement myLink){
		try {
			((JavascriptExecutor) myDriver).executeScript("arguments[0].click();", myLink);
			return true;
		} catch (Exception Ex){
			System.out.println("Could not find link");
			return false;
		}
	}
	public WebElement findDynamicElement(By myLocator){
		try{
			WebElement element = (new WebDriverWait(myDriver, 30)).until(ExpectedConditions.visibilityOfElementLocated(myLocator));
			return element;
		} catch (Exception Ex){
			return null;
		}
	}

	public List<WebElement> findDynamicElements(By myLocator){
		try{
			if(findDynamicElement(myLocator)!=null)
				return myDriver.findElements(myLocator);
			else return null;
		} catch (Exception Ex){
			return null;
		}
	}

	public WebElement findDynamicElement(By myLocator, long timeOutInSeconds){
		try{
			WebElement element = (new WebDriverWait(myDriver, timeOutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(myLocator));
			return element;
		} catch (Exception Ex){
			return null;
		}
	}
	public List<WebElement> findDynamicElements(By myLocator, long timeOutInSeconds){
		try{
			if(findDynamicElement(myLocator,timeOutInSeconds)!=null)
				return myDriver.findElements(myLocator);
			else return null;
		} catch (Exception Ex){
			return null;
		}
	}

	public WebElement findDynamicElement(By myLocator, int attempts, long attemptIntervalInMs){
		try{
			WebElement element = null;
			for (short timeOut = 0; element == null; timeOut++){
				try{
					element = myDriver.findElement(myLocator);
				} catch (NoSuchElementException ex){
					element = null;
				}
				if (timeOut >= attempts) return element;
				Thread.sleep(attemptIntervalInMs);
			}
			return element;
		} catch (Exception ex){
			System.out.println("Interrupted");
			return null;
		}
	}

	public List<WebElement> findDynamicElements(By myLocator,  int attempts, long attemptIntervalInMs){
		try{
			if(findDynamicElement(myLocator,attempts,attemptIntervalInMs)!=null)
				return myDriver.findElements(myLocator);
			else return null;
		} catch (Exception Ex){
			return null;
		}
	}
	
	public boolean moveRangeRight(WebElement myRange, int steps){
		try {
			for (int i=0; i<steps;i++)myRange.sendKeys(Keys.ARROW_RIGHT); 
			return true;
		} catch (Exception Ex){
			System.out.println("Could not find range");
			return false;
		}
	}
	public boolean moveRangeLeft(WebElement myRange, int steps){
		try {
			for (int i=0; i<steps;i++)myRange.sendKeys(Keys.ARROW_LEFT); 
			return true;
		} catch (Exception Ex){
			System.out.println("Could not find range");
			return false;
		}
	}

	public boolean moveDropdownDown(WebElement myDropdown, int steps){
		try {
			myDropdown.click();
			for (int i=0; i<steps;i++)myDropdown.sendKeys(Keys.ARROW_DOWN);
			myDropdown.sendKeys(Keys.ENTER);
			return true;
		} catch (Exception Ex){
			System.out.println("Could not find dropdown");
			return false;
		}
	}

	public boolean moveDropdownUp(WebElement myDropdown, int steps){
		try {
			myDropdown.click();
			for (int i=0; i<steps;i++)myDropdown.sendKeys(Keys.ARROW_UP);
			myDropdown.sendKeys(Keys.ENTER);
			return true;
		} catch (Exception Ex){
			System.out.println("Could not find dropdown");
			return false;
		}
	}
	public void scroll(int pixels){
		((JavascriptExecutor) myDriver).executeScript("window.scrollBy(0,".concat(String.valueOf(pixels)).concat(")"));
	}
	public void scroll(){
		((JavascriptExecutor) myDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	//document.body.scrollHeight
}
