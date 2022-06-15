import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class NewWindowPage extends BasePage {

    @FindBy(linkText = "Click Here")
    WebElement clickHereButton;

    @FindBy(className = "example")
    WebElement newPageHeadline;

    public NewWindowPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    public void setClickHereButton() {
        clickHereButton.click ();
    }

    public void swithToNewTab() {
        List<String> tabs = new ArrayList ( driver.getWindowHandles () );
        driver.switchTo ().window ( tabs.get ( 1 ) );

    }
}
