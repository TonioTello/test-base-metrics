package starter.pages.companies;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import starter.utils.WebAction;

public class CreateRelationshipPage {
    private WebDriver driver;

    private By notificationMessage = By.xpath("//*[contains(text(),'Relation requests sent') or contains(text(),'Relationship request sent')]");
    private By notificationMessageDone = By.xpath("//*[contains(text(),'Office relations created')]");
    private By relationShipOpc = By.xpath("//*[@href=\"/relationships\"]");
    private By newRelationShipBtn = By.xpath("//*[@href=\"/relationships/new\"]");
    private By searchNewRInput = By.xpath("//input[contains(@placeholder, 'Search')]"); //Todo
    private By selectLender = By.xpath("//*[@type=\"checkbox\"]"); //Todo
    private By selectStoreQueue = By.xpath("//*[@type=\"radio\" or @type=\"checkbox\"]"); //Todo
    private By selectStoreOpc = By.xpath("//*[@type=\"checkbox\"]"); //Todo
    private By sendInvitationBtn = By.xpath("//*[contains(text(), 'Send Invitation')]");
    private By goBackBtn = By.xpath("//*[contains(text(), 'back to relationships')]");
    private By nextBtn = By.xpath("//*[contains(text(), 'Next')]");
    private By approveRequestBtn = By.xpath("//*[contains(text(),'Accept request')]");
    private By acceptRelationshipBtn = By.xpath("//*[@aria-label=\"Accept Relationship\"]");
    private By selectedQueueOpc = By.xpath("//*[@type=\"radio\"]");
    //private By assignQueueBtn  = By.xpath("//*[contains(text(),'Assign queue')]");
    private By pendingRequestOpc = By.xpath("//*[contains(text(), 'Pending requests')]"); // Todo xpath took it from chrome
    private By searchDealerInput = By.xpath("//*[@placeholder=\"Search\" or @placeholder=\"search\"]");
    private By selectLenderFound = By.xpath("//*[@type=\"checkbox\"]");
    private By searchBranchInput = By.xpath("//input[contains(@placeholder, 'Search')]"); // Todo xpath took it from chrome
    private By reviewRequestBtn = By.xpath("//*[contains(@href, 'relationships/')]");
    private By gottenQueue = By.xpath("//*[@type=\"checkbox\"][preceding::td]");
    private By assignQueueBtn = By.xpath("//*[contains(text(), 'Assign Queue') or contains(text(), 'Assign queue')]");
    private By acceptRequestBtn = By.xpath("//*[contains(text(), 'Accept Request') or contains(text(), 'Accept request')]");
    private By requestsReceivedTag = By.xpath("//*[contains(text(),'Requests Received')]");
    private By gottenBranch = By.xpath("//button[contains(@class, 'uppercase')][preceding::input]");  // Todo soft Xpath
    private By branchInput = By.xpath("(//*[@class=\"ant-modal\"]//input)[1]");
    private By queueInput = By.xpath("(//*[@class=\"ant-modal\"]//input)[2]");
    private By assignThisQueueBtn = By.xpath("//*[contains(text(),'Assign to this Queue')]");
    private By selectBranchOption = By.xpath("(//*[@class=\"ant-select-item-option-content\"])[1]");
    private By selectQueueOption = By.xpath("(//*[@class=\"ant-select-item-option-content\"])[2]");
    private By deleteRelationshipOpt = By.xpath("//*[contains(@aria-label,'End Relationship')]");
    private By deleteRelationshipBtn = By.xpath("//span[contains(text(), 'End relationship')]");

    private By approvedLabel = By.xpath("//*[contains(text(), 'Approved') or contains(text(), 'approved')]");

    private By notificationStatus = By.xpath("//*[@role=\"status\"]");


    public CreateRelationshipPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRelationshipsOpc() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, relationShipOpc);
        webAction.waitToBeClickable(driver, relationShipOpc);
        driver.findElement(relationShipOpc).click();
    }

    public void clickNewRelationshipsOpc() {
        driver.findElement(newRelationShipBtn).click();
    }

    public void searchSelectLender(String lender) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(searchNewRInput).sendKeys(lender);
        driver.findElement(searchNewRInput).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        try {
            driver.findElement(selectLender).click();

        } catch (Exception e) {
            Assert.assertTrue("Lender is not Available", false);
        }
    }

    public void searchSelectStoreQueue(String lender) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(selectStoreQueue)).click().perform();
    }

    public void clickSendInvitation() throws InterruptedException {
        driver.findElement(sendInvitationBtn).click();
        Thread.sleep(3000);
        driver.findElement(goBackBtn).click();
    }

    public boolean getNotificationMsj() {
        boolean isVisible = true;

        try {
            isVisible = driver.findElement(notificationMessage).isDisplayed();
        } catch (Exception e) {
            return isVisible = false;
        }
        return isVisible;
    }

    public String verifyNotificationSuccessfully() {
        String status = "";
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, notificationStatus);
        status = driver.findElement(notificationStatus).getText();
        return status;
    }

    public boolean getNotificationMsjDone() {
        boolean isVisible = true;

        try {
            isVisible = driver.findElement(notificationMessageDone).isDisplayed();
        } catch (Exception e) {
            return isVisible = false;
        }
        return isVisible;
    }

    public void clickPendingRequestOpc() {
        driver.findElement(pendingRequestOpc).click();
    }

    public void searchSelectDealer(String dealer) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(searchDealerInput).sendKeys(dealer);
        Thread.sleep(1000);
        //driver.findElement(searchDealerInput).sendKeys(Keys.ENTER);
        driver.findElement(selectLenderFound).click();
    }

    public void clickReviewRequest() {
        driver.findElement(reviewRequestBtn).click();
    }

    public void searchAssignBranch(String branch) {
        driver.findElement(searchBranchInput).sendKeys(branch);
        driver.findElement(searchBranchInput).sendKeys(Keys.ENTER);
        driver.findElement(gottenBranch).click();
        driver.findElement(gottenQueue).click();
        driver.findElement(assignQueueBtn).click();
    }

    public void searchAssignQueue(String queue) {
        driver.findElement(branchInput).click();
        driver.findElement(selectBranchOption).click();
        driver.findElement(queueInput).click();
        driver.findElement(selectQueueOption).click();
        driver.findElement(assignThisQueueBtn).click();

    }

    public void deleteRelationship() throws InterruptedException {
        if (driver.findElement(deleteRelationshipOpt).isDisplayed()) {
            driver.findElement(deleteRelationshipOpt).click();
            Thread.sleep(500);
            driver.findElement(deleteRelationshipBtn).click();
            WebAction webAction = new WebAction(driver);
            webAction.waitInVisibilityOf(driver, notificationStatus);
        }
    }

    public String verifyApprovedLabel() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(approvedLabel).getText();
    }


    public void clickOnNext() {
        driver.findElement(nextBtn).click();
    }

    public void clickOnApproveRequest() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, approveRequestBtn);
        driver.findElement(approveRequestBtn).click();
    }

    public void clickOnAcceptRelationship() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, acceptRelationshipBtn);
        driver.findElement(acceptRelationshipBtn).click();

    }

    public void selectQueueOption() {
        driver.findElement(selectedQueueOpc).click();
    }

    public void clickOnAssignQueue() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, assignQueueBtn);
        driver.findElement(assignQueueBtn).click();
    }

    public void acceptRequestConfirmation() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, acceptRequestBtn);
        driver.findElement(acceptRequestBtn).click();
    }

    public void clickOnRequestsReceived() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, requestsReceivedTag);
        webAction.waitToBeClickable(driver, requestsReceivedTag);
        driver.findElement(requestsReceivedTag).click();
    }
}