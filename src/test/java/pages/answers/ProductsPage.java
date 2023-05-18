package pages.answers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By buttonAddBackpackToCart = By.id("add-to-cart-sauce-labs-backpack");
    private final By buttonGoToShoppingCart = By.xpath("//a[@class='shopping_cart_link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addBackpackToCart() {

        click(buttonAddBackpackToCart);
    }

    public void goToShoppingCart() {

        click(buttonGoToShoppingCart);
    }
}
