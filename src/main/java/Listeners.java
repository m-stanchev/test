import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    // WebDriver driver =null;
    ExtentReportManager extentReportManager = new ExtentReportManager ();
    private ExtentReports report = extentReportManager.getReporter ();
    private static String getMethodName;



    public void onTestStart(ITestResult result) {
        getMethodName = result.getMethod ().getMethodName ();
        ExtentTest test = report.createTest ( getMethodName );
        test.assignCategory ( result.getTestClass ().getRealClass ().getName () );
    }


    public void onTestSuccess(ITestResult result) {
        getMethodName = result.getMethod ().getMethodName ();
        ExtentTest test = report.createTest ( getMethodName );
        String successMessage = "Test Method " + getMethodName + " passed successfully!";
        Markup finalMessage = MarkupHelper.createLabel(successMessage, ExtentColor.GREEN);
        test.log(Status.PASS, finalMessage);
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver;

        try {
            driver = (WebDriver) result.getTestClass ().getRealClass ().getSuperclass ().getDeclaredField ( "driver" ).get ( result.getInstance () );
            getMethodName = result.getMethod ().getMethodName ();
            ExtentTest test = report.createTest ( getMethodName );
            test.fail ( "Test failed", MediaEntityBuilder.createScreenCaptureFromBase64String ( BasePage.getScreenshot ( driver ) ).build () );
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException ( e );
        }


    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
        if (report != null) {
            report.flush ();
        }
    }
}
