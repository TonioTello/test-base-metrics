package starter.pages.applications;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import starter.utils.WebAction;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NewAppPage {

    private WebDriver driver;

    private By numberOfLenderInput = By.id("applicantApplicationInformation_lendersNumber");
    private By numberOfDealerInput = By.id("applicantApplicationInformation_dealersNumber");
    private By setNumberOfLender = By.xpath("(//*[@title='1'][preceding::*[@id=\"applicantApplicationInformation_dealersNumber\"]])[1]"); //Todo
    private By setNumberOfDealer = By.xpath("(//*[@title='1'][preceding::*[@id=\"applicantApplicationInformation_dealersNumber\"]])[2]"); //Todo
    private By selectLenderAvailable = By.xpath("//*[@id=\"lenderAvailable\"]//span//input");
    private By searchLender = By.xpath("//*[@placeholder=\"Search by lenders\"]");
    private By companyIdInput = By.id("companyId");
    private By branchIdInput = By.id("branchId");
    private By branchIdInput2 = By.xpath("(//*[@id=\"branchId\"])[2]");
    private By officeIdInput = By.id("officeId");
    private By firstNameInput = By.id("applicant_firstName");
    //private By lastNameInput = By.id("applicant_lastName");  // Todo Retake
    private By lastNameInput = By.xpath("(//*[@id=\"applicant_suffix\"]//preceding::input)[last()]");
    //private By lastNameInput = By.xpath("(//*[@id=\"applicant_lastName\"])[2]");
    //private By dateOfBirthInput_ = By.id("mui-19"); //Todo
    //private By dateOfBirthInput_ = By.xpath("//*[@id=\"mui-19\" or @id=\"mui-13\"]");
    private By dateOfBirthInput_ = By.xpath("(//input[@id=\"applicant_socialSecurity\"]//preceding::input)[last()]");
    private By dateOfBirthYearInput_ = By.xpath("//button[contains(text(),'2000')]");
    private By dateOfBirthMonthInput_ = By.xpath("//button[contains(text(),'Feb')]");
    private By dateOfBirthDayInput_ = By.xpath("(//button[contains(text(),'7')])[1]");
    private By okButton = By.xpath("//button[contains(text(),'OK')]");

    private By dateOfBirthInput = By.id("applicant_dateOfBirth");
    private By socialSecurityInput = By.id("applicant_socialSecurity");
    private By driversLicenseStateInput = By.id("applicant_driversLicenseStateId");
    private By zipCodeInput = By.id("applicant_zipCode");

    private By submitBtn = By.xpath("//*[@type=\"submit\"]");
    private By requiredAlert = By.xpath("//*[@role=\"alert\"][contains(text(),'required')]");
    private By submitBtn2 = By.xpath("//*[contains(text(),'Submit')]");
    private By submitConfirmButton = By.xpath("//*[contains(text(),'Cancel')]//following::button");
    private By continueButton = By.xpath("//*[contains(text(),'Continue')]");
    private By submitRequestButton = By.xpath("//*[contains(text(),'Cancel')]//following::span");
    private By submitBtn3 = By.xpath("//*[contains(text(),'Submit')][preceding::*[contains(text(),'Cancel')]]");
    //private By submitBtn3 = By.xpath("//*[contains(text(),\"Cancel\")]//following::*[contains(text(),\"Submit\")]");

    private By updateBtn = By.xpath("//*[contains(text(), 'Update')]");
    private By totalLabel = By.xpath("//*[contains(text(), 'Total records')]");
    private By emailInput = By.id("applicant_email");
    private By emailOttoVerify = By.id("email");
    private By phoneNumberInput = By.id("applicant_phoneNumber");
    private By homeAddressInput = By.id("applicant_homeAddress");
    private By incomeApplicantInput = By.id("applicant_incomeApplicant_grossIncome");
    private By loanItem = By.xpath("//span[contains(@title,'Loan')]");
    private By leaseItem = By.xpath("//*[contains(@title,'Lease')]");
    private By tradeInVinInput = By.id("tradeIn_vin");
    private By textMessageInput = By.xpath("(//*[@id=\"messages_section\"]//textarea)[1]");
    private By termsConditionsOption = By.id("termsConditionsApplication_accept");
    private By termsOfUseOption = By.id("termsConditionsApplication_acceptTermsOfUse");

    private By dateToday = By.xpath("//a[contains(text(), 'Today')]");
    private By vehicleInformationInput = By.xpath("//*[@id=\"vehicleInformation_vin\" or @id=\"vehicleInformation_vehicle_vin\"]");
    //private By vehicleInformationInput = By.id("vehicleInformation_vehicle_vin");
    //private By vehicleInformationInput = By.id("vehicleInformation_vin");


    // Other fields to complete full applications
    private By middleNameInput = By.id("applicant_middleName");
    private By suffixInput = By.id("applicant_suffix");
    private By driversLicenseInput = By.id("applicant_driversLicense");
    //private By licenseExpirationInput = By.id("mui-20");
    //private By licenseExpirationInput = By.xpath("//*[@id=\"mui-20\" or @id=\"mui-14\"]");
    private By licenseExpirationInput = By.xpath("(//input[@id=\"applicant_driversLicenseStateId\"]//following::input)[1]");
    private By secundaryEmailInput = By.id("applicant_secundaryEmail");
    private By secundaryPhoneNumberInput = By.id("applicant_secundaryPhoneNumber");
    private By homeAddressAppInput = By.id("applicant_homeAddress");
    private By homeAddressLine2Input = By.id("applicant_homeAddressLine2");
    private By yearsAtAddressInput = By.id("applicant_yearsAtAddress");
    private By monthsAtAddressInput = By.id("applicant_monthsAtAddress");
    private By housingStatusIdInput = By.id("applicant_housingStatusId");
    private By landlordOrMTGHolderInput = By.id("applicant_landlordOrMTGHolder");
    private By monthlyPaymentInput = By.id("applicant_monthlyPayment");
    private By incomeEmployerNameInput = By.id("applicant_incomeApplicant_employerName");
    private By incomeWorkPhoneNumberInput = By.id("applicant_incomeApplicant_workPhoneNumber");
    private By incomeExtInput = By.id("applicant_incomeApplicant_ext");
    private By incomeHomeAddressInput = By.id("applicant_incomeApplicant_homeAddress");
    private By incomeHomeAddressLine2Input = By.id("applicant_incomeApplicant_homeAddressLine2");
    private By incomeHomeSuiteNumberInput = By.id("applicant_incomeApplicant_homeSuiteNumber");
    private By incomeZipCodeInput = By.id("applicant_incomeApplicant_zipCode");
    private By incomeSupervisorNameInput = By.id("applicant_incomeApplicant_supervisorName");
    private By incomeApplicant_employmentStatusIdInput = By.id("applicant_incomeApplicant_employmentStatusId");
    private By incomeApplicant_yearsAtJobInput = By.id("applicant_incomeApplicant_yearsAtJob");
    private By incomePositionDepartmentInput = By.id("applicant_incomeApplicant_positionDepartment");
    private By incomeYearsAtJobInput = By.id("applicant_incomeApplicant_yearsAtJob");
    private By incomeMonthsAtJobInput = By.id("applicant_incomeApplicant_monthsAtJob");
    private By incomeApplicantFrequencyIdInput = By.id("applicant_incomeApplicant_frequencyId");
    //private By dateInput = By.id("mui-21");
    //private By dateInput = By.xpath("//*[@id=\"mui-21\" or @id=\"mui-15\"]");
    private By dateInput = By.xpath("((//input[@id=\"applicant_incomeApplicant_frequencyId\"]//following::input)[not(@type=\"radio\" or @type=\"checkbox\")])[1]");

    private By loanCashPriceInput = By.id("loanPayment_cashPrice");
    private By leaseCashPriceInput = By.id("leasePayment_cashPrice");


    //Vehicle Information
    private By vehicleInfoBodyStyleOrTrimInput = By.xpath("//*[@id=\"vehicleInformation_bodyStyleOrTrim\" or @id=\"vehicleInformation_vehicle_bodyStyleOrTrim\"]");
    // private By vehicleInfoBodyStyleOrTrimInput = By.id("vehicleInformation_bodyStyleOrTrim");
    private By tradeInfoColorInput = By.xpath("(//*[@id=\"tradeIn_miles\"]//following::input)[1]");
    private By vehicleInfoVinInput = By.xpath("//*[@id=\"vehicleInformation_vin\" or @id=\"vehicleInformation_vehicle_vin\"]");
    //private By vehicleInfoVinInput = By.id("vehicleInformation_vin");
    private By vehicleInfoColorInput = By.xpath("(//*[@id=\"vehicleInformation_vehicle_miles\"]//preceding::input)[last()]");
    private By vehicleInfoMilesInput = By.xpath("//*[@id=\"vehicleInformation_miles\" or @id=\"vehicleInformation_vehicle_miles\"]");
    //private By vehicleInfoMilesInput = By.id("vehicleInformation_miles");
    private By vehicleInfoGvwInput = By.xpath("//*[@id=\"vehicleInformation_gvw\" or @id=\"vehicleInformation_vehicle_gvw\"]");
    //private By vehicleInfoGvwInput = By.id("vehicleInformation_gvw");
    private By vehicleInfoGvwrInput = By.xpath("//*[@id=\"vehicleInformation_gvwr\" or @id=\"vehicleInformation_vehicle_gvwr\"]");
    //private By vehicleInfoGvwrInput = By.id("vehicleInformation_gvwr");

    //private By vehicleInfoMsrpInput = By.id("vehicleInformation_msrp");
    private By vehicleInfoMsrpInput = By.xpath("//*[@id=\"vehicleInformation_msrp\" or @id=\"vehicleInformation_vehicle_msrp\"]");
    private By vehicle_wholeSaleInput = By.xpath("//*[@id=\"vehicleInformation_vehicle_wholeSale\" or @id=\"vehicleInformation_vehicle_wholeSale\"]");
    //private By vehicleInfoWeightInput = By.id("vehicleInformation_weight");
    private By vehicleInfoWeightInput = By.xpath("//*[@id=\"vehicleInformation_weight\" or @id=\"vehicleInformation_vehicle_weight\"]");
    //private By vehicleInfoIsComercialVehicleInput = By.id("vehicleInformation_isComercialVehicle");
    private By vehicleInfoIsComercialVehicleInput = By.xpath("//*[@id=\"vehicleInformation_isComercialVehicle\" or @id=\"vehicleInformation_vehicle_isComercialVehicle\" or @id=\"vehicleInformation_vehicle_commercial_vehicle\"]");
    //private By vehicleInfoIsNewInput = By.id("vehicleInformation_isNew");
    private By vehicleInfoIsNewInput = By.xpath("//*[@id=\"vehicleInformation_isNew\" or @id=\"vehicleInformation_vehicle_isNew\" or @id=\"vehicleInformation_vehicle_new_vehicle\"]");
    private By vehicleInfoNotesInput = By.xpath("//*[@id=\"vehicleInformation_vehicle_equipmentAddsNotes\"]");
    private By tradeInBodyStyleOrTrimInput = By.id("tradeIn_bodyStyleOrTrim");
    private By tradeInMilesInput = By.id("tradeIn_miles");

    // Calculator
    private By jDPowerButton = By.xpath("//*[contains(text(),'Pull vehicle info')]");
    private By calculateDTIButton = By.xpath("//*[contains(text(),'Calculate DTI' )]");
    private By requestButton = By.xpath("//*[contains(text(),'Request' )]");
    private By DTI_Input = By.id("DTI");
    private By PTI_Input = By.id("PTI");
    private By LTVTradeIn_Input = By.id("LTVTradeIn");
    private By LTVWithoutProducts_Input = By.id("LTVWithoutProducts");
    private By LTVRetail_Input = By.id("LTVRetail");
    private By LTVWithoutProductsRetail_Input = By.id("LTVWithoutProductsRetail");

    // Send application unregistered applicant
    private By sendApplicationBton = By.xpath("//*[contains(text(),'Send Application') or contains(text(),'Send application') or contains(text(),'Send Credit Application')]");
    private By oKButton = By.xpath("//*[contains(text(),'OK') or contains(text(),'Ok')]");
    private By nextButton = By.xpath("//*[contains(text(),'Next')]");
    private By applicantFirstNameInput = By.id("applicantName");
    private By applicantPhoneNumberInput = By.id("cellPhoneNumber");
    private By applicantemailInput = By.id("email");
    private By successNotification = By.xpath("//*[contains(text(), 'successfully')]");

    private By verificationCodeInput = By.id("one-time-code");
    private By validateBtn = By.xpath("//button[contains(text(),'Verify Code') or contains(text(),'Validate')]");

    private By checkAppFound = By.xpath("//*[contains(text(),'Total records 1')]");
    private By pullVehicleInfoBton = By.xpath("//*[contains(text(),'Pull vehicle info')]");
    private By jdPowerValues = By.xpath("//td[contains(text(),'Value')]//following::td");
    private By jdPowerOptions = By.xpath("//*[@role=\"tabpanel\"]//descendant::input[@type=\"checkbox\"]");
    private By jdPowerOptions2 = By.xpath("//*[@role=\"tabpanel\"]//descendant::input[@type=\"checkbox\"]//following-sibling::span");
    private By jdPowerOptionTag = By.xpath("//*[contains(text(),'Options')]");
    private By jdPowerTrimLevelTag = By.xpath("//*[contains(text(),'Trim Levels')]");
    private By jdPowerTrimLevels = By.xpath("//*[@role=\"tabpanel\"]//descendant::input[@type=\"radio\"]");
    private By spinIcons = By.xpath("//*[@class=\"ant-spin-dot-item\"]");
    private By oTTOinspectorButton = By.xpath("//*[contains(text(),'OTTOinspector')]");
    private By oTTOverifyButton = By.xpath("//*[contains(text(),'OTTOverify')]");
    private By ottoInsureButton = By.xpath("(//*[contains(text(),\"OTTOinsure\")])[1]");
    private By dealerPhoneUS = By.id("fromPhone");
    private By fromPhoneUS = By.id("fromPhone");
    private By toPhoneUS = By.id("toPhone");
    private By sendRequestButton = By.xpath("//*[contains(text(),'Send Request')]");


    // Vehicle Information
    private By passengerVehicle = By.id("PASSENGER_VEHICLE_ITEM");
    private By recreationalVehicles = By.id("RECREATIONAL_VEHICLES_ITEM");
    private By aircraftVehicle = By.id("AIRCRAFT_ITEM");
    private By boatVehicle = By.id("BOAT_ITEM");

    private By vehicleInformation_vehicle_makeInput = By.id("vehicleInformation_vehicle_make");
    private By vehicleInformation_vehicle_modelNameInput = By.id("vehicleInformation_vehicle_modelName");
    private By vehicleInformation_vehicle_numberOfSlideOutsInput = By.id("vehicleInformation_vehicle_numberOfSlideOuts");
    private By vehicleInformation_vehicle_useInput = By.id("vehicleInformation_vehicle_use");
    private By vehicleInformation_vehicle_typeOfLoanInput = By.id("vehicleInformation_vehicle_typeOfLoan");
    private By vehicleInformation_vehicle_typeOfRvInput = By.id("vehicleInformation_vehicle_typeOfRv");
    private By vehicleInformation_vehicle_dateInput = By.xpath("(//*[@id=\"vehicleInformation_vehicle_typeOfRv\"]//following::input)[1]");

    private By dateYearInput = By.xpath("//button[contains(text(),'2022')]");

    private By vehicleInformation_vehicle_dateYearInput = By.xpath("//button[contains(text(),'2022')]");

    private By vehicleInformation_vehicle_lengthInput = By.id("vehicleInformation_vehicle_length");
    private By vehicleInformation_vehicle_milesInput = By.id("vehicleInformation_vehicle_miles");
    private By vehicleInformation_vehicle_colorInput = By.id("vehicleInformation_vehicle_color");
    private By vehicleInformation_vehicle_bodyInput = By.id("vehicleInformation_vehicle_body");
    private By vehicleInformation_vehicle_notesOptionsInput = By.id("vehicleInformation_vehicle_notesOptions");
    //**********Aircraft***************//
    private By vehicleInformation_vehicle_modelInput = By.id("vehicleInformation_vehicle_model");
    private By vehicleInformation_Aircraft_dateInput = By.xpath("(//*[@id=\"vehicleInformation_vehicle_model\"]//following::input)[1]");

    private By vehicleInformation_Aircraft_dateYearInput_ = By.xpath("//button[contains(text(),'2022')]");
    private By vehicleInformation_vehicle_faanInput = By.id("vehicleInformation_vehicle_faan");
    private By vehicleInformation_vehicle_snInput = By.id("vehicleInformation_vehicle_sn");
    private By vehicleInformation_Aircraft_lastAnnualDateInput = By.xpath("(//*[@id=\"vehicleInformation_vehicle_sn\"]//following::input)[1]");
    private By vehicleInformation_Aircraft_ttafInput = By.id("vehicleInformation_vehicle_ttaf");
    private By vehicleInformation_Aircraft_reSmohInput = By.id("vehicleInformation_vehicle_reSmoh");
    private By vehicleInformation_vehicle_leSmohInput = By.id("vehicleInformation_vehicle_leSmoh");
    private By vehicleInformation_Aircraft_closingDateInput = By.xpath("(//*[@id=\"vehicleInformation_vehicle_leSmoh\"]//following::input)[1]");
    private By vehicleInformation_vehicle_sellerNameInput = By.id("vehicleInformation_vehicle_sellerName");
    private By vehicleInformation_vehicle_sellerPhonenumberInput = By.id("vehicleInformation_vehicle_sellerPhonenumber");
    private By vehicleInformation_vehicle_currentAircraftInput = By.id("vehicleInformation_vehicle_currentAircraft");
    private By vehicleInformation_vehicle_financedByInput = By.id("vehicleInformation_vehicle_financedBy");
    private By vehicleInformation_vehicle_typeOfPilotCertificateOptsInput = By.id("vehicleInformation_vehicle_typeOfPilotCertificateOpts");
    private By vehicleInformation_vehicle_currentHrsInput = By.id("vehicleInformation_vehicle_currentHrs");
    private By vehicleInformation_vehicle_ratingsInput = By.id("vehicleInformation_vehicle_ratings");
    private By vehicleInformation_Aircraft_endorsementsInput = By.id("vehicleInformation_vehicle_endorsements");
    private By vehicleInformation_Aircraft_aircraftExperienceInput = By.xpath("(//*[@id=\"vehicleInformation_vehicle_endorsements\"]//following::span)[1]");
    private By vehicleInformation_vehicle_aircraftWillBaseInput = By.id("vehicleInformation_vehicle_aircraftWillBase");
    private By vehicleInformation_vehicle_howAircraftUtilizedInput = By.id("vehicleInformation_vehicle_howAircraftUtilized");
    private By vehicleInformation_vehicle_detailsInput = By.id("vehicleInformation_vehicle_details");
    private By vehicleInformation_vehicle_previousExperienceInput = By.xpath("//*[@id=\"vehicleInformation_vehicle_previousExperience\"]//child::span[contains(text(),'Yes')]");
    //************Boat***************//
    private By vehicleInformation_boat_dateInput = By.xpath("(//*[@id=\"vehicleInformation_vehicle_model\"]//following::input)[1]");

    private By vehicleInformation_vehicle_boat_lengthInput = By.id("vehicleInformation_vehicle_length");
    private By vehicleInformation_vehicle_titleNumberInput = By.id("vehicleInformation_vehicle_titleNumber");
    private By vehicleInformation_vehicle_hullTypeInput = By.id("vehicleInformation_vehicle_hullType");
    private By vehicleInformation_vehicle_hullIdNumberInput = By.id("vehicleInformation_vehicle_hullIdNumber");
    private By vehicleInformation_vehicle_populsionTypeInput = By.id("vehicleInformation_vehicle_populsionType");
    private By vehicleInformation_vehicle_registrationNumberInput = By.id("vehicleInformation_vehicle_registrationNumber");
    private By vehicleInformation_vehicle_stateRegisteredInput = By.id("vehicleInformation_vehicle_stateRegistered");
    private By vehicleInformation_vehicle_hoursInput = By.id("vehicleInformation_vehicle_hours");
    private By vehicleInformation_vehicle_boatValueInput = By.id("vehicleInformation_vehicle_boatValue");
    private By vehicleInformation_vehicle_outboardMotorValueInput = By.id("vehicleInformation_vehicle_outboardMotorValue");
    private By vehicleInformation_vehicle_notesInput = By.id("vehicleInformation_vehicle_notes");

    //*** OttoInsure
    private By ottoInsureEmailInput = By.id("primaryEmail");
    private By ottoInsurePhoneInput = By.id("primaryPhone");

    //700Credit
    private By routeOneCompanyOption = By.xpath("//*[contains(@alt,'Route')]");
    private By cudlCompanyOption = By.xpath("//*[contains(@alt,'CUDL')]");
    private By dealertrackCompanyOption = By.xpath("//*[contains(@alt,'Dealertrack')]");
    private By appOneCompanyOption = By.xpath("//*[contains(@alt,'App One')]");
    private By signDocumentsBtn = By.xpath("//button[contains(text(),'Sign Documents')]");
    private By lastDocument = By.xpath("(//input[@type=\"checkbox\"])[last()]");
    private By signDocumentButton = By.xpath("//span[contains(text(),'Sign Document')]");
    private By coapplicantEmailInput = By.id("coapplicantEmail");


    public NewAppPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setNumberOfLenderInput(int value) throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        driver.findElement(numberOfLenderInput).click();
        webAction.waitToBeClickable(driver, setNumberOfLender);
        driver.findElement(setNumberOfLender).click();

    }

    public void setNumberOfDeaderInput(int value) throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        driver.findElement(numberOfDealerInput).click();
        webAction.waitToBeClickable(driver, setNumberOfDealer);
        driver.findElement(setNumberOfDealer).click();
    }

    public void selectLender(String lender) throws InterruptedException {
        Thread.sleep(1000);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 0)");

        driver.findElement(searchLender).sendKeys(lender);
        Thread.sleep(3000);
        driver.findElement(selectLenderAvailable).click();
    }

    public void setCompanyInput() {
        driver.findElement(companyIdInput).click();
    }

    public void setBranchInput() {
        driver.findElement(branchIdInput).click();
    }

    public void setOfficeInput() {
        driver.findElement(officeIdInput).click();
    }

    public void setFirstNameInput(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void setLastNameInput(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }


    public void setDateOfBirthInput(String dateOfBirth) throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(dateOfBirthInput_).click();
        Thread.sleep(1000);
        driver.findElement(dateOfBirthYearInput_).click();
        Thread.sleep(1000);
        driver.findElement(dateOfBirthMonthInput_).click();
        Thread.sleep(1000);
        driver.findElement(dateOfBirthDayInput_).click();
        Thread.sleep(1000);
        try {
            String sSistemaOperativo = System.getProperty("os.name");
            if (sSistemaOperativo.contains("Windows")) {

            } else {
                driver.findElement(okButton).click();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
        }
    }


    public void setSocialSecurityInput(String socialSecurityNumber) {
        driver.findElement(socialSecurityInput).sendKeys(socialSecurityNumber);
    }


    public void setState(String state) {
        driver.findElement(driversLicenseStateInput).sendKeys(state);
        driver.findElement(driversLicenseStateInput).sendKeys(Keys.ENTER);
    }

    public void setZipCodeInput(String zipCode) throws InterruptedException {
        driver.findElement(zipCodeInput).clear();
        driver.findElement(zipCodeInput).sendKeys(zipCode);
        Thread.sleep(700);
        driver.findElement(zipCodeInput).sendKeys(Keys.ENTER);
        //driver.findElement(zipCodeSearchIcon).click();
    }


    public void setIncomeApplicantInput(String incomeApplicant) {
        driver.findElement(incomeApplicantInput).clear();
        driver.findElement(incomeApplicantInput).sendKeys(incomeApplicant);
    }


    public void setTradeInVinInput(String tradeInVin) throws InterruptedException {
        driver.findElement(tradeInVinInput).clear();
        driver.findElement(tradeInVinInput).sendKeys(tradeInVin);
        Thread.sleep(1000);
        driver.findElement(tradeInVinInput).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    public void clickTradeInVinInput() throws InterruptedException {
        driver.findElement(tradeInVinInput).click();
    }

    public void moveToJDpowerSession() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(pullVehicleInfoBton)).perform();
    }

    public void moveToVehiclesInfo() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)", "");

    }


    public void setTermsConditionsOption() {
        driver.findElement(termsConditionsOption).click();
    }

    public void setTermsOfUseOption() {
        driver.findElement(termsOfUseOption).click();
    }

    public void submitApplication() throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, submitBtn);
        Thread.sleep(2000);
        webAction.highlightElement(driver.findElement(submitBtn));
        driver.findElement(submitBtn).click();
        Thread.sleep(2000);
    }

    public boolean validateAppSubmitted() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, totalLabel);
        return true;
    }

    public void setEmailInput(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPhoneInput(String phone) {
        driver.findElement(phoneNumberInput).clear();
        driver.findElement(phoneNumberInput).sendKeys(phone);
    }

    public void setHomeAddressInput(String homeAddress) {
        driver.findElement(homeAddressInput).clear();
        driver.findElement(homeAddressInput).sendKeys(homeAddress);
    }

    public void setTypeApplicantInput(String typeApplication) {
        if (typeApplication.equalsIgnoreCase("Lease")) {
            driver.findElement(loanItem).click();
            driver.findElement(leaseItem).click();
        } else {
            driver.findElement(loanItem).click();
            driver.findElement(loanItem).click();
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 0)");
    }

    public void setVinInfoInput(String vinInformation) {

        if (driver.findElement(vehicleInformationInput).getText().equalsIgnoreCase("")) {
            driver.findElement(vehicleInformationInput).clear();
            driver.findElement(vehicleInformationInput).sendKeys(vinInformation);
            driver.findElement(vehicleInformationInput).sendKeys(Keys.ENTER);
        }

    }

    public void updateApplication() throws InterruptedException {
        driver.findElement(updateBtn).click();
        Thread.sleep(2000);
    }

    // Others fields for full application
    public String getMiddleNameInput() {
        return driver.findElement(middleNameInput).getAttribute("value");
    }

    public void setMiddleNameInput(String middleName) {
        driver.findElement(middleNameInput).clear();
        driver.findElement(middleNameInput).sendKeys(middleName);
    }

    public String getSuffixInput() {
        return driver.findElement(middleNameInput).getAttribute("value");
    }

    public void setSuffixInput(String suffix) {
        driver.findElement(suffixInput).clear();
        driver.findElement(suffixInput).sendKeys(suffix);
    }

    public String getDriversLicenseInput() {
        return "driversLicenseInput";
    }

    public void setDriversLicenseInput(String driversLicense) {
        driver.findElement(driversLicenseInput).clear();
        driver.findElement(driversLicenseInput).sendKeys(driversLicense);
    }

    public String getLicenseExpirationInput() {
        return driver.findElement(middleNameInput).getAttribute("value");
    }

    public void setLicenseExpirationInput(String licenseExpiration) {
        driver.findElement(licenseExpirationInput).sendKeys(licenseExpiration);
    }

    public String getSecundaryEmailInput() {
        return driver.findElement(secundaryEmailInput).getAttribute("value");
    }

    public void setSecundaryEmailInput(String secundaryEmail) {
        driver.findElement(secundaryEmailInput).clear();
        driver.findElement(secundaryEmailInput).sendKeys(secundaryEmail);
    }

    public String getSecundaryPhoneNumberInput() {
        return driver.findElement(secundaryPhoneNumberInput).getAttribute("value");
    }

    public void setSecundaryPhoneNumberInput(String secundaryPhoneNumber) {
        driver.findElement(secundaryPhoneNumberInput).clear();
        driver.findElement(secundaryPhoneNumberInput).sendKeys(secundaryPhoneNumber);
    }

    public String getHomeAddressAppInput() {
        return driver.findElement(homeAddressAppInput).getAttribute("value");
    }

    public void setHomeAddressAppInput(String homeAddressApp) {
        driver.findElement(homeAddressAppInput).clear();
        driver.findElement(homeAddressAppInput).sendKeys(homeAddressApp);
    }

    public String getHomeAddressLine2Input() {
        return driver.findElement(homeAddressLine2Input).getAttribute("value");
    }

    public void setHomeAddressLine2Input(String homeAddressLine2) {
        driver.findElement(homeAddressLine2Input).clear();
        driver.findElement(homeAddressLine2Input).sendKeys(homeAddressLine2);
    }

    public String getYearsAtAddressInput() {
        return driver.findElement(yearsAtAddressInput).getAttribute("value");

    }

    public void setYearsAtAddressInput(String yearsAtAddress) {
        driver.findElement(yearsAtAddressInput).clear();
        driver.findElement(yearsAtAddressInput).sendKeys(yearsAtAddress);
    }

    public String getMonthsAtAddressInput() {
        return driver.findElement(middleNameInput).getAttribute("value");
    }

    public void setMonthsAtAddressInput(String monthsAtAddress) {
        driver.findElement(monthsAtAddressInput).clear();
        driver.findElement(monthsAtAddressInput).sendKeys(monthsAtAddress);
    }

    public String getMonthlyPaymentInput() {
        return driver.findElement(middleNameInput).getAttribute("value");

    }

    public void setHousingStatusIdInput(String housingStatus) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(housingStatusIdInput)).click().perform();
        driver.findElement(housingStatusIdInput).sendKeys(Keys.ENTER);
    }

    public void setLandlordOrMTGHolderInput(String landlordOrMTGHolder) {
        driver.findElement(landlordOrMTGHolderInput).clear();
        driver.findElement(landlordOrMTGHolderInput).sendKeys(landlordOrMTGHolder);
    }

    public void setMonthlyPaymentInput(String monthlyPayment) {
        driver.findElement(monthlyPaymentInput).clear();
        driver.findElement(monthlyPaymentInput).sendKeys(monthlyPayment);
    }

    public String getIncomeEmployerNameInput() {
        return driver.findElement(incomeEmployerNameInput).getAttribute("value");
    }

    public void setIncomeEmployerNameInput(String incomeEmployerName) {
        driver.findElement(incomeEmployerNameInput).clear();
        driver.findElement(incomeEmployerNameInput).sendKeys(incomeEmployerName);
    }

    public String getIncomeWorkPhoneNumberInput() {
        return driver.findElement(incomeWorkPhoneNumberInput).getAttribute("value");
    }

    public void setIncomeWorkPhoneNumberInput(String incomeWorkPhoneNumber) {
        driver.findElement(incomeWorkPhoneNumberInput).clear();
        driver.findElement(incomeWorkPhoneNumberInput).sendKeys(incomeWorkPhoneNumber);
    }

    public String getIncomeExtInput() {
        return driver.findElement(incomeExtInput).getAttribute("value");
    }

    public void setIncomeExtInput(String incomeExt) {
        driver.findElement(incomeExtInput).clear();
        driver.findElement(incomeExtInput).sendKeys(incomeExt);
    }

    public String getIncomeHomeAddressInput() {
        return driver.findElement(incomeHomeAddressInput).getAttribute("value");
    }

    public void setIncomeHomeAddressInput(String incomeHomeAddress) {
        driver.findElement(incomeHomeAddressInput).clear();
        driver.findElement(incomeHomeAddressInput).sendKeys(incomeHomeAddress);
    }

    public String getIncomeHomeAddressLine2Input() {
        return driver.findElement(incomeHomeAddressLine2Input).getAttribute("value");
    }

    public void setIncomeHomeAddressLine2Input(String incomeHomeAddressLine2) {
        driver.findElement(incomeHomeAddressLine2Input).clear();
        driver.findElement(incomeHomeAddressLine2Input).sendKeys(incomeHomeAddressLine2);
    }

    public String getIncomeHomeSuiteNumberInput() {
        return driver.findElement(incomeHomeSuiteNumberInput).getAttribute("value");
    }

    public void setIncomeHomeSuiteNumberInput(String incomeHomeSuiteNumber) {
        driver.findElement(incomeHomeSuiteNumberInput).clear();
        driver.findElement(incomeHomeSuiteNumberInput).sendKeys(incomeHomeSuiteNumber);
    }

    public String getIncomeZipCodeInput() {
        return driver.findElement(incomeZipCodeInput).getAttribute("value");
    }

    public void setIncomeZipCodeInput(String incomeZipCode) throws InterruptedException {
        driver.findElement(incomeZipCodeInput).clear();
        driver.findElement(incomeZipCodeInput).sendKeys(incomeZipCode);
        Thread.sleep(700);
        driver.findElement(incomeZipCodeInput).sendKeys(Keys.ENTER);
    }

    public String getIncomeSupervisorNameInput() {
        return driver.findElement(incomeSupervisorNameInput).getAttribute("value");
    }

    public void setIncomeSupervisorNameInput(String incomeSupervisorName) {
        driver.findElement(incomeSupervisorNameInput).clear();
        driver.findElement(incomeSupervisorNameInput).sendKeys(incomeSupervisorName);
    }

    public String getIncomeApplicant_employmentStatusInput() {
        return driver.findElement(incomeApplicant_employmentStatusIdInput).getAttribute("value");
    }

    public void setIncomeApplicant_employmentStatusInput(String incomeApplicant_employmentStatus) {
        driver.findElement(incomeApplicant_employmentStatusIdInput).click();
        driver.findElement(incomeApplicant_employmentStatusIdInput).sendKeys(Keys.ENTER);
    }

    public void setLoanCashPriceInput(String cashPrice, String typeApplication) {
        if (typeApplication.equalsIgnoreCase("loan")) {
            driver.findElement(loanCashPriceInput).clear();
            driver.findElement(loanCashPriceInput).sendKeys(cashPrice);
        } else {
            driver.findElement(leaseCashPriceInput).clear();
            driver.findElement(leaseCashPriceInput).sendKeys(cashPrice);
        }

    }

    public String getIncomePositionDepartmentInput() {
        return driver.findElement(incomePositionDepartmentInput).getAttribute("value");
    }

    public void setIncomePositionDepartmentInput(String incomePositionDepartment) {
        driver.findElement(incomePositionDepartmentInput).clear();
        driver.findElement(incomePositionDepartmentInput).sendKeys(incomePositionDepartment);
    }

    public String getIncomeYearsAtJobInput() {
        return driver.findElement(incomeYearsAtJobInput).getAttribute("value");
    }

    public void setIncomeYearsAtJobInput(String incomeYearsAtJob) {
        driver.findElement(incomeYearsAtJobInput).clear();
        driver.findElement(incomeYearsAtJobInput).sendKeys(incomeYearsAtJob);
    }

    public String getIncomeMonthsAtJobInput() {
        return driver.findElement(incomeApplicant_yearsAtJobInput).getAttribute("value");
    }

    public void setIncomeApplicant_yearsAtJobInputInput(String incomeApplicant_yearsAtJob) {
        driver.findElement(incomeApplicant_yearsAtJobInput).clear();
        driver.findElement(incomeApplicant_yearsAtJobInput).sendKeys(incomeApplicant_yearsAtJob);
    }

    public void setIncomeMonthsAtJobInput(String incomeMonthsAtJob) {
        driver.findElement(incomeMonthsAtJobInput).clear();
        driver.findElement(incomeMonthsAtJobInput).sendKeys(incomeMonthsAtJob);
    }

    public String getIncomeApplicantFrequencyIdInput() {
        return driver.findElement(incomeApplicantFrequencyIdInput).getAttribute("value");
    }

    public void setIncomeApplicantFrequencyIdInput(String incomeApplicantFrequency) {
        driver.findElement(incomeApplicantFrequencyIdInput).click();
        driver.findElement(incomeApplicantFrequencyIdInput).sendKeys(Keys.ENTER);
    }

    public void setTextMessageInput(String message) {
        driver.findElement(textMessageInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(textMessageInput).sendKeys(message);
    }

    public String getDateInput() {
        return driver.findElement(dateInput).getAttribute("value");
    }

    public void setDateInput(String date) {
        driver.findElement(dateInput).sendKeys(date);
    }

    public String getVehicleInfoBodyStyleOrTrimInput() {
        return driver.findElement(vehicleInfoBodyStyleOrTrimInput).getAttribute("value");
    }

    public void setVehicleInfoBodyStyleOrTrimInput(String vehicleInfoBodyStyleOrTrim) {
        driver.findElement(vehicleInfoBodyStyleOrTrimInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInfoBodyStyleOrTrimInput).sendKeys(vehicleInfoBodyStyleOrTrim);
    }

    public String getVehicleInfoColorInput() {
        return driver.findElement(vehicleInfoColorInput).getAttribute("value");
    }

    public void setVehicleInfoColorInput(String vehicleInfoColor) {
        driver.findElement(vehicleInfoColorInput).click();
        driver.findElement(vehicleInfoColorInput).sendKeys(vehicleInfoColor);
    }

    public String getVehicleInfoVinInput() throws InterruptedException {
        return driver.findElement(vehicleInfoVinInput).getAttribute("value");
    }

    public void setVehicleInfoVinInput(String vehicleInfoVin) throws InterruptedException {
        driver.findElement(vehicleInfoVinInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInfoVinInput).sendKeys(vehicleInfoVin);
        Thread.sleep(1000);
        driver.findElement(vehicleInfoVinInput).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }


    public String getVehicleInfoMilesInput() {
        return driver.findElement(vehicleInfoMilesInput).getAttribute("value");
    }

    public void setVehicleInfoMilesInput(String vehicleInfoMiles) {
        driver.findElement(vehicleInfoMilesInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInfoMilesInput).sendKeys(vehicleInfoMiles);
    }

    public String getVehicleInfoGvwInput() {
        return driver.findElement(vehicleInfoGvwInput).getAttribute("value");
    }

    public void setVehicleInfoGvwInput(String vehicleInfoGvw) {
        driver.findElement(vehicleInfoGvwInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInfoGvwInput).sendKeys(vehicleInfoGvw);
    }

    public String getVehicleInfoGvwrInput() {
        return driver.findElement(vehicleInfoGvwrInput).getAttribute("value");

    }

    public void setVehicleInfoGvwrInput(String vehicleInfoGvwr) {
        driver.findElement(vehicleInfoGvwrInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInfoGvwrInput).sendKeys(vehicleInfoGvwr);
    }

    public String getVehicleInfoMsrpInput() {
        return driver.findElement(vehicleInfoMsrpInput).getAttribute("value");
    }

    public void setVehicleInfoMsrpInput(String vehicleInfoMsrp) {
        driver.findElement(vehicleInfoMsrpInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInfoMsrpInput).sendKeys(vehicleInfoMsrp);
    }

    public void setVehicleWholeSaleInput(String vehicleWholeSale) {
        driver.findElement(vehicle_wholeSaleInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicle_wholeSaleInput).sendKeys(vehicleWholeSale);
    }

    public String getVehicleInfoWeightInput() {
        return driver.findElement(vehicleInfoWeightInput).getAttribute("value");
    }

    public void setVehicleInfoWeightInput(String vehicleInfoWeight) {
        driver.findElement(vehicleInfoWeightInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInfoWeightInput).sendKeys(vehicleInfoWeight);
    }

    public String getVehicleInfoIsComercialVehicleInput() {
        return driver.findElement(vehicleInfoIsComercialVehicleInput).getAttribute("value");
    }

    public void setVehicleInfoIsComercialVehicleInput(boolean vehicleInfoIsComercialVehicle) {
        if (vehicleInfoIsComercialVehicle) {
            driver.findElement(vehicleInfoIsComercialVehicleInput).click();
        }
    }

    public String getVehicleInfoIsNewInput() {
        return driver.findElement(vehicleInfoIsNewInput).getAttribute("value");
    }

    public void setVehicleInfoIsNewInput(boolean vehicleInfoIsNew) {
        if (vehicleInfoIsNew) {
            driver.findElement(vehicleInfoIsNewInput).click();
        }
    }

    public void setVehicleInfoNotesInput(String notes) {
        driver.findElement(vehicleInfoNotesInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInfoNotesInput).sendKeys(notes);
    }


    public String getTradeInBodyStyleOrTrimInput() {
        return driver.findElement(tradeInBodyStyleOrTrimInput).getAttribute("value");
    }


    public void setTradeInBodyStyleOrTrimInput(String tradeInBodyStyleOrTrim) {
        driver.findElement(tradeInBodyStyleOrTrimInput).clear();
        driver.findElement(tradeInBodyStyleOrTrimInput).sendKeys(tradeInBodyStyleOrTrim);
    }

    public String getTradeInfoColorInput() {
        return driver.findElement(tradeInfoColorInput).getAttribute("value");
    }

    public void setTradeInfoColorInput(String tradeInfoColor) {
        driver.findElement(tradeInfoColorInput).click();
        driver.findElement(tradeInfoColorInput).sendKeys(tradeInfoColor);
    }

    public String getTradeInMilesInput() {
        return driver.findElement(tradeInMilesInput).getAttribute("value");
    }

    public void setTradeInMilesInput(String tradeInMiles) {
        driver.findElement(tradeInMilesInput).clear();
        driver.findElement(tradeInMilesInput).sendKeys(tradeInMiles);
    }


    public String getDTI_Input() {
        return driver.findElement(DTI_Input).getAttribute("value");
    }

    public String getPTI_Input() {
        return driver.findElement(PTI_Input).getAttribute("value");
    }

    public String getLTVTradeIn_Input() {
        return driver.findElement(LTVTradeIn_Input).getAttribute("value");
    }

    public String getLTVWithoutProducts_Input() {
        return driver.findElement(LTVWithoutProducts_Input).getAttribute("value");
    }

    public String getLTVRetail_Input() {
        return driver.findElement(LTVRetail_Input).getAttribute("value");
    }

    public String getLTVWithoutProductsRetail_Input() {
        return driver.findElement(LTVWithoutProductsRetail_Input).getAttribute("value");
    }

    public void clickJDPowerButton() throws InterruptedException {
        driver.findElement(jDPowerButton).click();
        Thread.sleep(1000);
    }

    public void clickCalculateDTIButton() throws InterruptedException {
        driver.findElement(calculateDTIButton).click();
        Thread.sleep(500);
        driver.findElement(requestButton).click();
        Thread.sleep(3000);
    }


    public void selectBranchInput() throws InterruptedException {
        driver.findElement(branchIdInput2).click();
        Thread.sleep(3000);
        driver.findElement(branchIdInput2).sendKeys(Keys.ENTER);
    }

    public void selectOfficeInput() throws InterruptedException {
        driver.findElement(officeIdInput).click();
        Thread.sleep(3000);
        driver.findElement(officeIdInput).sendKeys(Keys.ENTER);
    }

    public void waitSelectListLoad(By element, int timeSeconds) throws InterruptedException {
        int count = 0;
        while (driver.findElement(element).getText().isEmpty() && ++count < timeSeconds) {
            Thread.sleep(1000);
        }
    }

    public void setApplicantFirstNameInput(String firstName) {
        driver.findElement(applicantFirstNameInput).sendKeys(firstName);
    }

    public void setApplicantPhoneNumberInput(String phoneNumber) {
        driver.findElement(applicantPhoneNumberInput).sendKeys(phoneNumber);
    }

    public void setApplicantEmailInput(String email) {
        driver.findElement(applicantemailInput).sendKeys(email);
    }

    public void clickOnSendApplication() {
        driver.findElement(sendApplicationBton).click();
    }

    public void clickOnOk() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, oKButton);
        driver.findElement(oKButton).click();
    }

    public boolean verifySuccessfullyNotification() {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(successNotification)));
        return true;
    }

    public void clickOnNext() {
        driver.findElement(nextButton).click();
    }

    public void clickOnSubmit2() {
        driver.findElement(submitBtn2).click();
    }

    public void clickOnSubmitConfirm() {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, submitConfirmButton);
        driver.findElement(submitConfirmButton).click();
    }

    public void clickOnContinue() {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, continueButton);
        driver.findElement(continueButton).click();
    }

    public void clickOnSubmitRequest() {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, submitRequestButton);
        driver.findElement(submitRequestButton).click();
    }

    public void clickOnSubmit3() {
        driver.findElement(submitBtn3).click();
    }

    public void clickOnValidate() {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, validateBtn);
        driver.findElement(validateBtn).click();
        webAction.highlightElement(driver.findElement(validateBtn));
    }

    public void setVerificationCode(String verificationCode) throws InterruptedException {
        driver.findElement(verificationCodeInput).sendKeys("0" + verificationCode);
        Thread.sleep(1500);
    }

    public void clickOnPullVehicleInfo() {
        Actions actions = new Actions(driver);
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, pullVehicleInfoBton);
        actions.moveToElement(driver.findElement(pullVehicleInfoBton)).click().perform();
        webAction.waitInVisibilityOf(driver, spinIcons);
        webAction.highlightElement(driver.findElement(pullVehicleInfoBton));
        //clickOnOk();
        driver.findElement(tradeInVinInput).click();
        driver.findElement(tradeInVinInput).sendKeys(Keys.ARROW_UP);
    }


    public List<String> getJDPowerValues() {
        List<String> jdPowerValuesList = new ArrayList<String>();
        WebAction webAction = new WebAction(driver);
        webAction.waitInVisibilityOf(driver, spinIcons);

        for (WebElement jdPowerValue : driver.findElements(jdPowerValues)) {
            jdPowerValuesList.add(jdPowerValue.getText());
        }
        return jdPowerValuesList;
    }

    public void clickOnAllJDPowerOptions() {
        WebAction webAction = new WebAction(driver);
        int count = 0;
        for (WebElement jdPowerOption : driver.findElements(jdPowerOptions2)) {
            //webAction.waitToBeClickable(driver, jdPowerOption);
            try {
                driver.findElements(jdPowerOptions).get(count).click();
            } catch (Exception e) {
            }
            count++;
        }
    }

    public void clickOnAllJDPowerTrimLevels() {
        WebAction webAction = new WebAction(driver);
        int count = 0;
        for (WebElement jdPowerTrimLevel : driver.findElements(jdPowerTrimLevels)) {
            //webAction.waitToBeClickable(driver, jdPowerTrimLevel);
            try {
                driver.findElements(jdPowerTrimLevels).get(count).click();
            } catch (Exception e) {
            }
            count++;
        }
    }

    public void clickOnJDPowerOption() {
        driver.findElement(jdPowerOptionTag).click();
    }

    public void clickOnJDPowerTrimLevel() {
        driver.findElement(jdPowerTrimLevelTag).click();
    }

    public void clickOnOTTOinspector() {
        Actions actions = new Actions(driver);
        WebAction webAction = new WebAction(driver);
        actions.moveToElement(driver.findElement(oTTOinspectorButton)).click().perform();
        //driver.findElement(oTTOinspectorButton).click();
        webAction.highlightElement(driver.findElement(oTTOinspectorButton));
    }

    public void clickOnOTTOverify() {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, oTTOverifyButton);
        Actions actions = new Actions(driver);
        webAction.highlightElement(driver.findElement(oTTOverifyButton));
        actions.moveToElement(driver.findElement(oTTOverifyButton)).click().perform();
        //driver.findElement(oTTOverifyButton).click();
    }

    public void clickOnOTTinsure() {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, ottoInsureButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(ottoInsureButton)).click().perform();
        //driver.findElement(oTTOverifyButton).click();
    }

    public void setLenderPhone(String phone) {
        driver.findElement(fromPhoneUS).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(fromPhoneUS).sendKeys(phone);
    }

    public void setDealerPhone(String phone) {
        driver.findElement(fromPhoneUS).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(fromPhoneUS).sendKeys(phone);
    }

    public void setDealerPhoneLenderSide(String phone) {
        driver.findElement(toPhoneUS).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(toPhoneUS).sendKeys(phone);
    }

    public void setEmailOttoVerifyInput(String email) {
/*        int count = 0;
        while (!driver.findElement(emailOttoVerify).getAttribute("value").equalsIgnoreCase("") && ++count<50){
            driver.findElement(emailOttoVerify).sendKeys(Keys.BACK_SPACE);
        }*/
        driver.findElement(emailOttoVerify).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(emailOttoVerify).sendKeys(email);
    }

    public void clickOnSendRequest() {
        driver.findElement(sendRequestButton).click();
    }


    public void clickOnPassengerVehicle() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(passengerVehicle)).click().perform();
    }

    public void clickOnRecreationalVehicles() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(recreationalVehicles)).click().perform();
        // driver.findElement(recreationalVehicles).click();
    }

    public void clickOnAircraftVehicle() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(aircraftVehicle)).click().perform();
    }

    public void clickOnBoatVehicle() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(boatVehicle)).click().perform();
    }

    public void setVehicleInformation_vehicle_makeInput(String makeInput) {
        driver.findElement(vehicleInformation_vehicle_makeInput).click();
        driver.findElement(vehicleInformation_vehicle_makeInput).sendKeys(Keys.ENTER);
    }

    public void setVehicleInformation_Aircraft_makeInput(String makeInput) {
        driver.findElement(vehicleInformation_vehicle_makeInput).sendKeys(makeInput);
    }

    public void setVehicleInformation_vehicle_modelNameInput(String modelNameInput) {
        driver.findElement(vehicleInformation_vehicle_modelNameInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_modelNameInput).sendKeys(modelNameInput);
    }

    public void setVehicleInformation_vehicle_numberOfSlideOutsInput(String numberOfSlideOutsInput) {
        driver.findElement(vehicleInformation_vehicle_numberOfSlideOutsInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_numberOfSlideOutsInput).sendKeys(numberOfSlideOutsInput);
    }

    public void setVehicleInformation_vehicle_useInput(String useInput) {
        driver.findElement(vehicleInformation_vehicle_useInput).click();
        driver.findElement(vehicleInformation_vehicle_useInput).sendKeys(Keys.ENTER);
    }

    public void setVehicleInformation_vehicle_typeOfLoanInput(String typeOfLoan_listInput) {
        driver.findElement(vehicleInformation_vehicle_typeOfLoanInput).click();
        driver.findElement(vehicleInformation_vehicle_typeOfLoanInput).sendKeys(Keys.ENTER);
    }

    public void setVehicleInformation_vehicle_typeOfRvInput(String typeOfRvInput) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(vehicleInformation_vehicle_typeOfRvInput)).click().perform();
        //driver.findElement(vehicleInformation_vehicle_typeOfRvInput).click();
        Thread.sleep(1200);
        driver.findElement(vehicleInformation_vehicle_typeOfRvInput).sendKeys(Keys.ENTER);
    }

    public void setVehicleInformation_vehicle_dateInput(String dateInput) throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, vehicleInformation_Aircraft_dateInput);
        driver.findElement(vehicleInformation_vehicle_dateInput).click();
        Thread.sleep(500);
        driver.findElement(vehicleInformation_vehicle_dateYearInput).click();
    }

    public void setVehicleInformation_vehicle_lengthInput(String lengthInput) {
        driver.findElement(vehicleInformation_vehicle_lengthInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_lengthInput).sendKeys(lengthInput);
    }

    public void setVehicleInformation_vehicle_milesInput(String milesInput) {
        driver.findElement(vehicleInformation_vehicle_milesInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_milesInput).sendKeys(milesInput);
    }

    public void setVehicleInformation_vehicle_colorInput(String colorInput) {
        driver.findElement(vehicleInformation_vehicle_colorInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_colorInput).sendKeys(colorInput);
    }

    public void setVehicleInformation_vehicle_bodyInput(String bodyInput) {
        driver.findElement(vehicleInformation_vehicle_bodyInput).click();
        driver.findElement(vehicleInformation_vehicle_bodyInput).sendKeys(Keys.ENTER);
    }

    public void setVehicleInformation_vehicle_notesOptionsInput(String notesOptionsInput) {
        driver.findElement(vehicleInformation_vehicle_notesOptionsInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_notesOptionsInput).sendKeys(notesOptionsInput);
    }

    public void setVehicleInformation_vehicle_modelInput(String modelInput) {
        driver.findElement(vehicleInformation_vehicle_modelInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_modelInput).sendKeys(modelInput);
    }

    public void setVehicleInformation_Aircraft_dateInput(String aircraft_dateInput) throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, vehicleInformation_Aircraft_dateInput);
        driver.findElement(vehicleInformation_Aircraft_dateInput).click();
        Thread.sleep(500);
        driver.findElement(vehicleInformation_Aircraft_dateYearInput_).click();
    }

    public void setVehicleInformation_vehicle_faanInput(String faanInput) {
        driver.findElement(vehicleInformation_vehicle_faanInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_faanInput).sendKeys(faanInput);
    }

    public void setVehicleInformation_vehicle_snInput(String snInput) {
        driver.findElement(vehicleInformation_vehicle_snInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_snInput).sendKeys(snInput);
    }

    public void setVehicleInformation_Aircraft_lastAnnualDateInput(String aircraft_lastAnnualDateInput) {
        driver.findElement(vehicleInformation_Aircraft_lastAnnualDateInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_Aircraft_lastAnnualDateInput).sendKeys(aircraft_lastAnnualDateInput);
    }

    public void setVehicleInformation_Aircraft_ttafInput(String ttafInput) {
        driver.findElement(vehicleInformation_Aircraft_ttafInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_Aircraft_ttafInput).sendKeys(ttafInput);
    }

    public void setVehicleInformation_Aircraft_reSmohInput(String reSmohInput) {
        driver.findElement(vehicleInformation_Aircraft_reSmohInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_Aircraft_reSmohInput).sendKeys(reSmohInput);
    }

    public void setVehicleInformation_vehicle_leSmohInput(String leSmohInput) {
        driver.findElement(vehicleInformation_vehicle_leSmohInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_leSmohInput).sendKeys(leSmohInput);
    }

    public void setVehicleInformation_Aircraft_closingDateInput(String aircraft_closingDateInput) {
        driver.findElement(vehicleInformation_Aircraft_closingDateInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_Aircraft_closingDateInput).sendKeys(aircraft_closingDateInput);
    }

    public void setVehicleInformation_vehicle_sellerNameInput(String sellerNameInput) {
        driver.findElement(vehicleInformation_vehicle_sellerNameInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_sellerNameInput).sendKeys(sellerNameInput);
    }

    public void setVehicleInformation_vehicle_sellerPhonenumberInput(String sellerPhonenumberInput) {
        driver.findElement(vehicleInformation_vehicle_sellerPhonenumberInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_sellerPhonenumberInput).sendKeys(sellerPhonenumberInput);
    }

    public void setVehicleInformation_vehicle_currentAircraftInput(String currentAircraftInput) {
        driver.findElement(vehicleInformation_vehicle_currentAircraftInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_currentAircraftInput).sendKeys(currentAircraftInput);
    }

    public void setVehicleInformation_vehicle_financedStringInput(String financedStringInput) {
        driver.findElement(vehicleInformation_vehicle_financedByInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_financedByInput).sendKeys(financedStringInput);
    }

    public void setVehicleInformation_vehicle_typeOfPilotCertificateOptsInput(String typeOfPilotCertificateOptsInput) {
        driver.findElement(vehicleInformation_vehicle_typeOfPilotCertificateOptsInput).click();
        driver.findElement(vehicleInformation_vehicle_typeOfPilotCertificateOptsInput).sendKeys(Keys.ENTER);
    }

    public void setVehicleInformation_vehicle_currentHrsInput(String currentHrsInput) {
        driver.findElement(vehicleInformation_vehicle_currentHrsInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_currentHrsInput).sendKeys(currentHrsInput);
    }

    public void setVehicleInformation_vehicle_ratingsInput(String ratingsInput) {
        driver.findElement(vehicleInformation_vehicle_ratingsInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_ratingsInput).sendKeys(ratingsInput);
    }

    public void setVehicleInformation_Aircraft_endorsementsInput(String endorsementsInput) {
        driver.findElement(vehicleInformation_Aircraft_endorsementsInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_Aircraft_endorsementsInput).sendKeys(endorsementsInput);
    }

    public void setVehicleInformation_Aircraft_aircraftExperienceInput(String aircraftExperienceInput) {
        driver.findElement(vehicleInformation_Aircraft_aircraftExperienceInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_Aircraft_aircraftExperienceInput).sendKeys(aircraftExperienceInput);
    }

    public void setVehicleInformation_vehicle_aircraftWillBaseInput(String aircraftWillBaseInput) {
        driver.findElement(vehicleInformation_vehicle_aircraftWillBaseInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_aircraftWillBaseInput).sendKeys(aircraftWillBaseInput);
    }

    public void setVehicleInformation_vehicle_howAircraftUtilizedInput(String howAircraftUtilizedInput) {
        driver.findElement(vehicleInformation_vehicle_howAircraftUtilizedInput).click();
        driver.findElement(vehicleInformation_vehicle_howAircraftUtilizedInput).sendKeys(Keys.ENTER);
    }

    public void setVehicleInformation_vehicle_previousExperienceInput(boolean yes) {
        driver.findElement(vehicleInformation_vehicle_previousExperienceInput).click();
    }

    public void setVehicleInformation_vehicle_detailsInput(String details) {
        driver.findElement(vehicleInformation_vehicle_detailsInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_detailsInput).sendKeys(details);
    }

    public void setVehicleInformation_boat_dateInput(String aircraft_dateInput) throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, vehicleInformation_Aircraft_dateInput);
        driver.findElement(vehicleInformation_Aircraft_dateInput).click();
        Thread.sleep(500);
        driver.findElement(vehicleInformation_Aircraft_dateYearInput_).click();
    }

    public void setVehicleInformation_vehicle_boat_lengthInput(String boat_lengthInput) {
        driver.findElement(vehicleInformation_vehicle_boat_lengthInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_boat_lengthInput).sendKeys(boat_lengthInput);
    }

    public void setVehicleInformation_vehicle_titleNumberInput(String titleNumberInput) {
        driver.findElement(vehicleInformation_vehicle_titleNumberInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_titleNumberInput).sendKeys(titleNumberInput);
    }

    public void setVehicleInformation_vehicle_hullTypeInput(String hullTypeInput) {
        driver.findElement(vehicleInformation_vehicle_hullTypeInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_hullTypeInput).sendKeys(hullTypeInput);
    }

    public void setVehicleInformation_vehicle_hullIdNumberInput(String hullIdNumberInput) {
        driver.findElement(vehicleInformation_vehicle_hullIdNumberInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_hullIdNumberInput).sendKeys(hullIdNumberInput);
    }

    public void setVehicleInformation_vehicle_populsionTypeInput(String populsionTypeInput) {
        driver.findElement(vehicleInformation_vehicle_populsionTypeInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_populsionTypeInput).sendKeys(populsionTypeInput);
    }

    public void setVehicleInformation_vehicle_registrationNumberInput(String registrationNumberInput) {
        driver.findElement(vehicleInformation_vehicle_registrationNumberInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_registrationNumberInput).sendKeys(registrationNumberInput);
    }

    public void setVehicleInformation_vehicle_stateRegisteredInput(String stateRegisteredInput) {
        driver.findElement(vehicleInformation_vehicle_stateRegisteredInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_stateRegisteredInput).sendKeys(stateRegisteredInput);
    }

    public void setVehicleInformation_vehicle_hoursInput(String hoursInput) {
        driver.findElement(vehicleInformation_vehicle_hoursInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_hoursInput).sendKeys(hoursInput);
    }

    public void setVehicleInformation_vehicle_boatValueInput(String boatValueInput) {
        driver.findElement(vehicleInformation_vehicle_boatValueInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_boatValueInput).sendKeys(boatValueInput);
    }

    public void setVehicleInformation_vehicle_outboardMotorValueInput(String outboardMotorValueInput) {
        driver.findElement(vehicleInformation_vehicle_outboardMotorValueInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_outboardMotorValueInput).sendKeys(outboardMotorValueInput);
    }

    public void setVehicleInformation_vehicle_notesInput(String notesInput) {
        driver.findElement(vehicleInformation_vehicle_notesInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(vehicleInformation_vehicle_notesInput).sendKeys(notesInput);
    }

    public void setOttoInsureEmailInput(String email) {
        driver.findElement(ottoInsureEmailInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(ottoInsureEmailInput).sendKeys(email);
    }

    public void setOttoInsurePhoneInput(String phone) {
        driver.findElement(ottoInsurePhoneInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(ottoInsurePhoneInput).sendKeys(phone);
    }


    public void moveToVehicleInfoNotesInput() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(vehicleInfoNotesInput)).perform();
    }

    public void moveTotVehicleInformation_vehicle_notesOptionsInput() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(vehicleInformation_vehicle_notesOptionsInput)).perform();
    }

    public void moveToVehicleInformation_vehicle_detailsInput() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(vehicleInformation_vehicle_detailsInput)).perform();
    }

    public void moveToVehicleInformation_vehicle_notesInput() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(vehicleInformation_vehicle_notesInput)).perform();
    }

    public void clickOnRouteOneCompany() {
        Actions actions = new Actions(driver);
        WebAction webAction = new WebAction(driver);
        actions.moveToElement(driver.findElement(routeOneCompanyOption)).click().perform();
        webAction.highlightElement(driver.findElement(routeOneCompanyOption));
    }

    public void clickOnCUDLCompany() {
        Actions actions = new Actions(driver);
        WebAction webAction = new WebAction(driver);
        actions.moveToElement(driver.findElement(cudlCompanyOption)).click().perform();
        webAction.highlightElement(driver.findElement(cudlCompanyOption));
    }

    public void clickOnDealerTrackCompany() {
        Actions actions = new Actions(driver);
        WebAction webAction = new WebAction(driver);
        actions.moveToElement(driver.findElement(dealertrackCompanyOption)).click().perform();
        webAction.highlightElement(driver.findElement(dealertrackCompanyOption));
    }

    public void clickOnAppOneCompany() {
        Actions actions = new Actions(driver);
        WebAction webAction = new WebAction(driver);
        actions.moveToElement(driver.findElement(appOneCompanyOption)).click().perform();
        webAction.highlightElement(driver.findElement(appOneCompanyOption));
    }

    public void clickOnSignDocuments() {
        Actions actions = new Actions(driver);
        WebAction webAction = new WebAction(driver);
        webAction.highlightElement(driver.findElement(signDocumentsBtn));
        actions.moveToElement(driver.findElement(signDocumentsBtn)).click().perform();
    }

    public void clickOnLastDocument() {

        driver.findElement(lastDocument).click();
    }

    public void clickOnSignDocumentButton() {
        WebAction webAction = new WebAction(driver);
        driver.findElement(signDocumentButton).click();
        webAction.highlightElement(driver.findElement(signDocumentButton));
        webAction.waitVisibilityOf(driver, signDocumentButton);
    }

    public void setCoApplicantEmail(String email) {
        driver.findElement(coapplicantEmailInput).sendKeys(email);
    }
}
