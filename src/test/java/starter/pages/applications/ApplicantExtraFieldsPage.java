package starter.pages.applications;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import starter.utils.WebAction;

public class ApplicantExtraFieldsPage {

    private WebDriver driver;


    private By currentlyBankruptcyCheckBox = By.xpath("((//span[contains(text(),'Currently in bankruptcy')])[1]//preceding::input)[last()]");
    private By previousResidenceInformationCheckBox = By.xpath("((//span[contains(text(),'Previous residence information')])[1]//preceding::input)[last()]");
    private By additionalResidenceInformationCheckBox = By.xpath("((//span[contains(text(),'Additional residence information')])[1]//preceding::input)[last()]");
    private By previousIncomeSourceCheckBox = By.xpath("((//span[contains(text(),'Previous income source')])[1]//preceding::input)[last()]");
    private By additionalIncomeSourceCheckBox = By.xpath("((//span[contains(text(),'Additional income source')])[1]//preceding::input)[last()]");

    /******Previous residence information**********/
    private By applicant_previousHomeAddressInput = By.id("applicant_previousHomeAddress");
    private By applicant_previousHomeAddressLine2Input = By.id("applicant_previousHomeAddressLine2");
    private By applicant_previousZipCodeInput = By.id("applicant_previousZipCode");
    private By applicant_previousYearsAtAddressInput = By.id("applicant_previousYearsAtAddress");
    private By applicant_previousMonthsAtAddressInput = By.id("applicant_previousMonthsAtAddress");
    private By applicant_previousHousingStatusIdInput = By.id("applicant_previousHousingStatusId");
    private By applicant_previousMonthlyPaymentInput = By.id("applicant_previousMonthlyPayment");
    /******Additional residence information**********/
    private By applicant_anotherHomeAddressInput = By.id("applicant_anotherHomeAddress");
    private By applicant_anotherHomeAddressLine2Input = By.id("applicant_anotherHomeAddressLine2");
    private By applicant_anotherZipCodeInput = By.id("applicant_anotherZipCode");
    private By applicant_anotherYearsAtAddressInput = By.id("applicant_anotherYearsAtAddress");
    private By applicant_anotherMonthsAtAddressInput = By.id("applicant_anotherMonthsAtAddress");
    private By applicant_anotherHousingStatusIdInput = By.id("applicant_anotherHousingStatusId");
    private By applicant_anotherMonthlyPaymentInput = By.id("applicant_anotherMonthlyPayment");
    /******Previous income source information****/
    private By applicant_incomeApplicant_previousEmployerNameInput = By.id("applicant_incomeApplicant_previousEmployerName");
    private By applicant_incomeApplicant_previousWorkPhoneNumberInput = By.id("applicant_incomeApplicant_previousWorkPhoneNumber");
    private By applicant_incomeApplicant_previousExtInput = By.id("applicant_incomeApplicant_previousExt");
    private By applicant_incomeApplicant_previousHomeAddressInput = By.id("applicant_incomeApplicant_previousHomeAddress");
    private By applicant_incomeApplicant_previousHomeAddressLine2Input = By.id("applicant_incomeApplicant_previousHomeAddressLine2");
    private By applicant_incomeApplicant_previousHomeSuiteNumberInput = By.id("applicant_incomeApplicant_previousHomeSuiteNumber");
    private By applicant_incomeApplicant_previousZipCodeInput = By.id("applicant_incomeApplicant_previousZipCode");
    private By applicant_incomeApplicant_previousSupervisorNameInput = By.id("applicant_incomeApplicant_previousSupervisorName");
    private By applicant_incomeApplicant_previousEmploymentStatusIdInput = By.id("applicant_incomeApplicant_previousEmploymentStatusId");
    private By applicant_incomeApplicant_previousPositionDepartmentInput = By.id("applicant_incomeApplicant_previousPositionDepartment");
    private By applicant_incomeApplicant_previousYearsAtJobInput = By.id("applicant_incomeApplicant_previousYearsAtJob");
    private By applicant_incomeApplicant_previousMonthsAtJobInput = By.id("applicant_incomeApplicant_previousMonthsAtJob");
    private By applicant_incomeApplicant_previousGrossIncomeInput = By.id("applicant_incomeApplicant_previousGrossIncome");
    private By applicant_incomeApplicant_previousFrequencyIdInput = By.id("applicant_incomeApplicant_previousFrequencyId");
    /******Additional income source information****/
    private By applicant_incomeApplicant_otherEmployerNameInput = By.id("applicant_incomeApplicant_otherEmployerName");
    private By applicant_incomeApplicant_otherWorkPhoneNumberInput = By.id("applicant_incomeApplicant_otherWorkPhoneNumber");
    private By applicant_incomeApplicant_otherExtInput = By.id("applicant_incomeApplicant_otherExt");
    private By applicant_incomeApplicant_otherHomeAddressInput = By.id("applicant_incomeApplicant_otherHomeAddress");
    private By applicant_incomeApplicant_otherHomeAddressLine2Input = By.id("applicant_incomeApplicant_otherHomeAddressLine2");
    private By applicant_incomeApplicant_otherHomeSuiteNumberInput = By.id("applicant_incomeApplicant_otherHomeSuiteNumber");
    private By applicant_incomeApplicant_otherZipCodeInput = By.id("applicant_incomeApplicant_otherZipCode");
    private By applicant_incomeApplicant_otherSupervisorNameInput = By.id("applicant_incomeApplicant_otherSupervisorName");
    private By applicant_incomeApplicant_otherEmploymentStatusIdInput = By.id("applicant_incomeApplicant_otherEmploymentStatusId");
    private By applicant_incomeApplicant_otherPositionDepartmentInput = By.id("applicant_incomeApplicant_otherPositionDepartment");
    private By applicant_incomeApplicant_otherYearsAtJobInput = By.id("applicant_incomeApplicant_otherYearsAtJob");
    private By applicant_incomeApplicant_otherMonthsAtJobInput = By.id("applicant_incomeApplicant_otherMonthsAtJob");
    private By applicant_incomeApplicant_otherGrossIncomeInput = By.id("applicant_incomeApplicant_otherGrossIncome");
    private By applicant_incomeApplicant_otherFrequencyIdInput = By.id("applicant_incomeApplicant_otherFrequencyId");
    private By applicant_incomeApplicant_otherProvinceInput = By.id("applicant_incomeApplicant_otherProvince");

    public ApplicantExtraFieldsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setCurrentlyBankruptcyCheckBoxCheckBox() {
        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(currentlyBankruptcyCheckBox)).click().perform();
    }

    public void setPreviousResidenceInformationCheckBox() {
        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(previousResidenceInformationCheckBox)).click().perform();
    }

    public void setAdditionalResidenceInformationCheckBox() {
        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(additionalResidenceInformationCheckBox)).click().perform();
    }

    public void setPreviousIncomeSourceCheckBox() {
        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(previousIncomeSourceCheckBox)).click().perform();
    }

    public void setAdditionalIncomeSourceCheckBox() {
        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(additionalIncomeSourceCheckBox)).click().perform();
    }

    public void setApplicant_previousHomeAddressInput(String applicant_previousHomeAddress) {
        driver.findElement(applicant_previousHomeAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_previousHomeAddressInput).sendKeys(applicant_previousHomeAddress);
    }

    public void setApplicant_previousHomeAddressLine2Input(String applicant_previousHomeAddressLine2) {
        driver.findElement(applicant_previousHomeAddressLine2Input).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_previousHomeAddressLine2Input).sendKeys(applicant_previousHomeAddressLine2);
    }

    public void setApplicant_previousZipCodeInput(String applicant_previousZipCode) {
        driver.findElement(applicant_previousZipCodeInput).sendKeys(applicant_previousZipCode);
        driver.findElement(applicant_previousZipCodeInput).sendKeys(Keys.ENTER);
    }

    public void setApplicant_previousYearsAtAddressInput(String applicant_previousYearsAtAddress) {
        driver.findElement(applicant_previousYearsAtAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_previousYearsAtAddressInput).sendKeys(applicant_previousYearsAtAddress);
    }

    public void setApplicant_previousMonthsAtAddressInput(String applicant_previousMonthsAtAddress) {
        driver.findElement(applicant_previousMonthsAtAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_previousMonthsAtAddressInput).sendKeys(applicant_previousMonthsAtAddress);
    }

    public void setApplicant_previousHousingStatusIdInput(String applicant_previousHousingStatusId) {
        driver.findElement(applicant_previousHousingStatusIdInput).click();
        driver.findElement(applicant_previousHousingStatusIdInput).sendKeys(Keys.ENTER);
    }

    public void setApplicant_previousMonthlyPaymentInput(String applicant_previousMonthlyPayment) {
        driver.findElement(applicant_previousMonthlyPaymentInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_previousMonthlyPaymentInput).sendKeys(applicant_previousMonthlyPayment);
    }

    public void setApplicant_anotherHomeAddressInput(String applicant_anotherHomeAddress) {
        driver.findElement(applicant_anotherHomeAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_anotherHomeAddressInput).sendKeys(applicant_anotherHomeAddress);
    }

    public void setApplicant_anotherHomeAddressLine2Input(String applicant_anotherHomeAddressLine2) {
        driver.findElement(applicant_anotherHomeAddressLine2Input).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_anotherHomeAddressLine2Input).sendKeys(applicant_anotherHomeAddressLine2);
    }

    public void setApplicant_anotherZipCodeInput(String applicant_anotherZipCode) {
        driver.findElement(applicant_anotherZipCodeInput).sendKeys(applicant_anotherZipCode);
        driver.findElement(applicant_anotherZipCodeInput).sendKeys(Keys.ENTER);
    }

    public void setApplicant_anotherYearsAtAddressInput(String applicant_anotherYearsAtAddress) {
        driver.findElement(applicant_anotherYearsAtAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_anotherYearsAtAddressInput).sendKeys(applicant_anotherYearsAtAddress);
    }

    public void setApplicant_anotherMonthsAtAddressInput(String applicant_anotherMonthsAtAddress) {
        driver.findElement(applicant_anotherMonthsAtAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_anotherMonthsAtAddressInput).sendKeys(applicant_anotherMonthsAtAddress);
    }

    public void setApplicant_anotherHousingStatusIdInput(String applicant_anotherHousingStatusId) {
        driver.findElement(applicant_anotherHousingStatusIdInput).click();
        driver.findElement(applicant_anotherHousingStatusIdInput).sendKeys(Keys.ENTER);
    }

    public void setApplicant_anotherMonthlyPaymentInput(String applicant_anotherMonthlyPayment) {
        driver.findElement(applicant_anotherMonthlyPaymentInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_anotherMonthlyPaymentInput).sendKeys(applicant_anotherMonthlyPayment);
    }

    public void setApplicant_incomeApplicant_previousEmployerNameInput(String applicant_incomeApplicant_previousEmployerName) {
        driver.findElement(applicant_incomeApplicant_previousEmployerNameInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_previousEmployerNameInput).sendKeys(applicant_incomeApplicant_previousEmployerName);
    }

    public void setApplicant_incomeApplicant_previousWorkPhoneNumberInput(String applicant_incomeApplicant_previousWorkPhoneNumber) {
        driver.findElement(applicant_incomeApplicant_previousWorkPhoneNumberInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_previousWorkPhoneNumberInput).sendKeys(applicant_incomeApplicant_previousWorkPhoneNumber);
    }

    public void setApplicant_incomeApplicant_previousExtInput(String applicant_incomeApplicant_previousExt) {
        driver.findElement(applicant_incomeApplicant_previousExtInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_previousExtInput).sendKeys(applicant_incomeApplicant_previousExt);
    }

    public void setApplicant_incomeApplicant_previousHomeAddressInput(String applicant_incomeApplicant_previousHomeAddress) {
        driver.findElement(applicant_incomeApplicant_previousHomeAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_previousHomeAddressInput).sendKeys(applicant_incomeApplicant_previousHomeAddress);
    }

    public void setApplicant_incomeApplicant_previousHomeAddressLine2Input(String applicant_incomeApplicant_previousHomeAddressLine2) {
        driver.findElement(applicant_incomeApplicant_previousHomeAddressLine2Input).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_previousHomeAddressLine2Input).sendKeys(applicant_incomeApplicant_previousHomeAddressLine2);
    }

    public void setApplicant_incomeApplicant_previousHomeSuiteNumberInput(String applicant_incomeApplicant_previousHomeSuiteNumber) {
        driver.findElement(applicant_incomeApplicant_previousHomeSuiteNumberInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_previousHomeSuiteNumberInput).sendKeys(applicant_incomeApplicant_previousHomeSuiteNumber);
    }

    public void setApplicant_incomeApplicant_previousZipCodeInput(String applicant_incomeApplicant_previousZipCode) {
        driver.findElement(applicant_incomeApplicant_previousZipCodeInput).sendKeys(applicant_incomeApplicant_previousZipCode);
        driver.findElement(applicant_incomeApplicant_previousZipCodeInput).sendKeys(Keys.ENTER);
    }

    public void setApplicant_incomeApplicant_previousSupervisorNameInput(String applicant_incomeApplicant_previousSupervisorName) {
        driver.findElement(applicant_incomeApplicant_previousSupervisorNameInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_previousSupervisorNameInput).sendKeys(applicant_incomeApplicant_previousSupervisorName);
    }

    public void setApplicant_incomeApplicant_previousEmploymentStatusIdInput(String applicant_incomeApplicant_previousEmploymentStatusId) {
        driver.findElement(applicant_incomeApplicant_previousEmploymentStatusIdInput).click();
        driver.findElement(applicant_incomeApplicant_previousEmploymentStatusIdInput).sendKeys(Keys.ENTER);
    }

    public void setApplicant_incomeApplicant_previousPositionDepartmentInput(String applicant_incomeApplicant_previousPositionDepartment) {
        driver.findElement(applicant_incomeApplicant_previousPositionDepartmentInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_previousPositionDepartmentInput).sendKeys(applicant_incomeApplicant_previousPositionDepartment);
    }

    public void setApplicant_incomeApplicant_previousYearsAtJobInput(String applicant_incomeApplicant_previousYearsAtJob) {
        driver.findElement(applicant_incomeApplicant_previousYearsAtJobInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_previousYearsAtJobInput).sendKeys(applicant_incomeApplicant_previousYearsAtJob);
    }

    public void setApplicant_incomeApplicant_previousMonthsAtJobInput(String applicant_incomeApplicant_previousMonthsAtJob) {
        driver.findElement(applicant_incomeApplicant_previousMonthsAtJobInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_previousMonthsAtJobInput).sendKeys(applicant_incomeApplicant_previousMonthsAtJob);
    }

    public void setApplicant_incomeApplicant_previousGrossIncomeInput(String applicant_incomeApplicant_previousGrossIncome) {
        driver.findElement(applicant_incomeApplicant_previousGrossIncomeInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_previousGrossIncomeInput).sendKeys(applicant_incomeApplicant_previousGrossIncome);
    }

    public void setApplicant_incomeApplicant_previousFrequencyIdInput(String applicant_incomeApplicant_previousFrequencyId) {
        driver.findElement(applicant_incomeApplicant_previousFrequencyIdInput).click();
        driver.findElement(applicant_incomeApplicant_previousFrequencyIdInput).sendKeys(Keys.ENTER);
    }

    public void setApplicant_incomeApplicant_otherEmployerNameInput(String applicant_incomeApplicant_otherEmployerName) {
        driver.findElement(applicant_incomeApplicant_otherEmployerNameInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_otherEmployerNameInput).sendKeys(applicant_incomeApplicant_otherEmployerName);
    }

    public void setApplicant_incomeApplicant_otherWorkPhoneNumberInput(String applicant_incomeApplicant_otherWorkPhoneNumber) {
        driver.findElement(applicant_incomeApplicant_otherWorkPhoneNumberInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_otherWorkPhoneNumberInput).sendKeys(applicant_incomeApplicant_otherWorkPhoneNumber);
    }

    public void setApplicant_incomeApplicant_otherExtInput(String applicant_incomeApplicant_otherExt) {
        driver.findElement(applicant_incomeApplicant_otherExtInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_otherExtInput).sendKeys(applicant_incomeApplicant_otherExt);
    }

    public void setApplicant_incomeApplicant_otherHomeAddressInput(String applicant_incomeApplicant_otherHomeAddress) {
        driver.findElement(applicant_incomeApplicant_otherHomeAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_otherHomeAddressInput).sendKeys(applicant_incomeApplicant_otherHomeAddress);
    }

    public void setApplicant_incomeApplicant_otherHomeAddressLine2Input(String applicant_incomeApplicant_otherHomeAddressLine2) {
        driver.findElement(applicant_incomeApplicant_otherHomeAddressLine2Input).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_otherHomeAddressLine2Input).sendKeys(applicant_incomeApplicant_otherHomeAddressLine2);
    }

    public void setApplicant_incomeApplicant_otherHomeSuiteNumberInput(String applicant_incomeApplicant_otherHomeSuiteNumber) {
        driver.findElement(applicant_incomeApplicant_otherHomeSuiteNumberInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_otherHomeSuiteNumberInput).sendKeys(applicant_incomeApplicant_otherHomeSuiteNumber);
    }

    public void setApplicant_incomeApplicant_otherZipCodeInput(String applicant_incomeApplicant_otherZipCode) {
        driver.findElement(applicant_incomeApplicant_otherZipCodeInput).sendKeys(applicant_incomeApplicant_otherZipCode);
        driver.findElement(applicant_incomeApplicant_otherZipCodeInput).sendKeys(Keys.ENTER);

    }

    public void setApplicant_incomeApplicant_otherSupervisorNameInput(String applicant_incomeApplicant_otherSupervisorName) {
        driver.findElement(applicant_incomeApplicant_otherSupervisorNameInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_otherSupervisorNameInput).sendKeys(applicant_incomeApplicant_otherSupervisorName);
    }

    public void setApplicant_incomeApplicant_otherEmploymentStatusIdInput(String applicant_incomeApplicant_otherEmploymentStatusId) {
        driver.findElement(applicant_incomeApplicant_otherEmploymentStatusIdInput).click();
        driver.findElement(applicant_incomeApplicant_otherEmploymentStatusIdInput).sendKeys(Keys.ENTER);
    }

    public void setApplicant_incomeApplicant_otherPositionDepartmentInput(String applicant_incomeApplicant_otherPositionDepartment) {
        driver.findElement(applicant_incomeApplicant_otherPositionDepartmentInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_otherPositionDepartmentInput).sendKeys(applicant_incomeApplicant_otherPositionDepartment);
    }

    public void setApplicant_incomeApplicant_otherYearsAtJobInput(String applicant_incomeApplicant_otherYearsAtJob) {
        driver.findElement(applicant_incomeApplicant_otherYearsAtJobInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_otherYearsAtJobInput).sendKeys(applicant_incomeApplicant_otherYearsAtJob);
    }

    public void setApplicant_incomeApplicant_otherMonthsAtJobInput(String applicant_incomeApplicant_otherMonthsAtJob) {
        driver.findElement(applicant_incomeApplicant_otherMonthsAtJobInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_otherMonthsAtJobInput).sendKeys(applicant_incomeApplicant_otherMonthsAtJob);
    }

    public void setApplicant_incomeApplicant_otherGrossIncomeInput(String applicant_incomeApplicant_otherGrossIncome) {
        driver.findElement(applicant_incomeApplicant_otherGrossIncomeInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_otherGrossIncomeInput).sendKeys(applicant_incomeApplicant_otherGrossIncome);
    }

    public void setApplicant_incomeApplicant_otherFrequencyIdInput(String applicant_incomeApplicant_otherFrequencyId) {
        driver.findElement(applicant_incomeApplicant_otherFrequencyIdInput).click();
        driver.findElement(applicant_incomeApplicant_otherFrequencyIdInput).sendKeys(Keys.ENTER);
    }

    public void setApplicant_incomeApplicant_otherProvinceInput(String applicant_incomeApplicant_otherProvince) {
        driver.findElement(applicant_incomeApplicant_otherProvinceInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(applicant_incomeApplicant_otherProvinceInput).sendKeys(applicant_incomeApplicant_otherProvince);
    }
}
