package pages.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By textfieldUsername = By.id("user-name");
    private final By textfieldPassword = By.id("password");
    private final By buttonLogin = By.id("login-button");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {

        this.driver.get("https://www.saucedemo.com/");
    }

    public void loginAs(String username, String password) {

        sendKeys(textfieldUsername, username);
        sendKeys(textfieldPassword, password);
        click(buttonLogin);
    }

    private void sendKeys(By locator, String textToType) {

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(textToType);
    }

    private void click(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
}
