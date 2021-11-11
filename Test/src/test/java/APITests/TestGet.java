package APITests;

import handlers.APIHandler;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestGet {

    @Test
    public void testGET(){
        Response response = RestAssured.get("https://reqres.in/api/users");
        System.out.println(response.asString());
    }

    @Test
    public void getUsers() {
        String baseURI = "https://sandbox-api.marqeta.com";
        String resource = "/v3/users";
        String username = "760e4e8f-537a-4074-a3e0-5e600aafddb8";
        String password = "ae5725cc-bda6-4987-8db2-df0ae042a349";

        APIHandler.setBaseURI(baseURI);
        APIHandler.setResource(resource);
        APIHandler.setCredentials(username, password);

        Response response = APIHandler.basicAuthGet();

        System.out.println(response.asString());

        Assert.assertEquals(200, response.getStatusCode());
    }

}
