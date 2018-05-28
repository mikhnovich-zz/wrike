package steps.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperty {
    FileInputStream file;
    Properties property = new Properties();

    public String getProperty(String name) throws IOException {
        file = new FileInputStream("src/test/java/steps/resources/config.properties");
        property.load(file);
        String res = (String) property.get(name);
        return res;
    }
}

