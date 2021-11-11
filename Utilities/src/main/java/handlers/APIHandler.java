package handlers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class APIHandler {

    private static String username;
    private static String password;
    private static String resource;

    public static void setBaseURI(String URI){
        RestAssured.baseURI = URI;
    }

    public static void setResource(String path){
        APIHandler.resource = path;
    }

    public static void setCredentials(String username, String password) {
        APIHandler.username = username;
        APIHandler.password = password;
    }

    public static Response basicAuthGet() {
        Response response = given()
                .auth()
                .preemptive()
                .basic(username, password)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .get(APIHandler.resource)
                .then().extract().response();
        return response;
    }
}
