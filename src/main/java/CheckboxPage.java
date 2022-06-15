import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage extends BasePage {

    @FindBy(xpath = "//*[@id='checkboxes']/input[1]")
    WebElement checkbox1;

    @FindBy(xpath = "//*[@id='checkboxes']/input[2]")
    WebElement checkbox2;


    public CheckboxPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    //Metode
    public void checkbox1Click() {
        checkbox1.click ();
    }

    public void checkbox2Click() {
        checkbox2.click ();
    }

    public boolean isChecked(WebElement checkbox1) {
        if (checkbox1.getAttribute ( "checked" ) != null) {
            return true;
        }
        return false;

    }

    public boolean isUnhecked(WebElement checkbox2) {
        if (checkbox2.getAttribute ( "checked" ) == null) {
            return true;
        }
        return false;

    }


}
