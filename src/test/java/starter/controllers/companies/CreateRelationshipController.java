package starter.controllers.companies;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import starter.pages.applications.AppInfoPage;
import starter.pages.companies.CreateRelationshipPage;
import starter.utils.WebAction;

public class CreateRelationshipController {
    public void selectNewRelationship(WebDriver driver) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            createRelationshipPage.clickRelationshipsOpc();
            //endPreviousRelationship(driver); // Delete if there is any
            createRelationshipPage.clickNewRelationshipsOpc();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("e = " + e);
            Assert.assertTrue("Error selecting relationship: "
                    + e.toString().substring(e.toString().indexOf("org.openqa.selenium"), e.toString().indexOf("(Session info")).replaceAll("\n", ""),
                    false);
        }
    }

    public void searchLender2(WebDriver driver, String lender) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            createRelationshipPage.clickOnNext();
            createRelationshipPage.searchSelectLender(lender);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendInvitation(WebDriver driver) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            createRelationshipPage.clickSendInvitation();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void validateNotificationMsj(WebDriver driver) {
        try {
            String notificationStatus, notificationStatus2 = "";
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            notificationStatus = createRelationshipPage.verifyNotificationSuccessfully();
            Assert.assertTrue("The notification message was not successfully : " + notificationStatus, notificationStatus.contains("successfully") || notificationStatus.contains("Accepting request"));
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            WebAction webAction = new WebAction(driver);
            webAction.validateRequiredAlert();
            Assert.assertTrue("Error getting the successfully notification message: " +e , false);
        }
    }

    public void validateNotificationMsjDone(WebDriver driver) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            Assert.assertTrue("The relation was not completed.", createRelationshipPage.getNotificationMsjDone());
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void goToPendingRequest(WebDriver driver) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            createRelationshipPage.clickRelationshipsOpc();
            createRelationshipPage.clickPendingRequestOpc();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void goToRelationship(WebDriver driver) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            createRelationshipPage.clickRelationshipsOpc();

        }catch (Exception e){
            Assert.fail("Error goToRelationship " + e);
        }
    }

    public void validateApproveLabel(WebDriver driver) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            Assert.assertEquals("The Application was not Approve", "Approved", createRelationshipPage.verifyApprovedLabel());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Validating Approve Label", false);
        }
    }

    public void searchDealer(WebDriver driver, String dealer) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            createRelationshipPage.searchSelectDealer(dealer);
            createRelationshipPage.clickReviewRequest();
        }catch (Exception e){
            Assert.fail("Error searchDealer: " + e);
        }
    }

    public void searchDealerLenderSide(WebDriver driver, String dealer) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            createRelationshipPage.searchSelectDealer(dealer);
        }catch (Exception e){
            Assert.fail("Error searchDealerLenderSide: " + e);
        }
    }

    public void searchLender(WebDriver driver, String dealer) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            createRelationshipPage.searchSelectDealer(dealer);
            createRelationshipPage.clickReviewRequest();
        }catch (Exception e){
            Assert.fail("Error searchLender: " + e);
        }
    }

    public void assignBranch(WebDriver driver, String branch, String queue) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            createRelationshipPage.searchAssignBranch(branch);
            createRelationshipPage.searchAssignQueue(queue);
        }catch (Exception e){
            Assert.fail("Error assignBranch: " + e);
        }
    }

    public void endPreviousRelationship(WebDriver driver) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            createRelationshipPage.deleteRelationship();
        }catch (Exception e){

        }
    }


    public void selectStoreQueue(WebDriver driver, String storeQueue) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            //createRelationshipPage.searchSelectLender();
            createRelationshipPage.searchSelectLender(storeQueue);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectStoreQueueLenderSide(WebDriver driver, String storeQueue) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            Thread.sleep(3000);
            createRelationshipPage.searchSelectStoreQueue(storeQueue);
            createRelationshipPage.clickOnNext();

        }catch (Exception e){
            Assert.fail("Error selectStoreQueueLenderSide: " + e);
        }
    }

    public void approveRequest(WebDriver driver) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            createRelationshipPage.clickOnRequestsReceived();
            createRelationshipPage.clickOnAcceptRelationship();
            createRelationshipPage.clickOnApproveRequest();
        }catch (Exception e){
            Assert.fail("Error when user try to approve the relationship request: " + e);
        }
    }

    public void approveDealerRequest(WebDriver driver) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            createRelationshipPage.clickOnRequestsReceived();
            createRelationshipPage.clickOnAcceptRelationship();
           // createRelationshipPage.clickOnApproveRequest();
        }catch (Exception e){
            Assert.fail("Error when user try to approve the relationship request: " + e);
        }
    }

    public void queueAssignment(WebDriver driver) {
        try {
            CreateRelationshipPage createRelationshipPage = new CreateRelationshipPage(driver);
            createRelationshipPage.selectQueueOption();
            createRelationshipPage.clickOnAssignQueue();
            createRelationshipPage.acceptRequestConfirmation();
        }catch (Exception e){
            Assert.fail("Error queueAssignment: " + e);
        }
    }
}
