import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InfiniteScroollPage extends BasePage {


    @FindBy(id = "page-footer")
    WebElement footerElement;

    public InfiniteScroollPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    public boolean isInfiniteScrollWorking() {
        List<WebElement> content = driver.findElements ( By.className ( "jscroll-added" ) );
        while (content.size () < 10) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript ( "window.scrollBy(0,250)", "" );
            content = driver.findElements ( By.className ( "jscroll-added" ) );
            if (content.size () == 10) {
                System.out.println ( "Test passed" );
                break;
            }
        }
        return false;
    }


    public boolean isElementVisible() {
        if (driver.findElement ( By.id ( "page-footer" ) ).isDisplayed ()) {
            return true;
        } else return false;
    }
}
