package answers.pages;

import answers.pages.helpers.ElementInteractionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {

    private final ElementInteractionHelper elementInteractionHelper;

    private final By buttonGoToCheckout = By.id("checkout");

    public ShoppingCartPage(WebDriver driver) {

        this.elementInteractionHelper = new ElementInteractionHelper(driver);
    }

    public void goToCheckout() {

        this.elementInteractionHelper.click(buttonGoToCheckout);
    }
}
