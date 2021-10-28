import AutomationPractice.model.User;
import exceptions.CustomException;
import exceptions.UnsupportedProtocolException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.naming.OperationNotSupportedException;

public class MyStepdefs {

    private static String username;
    private static String password;

    @Given("I have the correct username")
    public void iHaveTheCorrectUsername() {
        username = User.username;
    }

    @And("I have the correct password")
    public void iHaveTheCorrectPassword() {
        password = User.password;
    }

    @When("I press the submit login button")
    public void iPressTheSubmitLoginButton() throws OperationNotSupportedException, UnsupportedProtocolException, CustomException {
        AutomationPractice.Service.login();
    }

    @Then("I will be logged in")
    public void iWillBeLoggedIn() {
        
    }

    @Given("I have the wrong username")
    public void iHaveTheWrongUsername() {
        
    }

    @And("I have the wrong password")
    public void iHaveTheWrongPassword() {
        
    }

    @Then("I wont be logged in")
    public void iWontBeLoggedIn() {
    }
}
