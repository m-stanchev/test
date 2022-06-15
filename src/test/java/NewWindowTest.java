import org.testng.Assert;
import org.testng.annotations.Test;

public class NewWindowTest extends BaseTest {

    /**
     * Open new window
     * Test steps
     * 1. Navigate to https://the-internet.herokuapp.com/windows
     * 2. Click button Click here
     * 3. Swith to new tab
     * Expected result:
     * 3. Verify headline in new tab
     */

    @Test
    public void openNewWindowTest() {
        print ( "1. Navigate to https://the-internet.herokuapp.com/windows" );
        driver.navigate ().to ( Strings.NEW_WINDOW_URL );
        print ( "2. Click button Click here" );
        newWindowPage.setClickHereButton ();
        print ( "3. Swith to new tab" );
        newWindowPage.swithToNewTab ();
        print ( "3.Verify headline in new tab" );
        Assert.assertTrue ( newWindowPage.newPageHeadline.getText ().contains ( "New Window" ),
                "Notification message is not shown." );

    }
}
