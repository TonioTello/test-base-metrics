package starter.pages.applications;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import starter.pages.companies.PlanPage;
import starter.utils.WebAction;

import java.util.List;

public class LoginPage {

    private WebDriver driver;

    //private By usernameField = By.id("email");
    private By loginTab = By.xpath("//a[contains(text(),'Log in')]");
    private By usernameField = By.id("Email");
    private By passwordField = By.id("Password");
    //private By passwordField = By.id("password");
    private By loginButton = By.xpath("//input[@value=\"Log in\"]");
    private By homeLabel = By.xpath("//*[contains(text(), 'Home')]");
    private By newApplicationBtn = By.xpath("//*[contains(text(), 'New application')]");
    private By logoutOptionBtn = By.xpath("//*[contains(text(), 'Logout')]");
    private By checkOutLabel = By.xpath("//*[contains(text(), 'Check out')]");
    private By refreshBtn = By.xpath("//*[contains(text(), 'Refresh')]");
    private By spinIcons = By.xpath("//*[@class=\"ant-spin-dot-item\"]");

    private By okWelcomeMessageBtn = By.xpath("//*[contains(text(), 'OK')]");
    private By welcomeMessageLender = By.xpath("//*[contains(text(), 'Hello and Welcome')]");

    private By vehicleInformation_vehicle_notesInput = By.id("vehicleInformation_vehicle_notes");

    private By recoverMyPassword = By.xpath("//*[contains(text(),'Recover my password')]");
    private By validateMyEmailButton = By.xpath("//*[contains(text(),'Validate my email')]");
    private By emailAddressOption = By.xpath("//*[contains(text(),'email address')]");
    private By notificationStatus = By.xpath("//*[@role=\"status\"]");

    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("confirm");
    private By savePasswordBtn = By.xpath("//*[contains(text(),'Save new password')]");
    private By termsOfUseAgreementBtn = By.xpath("//*[contains(text(),'Terms of use')]");
    private By acceptButton = By.xpath("//*[contains(text(),'Accept')]");
    private By dontShowAgainBtn = By.xpath("//*[contains(text(), 'show again')]");
    private By sendRequestEmail_Opt = By.xpath("//*[contains(text(), 'Send request to email address')]");
    private By continueButton = By.xpath("//*[contains(text(), 'Continue')]");
    private By verificationCodeInput = By.id("one-time-code");
    private By validateBtn = By.xpath("//button[contains(text(),'Validate')]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogInTab() {
        driver.findElement(loginTab).click();
    }

    public void setUsernameField(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean getHomeLabel() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, homeLabel, 60);
        return driver.findElement(homeLabel).isDisplayed();
    }

    public boolean getCheckOutLabel() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, checkOutLabel);
        return driver.findElement(checkOutLabel).isDisplayed();
    }

    public void closeNewUpdatePopup() {
        try {
            WebAction webAction = new WebAction(driver);
            webAction.waitVisibilityOf(driver, refreshBtn);
            driver.findElement(refreshBtn).click();
            //Thread.sleep(3000);
            // webAction.waitInVisibilityOf(driver, spinIcons);   Todo remove comment
            // webAction.waitInVisibilityOf(driver, spinIcons);   Todo remove comment
        } catch (Exception e) {
            try {
                WebAction webAction = new WebAction(driver);
                // webAction.waitInVisibilityOf(driver, spinIcons);  Todo remove comment
            } catch (Exception ee) {

            }

        }
    }

    public boolean validateMessageLender() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, welcomeMessageLender);
        return driver.findElement(welcomeMessageLender).isDisplayed();
    }

    public void clickOnOkWelcomePopup() {
        driver.findElement(okWelcomeMessageBtn).click();
    }


    public void clickOnRecoverMyPassword() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, recoverMyPassword);
        driver.findElement(recoverMyPassword).click();
    }

    public void clickOnValidateEmail() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, validateMyEmailButton);
        driver.findElement(validateMyEmailButton).click();
    }

    public void clickOnEmailAddressOption() throws InterruptedException {
        Thread.sleep(2000);
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, emailAddressOption);
        driver.findElement(emailAddressOption).click();
    }

    public String getNotificationStatus() throws InterruptedException {
        String status = "";
        WebAction webAction = new WebAction(driver);
        Thread.sleep(1000);
        webAction.waitVisibilityOf(driver, notificationStatus);
        status = driver.findElement(notificationStatus).getText();
        Thread.sleep(500);
        webAction.waitInVisibilityOf(driver, notificationStatus);
        return status;
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

    public void clickOnAccept() throws InterruptedException {
        Thread.sleep(1000);
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, acceptButton);
        driver.findElement(acceptButton).click();
    }

    public void clickOnDontShowAgain() {
        driver.findElement(dontShowAgainBtn).click();
    }

    public void waitDataLoad() {
        try {
            WebAction webAction = new WebAction(driver);
            webAction.waitInVisibilityOf(driver, spinIcons);
            webAction.waitInVisibilityOf(driver, spinIcons);
        } catch (Exception e) {
/*            try {
                WebAction webAction = new WebAction(driver);
                webAction.waitInVisibilityOf(driver, spinIcons);
            } catch (Exception ee) {

            }*/

        }
    }

    public void clickOnSendRequestEmail() throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, sendRequestEmail_Opt);
        driver.findElement(sendRequestEmail_Opt).click();
        Thread.sleep(1000);
        driver.findElement(continueButton).click();
    }

    public void setVerificationCode(String verificationCode) throws InterruptedException {
        driver.findElement(verificationCodeInput).sendKeys("0" + verificationCode);
    }

    public void clickOnValidate() {
        driver.findElement(validateBtn).click();
    }

    public void validateNotificationMsj(WebDriver driver, String message) {
        try {
            String notificationStatus = "";
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            notificationStatus = appInfoPage.verifyNotificationSuccessfully();
            Assert.assertTrue(String.format("The notification message expected: \"%s\" vs received: \"%s\"", message, notificationStatus), notificationStatus.contains(message));
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            WebAction webAction = new WebAction(driver);
            webAction.validateRequiredAlert();
            Assert.assertTrue("Error getting the successfully notification message: " + e, false);
        }
    }

}