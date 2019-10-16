package otherExamples.youtube;

import mx.itesm.testing.otherExamples.youtube.YoutubePlayer;
import mx.itesm.testing.util.drivers.BrowserDriver;
import mx.itesm.testing.util.drivers.BrowserOption;
import mx.itesm.testing.util.drivers.EnhancedWebDriver;
import org.junit.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class YoutubePlayerIT {
    private static EnhancedWebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        driver = new EnhancedWebDriver(BrowserDriver.getDriver(BrowserOption.Chrome));
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        driver.quit();
    }

    @Before
    public void setUp() throws Exception { }

    @After
    public void tearDown() throws Exception { }

    @Test
    public void testYoutubeSearch() throws InterruptedException {
        String videoURL = YoutubePlayer.search(driver, "Billie Eilish - you should see me in a crown");
        assertThat(
                "Did not find correct video",
                videoURL,
                is(equalTo("https://www.youtube.com/watch?v=Ah0Ys50CqO8"))
        );
        YoutubePlayer.watchVideo(driver,videoURL,(short)5);
    }
}
