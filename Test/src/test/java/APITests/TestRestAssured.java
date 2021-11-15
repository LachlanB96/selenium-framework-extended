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
    public void createUserBasicAuth(){
        Response response = Marqeta.ServiceProvider.createUser2();
        System.out.println(response.asString());
    }

    @Test
    public void getUserBasicAuth(){
        Response response = Marqeta.ServiceProvider.getUser2();
        System.out.println(response.asString());
    }
}
