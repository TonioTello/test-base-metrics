package starter.controllers.applications;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import starter.pages.applications.AppInfoPage;
import starter.pages.applications.EditAppLenderPage;
import starter.pages.applications.HomePage;

public class ApproveAppController {

    public void searchNewApplicationMax(WebDriver driver, String appNumber) {
        try {
            HomePage homePage = new HomePage(driver);
            Thread.sleep(2000); // Wait data load
            homePage.clickOTTOMOTOmaxOpc();
            homePage.searchApp(appNumber, false);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Search New Application in OTTOMOTOmax", false);
        }
    }

    public void searchNewApplicationHome(WebDriver driver, String applicationNum) {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickHomeOpc();
            homePage.searchAppHomeDealer(applicationNum);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Search New Application in Home", false);
        }
    }

    public void claimApp(WebDriver driver) {
        try {
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            appInfoPage.clickClaimButton();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Claim the Application", false);
        }
    }
    public void sendMessage(WebDriver driver, String message) {
        try {
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            appInfoPage.setTextMessageInput(message);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error typing the text message for the other users...", false);
        }
    }

    public void approveApp(WebDriver driver) {
        try {
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            appInfoPage.clickApproveButton();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Approving the App: " + e, false);
        }
    }

    public void validateApproveLabel(WebDriver driver) {
        try {
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            HomePage homePage = new HomePage(driver);
            Assert.assertEquals("The Application was not Approve", "Approved", appInfoPage.verifyApprovedLabel());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Validating Approve Label", false);
        }
    }

    public void updateNewAppLenderForm(WebDriver driver, String typeApplication, String lenderGap, String gapCommission, String lenderServiceContract, String serviceContractCommission, String lenderOther, String otherCommission, String dealerGap, String dealerWarranty, String dealerOther) {
        try {
            EditAppLenderPage editAppLenderPage = new EditAppLenderPage(driver);
            Thread.sleep(3000);
            if (typeApplication.equalsIgnoreCase("loan")){ //editAppLenderPage.getTypeOfApplication().equalsIgnoreCase("loan")
                editAppLenderPage.clickMatch();
                editAppLenderPage.setLenderGapInput(lenderGap);
                editAppLenderPage.setLenderGapCommissionInput(gapCommission);
                editAppLenderPage.setLenderWarrantyInput(lenderServiceContract);
                editAppLenderPage.setLenderWarrantyCommissionInput(serviceContractCommission);
                editAppLenderPage.setLenderOtherInput(lenderOther);
                editAppLenderPage.setLenderOtherCommissionInput(otherCommission);
                //editAppLenderPage.setLineFiveInput("5000");  // Todo changed --> adjust robot
                editAppLenderPage.setDealerGapInput(dealerGap);
                editAppLenderPage.setDealerWarrantyInput(dealerWarranty);
                editAppLenderPage.setDealerOtherInput(dealerOther);
                editAppLenderPage.setLoanProcessingFeeInput("10");
                editAppLenderPage.setLenderFeesInput("10");


                Thread.sleep(2000);
                System.out.println("unpaidBalanceDealer = " + editAppLenderPage.getUnpaidBalanceInput());
                System.out.println("calculedpaymentDealer = " + editAppLenderPage.getCalculatedPaymentInput());
                System.out.println("TotalCheckLender = " + editAppLenderPage.getTotalCheckLenderInput());
                System.out.println("AmountFinancedLender = " + editAppLenderPage.getAmountFinancedLenderInput());

            }else {
                editAppLenderPage.clickMatch();
                editAppLenderPage.setLenderGapLeaseInput(lenderGap);
                editAppLenderPage.setLenderGapCommissionLeaseInput(gapCommission);
                editAppLenderPage.setLenderWarrantyLeaseInput(lenderServiceContract);
                editAppLenderPage.setLenderWarrantyCommissionLeaseInput(serviceContractCommission);
                editAppLenderPage.setLenderOtherLeaseInput(lenderOther);
                editAppLenderPage.setLenderOtherCommissionLeaseInput(otherCommission);
                editAppLenderPage.setDealerGapLeaseInput(dealerGap);
                editAppLenderPage.setDealerWarrantyLeaseInput(dealerWarranty);

                Thread.sleep(2000);
                System.out.println("unpaidBalanceDealer = " + editAppLenderPage.getUnpaidBalanceLeaseInput());
                System.out.println("calculedpaymentDealer = " + editAppLenderPage.getCalculatedPaymentLeaseInput());
                System.out.println("TotalCheckLender = " + editAppLenderPage.getTotalCheckLenderLeaseInput());

            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Lender Updating the New Application : " + e, false);
        }
    }

    public void validateNotificationMsj(WebDriver driver) {
        try {
            String notificationStatus = "";
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            notificationStatus = appInfoPage.verifyNotificationSuccessfully();
            Assert.assertTrue("The notification message was not successfully : " + notificationStatus, notificationStatus.contains("successfully"));
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the notification message", false);
        }
    }


}
