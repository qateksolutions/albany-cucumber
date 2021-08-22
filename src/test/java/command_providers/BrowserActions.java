package command_providers;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    // openBrowser is used to launch browser
    public BrowserActions openBrowser(String url) {
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }

    // closeBrowser is used to close the entire browser session
    public BrowserActions closeBrowser() {
        driver.quit();
        return this;
    }

    // captureTitle is used to capture the title of the browser
    public String captureTitle() {
        return driver.getTitle();
    }
}
