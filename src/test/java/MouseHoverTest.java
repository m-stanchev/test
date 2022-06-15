import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Mouse hover picture
 * Test steps:
 * 1. Navigate to https://the-internet.herokuapp.com/hovers
 * 2. Mouse hover over image1
 * Expected result:
 * 2. Verify User1 is shown
 */

public class MouseHoverTest extends BaseTest {

    @Test
    public void mouseHover() {
        print ( "1. Navigate to https://the-internet.herokuapp.com/hovers" );
        driver.navigate ().to ( Strings.MOUSE_HOVER_URL );
        print ( "2. Mouse hover over image1" );
        mouseHoverPage.mouseHoverImg ();
        print ( "2. Verify User1 is shown" );
        Assert.assertTrue ( mouseHoverPage.user1.isDisplayed () );
        //assert isElementPresent ( mouseHoverPage.user1 ) : "Error. Text user1 is not shown.";
    }
}
