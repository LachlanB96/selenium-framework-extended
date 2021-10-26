package com;

import driver.Driver;

import driver.FileHandler;
import exceptions.CustomException;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws CustomException {

//        String testURL = "http://automationpractice.com";
//        String testURL2 = "http://www.google.com";
//        String testURL1 = "hthtp://www.google.com";
//        String testURL0 = "http://www.bing.com";
//
//
//        Driver.setCurrentWebDriver("chrome");
//        Driver.implicitTimeout(1000);
//        Driver.goToURL(testURL);
//
//
//        AutomationPractice.page.HomePage.login();


        FileHandler.setFileName("./sample.txt");
        FileHandler.initialise();




        //Driver.goToURL(testURL2);
        //AutomationPractice.page.Product product = Driver.findElement(By.id("lst-ib"));
        // wait = new WebDriverWait(Driver.getCurrentDriver(), Duration.ofSeconds(1));
        //wait.until(visibilityOf())
        //Wait<WebDriver> wait1 = new FluentWait<>(Driver.getCurrentDriver());
        //wait1.until(Driver.findElement(By.xpath("lst-ib")));
        //SearchElement searchElement = new SearchElement(Driver.findElement(By.xpath("//input[@title='Search']")));
//        Product product = Driver.findProduct(By.xpath("lst-ib"));
//        product.sendKeys("Selenium33");
//        product.sendKeys(Keys.RETURN);
        //new Products(Driver.findElements(By.className("_Rm")));
        //System.out.println(Products.size());
    }
}
