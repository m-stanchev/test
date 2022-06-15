import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public static WebDriver createWebDriver() {
        ConfigFileReader fileReader = new ConfigFileReader ();
        String driverType = fileReader.getDriverType ();
        switch (driverType) {
            case "chrome":
                WebDriverManager.chromedriver ().setup ();
                return new ChromeDriver ();
            case "firefox":
                WebDriverManager.firefoxdriver ().setup ();
                return new FirefoxDriver ();
            case "edge":
                WebDriverManager.edgedriver ().setup ();
                return new EdgeDriver ();

            default:
                throw new IllegalStateException ( "Error: " + driverType );

        }

    }

    public static ChromeDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}
