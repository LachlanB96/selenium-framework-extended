package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
}
