package exercises;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise02Test {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void startBrowser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addBackpackToShoppingCart_checkoutOrder_shouldBeSuccessful() {

        // Navigate to the web shop
        driver.get("https://www.saucedemo.com/");

        // Log in to the web shop
        sendKeys(By.id("user-name"), "standard_user");
        sendKeys(By.id("password"), "secret_sauce");
        click(By.id("login-button"));

        // Add backpack to cart
        click(By.id("add-to-cart-sauce-labs-backpack"));

        // Go to shopping cart
        click(By.xpath("//a[@class='shopping_cart_link']"));

        // Go to checkout
        click(By.id("checkout"));

        // Fill in details
        sendKeys(By.id("first-name"), "John");
        sendKeys(By.id("last-name"), "Doe");
        sendKeys(By.id("postal-code"), "90210");
        click(By.id("continue"));

        // Confirm
        click(By.id("finish"));

        // Check that checkout has been completed successfully
        assertEquals("Thank you for your order!", getElementText(By.xpath("//h2")));
    }

    @AfterEach
    public void stopBrowser() {

        driver.quit();
    }

    private void sendKeys(By locator, String textToType) {

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(textToType);
    }

    private void click(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    private String getElementText(By locator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }
}
