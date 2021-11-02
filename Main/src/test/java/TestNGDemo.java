import AutomationPractice.Service;
import driver.AssertDriver;
import driver.WebHandler;
import exceptions.CustomException;
import exceptions.UnsupportedProtocolException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestNGDemo {

    @BeforeTest
    public void setupTest() {
        WebHandler.setCurrentWebDriver("chrome");
        WebHandler.implicitTimeout(1000);
    }

    @Test
    public void loginToWebsite() throws OperationNotSupportedException, UnsupportedProtocolException, CustomException {
        AutomationPractice.Service.login();
        assertTrue(Service.isLoggedIn());
        Assert.assertTrue(Service.isLoggedIn());
        AssertDriver.assertTrue(Service.isLoggedIn(), "Check if user logged in");
    }

    @AfterTest
    public void testComplete() {
        System.out.print("Test Complete.");
    }
}
