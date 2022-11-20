package driverutils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
 private DriverManager(){} // better to make pvt constructor to avoid unneccesary object creation
// better to make static ,so we can access directly w/o creating object
    public static WebDriver getDriver (BrowserName browserName) {
        WebDriver driver = null;
        if (browserName.toString().equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.toString().equalsIgnoreCase("Firefox")){
            WebDriverManager.chromedriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.toString().equalsIgnoreCase("Safari")) {
            WebDriverManager.chromedriver().setup();
            driver = new SafariDriver();
        } else {
            System.out.println("Invalid Browser Name,pls select the Browser ");
        }
        return driver;
    }
}