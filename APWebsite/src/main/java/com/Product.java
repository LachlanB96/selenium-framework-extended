package com;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Product {

    private static WebElement selfWebElement;

    public Product(WebElement element) {
        selfWebElement = element;
    }

    public static WebElement getSelfWebElement() {
        return selfWebElement;
    }

    public static void setSelfWebElement(WebElement selfWebElement) {
        Product.selfWebElement = selfWebElement;
    }

    public void sendKeys(String keys) {
        selfWebElement.sendKeys(keys);
    }

    public void sendKeys(Keys keys) {
        selfWebElement.sendKeys(keys);
    }
}
