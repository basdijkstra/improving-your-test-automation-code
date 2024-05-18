package answers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage extends BasePage {

    private final By buttonGoToCheckout = By.id("checkout");
    private final By buttonRemoveBackpack = By.id("remove-sauce-labs-backpack");
    private final By buttonContinueShopping = By.id("continue-shopping");
    private final By textlabelNumberOfItemsInShoppingCart = By.xpath("//span[@data-test='shopping-cart-badge']");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void removeBackpackFromShoppingCart() {

        click(buttonRemoveBackpack);
    }

    public void continueShopping() {

        click(buttonContinueShopping);
    }

    public boolean shoppingCartIsEmpty() {

        return isNotDisplayed(textlabelNumberOfItemsInShoppingCart);
    }

    public void goToCheckout() {

        click(buttonGoToCheckout);
    }
}
