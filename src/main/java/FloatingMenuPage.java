import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage extends BasePage {

    @FindBy(id = "page-footer")
    WebElement pageFooter;

    @FindBy(id = "menu")
    WebElement floatingMenu;

    public FloatingMenuPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }


    public void scrollDownThePage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView(true);", pageFooter );
    }


}
