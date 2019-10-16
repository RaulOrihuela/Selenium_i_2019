package otherExamples.cookBook;

import mx.itesm.testing.otherExamples.cookBook.RecipeSearcher;
import org.junit.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class RecipeSearcherTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void RecipeSearcher_Should_RemoveCategoryPrefix() throws InterruptedException {
        assertThat("The RecipeSearcher did not delete prefix",
                RecipeSearcher.removePrefix("Tiempo:\n1 hr(s) 30 min","Tiempo:\n" ),
                is(equalTo("1 hr(s) 30 min"))
        );
    }
}
