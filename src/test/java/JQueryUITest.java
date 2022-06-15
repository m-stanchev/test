import org.testng.Assert;
import org.testng.annotations.Test;

public class JQueryUITest extends BaseTest {

    /**
     * Menu test
     * Test steps:
     * 1. Navigate to https://the-internet.herokuapp.com/jqueryui/menu
     * 2. Mouse hover on Enable button and Click enable button
     * 3. Mouse hover download button and Click download button
     * 4. Mouse hover on Excel button and Click on Excel button
     * Expected result
     * 4. Menu.xls file is downloaded
     */

    @Test(priority = 5,groups = "Regression")
    public void jQueryTest() {
        print ( "1. Navigate to https://the-internet.herokuapp.com/jqueryui/menu" );
        driver.navigate ().to ( Strings.JQUERY_URL );
        print ( "2. Mouse hover on Enable button and Click enable button" );
        jQueryUIPage.setEnabledButton ();
        print ( "3. Mouse hover download button and Click download button" );
        jQueryUIPage.setDownloadButton ();
        print ( "4. Mouse hover on Excel button and Click on Excel button" );
        jQueryUIPage.setExcelButton ();
        print ( "4. Menu.xls file is downloaded" );
        Assert.assertTrue ( jQueryUIPage.verifyIfTheFileIsDownloaded () );
        // jQueryUIPage.verifyIfTheFileIsDownloaded ();


    }
}
