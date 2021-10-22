package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class App {

    public static void main(String[] args) {

        String testURL = "http://www.google.com";
        String testURL1 = "hthtp://www.google.com";


        Driver.setCurrentDriver("chrome");
        Driver.goToURL(testURL);


        Driver.implicitTimeout(1000);
        String testURL2 = "http://www.bing.com";
        //Driver.goToURL(testURL2);
        //com.Product product = Driver.findElement(By.id("lst-ib"));
        WebDriverWait wait = new WebDriverWait(Driver.getCurrentDriver(), Duration.ofSeconds(1));
        //wait.until(visibilityOf())
        Wait<WebDriver> wait1 = new FluentWait<>(Driver.getCurrentDriver());
        //wait1.until(Driver.findElement(By.xpath("lst-ib")));
        //SearchElement searchElement = new SearchElement(Driver.findElement(By.xpath("//input[@title='Search']")));
//        Product product = Driver.findProduct(By.xpath("lst-ib"));
//        product.sendKeys("Selenium33");
//        product.sendKeys(Keys.RETURN);
        new Products(Driver.findElements(By.className("_Rm")));
        System.out.println(Products.size());
    }
}
