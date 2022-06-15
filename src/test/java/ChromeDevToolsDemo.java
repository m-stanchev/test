import com.google.common.collect.ImmutableList;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.network.Network;
import org.openqa.selenium.devtools.v101.network.model.ConnectionType;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.openqa.selenium.devtools.v85.performance.Performance;
import org.openqa.selenium.devtools.v85.performance.model.Metric;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ChromeDevToolsDemo {

    //Paris coordinates
    private double parisLatitude = 48.864716;
    private double parisLongitude = 2.349014;

    //Madrid coordinates
    private double madridLatitude = 40.416775;
    private double madridLongitude = -3.703790;

    //Nova Zagora coordinates
    private double novaZagoraLatitude = 42.493635;
    private double novaZagoraLongitude = 26.008544;

    private final int accuracy = 1;


    @Test
    public void setGeolocationOverride() {

        ChromeDriver driver = DriverManager.createChromeDriver();
        DevTools devTools = driver.getDevTools();

        devTools.createSession();

        Map<String, Object> coordinates = new HashMap<String, Object>();

        coordinates.put("latitude", parisLatitude);
        coordinates.put("longitude", parisLongitude);
        coordinates.put("accuracy", accuracy);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        driver.get("https://browserleaks.com/geo");
        driver.manage().window().maximize();

        //focus on the map
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("reverse")));
    }

    @Test
    public void setDeviceMetrics() {

        ChromeDriver driver = DriverManager.createChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        // iPhone 11 Pro dimensions
        devTools.send(Emulation.setDeviceMetricsOverride(500,
                750,
                50,
                true,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));
        driver.get("https://selenium.dev/");
    }

    @Test
    public void collectPerformanceMetrics() {
        ChromeDriver driver = DriverManager.createChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));
        List<Metric> metricList = devTools.send(Performance.getMetrics());
        driver.get("https://google.com");
        driver.quit();

        for(Metric m : metricList) {
            System.out.println(m.getName() + "=" + m.getValue());
        }
    }

    @Test
    public void blockNetworkRequests() {
        ChromeDriver driver = DriverManager.createChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.png")));

        driver.get("https://phptravels.com/demo/");
    }

    @Test
    public void emulateNetworkSpeed() {
        ChromeDriver driver = DriverManager.createChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(false, 1, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));
        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.id("cartur"));

    }
}
