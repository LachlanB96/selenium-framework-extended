package APITests;

import gherkin.deps.com.google.gson.Gson;
import handlers.APIHandler;
import handlers.FileHandler;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TestUserGETPOST {

    private static String baseURI;
    private static String resource;
    private static String username;
    private static String password;

    @BeforeTest
    public void setup() throws IOException {
        FileHandler.setFileName("../Websites/src/main/java/Marqeta/credentials.txt");
        FileHandler.initialise();
        ArrayList<String> credentials = FileHandler.readFile();

        baseURI = "https://sandbox-api.marqeta.com";
        resource = "/v3/users";
        username = credentials.get(0);
        password = credentials.get(1);

    }

    @Test
    public void testGET() {
        APIHandler.setBaseURI("https://reqres.in");
        APIHandler.setResource("/api/users");
        Response response = APIHandler.basicGET();
        System.out.println(response.asString());
    }

    @Test
    public void getUsers() {
        APIHandler.setBaseURI(baseURI);
        APIHandler.setResource(resource);
        APIHandler.setCredentials(username, password);

        Response response = APIHandler.basicAuthGET();

        System.out.println(response.asString());

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void createUsers() {
        Map<String, String> bodyDataMap = new HashMap<>();

        bodyDataMap.put("first_name", "test");
        bodyDataMap.put("last_name", "map");

        String json = new Gson().toJson(bodyDataMap);

        APIHandler.setBaseURI(baseURI);
        APIHandler.setResource(resource);
        APIHandler.setCredentials(username, password);

        Response response = APIHandler.basicAuthPOST(json);

        System.out.println(response.asString());

        Assert.assertEquals(201, response.getStatusCode());
    }

}