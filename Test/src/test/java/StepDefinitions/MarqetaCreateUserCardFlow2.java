package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;

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
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }
//TODO: make dataTable put data into the correct places and as the correct format.

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
                throw new Exception(String.format("'%s' request does not exists"));
        }
        for(Map.Entry<String, String> entry : dataTable.entrySet()){
            if(entry.getKey().charAt(0) == '@'){
                //System.out.println("!");
                //System.out.println(entry);
                //System.out.println("!");
                String specialEntry = entry.getKey().substring(1);
                String specialEntryType = specialEntry.split(":")[0];
                String specialEntryKey = specialEntry.split(":")[1].substring(1);
                //System.out.println(entry.getKey().substring(1));
                //System.out.printf("\nSpecial entry type = %s", specialEntryType);

                switch (specialEntryType){
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
        System.out.println(request);
        System.out.println(dataTable);
        System.out.println(endpoint);
        System.out.printf("\nAssertions: %s\n", assertions);
        System.out.printf("\nExtractions: %s\n", extractions);
        //throw new PendingException();
    }

    @When("^I send the request off and store the response$")
    public void iSendTheRequestOffAndStoreTheResponse() {

    }

    @Then("^I assert and extract the variables$")
    public void iAssertAndExtractTheVariables() {
    }
}
