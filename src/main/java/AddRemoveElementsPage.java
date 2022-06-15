import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemoveElementsPage extends BasePage {

    //Webelements
    @FindBy(xpath = "//button[@onclick='addElement()']")
    WebElement addElementButton;

    @FindBy(xpath = "//button[@class='added-manually']")
    WebElement deleteButton;

    //Constructor

    public AddRemoveElementsPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    //Methods

    public void addElement() {
        addElementButton.click ();
    }

    public void removeElement() {
        deleteButton.click ();
    }


}
