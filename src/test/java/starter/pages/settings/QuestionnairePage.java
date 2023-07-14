package starter.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class QuestionnairePage {

    private WebDriver driver;


    private By nameLenderInput = By.id("nameLender");
    private By contactNameInput = By.id("contactName");
    private By phoneInput = By.id("phone");
    private By emailInput = By.id("email");
    private By numberBranchesInput = By.id("numberBranches");
    private By currentSoftwareUseInput = By.id("currentSoftwareUse");
    private By locationUnderwritingInput = By.id("locationUnderwriting");
    private By corporateOfficeAddressInput = By.id("corporateOfficeAddress");
    private By numberDealersInput = By.id("numberDealers");
    private By avgLoansMonthInput = By.id("avgLoansMonth");
    private By growthObjectiveInput = By.id("growthObjective");
    private By onlineApplicationInput = By.id("onlineApplication");
    private By provideEcontractInput = By.id("provideEcontract");
    private By productOffertInput = By.id("productOffer");
    private By companyToUsePullCreditInput = By.id("companyToUsePullCredit");
    private By nameofBankInput = By.id("nameofBank");
    private By stateBusinessInput = By.id("stateBusiness");
    private By autoRadioBtn = By.xpath("//*[contains(text(),'Auto')]");
    private By powerSportsBtn = By.xpath("//*[contains(text(),'Power Sports')]");
    private By otherTypeVehicleInput = By.id("otherTypeVehicle");
    private By maxPtiInput = By.id("maxPti");
    private By maxLtvInput = By.id("maxLtv");
    private By minIncomeInput = By.id("minIncome");
    private By minAmtFinanceInput = By.id("minAmtFinance");
    private By maxMilesInput = By.id("maxMiles");
    private By maxAgeOfVehicleInput = By.id("maxAgeOfVehicle");

    private By otherInput = By.id("other");

    private By submitBtn = By.xpath("(//*[contains(text(), 'Submit')])[2]");
    private By configurationOption = By.xpath("//*[contains(text(), 'Configuration')]");
    private By questionnaireOption = By.xpath("//*[contains(text(), 'Questionnaire')]");
    private By companyOption = By.xpath("//*[contains(text(), 'Company')]");
    private By choosePlanOption = By.xpath("(//*[contains(text(),'Choose this plan')])[1]");

    public QuestionnairePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setNameLenderInput(String nameLender) {
        driver.findElement(nameLenderInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(nameLenderInput).sendKeys(nameLender);
    }

    public void setContactNameInput(String contactName) {
        driver.findElement(contactNameInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(contactNameInput).sendKeys(contactName);
    }

    public void setPhoneInput(String phone) {
        driver.findElement(phoneInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(phoneInput).sendKeys(phone);

    }

    public void setEmailInput(String email) {
        driver.findElement(emailInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setNumberBranchesInput(String numberBranches) {
        driver.findElement(numberBranchesInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(numberBranchesInput).sendKeys(numberBranches);
    }

    public void setCurrentSoftwareUseInput(String currentSoftwareUse) {
        driver.findElement(currentSoftwareUseInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(currentSoftwareUseInput).sendKeys(currentSoftwareUse);
    }

    public void setLocationUnderwritingInput(String locationUnderwriting) {
        driver.findElement(locationUnderwritingInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(locationUnderwritingInput).sendKeys(locationUnderwriting);
    }

    public void setCorporateOfficeAddressInput(String corporateOfficeAddress) {
        driver.findElement(corporateOfficeAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(corporateOfficeAddressInput).sendKeys(corporateOfficeAddress);
    }

    public void setNumberDealersInput(String numberDealers) {
        driver.findElement(numberDealersInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(numberDealersInput).sendKeys(numberDealers);
    }

    public void setAvgLoansMonthInput(String avgLoansMonth) {
        driver.findElement(avgLoansMonthInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(avgLoansMonthInput).sendKeys(avgLoansMonth);
    }

    public void setGrowthObjectiveInput(String growthObjective) {
        driver.findElement(growthObjectiveInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(growthObjectiveInput).sendKeys(growthObjective);
    }

    public void setOnlineApplicationInput(String onlineApplication) {
        driver.findElement(onlineApplicationInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(onlineApplicationInput).sendKeys(onlineApplication);
    }

    public void setProvideEcontractInput(String provideEcontract) {
        driver.findElement(provideEcontractInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(provideEcontractInput).sendKeys(provideEcontract);
    }

    public void setProductOffertInput(String productOffert) {
        driver.findElement(productOffertInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(productOffertInput).sendKeys(productOffert);
    }

    public void setCompanyToUsePullCreditInput(String companyToUsePullCredit) {
        driver.findElement(companyToUsePullCreditInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(companyToUsePullCreditInput).sendKeys(companyToUsePullCredit);
    }

    public void setNameofBankInput(String nameofBank) {
        driver.findElement(nameofBankInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(nameofBankInput).sendKeys(nameofBank);
    }

    public void setStateBusinessInput(String stateBusiness) {
        driver.findElement(stateBusinessInput).click();
        driver.findElement(stateBusinessInput).sendKeys(Keys.ENTER);
    }

    public void setAutoRadioBtn() {
        driver.findElement(autoRadioBtn).click();
    }

    public void setPowerSportsRadioBtn() {
        driver.findElement(powerSportsBtn).click();
    }

    public void setOtherTypeVehicleInput(String otherTypeVehicle) {
        driver.findElement(otherTypeVehicleInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(otherTypeVehicleInput).sendKeys(otherTypeVehicle);
    }

    public void setMaxPtiInput(String maxPti) {
        driver.findElement(maxPtiInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(maxPtiInput).sendKeys(maxPti);
    }

    public void setMaxLtvInput(String maxLtv) {
        driver.findElement(maxLtvInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(maxLtvInput).sendKeys(maxLtv);
    }

    public void setMinIncomeInput(String minIncome) {
        driver.findElement(minIncomeInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(minIncomeInput).sendKeys(minIncome);
    }

    public void setMinAmtFinanceInput(String minAmtFinance) {
        driver.findElement(minAmtFinanceInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(minAmtFinanceInput).sendKeys(minAmtFinance);
    }

    public void setMaxMilesInput(String maxMiles) {
        driver.findElement(maxMilesInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(maxMilesInput).sendKeys(maxMiles);
    }


    public void setMaxAgeOfVehicleInput(String maxAgeOfVehicle) {
        driver.findElement(maxAgeOfVehicleInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(maxAgeOfVehicleInput).sendKeys(maxAgeOfVehicle);
    }

    public void setOtherInput(String other) {
        driver.findElement(otherInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(otherInput).sendKeys(other);
    }

    public void clickOnSubmit() {
        driver.findElement(submitBtn).click();
    }

    public void clickOnConfiguration() {
        driver.findElement(configurationOption).click();

    }

    public void clickOnQuestionnaire() {
        driver.findElement(questionnaireOption).click();

    }

    public void clickOnCompany() {
        driver.findElement(companyOption).click();
    }

    public void clickOnChoosePlan() {
        {
            driver.findElement(choosePlanOption).click();
        }
    }
}
