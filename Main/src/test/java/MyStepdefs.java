import AutomationPractice.model.User;
import handlers.WebHandler;
import exceptions.CustomException;
import exceptions.UnsupportedProtocolException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.naming.OperationNotSupportedException;


public class MyStepdefs {

    private static String username;
    private static String password;

    private static String testString1;
    private static String testString2;

    @Given("I have the correct username")
    public void iHaveTheCorrectUsername() {
        username = User.getUsername();
    }

    @And("I have the correct password")
    public void iHaveTheCorrectPassword() {
        password = User.getPassword();
    }

    @When("I press the submit login button")
    public void iPressTheSubmitLoginButton() throws OperationNotSupportedException, UnsupportedProtocolException, CustomException {
        WebHandler.setCurrentWebDriver("chrome");
        WebHandler.implicitTimeout(1000);
        AutomationPractice.Service.login();
    }

    @Then("I will be logged in")
    public void iWillBeLoggedIn() {
        Assert.assertEquals(AutomationPractice.Service.isLoggedIn(), true);
    }

    @Given("I have the wrong username")
    public void iHaveTheWrongUsername() {
        AutomationPractice.model.User.setUsername("wrongUsername");
    }

    @And("I have the wrong password")
    public void iHaveTheWrongPassword() {
        AutomationPractice.model.User.setPassword("wrongPassword");
    }

    @Then("I wont be logged in")
    public void iWontBeLoggedIn() {
        Assert.assertEquals(AutomationPractice.Service.isLoggedIn(), false);
    }

    @Given("^A string containing \"(.*?)\"$")
    public void aStringContaining(String arg) {
        testString1 = arg;
    }

    @When("I check if the given string is {int}")
    public void iCheckIfTheGivenStringIs(int arg0) {
        testString2 = Integer.toString(arg0);
    }

    @Then("Cucumber tests are working")
    public void cucumberTestsAreWorking() {
        Assert.assertEquals(testString1, testString2);
    }

    @Given("A value of <a>")
    public void aValueOfA() {
    }
}
