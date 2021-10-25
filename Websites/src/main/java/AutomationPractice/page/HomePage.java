package AutomationPractice.page;


import driver.Driver;
import exceptions.CustomException;

import java.time.Duration;

public class HomePage {


    public static void login() throws CustomException {
        Driver.findElement(AutomationPractice.object.HomePage.loginButton).click();
        //Driver.findElement().click();
        Driver.keyInput(AutomationPractice.object.HomePage.usernameInput,
                AutomationPractice.model.User.username,
                Duration.ofMillis(100));
    }
}
