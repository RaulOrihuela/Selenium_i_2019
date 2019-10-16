package mx.itesm.testing.otherExamples.microphone;

import mx.itesm.testing.util.drivers.EnhancedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FrequencyListener {
    private static void validateStart(EnhancedWebDriver myDriver) throws InterruptedException {
        if(!myDriver.getTitle().equals("Virtual Oscilloscope | Academo.org - Free, interactive, education.")) start(myDriver);
    }
    public static String start(EnhancedWebDriver myDriver) throws InterruptedException {
        myDriver.get("https://academo.org/demos/virtual-oscilloscope/");
        List<WebElement> controls = myDriver.findDynamicElements(By.className("form-control"),5);
        controls.get(2).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,"2.5");
        myDriver.moveDropdownDown(controls.get(3),3);
        myDriver.moveDropdownDown(controls.get(4),1);
        return  myDriver.getTitle();
    }
}
