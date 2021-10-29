package AutomationPractice;

import driver.WebHandler;
import exceptions.CustomException;
import exceptions.UnsupportedProtocolException;

import javax.naming.OperationNotSupportedException;

public class Service {

    public static void login() throws OperationNotSupportedException, UnsupportedProtocolException, CustomException {
        WebHandler.goToURL(AutomationPractice.object.HomePage.homePageURL);
        AutomationPractice.page.HomePage.login();
    }

    public static boolean isLoggedIn(){
        return AutomationPractice.page.HomePage.checkLoggedIn();
    }
}
