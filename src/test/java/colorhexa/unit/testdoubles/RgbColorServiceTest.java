package colorhexa.unit.testdoubles;

import mx.itesm.testing.colorhexa.bean.RgbColor;
import mx.itesm.testing.colorhexa.service.IRgbColorService;
import mx.itesm.testing.colorhexa.service.RgbColorServiceFake;
import org.hamcrest.Matchers;
import org.junit.*;

import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class RgbColorServiceTest {
    private static IRgbColorService rgbColorService;
    private static ArrayList<RgbColor> colors;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        rgbColorService = new RgbColorServiceFake();
        colors = rgbColorService.rgbColor_RA();
    }

    @After
    public void tearDown() throws Exception {
        rgbColorService = null;
        colors = null;
    }
    @Test
    public void colors_Should_NotBeEmpty(){
        assertThat(
                "The list was empty",
                colors,
                is(not(empty()))
        );
    }
    @Test
    public void colors_Should_HaveAtLeastThreeItems(){
        assertThat(
                "The list had less than 3 items",
                colors,
                hasSize(greaterThanOrEqualTo(3))
        );
    }
    @Test
    public void colors_Should_ContainRed(){
        assertThat(
                "The list did not contain red",
                colors,
                hasItem(Matchers.<RgbColor>allOf(
                        hasProperty("r",equalTo(255)),
                        hasProperty("g",equalTo(0)),
                        hasProperty("b",equalTo(0))
                ))
        );
    }
    @Test
    public void rgbColorService_Should_addNewColor(){
        int originalSize = colors.size();
        RgbColor sexyRedColor = new RgbColor(185,16,32);
        rgbColorService.rgbColor_C(sexyRedColor);
        colors = rgbColorService.rgbColor_RA();

        assertThat(
                "The service did not add a new color",
                colors,
                hasSize(greaterThan(originalSize))
        );
    }
    @Test
    public void rgbColorService_Should_deleteAColor(){
        int originalSize = colors.size();

        rgbColorService.rgbColor_D(2);
        colors = rgbColorService.rgbColor_RA();

        assertThat(
                "The service did not delete the specified color",
                colors,
                hasSize(lessThan(originalSize))
        );
    }
}
