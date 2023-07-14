package starter.pages.applications;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import starter.utils.WebAction;

import java.rmi.activation.ActivationInstantiator;

public class CoApplicantExtraFieldsPage {

    private WebDriver driver;


    private By currentlyBankruptcyCheckBox = By.xpath("((//span[contains(text(),'Currently in bankruptcy')])[2]//preceding::input)[last()]");
    private By previousResidenceInformationCheckBox = By.xpath("((//span[contains(text(),'Previous residence information')])[2]//preceding::input)[last()]");
    private By additionalResidenceInformationCheckBox = By.xpath("((//span[contains(text(),'Additional residence information')])[2]//preceding::input)[last()]");
    private By previousIncomeSourceCheckBox = By.xpath("((//span[contains(text(),'Previous income source')])[2]//preceding::input)[last()]");
    private By additionalIncomeSourceCheckBox = By.xpath("((//span[contains(text(),'Additional income source')])[2]//preceding::input)[last()]");

    /******Previous residence information**********/
    private By coApplicant_previousHomeAddressInput = By.id("coApplicant_previousHomeAddress");
    private By coApplicant_previousHomeAddressLine2Input = By.id("coApplicant_previousHomeAddressLine2");
    private By coApplicant_previousZipCodeInput = By.id("coApplicant_previousZipCode");
    private By coApplicant_previousYearsAtAddressInput = By.id("coApplicant_previousYearsAtAddress");
    private By coApplicant_previousMonthsAtAddressInput = By.id("coApplicant_previousMonthsAtAddress");
    private By coApplicant_previousHousingStatusIdInput = By.id("coApplicant_previousHousingStatusId");
    private By coApplicant_previousMonthlyPaymentInput = By.id("coApplicant_previousMonthlyPayment");
    /******Additional residence information**********/
    private By coApplicant_anotherHomeAddressInput = By.id("coApplicant_anotherHomeAddress");
    private By coApplicant_anotherHomeAddressLine2Input = By.id("coApplicant_anotherHomeAddressLine2");
    private By coApplicant_anotherZipCodeInput = By.id("coApplicant_anotherZipCode");
    private By coApplicant_anotherYearsAtAddressInput = By.id("coApplicant_anotherYearsAtAddress");
    private By coApplicant_anotherMonthsAtAddressInput = By.id("coApplicant_anotherMonthsAtAddress");
    private By coApplicant_anotherHousingStatusIdInput = By.id("coApplicant_anotherHousingStatusId");
    private By coApplicant_anotherMonthlyPaymentInput = By.id("coApplicant_anotherMonthlyPayment");
    /******Previous income source information****/
    private By coApplicant_incomeApplicant_previousEmployerNameInput = By.id("coApplicant_incomeApplicant_previousEmployerName");
    private By coApplicant_incomeApplicant_previousWorkPhoneNumberInput = By.id("coApplicant_incomeApplicant_previousWorkPhoneNumber");
    private By coApplicant_incomeApplicant_previousExtInput = By.id("coApplicant_incomeApplicant_previousExt");
    private By coApplicant_incomeApplicant_previousHomeAddressInput = By.id("coApplicant_incomeApplicant_previousHomeAddress");
    private By coApplicant_incomeApplicant_previousHomeAddressLine2Input = By.id("coApplicant_incomeApplicant_previousHomeAddressLine2");
    private By coApplicant_incomeApplicant_previousHomeSuiteNumberInput = By.id("coApplicant_incomeApplicant_previousHomeSuiteNumber");
    private By coApplicant_incomeApplicant_previousZipCodeInput = By.id("coApplicant_incomeApplicant_previousZipCode");
    private By coApplicant_incomeApplicant_previousSupervisorNameInput = By.id("coApplicant_incomeApplicant_previousSupervisorName");
    private By coApplicant_incomeApplicant_previousEmploymentStatusIdInput = By.id("coApplicant_incomeApplicant_previousEmploymentStatusId");
    private By coApplicant_incomeApplicant_previousPositionDepartmentInput = By.id("coApplicant_incomeApplicant_previousPositionDepartment");
    private By coApplicant_incomeApplicant_previousYearsAtJobInput = By.id("coApplicant_incomeApplicant_previousYearsAtJob");
    private By coApplicant_incomeApplicant_previousMonthsAtJobInput = By.id("coApplicant_incomeApplicant_previousMonthsAtJob");
    private By coApplicant_incomeApplicant_previousGrossIncomeInput = By.id("coApplicant_incomeApplicant_previousGrossIncome");
    private By coApplicant_incomeApplicant_previousFrequencyIdInput = By.id("coApplicant_incomeApplicant_previousFrequencyId");
    /******Additional income source information****/
    private By coApplicant_incomeApplicant_otherEmployerNameInput = By.id("coApplicant_incomeApplicant_otherEmployerName");
    private By coApplicant_incomeApplicant_otherWorkPhoneNumberInput = By.id("coApplicant_incomeApplicant_otherWorkPhoneNumber");
    private By coApplicant_incomeApplicant_otherExtInput = By.id("coApplicant_incomeApplicant_otherExt");
    private By coApplicant_incomeApplicant_otherHomeAddressInput = By.id("coApplicant_incomeApplicant_otherHomeAddress");
    private By coApplicant_incomeApplicant_otherHomeAddressLine2Input = By.id("coApplicant_incomeApplicant_otherHomeAddressLine2");
    private By coApplicant_incomeApplicant_otherHomeSuiteNumberInput = By.id("coApplicant_incomeApplicant_otherHomeSuiteNumber");
    private By coApplicant_incomeApplicant_otherZipCodeInput = By.id("coApplicant_incomeApplicant_otherZipCode");
    private By coApplicant_incomeApplicant_otherSupervisorNameInput = By.id("coApplicant_incomeApplicant_otherSupervisorName");
    private By coApplicant_incomeApplicant_otherEmploymentStatusIdInput = By.id("coApplicant_incomeApplicant_otherEmploymentStatusId");
    private By coApplicant_incomeApplicant_otherPositionDepartmentInput = By.id("coApplicant_incomeApplicant_otherPositionDepartment");
    private By coApplicant_incomeApplicant_otherYearsAtJobInput = By.id("coApplicant_incomeApplicant_otherYearsAtJob");
    private By coApplicant_incomeApplicant_otherMonthsAtJobInput = By.id("coApplicant_incomeApplicant_otherMonthsAtJob");
    private By coApplicant_incomeApplicant_otherGrossIncomeInput = By.id("coApplicant_incomeApplicant_otherGrossIncome");
    private By coApplicant_incomeApplicant_otherFrequencyIdInput = By.id("coApplicant_incomeApplicant_otherFrequencyId");
    private By coApplicant_incomeApplicant_otherProvinceInput = By.id("coApplicant_incomeApplicant_otherProvince");

    public CoApplicantExtraFieldsPage(WebDriver driver) {
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

    public void setCoApplicant_previousHomeAddressInput(String coApplicant_previousHomeAddress) {
        driver.findElement(coApplicant_previousHomeAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_previousHomeAddressInput).sendKeys(coApplicant_previousHomeAddress);
    }

    public void setCoApplicant_previousHomeAddressLine2Input(String coApplicant_previousHomeAddressLine2) {
        driver.findElement(coApplicant_previousHomeAddressLine2Input).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_previousHomeAddressLine2Input).sendKeys(coApplicant_previousHomeAddressLine2);
    }

    public void setCoApplicant_previousZipCodeInput(String coApplicant_previousZipCode) {
        driver.findElement(coApplicant_previousZipCodeInput).sendKeys(coApplicant_previousZipCode);
        driver.findElement(coApplicant_previousZipCodeInput).sendKeys(Keys.ENTER);
    }

    public void setCoApplicant_previousYearsAtAddressInput(String coApplicant_previousYearsAtAddress) {
        driver.findElement(coApplicant_previousYearsAtAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_previousYearsAtAddressInput).sendKeys(coApplicant_previousYearsAtAddress);
    }

    public void setCoApplicant_previousMonthsAtAddressInput(String coApplicant_previousMonthsAtAddress) {
        driver.findElement(coApplicant_previousMonthsAtAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_previousMonthsAtAddressInput).sendKeys(coApplicant_previousMonthsAtAddress);
    }

    public void setCoApplicant_previousHousingStatusIdInput(String coApplicant_previousHousingStatusId) {
        driver.findElement(coApplicant_previousHousingStatusIdInput).click();
        driver.findElement(coApplicant_previousHousingStatusIdInput).sendKeys(Keys.ENTER);
    }

    public void setCoApplicant_previousMonthlyPaymentInput(String coApplicant_previousMonthlyPayment) {
        driver.findElement(coApplicant_previousMonthlyPaymentInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_previousMonthlyPaymentInput).sendKeys(coApplicant_previousMonthlyPayment);
    }

    public void setCoApplicant_anotherHomeAddressInput(String coApplicant_anotherHomeAddress) {
        driver.findElement(coApplicant_anotherHomeAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_anotherHomeAddressInput).sendKeys(coApplicant_anotherHomeAddress);
    }

    public void setCoApplicant_anotherHomeAddressLine2Input(String coApplicant_anotherHomeAddressLine2) {
        driver.findElement(coApplicant_anotherHomeAddressLine2Input).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_anotherHomeAddressLine2Input).sendKeys(coApplicant_anotherHomeAddressLine2);
    }

    public void setCoApplicant_anotherZipCodeInput(String coApplicant_anotherZipCode) {
        driver.findElement(coApplicant_anotherZipCodeInput).sendKeys(coApplicant_anotherZipCode);
        driver.findElement(coApplicant_anotherZipCodeInput).sendKeys(Keys.ENTER);
    }

    public void setCoApplicant_anotherYearsAtAddressInput(String coApplicant_anotherYearsAtAddress) {
        driver.findElement(coApplicant_anotherYearsAtAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_anotherYearsAtAddressInput).sendKeys(coApplicant_anotherYearsAtAddress);
    }

    public void setCoApplicant_anotherMonthsAtAddressInput(String coApplicant_anotherMonthsAtAddress) {
        driver.findElement(coApplicant_anotherMonthsAtAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_anotherMonthsAtAddressInput).sendKeys(coApplicant_anotherMonthsAtAddress);
    }

    public void setCoApplicant_anotherHousingStatusIdInput(String coApplicant_anotherHousingStatusId) {
        driver.findElement(coApplicant_anotherHousingStatusIdInput).click();
        driver.findElement(coApplicant_anotherHousingStatusIdInput).sendKeys(Keys.ENTER);
    }

    public void setCoApplicant_anotherMonthlyPaymentInput(String coApplicant_anotherMonthlyPayment) {
        driver.findElement(coApplicant_anotherMonthlyPaymentInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_anotherMonthlyPaymentInput).sendKeys(coApplicant_anotherMonthlyPayment);
    }

    public void setCoApplicant_incomeApplicant_previousEmployerNameInput(String coApplicant_incomeApplicant_previousEmployerName) {
        driver.findElement(coApplicant_incomeApplicant_previousEmployerNameInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_previousEmployerNameInput).sendKeys(coApplicant_incomeApplicant_previousEmployerName);
    }

    public void setCoApplicant_incomeApplicant_previousWorkPhoneNumberInput(String coApplicant_incomeApplicant_previousWorkPhoneNumber) {
        driver.findElement(coApplicant_incomeApplicant_previousWorkPhoneNumberInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_previousWorkPhoneNumberInput).sendKeys(coApplicant_incomeApplicant_previousWorkPhoneNumber);
    }

    public void setCoApplicant_incomeApplicant_previousExtInput(String coApplicant_incomeApplicant_previousExt) {
        driver.findElement(coApplicant_incomeApplicant_previousExtInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_previousExtInput).sendKeys(coApplicant_incomeApplicant_previousExt);
    }

    public void setCoApplicant_incomeApplicant_previousHomeAddressInput(String coApplicant_incomeApplicant_previousHomeAddress) {
        driver.findElement(coApplicant_incomeApplicant_previousHomeAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_previousHomeAddressInput).sendKeys(coApplicant_incomeApplicant_previousHomeAddress);
    }

    public void setCoApplicant_incomeApplicant_previousHomeAddressLine2Input(String coApplicant_incomeApplicant_previousHomeAddressLine2) {
        driver.findElement(coApplicant_incomeApplicant_previousHomeAddressLine2Input).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_previousHomeAddressLine2Input).sendKeys(coApplicant_incomeApplicant_previousHomeAddressLine2);
    }

    public void setCoApplicant_incomeApplicant_previousHomeSuiteNumberInput(String coApplicant_incomeApplicant_previousHomeSuiteNumber) {
        driver.findElement(coApplicant_incomeApplicant_previousHomeSuiteNumberInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_previousHomeSuiteNumberInput).sendKeys(coApplicant_incomeApplicant_previousHomeSuiteNumber);
    }

    public void setCoApplicant_incomeApplicant_previousZipCodeInput(String coApplicant_incomeApplicant_previousZipCode) {
        driver.findElement(coApplicant_incomeApplicant_previousZipCodeInput).sendKeys(coApplicant_incomeApplicant_previousZipCode);
        driver.findElement(coApplicant_incomeApplicant_previousZipCodeInput).sendKeys(Keys.ENTER);
    }

    public void setCoApplicant_incomeApplicant_previousSupervisorNameInput(String coApplicant_incomeApplicant_previousSupervisorName) {
        driver.findElement(coApplicant_incomeApplicant_previousSupervisorNameInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_previousSupervisorNameInput).sendKeys(coApplicant_incomeApplicant_previousSupervisorName);
    }

    public void setCoApplicant_incomeApplicant_previousEmploymentStatusIdInput(String coApplicant_incomeApplicant_previousEmploymentStatusId) {
        driver.findElement(coApplicant_incomeApplicant_previousEmploymentStatusIdInput).click();
        driver.findElement(coApplicant_incomeApplicant_previousEmploymentStatusIdInput).sendKeys(Keys.ENTER);
    }

    public void setCoApplicant_incomeApplicant_previousPositionDepartmentInput(String coApplicant_incomeApplicant_previousPositionDepartment) {
        driver.findElement(coApplicant_incomeApplicant_previousPositionDepartmentInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_previousPositionDepartmentInput).sendKeys(coApplicant_incomeApplicant_previousPositionDepartment);
    }

    public void setCoApplicant_incomeApplicant_previousYearsAtJobInput(String coApplicant_incomeApplicant_previousYearsAtJob) {
        driver.findElement(coApplicant_incomeApplicant_previousYearsAtJobInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_previousYearsAtJobInput).sendKeys(coApplicant_incomeApplicant_previousYearsAtJob);
    }

    public void setCoApplicant_incomeApplicant_previousMonthsAtJobInput(String coApplicant_incomeApplicant_previousMonthsAtJob) {
        driver.findElement(coApplicant_incomeApplicant_previousMonthsAtJobInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_previousMonthsAtJobInput).sendKeys(coApplicant_incomeApplicant_previousMonthsAtJob);
    }

    public void setCoApplicant_incomeApplicant_previousGrossIncomeInput(String coApplicant_incomeApplicant_previousGrossIncome) {
        driver.findElement(coApplicant_incomeApplicant_previousGrossIncomeInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_previousGrossIncomeInput).sendKeys(coApplicant_incomeApplicant_previousGrossIncome);
    }

    public void setCoApplicant_incomeApplicant_previousFrequencyIdInput(String coApplicant_incomeApplicant_previousFrequencyId) {
        driver.findElement(coApplicant_incomeApplicant_previousFrequencyIdInput).click();
        driver.findElement(coApplicant_incomeApplicant_previousFrequencyIdInput).sendKeys(Keys.ENTER);
    }

    public void setCoApplicant_incomeApplicant_otherEmployerNameInput(String coApplicant_incomeApplicant_otherEmployerName) {
        driver.findElement(coApplicant_incomeApplicant_otherEmployerNameInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_otherEmployerNameInput).sendKeys(coApplicant_incomeApplicant_otherEmployerName);
    }

    public void setCoApplicant_incomeApplicant_otherWorkPhoneNumberInput(String coApplicant_incomeApplicant_otherWorkPhoneNumber) {
        driver.findElement(coApplicant_incomeApplicant_otherWorkPhoneNumberInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_otherWorkPhoneNumberInput).sendKeys(coApplicant_incomeApplicant_otherWorkPhoneNumber);
    }

    public void setCoApplicant_incomeApplicant_otherExtInput(String coApplicant_incomeApplicant_otherExt) {
        driver.findElement(coApplicant_incomeApplicant_otherExtInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_otherExtInput).sendKeys(coApplicant_incomeApplicant_otherExt);
    }

    public void setCoApplicant_incomeApplicant_otherHomeAddressInput(String coApplicant_incomeApplicant_otherHomeAddress) {
        driver.findElement(coApplicant_incomeApplicant_otherHomeAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_otherHomeAddressInput).sendKeys(coApplicant_incomeApplicant_otherHomeAddress);
    }

    public void setCoApplicant_incomeApplicant_otherHomeAddressLine2Input(String coApplicant_incomeApplicant_otherHomeAddressLine2) {
        driver.findElement(coApplicant_incomeApplicant_otherHomeAddressLine2Input).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_otherHomeAddressLine2Input).sendKeys(coApplicant_incomeApplicant_otherHomeAddressLine2);
    }

    public void setCoApplicant_incomeApplicant_otherHomeSuiteNumberInput(String coApplicant_incomeApplicant_otherHomeSuiteNumber) {
        driver.findElement(coApplicant_incomeApplicant_otherHomeSuiteNumberInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_otherHomeSuiteNumberInput).sendKeys(coApplicant_incomeApplicant_otherHomeSuiteNumber);
    }

    public void setCoApplicant_incomeApplicant_otherZipCodeInput(String coApplicant_incomeApplicant_otherZipCode) {
        driver.findElement(coApplicant_incomeApplicant_otherZipCodeInput).sendKeys(coApplicant_incomeApplicant_otherZipCode);
        driver.findElement(coApplicant_incomeApplicant_otherZipCodeInput).sendKeys(Keys.ENTER);

    }

    public void setCoApplicant_incomeApplicant_otherSupervisorNameInput(String coApplicant_incomeApplicant_otherSupervisorName) {
        driver.findElement(coApplicant_incomeApplicant_otherSupervisorNameInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_otherSupervisorNameInput).sendKeys(coApplicant_incomeApplicant_otherSupervisorName);
    }

    public void setCoApplicant_incomeApplicant_otherEmploymentStatusIdInput(String coApplicant_incomeApplicant_otherEmploymentStatusId) {
        driver.findElement(coApplicant_incomeApplicant_otherEmploymentStatusIdInput).click();
        driver.findElement(coApplicant_incomeApplicant_otherEmploymentStatusIdInput).sendKeys(Keys.ENTER);
    }

    public void setCoApplicant_incomeApplicant_otherPositionDepartmentInput(String coApplicant_incomeApplicant_otherPositionDepartment) {
        driver.findElement(coApplicant_incomeApplicant_otherPositionDepartmentInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_otherPositionDepartmentInput).sendKeys(coApplicant_incomeApplicant_otherPositionDepartment);
    }

    public void setCoApplicant_incomeApplicant_otherYearsAtJobInput(String coApplicant_incomeApplicant_otherYearsAtJob) {
        driver.findElement(coApplicant_incomeApplicant_otherYearsAtJobInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_otherYearsAtJobInput).sendKeys(coApplicant_incomeApplicant_otherYearsAtJob);
    }

    public void setCoApplicant_incomeApplicant_otherMonthsAtJobInput(String coApplicant_incomeApplicant_otherMonthsAtJob) {
        driver.findElement(coApplicant_incomeApplicant_otherMonthsAtJobInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_otherMonthsAtJobInput).sendKeys(coApplicant_incomeApplicant_otherMonthsAtJob);
    }

    public void setCoApplicant_incomeApplicant_otherGrossIncomeInput(String coApplicant_incomeApplicant_otherGrossIncome) {
        driver.findElement(coApplicant_incomeApplicant_otherGrossIncomeInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_otherGrossIncomeInput).sendKeys(coApplicant_incomeApplicant_otherGrossIncome);
    }

    public void setCoApplicant_incomeApplicant_otherFrequencyIdInput(String coApplicant_incomeApplicant_otherFrequencyId) {
        driver.findElement(coApplicant_incomeApplicant_otherFrequencyIdInput).click();
        driver.findElement(coApplicant_incomeApplicant_otherFrequencyIdInput).sendKeys(Keys.ENTER);
    }

    public void setCoApplicant_incomeApplicant_otherProvinceInput(String coApplicant_incomeApplicant_otherProvince) {
        driver.findElement(coApplicant_incomeApplicant_otherProvinceInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(coApplicant_incomeApplicant_otherProvinceInput).sendKeys(coApplicant_incomeApplicant_otherProvince);
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
}
