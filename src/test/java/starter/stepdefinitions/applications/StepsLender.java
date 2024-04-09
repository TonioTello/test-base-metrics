package starter.stepdefinitions.applications;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import starter.controllers.NavigateController;
import starter.controllers.applications.ApproveAppController;
import starter.controllers.applications.ClaimAppController;
import starter.controllers.applications.CreateAppController;
import starter.controllers.applications.StartAppController;
import starter.controllers.companies.SetCompanyController;
import starter.utils.JsonFile;

public class StepsLender {

    StartAppController startAppController = new StartAppController();
    CreateAppController createAppController = new CreateAppController();
    ClaimAppController claimAppController = new ClaimAppController();
    ApproveAppController approveAppController = new ApproveAppController();
    SetCompanyController setCompanyController = new SetCompanyController();


    JsonFile jsonFile = new JsonFile();
    private int numAppsBefore;
    private int numAppsAfter;
    private String applicationNum = "00000";
    private String typeApplication = "loan";

    @Managed(driver = "chrome")
    WebDriver driver;           //options = "headless"
    NavigateController navigateController;
    EnvironmentVariables environmentVariables;


    public void login(String rol) {
        navigateController.toTheOttomotoHomePage();
    }

    @Given("the lender is logged at Ottomoto home page")
    public void theLenderIsLoggedAtOttomotoHomePage() {
        //throw new io.cucumber.java.PendingException();
    }

    @When("the lender submits only the default values in the form")
    public void theLenderSubmitsOnlyTheDefaultValuesInTheForm() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the lender see a message notification")
    public void theLenderSeeAMessageNotification() {
        //throw new io.cucumber.java.PendingException();
        //throw new io.cucumber.java.PendingException();
        //Assert.fail();

    }

    @And("the lender see that an application has been created")
    public void theLenderSeeThatAnApplicationHasBeenCreated() {
        throw new io.cucumber.java.PendingException();

    }


    @Given("the lender has created an application")
    public void theLenderHasCreatedAnApplication() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the lender update the {string} application with the required fields")
    public void theLenderUpdateTheApplicationWithTheRequiredFields(String application) {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the lender send the request to OTTOinspector")
    public void theLenderSendTheRequestToOTTOinspector() {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the lender see a successful message notification")
    public void theLenderSeeASuccessfulMessageNotification() {
        //throw new io.cucumber.java.PendingException();
    }

    @And("the lender see that the OTTOinspector status is pending")
    public void theLenderSeeThatTheOTTOinspectorStatusIsPending() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the lender submits all the form fields including TypeVehicle {string}")
    public void theLenderSubmitsAllTheFormFieldsIncludingTypeVehicle(String typeVehicle) {
        //throw new io.cucumber.java.PendingException();


    }

    @When("the lender submits the configuration questionnaire")
    public void theLenderSubmitsTheConfigurationQuestionnaire() {
        //throw new io.cucumber.java.PendingException();


    }

    @And("the lender see that questionnaire has been saved")
    public void theLenderSeeThatQuestionnaireHasBeenSaved() {
        //throw new io.cucumber.java.PendingException();
        //Assert.fail("Questionnaire not found");
    }

    @When("the lender updated it with the payment information {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void theLenderUpdatedItWithThePaymentInformation(String typeApplication, String loanTerms, String frequency, String interestRate, String cashPrice, String downPayment, String manufacturerRebate, String securityDeposit, String tradeValue, String tradePayoff, String netTradeValue, String salesTax, String dealerFees, String eTRFee, String licenseFee, String titleFees, String otherFee) throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the lender should see the Unpaid Balance and Calculated Payment")
    public void theLenderShouldSeeTheUnpaidBalanceAndCalculatedPayment() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the lender should see the Total Check and Amount Financed")
    public void theLenderShouldSeeTheTotalCheckAndAmountFinanced() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the lender submits all the form fields")
    public void theLenderSubmitsAllTheFormFields() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @Given("the lender has created a full application")
    public void theLenderHasCreatedAFullApplication() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @Given("the lender has created a simple application type lease")
    public void theLenderHasCreatedASimpleApplicationTypeLease() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();


    }

    @When("the lender updated the lease application with the payment information")
    public void theLenderUpdatedTheLeaseApplicationWithThePaymentInformation() {
        //throw new io.cucumber.java.PendingException();

    }
}
