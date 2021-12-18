package helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFromPom {
    private Properties properties;

    public ReadFromPom() throws IOException {
        InputStream is = getClass().getClassLoader()
                .getResourceAsStream("properties-from-pom.properties");
        this.properties = new Properties();
        this.properties.load(is);
    }

    public String getPropertyFomPom(String propertyName) {
        return this.properties.getProperty(propertyName);
    }
}
