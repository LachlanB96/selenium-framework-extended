//import AutomationPractice.model.User;
//import handlers.WebHandler;
//import exceptions.CustomException;
//import exceptions.UnsupportedProtocolException;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.testng.Assert;
//
//import javax.naming.OperationNotSupportedException;
//
//
//public class LoginStepdefs {
//
//    private static String username;
//    private static String password;
//    private static boolean expectedOutcome;
//
//    @Given("I have the {string} username")
//    public void iHaveTheUsername(String arg0) {
//        User.setUsername(arg0);
//    }
//
//    @And("I have the {string} password")
//    public void iHaveThePassword(String arg0) {
//        User.setPassword(arg0);
//    }
//
//    @When("I submit the login information")
//    public void iSubmitTheLoginInformation() throws OperationNotSupportedException, UnsupportedProtocolException, CustomException {
//        WebHandler.setCurrentWebDriver("chrome");
//        WebHandler.implicitTimeout(1000);
//        AutomationPractice.Service.login();
//    }
//
//    @Then("I will be logged in if the {string} is true")
//    public void iWillBeLoggedInIfTheIsTrue(String arg0) {
//        expectedOutcome = Boolean.parseBoolean(arg0);
//        Assert.assertEquals(AutomationPractice.Service.isLoggedIn(), expectedOutcome);
//    }
//}
