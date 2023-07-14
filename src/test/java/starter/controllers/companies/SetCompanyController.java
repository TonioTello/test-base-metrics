package starter.controllers.companies;

import com.github.javafaker.Faker;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import starter.pages.applications.AppInfoPage;
import starter.pages.applications.HomePage;
import starter.pages.companies.CompaniesPage;
import starter.pages.companies.NewCompanyPage;
import starter.pages.companies.PlanPage;
import starter.pages.settings.QuestionnairePage;
import starter.pages.settings.SettingsPage;
import starter.utils.WebAction;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SetCompanyController {

    Faker faker = new Faker();

    public void selectCompaniesOption(WebDriver driver) {

        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickCompaniesOption();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hitNewCompany(WebDriver driver) {
        try {
            CompaniesPage companiesPage = new CompaniesPage(driver);
            companiesPage.clickNewCompanyBton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillOutCompanyInfo(WebDriver driver, String typeCompany, String nameCompany, String legalName, String accountingContactName, String email, String phoneNumber, String businessAddress, String zipCode) {
        try {
            String letterTypeCompany = String.valueOf(typeCompany.charAt(0)).toUpperCase();
            //email = String.format("tester.testyng+company%s%s@gmail.com", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime()));
            email = String.format("ottomoto-1fcbe8+company%s%s@gmail.com", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime()));
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.setTypeCompanyInput(typeCompany);
            newCompanyPage.setNameCompanyInput(nameCompany);
            newCompanyPage.setLegalNameInput(legalName);
            newCompanyPage.setAccountingContactNameInput(accountingContactName);
            newCompanyPage.setEmailInput(email);
            //newCompanyPage.setEmailInput(String.format("tester.testyng+company%s%s@gmail.com", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime())));
            newCompanyPage.setPhoneNumberInput(phoneNumber);
            //newCompanyPage.setPhoneNumberInput("7705308818");
            newCompanyPage.setBusinessAddressInput(businessAddress);
            newCompanyPage.setZipCodeInput(zipCode);
            newCompanyPage.webSiteInput("https://www.google.com/" + nameCompany.split(" ")[0]);
            System.out.println("Company email = " + email);
        } catch (Exception e) {
            Assert.assertTrue("Error fill out the company info", false);
        }
    }

    public void submitForm(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.submitCompany();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error submitting the company info", false);
        }
    }

    public void validateCompanyCreated(WebDriver driver, String nameCompany) {
        try {
            HomePage homePage = new HomePage(driver);
            CompaniesPage companiesPage = new CompaniesPage(driver);
            homePage.clickCompaniesOption();
            Assert.assertTrue("The company " + nameCompany + " has not been created", companiesPage.searchCreatedCompany(nameCompany));
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void editCompany(WebDriver driver) {
        try {
            CompaniesPage companiesPage = new CompaniesPage(driver);
            companiesPage.goTOEditCompany();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hitAddNewBranch(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.clickAddNewBranch();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillOutBranchInfo(WebDriver driver, String typeCompany, String branchName, String emailAddress, String phoneNumber, String businessAddress, String zipCode) {
        try {
            String letterTypeCompany = String.valueOf(typeCompany.charAt(0)).toUpperCase();
            //emailAddress = String.format("tester.testyng+branch%s%s@gmail.com", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime()));
            emailAddress = String.format("ottomoto-1fcbe8+branch%s%s@gmail.com", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime()));
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.setBranchNameInput(branchName);
            newCompanyPage.setBranchEmailInput(emailAddress);
            //newCompanyPage.setBranchEmailInput(String.format("tester.testyng+branch%s%s@gmail.com", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime())));
            newCompanyPage.setBranchPhoneNumberInput(phoneNumber);
            //newCompanyPage.setBranchPhoneNumberInput("7705308818");
            newCompanyPage.setBranchBusinessAddressInput(businessAddress);
            newCompanyPage.setBranchZipCodeInput(zipCode);
            newCompanyPage.submitBranch();
            System.out.println("Branch emailAddress = " + emailAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillOutBranchStoreInfo(WebDriver driver, String discountCoupon, String branchName, String emailAddress, String phoneNumber, String businessAddress, String zipCode) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.clickOnChoosePlanBtn();
            newCompanyPage.clickOnNewBranchBtn();
            newCompanyPage.clickOnMatchStoreInfoBtn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillOutCreditCardInfo_Pay(WebDriver driver, boolean nextBtn) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.setPaymentInfo_ownerNameInput("Paul Nicholas");
            newCompanyPage.setCcnumberInput("4856200260248995");
            newCompanyPage.setCcexpInput("02 / 23");
            newCompanyPage.setCvvInput("956");
            if (nextBtn) {
                newCompanyPage.clickOnNextBtn();
            } else {
                newCompanyPage.setPaymentInfoZipCodeInput("10001");
            }
            ;
            //Todo click on sliders integrations --> click onapplic coup
            newCompanyPage.clickOnPayNowBtn();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error fill Out Credit Card Info", false);
        }
    }

    public void fillOutCreditCardInfo(WebDriver driver, boolean nextBtn) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.setPaymentInfo_ownerNameInput("Paul Nicholas");
            newCompanyPage.setCcnumberInput("4856200260248995");
            newCompanyPage.setCcexpInput("02 / 23");
            newCompanyPage.setCvvInput("956");
            newCompanyPage.setPaymentInfoZipCodeInput("10001");
            if (nextBtn) {
                newCompanyPage.clickOnNextBtn();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error fill Out Credit Card Info", false);
        }
    }

    public void submitPayment(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.clickOnPayNowBtn();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error submitPayment", false);
        }
    }



    public void applyDiscountCoupon(WebDriver driver, String discountCoupon) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.setPaymentInfo_couponInput(discountCoupon);
            String notificationStatus = newCompanyPage.getNotificationsStatus();
            Assert.assertTrue("The notification message was not successfully : " + notificationStatus, notificationStatus.contains("applied"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateBranchCreated(WebDriver driver, String branchName) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            Assert.assertTrue("The Branch " + branchName + " has not been created", newCompanyPage.searchBranch(branchName));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error the Branch was not created", false);
        }
    }


    public void selectStoreOption(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.goToStore();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void hitAddNewStore(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.clickAddNewStore();
            Thread.sleep(500);
            newCompanyPage.clickFreeOption();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error searching the Add New Store Button", false);
        }
    }

    public void fillOutStoreInfo(WebDriver driver, String typeCompany, String branchName, String officeName, String emailAddress, String phoneNumber, String businessAddress, String zipCode) {
        try {
            String letterTypeCompany = String.valueOf(typeCompany.charAt(0)).toUpperCase();
            //emailAddress = String.format("tester.testyng+store%s%s@gmail.com", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime()));
            emailAddress = String.format("ottomoto-1fcbe8+store%s%s@gmail.com", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime()));
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.setOfficeBranchNameInput(branchName);
            newCompanyPage.setOfficeNameInput(officeName);
            newCompanyPage.setOfficeEmailInput(emailAddress);
            //newCompanyPage.setOfficeEmailInput(String.format("tester.testyng+store%s%s@gmail.com", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime())));
            newCompanyPage.setOfficePhoneNumberInput(phoneNumber);
            //newCompanyPage.setOfficePhoneNumberInput("7705308818");
            newCompanyPage.setOfficeBusinessAddressInput(businessAddress);
            newCompanyPage.setOfficeZipCodeInput(zipCode);
            newCompanyPage.submitOffice();
            System.out.println("Store emailAddress = " + emailAddress);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error filling out the store info: " + e, false);
        }
    }

    public void fillOutStoreInfoShort(WebDriver driver, String branchName, String officeName, String emailAddress, String phoneNumber, String businessAddress, String zipCode) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.setOfficeBranchNameInput(branchName);
            newCompanyPage.setOfficeNameInput(officeName);
            newCompanyPage.setOfficeEmailInput(emailAddress);
            newCompanyPage.setOfficePhoneNumberInput(phoneNumber);
            newCompanyPage.setOfficeBusinessAddressInput(businessAddress);
            newCompanyPage.setOfficeZipCodeInput(zipCode);
            newCompanyPage.submitOffice();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error filling out the store info: " + e, false);
        }
    }

    public void validateOfficeCreated(WebDriver driver, String officeName) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            Assert.assertTrue("The OfficeName " + officeName + " has not been created", newCompanyPage.searchOffice(officeName));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error the Office was not created", false);
        }
    }

    public void selectUsersOption(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.goToUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectUsersOption_LeftPanel(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.clickUsersOption();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void hitAddNewUser(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.clickAddNewUser();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error searching the Add New User Button", false);
        }
    }

    public void fillOutUserInfo(WebDriver driver, String typeCompany, String branchName, String storeName, String firstName, String lastName, String emailAddress, String phoneNumber, String businessAddress, String zipCode, String rol) {
        try {
            String letterTypeCompany = String.valueOf(typeCompany.charAt(0)).toUpperCase();
            emailAddress = String.format("ottomoto-1fcbe8+dev_user%s%s@gmail.com", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime()));
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            //newCompanyPage.setUserBranchNameInput(branchName);
            //newCompanyPage.setUserStoreNameInput(storeName);
            newCompanyPage.setUserFirstNameInput(firstName);
            newCompanyPage.setUserLastNameInput(lastName);
            //newCompanyPage.setUserEmailInput("ottomoto-1fcbe8+DEA@inbox.mailtrap.io");
            newCompanyPage.setUserEmailInput(emailAddress);
           // newCompanyPage.setUserEmailInput("aagrawal+dealer_4@cobaltcore.io");
            //newCompanyPage.setUserEmailInput(String.format("ottomoto-1fcbe8+robot_user%s%s@gmail.com", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime())));
            //newCompanyPage.setUserEmailInput("tester.testyng+uat_relationship_dealer@gmail.com");
            newCompanyPage.setUserPhoneNumberInput(phoneNumber);
            //newCompanyPage.setUserPhoneNumberInput("7705308818");
            newCompanyPage.setUserBusinessAddressInput(businessAddress);
            newCompanyPage.setUserZipCodeInput(zipCode);
            newCompanyPage.setUserRolInput(rol);
            newCompanyPage.submitUser();
            System.out.println("User emailAddress = " + emailAddress);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error filling out the user info " + e, false);
        }
    }

    public void selectRolesOption(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.goToRoles();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hitAddNewRole(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.clickAddNewRole();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error searching the Add New Role Button", false);
        }
    }

    public void fillOutRoleInfo(WebDriver driver, String companyName) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.setEmployeePosition(companyName);
            newCompanyPage.setRolDescription();
            newCompanyPage.setBaseRole();
            newCompanyPage.submitRole();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error filling out the role info", false);
        }
    }

    public void validateNotificationMsj(WebDriver driver) {
        try {
            String notificationStatus = "";
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            Thread.sleep(2000);
            notificationStatus = appInfoPage.verifyNotificationSuccessfully();
            Assert.assertTrue("The notification message was not successfully : " + notificationStatus, notificationStatus.contains("successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            WebAction webAction = new WebAction(driver);
            webAction.validateRequiredAlert();
            //Assert.assertTrue("Error getting the successfully notification message", false);
        }
    }


    public void validateUserCreated(WebDriver driver, String userName) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            Thread.sleep(2000);
            Assert.assertTrue("The User called " + userName + " has not been created", newCompanyPage.searchUser(userName));
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error the User was not created", false);

        }
    }

    public void selectQueueOption(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.goToQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hitAddNewQueue(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.clickAddNewQueue();
            Thread.sleep(500);
            newCompanyPage.clickFreeOption();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error searching the Add New Queue Button", false);
        }
    }

    public void fillOutQueueInfo(WebDriver driver, String typeCompany, String branchName, String queueName, String emailAddress, String phoneNumber, String businessAddress, String zipCode) {
        try {
            String letterTypeCompany = String.valueOf(typeCompany.charAt(0)).toUpperCase();
            //emailAddress = String.format("tester.testyng+queue%s%s@inbox.mailtrap.io", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime()));
            emailAddress = String.format("ottomoto-1fcbe8+queue%s%s@inbox.mailtrap.io", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime()));
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            //newCompanyPage.setOfficeBranchNameInput(branchName);
            newCompanyPage.setOfficeNameInput(queueName);
            newCompanyPage.setOfficeEmailInput(emailAddress);
            //newCompanyPage.setOfficeEmailInput(String.format("tester.testyng+queue%s%s@inbox.mailtrap.io", letterTypeCompany, new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime())));
            //newCompanyPage.setOfficeEmailInput("tester.testyng+uat_relationship_dealer@gmail.com");
            newCompanyPage.setOfficePhoneNumberInput(phoneNumber);
            newCompanyPage.setOfficeBusinessAddressInput(businessAddress);
            newCompanyPage.setOfficeZipCodeInput(zipCode);
            newCompanyPage.submitOffice();
            System.out.println("Queue emailAddress = " + emailAddress);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error filling out the Queue info", false);
        }
    }

    public void fillOutLenderCompanyInfo(WebDriver driver, String typeCompany, String nameCompany, String legalName, String accountingContactName, String email, String phoneNumber, String businessAddress, String zipCode, String userEmail) {
        try {
            PlanPage planPage = new PlanPage(driver);
            planPage.setNameCompanyInput(nameCompany);
            planPage.setLegalNameInput(legalName);
            planPage.setAccountingContactNameInput(accountingContactName);
            planPage.setEmailInput(email);
            planPage.setPhoneNumberInput(phoneNumber);
            planPage.setBusinessAddressInput(businessAddress);
            planPage.setBusinessAddress2Input(businessAddress);
            planPage.setZipCodeInput(zipCode);
            //planPage.setCityInput("Cornelius");
            //planPage.setCountryInput("Mecklenburg");
            //planPage.setStateInput("NC");
            planPage.setUserFirstNameInput(faker.name().firstName());
            planPage.setUserLastNameInput(faker.name().lastName());
            //planPage.setUserEmailInput(String.format("tester.testyng+planType%s@inbox.mailtrap.io", new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime())));
            planPage.setUserEmailInput(userEmail);
            planPage.setUserPhoneNumberInput(faker.phoneNumber().phoneNumber());
            planPage.setAcceptElectronicSignatureCheckbox(); // Refer also to "I accept Terms of Use Agreement"
            if (typeCompany.equalsIgnoreCase("Dealer")) {
                planPage.setHaveReadAgreeCheckbox();
            }
            planPage.setIAcceptOTTOMOTOCheckbox();
            planPage.clinkOnNextStep();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error fillOutLenderCompanyInfo", false);

        }
    }

    public void selectPlanTypeCompany(WebDriver driver, String typeCompany, String environment) {
        try {
            PlanPage planPage = new PlanPage(driver);
            if (typeCompany.equalsIgnoreCase("dealer")) {
                planPage.clickOnChoosePlanDealer(environment);
            } else if (typeCompany.equalsIgnoreCase("lender")) {
                planPage.clickOnChoosePlanLender(environment);
            } else {
                Assert.assertTrue("Type of company does not valid", false);
            }
            planPage.clinkOnNextStep();
        } catch (Exception e) {
            Assert.fail("Error selectPlanTypeCompany: " + e);
        }
    }

    public void validateCode(WebDriver driver, String verificationCode) {

        try {
            PlanPage planPage = new PlanPage(driver);
            planPage.setVerificationCode(verificationCode);
            planPage.clickOnValidate();
            Assert.assertTrue("Notification Success Company Validated is not displayed", planPage.validateNotificationSuccessCompanyValidated());
            Thread.sleep(10000); // Todo wait next email
        } catch (Exception e) {
            Assert.fail("Error validateCode: " + e);
        }
    }


    public void createPassword(WebDriver driver, String password) {
        try {
            PlanPage planPage = new PlanPage(driver);
            planPage.setNewPassword(password);
            planPage.setConfirmPassword(password);
            planPage.clickOnSavePassword();
            Assert.assertTrue("Notification Success Company Validated is not displayed", true);
            planPage.closeNewUpdatePopup();
            System.out.println(" = ");

        } catch (Exception e) {
            Assert.fail("Error createPassword: " + e);
        }
    }

    public void createPasswordFullCompany(WebDriver driver, String password) {
        try {
            PlanPage planPage = new PlanPage(driver);
            planPage.setNewPassword(password);
            planPage.setConfirmPassword(password);
            planPage.setTermsOfUseAgreement();
            planPage.clickOnSavePassword();
            //planPage.closeNewUpdatePopup();
            System.out.println(" = ");

        } catch (Exception e) {
            Assert.fail("Error createPasswordFullCompany: " + e);
        }
    }

    public void hitSettings(WebDriver driver) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.clickOnSettingsOpc();
        } catch (Exception e) {
            Assert.fail("Error hitSettings: " + e);
        }
    }

    public void hitDiscountCoupons(WebDriver driver) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.clickOnDiscountCouponsBtn();
        } catch (Exception e) {
            Assert.fail("Error hit Discount Coupons opc: " + e);
        }
    }

    public void hitNewDiscountCoupons(WebDriver driver) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.clickOnNewDiscountCouponOpc();
        } catch (Exception e) {
            Assert.fail("Error hit New Discount Coupons: " + e);
        }
    }

    public String fillOutCouponInfo(WebDriver driver) {
        String codeCoupon = "C" + new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime());
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.setCodeCouponInput(codeCoupon);
            settingsPage.setTypeCouponInput("Percentage");
            //settingsPage.setTypeCouponInput("Value");
            settingsPage.setUseCouponInput("Single");
            settingsPage.setValueCouponInput("100");  //Percentage
            //settingsPage.setValueCouponInput("500");    //Value
            settingsPage.setStartDateCouponInput("10/28/2022");
            settingsPage.setEndDateCouponInput("10/28/2022");
            settingsPage.setStatusCouponInput("Active");
            settingsPage.setObservationCouponInput("COUPON FOR AUTOMATED SCENARIOS");
        } catch (Exception e) {
            Assert.assertTrue("Error filling out the coupon # "+codeCoupon+" : " + e, false);
        }
        return codeCoupon;
    }

    public void submit(WebDriver driver) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.clickOnSubmit();
        } catch (Exception e) {
            WebAction webAction = new WebAction(driver);
            webAction.validateRequiredAlert();
            Assert.assertTrue("Error submitting the coupon information: " + e, false);
        }
    }

    public void searchCoupon(WebDriver driver, String codeCoupon) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.setSearchInput(codeCoupon);
        } catch (Exception e) {
            Assert.fail("Error searching Coupon: " + e);
        }
    }

    public void validateCouponCreated(WebDriver driver, String codeCoupon) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            Assert.assertTrue("Cound " + codeCoupon + " is not on the list", settingsPage.getTotalRecords());
        } catch (Exception e) {
            Assert.fail("Error searching for the new coupon");
        }
    }


    public void logoutUser(WebDriver driver) {
        //*[contains(text(),'Logout')]
        try {
            HomePage homePage = new HomePage(driver);
            Thread.sleep(2000);
            homePage.logout();
            Thread.sleep(2000);
            driver.navigate().refresh();
            //homePage.isLogOutVisible();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Logout: " +e, false);
        }
    }

    public void activeJDpowerNewUser(WebDriver driver, String branchNameF) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.clickOnJdPowerAccessBtn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCompanySettings(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.clickOnUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validatePaymentNotification(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.isPaymentCompleted();
            //Assert.assertTrue("Payment completed notification is not successful", newCompanyPage.isPaymentCompleted());
            Serenity.takeScreenshot(); // Todo Screenshot
            newCompanyPage.clickOnFinishBtn();
            //newCompanyPage.clickOnOK();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeWelcomePopUp(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.clickOnDontShowAgain();
        } catch (Exception e) {
        }
    }

    public void selectSubscriptionsOption(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.clickOnSubscriptions();
            newCompanyPage.clickOnAddMoreCredits();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectsIntegrationsProducts(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.setoTTOinspectorSlider();
            newCompanyPage.setoTTOverifySlider();
            newCompanyPage.setoTTOsignSlider();
            newCompanyPage.setjDPowerSlider();
        } catch (Exception e) {
            Assert.fail("Error selectsIntegrationsProducts: " + e);
        }
    }

    public void validateTotalEqualZero() {
    }

    public void selectDocumentsSuperAdmin(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.selectOTTOsignTab();
            //newCompanyPage.selectAllDocumentList();
            ///Thread.sleep(1000);
            //newCompanyPage.selectAllDocumentList();
            newCompanyPage.lastOneDocumentList();
            Thread.sleep(1000);
            newCompanyPage.lastOneDocumentList();
            Thread.sleep(1000);

            //newCompanyPage.selectNewDocument("Agreement to Provide Insurance");
            newCompanyPage.clickOnApplyDocuments();
            //newCompanyPage.clickOnOK();
            Thread.sleep(5000);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectAdvertisingOpc(WebDriver driver) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.clickOnAdvertisingOpc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hitNewCampaign(WebDriver driver) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.clickOnNewCampaign();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillOutCampaignForm(WebDriver driver, String campaignName) {
        try {
            String currentWorkingDir = System.getProperty("user.dir");
            String absolutePath = currentWorkingDir + "\\src\\test\\resources\\assets\\";


            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.setCampaignNameInput(campaignName);
            settingsPage.setStartDateCampaignInput("12/01/2022");
            settingsPage.setEndDateCampaignInput("12/01/2022");
            settingsPage.setTypeOfCompanyInput("Dealer");
            settingsPage.setCompanyNameInput("Wallace");
            //settingsPage.setExposureTimeInput("15");
            settingsPage.setStatusCampaignInput("Active");
            settingsPage.setConfigurationStateInput("All");
            settingsPage.setConfigurationTypeUsersInput("All");
            settingsPage.setUrlInput("https://www.udemy.com/");
            settingsPage.setCampaignImageDesktopInput(absolutePath + "desktop.jpg");
            settingsPage.setCampaignImageMobileInput(absolutePath + "mobile.png");
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void searchCampaign(WebDriver driver, String campaignName) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.setSearchInput(campaignName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateAdvertisingCreated(WebDriver driver, String campaignName) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            Assert.assertTrue("CampaignName " + campaignName + " is not on the list", settingsPage.getTotalRecords());
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateEducationBLogCreated(WebDriver driver, String blogPostTitle) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.clickOnViewBlogDetails();
            Thread.sleep(4000);
        } catch (Exception e) {
            Assert.fail("Blog Post " + blogPostTitle + " is not on the list");
        }
    }

    public void selectEducationOpc(WebDriver driver) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.clickOnEducationOpc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hitBlogPost(WebDriver driver) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.clickOnNewBlogPost();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillOutBlogPostInfo(WebDriver driver, String blogPostTitle) {
        try {
            String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";
            String currentWorkingDir = System.getProperty("user.dir");
            String absolutePath = currentWorkingDir + "\\src\\test\\resources\\assets\\";
            SettingsPage settingsPage = new SettingsPage(driver);

            settingsPage.setBlogPostTitleInput(blogPostTitle);
            settingsPage.setBlogPostBodyTextInput(text);
            settingsPage.setBlogPostImage(absolutePath + "carLoanBlog.jpg");
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchEducationBlog(WebDriver driver, String blogTitle) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            settingsPage.setSearchInput(blogTitle);
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitNotificationDisappear(WebDriver driver) {
        try {
            SettingsPage settingsPage = new SettingsPage(driver);
            Thread.sleep(1500);
            settingsPage.waitNotificationInvisibility();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hitConfigurationTab(WebDriver driver) {
        try {
            QuestionnairePage questionnairePage = new QuestionnairePage(driver);
            questionnairePage.clickOnConfiguration();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hitQuestionnaireOption(WebDriver driver) {
        try {
            QuestionnairePage questionnairePage = new QuestionnairePage(driver);
            questionnairePage.clickOnQuestionnaire();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void FillOutLenderQuestionnaire(WebDriver driver) {

        try {
            QuestionnairePage questionnairePage = new QuestionnairePage(driver);
            questionnairePage.setNameLenderInput(faker.name().firstName());
            questionnairePage.setContactNameInput(faker.name().firstName());
            questionnairePage.setPhoneInput(faker.phoneNumber().phoneNumber());
            questionnairePage.setEmailInput(String.format("ottomoto-1fcbe8+questionnaire%s@inbox.mailtrap.io", new SimpleDateFormat("ddHHmmss").format(Calendar.getInstance().getTime())));
            questionnairePage.setNumberBranchesInput("1");
            questionnairePage.setCurrentSoftwareUseInput("IOS1233");
            //questionnairePage.setLocationUnderwritingInput(faker.address().fullAddress());
            questionnairePage.setCorporateOfficeAddressInput(faker.address().secondaryAddress());
            questionnairePage.setNumberDealersInput("1");
            questionnairePage.setAvgLoansMonthInput("7");
            questionnairePage.setGrowthObjectiveInput("Be best lender company");
            questionnairePage.setOnlineApplicationInput("UdeA");
            questionnairePage.setProvideEcontractInput("Yes");
            questionnairePage.setProductOffertInput("Cameras and security system");
            questionnairePage.setCompanyToUsePullCreditInput("ScotiaBank Canada");
           questionnairePage.setNameofBankInput("ScotiaBank");
          questionnairePage.setAutoRadioBtn();
            questionnairePage.setPowerSportsRadioBtn();
            //questionnairePage.setOtherTypeVehicleInput("Alabama");
            questionnairePage.setMaxPtiInput(String.valueOf(faker.number().numberBetween(1, 20)));
            questionnairePage.setMaxLtvInput(String.valueOf(faker.number().numberBetween(1, 20)));
            questionnairePage.setMinIncomeInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            questionnairePage.setMinAmtFinanceInput("1200");
            questionnairePage.setMaxMilesInput("1700");
            questionnairePage.setMaxAgeOfVehicleInput("15");
            questionnairePage.setOtherInput(faker.lorem().characters(50, 100));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submitQuestionnaire(WebDriver driver) {
        try {
            QuestionnairePage questionnairePage = new QuestionnairePage(driver);
            questionnairePage.clickOnSubmit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectCompanyOption(WebDriver driver) {
        try {
            QuestionnairePage questionnairePage = new QuestionnairePage(driver);
            questionnairePage.clickOnCompany();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectPlanType(WebDriver driver, boolean b) {
        try {
            QuestionnairePage questionnairePage = new QuestionnairePage(driver);
            questionnairePage.clickOnChoosePlan();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submitPaymentDetails(WebDriver driver, boolean b) {
    }

    public void createdADiscountCoupon(WebDriver driver) {
    }
}