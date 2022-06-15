import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {
    private static ExtentReports extentReports;
    private ConfigFileReader configFileReader;

    public synchronized ExtentReports getReporter() {
        if (extentReports == null) {
            String projectPath = System.getProperty("user.dir");
            String dateStamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
            String reportPath = String.format("%s/reports/report_%s/Report.html", projectPath, dateStamp);

            extentReports = new ExtentReports ();
            ExtentSparkReporter extentReporter = new ExtentSparkReporter ( reportPath )
                    .viewConfigurer ()
                    .viewOrder ()
                    .as ( new ViewName[]{
                            ViewName.TEST,
                            ViewName.DASHBOARD,
                            ViewName.DEVICE,
                            ViewName.EXCEPTION,
                            ViewName.LOG
                    } )
                    .apply ();

            extentReporter.config ().setTheme ( Theme.DARK );
            extentReporter.config ().setDocumentTitle ( "HerokuappTest" );
            extentReporter.config ().setReportName ( "HerokuappTest" );

            extentReports.attachReporter ( extentReporter );
            extentReports.setSystemInfo ( "Organization", "Prime Holding JSC" );
            configFileReader = new ConfigFileReader ();
            extentReports.setSystemInfo ( "Browser", configFileReader.getDriverType () );
        }
        return extentReports;
    }
}

