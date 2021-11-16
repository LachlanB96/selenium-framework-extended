package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class MarqetaUserFlowStepDefs {

    private static List<Map<String, String>> data;

    @Given("^I have initialised the APIHandler$")
    public void iHaveInitialisedTheAPIHandler() {
        Marqeta.ServiceProvider.init();
    }

    @Given("^I have the following table of field data for the users$")
    public void iHaveTheFollowingTableOfFieldDataForTheUsers(List<Map<String, String>> dataTable) {
        data = dataTable;
    }

    @When("^I create the user request$")
    public void iCreateTheUserRequest() {
        System.out.println("testWhenCreate");
        for(Map<String, String> userData : data){
            Response res = Marqeta.ServiceProvider.createUser(userData);
            System.out.println(res.asString());
        }
    }

    @Then("^The users should exist$")
    public void theUsersShouldExist() {
        System.out.println("TestThen");
    }

    @When("^I search for each user$")
    public void iSearchForEachUser() {
        System.out.println("testWhenSearch");
        for(Map<String, String> userData : data){
            Response res = Marqeta.ServiceProvider.searchUser(userData);
            System.out.println(res.asString());
        }
    }

    @Then("^I should get a valid user in response$")
    public void iShouldGetAValidUserInResponse() {
    }
}
