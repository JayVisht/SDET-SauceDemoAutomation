package base;

import driverutils.BrowserName;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import driverutils.DriverManager;

public class BaseTest {
// public LoginPage loginPage;
     public WebDriver driver;
// NOT ADVISABLE TO MAKE PVT CONSTRUCTOR IN PARENT BASE TEST CLASS ...CHILD CANT EXTENT IT

     @BeforeMethod
     public  void setUp() {
         setUpDriver();
//         initializeLoginPage();
     }

        @AfterMethod
         public void cleanUp(){
        driver.quit();
        }

//        private  void initializeLoginPage(){
//         loginPage = new LoginPage(driver);
//         loginPage.navigateToLoginPage();
//        }

        private void setUpDriver()
        {
            driver = DriverManager.getDriver(BrowserName.CHROME);
        }




}
