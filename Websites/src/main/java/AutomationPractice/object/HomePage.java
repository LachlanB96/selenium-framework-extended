package AutomationPractice.object;

import org.openqa.selenium.By;

public class HomePage {

    public static By loginButton = By.xpath("//*[@id=\"header\"]//a[@class=\"login\"]");

    public static By usernameInput = By.xpath("//*[@id=\"email\"]");

    public static By passwordInput = By.xpath("//*[@id=\"passwd\"]");

    public static By submitLoginInput = By.xpath("//*[@id=\"SubmitLogin\"]");

    public static By logoutButton = By.xpath("//*[@id=\"header\"]//a[@class=\"logout\"]");

}
