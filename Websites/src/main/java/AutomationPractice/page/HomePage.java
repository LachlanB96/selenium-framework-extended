package AutomationPractice.page;


import AutomationPractice.model.User;
import driver.Driver;
import exceptions.CustomException;

import java.time.Duration;

public class HomePage {


    public static void login() throws CustomException {

        //If signed out, find the sign in button and click it
        Driver.findElement(AutomationPractice.object.HomePage.loginButton).click();

        //Using a custom input method, send the username with a 0.1 second delay
        Driver.keyInput(AutomationPractice.object.HomePage.usernameInput,
                AutomationPractice.model.User.username,
                Duration.ofMillis(100));

        //Using a custom input method, send the password with a 0.1 second delay
        Driver.keyInput(AutomationPractice.object.HomePage.passwordInput,
                User.password,
                Duration.ofMillis(100));

        //Click the submit button to complete sign in
        Driver.findElement(AutomationPractice.object.HomePage.submitLoginInput).click();

        try {
            Driver.findElement(AutomationPractice.object.HomePage.logoutButton);
            System.out.println("Login successful");
        } catch (CustomException e) {
            System.out.println("Login not successful");
        }
    }

}
