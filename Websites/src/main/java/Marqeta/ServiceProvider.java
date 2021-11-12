package Marqeta;

import gherkin.deps.com.google.gson.Gson;
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
        APIHandler.setCredentials(username, password);
        String baseURI = "https://sandbox-api.marqeta.com";
        APIHandler.setBaseURI(baseURI);
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
}
