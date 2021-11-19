package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.valueOf;

public class MarqetaCreateUserCardFlow2 {

    private static Map<String, Object> headerParams;
    private static Map<String, Object> bodyParams;
    private static Map<String, String> assertions;
    private static Map<String, Object> extractions;

    @Given("^I set the environment to \"([^\"]*)\"$")
    public void iSetTheEnvironmentTo(String env) throws Throwable {
        switch (env){
            case "MARQETA_SANDBOX":
                System.out.println("Marqeta Sandbox");
                break;
            default:
                System.out.printf("No known ENV called %s", env);
                throw new Exception("EXC");
        }

    }

    @And("I create a \"(.*?)\" request with the following")
    public void iSendARequestWithTheFollowing(String request, Map<String, String> dataTable) throws Throwable {
        String endpoint;
        switch(request){
            case "CREATE_USER":
                endpoint = Marqeta.API.EndPoints.createUser;
                break;
            case "CREATE_CARD_PRODUCT":
                endpoint = Marqeta.API.EndPoints.createCardProduct;
                break;
            case "CREATE_CARD":
                endpoint = Marqeta.API.EndPoints.createCard;
                break;
            default:
                throw new Exception(String.format("'%s' request does not exists", request));
        }
        for(Map.Entry<String, String> entry : dataTable.entrySet()){
            if(entry.getKey().charAt(0) == '@'){
                String specialEntry = entry.getKey().substring(1);
                String specialEntryType = specialEntry.split(":")[0];
                String specialEntryKey = specialEntry.split(":")[1].substring(1);
                switch (specialEntryType){
                    case "header":
                        if(headerParams == null){
                            headerParams = new HashMap<String, Object>();
                        }
                        headerParams.put(specialEntryKey, entry.getValue());
                        break;
                    case "assert":
                        if(assertions == null){
                            assertions = new HashMap<String, String>();
                        }
                        assertions.put(specialEntryKey, entry.getValue());
                        break;
                    case "extract":
                        if(extractions == null){
                            extractions = new HashMap<String, Object>();
                        }
                        extractions.put(specialEntryKey, entry.getValue());
                        break;
                    default:
                        throw new Exception(String.format("No such special entry exist: %s", specialEntryType));
                }
            } else {
                System.out.printf("Key = %s, Value = %s", entry.getKey(), entry.getValue());
            }
        }
        System.out.println(dataTable);

        System.out.printf("\nHeaders: %s\n", headerParams);
        System.out.printf("\nAssertions: %s\n", assertions);
        System.out.printf("\nExtractions: %s\n", extractions);
    }

    @When("^I send the request off and store the response$")
    public void iSendTheRequestOffAndStoreTheResponse() {
    }

    @Then("^I assert and extract the variables$")
    public void iAssertAndExtractTheVariables() {
        int fakeResponseCode = 201;
        for(Map.Entry<String, String> entry : assertions.entrySet()){
            switch(entry.getKey()){
                case "responseCode":
                    Assert.assertEquals(entry.getValue(), String.valueOf(fakeResponseCode));
                    System.out.printf(String.valueOf(fakeResponseCode));
                    break;
            }
        }

    }
}
