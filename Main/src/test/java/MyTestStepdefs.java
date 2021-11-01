import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class MyTestStepdefs {

    private static int a;
    private static int b;
    private static int sum;
    private static Boolean outcome;

    @Given("A value of {int}")
    public void aValueOf(int a) {
        MyTestStepdefs.a = a;
    }

    @And("And a value of {int}")
    public void aValueOfB(int b) {
        MyTestStepdefs.b = b;
    }

    @When("I compare the value of a + b it should be {int}")
    public void iCompareTheValueOfABItShouldBeSum(int sum) {
        MyTestStepdefs.sum = sum;
    }


    @Then("We compare if sum was the desired output of {string}")
    public void weCompareIfSumWasTheDesiredOutputOfOutcome(String outcome) {
        MyTestStepdefs.outcome = Boolean.getBoolean(outcome);
        if(a + b == sum && MyTestStepdefs.outcome){
            assert true;
        }
    }

}
