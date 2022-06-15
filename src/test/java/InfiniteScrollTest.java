import org.testng.Assert;
import org.testng.annotations.Test;

public class InfiniteScrollTest extends BaseTest {
    /**
     * Infinite scroll test
     * Test steps
     * 1. Navigate to https://the-internet.herokuapp.com/infinite_scroll
     */

    @Test
    public void infiniteScrollTest() {
        driver.navigate ().to ( Strings.INFINITE_SCROLL_URL );
        infiniteScroollPage.isInfiniteScrollWorking ();
        Assert.assertFalse ( infiniteScroollPage.isInfiniteScrollWorking () );
    }


}
