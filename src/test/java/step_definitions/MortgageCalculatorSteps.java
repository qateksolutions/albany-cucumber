package step_definitions;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.RealApr;

import java.util.List;
import java.util.Map;

public class MortgageCalculatorSteps {
    WebDriver driver = Hooks.driver;

    @Given("^user is in mortgage calculator home page$")
    public void navigateToMortgageCalculatorHomePage() {
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }

    @And("^user navigate to Real Apr page$")
    public void navigateToRealAprPage() {
        new Home(driver)
                .mouseHoverToRates()
                .navigateToRealApr();
    }

    @When("^user clicks on calculate button upon entering the data$")
    public void clicksCalculateButtonUponEnteringTheData(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps(String.class, String.class);
        for (Map<String, String> cells: dataTable) {
            new RealApr(driver)
                    .typeHomeValue(cells.get("HomePrice"))
                    .typeDownPayment(cells.get("DownPayment"))
                    .typeInterestRate(cells.get("InterestRate"))
                    .clickOnCalculateButton();
        }
    }

    @Then("^the real apr rate is \"(.+?)\"$")
    public void validateRealAprRate(String realApr) {
        new RealApr(driver)
                .validateRealAprRate(realApr);
    }
}
