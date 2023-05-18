package pages.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By buttonGoToCheckout = By.id("checkout");

    public ShoppingCartPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToCheckout() {

        click(buttonGoToCheckout);
    }

    private void click(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
}
