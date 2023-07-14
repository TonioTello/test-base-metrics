package starter.pages.companies;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import starter.utils.WebAction;

import java.time.Duration;

public class PlanPage {
    private WebDriver driver;

    private By typeCompanyInput = By.id("profile_companyTypeId");
    private By lenderOption = By.xpath("//*[contains(@title,'Lender')]");
    private By dealerOption = By.xpath("//*[contains(@title,'Dealer')]");

    //private By choosePlanBtn = By.xpath("//*[contains(text(),' this plan')]");
    //private By choosePlanBtn = By.xpath("(//*[preceding::*[contains(text(),'QA-NMI Prod-Renew Dealer Type')]])[3]");
    private By choosePlanBtnDealerQA = By.xpath("(//*[preceding::*[contains(text(),'Dealer Type')]])[3]");
    private By choosePlanBtnLenderQA = By.xpath("(//*[preceding::*[contains(text(),'Lender Type')]])[3]");
    private By choosePlanBtnDealerUAT = By.xpath("(//*[preceding::*[contains(text(),'Dealer Plan Type')]])[3]");
    private By choosePlanBtnDealerDEV = By.xpath("(//*[preceding::*[contains(text(),'Dealer Plan Type')]])[3]");
    private By choosePlanBtnLenderUAT = By.xpath("(//*[preceding::*[contains(text(),'Lender Plan Type')]])[3]");
    private By nextStepBtn = By.xpath("//*[contains(text(),'Next Step')]");
    private By nameCompanyInput = By.id("secondStep_name");
    private By legalNameInput = By.id("secondStep_legalName");
    private By accountingContactNameInput = By.id("secondStep_accountingContactName");
    private By emailInput = By.id("secondStep_email");
    private By phoneNumberInput = By.id("secondStep_phoneNumber");
    private By businessAddressInput = By.id("secondStep_businessAddress");
    private By businessAddress2Input = By.id("secondStep_businessAddressLine2");
    private By zipCodeInput = By.id("secondStep_zipCode");
    private By countryInput = By.id("secondStep_countyCode");
    private By cityInput = By.id("secondStep_city");
    //private By stateInput = By.xpath("(//input[preceding::input[@name=\"secondStep.city\"]])[1]");
    private By stateInput = By.id("rc_select_0");
    private By stateNCInput = By.xpath("//*[@title=\"NC\"]");   //Todo data "Quemada"


    private By userFirstNameInput = By.id("secondStep_userInfo_firstName");
    private By userLastNameInput = By.id("secondStep_userInfo_lastName");
    private By userEmailInput = By.id("secondStep_userInfo_email");
    private By userPhoneNumberInput = By.id("secondStep_userInfo_phoneNumber");

    private By acceptElectronicSignatureCheckbox = By.xpath("(//*[@type=\"checkbox\"])[1]");
    private By haveReadAgreeCheckbox = By.xpath("(//*[@type=\"checkbox\"])[2]");
    private By acceptOTTOMOTOCheckbox = By.xpath("(//*[@type=\"checkbox\"])[3]");


    private By submitBtn = By.xpath("//*[@type=\"button\" and contains(text(), 'Submit')]");
    private By verificationCodeInput = By.id("one-time-code");
    private By verificationCodeInput0 = By.xpath("//*[contains(@data-cy,\"verification-code-0-item\")]");
    private By verificationCodeInput1 = By.xpath("//*[contains(@data-cy,\"verification-code-1-item\")]");
    private By verificationCodeInput2 = By.xpath("//*[contains(@data-cy,\"verification-code-2-item\")]");
    private By verificationCodeInput3 = By.xpath("//*[contains(@data-cy,\"verification-code-3-item\")]");
    private By validateBtn = By.xpath("//button[contains(text(),'Validate')]");
    private By notificationSuccessValidated = By.xpath("//*[contains(text(),'We have successfully validated your company')]");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("confirm");
    private By savePasswordBtn = By.xpath("//*[contains(text(),'Save new password')]");
    private By termsOfUseAgreementBtn = By.id("termsOfUseAgreement");
    private By refreshBtn = By.xpath("//*[contains(text(), 'Refresh')]");

    private By checkAppFound = By.xpath("//*[contains(text(),'Total records 1')]");



    public PlanPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setNameCompanyInput(String nameCompany) {
        driver.findElement(nameCompanyInput).sendKeys(nameCompany);
    }

    public void setLegalNameInput(String legalName) {
        driver.findElement(legalNameInput).sendKeys(legalName);
    }

    public void setAccountingContactNameInput(String accountingContactName) {
        driver.findElement(accountingContactNameInput).sendKeys(accountingContactName);
    }

    public void setEmailInput(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPhoneNumberInput(String phoneNumber) {
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public void setBusinessAddressInput(String businessAddress) {
        driver.findElement(businessAddressInput).sendKeys(businessAddress);
    }

    public void setBusinessAddress2Input(String businessAddress) {
        driver.findElement(businessAddress2Input).sendKeys(businessAddress);
    }

    public void setZipCodeInput(String zipCode) throws InterruptedException {
        driver.findElement(zipCodeInput).sendKeys(zipCode);
        Thread.sleep(800);
        driver.findElement(zipCodeInput).sendKeys(Keys.ENTER);
    }

    public void setCountryInput(String city) {
        driver.findElement(countryInput).sendKeys(city);
    }

    public void setCityInput(String city) {
        driver.findElement(cityInput).sendKeys(city);
    }

    public void setStateInput(String state) throws InterruptedException {
        driver.findElement(stateInput).sendKeys(state);
        Thread.sleep(1000);
        driver.findElement(stateNCInput).click();

    }

    public void submitCompany() throws InterruptedException {
        Thread.sleep(1000); //Todo Delete cos Zipcode
        driver.findElement(submitBtn).click();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(deleteRelationshipBtn)));
    }


    public void setUserFirstNameInput(String userFirstName) {
        driver.findElement(userFirstNameInput).sendKeys(userFirstName);
    }

    public void setUserLastNameInput(String userLastName ){
        driver.findElement(userLastNameInput).sendKeys(userLastName);
    }

    public void setUserEmailInput( String userEmail) {
        driver.findElement(userEmailInput).sendKeys(userEmail);
    }

    public void setUserPhoneNumberInput( String userPhoneNumber) {
        driver.findElement(userPhoneNumberInput).sendKeys(userPhoneNumber);
    }

    public void setAcceptElectronicSignatureCheckbox() {
        driver.findElement(acceptElectronicSignatureCheckbox).click();
    }

    public void setHaveReadAgreeCheckbox( ) {
        driver.findElement(haveReadAgreeCheckbox).click();
    }

    public void setIAcceptOTTOMOTOCheckbox() {
        driver.findElement(acceptOTTOMOTOCheckbox).click();
    }

    public void clickOnChoosePlanDealer(String environment) {
        if (environment.equalsIgnoreCase("qa")){
            driver.findElement(choosePlanBtnDealerQA).click();
        } else if (environment.equalsIgnoreCase("uat")) {
            driver.findElement(choosePlanBtnDealerUAT).click();
        } else if (environment.equalsIgnoreCase("dev")) {
            driver.findElement(choosePlanBtnDealerDEV).click();
        }else {
            driver.findElement(choosePlanBtnDealerUAT).click();
        }
    }

    public void clickOnChoosePlanLender(String environment) {
        if (environment.equalsIgnoreCase("qa")){
            driver.findElement(choosePlanBtnLenderQA).click();
        } else if (environment.equalsIgnoreCase("uat")) {
            driver.findElement(choosePlanBtnLenderUAT).click();
        }else {
            driver.findElement(choosePlanBtnLenderUAT).click();
        }
    }

    public void clinkOnNextStep() {
        WebAction webAction= new WebAction(driver);
        webAction.waitToBeClickable(driver, nextStepBtn);
        driver.findElement(nextStepBtn).click();
    }

    public void setVerificationCode(String verificationCode) throws InterruptedException {
        driver.findElement(verificationCodeInput).sendKeys("0"+verificationCode);
    }

    public void clickOnValidate() {
        driver.findElement(validateBtn).click();
    }

    public boolean validateNotificationSuccessCompanyValidated() {
       return driver.findElement(notificationSuccessValidated).isDisplayed();
    }

    public void setNewPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        driver.findElement(confirmPasswordInput).sendKeys(password);
    }

    public void clickOnSavePassword() {
        driver.findElement(savePasswordBtn).click();
    }

    public void setTermsOfUseAgreement() {
        driver.findElement(termsOfUseAgreementBtn).click();
    }

    public void closeNewUpdatePopup() {
        try {
            WebAction webAction = new WebAction(driver);
            webAction.waitVisibilityOf(driver, refreshBtn);
            Thread.sleep(3000);
        } catch (Exception e) {

        }
    }


}
