package Marqeta;

import gherkin.deps.com.google.gson.Gson;
import handlers.APIHandler;
import handlers.APIHandler2;
import handlers.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class ServiceProvider {

    public static void init() {
        FileHandler.setFileName("../Websites/src/main/java/Marqeta/credentials.txt");
        FileHandler.initialise();
        ArrayList<String> credentials = null;
        try {
            credentials = FileHandler.readFile();
        } catch (IOException e) {
            System.out.println("Issues reading the file");
            e.printStackTrace();
        }
        assert credentials != null;
        String username = credentials.get(0);
        String password = credentials.get(1);
        APIHandler.setCredentials(username, password);
        APIHandler2.setCredentials(username, password);

        String baseURI = "https://sandbox-api.marqeta.com";
        APIHandler.setBaseURI(baseURI);
        APIHandler2.setBaseURI(baseURI);
    }

    public static Response getUsers(){
        String resource = "/v3/users";
        APIHandler.setResource(resource);
        return APIHandler.basicAuthGET();
    }

    public static Response createUser(String bodyData){
        String resource = "/v3/users";
        APIHandler.setResource(resource);
        return APIHandler.basicAuthPOST(bodyData);
    }

    public static Response getUserByToken(String userToken) {
        String resource = String.format("/v3/users/%s", userToken);
        APIHandler.setResource(resource);
        return APIHandler.basicAuthGET();
    }

    public static Response updateUserByToken(String userToken, String json) {
        String resource = String.format("/v3/users/%s", userToken);
        System.out.println(resource);
        APIHandler.setResource(resource);
        return APIHandler.basicPUT(json);
    }

    public static Response getUser2() {
        String resource = "/v3/users";
        APIHandler2.setResource(resource);
        return APIHandler2.makeRequest(true, APIHandler2.requestTypes.GET, "");
    }

    public static Response createUser2() {
        String resource = "/v3/users";
        APIHandler2.setResource(resource);
        Map<String, String> bodyDataMap = new HashMap<>();
        bodyDataMap.put("first_name", "Test");
        bodyDataMap.put("last_name", "lastName");
        String body = new Gson().toJson(bodyDataMap);
        return APIHandler2.makeRequest(true, APIHandler2.requestTypes.POST, body);
    }
}
