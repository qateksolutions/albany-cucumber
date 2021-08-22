package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealApr extends NavigationBar{
    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);

    private final By CalculatorTab = By.xpath("//*[@id='CalcForm']//label[text()='Calculator']");
    private final By HomeValue = By.name("HomeValue");
    private final By DownPayment = By.name("DownPayment");
    private final By DownPaymentInDollar = By.id("DownPaymentSel0");
    private final By InterestRate = By.name("Interest");
    private final By CalculateButton = By.name("calculate");
    private final By ActualAprValue = By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[contains(text(),'Actual APR')]/../../td[2]/strong");

    public RealApr(WebDriver driver) {
        super(driver);
    }

    // Wait for the calculator tab to exist
    public RealApr waitForPageToLoad() {
        LOGGER.debug("Wait for the Real APR page to load");
        ActOn.wait(driver, CalculatorTab).waitForElementToBeVisible();
        return this;
    }

    public RealApr typeHomeValue(String value) {
        LOGGER.debug("Entered Home price is: " + value);
        ActOn.element(driver, HomeValue).setValue(value);
        return this;
    }

    public RealApr clickDownPaymentInDollar() {
        LOGGER.debug("Clicked on Down Payment in Dollar");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    public RealApr typeDownPayment(String value) {
        LOGGER.debug("Entered down payment is: " + value);
        ActOn.element(driver, DownPayment).setValue(value);
        return this;
    }

    public RealApr typeInterestRate(String value) {
        LOGGER.debug("Entered Interest Rate is: " + value);
        ActOn.element(driver, InterestRate).setValue(value);
        return this;
    }

    public RealApr clickOnCalculateButton() {
        LOGGER.debug("Clicked on Calculate button");
        ActOn.element(driver, CalculateButton).click();
        return this;
    }

    public RealApr validateRealAprRate(String expectedValue) {
        String aprRate = ActOn.element(driver, ActualAprValue).getTextValue();
        LOGGER.debug("Validating Real Apr rate is: " + expectedValue);
        Assert.assertEquals("Actual Value is not match with Expected Value", expectedValue, aprRate);
        return this;
    }
}
