package product;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductPage;

public class ProductPageTest extends BaseTest {


    LoginPage loginPage;

    @BeforeMethod
    void preValidation() {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        boolean isPresent = loginPage.verifyingThePresenceOfRobotImage();
        Assert.assertTrue(isPresent);
    }

    @Test
    void verifyingPrimaryHeaderLabelsAreDisplayed() {
//        loginPage.enterUsername("standard_user");
//        loginPage.enterPassword("secret_sauce");
//        loginPage.clickOnLoginButton();
       ProductPage productPage= loginPage.loginAsStandardUser("standard_user","secret_sauce");

        boolean isLogoDisplayed = productPage.VerifyingTheAppLogoIsDisplayed();
        boolean isMenuBtnDisplayed = productPage.VerifyingTheMenuButtonBoxIsDisplayed();
        boolean isShoppingCartDisplayed = productPage.VerifyingTheShoppingCartContainer();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isLogoDisplayed);
        softAssert.assertTrue(isMenuBtnDisplayed);
        softAssert.assertTrue(isShoppingCartDisplayed);
    }

    @Test
    public void verifyingSecondaryHeaderLabelAreDisplayed() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        ProductPage productPage= new ProductPage(driver);


        boolean isSelectContainerDisplayed = productPage.VerifyingTheProductSelectContainer();
        boolean isRobotPeekImageDisplayed = productPage.VerifyingTheRobotPeekImage();
        boolean isProductTitleVisible = productPage.verifyingProductTitleVisible();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isSelectContainerDisplayed);
        softAssert.assertTrue(isRobotPeekImageDisplayed);
        softAssert.assertTrue(isProductTitleVisible);

    }

    @Test
    public void verifyingFooterLabelAtTheBottomOfThePageAreDisplayed() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

         ProductPage productPage= new ProductPage(driver);


        boolean isFooterScriptDisplayed = productPage.VerifyingTheFooterCopyScript();
        boolean isSocialLogoDisplayed = productPage.VerifyingTheSocialLogoOnFooterPage();
        boolean isFooterRobotImageVisible = productPage.VerifyingTheFooterRobotImage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isFooterRobotImageVisible);
        softAssert.assertTrue(isFooterScriptDisplayed);
        softAssert.assertTrue(isSocialLogoDisplayed);
    }
    @AfterMethod
    public void closeWindow(){
    driver.quit();

    }
}