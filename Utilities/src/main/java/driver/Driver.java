package driver;

import exceptions.CustomException;
import exceptions.UnsupportedProtocolException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;


public class Driver {

    private static WebDriver currentWebDriver;
    private static Wait currentWaitDriver;


    public static WebDriver getWebDriver() {
        if(Driver.currentWebDriver == null){
            setCurrentWebDriver("chrome");
            setCurrentWaitDriver(Driver.currentWebDriver);
        }
        return Driver.currentWebDriver;
    }

    public static void setCurrentWebDriver(String driver) {
        if(Objects.equals(driver, "chrome")) {
            System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
            Driver.currentWebDriver = new ChromeDriver();
        }
    }

    public static void setCurrentWaitDriver(WebDriver driver) {
        Driver.currentWaitDriver = new FluentWait(driver);
    }

    public static void goToURL(String url){
        if(!getProtocol(url).equals("http") || getProtocol(url).equals("https")) {
            try {
                throw new UnsupportedProtocolException(getProtocol(url));
            } catch (Exception | UnsupportedProtocolException e) {
                e.printStackTrace();
            }
        }
        currentWebDriver.get(url);
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
            Driver.findElement(elementSelector).sendKeys(letter);
            //currentWaitDriver.wait(ofMillis);
            Driver.currentWebDriver.manage().timeouts().implicitlyWait(ofMillis);
        }

    }
}
