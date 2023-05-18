package pages.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By textfieldFirstName = By.id("first-name");
    private final By textfieldLastName = By.id("last-name");
    private final By textfieldPostalCode = By.id("postal-code");
    private final By buttonContinueToOverview = By.id("continue");
    private final By buttonConfirmOrder = By.id("finish");
    private final By textlabelConfirmation = By.xpath("//h2");

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    private void sendKeys(By locator, String textToType) {

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(textToType);
    }

    private void click(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    private String getElementText(By locator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }
}
