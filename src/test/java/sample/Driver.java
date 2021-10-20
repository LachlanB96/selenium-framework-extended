package sample;

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


    public static WebDriver getCurrentDriver() {
        return currentDriver;
    }

    public static void setCurrentDriver(String driver) {
        if(Objects.equals(driver, "chrome")) {
            System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
            Driver.currentDriver = new ChromeDriver();
        }
    }

    public static void goToURL(String url){
        try {
            currentDriver.get(url);
        } catch  (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public static Product findElement(By locator) throws CustomException {
        try {
            Product product = new Product(currentDriver.findElement(locator));
            return product;
        } catch (NoSuchElementException e){
            throw new CustomException(e, "No such element exists");
        } catch (Exception e){
            throw new CustomException(e, "Generic exception caught");
        }
    }

    public static List<WebElement> findElements(By locator){
        return currentDriver.findElements(locator);
    }

    public static void implicitTimeout(long time){
        currentDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
    }
}
