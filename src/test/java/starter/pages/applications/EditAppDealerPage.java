package starter.pages.applications;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import starter.utils.WebAction;

public class EditAppDealerPage {

    private WebDriver driver;
    private By frequencyInput = By.xpath("(//span[contains(@title,'Monthly')])[1]");
    private By weeklyItem = By.xpath("//*[contains(@title,'Weekly')]");
    private By biweeklyItem = By.xpath("//*[contains(@title,'Bi-Weekly')]");
    private By semiMonthlyItem = By.xpath("//*[contains(@title,'Semi-Monthly')]");
    private By dailyItem = By.xpath("//*[contains(@title,'Daily')]");
    private By interestRateInput = By.id("loanPayment_interestRate");
    private By cashPriceInput = By.id("loanPayment_cashPrice");
    private By downPaymentInput = By.id("loanPayment_downPayment");
    private By manufacturerRebateInput = By.id("loanPayment_manufacturerRebate");
    private By tradeInValueInput = By.id("loanPayment_tradeInValue");
    private By tradePayOffInput = By.id("loanPayment_tradePayOff");
    private By netTradeValueInput = By.id("loanPayment_netTradeValue");
    private By salesTaxInput = By.xpath("//*[@id=\"loanPayment_salesTax\"]//input");
    private By salesTaxInputQA = By.id("loanPayment_salesTax");
    private By salesTaxButton = By.xpath("//*[@id=\"loanPayment_salesTax\"]//button");
    private By salesTaxOTTOcalculateButton = By.xpath("(//*[contains(text(),'OTTOcalculate™')])[1]");
    private By dealerFeesInput = By.id("loanPayment_dealerFees");
    private By etrInput = By.id("loanPayment_etr");
    private By licenseFeeInput = By.id("loanPayment_licenseFee");
    private By titleFeesInput = By.id("loanPayment_titleFees");
    private By otherInput = By.id("loanPayment_other");
    private By otherFeeDescriptionInput = By.id("loanPayment_otherFeeDescription");
    private By leaseOtherFeeDescriptionInput = By.id("leasePayment_otherFeeDescription");
    private By unpaidBalanceInput = By.id("loanPayment_unpaidBalance");
    private By calculatedPaymentInput = By.id("loanPayment_calculatedPayment");
    private By vehicleInformationInput = By.id("vehicleInformation_vehicle_vin");
    //private By vehicleInformationInput = By.id("vehicleInformation_vin");
    private By loanTypeOfApp = By.xpath("//*[contains(text(),'Loan')]");
    private By leaseTypeOfApp = By.xpath("//*[contains(text(),'Lease')]");
    //private By typeOfApplication = By.xpath("(//span[preceding::*[@id=\"LTVWithoutProductsRetail\"]])[2]");
    //private By typeOfApplication = By.xpath("//*[contains(text(),'Type of application')]//following::input[1]");
    private By typeOfApplication = By.xpath("(//*[@id=\"applicationTypeId\"]//following::span)[1]");

    //************ Lease  ***********//

    private By matchBtn = By.xpath("//*[contains(text(),'Match')]");
    private By updateBtn = By.xpath("//*[contains(text(), 'Update')]");

    private By cashPriceLeaseInput = By.id("leasePayment_cashPrice");
    private By downPaymentLeaseInput = By.id("leasePayment_downPayment");
    private By manufacturerRebateLeaseInput = By.id("leasePayment_manufacturerRebate");
    private By tradeInValueLeaseInput = By.id("leasePayment_tradeInValue");
    private By tradePayOffLeaseInput = By.id("leasePayment_tradePayOff");
    private By netTradeValueLeaseInput = By.id("leasePayment_netTradeValue");
    private By salesTaxLeaseInput = By.xpath("//*[@id=\"leasePayment_salesTax\"]//input");
    private By securityDepositLeaseInput = By.id("leasePayment_securityDeposit");
    private By dealerFeesLeaseInput = By.id("leasePayment_dealerFees");
    private By etrLeaseInput = By.id("leasePayment_etr");
    private By licenseFeeLeaseInput = By.id("leasePayment_licenseFee");
    private By titleFeesLeaseInput = By.id("leasePayment_titleFees");
    private By otherLeaseInput = By.id("leasePayment_other");
    private By unpaidBalanceLeaseInput = By.id("leasePayment_unpaidBalance");
    private By actualCashRequiredLeaseInput = By.id("leasePayment_actualCashRequired");
    private By calculatedPaymentLeaseInput = By.id("leasePayment_calculatedPayment");

    // Lender payment values
    private By loanPayment_lenderGapInput = By.id("loanPayment_lenderGap");
    private By loanPayment_lenderGapCommissionInput = By.id("loanPayment_lenderGapCommission");
    private By loanPayment_lenderWarrantyInput = By.id("loanPayment_lenderWarranty");
    private By loanPayment_lenderWarrantyCommissionInput = By.id("loanPayment_lenderWarrantyCommission");
    private By loanPayment_lenderOtherInput = By.id("loanPayment_lenderOther");
    private By loanPayment_lenderOtherCommissionInput = By.id("loanPayment_lenderOtherCommission");
    private By loanPayment_dealerGapInput = By.id("loanPayment_dealerGap");
    private By loanPayment_dealerWarrantyInput = By.id("loanPayment_dealerWarranty");
    private By loanPayment_dealerOtherInput = By.id("loanPayment_dealerOther");

    private By totalCheckLenderInput = By.id("loanPayment_totalDealerCheck");
    private By amountFinancedLenderInput = By.id("loanPayment_amountFinanced");
    private By checkAppFound = By.xpath("//*[contains(text(),'Total records 1')]");
    private By tpaNameInput = By.xpath("(//*[@id=\"loanPayment_amountFinanced\"]//following::input)[1]");
    private By tpaTruwarrantyItem = By.xpath("//*[contains(text(),'TruWarranty')]");
    private By ottoProductsBtn = By.xpath("((//*[@id=\"loanPayment_amountFinanced\"]//following::input)[1]//following::button)[1]");
    private By productItem = By.xpath("(//*[contains(text(),'VSC')]//preceding::input)[last()]");
    private By createContractBtn = By.xpath("//*[contains(text(),'Create Contract')]");
    private By truVSC_Item = By.xpath("//*[contains(text(),'A La Car')]");
    private By aLaCar_Item = By.xpath("//*[contains(text(),'A La Car')]");
    private By truVSC_Term = By.xpath("(//*[contains(text(),'TruVSC TruTruck')]//following::input)[1]");
    private By aLaCarVSC_Term = By.xpath("(//*[contains(text(),'A La Car')]//following::input)[1]");
    private By truVSC_showCost= By.id("VSC_TRUTRUCK_showCost");
    private By aLaCarVSC_showCost= By.id("VSC_REG (ALC) GS A_showCost");
    private By truVSC_price= By.id("VSC_productPrice");
    private By aLaCarVSC_price= By.id("VSC_productPrice");




    // --> Lease  leasePayment_lenderGap

    private By leasePayment_lenderGapInput = By.id("leasePayment_lenderGap");
    private By leasePayment_lenderGapCommissionInput = By.id("leasePayment_lenderGapCommission");
    private By leasePayment_lenderWarrantyInput = By.id("leasePayment_lenderWarranty");
    private By leasePayment_lenderWarrantyCommissionInput = By.id("leasePayment_lenderWarrantyCommission");
    private By leasePayment_lenderOtherInput = By.id("leasePayment_lenderOther");
    private By leasePayment_lenderOtherCommissionInput = By.id("leasePayment_lenderOtherCommission");
    private By leasePayment_dealerGapInput = By.id("leasePayment_dealerGap");
    private By leasePayment_dealerWarrantyInput = By.id("leasePayment_dealerWarranty");
    private By leasePayment_dealerOtherInput = By.id("leasePayment_dealerOther");

    private By amountFinancedLenderLeaseInput = By.id("loanPayment_amountFinanced");
    private By totalCheckLenderLeaseInput = By.id("leasePayment_totalDealerCheck");


    public EditAppDealerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setInterestRateInput(String interestRate) {
        driver.findElement(interestRateInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(interestRateInput).sendKeys(interestRate);
    }

    public void setFrequencyInput(String frequency) {

        if (frequency.equalsIgnoreCase("Weekly")) {
            driver.findElement(frequencyInput).click();
            driver.findElement(weeklyItem).click();
        } else if (frequency.equalsIgnoreCase("Bi-Weekly")) {
            driver.findElement(frequencyInput).click();
            driver.findElement(biweeklyItem).click();
        } else if (frequency.equalsIgnoreCase("Semi-Monthly")) {
            driver.findElement(frequencyInput).click();
            driver.findElement(semiMonthlyItem).click();
        } else if (frequency.equalsIgnoreCase("Daily")) {
            driver.findElement(frequencyInput).click();
            driver.findElement(dailyItem).click();
        }
    }

    public void setCashPriceInput(String cashPrice) {
        driver.findElement(cashPriceInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(cashPriceInput).sendKeys(cashPrice);
    }

    public void setDownPaymentInput(String downPayment) {
        driver.findElement(downPaymentInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(downPaymentInput).sendKeys(downPayment);
    }

    public void setManufacturerRebateInput(String manufacturerRebate) {
        driver.findElement(manufacturerRebateInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(manufacturerRebateInput).sendKeys(manufacturerRebate);
    }

    public void setTradeInValueInput(String tradeInValue) {
        driver.findElement(tradeInValueInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(tradeInValueInput).sendKeys(tradeInValue);
    }

    public void setTradePayOffInput(String tradePayOff) {
        driver.findElement(tradePayOffInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(tradePayOffInput).sendKeys(tradePayOff);
    }

    public void setNetTradeValueInput(String netTradeValue) {
    }

    public void setSalesTaxInput(String salesTax) {
        driver.findElement(salesTaxInput).click();
        driver.findElement(salesTaxInput).sendKeys(Keys.BACK_SPACE);
        driver.findElement(salesTaxInput).sendKeys(Keys.BACK_SPACE);
        driver.findElement(salesTaxInput).sendKeys(Keys.BACK_SPACE);
        driver.findElement(salesTaxInput).sendKeys(Keys.BACK_SPACE);
        driver.findElement(salesTaxInput).sendKeys(salesTax);
    }

    public void clickSalesTaxOTTOcalculateButton() {
        driver.findElement(salesTaxOTTOcalculateButton).click();
    }

    public void setDealerFeesInput(String dealerFees) {
        driver.findElement(dealerFeesInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(dealerFeesInput).sendKeys(dealerFees);
    }

    public void setEtrInput(String etr) {
        driver.findElement(etrInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(etrInput).sendKeys(etr);
    }

    public void setLicenseFeeInput(String licenseFee) {
        driver.findElement(licenseFeeInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(licenseFeeInput).sendKeys(licenseFee);
    }

    public void setTitleFeesInput(String titleFees) {
        driver.findElement(titleFeesInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(titleFeesInput).sendKeys(titleFees);
    }

    public void setOtherInput(String other) {
        driver.findElement(otherInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(otherInput).sendKeys(other);
    }

    public void setOtherDescriptionInput(String text) {
        driver.findElement(otherFeeDescriptionInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(otherFeeDescriptionInput).sendKeys(text);
    }

    public void setLeaseOtherDescriptionInput(String text) {
        driver.findElement(leaseOtherFeeDescriptionInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(leaseOtherFeeDescriptionInput).sendKeys(text);
    }

    public String getUnpaidBalanceInput() {
        WebAction webAction = new WebAction(driver);
        webAction.highlightElement(driver.findElement(unpaidBalanceInput));
        return driver.findElement(unpaidBalanceInput).getAttribute("value");
    }

    public String getCalculatedPaymentInput() {
        WebAction webAction = new WebAction(driver);
        webAction.highlightElement(driver.findElement(calculatedPaymentInput));
        return driver.findElement(calculatedPaymentInput).getAttribute("value");
    }

    public void setVinInfoInput(String vinInformation) {

        if (driver.findElement(vehicleInformationInput).getText().equalsIgnoreCase("")) {
            driver.findElement(vehicleInformationInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            driver.findElement(vehicleInformationInput).sendKeys(vinInformation);
            driver.findElement(vehicleInformationInput).sendKeys(Keys.ENTER);
        }

    }

    public String getTypeOfApplication() {
        return driver.findElement(typeOfApplication).getText();
    }

    //********* Lease Methods *********//
    public void setCashPriceLeaseInput(String cashPrice) {
        driver.findElement(cashPriceLeaseInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(cashPriceLeaseInput).sendKeys(cashPrice);
    }

    public void setDownPaymentLeaseInput(String downPayment) {
        driver.findElement(downPaymentLeaseInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(downPaymentLeaseInput).sendKeys(downPayment);
    }

    public void setManufacturerRebateLeaseInput(String manufacturerRebate) {
        driver.findElement(manufacturerRebateLeaseInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(manufacturerRebateLeaseInput).sendKeys(manufacturerRebate);
    }

    public void securityDepositLeaseInput(String securityDeposit) {
        driver.findElement(securityDepositLeaseInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(securityDepositLeaseInput).sendKeys(securityDeposit);
    }

    public void setTradeInValueLeaseInput(String tradeInValue) {
        driver.findElement(tradeInValueLeaseInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(tradeInValueLeaseInput).sendKeys(tradeInValue);
    }

    public void setTradePayOffLeaseInput(String tradePayOff) {
        driver.findElement(tradePayOffLeaseInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(tradePayOffLeaseInput).sendKeys(tradePayOff);
    }

    public void setDealerFeesLeaseInput(String dealerFees) {
        driver.findElement(dealerFeesLeaseInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(dealerFeesLeaseInput).sendKeys(dealerFees);
    }

    public void setEtrLeaseInput(String etr) {
        driver.findElement(etrLeaseInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(etrLeaseInput).sendKeys(etr);
    }

    public void setLicenseFeeLeaseInput(String licenseFee) {
        driver.findElement(licenseFeeLeaseInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(licenseFeeLeaseInput).sendKeys(licenseFee);
    }

    public void setTitleFeesLeaseInput(String titleFees) {
        driver.findElement(titleFeesLeaseInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(titleFeesLeaseInput).sendKeys(titleFees);
    }

    public void setOtherLeaseInput(String other) {
        driver.findElement(otherLeaseInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(otherLeaseInput).sendKeys(other);
    }

    public String getUnpaidBalanceLeaseInput() {
        return driver.findElement(unpaidBalanceLeaseInput).getAttribute("value");
    }

    public String getCalculatedPaymentLeaseInput() {
        WebAction webAction = new WebAction(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(calculatedPaymentLeaseInput)).perform();
        webAction.highlightElement(driver.findElement(calculatedPaymentLeaseInput));
        return driver.findElement(calculatedPaymentLeaseInput).getAttribute("value");
    }

    public String getActualCashRequiredLeaseInput() {
        WebAction webAction = new WebAction(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(actualCashRequiredLeaseInput)).perform();
        webAction.highlightElement(driver.findElement(actualCashRequiredLeaseInput));
        return driver.findElement(actualCashRequiredLeaseInput).getAttribute("value");
    }

    // Lender Lease payment values
    // Lease
    public void setLenderGapLeaseInput(String lenderGap) {
        driver.findElement(leasePayment_lenderGapInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(leasePayment_lenderGapInput).sendKeys(lenderGap);
    }

    public void setLenderGapCommissionLeaseInput(String gapCommission) {
        driver.findElement(leasePayment_lenderGapCommissionInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(leasePayment_lenderGapCommissionInput).sendKeys(gapCommission);
    }

    public void setLenderWarrantyLeaseInput(String lenderServiceContract) {
        driver.findElement(leasePayment_lenderWarrantyInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(leasePayment_lenderWarrantyInput).sendKeys(lenderServiceContract);
    }

    public void setLenderWarrantyCommissionLeaseInput(String serviceContractCommission) {
        driver.findElement(leasePayment_lenderWarrantyCommissionInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(leasePayment_lenderWarrantyCommissionInput).sendKeys(serviceContractCommission);
    }

    public void setLenderOtherLeaseInput(String lenderOther) {
        driver.findElement(leasePayment_lenderOtherInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(leasePayment_lenderOtherInput).sendKeys(lenderOther);
    }

    public void setLenderOtherCommissionLeaseInput(String otherCommission) {
        driver.findElement(leasePayment_lenderOtherCommissionInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(leasePayment_lenderOtherCommissionInput).sendKeys(otherCommission);
    }

    public void setDealerGapLeaseInput(String dealerGap) {
        driver.findElement(leasePayment_dealerGapInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(leasePayment_dealerGapInput).sendKeys(dealerGap);
    }

    public void setDealerWarrantyLeaseInput(String dealerWarranty) {
        driver.findElement(leasePayment_dealerWarrantyInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(leasePayment_dealerWarrantyInput).sendKeys(dealerWarranty);
    }

    public void setDealerOtherLeaseInput(String dealerOther) {
        driver.findElement(leasePayment_dealerOtherInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(leasePayment_dealerOtherInput).sendKeys(dealerOther);
    }

    public String getTotalCheckLenderLeaseInput() {
        WebAction webAction = new WebAction(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(totalCheckLenderLeaseInput)).perform();
        webAction.highlightElement(driver.findElement(totalCheckLenderLeaseInput));
        return driver.findElement(totalCheckLenderLeaseInput).getAttribute("value");
    }

    public String getAmountFinancedLenderLeaseInput() {
        return driver.findElement(amountFinancedLenderLeaseInput).getAttribute("value");
    }

    // Lender Loan payment values methods
    public void setLenderGapInput(String lenderGapInput) {
        if (lenderGapInput.equalsIgnoreCase("0")){return;}
        driver.findElement(loanPayment_lenderGapInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_lenderGapInput).sendKeys(lenderGapInput);
    }

    public void setLenderGapCommissionInput(String lenderGapCommissionInput) {
        driver.findElement(loanPayment_lenderGapCommissionInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_lenderGapCommissionInput).sendKeys(lenderGapCommissionInput);
    }

    public void setLenderWarrantyInput(String lenderWarrantyInput) {
        if (lenderWarrantyInput.equalsIgnoreCase("0")){return;}
        driver.findElement(loanPayment_lenderWarrantyInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_lenderWarrantyInput).sendKeys(lenderWarrantyInput);
    }

    public void setLenderWarrantyCommissionInput(String lenderWarrantyCommissionInput) {
        driver.findElement(loanPayment_lenderWarrantyCommissionInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_lenderWarrantyCommissionInput).sendKeys(lenderWarrantyCommissionInput);
    }

    public void setLenderOtherInput(String lenderOtherInput) {
        if (lenderOtherInput.equalsIgnoreCase("0")){return;}
        driver.findElement(loanPayment_lenderOtherInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_lenderOtherInput).sendKeys(lenderOtherInput);
    }

    public void setLenderOtherCommissionInput(String lenderOtherCommissionInput) {
        driver.findElement(loanPayment_lenderOtherCommissionInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_lenderOtherCommissionInput).sendKeys(lenderOtherCommissionInput);
    }

    public void setDealerGapInput(String dealerGapInput) {
        driver.findElement(loanPayment_dealerGapInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_dealerGapInput).sendKeys(dealerGapInput);
    }

    public void setDealerWarrantyInput(String dealerWarrantyInput) {
        driver.findElement(loanPayment_dealerWarrantyInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_dealerWarrantyInput).sendKeys(dealerWarrantyInput);
    }

    public void setDealerOtherInput(String dealerOtherInput) {
        driver.findElement(loanPayment_dealerOtherInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_dealerOtherInput).sendKeys(dealerOtherInput);
    }

    public void clickMatch() {
        driver.findElement(matchBtn).click();
    }

    public void updateApplication() throws InterruptedException {
//        driver.findElement(updateBtn).click();
//        Thread.sleep(3000);

        WebElement updateBtnElement = driver.findElement(updateBtn);
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, updateBtn);
        driver.findElement(updateBtn).click();
        webAction.highlightElement(updateBtnElement);
        //Thread.sleep(3000);
    }

    public String getTotalCheckLenderInput() {
        WebAction webAction = new WebAction(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(totalCheckLenderInput)).perform();
        webAction.highlightElement(driver.findElement(totalCheckLenderInput));
        return driver.findElement(totalCheckLenderInput).getAttribute("value");
    }

    public String getAmountFinancedLenderInput() {
        WebAction webAction = new WebAction(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(amountFinancedLenderInput)).perform();
        webAction.highlightElement(driver.findElement(amountFinancedLenderInput));
        return driver.findElement(amountFinancedLenderInput).getAttribute("value");
    }


    public void selectTPAAlphaWarranty(String tpaProvider) {
        driver.findElement(tpaNameInput).click();
        driver.findElement(tpaNameInput).sendKeys(Keys.ENTER);
    }

    public void selectTPATruwarranty(String tpaProvider) {
        driver.findElement(tpaNameInput).click();
        driver.findElement(tpaTruwarrantyItem).click();
    }

    public void clickOTTOProducts() {
        driver.findElement(ottoProductsBtn).click();

    }

    public void clickProductItemsAlphaWarranty() throws InterruptedException {
        driver.findElement(productItem).click();  //VSC
        driver.findElement(aLaCar_Item).click();  // A La Car
        driver.findElement(aLaCarVSC_Term).click();    // A La Car item
        Thread.sleep(500);
        driver.findElement(aLaCarVSC_Term).sendKeys(Keys.ENTER);
        driver.findElement(aLaCarVSC_showCost).click();
        driver.findElement(aLaCarVSC_price).sendKeys("1000");
    }

    public void clickProductItemsTruwarranty() throws InterruptedException {
        driver.findElement(productItem).click();  //VSC
        driver.findElement(truVSC_Item).click();  // TruVSC TruTruck
        driver.findElement(truVSC_Term).click();    // TruVSC TruTruck item
        Thread.sleep(1000);
        driver.findElement(truVSC_Term).sendKeys(Keys.ENTER);
        driver.findElement(truVSC_showCost).click();
        driver.findElement(truVSC_price).sendKeys("2000");
    }

    public void clickCreateContract() {
        driver.findElement(createContractBtn).click();
    }
}
