package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;


public class LoginPageTest  extends BaseTest {
//    private LoginPageTest() {
//    } // no reason for anyone to access, hence pvt constructor to avoid object creation
    private LoginPage loginPage;
    @BeforeMethod
    void preValidation() {
       loginPage = new LoginPage(driver);
       loginPage.navigateToLoginPage();
        boolean isPresent = loginPage.verifyingThePresenceOfRobotImage();
        Assert.assertTrue(isPresent);
    }

    @Test
    void verifyTheUsernameTextBoxPresence() {
        boolean isPresent = loginPage.verifyingThePresenceOfUsernameTextBox();
        Assert.assertTrue(isPresent);

    }

    @Test
    void verifyThePasswordTextBoxPresence() {
        boolean isPresent = loginPage.verifyingThePresenceOfPasswordTextBox();
        Assert.assertTrue(isPresent);
    }

    @Test
    void verifyTheLoginButtonPresence() {
        boolean isPresent = loginPage.verifyingThePresenceOfLoginButton();
        Assert.assertTrue(isPresent);
    }
    @Test (dataProvider ="validLoginData",dataProviderClass = LoginDataProvider.class)
    void verifyUserIsAbleToLoginWithValidCredentials(String username,String Password){

        ProductPage productPage = new ProductPage(driver);
        loginPage.loginAsStandardUser("standard_user", "secret_sauce");

      boolean isProductTitleVisible = productPage.verifyingProductTitleVisible();
        Assert.assertTrue(isProductTitleVisible);
}
    @Test (dataProvider ="invalidLoginData",dataProviderClass = LoginDataProvider.class)
    void verifyUserIsAbleToLoginWithInValidCredentials(String username,String Password){

        loginPage.loginAsStandardUser("standard_user", "secret_sauce");
        String ExpectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String ActualErrorMessage = loginPage.isErrorMessageDisplayedWhenInvalidCredentialsEntered();
        Assert.assertEquals(ActualErrorMessage,ExpectedErrorMessage);
    }


    @AfterMethod
    void afterMethod(){
     driver.quit();
   }

}