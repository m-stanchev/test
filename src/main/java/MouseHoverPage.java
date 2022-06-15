import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPage extends BasePage {

    @FindBy(xpath = "//div[1]/img[@src='/img/avatar-blank.jpg']")
    WebElement img;

    @FindBy(xpath = "//h5[text()='name: user1']")
    WebElement user1;

    public MouseHoverPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    public void mouseHoverImg() {
        Actions action = new Actions ( driver );
        action.moveToElement ( img ).perform ();
    }
}
