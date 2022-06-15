import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage extends BasePage {

    private final String propertyFilePath = "C:\\Users\\Joca\\IdeaProjects\\HerokuappTest\\upload\\cvjpeg.jpg";

    @FindBy(id = "file-upload")
    WebElement fileUpload;

    @FindBy(xpath = "//*[@id=\"file-submit\"]")

    WebElement fileSubmit;

    @FindBy(xpath = "//h3[text()='File Uploaded!']")
    WebElement fileUploaded;

    public UploadPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    public void fileUploadClick() {
        fileUpload.click ();
    }

    public void fileSubmitClick() {
        fileSubmit.click ();
    }

    public void uploadPicture() {
        fileUpload.sendKeys ( propertyFilePath );

    }


}
