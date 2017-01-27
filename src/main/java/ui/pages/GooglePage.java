package ui.pages;


import org.openqa.selenium.WebDriver;
import ui.utils.DriverManager;
import ui.utils.Helpers;

public class GooglePage extends Helpers{
    private WebDriver driver;

    public GooglePage(){this.driver = DriverManager.getDriver();}

    public void openPage(){
        driver.get("http://google.com");
    }
}
