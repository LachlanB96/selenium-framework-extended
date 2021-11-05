import AutomationPractice.Service;
import handlers.AssertHandler;
import handlers.WebHandler;
import exceptions.CustomException;
import exceptions.UnsupportedProtocolException;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertTrue;

public class TestNGDemo {

//    @DataProvider(name = "data-test")
//    public Object[][] dpMethodTest(){
//        return new Object[][] {
//                {
//                        true,
//                        "2",
//                        3
//                },
//                {
//                        false,
//                        2.0,
//                        "3"
//                }
//        };
//    }
//
//    @DataProvider(name = "data-provider")
//    public Object[][] dpMethod(){
//        return new Object[][] {
//                {
//                        AutomationPractice.model.User.getUsername(),
//                        AutomationPractice.model.User.getPassword(),
//                        "true"
//                },
//                {
//                        "Fake@username.com",
//                        "fakePassword",
//                        "false"
//                }
//        };
//    }
//
//    @BeforeTest
//    public void setupTest() {
//        WebHandler.setCurrentWebDriver("chrome");
//        WebHandler.implicitTimeout(1000);
//        System.out.println("TEST!!");
//    }
//
//    @Test (dataProvider = "data-test")
//    public void loginToWebsite(Object[] objects) {
//        for(Object value : objects){
//            System.out.print(value);
//        }
//    }
//
//    @Test (dataProvider = "data-provider")
//    public void loginToWebsite(String[] val) throws OperationNotSupportedException, UnsupportedProtocolException, CustomException {
//        String username = val[0];
//        String password = val[1];
//        boolean outcomeExpected = Boolean.parseBoolean(val[2]);
//        AutomationPractice.model.User.setUsername(username);
//        AutomationPractice.model.User.setPassword(password);
//        AutomationPractice.Service.login();
//        //assertTrue(Service.isLoggedIn());
//        //Assert.assertTrue(Service.isLoggedIn());
//        AssertHandler.assertTrue(Service.isLoggedIn(), "Check if user logged in");
//    }
//
//    @AfterTest
//    public void testComplete() {
//        System.out.print("Test Complete.");
//    }
}
