import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends BasePage {

    //@FindBy(id = "column-a")
    @FindBy(xpath = "//div[@id='column-a']")
    WebElement columnA;
    //@FindBy(id = "column-b")
    @FindBy(xpath = "//div[@id='column-b']")
    WebElement columnB;

    public DragAndDropPage(WebDriver driver) {
        super ( driver );
        PageFactory.initElements ( driver, this );
    }

    public void dragAToB() {
        Actions action = new Actions ( driver );
        action.dragAndDrop ( columnA, columnB ).perform ();

    }

    public void dragAndDropJS(WebElement source, WebElement destination, WebDriver driver) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");" +
                "\n" + "event.initCustomEvent(typeOfEvent,true, true, null);" +
                "\n" + "event.dataTransfer = {\n" + "data: {}," +
                "\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "}," +
                "\n" + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};" +
                "\n" + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) " +
                "{\n" + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" +
                "}\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" + "} " +
                "else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);" +
                "\n" + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) " +
                "{\n" + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);" +
                "\n" + "var dropEvent = createEvent('drop');\n" +
                "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);" +
                "\n" + "var dragEndEvent = createEvent('dragend');\n" +
                "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" +
                "\n" + "var source = arguments[0];\n" + "var destination = arguments[1];\n" +
                "simulateHTML5DragAndDrop(source,destination);", source, destination );
        Thread.sleep ( 1500 );

    }
}
