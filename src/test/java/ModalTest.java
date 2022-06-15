import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalTest extends BaseTest {

    /**
     * Turn off modal dialog
     * Test steps:
     * 1. Navigate to https://the-internet.herokuapp.com/entry_ad
     * 2. Click close modal button
     * Expected result:
     * 2. Modal is closed
     */

    @Test
    public void turnOffModal() {
        print ( "1. Navigate to https://the-internet.herokuapp.com/entry_ad" );
        driver.navigate ().to ( Strings.MODAL_URL );
        print ( "2. Click close modal button" );
        modalPage.modalCloseButtonClick ();
        print ( "2. Modal is closed" );
        Assert.assertTrue ( modalPage.headline.isDisplayed () );
        //assert isElementPresent ( modalPage.headline ) : "Error. Modal is not closed.";

    }
}
