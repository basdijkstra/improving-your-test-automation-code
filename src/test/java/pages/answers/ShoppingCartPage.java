package pages.answers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    private final By buttonGoToCheckout = By.id("checkout");

    public ShoppingCartPage(WebDriver driver) {

        super(driver);
    }

    public void goToCheckout() {

        click(buttonGoToCheckout);
    }
}
