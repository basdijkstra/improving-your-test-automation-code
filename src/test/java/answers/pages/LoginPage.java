package answers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private final By textfieldUsername = By.id("user-name");
    private final By textfieldPassword = By.id("password");
    private final By buttonLogin = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {

        open("https://www.saucedemo.com/");
    }

    public void loginAs(String username, String password) {

        sendKeys(textfieldUsername, username);
        sendKeys(textfieldPassword, password);
        click(buttonLogin);
    }
}
