package APITests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRestAssured {

    @BeforeTest
    public void setup() {
        Marqeta.ServiceProvider.init();
    }

    @Test
    public void getUserBasicAuth(){
        Response response = Marqeta.ServiceProvider.getUserGeneric();
        System.out.println(response.asString());
    }


    @Test
    public void createUserBasicAuth(){
        Response response = Marqeta.ServiceProvider.createUserGeneric();
        System.out.println(response.asString());
    }

    @Test
    public void updateUser(){
        Response response = Marqeta.ServiceProvider.updateUserGeneric();
        System.out.println(response.asString());
    }
}
