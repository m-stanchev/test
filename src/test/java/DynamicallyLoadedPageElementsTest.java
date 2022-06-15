import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicallyLoadedPageElementsTest extends BaseTest {
    /**
     * Dynamically Loaded Page Elements with element that is hidden
     * <p>
     * Test steps:
     * 1. Navigate to  https://the-internet.herokuapp.com/dynamic_loading
     * 2. Click on element on the page that is hidden
     * 3. Click start button
     * Expected result:
     * 3. Verify URL is https://the-internet.herokuapp.com/dynamic_loading/1
     * 3a. Verify text is Hello World!
     */

    @Test

    public void elementOnPageThatIsHiddenTest() {
        print ( "1. Navigate to  https://the-internet.herokuapp.com/dynamic_loading" );
        driver.navigate ().to ( Strings.DLPE_URL );
        print ( "2. Click on element on the page that is hidden" );
        dlpep.elementOnPageThatIsHiddenClick ();
        print ( "3. Click start button" );
        dlpep.startButton12Click ();
        print ( "3. Verify URL is https://the-internet.herokuapp.com/dynamic_loading/1" );
        assert isCurrentUrlEqualsTo ( Strings.DLPE_SUCC1_URL ) : "Error. Wrong URL.";
        print ( "3a. Verify text is Hello World!" );
        Assert.assertTrue ( dlpep.textReached.isDisplayed () );
        // assert isElementPresent ( dlpep.textReached ) : "Text Hello World is not shown.";
    }

    /**
     * Dynamically Loaded Page Elements with element rendered after the fact
     * <p>
     * Test steps:
     * 1. Navigate to  https://the-internet.herokuapp.com/dynamic_loading
     * 2. Click on element on the page that is rendered after the fact
     * 3. Click start button
     * Expected result:
     * 3. Verify URL is https://the-internet.herokuapp.com/dynamic_loading/2
     * 3a. Verify text is Hello World!
     */


    @Test
    public void elementRenderedAfterTheFactTest() {
        print ( "1. Navigate to  https://the-internet.herokuapp.com/dynamic_loading" );
        driver.navigate ().to ( Strings.DLPE_URL );
        print ( "2. Click on element on the page that is rendered after the fact" );
        dlpep.elementRenderedAfterTheFactClick ();
        print ( "3. Click start button" );
        dlpep.startButton12Click ();
        print ( "3. Verify URL is https://the-internet.herokuapp.com/dynamic_loading/2" );
        assert isCurrentUrlEqualsTo ( Strings.DLPE_SUCC2_URL ) : "Error. Wrong URL.";
        print ( "3a. Verify text is Hello World!" );
        Assert.assertTrue ( dlpep.textReached.getText ().equals ( "Hello World!" ) );
        //assert isElementPresent ( dlpep.textReached ) : "Text Hello World is not shown.";
    }
}
