import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ExitIntentPage extends BasePage {

    @FindBy(className = "large-12 columns")
    WebElement content;

    @FindBy(className = "modal-title")
    WebElement modal;

    public ExitIntentPage(WebDriver driver) {
        super ( driver );
    }

    public void mouseOut() {

        Actions actions = new Actions ( driver );
        actions.moveToElement ( content ).build ().perform ();
        actions.moveByOffset ( -1, -1 ).build ().perform ();

    }
}
