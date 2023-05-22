package answers.pages.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementInteractionHelper {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ElementInteractionHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void sendKeys(By locator, String textToType) {

        this.wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.driver.findElement(locator).sendKeys(textToType);
    }

    public void click(By locator) {

        this.wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.driver.findElement(locator).click();
    }

    public String getElementText(By locator) {

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator).getText();
    }
}
