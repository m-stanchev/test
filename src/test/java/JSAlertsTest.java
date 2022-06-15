import org.testng.Assert;
import org.testng.annotations.Test;

public class JSAlertsTest extends BaseTest {

    /**
     * Alert test
     * Test steps
     * 1. Navigate to https://the-internet.herokuapp.com/javascript_alerts
     * 2. Click on js alert button and turn it off
     * 3. Click on js confirm alert button and click ok
     * 4. Click on js prompt button and type text
     * Expected result
     * 4. 4. Verify that the text that is typed is the same as text shown in the page
     */

    @Test(priority = 3, groups = "Regression")
    public void jsAlertTest() {
        print ( "1. Navigate to https://the-internet.herokuapp.com/javascript_alerts" );
        driver.navigate ().to ( Strings.ALERTS_URL );
        print ( "2. Click on js alert button and turn it off" );
        jsAlertsPage.setJsAlertButton ();
        print ( "3. Click on js confirm alert button and click ok" );
        jsAlertsPage.setJsConfirmButton ();
        print ( "4. Click on js prompt button and type text " );
        jsAlertsPage.setJsPromptButton ();
        print ( "4. Verify that the text that is typed is the same as text shown in the page" );
        Assert.assertTrue ( jsAlertsPage.result.getText ().contentEquals ( "You entered: Jovana" ) );


    }
}
