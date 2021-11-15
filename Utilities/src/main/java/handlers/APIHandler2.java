package handlers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class APIHandler2 {

    public enum requestTypes {
        GET,
        POST,
        PUT,
        DELETE
    }

    private static String username;
    private static String password;
    private static String resource;

    public static void setBaseURI(String URI){
        RestAssured.baseURI = URI;
    }

    public static void setResource(String path){
        APIHandler2.resource = path;
    }

    public static void setCredentials(String username, String password) {
        APIHandler2.username = username;
        APIHandler2.password = password;
    }

    public static Response makeRequest(boolean basicAuth, requestTypes methodType, String bodyData){
        RequestSpecification reqSpec = RestAssured.given();
        if(basicAuth){
            reqSpec.auth().basic(username, password);
        }
        reqSpec.header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON);
        if(bodyData != "" && bodyData != null){
            System.out.println("ERROR WITH BODY");
        }
        switch (methodType) {
            case GET:
                return reqSpec.get(APIHandler2.resource).then().extract().response();
            case POST:
                return reqSpec.body(bodyData).post(APIHandler2.resource).then().extract().response();
        }
        return reqSpec.get(APIHandler2.resource).then().extract().response();
    }
}
