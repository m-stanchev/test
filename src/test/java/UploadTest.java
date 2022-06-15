import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UploadTest extends BaseTest {

    /**
     * Upload picture
     * Test steps:
     * 1. Navigate to https://the-internet.herokuapp.com/upload
     * 2. Upload picture
     * 3. Click submit
     * 4. Take screenshoot
     * Expected result:
     * 3. Picture is uploaded
     *
     * @throws IOException
     */

    @Test(priority = 4, invocationCount = 1, invocationTimeOut = 9000)
    public void uploadPictureTest() throws IOException {
        print ( "Navigate to https://the-internet.herokuapp.com/upload" );
        driver.navigate ().to ( Strings.UPLOAD_URL );
        print ( "2. Upload picture" );
        uploadPage.uploadPicture ();
        print ( "3. Click submit" );
        uploadPage.fileSubmitClick ();
        print ( "4. Take screenshoot" );
        uploadPage.takeSs ( driver );
        print ( "3. Picture is uploaded" );
        Assert.assertTrue ( uploadPage.fileUploaded.isDisplayed () );
        //assert isElementPresent ( uploadPage.fileUploaded ) : "Error. Upload is not done";

    }
}
