package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.resources.GetProperty;


import java.io.File;
import java.io.IOException;

public class Browser {
    private static Browser instance = null;
    private WebDriver driver;
    private GetProperty property = new GetProperty();
    private File file = new File("");

    private Browser() {
    }

    public WebDriver getDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath() + "\\" + property.getProperty("resources") + "chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public static Browser getInstance()
    {
        if (instance == null)
        {
            instance = new Browser();
        }
        return instance;
    }
}