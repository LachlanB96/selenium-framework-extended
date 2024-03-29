package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.testng.Assert;


public class MyStepdefs {

    private static String testString1;
    private static String testString2;

    private static int a;
    private static int b;
    private static int sum;
    private static Boolean outcome;



    @Given("^A string containing \"(.*?)\"$")
    public void aStringContaining(String str) {
        System.out.printf("A string containing '%s'\n", str);
        testString1 = str;
    }

    @When("^I check if the given string is (\\d+)$")
    public void iCheckIfTheGivenStringIs(int arg0) {
        System.out.printf("A string containing '%d'\n", arg0);
        testString2 = Integer.toString(arg0);
    }

    @Then("Cucumber tests are working")
    public void cucumberTestsAreWorking() {
        Assert.assertEquals(testString1, testString2);
    }

    @Given("A value of (\\d+)")
    public void aValueOf(int a) {
        StepDefinitions.MyStepdefs.a = a;
    }

    @And("And a value of (\\d+)")
    public void aValueOfB(int b) {
        StepDefinitions.MyStepdefs.b = b;
    }

    @When("I compare the value of a \\+ b it should be (\\d+)")
    public void iCompareTheValueOfABItShouldBeSum(int sum) {
        StepDefinitions.MyStepdefs.sum = sum;
    }


    @Then("We compare if sum was the desired output of \"(.*?)\"")
    public void weCompareIfSumWasTheDesiredOutputOfOutcome(String outcome) {
        StepDefinitions.MyStepdefs.outcome = Boolean.getBoolean(outcome);
        if(a + b == sum && StepDefinitions.MyStepdefs.outcome){
            assert true;
        }
    }

}
