package starter.pages.applications;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import starter.utils.WebAction;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AppInfoPage {
    private WebDriver driver;

    private By claimButton = By.xpath("//*[contains(text(), 'Claim')]");
    private By searchLenderInput = By.xpath("//*[@placeholder=\"Search by lenders\"]");
    private By updateButton = By.xpath("//*[contains(text(), 'Update')]");
    private By selectLenderCheckbox = By.xpath("//*[@class=\"ant-checkbox-input\"][following::span[contains(text(), 'Demo Tech')]]");
    private By selectLenderAvailable = By.xpath("//*[@id=\"lenderAvailable\"]//span//input");
    private By searchLender = By.xpath("//*[@placeholder=\"Search by lenders\"]");

    private By submitenderBtn = By.xpath("(//*[contains(text(),'Available Lenders')]//following::button)[last()]");
    private By tradeVinInput = By.id("tradeIn_vin");

    private By approveButton = By.xpath("//*[contains(text(),'Approve') or @class=\"text-green\"] ");
    private By approvedLabel = By.xpath("//span[contains(text(), 'Approved')]");
    private By notificationMessage = By.xpath("//*[contains(text(), 'successfully')]");
    private By notificationStatus = By.xpath("//*[@role=\"status\"]");
    private By checkAppFound = By.xpath("//*[contains(text(),'Total records 1')]");
    private By statusPendingLabel = By.xpath("//*[contains(text(), 'pending') or contains(text(), 'Pending')]");
    private By statusCopySent = By.xpath("//*[contains(text(), 'copy successfully') or contains(text(), 'Application copy successfully sent')]");
    private By statusCopyDealerSent = By.xpath("//*[contains(text(), 'Documents sent to be signed') or contains(text(), 'be signed')]");

    private By spinIcons = By.xpath("//*[@class=\"ant-spin-dot-item\"]");
    private By textMessageInput = By.xpath("(//*[@id=\"messages_section\"]//textarea)[1]");
    private By loanPayment_loanTermsInput = By.id("loanPayment_loanTerms");


    public AppInfoPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickClaimButton() {
        WebAction webAction = new WebAction(driver);

        webAction.waitToBeClickable(driver, claimButton);
        driver.findElement(claimButton).click();
    }

    public void selectLender(String lender) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(searchLender).sendKeys(lender);
        Thread.sleep(3000);
        driver.findElement(selectLenderAvailable).click();
    }

    public void clickOnSubmitTotheLender() throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        driver.findElement(submitenderBtn).click();
        webAction.waitVisibilityOf(driver, statusCopySent);
        webAction.waitInVisibilityOf(driver, statusCopySent);
    }

    public void clickUpdateButton() throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, updateButton);
        Thread.sleep(2000);
        driver.findElement(updateButton).click();
        webAction.highlightElement(driver.findElement(updateButton));
    }

    public void clickApproveButton() throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        try {
            if (driver.findElement(spinIcons).isDisplayed()) {
                Thread.sleep(1000); // Wait element attached to the page document
                webAction.waitInVisibilityOf(driver, spinIcons);
            }
        } catch (Exception e) {
            // Keeps going
            System.out.println("e = " + e);
        }

        Thread.sleep(5000); // Wait element attached to the page document
        try {
            webAction.waitVisibilityOf(driver, approveButton);
            webAction.waitToBeClickable(driver, approveButton);
            driver.findElement(approveButton).click();
        } catch (Exception e) {
            Thread.sleep(10000); // Wait element attached to the page document
            driver.findElement(approveButton).click();

        }
        webAction.highlightElement(driver.findElement(approveButton));
    }

    public String verifyApprovedLabel() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(approvedLabel).getText();
    }

    public String getTradeVinValue() {
        return driver.findElement(tradeVinInput).getAttribute("value");
    }

    public String verifyNotificationSuccessfully() {
        String notification = "";
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, notificationStatus);
        notification = driver.findElement(notificationStatus).getText();
        webAction.waitInVisibilityOf(driver, notificationStatus);
        return notification;
    }

    public String verifyNotificationSuccessfullyCopySent() throws InterruptedException {
        String notification = "Notification no catched";
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, notificationStatus);
        if (driver.findElement(notificationStatus).getText().contains("successfully updated")) {
            webAction.waitInVisibilityOf(driver, notificationStatus);
        } else {
            notification = driver.findElement(notificationStatus).getText();
            webAction.waitInVisibilityOf(driver, notificationStatus);
            return notification;
        }

        Thread.sleep(1000);
        try {
            webAction.waitVisibilityOf(driver, notificationStatus);
            notification = driver.findElement(notificationStatus).getText();
            webAction.waitInVisibilityOf(driver, notificationStatus);
        } catch (Exception e) {
        }


        return notification;
    }

    public boolean verifyStatusPending() {
        Actions actions = new Actions(driver);
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, statusPendingLabel, 10);
        if (driver.findElement(statusPendingLabel).isDisplayed()) {
            actions.moveToElement(driver.findElement(statusPendingLabel)).perform();
            webAction.highlightElement(driver.findElement(statusPendingLabel));
            return true;
        } else {
            return false;
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void setTextMessageInput(String message) {
        driver.findElement(textMessageInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(textMessageInput).sendKeys(message);
        driver.findElement(textMessageInput).sendKeys(Keys.ENTER);
    }

    public void clickOnLoanTerms() {
        driver.findElement(loanPayment_loanTermsInput).click();
    }
}

