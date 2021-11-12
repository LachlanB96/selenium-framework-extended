package APITests;

import handlers.APIHandler;
import handlers.FileHandler;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;


public class TestGet {

    private static String baseURI;
    private static String resource;
    private static String username;
    private static String password;

    @BeforeTest
    public void setup() throws IOException {
        FileHandler.setFileName("creds.txt");
        FileHandler.initialise();
        ArrayList<String> creds = FileHandler.readFile();

        baseURI = "https://sandbox-api.marqeta.com";
        resource = "/v3/users";
        username = creds.get(0);
        password = creds.get(1);

    }

    @Test
    public void testGET() {
        Response response = RestAssured.get("https://reqres.in/api/users");
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
        String bodyData = "{\n" +
                "        \"first_name\": \"Test2\",\n" +
                "        \"last_name\": \"User2\"\n" +
                "        }";

        APIHandler.setBaseURI(baseURI);
        APIHandler.setResource(resource);
        APIHandler.setCredentials(username, password);

        Response response = APIHandler.basicAuthPOST(bodyData);

        System.out.println(response.asString());

        Assert.assertEquals(201, response.getStatusCode());
    }

//    @Test
//    public void getCreds() throws IOException {
//        FileHandler.setFileName("creds.txt");
//        FileHandler.initialise();
//        ArrayList<String> creds = FileHandler.readFile();
//        System.out.println(creds.get(0));
//        System.out.println(creds.get(1));
//    }

}