package AutomationPractice.page;

import org.openqa.selenium.WebElement;

public class SearchElement {


    private static WebElement selfWebElement;

    public SearchElement(WebElement element) {

    }

    public static WebElement getSelfWebElement() {
        return selfWebElement;
    }

    public static void setSelfWebElement(WebElement selfWebElement) {
        SearchElement.selfWebElement = selfWebElement;
    }
}
