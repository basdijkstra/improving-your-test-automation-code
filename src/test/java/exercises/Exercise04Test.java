package exercises;

import exercises.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise04Test {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void startBrowser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addBackpackToShoppingCart_removeItem_addBikeLightFromDetailPage_checkoutOrder_shouldBeSuccessful() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginAs("standard_user", "secret_sauce");

        // Add product from product overview page
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();
        productsPage.goToShoppingCart();

        // Remove product and continue shopping
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.removeBackpackFromShoppingCart();
        shoppingCartPage.continueShopping();

        // Add product from product detail page
        productsPage.goToBikeLightDetailPage();
        BikeLightProductDetailPage bikeLightProductDetailPage = new BikeLightProductDetailPage(driver);
        bikeLightProductDetailPage.addItemToCart();
        bikeLightProductDetailPage.goToShoppingCart();

        // Check that we have one item in our shopping cart
        new ShoppingCartPage(driver).goToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        assertEquals("1", checkoutPage.getNumberOfItemsInOrder());

        // Complete order
        checkoutPage.completeOrderFor("John", "Doe", "90210");
        assertEquals("Thank you for your order!", checkoutPage.getOrderConfirmationText());
    }

    @AfterEach
    public void stopBrowser() {

        driver.quit();
    }
}
