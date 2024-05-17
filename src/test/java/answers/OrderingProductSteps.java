package answers;

import answers.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderingProductSteps {

    private WebDriver driver;

    @Before(value = "@answers")
    public void startBrowser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("Susie Standard is a Sauce Web Shop user")
    public void susie_standard_is_a_sauce_web_shop_user() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginAs("standard_user", "secret_sauce");
    }

    @When("they order the Sauce Labs backpack using")
    public void they_order_the_sauce_labs_backpack_using(List<Map<String, String>> orderData) {

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();
        productsPage.goToShoppingCart();

        new ShoppingCartPage(driver).goToCheckout();

        Map<String, String> order = orderData.getFirst();

        new CheckoutPage(driver).completeOrderFor(
                order.get("firstName"),
                order.get("lastName"),
                order.get("postalCode")
        );
    }

    @Then("their order is successful")
    public void their_order_is_successful() {

        assertEquals(
                "Thank you for your order!",
                new CheckoutPage(driver).getOrderConfirmationText()
        );
    }

    @After(value = "@answers")
    public void closeBrowser() {

        driver.quit();
    }
}
