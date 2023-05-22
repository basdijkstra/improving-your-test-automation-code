package answers.pages;

import answers.pages.helpers.ElementInteractionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private final ElementInteractionHelper elementInteractionHelper;

    private final By buttonAddBackpackToCart = By.id("add-to-cart-sauce-labs-backpack");
    private final By buttonGoToShoppingCart = By.xpath("//a[@class='shopping_cart_link']");

    public ProductsPage(WebDriver driver) {
        this.elementInteractionHelper = new ElementInteractionHelper(driver);
    }

    public void addBackpackToCart() {

        this.elementInteractionHelper.click(buttonAddBackpackToCart);
    }

    public void goToShoppingCart() {

        this.elementInteractionHelper.click(buttonGoToShoppingCart);
    }
}
