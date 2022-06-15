import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class JQueryUIPage extends BasePage {


    @FindBy(xpath = "//a[text()='Enabled']")
    WebElement enabledButton;

    @FindBy(xpath = "//a[text()='Downloads']")
    WebElement downloadButton;

    @FindBy(xpath = "//a[text()='Excel']")
    WebElement excelButton;

    public JQueryUIPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    public void setEnabledButton() {
        //Creating object of an Actions class
        Actions action = new Actions ( driver );
//Performing the mouse hover action on the target element.
        action.moveToElement ( enabledButton ).perform ();
        enabledButton.click ();
    }

    public void setDownloadButton() {
        Actions action = new Actions ( driver );
        action.moveToElement ( downloadButton ).perform ();
        downloadButton.click ();
    }

    public void setExcelButton() {
        waitForElement ( excelButton );
        Actions action = new Actions ( driver );
        action.moveToElement ( excelButton ).perform ();
        excelButton.click ();
    }

    public boolean verifyIfTheFileIsDownloaded() {

        String downloadPath = "C:\\Users\\Joca\\Downloads";
        File dir = new File ( downloadPath );
        File[] dirContents = dir.listFiles ();

        for (File file : dirContents) {
            if (file.getName ().equalsIgnoreCase ( "menu.xls" )) {
                System.out.println ( "Test passed" );
                break;
            }
        }
        return true;
    }

    public void listDownloads() {
        String downloadPath = "C:\\Users\\Joca\\Downloads";
        File dir = new File ( downloadPath );
        File[] dirContents = dir.listFiles ();

    }
}
