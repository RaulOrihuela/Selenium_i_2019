package mx.itesm.testing.otherExamples.youtube;

import mx.itesm.testing.util.drivers.EnhancedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YoutubePlayer {
    public static String search(EnhancedWebDriver myDriver, String searchTerm) throws InterruptedException{

        //GO TO YOUTUBE
        myDriver.get("http://www.youtube.com/");

        //SEARCH
        myDriver.findDynamicElement(By.id("search")).sendKeys(searchTerm);
        String currentTitle = myDriver.getTitle();
        myDriver.findElement(By.id("search-icon-legacy")).click();
        myDriver.waitForTitleChange(currentTitle);
        myDriver.navigate().refresh();

        //FIND LINK TO VIDEO
        currentTitle = myDriver.findElement(By.id("video-title")).getAttribute("href");

        return currentTitle;
    }
    public static String watchVideo(EnhancedWebDriver myDriver, String URL, short timeOutInMinutes){
        myDriver.get(URL);
        WebElement autoplay = myDriver.findDynamicElement(By.id("toggle"));
        if(autoplay!= null && autoplay.getAttribute("aria-pressed").equals("true"))autoplay.click();
        if(myDriver.findDynamicElement(By.className("ended-mode"), timeOutInMinutes*12,5000)!=null)
            return "Finished watching video";
        else
            return "Timeout interruption";

    }
}
