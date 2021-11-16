package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public class MarqetaUserFlowStepDefs {



    @Given("^I have initialised the APIHandler$")
    public void iHaveInitialisedTheAPIHandler() {
        Marqeta.ServiceProvider.init();
    }

    @Given("^I have the following table of field data for the users$")
    public void iHaveTheFollowingTableOfFieldDataForTheUsers(List<Map<String, String>> dataTable) {
        System.out.println(dataTable);
        for(Map<String, String> userData : dataTable){
            Response res = Marqeta.ServiceProvider.createUser(userData);
            System.out.println(res.asString());
        }
    }

//    @Given("^I have the following table of names and initials$")
//    public void iHaveTheFollowingTableOfNamesAndInitials(Map<String, List<String>> data) {
//        //for()
//        System.out.println(data);
//    }

    @When("^I create the user request$")
    public void iCreateTheUserRequest() {
        System.out.println("testWhen");
    }

    @Then("^The users should exist$")
    public void theUsersShouldExist() {
        System.out.println("TestThen");
    }

}
