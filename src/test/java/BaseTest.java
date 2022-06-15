import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected CheckboxPage checkboxPage;
    protected AddRemoveElementsPage addRemoveElementsPage;
    protected BasePage basePage;
    protected DynamicControlsPage dynamicControlsPage;
    protected DownloadFilesPage downloadFilesPage;
    protected UploadPage uploadPage;
    protected ModalPage modalPage;
    protected DropdownPage dropdownPage;
    protected DynamicallyLoadedPageElementsPage dlpep;
    protected NewWindowPage newWindowPage;
    protected FloatingMenuPage floatingMenuPage;
    protected InfiniteScroollPage infiniteScroollPage;
    protected JQueryUIPage jQueryUIPage;
    protected JSAlertsPage jsAlertsPage;
    protected ExitIntentPage exitIntentPage;
    protected DragAndDropPage dragAndDropPage;
    protected MouseHoverPage mouseHoverPage;
    protected WebTablePage webTablePage;

    @BeforeSuite
    public void beforeSuiteMethod() {
        System.out.println ( "This is a test run of a suite:" );
    }

    @AfterSuite
    public void afterSuiteMethod() {
        System.out.println ( "Test run of a suite is finished." );
    }


    @BeforeMethod
    public void beforeMethod() {
        driver = startNewDriver ();
        driver.manage ().window ().maximize ();
        checkboxPage = new CheckboxPage ( driver );
        addRemoveElementsPage = new AddRemoveElementsPage ( driver );
        dynamicControlsPage = new DynamicControlsPage ( driver );
        downloadFilesPage = new DownloadFilesPage ( driver );
        uploadPage = new UploadPage ( driver );
        modalPage = new ModalPage ( driver );
        dropdownPage = new DropdownPage ( driver );
        dlpep = new DynamicallyLoadedPageElementsPage ( driver );
        newWindowPage = new NewWindowPage ( driver );
        floatingMenuPage = new FloatingMenuPage ( driver );
        infiniteScroollPage = new InfiniteScroollPage ( driver );
        jQueryUIPage = new JQueryUIPage ( driver );
        jsAlertsPage = new JSAlertsPage ( driver );
        exitIntentPage = new ExitIntentPage ( driver );
        dragAndDropPage = new DragAndDropPage ( driver );
        mouseHoverPage = new MouseHoverPage ( driver );
        webTablePage = new WebTablePage ( driver );
    }

    @AfterMethod
    public void afterMethod() {

        driver.quit ();
    }

    private WebDriver startNewDriver() {
        WebDriver driver = DriverManager.createWebDriver ();
        driver.navigate ().to ( Strings.BASE_URL );
        return driver;

    }

    public void print(String text) {
        System.out.println ( text );
    }


    public boolean isCurrentUrlEqualsTo(String expectedUrl) {
        System.out.println ( "isCurrentUrlEqualsTo ( " + expectedUrl + " ) " );
        String currentUrl = driver.getCurrentUrl ();
        System.out.println ( "User is on " + currentUrl );
        boolean b = currentUrl.equals ( expectedUrl );
        return b;
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait ( driver, Duration.ofSeconds ( 25 ) );
        wait.until ( ExpectedConditions.visibilityOf ( element ) );
    }



    public boolean isElementPresent(WebElement element) {
        System.out.println ( "isElementPresent" );
        try {
            boolean isPresent = element.isDisplayed ();
            return true;
        } catch (Exception e) {
            System.out.println ( e.getMessage () );
            System.out.println ( "Element is not present on page" );
            return false;
        }
    }



}
