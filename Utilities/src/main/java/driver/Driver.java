package driver;

import exceptions.CustomException;
import exceptions.UnsupportedProtocolException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;


public class Driver {

    private static WebDriver currentDriver;


    public static WebDriver getDriver() {
        if(Driver.currentDriver == null){
            setCurrentDriver("chrome");
        }
        return Driver.currentDriver;
    }

    public static void setCurrentDriver(String driver) {
        if(Objects.equals(driver, "chrome")) {
            System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
            Driver.currentDriver = new ChromeDriver();
        }
    }

    public static void goToURL(String url){
        if(!getProtocol(url).equals("http") || getProtocol(url).equals("https")) {
            try {
                throw new UnsupportedProtocolException(getProtocol(url));
            } catch (Exception | UnsupportedProtocolException e) {
                e.printStackTrace();
            }
        }
        currentDriver.get(url);
    }

    public static WebElement findElement(By locator) throws CustomException {
        try {
            return currentDriver.findElement(locator);
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
        return currentDriver.findElements(locator);
    }

    public static void implicitTimeout(long time){
        currentDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
    }

    private static String getProtocol(String url){
        return url.split(":")[0];
    }

    public static void keyInput(By elementSelector, String input, Duration ofMillis) throws CustomException {
        String[] strArray = input.split("");
        for(String letter : strArray){
            Driver.findElement(elementSelector).sendKeys(letter);
        }

    }
}
