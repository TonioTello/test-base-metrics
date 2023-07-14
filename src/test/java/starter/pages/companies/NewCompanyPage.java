package starter.pages.companies;

import io.cucumber.java.en_old.Ac;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import starter.utils.WebAction;

import java.time.Duration;

public class NewCompanyPage {
    private WebDriver driver;

    private By typeCompanyInput = By.id("profile_companyTypeId");
    private By lenderOption = By.xpath("//*[contains(@title,'Lender')]");
    private By dealerOption = By.xpath("//*[contains(@title,'Dealer')]");
    private By nameCompanyInput = By.id("profile_name");
    private By legalNameInput = By.id("profile_legalName");
    private By accountingContactNameInput = By.id("profile_accountingContactName");
    private By emailInput = By.id("profile_email");
    private By phoneNumberInput = By.id("profile_phoneNumber");
    private By businessAddressInput = By.id("profile_businessAddress");
    private By zipCodeInput = By.id("profile_zipCode");

    private By spinIcons = By.xpath("//*[@class=\"ant-spin-dot-item\"]");

    private By profile_webSiteInput = By.id("profile_webSite");


    private By zipCodeSearchIcon = By.xpath("//button[preceding::input[@id='profile_zipCode']][1]");
    private By zipCodeSearchBranchIcon = By.xpath("(//*[@id=\"branch_zipCode\"]//following::button)[1]");
    private By cityInput = By.id("profile_city");
    private By stateInput = By.id("profile_stateId");
    private By submitBtn = By.xpath("//*[@type=\"button\" and contains(text(), 'Submit')]");
    private By submitBtn_ = By.xpath("//*[contains(text(), 'Submit')]");
    private By submitBranchBtn = By.xpath("//*[@type=\"submit\" and contains(text(), 'Submit')]");
    private By submitOfficeBtn = By.xpath("//*[@type=\"submit\" and contains(text(), 'Submit')]");

    //***Branch ***//
    private By addNewBranchBtn = By.xpath("//*[contains(text(),'Add new branch')]");
    private By addNewStoreBtn = By.id("tabs--1--tab--1");
    private By branchNameInput = By.id("branch_name");
    private By branchEmailInput = By.id("branch_email");
    private By branchPhoneNumberInput = By.id("branch_phoneNumber");
    private By branchBusinessAddressInput = By.id("branch_businessAddress");
    private By branchZipCodeInput = By.id("branch_zipCode");
    private By branchCityInput = By.id("branch_city");


    private By searchBranchInput = By.id("branchFilters_search");
    private By searchOfficeInput = By.id("officeFilters_search");

    private By numBranchesMatched = By.xpath("//*[contains(text(), 'Total records')]");
    private By notificationSuccessfully = By.xpath("//*[contains(text(), 'Company successfully created')]");

    //****Store-Office****//
    private By storeOpc = By.xpath("//button[contains(text(),'Store(s)')]");
    private By subscriptionsOpc = By.xpath("//*[contains(@aria-label,'Subscriptions')]");
    private By queueOpc = By.xpath("//button[contains(text(),'Queue')]");
    private By officeBranchNameInput = By.id("office_branchId");
    private By officeBranchNameOptions = By.xpath("//*[contains(@class, 'ant-select-item-option-content')]"); //Todo
    private By officeNameInput = By.id("office_name");
    private By officeEmailInput = By.id("office_email");
    private By officePhoneNumberInput = By.id("office_phoneNumber");
    private By officeBusinessAddressInput = By.id("office_businessAddress");
    private By officeZipCodeInput = By.id("office_zipCode");
    private By zipCodeSearchOfficeIcon = By.xpath("//button[preceding::input[@id='office_zipCode']][1]");

    private By officeBranchInput = By.id("branchFilters_search");
    private By numOfficeMatched = By.xpath("//*[contains(text(), 'Total records')]");
    private By addNewUserButton = By.xpath("(//*[@id=\"userFilters_search\"]//following::button[contains(text(),'Add new')])[1]");
    private By addNewUserButtonLP = By.xpath("//*[contains(text(),'New user')]");
    private By addNewStoreButton = By.xpath("(//*[@id=\"officeFilters_search\"]//following::button[contains(text(),'Add new')])[1]");
    private By addNewQueueButton = By.xpath("(//*[@id=\"officeFilters_search\"]//following::button[contains(text(),'Add new')])[1]");
    private By freeOptionButton = By.xpath("//*[contains(text(),'Free')]");

    //****Roles****//
    private By rolesOpc = By.xpath("//button[contains(text(),'Roles')]");

    private By addNewRoleButton = By.xpath("(//*[@id=\"search\"]//following::button[contains(text(),'Add new')])[1]");

    //private By employeePositionInput = By.id("profile_name");
    private By employeePositionInput = By.xpath("(//*[@id=\"profile_description\"]//preceding::input)[last()]");
    private By rolDescriptionInput = By.id("profile_description");
    private By baseRoleInput = By.id("profile_roleTypeId");

    private By submitRoleBtn = By.xpath("//*[@type=\"submit\" and contains(text(), 'Submit')]");


    //****Store-User****//
    private By usersOpc = By.xpath("//button[contains(text(),'Users')]");
    private By usersOpcLP = By.xpath("//*[contains(text(),'Users')]");
    private By userBranchNameInput = By.id("office_branchId");
    private By userBranchNameOptions = By.xpath("//*[contains(@class, 'ant-select-item-option-content')]"); //Todo
    private By userStoreNameOptions = By.xpath("//*[contains(@class, 'ant-select-item-option-content')]"); //Todo Should be # to Branch Xpath

    private By userStoreNameInput = By.id("office_officeId");
    private By userFirstNameInput = By.id("office_firstName");
    private By userLastNameInput = By.id("office_lastName");
    private By userEmailInput = By.id("office_email");
    private By userPhoneNumberInput = By.id("office_phoneNumber");
    private By userBusinessAddressInput = By.id("office_homeAddress");
    private By userZipCodeInput = By.id("office_zipCode");
    private By zipCodeSearchUserIcon = By.xpath("//button[preceding::input[@id='office_zipCode']][1]");
    private By userRolInput = By.id("office_roleId");
    private By userRolOptions = By.xpath("//*[contains(@class, 'ant-select-item-option-content')]"); //Todo Should be # to Branch Xpath
    private By numUserMatched = By.xpath("//*[contains(text(), 'Total records')]");
    private By submitUserBtn = By.xpath("//*[@type=\"button\" and contains(text(), 'Submit')]");
    private By searchUserInput = By.id("userFilters_search");
    private By notificationMessage = By.xpath("//*[contains(text(), 'successfully')]");

    private By checkAppFound = By.xpath("(//*[contains(text(),'Total records 1')])[last()]"); // Todo Review Cos there are three, only one is active
    private By checkBranchFound = By.xpath("(//*[@id=\"branchFilters\"]//following::*[contains(text(),'Total records 1')])[1]");
    private By checkOfficeFound = By.xpath("(//*[@id=\"officeFilters\"]//following::*[contains(text(),'Total records 1')])");
    private By checkUserFound = By.xpath("(//*[@id=\"userFilters\"]//following::*[contains(text(),'Total records 1')])");


    //** Store Info - New Plan company **//
    private By newBranchBtn = By.xpath("//*[contains(text(), 'New Branch')]");
    private By applyBtn = By.xpath("//*[contains(text(), 'Apply')]");
    //private By applyBtn = By.xpath("//*[contains(text(), 'Apply')]");
    private By choosePlanBtn = By.xpath("//*[contains(text(),'Choose this plan')]");
    private By nextBtn = By.xpath("//*[contains(text(), 'Next')]");
    private By payNowBtn = By.xpath("//*[contains(text(), 'Pay now')]");
    private By finishBtn = By.xpath("//*[contains(text(), 'Finish')]");
    private By dontShowAgainBtn = By.xpath("//*[contains(text(), 'show again')]");
    private By updateBtn = By.xpath("//*[contains(text(), 'Update')]");
    private By addMoreCreditsBtn = By.xpath("//*[contains(text(),'Add more credits')]");
    private By paymentCompletedLabel = By.xpath("//*[contains(text(), 'Payment Complete')]");
    private By matchStoreInfoBtn = By.xpath("(//*[contains(text(), 'New Branch')]//preceding::button)[last()]");
    private By paymentInfo_couponInput = By.id("paymentInfo_coupon");
    private By ccnumberInput = By.id("ccnumber");
    private By paymentInfo_ownerNameInput = By.id("paymentInfo_ownerName");
    private By ccexpInput = By.id("ccexp");
    private By cvvInput = By.id("cvv");
    private By paymentInfo_zipCodeInput = By.id("paymentInfo_zipCode");
    private By profile_jdPowerAccessBtn = By.id("profile_jdPowerAccess");

    private By notificationStatus = By.xpath("//*[@role=\"status\"]");
    private By couponApplied = By.xpath("//*[contains(text(), 'Coupon applied')]");





    private By oTTOinspectorSlider= By.xpath("//*[contains(text(),'1.05 USD')]");
    private By oTTOverifySlider= By.xpath("//*[contains(text(),'1.06 USD')]");
    private By oTTOsignSlider= By.xpath("//*[contains(text(),'1.07 USD')]");
    private By jDPowerSlider= By.xpath("//*[contains(text(),'query by month')]");
    private By okBtn= By.xpath("//*[contains(text(),'Ok') or contains(text(),'OK')]");
    private By oTTOsignOption= By.xpath("//button[contains(text(),'OTTOsign')]");
    private By allDocumentsOption= By.xpath("//thead//input");
    private By lastDocuOption= By.xpath("(//tbody//input)[last()]");
    private By applyDocumentsOption= By.xpath("//button[contains(text(),'Apply selected documents')]");



    public NewCompanyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setTypeCompanyInput(String typeCompany) {
        driver.findElement(typeCompanyInput).click();
        if (typeCompany.equalsIgnoreCase("lender")) {
            driver.findElement(lenderOption).click();
        } else {
            driver.findElement(dealerOption).click();
        }
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

    public void setZipCodeInput(String zipCode) throws InterruptedException {
        driver.findElement(zipCodeInput).clear();
        driver.findElement(zipCodeInput).sendKeys(zipCode);
        Thread.sleep(5000); //Todo real value is 800
        driver.findElement(zipCodeInput).sendKeys(Keys.ENTER);
        Thread.sleep(2000); //Todo real value is 800
    }


    public void webSiteInput(String profile_webSite) throws InterruptedException {
        driver.findElement(profile_webSiteInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(profile_webSiteInput).sendKeys(profile_webSite);
        Thread.sleep(000); //Todo real value is 800
    }

    public void setCityInput(String city) {
        driver.findElement(cityInput).sendKeys(city);
    }

    public void setStateInput(String state) {
        driver.findElement(stateInput).sendKeys(state);
    }

    public void submitCompany() throws InterruptedException {
        Thread.sleep(3000); //Todo Delete cos Zipcode
        WebElement submitBtnElement = driver.findElement(submitBtn);
        Actions actions = new Actions(driver);
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, submitBtn);
        actions.moveToElement(submitBtnElement).click().perform();
        webAction.highlightElement(submitBtnElement);
    }

    public void clickAddNewBranch() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(addNewBranchBtn).click();
    }

    public void setBranchNameInput(String branchName) {
        driver.findElement(branchNameInput).sendKeys(branchName);
    }

    public void setBranchEmailInput(String branchEmail) {
        driver.findElement(branchEmailInput).sendKeys(branchEmail);
    }

    public void setBranchPhoneNumberInput(String branchPhoneNumber) {
        driver.findElement(branchPhoneNumberInput).sendKeys(branchPhoneNumber);
    }

    public void setBranchBusinessAddressInput(String branchBusinessAddress) {
        driver.findElement(branchBusinessAddressInput).sendKeys(branchBusinessAddress);
    }

    public void setBranchZipCodeInput(String branchZipCode) throws InterruptedException {
        int count = 0;
        Thread.sleep(1000);
        driver.findElement(branchZipCodeInput).sendKeys(branchZipCode);
        Thread.sleep(1000);
        driver.findElement(branchZipCodeInput).sendKeys(Keys.ENTER); // Todo review It submits the info when ENTER is pressed
        Thread.sleep(3000);
        while (driver.findElement(branchCityInput).getAttribute("value").equalsIgnoreCase("") & count < 4) {
            count++;
            driver.findElement(branchZipCodeInput).clear();
            driver.findElement(branchZipCodeInput).sendKeys(Keys.ENTER);
            Thread.sleep(5000);
        }
    }

    public void submitBranch() throws InterruptedException {
        Thread.sleep(3000);
        WebElement submitBranchBtnElement = driver.findElement(submitBranchBtn);
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, submitBranchBtn);
        driver.findElement(submitBranchBtn).click();
        webAction.highlightElement(submitBranchBtnElement);
    }

    public boolean searchBranch(String branchName) throws InterruptedException {
        String branchFirstName = branchName;
        if (branchName.contains(" ")) {
            branchFirstName = branchName.split(" ")[0];
        }
        driver.findElement(searchBranchInput).sendKeys(branchFirstName);
        Thread.sleep(500);
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, checkBranchFound);
        return true;
/*
        String totalRecordsText = driver.findElement(numBranchesMatched).getText();
        if (totalRecordsText.contains("1")) {
            return true;
        } else {
            return false;
        }*/
    }

    //Store-Office
    public void setOfficeNameInput(String officeName) {
        driver.findElement(officeNameInput).sendKeys(officeName);
    }

    public void setOfficeEmailInput(String officeEmail) {
        driver.findElement(officeEmailInput).sendKeys(officeEmail);
    }

    public void setOfficePhoneNumberInput(String officePhoneNumber) {
        driver.findElement(officePhoneNumberInput).sendKeys(officePhoneNumber);
    }

    public void setOfficeBusinessAddressInput(String officeBusinessAddress) {
        driver.findElement(officeBusinessAddressInput).sendKeys(officeBusinessAddress);
    }

    public void setOfficeZipCodeInput(String officeZipCode) throws InterruptedException {
        driver.findElement(officeZipCodeInput).sendKeys(officeZipCode);
        Thread.sleep(700);
        driver.findElement(officeZipCodeInput).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        //driver.findElement(zipCodeSearchOfficeIcon).click();
    }

    public void submitOffice() throws InterruptedException {
        Thread.sleep(3000);
        WebElement submitOfficeBtnElement = driver.findElement(submitOfficeBtn);
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, submitOfficeBtn);
        driver.findElement(submitOfficeBtn).click();
        webAction.highlightElement(submitOfficeBtnElement);
    }

    public void goToStore() {
        driver.findElement(storeOpc).click();
    }

    public void clickOnSubscriptions() {
        driver.findElement(subscriptionsOpc).click();
    }

    public void clickAddNewStore() throws Exception {
        Thread.sleep(3000);
        driver.findElement(addNewStoreButton).click();
    }

    public boolean validateSubmitOK() {
        return driver.findElement(notificationSuccessfully).isDisplayed(); // Todo I expect a false value, but It throws an error
    }

    public void setOfficeBranchNameInput(String branchName) throws Exception {

        WebElement branchInput = driver.findElement(officeBranchNameInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(branchInput).click().perform();

        Thread.sleep(500);
        for (WebElement branch : driver.findElements(officeBranchNameOptions)) {
            if (branch.getText().equalsIgnoreCase(branchName)) {
                branch.click();
                break;
            }
        }
    }

    // Users methods
    public void goToUsers() {
        driver.findElement(usersOpc).click();
    }

    public void clickUsersOption() {
        driver.findElement(usersOpcLP).click();
    }

    public void clickAddNewUser() throws Exception {
        Thread.sleep(3000);
        driver.findElement(addNewUserButton).click();
    }

    public void setUserBranchNameInput(String branchName) throws Exception {
        WebElement branchInput = driver.findElement(userBranchNameInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(branchInput).click().perform();

        Thread.sleep(500);
        for (WebElement branch : driver.findElements(userBranchNameOptions)) {
            if (branch.getText().equalsIgnoreCase(branchName)) {
                branch.click();
                break;
            }
        }
    }

    public void setUserStoreNameInput(String storeName) throws Exception {
        WebElement storeInput = driver.findElement(userStoreNameInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(storeInput).click().perform();

        Thread.sleep(500);
        for (WebElement store : driver.findElements(userStoreNameOptions)) {
            if (store.getText().equalsIgnoreCase(storeName)) {
                store.click();
                break;
            }
        }
    }

    public void setUserFirstNameInput(String firstName) {
        driver.findElement(userFirstNameInput).sendKeys(firstName);
    }


    public void setUserLastNameInput(String lastName) {
        driver.findElement(userLastNameInput).sendKeys(lastName);
    }

    public void setUserEmailInput(String emailAddress) {
        driver.findElement(userEmailInput).sendKeys(emailAddress);
    }

    public void setUserPhoneNumberInput(String phoneNumber) {
        driver.findElement(userPhoneNumberInput).sendKeys(phoneNumber);
    }

    public void setUserBusinessAddressInput(String businessAddress) {
        driver.findElement(userBusinessAddressInput).sendKeys(businessAddress);
    }

    public void setUserZipCodeInput(String zipCode) throws InterruptedException {
        driver.findElement(userZipCodeInput).sendKeys(zipCode);
        Thread.sleep(500);
        driver.findElement(userZipCodeInput).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    public void submitUser() throws InterruptedException {
        Thread.sleep(3000);
/*        driver.findElement(submitUserBtn).sendKeys(Keys.ARROW_UP);
        driver.findElement(submitUserBtn).sendKeys(Keys.ARROW_UP);
        driver.findElement(submitUserBtn).sendKeys(Keys.ARROW_UP);
        driver.findElement(submitUserBtn).sendKeys(Keys.ARROW_UP);*/

        WebElement submitUserBtnElement = driver.findElement(submitUserBtn);
        WebAction webAction = new WebAction(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(submitUserBtn)).perform();
        webAction.waitToBeClickable(driver, submitUserBtn);
        actions.moveToElement(driver.findElement(submitUserBtn)).click().perform();
        //driver.findElement(submitUserBtn).click();
        webAction.highlightElement(submitUserBtnElement);

    }

    public void setUserRolInput(String userRol) throws InterruptedException {
        WebElement rolInput = driver.findElement(userRolInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(rolInput).click().perform();

        Thread.sleep(500);
        for (WebElement rol : driver.findElements(userRolOptions)) {
            if (rol.getText().equalsIgnoreCase(userRol)) {
                rol.click();
                break;
            }
        }
    }

    public boolean searchUser(String userName) throws InterruptedException {
        int totalRecordsNum = 0;
        Thread.sleep(3000);
        driver.findElement(searchUserInput).sendKeys(userName);
        Thread.sleep(500);
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, checkUserFound);
        return true;

/*        for (WebElement totalRecord : driver.findElements(numUserMatched)) {
            if (totalRecord.isDisplayed()){
                totalRecordsNum =   Integer.parseInt(totalRecord.getText().replaceAll("[^0-9]", ""));
                if (totalRecordsNum >= 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;*/
    }

    public void goToQueue() {
        driver.findElement(queueOpc).click();
    }

    public void clickAddNewQueue() throws Exception {
        Thread.sleep(3000);
        driver.findElement(addNewQueueButton).click();
/*        for (WebElement storeButton : driver.findElements(addNewQueueButton)) {
            if (storeButton.isDisplayed()){
                storeButton.click();
                break;
            }
        }*/

    }

    public boolean searchOffice(String officeName) throws InterruptedException {
        String officeFirstName = officeName;
        if (officeName.contains(" ")) {
            officeFirstName = officeName.split(" ")[0];
        }
        driver.findElement(searchOfficeInput).sendKeys(officeFirstName);
        Thread.sleep(500);
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, checkOfficeFound);
        return true;
    }

    public void clickFreeOption() {
        try {
            WebAction webAction = new WebAction(driver);
            webAction.waitVisibilityOf(driver, freeOptionButton);
            driver.findElement(freeOptionButton).click();
        } catch (Exception e) {
        }

    }

    public boolean verifyNotificationSuccessfully() {
        return driver.findElement(notificationMessage).isDisplayed();
    }

    //**** Roles Methods

    public void goToRoles() {
        driver.findElement(rolesOpc).click();
    }

    public void clickAddNewRole() throws Exception {
        Thread.sleep(3000);
        driver.findElement(addNewRoleButton).click();
    }

    public void setEmployeePosition(String companyName) {
        driver.findElement(employeePositionInput).sendKeys(companyName + " Manager");
    }

    public void setRolDescription() {
        driver.findElement(rolDescriptionInput).sendKeys("Manager");
    }

    public void setBaseRole() throws InterruptedException {
        driver.findElement(baseRoleInput).click();
        Thread.sleep(800);
        driver.findElement(baseRoleInput).sendKeys(Keys.ENTER);
    }

    public void submitRole() throws InterruptedException {
        Thread.sleep(3000);
        WebElement submitRoleBtnElement = driver.findElement(submitRoleBtn);
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, submitRoleBtn);
        driver.findElement(submitRoleBtn).click();
        webAction.highlightElement(submitRoleBtnElement);

    }



    public void setApplyBtn(By applyBtn) {
        this.applyBtn = applyBtn;
    }

    public void clickOnChoosePlanBtn() {
        driver.findElement(choosePlanBtn).click();
    }

    public void clickOnNewBranchBtn() throws InterruptedException {
        driver.findElement(newBranchBtn).click();
        Thread.sleep(1000);
        driver.findElement(submitBtn_).click();
    }

    public void clickOnMatchStoreInfoBtn() {
        driver.findElement(matchStoreInfoBtn).click();

    }

    public void setPaymentCompletedLabel(By paymentCompletedLabel) {
        this.paymentCompletedLabel = paymentCompletedLabel;
    }



    public void setPaymentInfo_couponInput(String discountCoupon) throws InterruptedException {
        driver.findElement(paymentInfo_couponInput).sendKeys(discountCoupon);
        driver.findElement(applyBtn).click();
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, couponApplied);
        webAction.waitInVisibilityOf(driver, couponApplied);
    }

    public String getNotificationsStatus() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver,notificationStatus );
        return driver.findElement(notificationStatus).getText();
    }

    public void setCcnumberInput(String ccnumber) throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.findElement(ccnumberInput).click();
        Thread.sleep(1000);
        driver.findElement(ccnumberInput).click();
        actions.moveToElement(driver.findElement(ccnumberInput)).sendKeys(ccnumber).perform();
    }

    public void setPaymentInfo_ownerNameInput(String ownerName) {
        Actions actions = new Actions(driver);
        driver.findElement(paymentInfo_ownerNameInput).click();
        actions.moveToElement(driver.findElement(paymentInfo_ownerNameInput)).sendKeys(ownerName).perform();
    }

    public void setCcexpInput(String ccexp) {
        Actions actions = new Actions(driver);
        driver.findElement(ccexpInput).click();
        actions.moveToElement(driver.findElement(ccexpInput)).sendKeys(ccexp).perform();
    }

    public void setCvvInput(String cvv) {
        Actions actions = new Actions(driver);
        driver.findElement(cvvInput).click();
        actions.moveToElement(driver.findElement(cvvInput)).sendKeys(cvv).perform();
    }

    public void setPaymentInfoZipCodeInput(String cvv) {
        Actions actions = new Actions(driver);
        driver.findElement(paymentInfo_zipCodeInput).click();
        driver.findElement(paymentInfo_zipCodeInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        actions.moveToElement(driver.findElement(paymentInfo_zipCodeInput)).sendKeys(cvv).perform();
    }

    public void clickOnNextBtn() {
        driver.findElement(nextBtn).click();
    }

    public void clickOnPayNowBtn() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(payNowBtn).click();
    }
    public void clickOnFinishBtn() throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, finishBtn);
        webAction.highlightElement(driver.findElement(finishBtn));
        driver.findElement(finishBtn).click();
        Thread.sleep(3000);
    }

    public boolean isPaymentCompleted() {
        return driver.findElement(paymentCompletedLabel).isDisplayed();
    }

    public void clickOnDontShowAgain() throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        Actions actions = new Actions(driver);
        webAction.waitVisibilityOf(driver, dontShowAgainBtn);
        webAction.waitToBeClickable(driver, dontShowAgainBtn);
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(dontShowAgainBtn)).click().perform();
        webAction.waitInVisibilityOf(driver, dontShowAgainBtn);
    }

    public void clickOnJdPowerAccessBtn() throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver,profile_jdPowerAccessBtn );
        Thread.sleep(1000);
        driver.findElement(profile_jdPowerAccessBtn).click();
    }

    public void clickOnUpdate() throws InterruptedException {
        //driver.findElement(updateBtn).click();
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        WebAction webAction = new WebAction(driver);
        webAction.highlightElement(driver.findElement(updateBtn));
        actions.moveToElement(driver.findElement(updateBtn)).click().perform();
        webAction.waitVisibilityOf(driver, notificationStatus);
        webAction.waitInVisibilityOf(driver, notificationStatus);
    }

    public void clickOnAddMoreCredits() {
        driver.findElement(addMoreCreditsBtn).click();
    }

    public void setoTTOinspectorSlider() {
        driver.findElement(oTTOinspectorSlider).click();
    }

    public void setoTTOverifySlider( ) {
        driver.findElement(oTTOverifySlider).click();
    }

    public void setoTTOsignSlider( ) {
        driver.findElement(oTTOsignSlider).click();
    }

    public void setjDPowerSlider( ) {
        driver.findElement(jDPowerSlider).click();
    }

    public void clickOnOK() {
        driver.findElement(okBtn).click();
    }

    public void selectOTTOsignTab() {
        driver.findElement(oTTOsignOption).click();
    }

    public void selectAllDocumentList() {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, allDocumentsOption);
        driver.findElement(allDocumentsOption).click();
    }

    public void lastOneDocumentList() {
        driver.findElement(lastDocuOption).click();
    }

    public void selectNewDocument(String agreement_to_provide_insurance) {
    }

    public void clickOnApplyDocuments() {
        WebElement _applyDocumentsOption = driver.findElement(applyDocumentsOption);
        if(_applyDocumentsOption.isEnabled()){
            WebAction webAction = new WebAction(driver);
            webAction.waitToBeClickable(driver, _applyDocumentsOption);
            driver.findElement(applyDocumentsOption).click();
            driver.findElement(okBtn).click();
        }
    }
}
