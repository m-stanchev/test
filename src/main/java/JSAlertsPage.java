import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JSAlertsPage extends BasePage {

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    WebElement jsAlertButton;
    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    WebElement jsConfirmButton;
    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    WebElement jsPromptButton;

    @FindBy(id = "result")
    WebElement result;

    public JSAlertsPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    public void setJsAlertButton() {
        jsAlertButton.click ();
        Alert alert = driver.switchTo ().alert ();
        String alertText = alert.getText ();
        alert.dismiss ();
        System.out.println ( alertText );
        Assert.assertTrue ( alertText.contains ( "I am a JS Alert" ) );
    }

    public void setJsConfirmButton() {
        jsConfirmButton.click ();
        Alert alert = driver.switchTo ().alert ();
        String text = alert.getText ();
        alert.accept ();
        System.out.println ( text );
        Assert.assertTrue ( text.contains ( "I am a JS Confirm" ) );
    }

    public void setJsPromptButton() {
        jsPromptButton.click ();
        Alert alert = driver.switchTo ().alert ();
        alert.sendKeys ( "Jovana" );
        alert.accept ();
    }
}
