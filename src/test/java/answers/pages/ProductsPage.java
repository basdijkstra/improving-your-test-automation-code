package answers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage extends BasePage {

    private final By buttonAddBackpackToCart = By.id("add-to-cart-sauce-labs-backpack");
    private final By buttonGoToBikeLightDetailPage = By.xpath("//div[text()='Sauce Labs Bike Light']");
    private final By buttonGoToShoppingCart = By.xpath("//a[@class='shopping_cart_link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addBackpackToCart() {

        click(buttonAddBackpackToCart);
    }

    public void goToBikeLightDetailPage() {

        click(buttonGoToBikeLightDetailPage);
    }

    public void goToShoppingCart() {

        click(buttonGoToShoppingCart);
    }
}
