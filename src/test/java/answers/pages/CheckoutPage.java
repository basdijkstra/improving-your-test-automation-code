package answers.pages;

import answers.pages.helpers.ElementInteractionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private final ElementInteractionHelper elementInteractionHelper;

    private final By textfieldFirstName = By.id("first-name");
    private final By textfieldLastName = By.id("last-name");
    private final By textfieldPostalCode = By.id("postal-code");
    private final By buttonContinueToOverview = By.id("continue");
    private final By buttonConfirmOrder = By.id("finish");
    private final By textlabelConfirmation = By.xpath("//h2");

    public CheckoutPage(WebDriver driver) {

        this.elementInteractionHelper = new ElementInteractionHelper(driver);
    }

    public void completeOrderFor(String firstName, String lastName, String postalCode) {

        this.elementInteractionHelper.sendKeys(textfieldFirstName, firstName);
        this.elementInteractionHelper.sendKeys(textfieldLastName, lastName);
        this.elementInteractionHelper.sendKeys(textfieldPostalCode, postalCode);
        this.elementInteractionHelper.click(buttonContinueToOverview);
        this.elementInteractionHelper.click(buttonConfirmOrder);
    }

    public String getOrderConfirmationText() {

        return this.elementInteractionHelper.getElementText(textlabelConfirmation);
    }
}
