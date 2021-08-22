package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt='Logo']");
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");

    public WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    // Mouse Hover to the rates link
    public NavigationBar mouseHoverToRates() {
        LOGGER.debug("Mouse Hove to Rates Link in the navigation bar");
        ActOn.element(driver, RatesLink).mouseHover();
        return this;
    }

    // Click on Real Apr link
    public RealApr navigateToRealApr() {
        LOGGER.debug("Navigating to Real Apr Page");
        ActOn.element(driver, RealAprLink).click();
        return new RealApr(driver);
    }

    // Navigate to the Home Page
    public Home navigateToHome() {
        LOGGER.debug("Navigating to Home Page");
        ActOn.element(driver, MortgageCalculatorLogo).click();
        return new Home(driver);
    }
}
