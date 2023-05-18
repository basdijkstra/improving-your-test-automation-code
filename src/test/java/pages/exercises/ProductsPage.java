package pages.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By buttonAddBackpackToCart = By.id("add-to-cart-sauce-labs-backpack");
    private final By buttonGoToShoppingCart = By.xpath("//a[@class='shopping_cart_link']");

    public ProductsPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addBackpackToCart() {

        click(buttonAddBackpackToCart);
    }

    public void goToShoppingCart() {

        click(buttonGoToShoppingCart);
    }

    private void click(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
}
