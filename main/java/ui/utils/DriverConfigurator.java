package ui.utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverConfigurator {
    public static WebDriver createInstance(String seleniumIp, String browserName, Boolean useGrid) {
        URL hostURL = null;
        try {
            hostURL = new URL(seleniumIp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities capability = null;
        WebDriver driver = null;
        if (useGrid) {
            if (browserName.toLowerCase().contains("firefox")) {
                capability = DesiredCapabilities.firefox();
                capability.setBrowserName("firefox");
                capability.setPlatform(Platform.LINUX);
            }
            if (browserName.toLowerCase().contains("internetExplorer")) {
                capability = DesiredCapabilities.internetExplorer();
                capability.setBrowserName("internetExplorer");
            }
            if (browserName.toLowerCase().contains("chrome")) {
                capability = DesiredCapabilities.chrome();
                capability.setBrowserName("chrome");
                capability.setPlatform(Platform.LINUX);
            }
            if (browserName.toLowerCase().contains("safari")){
                capability = DesiredCapabilities.safari();
                capability.setBrowserName("safari");
                capability.setPlatform(Platform.LINUX);
            }
            if (browserName.toLowerCase().contains("edge")){
                capability = DesiredCapabilities.edge();
                capability.setBrowserName("edge");
            }
            driver = new RemoteWebDriver(hostURL, capability);
        }
        else{
            if (browserName.toLowerCase().contains("firefox")) {
               driver = new FirefoxDriver();
                System.setProperty("webdriver.gecko.driver", "main/resources/geckodriver32.exe");
            }
            if (browserName.toLowerCase().contains("internet")) {
                driver = new InternetExplorerDriver();
                System.setProperty("webdriver.ie.driver", "main/resources/IEDriverServer32.exe");
            }
            if (browserName.toLowerCase().contains("chrome")) {
                driver = new ChromeDriver();
                System.setProperty("webdriver.chrome.driver", "main/resources/chromedriver.exe");
            }
            if (browserName.toLowerCase().contains("safari")){
                driver = new SafariDriver();
                System.setProperty("webdriver.safari.driver", "safari.exe");
            }
            if (browserName.toLowerCase().contains("edge")){
                driver = new EdgeDriver();
                System.setProperty("webdriver.edge.driver", "main/resources/MicrosoftWebDriver.exe");
            }
        }

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
