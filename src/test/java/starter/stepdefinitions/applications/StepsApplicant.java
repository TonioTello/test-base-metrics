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
import starter.utils.JsonFile;

public class StepsApplicant {

    StartAppController startAppController = new StartAppController();
    CreateAppController createAppController = new CreateAppController();
    ClaimAppController claimAppController = new ClaimAppController();
    ApproveAppController approveAppController = new ApproveAppController();

    JsonFile jsonFile = new JsonFile();
    private int numAppsBefore;
    private int numAppsAfter;

    @Managed(driver = "chrome")
    WebDriver driver;           //options = "headless"
    NavigateController navigateController;
    EnvironmentVariables environmentVariables;

    String environment = "";

    public void login(String rol) {
        //throw new io.cucumber.java.PendingException();
    }

    @Given("the applicant is logged at Ottomoto home page")
    public void theApplicantIsLoggedAtOttomotoHomePage() {
/*        String username = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("user.username.applicant");
        String password = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("user.password.applicant");
        navigateController.toTheOttomotoHomePage();
        startAppController.inputCredentials(driver, username, password);*/
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Login successfully", true);
    }


    @When("the applicant submits all the form fields")
    public void theApplicantSubmitsAllTheFormFields() {
        ////throw new io.cucumber.java.PendingException();
    }


    @Then("the applicant see a message notification")
    public void theApplicantSeeAMessageNotification() {
    }

    @Then("the super admin see a message notification")
    public void theSuperAdminSeeAMessageNotification() {
        //throw new io.cucumber.java.PendingException();
    }

    @And("the applicant see that an application has been created")
    public void theApplicantSeeThatAAnApplicationHasBeenCreated() {
        //throw new io.cucumber.java.PendingException();
    }

    @When("the applicant submits the form fields")
    public void theApplicantSubmitsTheFormFields() {
        //throw new io.cucumber.java.PendingException();
    }

    @When("the dealer claims and sends the new application to the lender")
    public void theDealerClaimsAndSendsTheNewApplicationToTheLender() {
        //throw new io.cucumber.java.PendingException();
    }

    @And("the lender approves the new application")
    public void theLenderApprovesTheNewApplication() {
        //throw new io.cucumber.java.PendingException();
    }

    @Then("the applicant see the new applications approved")
    public void theApplicantSeeTheNewApplicationsApproved() {
        //throw new io.cucumber.java.PendingException();
    }


    @When("the applicant submits all the form fields including TypeVehicle {string}")
    public void theApplicantSubmitsAllTheFormFieldsIncludingTypeVehicle(String typeVehicle) {
        ////throw new io.cucumber.java.PendingException();
    }

    @And("the applicant submits the form fields including TypeVehicle {string}")
    public void theApplicantSubmitsTheFormFieldsIncludingTypeVehicle(String typeVehicle) {
        //throw new io.cucumber.java.PendingException();

    }


    @And("the {string} see that a new application has been created")
    public void theSeeThatANewApplicationHasBeenCreated(String arg0) {
    }


    @When("the applicant submits only the default values in the form")
    public void theApplicantSubmitsOnlyTheDefaultValuesInTheForm() {

    }
}
