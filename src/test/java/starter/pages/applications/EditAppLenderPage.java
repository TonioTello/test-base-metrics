package starter.pages.applications;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import starter.utils.WebAction;

import java.time.Duration;

public class EditAppLenderPage {
    private WebDriver driver;

    private By matchBtn = By.xpath("//*[contains(text(),'Match')]");
    private By updateBtn = By.xpath("//*[contains(text(), 'Update')]");

    private By loanTypeOfApp = By.xpath("//*[contains(text(),'Loan')]");
    private By leaseTypeOfApp = By.xpath("//*[contains(text(),'Lease')]");
    private By typeOfApplication = By.xpath("(//span[preceding::*[@id=\"LTVWithoutProductsRetail\"]])[2]");

    private By unpaidBalanceInput = By.id("loanPayment_unpaidBalance");
    private By calculatedPaymentInput = By.id("loanPayment_calculatedPayment");
    private By unpaidBalanceLeaseInput = By.id("leasePayment_unpaidBalance");
    private By calculatedPaymentLeaseInput = By.id("leasePayment_calculatedPayment");

    // Lender payment values -->Loan
    private By loanPayment_lenderGapInput = By.id("loanPayment_lenderGap");
    private By loanPayment_lenderGapCommissionInput = By.id("loanPayment_lenderGapCommission");
    private By loanPayment_lenderWarrantyInput = By.id("loanPayment_lenderWarranty");
    private By loanPayment_lenderWarrantyCommissionInput = By.id("loanPayment_lenderWarrantyCommission");
    private By loanPayment_lenderOtherInput = By.id("loanPayment_lenderOther");
    private By loanPayment_lenderOtherCommissionInput = By.id("loanPayment_lenderOtherCommission");
    private By loanPayment_dealerGapInput = By.id("loanPayment_dealerGap");
    private By loanPayment_dealerWarrantyInput = By.id("loanPayment_dealerWarranty");
    private By loanPayment_dealerOtherInput = By.id("loanPayment_dealerOther");
    private By loanPayment_loanProcessingFeeInput = By.id("loanPayment_loanProcessingFee");
    private By loanPayment_lenderFeesInput = By.id("loanPayment_lenderFees");

    private By loanPayment_line5Input = By.id("loanPayment_line5");

    private By totalCheckLenderInput = By.id("loanPayment_totalDealerCheck");
    private By amountFinancedLenderInput = By.id("loanPayment_amountFinanced");

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

    private By checkAppFound = By.xpath("//*[contains(text(),'Total records 1')]");




    public EditAppLenderPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getTypeOfApplication() {
        return driver.findElement(typeOfApplication).getText();
    }
    public String getUnpaidBalanceInput() {
        return driver.findElement(unpaidBalanceInput).getAttribute("value");
    }

    public String getCalculatedPaymentInput() {
        return driver.findElement(calculatedPaymentInput).getAttribute("value");

    }

    // Lender payment values methods
    public void setLenderGapInput(String lenderGapInput) {
        driver.findElement(loanPayment_lenderGapInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_lenderGapInput).sendKeys(lenderGapInput);
    }

    public void setLenderGapCommissionInput(String lenderGapCommissionInput) {
        driver.findElement(loanPayment_lenderGapCommissionInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_lenderGapCommissionInput).sendKeys(lenderGapCommissionInput);
    }

    public void setLenderWarrantyInput(String lenderWarrantyInput) {
        driver.findElement(loanPayment_lenderWarrantyInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_lenderWarrantyInput).sendKeys(lenderWarrantyInput);
    }

    public void setLenderWarrantyCommissionInput(String lenderWarrantyCommissionInput) {
        driver.findElement(loanPayment_lenderWarrantyCommissionInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_lenderWarrantyCommissionInput).sendKeys(lenderWarrantyCommissionInput);
    }

    public void setLenderOtherInput(String lenderOtherInput) {
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

    public void setLoanProcessingFeeInput(String loanProcessingFee) {
        driver.findElement(loanPayment_loanProcessingFeeInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_loanProcessingFeeInput).sendKeys(loanProcessingFee);
    }

    public void setLenderFeesInput(String lenderFees) {
        driver.findElement(loanPayment_lenderFeesInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_lenderFeesInput).sendKeys(lenderFees);
    }

    public void setLineFiveInput(String lineFive) {
        driver.findElement(loanPayment_line5Input).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(loanPayment_line5Input).sendKeys(lineFive);
    }

    public void clickMatch() {
        driver.findElement(matchBtn).click();
    }

    public void updateApplication() throws InterruptedException {
        Thread.sleep(2000);
        WebElement updateBtnElement = driver.findElement(updateBtn);
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, updateBtn);
        driver.findElement(updateBtn).click();
        webAction.highlightElement(updateBtnElement);
    }

    public String getTotalCheckLenderInput() {
        return driver.findElement(totalCheckLenderInput).getAttribute("value");
    }

    public String getAmountFinancedLenderInput() {
        return driver.findElement(amountFinancedLenderInput).getAttribute("value");
    }


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

    public String getUnpaidBalanceLeaseInput() {
        return driver.findElement(unpaidBalanceLeaseInput).getAttribute("value");

    }

    public String getCalculatedPaymentLeaseInput() {
        return driver.findElement(calculatedPaymentLeaseInput).getAttribute("value");
    }

    public String getTotalCheckLenderLeaseInput() {
        return driver.findElement(totalCheckLenderLeaseInput).getAttribute("value");
    }

    public String getAmountFinancedLenderLeaseInput() {
        return driver.findElement(amountFinancedLenderLeaseInput).getAttribute("value");
    }


}