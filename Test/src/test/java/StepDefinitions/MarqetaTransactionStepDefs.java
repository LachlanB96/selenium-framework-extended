package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

public class MarqetaTransactionStepDefs {

    private static Map<String, String> dataTableGlobal;

    @Given("^I have initialised the APIHandler for use$")
    public void iHaveInitialisedTheAPIHandler() {
        Marqeta.ServiceProvider.init();
    }

    @And("^I have the following table of field data for the user$")
    public void iHaveTheFollowingTableOfFieldDataForTheUser(Map<String, String> data) {
        dataTableGlobal = data;
    }

    @When("^I make a transaction$")
    public void iMakeATransaction() {

    }

    @Then("^my balance should be lower than before$")
    public void myBalanceShouldBeLowerThanBefore() {
    }
}
