package answers.pages;

import answers.pages.helpers.ElementInteractionHelper;
import answers.pages.helpers.NavigationHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final ElementInteractionHelper elementInteractionHelper;
    private final NavigationHelper navigationHelper;

    private final By textfieldUsername = By.id("user-name");
    private final By textfieldPassword = By.id("password");
    private final By buttonLogin = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.elementInteractionHelper = new ElementInteractionHelper(driver);
        this.navigationHelper = new NavigationHelper(driver);
    }

    public void open() {

        this.navigationHelper.open("https://www.saucedemo.com/");
    }

    public void loginAs(String username, String password) {

        this.elementInteractionHelper.sendKeys(textfieldUsername, username);
        this.elementInteractionHelper.sendKeys(textfieldPassword, password);
        this.elementInteractionHelper.click(buttonLogin);
    }
}
