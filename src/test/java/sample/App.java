package sample;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class App {

    public static void main(String[] args) throws CustomException {

        String testURL = "http://www.google.com";

        Driver.setCurrentDriver("chrome");
        Driver.goToURL(testURL);

        int a = 1;
        int b = 2;
        String c = "3";
        int d = 0;

//        try {
//            int x = a / d;
//        } catch (Exception e){
//            System.out.println("ERR0R: " + e);
//            throw new CustomException(e);
//        }

        Driver.implicitTimeout(10);
        String testURL2 = "http://www.bing.com";
        //Driver.goToURL(testURL2);
        //Product product = Driver.findElement(By.id("lst-ib"));
        SearchElement searchElement = new SearchElement(Driver.findElement(By.xpath("//input[@title='Search']")));
        Product product = Driver.findElement(By.xpath("lst-ib"));
        product.sendKeys("Selenium33");
        product.sendKeys(Keys.RETURN);
        Products productList = new Products(Driver.findElements(By.className("_Rm")));
        System.out.println(productList.size());
    }
}
