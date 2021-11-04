package com;

import handlers.LogHandler;
import handlers.WebHandler;
import exceptions.CustomException;
import exceptions.UnsupportedProtocolException;

import javax.naming.OperationNotSupportedException;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws CustomException, IOException, OperationNotSupportedException, UnsupportedProtocolException {


        WebHandler.setCurrentWebDriver("chrome");
        WebHandler.implicitTimeout(1000);

        AutomationPractice.Service.login();

        LogHandler.printLog(3);


        //PLEASE EXCUSE THIS MESS OF COMMENTS

//        FileHandler.setFileName("./sample.txt");
//        FileHandler.initialise();
//
//        ArrayList<String> fileLines = FileHandler.readFile();
//
//        for(String line : fileLines){
//            System.out.println(line);
//        }
//
//        FileHandler.initialise();
//        FileHandler.writeFile("Hello new line");
//
//        FileHandler.initialise();
//        fileLines = FileHandler.readFile();
//
//        for(String line : fileLines){
//            System.out.println(line);
//        }

        //LogHandler.standardLog("Good morning", new Date());

//        FileHandler.setFileName("standard-log.txt");
//        FileHandler.initialise();
//        ArrayList<String> fileLines = FileHandler.readFile();
//
//        for(String line : fileLines){
//            System.out.println(line);
//        }

       // LogHandler.printLog(3);




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
