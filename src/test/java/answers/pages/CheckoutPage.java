package answers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By textfieldFirstName = By.id("first-name");
    private final By textfieldLastName = By.id("last-name");
    private final By textfieldPostalCode = By.id("postal-code");
    private final By buttonContinueToOverview = By.id("continue");
    private final By buttonConfirmOrder = By.id("finish");
    private final By textlabelConfirmation = By.xpath("//h2");

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
