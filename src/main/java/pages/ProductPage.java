package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver lDriver;
    public ProductPage(WebDriver driver){
        this.lDriver=driver;}

    By menuButtonContainer= By.id("menu_button_container");

    By appLogo = By.className("app_logo");

    By shoppingCartContainer= By.id("shopping_cart_container");

    By productPageTitle = By.cssSelector("span[class='title']");

    By productSelectContainer = By.cssSelector("span[class='select_container']");

    By RobotPeekImage = By.className("peek");

    By footerCopyScript = By.cssSelector("div[class='footer_copy']");

    By SocialLogo = By.cssSelector("ul[class='social']");

    By footerRobot = By.className("footer_robot");


    public void navigateToProductPageUrl(){
        System.out.println("Navigate to product Page");
        String productPageUrl = "https://www.saucedemo.com/inventory.html";
        lDriver.get(productPageUrl);
    }


    public boolean verifyingProductTitleVisible(){
        boolean isDisplayed = lDriver.findElement(productPageTitle).isDisplayed();
        System.out.println(" Product title PRODUCT is displayed----");
        return isDisplayed;
    }
    public boolean VerifyingTheMenuButtonBoxIsDisplayed(){
       boolean isDisplayed = lDriver.findElement(menuButtonContainer).isDisplayed();
        System.out.println("Menu Button Box is Displayed-----"+ isDisplayed);
        return isDisplayed;
    }
    public boolean VerifyingTheAppLogoIsDisplayed(){
        boolean isDisplayed = lDriver.findElement(appLogo).isDisplayed();
        System.out.println("App logo  is Displayed-----"+ isDisplayed);
        return isDisplayed;
    }


    public boolean VerifyingTheShoppingCartContainer(){
        boolean isDisplayed = lDriver.findElement(shoppingCartContainer).isDisplayed();
        System.out.println("Shopping Cart Container is Displayed-----"+ isDisplayed);
        return isDisplayed;
    }

    public boolean VerifyingTheProductSelectContainer(){
        boolean isDisplayed = lDriver.findElement(productSelectContainer).isDisplayed();
        System.out.println("Product Select Container is Displayed-----"+ isDisplayed);
        return isDisplayed;
    }
    public boolean VerifyingTheRobotPeekImage(){
        boolean isDisplayed = lDriver.findElement(RobotPeekImage).isDisplayed();
        System.out.println("Robot Peek Image is Displayed-----"+ isDisplayed);
        return isDisplayed;
    }

    public boolean VerifyingTheFooterCopyScript(){
        boolean isDisplayed = lDriver.findElement(footerCopyScript).isDisplayed();
        System.out.println("Footer Copy Script is Displayed-----"+ isDisplayed);
        return isDisplayed;
    }

    public boolean VerifyingTheSocialLogoOnFooterPage(){
        boolean isDisplayed = lDriver.findElement(SocialLogo).isDisplayed();
        System.out.println("Social logo on Footer page is Displayed-----"+ isDisplayed);
        return isDisplayed;
    }
    public boolean VerifyingTheFooterRobotImage(){
        boolean isDisplayed = lDriver.findElement(footerRobot).isDisplayed();
        System.out.println("Footer Robot image  is Displayed-----"+ isDisplayed);
        return isDisplayed;
    }





}
