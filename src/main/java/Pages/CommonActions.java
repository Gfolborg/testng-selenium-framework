package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.IOException;

import static java.sql.DriverManager.getDriver;

public class CommonActions {
    static WebDriver driver;


    static public WebDriver openBrowser(String browserType) {
        if (browserType.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserType.equals("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserType.equals("Edge")) {
            driver = new EdgeDriver();
        } else if (browserType.equals("Internet Explorer")) {
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Browser Type Invalid");
        }
        return driver;
    }

    public void enterUrl() {
        driver.get("https://tutorialsninja.com/demo");
    }

    public void closeBrowser() {
        driver.close();
    }


}
