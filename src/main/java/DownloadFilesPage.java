import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DownloadFilesPage extends BasePage {

    @FindBy(xpath = "//a[@href='download/sunset (2).jpg']")
    WebElement sunsetPic;

    @FindBy(xpath = "//a[@href='download/file1.png']")
    WebElement file1;

    @FindBy(className = "example")
    WebElement listOfFiles;

    public String downloadPath = "C:\\Users\\Joca\\Downloads";

    public DownloadFilesPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    public void sunsetPicClick() {
        waitForElement ( sunsetPic );
        sunsetPic.click ();
    }
    public void file1Click(){
        file1.click ();
    }

    public boolean verifyIfTheFileIsDownloaded() {

        String downloadPath = "C:\\Users\\Joca\\Downloads";
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (File file : dirContents) {
            if (file.getName().equalsIgnoreCase("file1.png")) {
                System.out.println ("Test passed");
                return true;
            }
        }
        return false;
    }

    public void captureList()throws IOException{
        File listScreenshot = driver.findElement ( By.className ( "example" ) ).getScreenshotAs ( OutputType.FILE );
        DateFormat dateFormat = new SimpleDateFormat ( "dd-MM-yyyy h-m-s" );
        Date date = new Date ();
        FileUtils.copyFile ( listScreenshot,new File ( ".\\screenshots\\homepage" + dateFormat.format ( date ) + ".png ") );
    }
}
