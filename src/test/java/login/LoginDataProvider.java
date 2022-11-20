package login;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "validLoginData")
    public Object[][] getLoginValidCredentials() {
        return new Object[][] {
                { "standard_user", "secret_sauce" },

        };
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] getInValidLoginCredentials() {
        return new Object[][] {
                { "standard_user1",  "secret_sauce" },
                {" standard_user" ,  "secret_sauce1" },

        };
    }


}
