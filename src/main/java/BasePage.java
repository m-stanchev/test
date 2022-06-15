import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BasePage {
    protected WebDriver driver;
    public WebDriver wait;


    public BasePage(WebDriver driver) {

        this.driver = driver;

    }

    public void takeSs(WebDriver driver) throws IOException {

        File pic = ((TakesScreenshot) driver).getScreenshotAs ( OutputType.FILE );
        DateFormat dateFormat = new SimpleDateFormat ( "dd-MM-yyyy h-m-s" );
        Date date = new Date ();
        File path = new File ( ".\\screenshots\\homepage" + dateFormat.format ( date ) + ".png" );

        FileUtils.copyFile ( pic, path );
    }

    //    public static void takeScreenshot(WebDriver driver, String methodName) throws IOException {
//        File pic = ((TakesScreenshot) driver).getScreenshotAs ( OutputType.FILE );
//        DateFormat dateFormat = new SimpleDateFormat ( "dd-MM-yyyy h-m-s" );
//        Date date = new Date ();
//        File path = new File ( ".\\screenshots\\homepage" + methodName + dateFormat.format ( date ) + ".png" );
//        FileUtils.copyFile ( pic, path );
//
//    }
    public static String getScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs ( OutputType.BASE64 );
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait ( driver, Duration.ofSeconds ( 25 ) );
        wait.until ( ExpectedConditions.visibilityOf ( element ) );
    }

    public void sleep() {

        try {
            Thread.sleep ( 50000 );
        } catch (Exception e) {
            System.out.println ( e.getMessage () );
        }
    }

    //Helper methods
    //Click Method

    public void click(WebElement element) {
        waitForElement ( element );
        element.click ();
    }

    public void click(By by) {
        waitVisibility ( by ).click ();
    }

    //Write Text

    public void writeText(WebElement element,String text){
        waitForElement ( element );
        element.sendKeys ( text );
    }
    public void writeText(By by, String text) {
        waitVisibility ( by ).sendKeys ( text );
    }

    //Read Text
    public String readText(By by) {
        return waitVisibility ( by ).getText ();
    }

    public void clearText(By by) {
        waitVisibility ( by ).clear ();
    }

    //Wait
    public WebElement waitVisibility(By by) {
        WebDriverWait wait = new WebDriverWait ( driver, Duration.ofSeconds ( 25 ) );
        return wait.until ( ExpectedConditions.visibilityOfElementLocated ( by ) );
    }
}
