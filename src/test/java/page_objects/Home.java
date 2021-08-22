package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar {
    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    private final By HomeValue = By.id("homeval");
    private final By DownPayment = By.id("downpayment");
    private final By DownPaymentInDollar = By.xpath("//*[@id='calc']//input[@name='param[downpayment_type]'][@value='money']");
    private final By LoanAmount = By.id("loanamt");
    private final By InterestRate = By.id("intrstsrate");
    private final By LoanTerm = By.id("loanterm");
    private final By StartDateMonth = By.name("param[start_month]");
    private final By StartDateYear = By.id("start_year");
    private final By PropertyTax = By.id("pptytax");
    private final By Pmi = By.id("pmi");
    private final By Hoi = By.id("hoi");
    private final By Hoa = By.id("hoa");
    private final By LoanType = By.name("param[milserve]");
    private final By BuyOrRefi = By.name("param[refiorbuy]");
    private final By Calculate = By.name("cal");

    public Home(WebDriver driver) {
        super(driver);
    }

    // Enter Home value
    public Home typeHomePrice(String value) {
        LOGGER.debug("Entered Home price is: " + value);
        ActOn.element(driver, HomeValue).setValue(value);
        return this;
    }

    // Enter Down payment
    public Home typeDownPayment(String value) {
        ActOn.wait(driver, DownPayment).waitForElementToBeVisible();
        LOGGER.debug("Entered Down Payment is: " + value);
        ActOn.element(driver, DownPayment).setValue(value);
        return this;
    }

    // Click on the $ radio button for the Down Payment option
    public Home clickDownPaymentInDollar() {
        LOGGER.debug("Clicked on the Down Payment in Dollar");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    // Enter loan amount
    public Home typeLoanAmount(String value) {
        LOGGER.debug("Entered Loan Amount is: " + value);
        ActOn.element(driver, LoanAmount).setValue(value);
        return this;
    }

    // Enter interest rate
    public Home typeInterestRate(String value) {
        LOGGER.debug("Entered Interest Rate is: " + value);
        ActOn.element(driver, InterestRate).setValue(value);
        return this;
    }

    // Enter loan term
    public Home typeLoanTermInYears(String value) {
        LOGGER.debug("Entered Loan term is: " + value);
        ActOn.element(driver, LoanTerm).setValue(value);
        return this;
    }

    // Select month
    public Home selectMonth(String month) {
        LOGGER.debug("Selected month is: " + month);
        ActOn.element(driver, StartDateMonth).selectValue(month);
        return this;
    }

    // Enter Year
    public Home typeYear(String year) {
        LOGGER.debug("Entered year is: " + year);
        ActOn.element(driver, StartDateYear).setValue(year);
        return this;
    }

    // Enter the property tax
    public Home typePropertyTax(String value) {
        LOGGER.debug("Entered property tax is: " + value);
        ActOn.element(driver, PropertyTax).setValue(value);
        return this;
    }

    // Enter the pmi
    public Home typePmi(String value) {
        LOGGER.debug("Entered pmi is: " + value);
        ActOn.element(driver, Pmi).setValue(value);
        return this;
    }

    // Enter the homeowner insurance "1000"
    public Home typeHOI(String value) {
        LOGGER.debug("Entered homeowner insurance is: " + value);
        ActOn.element(driver, Hoi).setValue(value);
        return this;
    }

    // Enter the monthly hoa
    public Home typeHOA(String value) {
        LOGGER.debug("Entered homeowner association is: " + value);
        ActOn.element(driver, Hoa).setValue(value);
        return this;
    }

    // Select the loan type
    public Home selectLoanType(String value) {
        LOGGER.debug("Selected loan type is: " + value);
        ActOn.element(driver, LoanType).selectValue(value);
        return this;
    }

    // Selecting "Buy" from Buy or Refi dropdown
    public Home selectBuyOrRefi(String value) {
        LOGGER.debug("Selected Buy or Refi option is: " + value);
        ActOn.element(driver, BuyOrRefi).selectValue(value);
        return this;
    }

    // Click on the calculate button
    public Home clickOnCalculateButton() {
        LOGGER.debug("Clicked on the Calculate button");
        ActOn.element(driver, Calculate).click();
        return this;
    }

    // Validating that Total Monthly payment is accurate
    public Home validateMonthlyPayment(String totalMonthlyPayment) {
        LOGGER.debug("Validating total Monthly payment " + totalMonthlyPayment);
        By monthlyPaymentLocator = By.xpath("//*[@id='calc']//h3[text()='"+ totalMonthlyPayment +"']");
        AssertThat.elementAssertions(driver, monthlyPaymentLocator).elementExist();
        return this;
    }
}
