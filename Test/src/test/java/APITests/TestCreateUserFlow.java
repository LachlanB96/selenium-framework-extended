package APITests;

import gherkin.deps.com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestCreateUserFlow {

    private static String userToken;
    private static final String firstName = "111";
    private static final String lastName = "222";
    private static final String lastNameUpdate = "333";


    @BeforeTest
    public void setup() {
        Marqeta.ServiceProvider.init();
    }

    @Test
    public void createUser() {
        Map<String, String> bodyDataMap = new HashMap<>();
        bodyDataMap.put("first_name", firstName);
        bodyDataMap.put("last_name", lastName);
        String json = new Gson().toJson(bodyDataMap);

        Response response = Marqeta.ServiceProvider.createUserBasic(json);

        JsonPath jsonPathEvaluator = response.jsonPath();
        userToken = jsonPathEvaluator.get("token");

        System.out.println(userToken);
        System.out.println(response.asString());
        Assert.assertEquals(201, response.getStatusCode());
    }

    @Test
    public void getUserWithToken() {
        Response response = Marqeta.ServiceProvider.getUserByToken(userToken);

        JsonPath jsonPathEvaluator = response.jsonPath();
        String userFirstName = jsonPathEvaluator.get("first_name");

        System.out.println(response.asString());

        Assert.assertEquals(userFirstName, firstName);
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void updateUserWithToken() {
        Map<String, String> bodyDataMap = new HashMap<>();
        bodyDataMap.put("last_name", lastNameUpdate);

        String json = new Gson().toJson(bodyDataMap);

        Response response = Marqeta.ServiceProvider.updateUserByToken(userToken, json);

        System.out.println(response.asString());

        JsonPath jsonPathEvaluator = response.jsonPath();

        String userFirstName = jsonPathEvaluator.get("first_name");
        String userLastName = jsonPathEvaluator.get("last_name");

        System.out.println(response.asString());

        Assert.assertEquals(userFirstName, firstName);
        Assert.assertEquals(userLastName, lastNameUpdate);
        Assert.assertEquals(200, response.getStatusCode());
    }

}