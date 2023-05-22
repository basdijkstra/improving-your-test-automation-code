package answers.pages.helpers;

import org.openqa.selenium.WebDriver;

public class NavigationHelper {

    private final WebDriver driver;

    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {

        this.driver.get(url);
    }
}
