package answers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    private final By textfieldFirstName = By.id("first-name");
    private final By textfieldLastName = By.id("last-name");
    private final By textfieldPostalCode = By.id("postal-code");
    private final By buttonContinueToOverview = By.id("continue");
    private final By buttonConfirmOrder = By.id("finish");
    private final By textlabelConfirmation = By.xpath("//h2");
    private final By textlabelNumberOfItemsInShoppingCart = By.xpath("//span[@data-test='shopping-cart-badge']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void completeOrderFor(String firstName, String lastName, String postalCode) {

        sendKeys(textfieldFirstName, firstName);
        sendKeys(textfieldLastName, lastName);
        sendKeys(textfieldPostalCode, postalCode);
        click(buttonContinueToOverview);
        click(buttonConfirmOrder);
    }

    public String getOrderConfirmationText() {

        return getElementText(textlabelConfirmation);
    }
}
