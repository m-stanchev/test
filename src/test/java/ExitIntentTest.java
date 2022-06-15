import org.testng.Assert;
import org.testng.annotations.Test;

public class ExitIntentTest extends BaseTest {

    /**
     * Exit Intent test
     * Test steps
     * 1. Navigate to https://the-internet.herokuapp.com/exit_intent
     * 2. Performe mouse outside the window
     */

    @Test
    public void exitIntentTest() {
        print ( "1. Navigate to https://the-internet.herokuapp.com/exit_intent" );
        driver.navigate ().to ( Strings.EXIT_INTENT_URL );
        print ( "2. Performe mouse outside the window" );
        exitIntentPage.mouseOut ();
        Assert.assertTrue ( exitIntentPage.modal.isDisplayed () );

    }

}

