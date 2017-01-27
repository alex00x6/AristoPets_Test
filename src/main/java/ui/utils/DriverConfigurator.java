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
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver32.exe");
               driver = new FirefoxDriver();
            }
            if (browserName.toLowerCase().contains("internet")) {
                System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer32.exe");
                driver = new InternetExplorerDriver();
            }
            if (browserName.toLowerCase().contains("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }
            if (browserName.toLowerCase().contains("safari")){
                System.setProperty("webdriver.safari.driver", "safari.exe");
                driver = new SafariDriver();
            }
            if (browserName.toLowerCase().contains("edge")){
                System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
            }
        }

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
