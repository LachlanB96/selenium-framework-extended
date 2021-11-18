package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MarqetaCreateUserCardFlow {

    private static Map<String, String> dataTableGlobal;

    private static String userToken;
    private static String cardProdToken;
    private static String cardToken;

    private static Response createUserRes;
    private static Response createCardProdRes;
    private static Response createCardRes;

    //Used for all Scenarios
    @Given("^I have initialised the APIHandler for use$")
    public void iHaveInitialisedTheAPIHandler() {
        Marqeta.ServiceProvider.init();
    }


    //---Create a User---

    @And("^I have the following table of field data for the user$")
    public void iHaveTheFollowingTableOfFieldDataForTheUser(Map<String, String> data) {
        dataTableGlobal = data;
    }

    @When("^I create the user$")
    public void iCreateTheUser() {
        createUserRes = Marqeta.ServiceProvider.createUser(dataTableGlobal);
    }

    @Then("^I should get a (\\d+) server response and I store the user token$")
    public void iShouldGetAServerResponseAndIStoreTheUserToken(int expectedResponse) {
        JsonPath jsonPathEvaluator = createUserRes.jsonPath();
        userToken = jsonPathEvaluator.get("token");
        Assert.assertEquals(createUserRes.statusCode(), expectedResponse);
    }


    //---Create a Card Product---

    @And("^I have the following table of field data for the card product$")
    public void iHaveTheFollowingTableOfFieldDataForTheCardProduct(Map<String, String> data) {
        dataTableGlobal = data;
    }

    @When("^I create the card product$")
    public void iCreateTheCardProduct() {
        createCardProdRes = Marqeta.ServiceProvider.createBasicCardProduct(dataTableGlobal);
    }

    @Then("^I should get a (\\d+) server response and I store the card product token$")
    public void iShouldGetAServerResponseAndIStoreTheCardProductToken(int expectedResponse) {
        JsonPath jsonPathEvaluator = createCardProdRes.jsonPath();
        cardProdToken = jsonPathEvaluator.get("token");
        Assert.assertEquals(createCardProdRes.statusCode(), expectedResponse);
    }


    //---Create a Card---

    @And("^I have the following table of field data for the card$")
    public void iHaveTheFollowingTableOfFieldDataForTheCard(Map<String, String> data) {
        dataTableGlobal = data;
    }

    @When("^I create the card$")
    public void iCreateTheCard() {
        Map<String, String> newDataTable = new HashMap<>();
        for (Map.Entry<String, String> field : dataTableGlobal.entrySet()) {
            String key = (field.getKey() == null) ? null : field.getKey();
            newDataTable.put(key, field.getValue());
        }
        newDataTable.put("user_token", userToken);
        newDataTable.put("card_product_token", cardProdToken);
        System.out.println(newDataTable);
        createCardRes = Marqeta.ServiceProvider.createBasicCard(newDataTable);
    }

    @Then("^I should get a (\\d+) server response and I store the card token$")
    public void iShouldGetAServerResponseAndIStoreTheCardToken(int expectedResponse) {
        JsonPath jsonPathEvaluator = createCardRes.jsonPath();
        cardToken = jsonPathEvaluator.get("token");
        Assert.assertEquals(createCardRes.statusCode(), expectedResponse);
        System.out.println(cardToken);
    }

}