import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "src/main/resources/Configuration";

    public ConfigFileReader() {
        try {
            FileReader reader = new FileReader ( propertyFilePath );
            properties = new Properties ();
            properties.load ( reader );
            reader.close ();


        } catch (IOException e) {
            Assert.fail ( e.getMessage () );
        }
    }

    public String getProperty(String propertyName) {
        return properties.getProperty ( propertyName );
    }

    public String getDriverType() {
        return getProperty ( "browser" );
    }


}
