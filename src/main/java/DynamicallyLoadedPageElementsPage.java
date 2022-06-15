import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicallyLoadedPageElementsPage extends BasePage {

    @FindBy(xpath = "//*[text()='Example 1: Element on page that is hidden']")

    WebElement elementOnPageThatIsHidden;

    @FindBy(xpath = "//*[text()='Example 2: Element rendered after the fact']")
    WebElement elementRenderedAfterTheFact;

    @FindBy(xpath = "//button[text()='Start']")
    WebElement startButton12;

    @FindBy(xpath = "//h4[text()='Hello World!']")
    WebElement textReached;

    //Constructor
    public DynamicallyLoadedPageElementsPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    //Methods

    public void elementOnPageThatIsHiddenClick() {
        elementOnPageThatIsHidden.click ();
    }

    public void elementRenderedAfterTheFactClick() {
        elementRenderedAfterTheFact.click ();
    }

    public void startButton12Click() {
        startButton12.click ();
        waitForElement ( textReached );
    }


}
