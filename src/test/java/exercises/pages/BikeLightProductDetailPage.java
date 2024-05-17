package exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BikeLightProductDetailPage {

    private WebDriver driver;
    private final WebDriverWait wait;

    private final By buttonAddToCart = By.id("add-to-cart");
    private final By buttonGoToShoppingCart = By.xpath("//a[@class='shopping_cart_link']");

    public BikeLightProductDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addItemToCart() {

         click(buttonAddToCart);
    }

    public void goToShoppingCart() {

        click(buttonGoToShoppingCart);
    }

    private void click(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
}
