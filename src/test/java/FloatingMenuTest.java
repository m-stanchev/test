import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenuTest extends BaseTest {

    /**
     * Floating Menu Test
     * Test steps
     * 1. Navigate to https://the-internet.herokuapp.com/floating_menu
     * 2. Scroll to the bottom of the page
     * Expected result
     * 2. Floating menu is still present on the page
     */

    @Test

    public void floatingMenuTest() {
        print ( "1. Navigate to https://the-internet.herokuapp.com/floating_menu" );
        driver.navigate ().to ( Strings.SCROLL_URL );
        print ( "2. Scroll to the bottom of the page" );
        floatingMenuPage.scrollDownThePage ();
        print ( "2. Floating menu is still present on the page" );
        Assert.assertTrue ( floatingMenuPage.floatingMenu.isDisplayed () );
        // assert isElementPresent ( floatingMenuPage.floatingMenu ) : "Error. Floating menu is not present on page.";
    }


}
