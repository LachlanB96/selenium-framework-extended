package handlers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class OldAPIHandler {

    private static String username;
    private static String password;
    private static String resource;

    public static void setBaseURI(String URI){
        RestAssured.baseURI = URI;
    }

    public static void setResource(String path){
        OldAPIHandler.resource = path;
    }

    public static void setCredentials(String username, String password) {
        OldAPIHandler.username = username;
        OldAPIHandler.password = password;
    }

    public static Response basicGET() {
        return given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .get(OldAPIHandler.resource)
                .then().extract().response();
    }

    public static Response basicAuthGET() {
        return given()
                .auth()
                .preemptive()
                .basic(username, password)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .get(OldAPIHandler.resource)
                .then().extract().response();
    }

    public static Response basicAuthPOST(String bodyData) {
        return given()
                .auth()
                .preemptive()
                .basic(username, password)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .body(bodyData)
                .post(OldAPIHandler.resource)
                .then().extract().response();
    }

    public static Response basicPUT(String bodyData) {
        return given()
                .auth()
                .preemptive()
                .basic(username, password)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .body(bodyData)
                .put(OldAPIHandler.resource)
                .then().extract().response();
    }
}
