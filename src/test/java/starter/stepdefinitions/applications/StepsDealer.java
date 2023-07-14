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
import starter.controllers.ApiController;
import starter.controllers.NavigateController;
import starter.controllers.applications.ApproveAppController;
import starter.controllers.applications.ClaimAppController;
import starter.controllers.applications.CreateAppController;
import starter.controllers.applications.StartAppController;
import starter.utils.JsonFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StepsDealer {

    StartAppController startAppController = new StartAppController();
    CreateAppController createAppController = new CreateAppController();
    ClaimAppController claimAppController = new ClaimAppController();
    ApproveAppController approveAppController = new ApproveAppController();
    ApiController apiController = new ApiController();

    JsonFile jsonFile = new JsonFile();
    private int numAppsBefore;
    private int numAppsAfter;
    private String applicationNum = "00000";
    private String linkNewApplication = "";
    private String unRegisterApplicantEmail = String.format("ottomoto-1fcbe8+%s@inbox.mailtrap.io", new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
    String newApplicationUrl = "";

    String environment = "";
    String typeVehicle = "Passenger";
    String typeApplication = "loan";


    List<String> jdPowerValues = new ArrayList<>();

    @Managed(driver = "chrome")
    WebDriver driver;  //options = "headless"
    NavigateController navigateController;
    EnvironmentVariables environmentVariables;


    public void login(String rol) {
        //throw new io.cucumber.java.PendingException();

    }

    public void login(String rol, String url) {
        //throw new io.cucumber.java.PendingException();

    }

    @Given("the dealer is logged at Ottomoto home page")
    public void theDealerIsLoggedAtOttomotoHomePage() {
        //throw new io.cucumber.java.PendingException();

    }


    @And("the dealer submits the all mandatory form fields")
    public void theDealerSubmitsTheAllMandatoryFormFields() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();


    }

    @Then("the dealer see a successful message notification")
    public void theDealerSeeASuccessfulMessageNotification() {
       // createAppController.validateNotificationMsj(driver);
    }

    @And("the dealer see that a new application has been created")
    public void theDealerSeeThatANewApplicationHasBeenCreated() {
        //throw new io.cucumber.java.PendingException();

    }

    @Given("the dealer has created an application")
    public void theDealerHasCreatedAnApplication() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @Given("the dealer has created a simple application")
    public void theDealerHasCreatedASimpleApplication() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @And("updated it with the payment information {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void updatedItWithThePaymentInformation(String typeApplication, String loanTerms, String frequency, String interestRate, String cashPrice, String downPayment, String manufacturerRebate, String securityDeposit, String tradeValue, String tradePayoff, String netTradeValue, String salesTax, String dealerFees, String eTRFee, String licenseFee, String titleFees, String otherFee) throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the lender claims and set the commission values {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void theLenderClaimsAndSetTheCommissionValues(String lenderGap, String gapCommission, String lenderServiceContract, String serviceContractCommission, String lenderOther, String otherCommission, String dealerGap, String dealerWarranty, String dealerOther) throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer updates his commission values {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void theDealerUpdatesHisCommissionValue(String lenderGap, String gapCommission, String lenderServiceContract, String serviceContractCommission, String lenderOther, String otherCommission, String dealerGap, String dealerWarranty, String dealerOther) {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the dealer should see that Unpaid Balance and Calculated Payment should be equal to {string} and {string} respectively")
    public void theDealerShouldSeeThatUnpaidBalanceAndCalculatedPaymentShouldBeEqualToAndRespectively(String unpaidBalance, String calculatedPayment) {
        System.out.println("unpaidBalance expected = " + unpaidBalance + "and calculatedPayment expected = " + calculatedPayment);
    }

    @And("the Total Check and Amount Financed should be equal to {string} and {string} respectively")
    public void theTotalCheckAndAmountFinancedShouldBeEqualToAndRespectively(String totalCheckLender, String amountFinancedLender) {
        System.out.println("TotalCheckLender expected = " + totalCheckLender + "and AmountFinancedLender expected = " + amountFinancedLender);
        startAppController.logoutUser(driver);
    }

    @When("the lender claims the new application from dealer")
    public void theLenderClaimsTheNewApplicationFromDealer() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the lender approves the new application from dealer")
    public void theLenderApprovesTheNewApplicationFromDealer() {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the dealer see the new applications approved")
    public void theDealerSeeTheNewApplicationsApproved() {
        //throw new io.cucumber.java.PendingException();

    }

    @Given("the dealer{int} is logged at Ottomoto home page")
    public void theDealerIsLoggedAtOttomotoHomePage(int number) {
        //throw new io.cucumber.java.PendingException();
    }

    @And("the dealer sent an application to an unregistered applicant")
    public void theDealerSentAnApplicationToAnUnregisteredApplicant() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the unregistered applicant receives the application via email or text message")
    public void theUnregisteredApplicantReceivesTheApplicationViaEmailOrTextMessage() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the unregistered applicant accept and submits the form fields")
    public void theUnregisteredApplicantAcceptAndSubmitsTheFormFields() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the unregistered applicant submits the form including TypeVehicle {string}")
    public void theUnregisteredApplicantSubmitsTheFormIncludingTypeVehicle(String typeVehicle) {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the dealer is notified by email of the New Application")
    public void theDealerIsNotifiedByEmailOfTheNewApplication() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer open and see the information match with the unregistered applicant")
    public void theDealerOpenAndSeeTheInformationMatchWithTheUnregisteredApplicant() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer see that JD Power values has been saved")
    public void theDealerSeeThatJDPowerValuesHasBeenSaved() {
        //throw new io.cucumber.java.PendingException();

    }

    @Given("the dealer has created an application with the JDpower info")
    public void theDealerHasCreatedAnApplicationWithTheJDpowerInfo() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the dealer check all the JD Power options")
    public void theDealerCheckAllTheJDPowerOptions() {
        //throw new io.cucumber.java.PendingException();


    }

    @And("the dealer update the application")
    public void theDealerUpdateTheApplication() {
        //throw new io.cucumber.java.PendingException();
    }

    @Then("the dealer see that JD Power values change")
    public void theDealerSeeThatJDPowerValuesChange() {
        //throw new io.cucumber.java.PendingException();

    }


    @When("the dealer submits the form fields with the JDpower info")
    public void theDealerSubmitsTheFormFieldsWithTheJDpowerInfo() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }


    @And("the dealer update the {string} application with the required fields")
    public void theDealerUpdateTheApplicationWithTheRequiredFields(String application) {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the dealer send the request to OTTOinspector")
    public void theDealerSendTheRequestToOTTOinspector() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer see that the OTTOinspector status is pending")
    public void theDealerSeeThatTheOTTOinspectorStatusIsPending() {
        //throw new io.cucumber.java.PendingException();

    }


    @And("the dealer see that JD Power values has been update")
    public void theDealerSeeThatJDPowerValuesHasBeenUpdate() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the dealer send the request to OTTOverify")
    public void theDealerSendTheRequestToOTTOverify() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer see that the OTTOverify status is pending")
    public void theDealerSeeThatTheOTTOverifyStatusIsPending() {
        //throw new io.cucumber.java.PendingException();

    }


    @When("the dealer submits all the form fields including TypeVehicle {string}")
    public void theDealerSubmitsAllTheFormFieldsIncludingTypeVehicle(String typeVehicle) throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the dealer see a message notification")
    public void theDealerSeeAMessageNotification() {
        createAppController.validateNotificationMsj(driver);
    }

    @And("the dealer submits the form fields including TypeVehicle {string}")
    public void theDealerSubmitsTheFormFieldsIncludingTypeVehicle(String typeVehicle) {
        //throw new io.cucumber.java.PendingException();

    }

    @Given("the dealer has created a full application")
    public void theDealerHasCreatedAFullApplication() {
        //throw new io.cucumber.java.PendingException();

    }

    private void elseif(boolean contains) {
    }

    @When("the dealer send the request to OTTOinsure")
    public void theDealerSendTheRequestToOTTOinsure() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer receive an email to continue the process with Gabi")
    public void theDealerReceiveAnEmailToContinueTheProcessWithGabi() {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the dealer see an OTTOinsure successful message notification")
    public void theDealerSeeAnOTTOinsureSuccessfulMessageNotification() {
        //throw new io.cucumber.java.PendingException();

    }


    @When("the dealer send the application details to the company {string}")
    public void theDealerSendTheApplicationDetailsToTheCompany(String company) {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer update the application to make a new {int}credit request")
    public void theDealerUpdateTheApplicationToMakeANewCreditRequest(int arg0) {
        //throw new io.cucumber.java.PendingException();
    }


    @When("the dealer submits all the form fields")
    public void theDealerSubmitsAllTheFormFields() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the dealer submits only the default values in the form")
    public void theDealerSubmitsOnlyTheDefaultValuesInTheForm() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the dealer updated it with the payment information {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void theDealerUpdatedItWithThePaymentInformation(String typeApplication, String loanTerms, String frequency, String interestRate, String cashPrice, String downPayment, String manufacturerRebate, String securityDeposit, String tradeValue, String tradePayoff, String netTradeValue, String salesTax, String dealerFees, String eTRFee, String licenseFee, String titleFees, String otherFee) throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the dealer should see the Unpaid Balance and Calculated Payment")
    public void theDealerShouldSeeTheUnpaidBalanceAndCalculatedPayment() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer should see the Total Check and Amount Financed")
    public void theDealerShouldSeeTheTotalCheckAndAmountFinanced() {
        //throw new io.cucumber.java.PendingException();

    }


    @When("the dealer creates a contract with a product from TPA Alpha Warranty")
    public void theDealerCreatesAContractWithAProductFromTPAAlphaWarranty() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer  creates a contract with a product from TPA Truwarranty")
    public void theDealerCreatesAContractWithAProductFromTPATruwarranty() {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the dealer see the two contract created")
    public void theDealerSeeTheTwoContractCreated() {
    }

    @Given("the dealer has created a simple application type lease")
    public void theDealerHasCreatedASimpleApplicationTypeLease() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the dealer updated the lease application with the payment information")
    public void theDealerUpdatedTheLeaseApplicationWithThePaymentInformation() {
        //throw new io.cucumber.java.PendingException();

    }
}
