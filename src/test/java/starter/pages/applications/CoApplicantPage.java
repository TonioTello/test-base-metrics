package starter.pages.applications;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class CoApplicantPage {

    private WebDriver driver;

    private By coFirstNameInput = By.id("coApplicant_firstName");
    //private By coLastNameInput = By.id("coApplicant_lastName"); Todo take it back
    private By coLastNameInput = By.xpath("(//*[@id=\"coApplicant_suffix\"]//preceding::input)[last()]");
    //private By coDateOfBirthInput_ = By.id("mui-22");
    private By coDateOfBirthInput_ = By.xpath("(//input[@id=\"coApplicant_socialSecurity\"]//preceding::input)[last()]");
    private By coSocialSecurityInput = By.id("coApplicant_socialSecurity");
    private By coDriversLicenseStateInput_ = By.id("coApplicant_stateId");
    private By coDriversLicenseStateInput = By.id("coApplicant_driversLicenseStateId");
    private By coZipCodeInput = By.id("coApplicant_zipCode");
    private By zipCodeSearchIcon = By.xpath("//button[preceding::input[@id='applicant_zipCode']][1]"); //Todo
    private By coZipCodeSearchIcon = By.xpath("//button[preceding::input[@id='coApplicant_zipCode']][1]"); //Todo
    private By coIncomeApplicantInput = By.id("coApplicant_incomeApplicant_grossIncome");

    private By okButton = By.xpath("//*[contains(text(), 'OK')]");


    // Other fields to complete full applications
    private By middleNameInput = By.id("coApplicant_middleName");
    private By suffixInput = By.id("coApplicant_suffix");
    private By driversLicenseInput = By.id("coApplicant_driversLicense");
    private By licenseExpirationInput =  By.xpath("(//input[@id=\"coApplicant_driversLicenseStateId\"]//following::input)[1]");
    private By emailInput = By.id("coApplicant_email");
    private By secundaryEmailInput = By.id("coApplicant_secundaryEmail");
    private By phoneNumberInput = By.id("coApplicant_phoneNumber");
    private By secundaryPhoneNumberInput = By.id("coApplicant_secundaryPhoneNumber");
    private By homeAddressAppInput = By.id("coApplicant_homeAddress");
    private By homeAddressLine2Input = By.id("coApplicant_homeAddressLine2");
    private By yearsAtAddressInput = By.id("coApplicant_yearsAtAddress");
    private By monthsAtAddressInput = By.id("coApplicant_monthsAtAddress");
    private By housingStatusIdInput = By.id("coApplicant_housingStatusId");
    private By landlordOrMTGHolderInput = By.id("coApplicant_landlordOrMTGHolder");
    private By monthlyPaymentInput = By.id("coApplicant_monthlyPayment");
    private By incomeEmployerNameInput = By.id("coApplicant_incomeApplicant_employerName");
    private By incomeWorkPhoneNumberInput = By.id("coApplicant_incomeApplicant_workPhoneNumber");
    private By incomeExtInput = By.id("coApplicant_incomeApplicant_ext");
    private By incomeHomeAddressInput = By.id("coApplicant_incomeApplicant_homeAddress");
    private By incomeHomeAddressLine2Input = By.id("coApplicant_incomeApplicant_homeAddressLine2");
    private By incomeHomeSuiteNumberInput = By.id("coApplicant_incomeApplicant_homeSuiteNumber");
    private By incomeZipCodeInput = By.id("coApplicant_incomeApplicant_zipCode");
    private By incomeSupervisorNameInput = By.id("coApplicant_incomeApplicant_supervisorName");
    private By incomeApplicant_employmentStatusIdInput = By.id("coApplicant_incomeApplicant_employmentStatusId");
    private By incomeApplicant_yearsAtJobInput = By.id("coApplicant_incomeApplicant_yearsAtJob");
    private By incomePositionDepartmentInput = By.id("coApplicant_incomeApplicant_positionDepartment");
    private By incomeYearsAtJobInput = By.id("coApplicant_incomeApplicant_yearsAtJob");
    private By incomeMonthsAtJobInput = By.id("coApplicant_incomeApplicant_monthsAtJob");
    private By incomeApplicantFrequencyIdInput = By.id("coApplicant_incomeApplicant_frequencyId");
    private By dateInput = By.xpath("((//input[@id=\"coApplicant_incomeApplicant_frequencyId\"]//following::input)[not(@type=\"radio\" or @type=\"checkbox\")])[1]");

    //Vehicle Information
    private By vehicleInfoBodyStyleOrTrimInput = By.id("vehicleInformation_vehicle_bodyStyleOrTrim");
    private By tradeInfoColorInput = By.xpath("(//input[preceding::*[@id=\"tradeIn_miles\"]])[1]");
    private By vehicleInfoVinInput = By.id("vehicleInformation_vehicle_vin");
    //private By vehicleInfoVinInput = By.id("vehicleInformation_vin");
    private By vehicleInfoColorInput = By.xpath("(//input[preceding::*[@id=\"vehicleInformation_vehicle_bodyStyleOrTrim\"]])[1]");
    private By vehicleInfoMilesInput = By.id("vehicleInformation_vehicle_miles");
    private By vehicleInfoGvwInput = By.id("vehicleInformation_vehicle_gvw");
    private By vehicleInfoGvwrInput = By.id("vehicleInformation_vehicle_gvwr");

    private By vehicleInfoMsrpInput = By.id("vehicleInformation_vehicle_msrp");
    private By vehicleInfoWeightInput = By.id("vehicleInformation_vehicle_weight");
    private By vehicleInfoIsComercialVehicleInput = By.id("vehicleInformation_vehicle_isComercialVehicle");
    private By vehicleInfoIsNewInput = By.id("vehicleInformation_vehicle_isNew");
    private By tradeInBodyStyleOrTrimInput = By.id("tradeIn_bodyStyleOrTrim");
    private By tradeInMilesInput = By.id("tradeIn_miles");

    private By checkAppFound = By.xpath("//*[contains(text(),'Total records 1')]");


    public CoApplicantPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCoAppTab() {
        WebElement coAppTab = driver.findElement(By.xpath("//button[contains(text(), 'Co-Applicant')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(coAppTab).click().build().perform();
    }

    public void selectApplicantTab() {
        WebElement coAppTab = driver.findElement(By.xpath("(//button[contains(text(), 'Co-Applicant')]//preceding::button)[last()]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(coAppTab).click().build().perform();
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

    public void setEmailInput(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setSecundaryEmailInput(String secundaryEmail) {
        driver.findElement(secundaryEmailInput).clear();
        driver.findElement(secundaryEmailInput).sendKeys(secundaryEmail);
    }

    public String getSecundaryPhoneNumberInput() {
        return driver.findElement(secundaryPhoneNumberInput).getAttribute("value");
    }

    public void setPhoneNumberInput(String secundaryPhoneNumber) {
        driver.findElement(phoneNumberInput).clear();
        driver.findElement(phoneNumberInput).sendKeys(secundaryPhoneNumber);
    }    public void setSecundaryPhoneNumberInput(String secundaryPhoneNumber) {
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
        driver.findElement(housingStatusIdInput).click();
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
        driver.findElement(vehicleInfoBodyStyleOrTrimInput).clear();
        driver.findElement(vehicleInfoBodyStyleOrTrimInput).sendKeys(vehicleInfoBodyStyleOrTrim);
    }

    public String getVehicleInfoColorInput() {
        return driver.findElement(vehicleInfoColorInput).getAttribute("value");
    }

    public void setVehicleInfoColorInput(String vehicleInfoColor) {
        driver.findElement(vehicleInfoColorInput).click();
        driver.findElement(vehicleInfoColorInput).sendKeys(Keys.ENTER);
    }

    public String getVehicleInfoVinInput() throws InterruptedException {
        return driver.findElement(vehicleInfoVinInput).getAttribute("value");
    }

    public void setVehicleInfoVinInput(String vehicleInfoVin) throws InterruptedException {
        driver.findElement(vehicleInfoVinInput).clear();
        driver.findElement(vehicleInfoVinInput).sendKeys(vehicleInfoVin);
        Thread.sleep(1000);
        driver.findElement(vehicleInfoVinInput).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }


    public String getVehicleInfoMilesInput() {
        return driver.findElement(vehicleInfoMilesInput).getAttribute("value");
    }

    public void setVehicleInfoMilesInput(String vehicleInfoMiles) {
        driver.findElement(vehicleInfoMilesInput).clear();
        driver.findElement(vehicleInfoMilesInput).sendKeys(vehicleInfoMiles);
    }

    public String getVehicleInfoGvwInput() {
        return driver.findElement(vehicleInfoGvwInput).getAttribute("value");
    }

    public void setVehicleInfoGvwInput(String vehicleInfoGvw) {
        driver.findElement(vehicleInfoGvwInput).clear();
        driver.findElement(vehicleInfoGvwInput).sendKeys(vehicleInfoGvw);
    }

    public String getVehicleInfoGvwrInput() {
        return driver.findElement(vehicleInfoGvwrInput).getAttribute("value");

    }

    public void setVehicleInfoGvwrInput(String vehicleInfoGvwr) {
        driver.findElement(vehicleInfoGvwrInput).clear();
        driver.findElement(vehicleInfoGvwrInput).sendKeys(vehicleInfoGvwr);
    }

    public String getVehicleInfoMsrpInput() {
        return driver.findElement(vehicleInfoMsrpInput).getAttribute("value");
    }

    public void setVehicleInfoMsrpInput(String vehicleInfoMsrp) {
        driver.findElement(vehicleInfoMsrpInput).clear();
        driver.findElement(vehicleInfoMsrpInput).sendKeys(vehicleInfoMsrp);
    }

    public String getVehicleInfoWeightInput() {
        return driver.findElement(vehicleInfoWeightInput).getAttribute("value");
    }
    public void setVehicleInfoWeightInput(String vehicleInfoWeight) {
        driver.findElement(vehicleInfoWeightInput).clear();
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
        driver.findElement(tradeInfoColorInput).sendKeys(Keys.ENTER);
    }

    public String getTradeInMilesInput() {
        return driver.findElement(tradeInMilesInput).getAttribute("value");
    }

    public void setTradeInMilesInput(String tradeInMiles) {
        driver.findElement(tradeInMilesInput).clear();
        driver.findElement(tradeInMilesInput).sendKeys(tradeInMiles);
    }

    public void setCoFirstNameInput(String firstName) {
        driver.findElement(coFirstNameInput).clear();  //Todo
        driver.findElement(coFirstNameInput).sendKeys(firstName);
    }
    public void setCoLastNameInput(String lastName) {
        driver.findElement(coLastNameInput).clear();
        driver.findElement(coLastNameInput).sendKeys(lastName);
    }
    public void setCoDateOfBirthInput(String dateOfBirth) throws InterruptedException {
        driver.findElement(coDateOfBirthInput_).sendKeys(dateOfBirth);
    }
    public void setCoSocialSecurityInput(String socialSecurityNumber) {
        driver.findElement(coSocialSecurityInput).sendKeys(socialSecurityNumber);
    }
    public void setCoState(String state) {
        driver.findElement(coDriversLicenseStateInput).sendKeys(state);
        driver.findElement(coDriversLicenseStateInput).sendKeys(Keys.ENTER);
    }

    public void setCoZipCodeInput(String zipCode) throws InterruptedException {
        driver.findElement(coZipCodeInput).clear();
        driver.findElement(coZipCodeInput).sendKeys(zipCode);
        Thread.sleep(700);
        driver.findElement(coZipCodeInput).sendKeys(Keys.ENTER);
        //driver.findElement(coZipCodeSearchIcon).click();
    }
    public void setCoIncomeApplicantInput(String incomeApplicant) {
        driver.findElement(coIncomeApplicantInput).clear();
        driver.findElement(coIncomeApplicantInput).sendKeys(incomeApplicant);
    }

}
