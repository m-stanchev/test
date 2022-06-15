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

public class DynamicControlsPage extends BasePage {

    @FindBy(xpath = "//form[@id='checkbox-example']/button")
    WebElement removeAddButton;

    @FindBy(id = "checkbox")
    WebElement checkbox;

    @FindBy(id = "message")
    WebElement itsGoneMsg;

    @FindBy(xpath = "//form[@id='input-example']/button")
    WebElement enableButton;

    @FindBy(xpath = "//input[@type='text']")
    WebElement input;

    //Constructor

    public DynamicControlsPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    public void removeAddButtonClick() {
        removeAddButton.click ();
    }

    public void enableButtonClick() {
        enableButton.click ();
    }

    public void typeSomeText() {
        input.sendKeys ( "abcd" );
    }

    public void captureButton() throws IOException {
        File buttonSs = driver.findElement ( By.id ( "message" ) ).getScreenshotAs ( OutputType.FILE );
        DateFormat dateFormat = new SimpleDateFormat ( "dd-mm-yyyy h-m-s" );
        Date date = new Date ();
        FileUtils.copyFile ( buttonSs, new File ( ".\\screenshots\\homepage" + dateFormat.format ( date ) + ".png " ) );
    }

}
