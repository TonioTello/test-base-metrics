package starter.controllers.applications;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import starter.pages.applications.AppInfoPage;
import starter.pages.applications.HomePage;
import starter.pages.applications.NewAppPage;
import starter.utils.InternalAction;
import starter.utils.WebAction;

public class ClaimAppController {

    InternalAction internalAction = new InternalAction();

    public void searchNewApplicationsOTTOMOTOmax(WebDriver driver, String appNumber) {
        try {
            HomePage homePage = new HomePage(driver);
            Thread.sleep(2000); // Wait data load
            homePage.clickOTTOMOTOmaxOpc();
            homePage.searchApp(appNumber, false);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(String.format("Error Search New Application <#%s> in OTTOMOTOmax: "  + e, appNumber), false);
        }
    }

    public void searchNewApplicationsHome(WebDriver driver, String appNumber, Boolean isValidation) {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.searchApp(appNumber, isValidation);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Search New Application",false );
        }
    }

    public void claimApp(WebDriver driver) {
        try {
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            appInfoPage.clickClaimButton();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Claim the Application " + e, false );

        }
    }


    public void submitApptoLender(WebDriver driver, String leader) {
        try {
            String notificationStatus = "";
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            appInfoPage.selectLender(leader);

            //appInfoPage.setTextMessageInput("Message from dealer to lender");
            appInfoPage.clickOnSubmitTotheLender();
            appInfoPage.clickUpdateButton();
            notificationStatus = appInfoPage.verifyNotificationSuccessfully();
            Assert.assertTrue("The notification message was not successfully : " + notificationStatus, notificationStatus.contains("successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            //Assert.assertTrue("Error Submit Application to Lender", false );
            internalAction.logError("Error Submit Application to Lender", e);

        }

    }
    public void submitAppCopytoLender(WebDriver driver, String leader) {
        try {
            String notificationStatus = "";
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            appInfoPage.selectLender("Demo Tech");
            appInfoPage.clickOnSubmitTotheLender();
            appInfoPage.clickUpdateButton();
            notificationStatus = appInfoPage.verifyNotificationSuccessfully();
            Assert.assertTrue("The notification message was not successfully : " + notificationStatus, notificationStatus.contains("successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Submit Application to Lender: " + e, false );
            //internalAction.logError("Error Submit Application to Lender", e);

        }

    }



    public void validateAppLabel(WebDriver driver, String appNumber, String status) {
        try {
            HomePage homePage = new HomePage(driver);
            Assert.assertTrue("The Application number "+appNumber+" has not been " + status, homePage.getAppLabelStatus(status).contains(status) );
        } catch (Exception e) {
            e.printStackTrace();
            //Assert.assertTrue("Error Validating Application Label",false );
            internalAction.logError("Error Validating Application Label", e);

        }
    }

    public void validateTradeInfo(WebDriver driver, String tradeInfo) {
        try {
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            Assert.assertEquals("The Trade-In information is not displayed", tradeInfo, appInfoPage.getTradeVinValue() );
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Validating Trade-In Information",false );
        }
    }

    public void validateAppValuesDealer(WebDriver driver) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            Assert.assertTrue("Field VehicleInfoGvwr is not equal", newAppPage.getVehicleInfoGvwrInput().equalsIgnoreCase("517") );

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error filling out the others fields for full Application", false);
        }

    }
}
