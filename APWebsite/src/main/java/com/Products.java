package com;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Products {

    private static List<WebElement> products;

    public Products(List<WebElement> productWebElements) {
        products = productWebElements;
    }

    public static List<WebElement> getProducts() {
        return products;
    }

    public static void setProducts(List<WebElement> products) {
        Products.products = products;
    }

    public static int size(){
        return products.size();
    }
}
