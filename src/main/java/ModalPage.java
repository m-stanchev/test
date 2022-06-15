import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalPage extends BasePage {

    @FindBy(xpath = "//div[@class='modal-footer']/p")
    WebElement modalCloseButton;

    @FindBy(className = "example")
    WebElement headline;


    //Constructor
    public ModalPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    //Methods
    public void modalCloseButtonClick() {
        waitForElement ( modalCloseButton );
        modalCloseButton.click ();
    }
}
