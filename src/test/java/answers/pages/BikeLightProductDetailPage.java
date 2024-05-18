package answers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BikeLightProductDetailPage extends BasePage {

    private final By buttonAddToCart = By.id("add-to-cart");
    private final By buttonGoToShoppingCart = By.xpath("//a[@class='shopping_cart_link']");

    public BikeLightProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void addItemToCart() {

         click(buttonAddToCart);
    }

    public void goToShoppingCart() {

        click(buttonGoToShoppingCart);
    }
}
