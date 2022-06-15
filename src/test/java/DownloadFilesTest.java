import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DownloadFilesTest extends BaseTest {
    /**
     * Download picture
     * Test steps:
     * 1. Navigate to https://the-internet.herokuapp.com/download
     * 2. Capture the list of files
     * 3. Click on file1 to download it
     * Expected result:
     * 3. Verify the file1 is downloaded
     *
     * @throws IOException
     */

    @Test(priority = 4)
    public void downloadPic() throws IOException {
        print ( "1. Navigate to https://the-internet.herokuapp.com/download" );
        driver.navigate ().to ( Strings.DOWNLOAD_URL );
        print ( "2. Capture the list of files" );
        downloadFilesPage.captureList ();
        print ( "3. Click on file1 to download it" );
        downloadFilesPage.file1Click ();
        print ( "3. Verify the file1 is downloaded" );
        Assert.assertTrue ( downloadFilesPage.verifyIfTheFileIsDownloaded () );


    }
}
