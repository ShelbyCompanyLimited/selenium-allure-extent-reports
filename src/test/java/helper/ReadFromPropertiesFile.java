package helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertiesFile {

    public Properties properties;
    private String propertyFilePath;


    public ReadFromPropertiesFile() {

        if (System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {
            propertyFilePath = System.getProperty("user.dir") + "/src/test/resources/settings.properties";
        }
        else
        {
            propertyFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\settings.properties";
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getEmail() {
        String item = properties.getProperty("email");
        if (item != null) return item;
        else throw new RuntimeException("email is not specified in Property File");
    }

    public String getPassword() {
        String item = properties.getProperty("password");
        if (item != null) return item;
        else throw new RuntimeException("password is not specified in Property File");
    }

}