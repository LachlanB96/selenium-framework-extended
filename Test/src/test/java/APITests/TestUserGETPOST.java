package APITests;

import gherkin.deps.com.google.gson.Gson;
import handlers.OldAPIHandler;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class TestUserGETPOST {

    @BeforeTest
    public void setup() {
        Marqeta.ServiceProvider.init();
    }

    @Test
    public void testGET() {
        OldAPIHandler.setBaseURI("https://reqres.in");
        OldAPIHandler.setResource("/api/users");
        Response response = OldAPIHandler.basicGET();
        System.out.println(response.asString());
    }

    @Test
    public void getUsersWithServiceProvider() {
        Response response = Marqeta.ServiceProvider.getUsers();
        System.out.println(response.asString());
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void createUsers() {
        Map<String, String> bodyDataMap = new HashMap<>();
        bodyDataMap.put("first_name", "NEW");
        bodyDataMap.put("last_name", "USER");
        String json = new Gson().toJson(bodyDataMap);

        Response response = Marqeta.ServiceProvider.createUser(json);
        System.out.println(response.asString());
        Assert.assertEquals(201, response.getStatusCode());
    }

}