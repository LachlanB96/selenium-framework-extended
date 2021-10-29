package AutomationPractice.page;


import AutomationPractice.model.User;
import driver.LogHandler;
import driver.WebHandler;
import exceptions.CustomException;

import java.time.Duration;

public class HomePage {


    public static void login() throws CustomException {

        //If signed out, find the sign in button and click it
        WebHandler.findElement(AutomationPractice.object.HomePage.loginButton).click();

        //Using a custom input method, send the username with a 0.1 second delay
        WebHandler.keyInput(AutomationPractice.object.HomePage.usernameInput,
                AutomationPractice.model.User.getUsername(),
                Duration.ofMillis(100));

        //Using a custom input method, send the password with a 0.1 second delay
        WebHandler.keyInput(AutomationPractice.object.HomePage.passwordInput,
                User.getPassword(),
                Duration.ofMillis(100));

        //Click the submit button to complete sign in
        WebHandler.findElement(AutomationPractice.object.HomePage.submitLoginInput).click();

        try {
            WebHandler.findElement(AutomationPractice.object.HomePage.logoutButton);
            LogHandler.standardLog("Login successful", "INFO");
        } catch (CustomException e) {
            LogHandler.standardLog("Login NOT successful", "WARN");
        }
    }

    public static boolean checkLoggedIn() {
        try {
            WebHandler.findElement(AutomationPractice.object.HomePage.logoutButton);
            return true;
        } catch (CustomException e) {
            return false;
        }
    }
}
