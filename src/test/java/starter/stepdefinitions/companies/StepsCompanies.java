package starter.stepdefinitions.companies;

import com.github.javafaker.Faker;
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
import starter.controllers.applications.ClaimAppController;
import starter.controllers.applications.CreateAppController;
import starter.controllers.applications.StartAppController;
import starter.controllers.companies.CreateRelationshipController;
import starter.controllers.companies.SetCompanyController;
import starter.controllers.signUp.SignUpController;
import starter.utils.JsonFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StepsCompanies {

    StartAppController startAppController = new StartAppController();
    SetCompanyController setCompanyController = new SetCompanyController();

    CreateAppController createAppController = new CreateAppController();
    ClaimAppController claimAppController = new ClaimAppController();


    SignUpController signUpController = new SignUpController();
    CreateRelationshipController createRelationshipController = new CreateRelationshipController();
    ApiController apiController = new ApiController();

    private String applicationNum = "00000";
    private String typeCompany = "Dealer";
    private int numAppsBefore;
    private int numAppsAfter;
    List<String> jdPowerValues = new ArrayList<>();
    JsonFile jsonFile = new JsonFile();


    Faker faker = new Faker();

    private String userNameF = faker.name().firstName();
    private String firstNameF = faker.name().firstName();
    private String lastNameF = faker.name().lastName();
    private String companyF = faker.company().name().replaceAll("[,-.]", "");
    ;
    private String legalNameF = faker.company().name().replaceAll("[,-.]", "");
    private String accountingContactNameF = companyF;
    private String branchNameF = faker.company().name().replaceAll("[,-.]", "");
    private String storeNameF = faker.company().name().replaceAll("[,-.]", "");
    private String queueNameF = faker.company().name().replaceAll("[,-.]", "");
    private String emailAddressF = String.format("appmoto-1fcbe8+settingCompany%s@inbox.mailtrap.io", new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime()));
    private String phoneNumberF = faker.phoneNumber().phoneNumber();
    private String businessAddressF = faker.address().fullAddress();
    private String optionId = "1";
    String environment =  "";

    private String verificationCode = "";
    private String zipCode = "28031";
    private String rolF = faker.job().position();
    private String username = String.format("appmoto-1fcbe8+%s@inbox.mailtrap.io", new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
    private String emailRecoverPassword = "";
    private String password = "2022ottoMOTO*";
    private String newPassword =  String.format("2022ottoMOTO%s*", new SimpleDateFormat("yyyyMM_HHmmss").format(Calendar.getInstance().getTime()));
    private String campaignName = "";
    private String blogPostTitle = "";
    private String codeCoupon = "C10271830";
    private String codeCoupon2 = "C10271828";


    @Managed(driver = "chrome")
    WebDriver driver;               //options = "headless"
    NavigateController navigateController;
    EnvironmentVariables environmentVariables;

    public void login(String rol) {
        navigateController.toTheAppmotoHomePage();
    }

    @Given("the super admin is logged at Appmoto home page")
    public void theSuperAdminIsLoggedAtAppmotoHomePage() {
        //throw new io.cucumber.java.PendingException();
    }

    @And("the super admin has a new company created type {string}")
    public void theSuperAdminHasANewCompanyCreatedType(String typeCompany) {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the company created has a new branch and store-queue")
    public void theCompanyCreatedHasANewBranchAndStore() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the super admin search for the company and select its branch and store-queue")
    public void theSuperAdminSearchForTheCompanyAndSelectItsBranchAndStore() {
        //throw new io.cucumber.java.PendingException();

    }


    @And("creates new roles for the users")
    public void createsNewRolesForTheUsers() {
        //throw new io.cucumber.java.PendingException();


    }

    @Then("the super admin can complete the company setting adding a new user")
    public void theSuperAdminCanCompleteTheCompanySettingAddingANewUser() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the super admin can see the new user on the list")
    public void theSuperAdminCanSeeTheNewUserOnTheList() {
        //throw new io.cucumber.java.PendingException();

    }

    @Given("the lender is logged at Appmoto home page to send a request")
    public void theLenderIsLoggedAtAppmotoHomePageToSendARequest() {

        //throw new io.cucumber.java.PendingException();

    }

    @And("the lender sent a new relationship request to the dealer")
    public void theLenderSentANewRelationshipRequestToTheDealer() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the dealer open the request from the lender")
    public void theDealerOpenTheRequestFromTheLender() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer accept the new relationship request")
    public void theDealerAcceptTheNewRelationshipRequest() {
        //throw new io.cucumber.java.PendingException();
    }

    @Given("the dealer is logged at Appmoto home page to send a request")
    public void theDealerIsLoggedAtAppmotoHomePageToSendARequest() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer sent a new relationship request to the lender")
    public void theDealerSentANewRelationshipRequestToTheLender() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the lender open the request from the dealer")
    public void theLenderOpenTheRequestFromTheDealer() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the lender select the dealer branch and accept the new relationship")
    public void theLenderSelectTheDealerBranchAndAcceptTheNewRelationship() {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the lender I should see a successful message notification")
    public void theLenderIShouldSeeASuccessfulMessageNotification() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer I should see that a new relationship has been created")
    public void theDealerIShouldSeeThatANewRelationshipHasBeenCreated() {
        //throw new io.cucumber.java.PendingException();

    }

    @Given("a new user wants to create a company type {string}")
    public void aNewUserWantsToCreateACompanyType(String typeCompany) {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the new user selects the plan and fill out the company info")
    public void theNewUserSelectsThePlanAndFillOutTheCompanyInfo() {
        //throw new io.cucumber.java.PendingException();
    }

    @And("the new user completes the email confirmation")
    public void theNewUserCompletesTheEmailConfirmation() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the new user actives the company with new credentials")
    public void theNewUserActivesTheCompanyWithNewCredentials() {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the new user can log in at the Appmoto home page")
    public void theNewUserCanLogInAtTheAppmotoHomePage() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }


    @Given("I am successfully logged as Super User")
    public void iAmSuccessfullyLoggedAsSuperUser() {
        //throw new io.cucumber.java.PendingException();
    }

    @When("I search the {string} created and edit it")
    public void iSearchTheCreatedAndEditIt(String company) {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("I should have a new branch called {string}")
    public void iShouldHaveANewBranchCalled(String branchName) {
        //throw new io.cucumber.java.PendingException();

    }


    @When("the super admin submits all the coupon information")
    public void theSuperAdminSubmitsAllTheCouponInformation() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the super admin see that a new coupon has been created")
    public void theSuperAdminSeeThatAnNewCouponHasBeenCreated() {
        //throw new io.cucumber.java.PendingException();
        //Assert.fail("coupon not found");
    }

    @Given("the super admin has created a {int}% discount coupon")
    public void theSuperAdminHasCreatedADiscountCoupon(int arg0) {
        //throw new io.cucumber.java.PendingException();

    }

    @And("a new daler company and store are created")
    public void aNewDalerCompanyAndStoreAreCreated() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the store get additional credits to use integrations")
    public void theStoreGetAdditionalCreditsToUseIntegrations() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer applies the {int}%  discount coupon")
    public void theDealerAppliesTheDiscountCoupon(int arg0) {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the dealer can use the integrations functionalities")
    public void theDealerCanUseTheIntegrationsFunctionalities() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the dealer has created an application and try to get JDpower info")
    public void theDealerHasCreatedAnApplicationAndTryToGetJDpowerInfo() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the super admin active the JDpower option for the new company")
    public void theSuperAdminActiveTheJDpowerOptionForTheNewCompany() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the dealer store get additional credits to use integrations")
    public void theDealerStoreGetAdditionalCreditsToUseIntegrations() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the super admin makes the dealer's documentation available")
    public void theSuperAdminMakesTheDealerSDocumentationAvailable() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the dealer chooses the documents for the applicant")
    public void theDealerChoosesTheDocumentsForTheApplicant() {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the dealer see the E-sign Documents status as sent")
    public void theDealerSeeTheESignDocumentsStatusAsSent() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the applicant receives the Documents via email")
    public void theApplicantReceivesTheDocumentsViaEmail() {
    }

    @Given("the applicant has created a full application")
    public void theApplicantHasCreatedAFullApplication() {
        //throw new io.cucumber.java.PendingException();


    }



    @Then("the dealer should see a successful message notification")
    public void theDealerShouldSeeASuccessfulMessageNotification() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the super admin submits all the advertising information")
    public void theSuperAdminSubmitsAllTheAdvertisingInformation() {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the super admin see a successful message notification")
    public void theSuperAdminSeeASuccessfulMessageNotification() {
    }

    @And("the applicant should notice the advertising at the top of the page")
    public void theApplicantShouldNoticeTheAdvertisingAtTheTopOfThePage() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the super admin see that the advertising has been created")
    public void theSuperAdminSeeThatTheAdvertisingHasBeenCreated() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the lender open the request from the lender")
    public void theLenderOpenTheRequestFromTheLender() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the lender accept the new relationship request")
    public void theLenderAcceptTheNewRelationshipRequest() {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the lender should see a successful message notification")
    public void theLenderShouldSeeASuccessfulMessageNotification() {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the super admin submits all the blog post information")
    public void theSuperAdminSubmitsAllTheBlogPostInformation() {
        //throw new io.cucumber.java.PendingException();


    }

    @And("the super admin see that the blog post has been created")
    public void theSuperAdminSeeThatTheBlogPostHasBeenCreated() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the applicant should notice the blog post at the top of the page")
    public void theApplicantShouldNoticeTheBlogPostAtTheTopOfThePage() {
        //throw new io.cucumber.java.PendingException();

    }

    @Given("the user is on the Appmoto login page")
    public void theUserIsOnTheAppmotoLoginPage() {
        //throw new io.cucumber.java.PendingException();
    }

    @When("the user set up the {string} to recover the password")
    public void theUserSetUpTheToRecoverThePassword(String email) {
        //throw new io.cucumber.java.PendingException();
    }

    @And("the user receives the link to set up a new password")
    public void theUserReceivesTheLinkToSetUpANewPassword() {
        //throw new io.cucumber.java.PendingException();

    }

    @Then("the user can log in on the Appmoto home page with the new password")
    public void theUserCanLogInOnTheAppmotoHomePageWithTheNewPassword() {
        //throw new io.cucumber.java.PendingException();
    }


    @And("the new user can pay for plan selected")
    public void theNewUserCanPayForPlanSelected() throws InterruptedException {
        //throw new io.cucumber.java.PendingException();

    }

    @When("the super admin submits all new user information")
    public void theSuperAdminSubmitsAllNewUserInformation() {
        //throw new io.cucumber.java.PendingException();

    }

    @And("the super admin see that a new user has been created")
    public void theSuperAdminSeeThatANewUserHasBeenCreated() {
        //throw new io.cucumber.java.PendingException();

    }
}