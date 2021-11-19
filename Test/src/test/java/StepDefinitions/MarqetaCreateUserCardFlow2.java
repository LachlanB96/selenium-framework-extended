package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.Map;

public class MarqetaCreateUserCardFlow2 {

    private static Map<String, Object> headerParams;
    private static Map<String, Object> bodyParams;
    private static Map<String, Object> assertions;
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
                System.out.println("!");
                System.out.println(entry);
                System.out.println("!");
            } else {
                System.out.printf("Key = %s, Value = %s", entry.getKey(), entry.getValue());
            }
        }
        System.out.println(request);
        System.out.println(dataTable);
        System.out.println(endpoint);
        //throw new PendingException();
    }
}
