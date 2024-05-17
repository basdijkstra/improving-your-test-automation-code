package exercises;

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

    @Before(value = "@exercises")
    public void startBrowser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I am on the Sauce Web Shop login page")
    public void i_am_on_the_sauce_web_shop_login_page() {

        new LoginPage(driver).open();
    }

    @When("I log in with username {word} and password {word}")
    public void i_log_in_with_username_and_password(String username, String password) {

        new LoginPage(driver).loginAs(username, password);
    }

    @When("I add the Sauce Labs backpack to my shopping cart")
    public void i_add_the_sauce_labs_backpack_to_my_shopping_cart() {

        new ProductsPage(driver).addBackpackToCart();
    }

    @When("I open the shopping cart")
    public void i_open_the_shopping_cart() {

        new ProductsPage(driver).goToShoppingCart();
    }

    @When("I go to the checkout page")
    public void i_go_to_the_checkout_page() {

        new ShoppingCartPage(driver).goToCheckout();
    }

    @When("I complete the order using")
    public void i_complete_the_order_using(List<Map<String, String>> orderData) {
        Map<String, String> order = orderData.getFirst();

        new CheckoutPage(driver).completeOrderFor(
                order.get("firstName"),
                order.get("lastName"),
                order.get("postalCode")
                );
    }

    @Then("I see {string} as a confirmation message")
    public void i_see_thank_you_for_your_order_as_a_confirmation_message(String expectedConformationText) {

        assertEquals(expectedConformationText, new CheckoutPage(driver).getOrderConfirmationText());
    }

    @After(value = "@exercises")
    public void closeBrowser() {

        driver.quit();
    }
}
