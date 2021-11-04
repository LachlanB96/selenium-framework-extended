package handlers;

import exceptions.CustomException;
import exceptions.UnsupportedProtocolException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import javax.naming.OperationNotSupportedException;
import java.time.Duration;
import java.util.List;
import java.util.Objects;


public class WebHandler {

    private static WebDriver currentWebDriver;
    private static Wait currentWaitDriver;


    public static WebDriver getWebDriver() {
        if(WebHandler.currentWebDriver == null){
            setCurrentWebDriver("chrome");
            setCurrentWaitDriver(WebHandler.currentWebDriver);
        }
        return WebHandler.currentWebDriver;
    }

    public static void setCurrentWebDriver(String driver) {
        if(Objects.equals(driver, "chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\LachlanB\\IdeaProjects\\selenium-framework-extended\\chromedriver.exe");
            WebHandler.currentWebDriver = new ChromeDriver();
            LogHandler.standardLog("Chrome Driver set successfully", "INFO");
        }
    }

    public static void setCurrentWaitDriver(WebDriver driver) {
        WebHandler.currentWaitDriver = new FluentWait(driver);
    }

    public static void goToURL(String url) throws UnsupportedProtocolException, OperationNotSupportedException {
        if(!getProtocol(url).equals("http") || getProtocol(url).equals("https"))
            throw new UnsupportedProtocolException(getProtocol(url));
        try {
            currentWebDriver.get(url);
        } catch (Throwable e){
            throw new OperationNotSupportedException("Unable to naviagte to URL " + url);
        }
    }

    public static WebElement findElement(By locator) throws CustomException {
        try {
            return currentWebDriver.findElement(locator);
        } catch (NoSuchElementException e){
            throw new CustomException(e, "No such element exists");
        } catch (Exception e){
            throw new CustomException(e, "Generic exception caught");
        }
    }

//    public static Product findProduct(By locator) throws CustomException {
//        try {
//            Product product = new Product(currentDriver.findElement(locator));
//            return product;
//        } catch (NoSuchElementException e){
//            throw new CustomException(e, "No such element exists");
//        } catch (Exception e){
//            throw new CustomException(e, "Generic exception caught");
//        }
//    }

    public static List<WebElement> findElements(By locator){
        return currentWebDriver.findElements(locator);
    }

    public static void implicitTimeout(long time){
        currentWebDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
    }

    private static String getProtocol(String url){
        return url.split(":")[0];
    }

    public static void keyInput(By elementSelector, String input, Duration ofMillis) throws CustomException {
        String[] strArray = input.split("");
        for(String letter : strArray){
            WebHandler.findElement(elementSelector).sendKeys(letter);
            //currentWaitDriver.wait(ofMillis);
            WebHandler.currentWebDriver.manage().timeouts().implicitlyWait(ofMillis);
        }

    }
}
