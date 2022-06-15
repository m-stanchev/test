import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    @FindBy(id = "dropdown")
    WebElement dropdown;

    @FindBy(xpath = "//select/option[contains(@value,'1')]")
    WebElement option1;

    @FindBy(xpath = "//select/option[contains(@value,'2')]")
    WebElement option2;

    @FindBy(xpath = "//select/option[contains(@selected,'selected')]")
    WebElement selectedOptions;


    //Constructor
    public DropdownPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    //Methods
    public void dropdownClick() {
        dropdown.click ();
    }

    public void option1Select() {
        option1.click ();
    }

    public void option2Select() {
        option2.click ();
    }


    public void selectFromDropdown() {
        Select dropDown = new Select ( driver.findElement ( By.id ( "dropdown" ) ) );

        dropDown.selectByVisibleText ( "Option 2" );
    }


}
