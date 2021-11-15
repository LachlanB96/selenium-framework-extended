package handlers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class APIHandler {

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
        APIHandler.resource = path;
    }

    public static void setCredentials(String username, String password) {
        APIHandler.username = username;
        APIHandler.password = password;
    }

    public static Response makeRequest(boolean basicAuth, requestTypes methodType, String bodyData){

        RequestSpecification reqSpec = RestAssured.given();

        if(basicAuth) reqSpec.auth().basic(username, password);

        reqSpec.header("Accept", ContentType.JSON.getAcceptHeader());
        reqSpec.contentType(ContentType.JSON);

        Response response;
        switch (methodType) {
            case GET:
                response = reqSpec.get(APIHandler.resource);
                break;
            case POST:
                response = reqSpec.body(bodyData).post(APIHandler.resource);
                break;
            case PUT:
                response = reqSpec.body(bodyData).put(APIHandler.resource);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + methodType);
        }
        return response.then().extract().response();
    }
}
