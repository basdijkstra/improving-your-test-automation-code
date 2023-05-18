package answers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.answers.*;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Answer02Test {

    private WebDriver driver;

    @BeforeEach
    public void startBrowser() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addBackpackToShoppingCart_checkoutOrder_shouldBeSuccessful() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();
        productsPage.goToShoppingCart();

        new ShoppingCartPage(driver).goToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.completeOrderFor("John", "Doe", "90210");

        assertEquals("Thank you for your order!", checkoutPage.getOrderConfirmationText());
    }

    @AfterEach
    public void stopBrowser() {

        driver.quit();
    }
}
