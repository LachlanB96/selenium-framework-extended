package Marqeta;

import gherkin.deps.com.google.gson.Gson;
import handlers.OldAPIHandler;
import handlers.APIHandler;
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
        OldAPIHandler.setCredentials(username, password);
        APIHandler.setCredentials(username, password);

        String baseURI = "https://sandbox-api.marqeta.com";
        OldAPIHandler.setBaseURI(baseURI);
        APIHandler.setBaseURI(baseURI);
    }

    public static Response getUsersBasic(){
        String resource = "/v3/users";
        OldAPIHandler.setResource(resource);
        return OldAPIHandler.basicAuthGET();
    }

    public static Response createUserBasic(String bodyData){
        String resource = "/v3/users";
        OldAPIHandler.setResource(resource);
        return OldAPIHandler.basicAuthPOST(bodyData);
    }

    public static Response getUserByToken(String userToken) {
        String resource = String.format("/v3/users/%s", userToken);
        OldAPIHandler.setResource(resource);
        return OldAPIHandler.basicAuthGET();
    }

    public static Response updateUserByToken(String userToken, String json) {
        String resource = String.format("/v3/users/%s", userToken);
        System.out.println(resource);
        OldAPIHandler.setResource(resource);
        return OldAPIHandler.basicPUT(json);
    }


    public static Response getUserGeneric() {
        String resource = "/v3/users";
        APIHandler.setResource(resource);
        Map<String, String> authData = new HashMap<>();
        authData.put("authType", "basic");
        return APIHandler.makeRequest(APIHandler.requestTypes.GET, "", authData);
    }

    public static Response createUserGeneric() {
        String resource = "/v3/users";
        APIHandler.setResource(resource);
        Map<String, String> bodyDataMap = new HashMap<>();
        bodyDataMap.put("first_name", "Bob555");
        bodyDataMap.put("last_name", "Sturt");
        String body = new Gson().toJson(bodyDataMap);
        Map<String, String> authData = new HashMap<>();
        authData.put("authType", "basic");
        return APIHandler.makeRequest(APIHandler.requestTypes.POST, body, authData);
    }

    public static Response updateUserGeneric(){
        String resource = "/v3/users/114f0af1-254f-4609-b315-bf833fd0e211";
        APIHandler.setResource(resource);
        Map<String, String> bodyDataMap = new HashMap<>();
        bodyDataMap.put("first_name", "Homer");
        bodyDataMap.put("last_name", "Simpson");
        String body = new Gson().toJson(bodyDataMap);
        Map<String, String> authData = new HashMap<>();
        authData.put("authType", "basic");
        return APIHandler.makeRequest(APIHandler.requestTypes.PUT, body, authData);
    }

    public static Response deleteUserGeneric(){
        String resource = "/v3/users";
        APIHandler.setResource(resource);
        Map<String, String> bodyDataMap = new HashMap<>();
        bodyDataMap.put("first_name", "Delete");
        bodyDataMap.put("last_name", "Me Please");
        String body = new Gson().toJson(bodyDataMap);
        Map<String, String> authData = new HashMap<>();
        authData.put("authType", "basic");
        Response response = APIHandler.makeRequest(APIHandler.requestTypes.POST, body, authData);
        System.out.println(response.asString());
        String token = response.path("token").toString();
        resource = "/v3/users/" + token;
        APIHandler.setResource(resource);
        response = APIHandler.makeRequest(APIHandler.requestTypes.DELETE, "", authData);
        System.out.println(response.asString());
        return response;
    }

    public static Response createUser(Map<String, String> bodyDataMap) {
        String resource = "/v3/users";
        APIHandler.setResource(resource);
        String body = new Gson().toJson(bodyDataMap);
        Map<String, String> authData = new HashMap<>();
        authData.put("authType", "basic");
        return APIHandler.makeRequest(APIHandler.requestTypes.POST, body, authData);
    }

    public static Response searchUser(Map<String, String> bodyDataMap){
        String resource = "/v3/users/lookup";
        APIHandler.setResource(resource);
        String body = new Gson().toJson(bodyDataMap);
        Map<String, String> authData = new HashMap<>();
        authData.put("authType", "basic");
        return APIHandler.makeRequest(APIHandler.requestTypes.POST, body, authData);
    }

    public static Response createBasicCardProduct(Map<String, String> bodyDataMap) {
        String resource = "/v3/cardproducts";
        APIHandler.setResource(resource);
        String body = new Gson().toJson(bodyDataMap);
        Map<String, String> authData = new HashMap<>();
        authData.put("authType", "basic");
        return APIHandler.makeRequest(APIHandler.requestTypes.POST, body, authData);
    }

}
