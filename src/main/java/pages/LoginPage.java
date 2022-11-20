package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
     private final  WebDriver LOCAL_DRIVER; //pvt because its local driver
     public LoginPage(WebDriver driver){
         this.LOCAL_DRIVER= driver;
     }
   //its good practice to make locator pvt and final only this class will use and hence the variable will be
//    constant and uppercase (UPPERCASE MEANS CONSTANT AND FINAL)
    private final By USERNAME_TEXT_BOX= By.id("user-name");
    private final By PASSWORD_TEXT_BOX= By.id("password");
    private final By LOGIN_BUTTON= By.id("login-button");
    private final By ROBOT_IMAGE = By.xpath("//*[@id='root']/div/div[2]/div[1]/div[2]");

    private final By ERROR_MESSAGE= By.cssSelector("h3[data-test='error']");


    public LoginPage navigateToLoginPage() {
        System.out.println("Launch the Browser");
        String LoginUrl = "https://www.saucedemo.com/";
        System.out.println("Navigate to URL"+LoginUrl);
        LOCAL_DRIVER.get(LoginUrl);
        return this;
    }
    public boolean verifyingThePresenceOfUsernameTextBox() {
        boolean presenceOfUsername = LOCAL_DRIVER.findElement(USERNAME_TEXT_BOX).isDisplayed();
        System.out.println("Username is present---" + presenceOfUsername);
        return presenceOfUsername;
    }

    public boolean verifyingThePresenceOfPasswordTextBox() {
        boolean presenceOfPassword = LOCAL_DRIVER.findElement(PASSWORD_TEXT_BOX).isDisplayed();
        System.out.println("Password is present---" + presenceOfPassword);
        return presenceOfPassword;
    }

    public boolean verifyingThePresenceOfLoginButton() {
        boolean presenceOfLoginButton = LOCAL_DRIVER.findElement(LOGIN_BUTTON).isDisplayed();
        System.out.println("LoginButton is present---" + presenceOfLoginButton);
        return presenceOfLoginButton;
    }

    public boolean verifyingThePresenceOfRobotImage() {
        boolean presenceOfRobotImage = LOCAL_DRIVER.findElement(ROBOT_IMAGE ).isDisplayed();
        System.out.println("RobotImage is present---" + presenceOfRobotImage);
        return presenceOfRobotImage;

    }

    public LoginPage enterUsername(String username) {
        System.out.println("Enter username:" + username);
        LOCAL_DRIVER.findElement(USERNAME_TEXT_BOX).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        System.out.println("Enter password:" + password);
        LOCAL_DRIVER.findElement(PASSWORD_TEXT_BOX).sendKeys(password);
        return this;
    }

    public LoginPage clickOnLoginButton() {
        System.out.println("loginButton click");
        LOCAL_DRIVER.findElement(LOGIN_BUTTON).click();
        return this;

    }
    public ProductPage loginAsStandardUser(String userName ,String passWord) {
        enterUsername(userName);
        enterPassword(passWord);
        clickOnLoginButton();
       return new ProductPage(LOCAL_DRIVER);

    }
        public String isErrorMessageDisplayedWhenInvalidCredentialsEntered() {
        String ErrorMessage = LOCAL_DRIVER.findElement(ERROR_MESSAGE).getText();
        System.out.println("Valid Error Message Displayed");
        return ErrorMessage;


    }


    }