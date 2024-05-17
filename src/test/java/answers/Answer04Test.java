package answers;

import answers.pages.*;
import exercises.pages.CheckoutPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Answer04Test {

    private WebDriver driver;

    @BeforeEach
    public void startBrowser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginAs("standard_user", "secret_sauce");
    }

    @Test
    public void addBackpackToShoppingCart_removeItem_shouldBeSuccessful() {

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();
        productsPage.goToShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.removeBackpackFromShoppingCart();

        assertTrue(shoppingCartPage.shoppingCartIsEmpty());
    }

    @Test
    public void orderItemFromProductDetailPage_checkoutOrder_shouldBeSuccessful() {

        // Add product from product detail page
        new ProductsPage(driver).goToBikeLightDetailPage();
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
