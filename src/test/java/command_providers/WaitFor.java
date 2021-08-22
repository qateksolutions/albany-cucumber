package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {
    private WebDriver driver;
    private By locator;

    public WaitFor(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public WaitFor waitForElementToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    public WaitFor fixWait(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            System.out.println("Wait Exception is: " + e);
        }
        return this;
    }
}
