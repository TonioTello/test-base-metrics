package starter.controllers.applications;

import com.github.javafaker.Faker;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import starter.pages.applications.*;
import starter.pages.externals.GabiPage;
import starter.utils.InternalAction;
import starter.utils.WebAction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CreateAppController {
    Faker faker = new Faker();
    InternalAction internalAction = new InternalAction();

    public void hitNewApplication(WebDriver driver) {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickNewAppButton();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error going to New Application", false);
        }
    }

    public int numberApplications(WebDriver driver) {
        int numApps = 0;
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickHomeOpc();
            numApps = homePage.getNumberApplications(); // new APp
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the number of Applications: " + e, false);
        }
        return numApps;
    }

    public void fillOutDefaultFields(WebDriver driver, String numberOfLender, String numberOfDeader, String firstName, String lastName, String dateOfBirth, String socialSecurity, String state, String zipCode, String incomeApplicant) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.setNumberOfLenderInput(1);
            newAppPage.setNumberOfDeaderInput(1);
            newAppPage.setDateOfBirthInput("06/30/2000"); // Todo
            newAppPage.setSocialSecurityInput("555 55 5555"); //Todo
            newAppPage.setState("AK"); //faker.address().state()
            newAppPage.setZipCodeInput(faker.address().zipCode());
            newAppPage.setIncomeApplicantInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            newAppPage.setIncomeApplicantFrequencyIdInput("Yearly");
            //newAppPage.setTextMessageInput("Message from applicant to dealer");
            newAppPage.setTermsConditionsOption();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error filling out the mandatory form information: " + e, false);
        }
    }

    public void fillOutFormUnRegisteredApplicant(WebDriver driver, String numberOfLender, String numberOfDeader, String firstName, String lastName, String dateOfBirth, String socialSecurity, String state, String zipCode, String incomeApplicant, String unRegisterApplicantEmail) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            Thread.sleep(2000);
            newAppPage.setFirstNameInput(faker.name().firstName());
            newAppPage.setLastNameInput(faker.name().lastName());
            newAppPage.setDateOfBirthInput("08/12/1998");
            newAppPage.setSocialSecurityInput("555 55 5555"); //Todo
            newAppPage.setState("AK"); //faker.address().state()
            newAppPage.setZipCodeInput("10001"); //faker.address().zipCode()
            newAppPage.setEmailInput(unRegisterApplicantEmail);
            newAppPage.setPhoneInput(faker.phoneNumber().phoneNumber());
            newAppPage.setHomeAddressInput(faker.address().fullAddress());
            newAppPage.setIncomeApplicantInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error filling out the form for unregistered applicant " + e, false);
        }
    }

    public void fillOutDealerForm(WebDriver driver, String typeApplication) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            Thread.sleep(2000);
            //newAppPage.selectLender("Demo Tech");
            newAppPage.setFirstNameInput(faker.name().firstName());
            newAppPage.setLastNameInput(faker.name().lastName());
            newAppPage.setDateOfBirthInput("08/12/1998");
            newAppPage.setSocialSecurityInput("555 55 5555"); //Todo
            newAppPage.setState("AK"); //faker.address().state()
            newAppPage.setZipCodeInput("10001"); //faker.address().zipCode()
            newAppPage.setEmailInput("fake_email+" + faker.number().numberBetween(10, 100) + faker.internet().emailAddress());
            //newAppPage.setPhoneInput(faker.phoneNumber().phoneNumber());
            newAppPage.setPhoneInput("2489852669");
            //newAppPage.setHomeAddressInput(faker.address().fullAddress());
            newAppPage.setHomeAddressInput("21222 E KIRCKLAND LN APARTMENT 1");
            newAppPage.setIncomeApplicantInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            newAppPage.setIncomeApplicantFrequencyIdInput("Yearly");
            newAppPage.setTypeApplicantInput(typeApplication);
/*            newAppPage.setVinInfoInput("1C6RD6KT4CS332867");

            newAppPage.setVehicleInfoBodyStyleOrTrimInput("PU LTZ");
            newAppPage.setVehicleInfoMilesInput("47000");
            newAppPage.setVehicleInfoColorInput("Aluminum");
            newAppPage.setVehicleInfoGvwInput("003500");  // Todo It is submitted with a Enter
            newAppPage.setVehicleInfoGvwrInput("517");   // Todo field does not accept the value (517 KG) It shoud show up the addcional information
            newAppPage.setVehicleInfoMsrpInput("17000");
            newAppPage.setVehicleInfoWeightInput("1524");
            newAppPage.setVehicleInfoIsComercialVehicleInput(true);
            newAppPage.setVehicleInfoIsNewInput(false);
            newAppPage.setVehicleInfoNotesInput("notes");*/

            //Mandatory fields when a the app is send to the lender

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error fillOutDealerForm: " + e, false);
        }
    }

    public void fillOutVehicleInfo(WebDriver driver, String typeApplication) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);


            newAppPage.setVinInfoInput("1C6RD6KT4CS332867");

            newAppPage.setVehicleInfoBodyStyleOrTrimInput("PU LTZ");
            newAppPage.setVehicleInfoMilesInput("47000");
            newAppPage.setVehicleInfoColorInput("Aluminum");
            newAppPage.setVehicleInfoGvwInput("003500");  // Todo It is submitted with a Enter
            newAppPage.setVehicleInfoGvwrInput("517");   // Todo field does not accept the value (517 KG) It shoud show up the addcional information
            newAppPage.setVehicleInfoMsrpInput("17000");
            newAppPage.setVehicleWholeSaleInput("7000");
            newAppPage.setVehicleInfoWeightInput("1524");
            newAppPage.setVehicleInfoIsComercialVehicleInput(true);
            newAppPage.setVehicleInfoIsNewInput(false);
            newAppPage.setVehicleInfoNotesInput("notes");

            //Mandatory fields when a the app is send to the lender

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error fillOutDealerForm: " + e, false);
        }
    }

    public void fillOutDealerDefaultFields(WebDriver driver, String typeApplication) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            Thread.sleep(2000);
            //newAppPage.selectLender("Demo Tech");
            newAppPage.setFirstNameInput(faker.name().firstName());
            newAppPage.setLastNameInput(faker.name().lastName());
            newAppPage.setDateOfBirthInput("08/12/1998");
            newAppPage.setSocialSecurityInput("555 55 5555"); //Todo
            newAppPage.setState("AK"); //faker.address().state()
            newAppPage.setZipCodeInput("10001"); //faker.address().zipCode()
            newAppPage.setEmailInput("fake_email+" + faker.number().numberBetween(10, 100) + faker.internet().emailAddress());
            //newAppPage.setPhoneInput(faker.phoneNumber().phoneNumber());
            newAppPage.setPhoneInput("2489852669");
            //newAppPage.setHomeAddressInput(faker.address().fullAddress());
            newAppPage.setHomeAddressInput("21222 E KIRCKLAND LN APARTMENT 1");
            newAppPage.setIncomeApplicantInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            newAppPage.setIncomeApplicantFrequencyIdInput("Yearly");
            newAppPage.setTypeApplicantInput(typeApplication);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error fillOutDealerDefaultFields: " + e, false);
        }
    }

    public void fillOutDealerSimpleForm(WebDriver driver, String typeApplication) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            Thread.sleep(2000);
            //newAppPage.selectLender("Demo Tech");
            newAppPage.setFirstNameInput(faker.name().firstName());
            newAppPage.setLastNameInput(faker.name().lastName());
            newAppPage.setDateOfBirthInput("08/12/1998");
            newAppPage.setSocialSecurityInput("555 55 5555"); //Todo
            newAppPage.setDriversLicenseInput("012345678");
            newAppPage.setState("AK"); //faker.address().state()
            newAppPage.setZipCodeInput("10001"); //faker.address().zipCode()
            newAppPage.setEmailInput("fake_email+" + faker.number().numberBetween(10, 100) + faker.internet().emailAddress());
            //newAppPage.setPhoneInput(faker.phoneNumber().phoneNumber());
            newAppPage.setPhoneInput("2489852669");
            newAppPage.setHomeAddressInput(faker.address().fullAddress());
            newAppPage.setIncomeApplicantInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            newAppPage.setIncomeApplicantFrequencyIdInput("Yearly");

            newAppPage.setIncomeEmployerNameInput(faker.name().name());
            newAppPage.setIncomeWorkPhoneNumberInput("7864206154");
            newAppPage.setIncomeExtInput("123");
            newAppPage.setIncomeHomeAddressInput("13025 Roselle Ave");//(faker.address().fullAddress());
            newAppPage.setIncomeHomeAddressLine2Input("13025 Roselle Ave");//(faker.address().secondaryAddress());
            newAppPage.setIncomeHomeSuiteNumberInput("1007");
            newAppPage.setIncomeZipCodeInput("90250");
            newAppPage.setIncomeSupervisorNameInput("Rohan");
            newAppPage.setIncomePositionDepartmentInput(faker.job().position());
            //newAppPage.setIncomeApplicant_employmentStatusInput("Active Military"); // It comes for default
            newAppPage.setIncomeApplicant_yearsAtJobInputInput("4");
            newAppPage.setIncomeMonthsAtJobInput("2");
            newAppPage.setTypeApplicantInput(typeApplication);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error fillOutDealerSimpleForm: " + e, false);
        }
    }

    public void fillOutDealerFormForLender(WebDriver driver, String typeApplication, String lender) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.selectLender(lender);
            newAppPage.setHousingStatusIdInput("Rent");
            newAppPage.setMonthlyPaymentInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            newAppPage.setIncomeEmployerNameInput(faker.name().name());
            newAppPage.setIncomeApplicant_employmentStatusInput("Active Military"); //Todo review this field is messing for Unregistered applicant
            newAppPage.setLoanCashPriceInput("15000", typeApplication);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error fillOutDealerFormForLender: " + e, false);
        }
    }

    public void fillOutLenderFormForLender(WebDriver driver, String typeApplication, String lender) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            //newAppPage.selectLender(lender);
            newAppPage.setHousingStatusIdInput("Rent");
            newAppPage.setMonthlyPaymentInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            newAppPage.setIncomeEmployerNameInput(faker.name().name());
            newAppPage.setIncomeApplicant_employmentStatusInput("Active Military"); //Todo review this field is messing for Unregistered applicant
            newAppPage.setLoanCashPriceInput("15000", typeApplication);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error fillOutDealerFormForLender: " + e, false);
        }
    }

    public void selectLenderAppCopy(WebDriver driver, String lender) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.selectLender(lender);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error fillOutDealerFormForLender: " + e, false);
        }
    }

    public void fillOutLenderForm(WebDriver driver, String typeApplication) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.setFirstNameInput(faker.name().firstName());
            newAppPage.setLastNameInput(faker.name().lastName());
            newAppPage.setDateOfBirthInput("08/12/1998");
            newAppPage.setSocialSecurityInput("555 55 5555"); //Todo
            newAppPage.setState("AK"); //faker.address().state()
            newAppPage.setZipCodeInput("10001"); //faker.address().zipCode()
            newAppPage.setEmailInput("fake_email+" + faker.number().numberBetween(10, 100) + faker.internet().emailAddress());
            newAppPage.setPhoneInput(faker.phoneNumber().phoneNumber());
            newAppPage.setHomeAddressInput(faker.address().fullAddress());
            newAppPage.setIncomeApplicantInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            newAppPage.setIncomeApplicantFrequencyIdInput("Yearly");
            newAppPage.setTypeApplicantInput(typeApplication);
            //newAppPage.setVehicleInfoMilesInput("47000");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error filling out the lender information: " + e, false);
        }
    }

    public void fillOutDealerMath(WebDriver driver, String typeApplication, String loanTerms, String frequency, String interestRate, String cashPrice, String downPayment, String manufacturerRebate, String securityDeposit, String tradeValue, String tradePayoff, String netTradeValue, String salesTax, String dealerFees, String eTRFee, String licenseFee, String titleFees, String otherFee) {
        try {
            EditAppDealerPage editAppDealerPage = new EditAppDealerPage(driver);
            Thread.sleep(3000);
            //editAppDealerPage.setVinInfoInput("JH4DB1570PS000858");
            editAppDealerPage.setFrequencyInput(frequency);
            if (typeApplication.equalsIgnoreCase("Loan")) {  //editAppDealerPage.getTypeOfApplication().equalsIgnoreCase("Loan")
                editAppDealerPage.setInterestRateInput(interestRate);
                editAppDealerPage.setCashPriceInput(cashPrice);
                editAppDealerPage.setDownPaymentInput(downPayment);
                editAppDealerPage.setManufacturerRebateInput(manufacturerRebate);
                editAppDealerPage.setTradeInValueInput(tradeValue);
                editAppDealerPage.setTradePayOffInput(tradePayoff);
                editAppDealerPage.clickSalesTaxOTTOcalculateButton();
                Thread.sleep(2000);
                editAppDealerPage.setDealerFeesInput(dealerFees);
                editAppDealerPage.setEtrInput(eTRFee);
                editAppDealerPage.setLicenseFeeInput(licenseFee);
                editAppDealerPage.setTitleFeesInput(titleFees);
                editAppDealerPage.setOtherInput(otherFee);
                editAppDealerPage.setOtherDescriptionInput("other fee description");
                Thread.sleep(3000);
                //System.out.println("unpaidBalance = " + editAppDealerPage.getUnpaidBalanceInput());
                //System.out.println("calculedpayment = " + editAppDealerPage.getCalculatedPaymentInput());
            } else {
                editAppDealerPage.setCashPriceLeaseInput(cashPrice);
                editAppDealerPage.setDownPaymentLeaseInput(downPayment);
                editAppDealerPage.setManufacturerRebateLeaseInput(manufacturerRebate);
                editAppDealerPage.securityDepositLeaseInput(securityDeposit);
                editAppDealerPage.setTradeInValueLeaseInput(tradeValue);
                editAppDealerPage.setTradePayOffLeaseInput(tradePayoff);
                editAppDealerPage.setDealerFeesLeaseInput(dealerFees);
                editAppDealerPage.setEtrLeaseInput(eTRFee);
                editAppDealerPage.setLicenseFeeLeaseInput(licenseFee);
                editAppDealerPage.setTitleFeesLeaseInput(titleFees);
                editAppDealerPage.setOtherLeaseInput(otherFee);
                editAppDealerPage.setLeaseOtherDescriptionInput("other fee description");
                Thread.sleep(3000);
                //System.out.println("unpaidBalance = " + editAppDealerPage.getUnpaidBalanceLeaseInput());
                //System.out.println("calculedpayment = " + editAppDealerPage.getCalculatedPaymentLeaseInput());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error updating the payment information: " + e, false);
        }
    }

    public void fillOutLenderMath(WebDriver driver, String typeApplication, String loanTerms, String frequency, String interestRate, String cashPrice, String downPayment, String manufacturerRebate, String securityDeposit, String tradeValue, String tradePayoff, String netTradeValue, String salesTax, String dealerFees, String eTRFee, String licenseFee, String titleFees, String otherFee) {
        try {
            EditAppDealerPage editAppDealerPage = new EditAppDealerPage(driver);
            Thread.sleep(3000);
            //editAppDealerPage.setVinInfoInput("JH4DB1570PS000858");
            editAppDealerPage.setFrequencyInput(frequency);
            if (typeApplication.equalsIgnoreCase("Loan")) {  //editAppDealerPage.getTypeOfApplication().equalsIgnoreCase("Loan")
                editAppDealerPage.setInterestRateInput(interestRate);
                editAppDealerPage.setCashPriceInput(cashPrice);
                editAppDealerPage.setDownPaymentInput(downPayment);
                editAppDealerPage.setManufacturerRebateInput(manufacturerRebate);
                editAppDealerPage.setTradeInValueInput(tradeValue);
                editAppDealerPage.setTradePayOffInput(tradePayoff);
                editAppDealerPage.clickSalesTaxOTTOcalculateButton();
                Thread.sleep(2000);
                editAppDealerPage.setDealerFeesInput(dealerFees);
                editAppDealerPage.setEtrInput(eTRFee);
                editAppDealerPage.setLicenseFeeInput(licenseFee);
                editAppDealerPage.setTitleFeesInput(titleFees);
                editAppDealerPage.setOtherInput(otherFee);
                editAppDealerPage.setOtherDescriptionInput("other fee description");
                Thread.sleep(3000);
                //System.out.println("unpaidBalance = " + editAppDealerPage.getUnpaidBalanceInput());
                //System.out.println("calculedpayment = " + editAppDealerPage.getCalculatedPaymentInput());
            } else {
                editAppDealerPage.setCashPriceLeaseInput(cashPrice);
                editAppDealerPage.setDownPaymentLeaseInput(downPayment);
                editAppDealerPage.setManufacturerRebateLeaseInput(manufacturerRebate);
                editAppDealerPage.securityDepositLeaseInput(securityDeposit);
                editAppDealerPage.setTradeInValueLeaseInput(tradeValue);
                editAppDealerPage.setTradePayOffLeaseInput(tradePayoff);
                editAppDealerPage.setDealerFeesLeaseInput(dealerFees);
                editAppDealerPage.setEtrLeaseInput(eTRFee);
                editAppDealerPage.setLicenseFeeLeaseInput(licenseFee);
                editAppDealerPage.setTitleFeesLeaseInput(titleFees);
                editAppDealerPage.setOtherLeaseInput(otherFee);
                Thread.sleep(3000);
                //System.out.println("unpaidBalance = " + editAppDealerPage.getUnpaidBalanceLeaseInput());
                //System.out.println("calculedpayment = " + editAppDealerPage.getCalculatedPaymentLeaseInput());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error updating the payment information: " + e, false);
        }
    }

    public void submitUpdating(WebDriver driver) {
        try {
            EditAppDealerPage editAppDealerPage = new EditAppDealerPage(driver);
            editAppDealerPage.updateApplication();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error submitting the updated payment information: " + e, false);
        }
    }

    public void fillOutFormCoApp(WebDriver driver, String firstName, String lastName, String dateOfBirth, String socialSecurity, String state, String zipCode, String incomeApplicant) {
        try {
            CoApplicantPage coApplicantPage = new CoApplicantPage(driver);
            coApplicantPage.selectCoAppTab();
            coApplicantPage.setCoFirstNameInput(faker.name().firstName());
            coApplicantPage.setCoLastNameInput(faker.name().lastName());
            coApplicantPage.setCoDateOfBirthInput("07/22/2000");
            coApplicantPage.setCoSocialSecurityInput("555 55 5555");
            coApplicantPage.setCoState("AK");
            coApplicantPage.setCoZipCodeInput("10001");
            coApplicantPage.setCoIncomeApplicantInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            coApplicantPage.setMiddleNameInput(faker.name().firstName());
            coApplicantPage.setSuffixInput(faker.name().suffix());
            coApplicantPage.setDriversLicenseInput("012345678");
            coApplicantPage.setEmailInput(String.format("appmoto-1fcbe8+coAppFirst%s@inbox.mailtrap.io", new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime())));

            coApplicantPage.setLicenseExpirationInput("07/22/2000");
            coApplicantPage.setSecundaryEmailInput(String.format("appmoto-1fcbe8+coAppSecond%s@inbox.mailtrap.io", new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime())));
            coApplicantPage.setPhoneNumberInput("8159969738");
            coApplicantPage.setSecundaryPhoneNumberInput("9159969739");
            coApplicantPage.setHomeAddressAppInput(faker.address().fullAddress());
            coApplicantPage.setHomeAddressLine2Input(faker.address().secondaryAddress());
            coApplicantPage.setYearsAtAddressInput("2");
            coApplicantPage.setMonthsAtAddressInput("4");
            coApplicantPage.setHousingStatusIdInput("Rent");
            coApplicantPage.setLandlordOrMTGHolderInput(faker.name().firstName());
            coApplicantPage.setMonthlyPaymentInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            coApplicantPage.setIncomeEmployerNameInput(faker.name().name());
            coApplicantPage.setIncomeWorkPhoneNumberInput("7864206154");
            coApplicantPage.setIncomeExtInput("123");
            coApplicantPage.setIncomeHomeAddressInput("8392 South 22nd Cir");
            coApplicantPage.setIncomeHomeAddressLine2Input("8392 South 22nd Cir");
            coApplicantPage.setIncomeHomeSuiteNumberInput("1007");
            coApplicantPage.setIncomeZipCodeInput("10001");
            coApplicantPage.setIncomeSupervisorNameInput("Rohan");
            coApplicantPage.setIncomePositionDepartmentInput(faker.job().position());
            coApplicantPage.setIncomeApplicant_employmentStatusInput("Active Military");
            coApplicantPage.setIncomeApplicant_yearsAtJobInputInput("4");
            coApplicantPage.setIncomeMonthsAtJobInput("2");
            coApplicantPage.setIncomeApplicantFrequencyIdInput("Yearly");
            coApplicantPage.setDateInput("07/22/2000");
            coApplicantPage.selectApplicantTab();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error filling out the Co-Applicant Info: " + e, false);
        }
    }

    public void fillOutForm_VIN(WebDriver driver, String numberOfLender, String numberOfDeader, String firstName, String lastName, String dateOfBirth, String socialSecurity, String state, String zipCode, String incomeApplicant, String tradeInfo) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.setNumberOfLenderInput(Integer.parseInt(numberOfLender));
            newAppPage.setNumberOfDeaderInput(Integer.parseInt(numberOfDeader));
            newAppPage.setFirstNameInput(firstName);
            newAppPage.setLastNameInput(lastName);
            newAppPage.setDateOfBirthInput(dateOfBirth);
            newAppPage.setSocialSecurityInput(socialSecurity);
            newAppPage.setState(state);
            newAppPage.setZipCodeInput(zipCode);
            newAppPage.setIncomeApplicantInput(incomeApplicant);
            newAppPage.setTradeInVinInput(tradeInfo);
            newAppPage.setTermsConditionsOption();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error filling out the VIN information", false);
        }
    }

    public void submitApp(WebDriver driver) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.submitApplication();
        } catch (Exception e) {
            WebAction webAction = new WebAction(driver);
            webAction.validateRequiredAlert();
            e.printStackTrace();
            Assert.assertTrue(String.format("Error submitting the mandatory form info: %s", e), false);
        }
    }

    public void confirmSubmitApp(WebDriver driver) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.clickOnOk();
        } catch (Exception e) {
            e.printStackTrace();
            //Assert.assertTrue(String.format("Error submitting the mandatory form info: %s", e), false);
        }
    }

    public String getNewApplicationNumber(WebDriver driver) {
        String applicationNum = "";
        try {
            HomePage homePage = new HomePage(driver);
            applicationNum = homePage.getNewApplicationNum(); // new APp
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the NewApplicationNumber: " + e, false);
        }
        return applicationNum;
    }

    public String getNewApplicationNumberLender(WebDriver driver) {
        String applicationNum = "";
        try {
            HomePage homePage = new HomePage(driver);
            applicationNum = homePage.getNewApplicationNumLender(); // new APp
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the NewApplicationNumber: " + e, false);
        }
        return applicationNum;
    }

    public void searchNewApplication(WebDriver driver, String applicationNum) {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickHomeOpc();
            homePage.searchAppHomeDealer(applicationNum);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Search New Application in OTTOMOTOmax: " + e, false);
            }
    }

    public void selectHomeOption(WebDriver driver) {

        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickHomeOpc();
        } catch (Exception e) {
            Assert.fail("Error selectHomeOption: " + e);
        }
    }

    public void selectCopyEditApplication(WebDriver driver) {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickEditApplication();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error selecting the edit option", false);
        }
    }

    public void selectOriginalEditApplication(WebDriver driver) {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickEditApplicationOriginal();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error selecting the edit option", false);
        }
    }

    public void updateApplication(WebDriver driver) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            Thread.sleep(5000);
            newAppPage.updateApplication();
            //Assert.assertTrue("The Application info was not Updated", newAppPage.validateAppSubmitted());
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Updating the Application", false);
        }
    }

    public void updateDealerCommissionValuesForm(WebDriver driver, String lenderGap, String gapCommission, String lenderServiceContract, String serviceContractCommission, String lenderOther, String otherCommission, String dealerGap, String dealerWarranty, String dealerOther) {
        try {
            EditAppDealerPage editAppDealerPage = new EditAppDealerPage(driver);
            Thread.sleep(3000);
            if (editAppDealerPage.getTypeOfApplication().equalsIgnoreCase("loan")) {
                editAppDealerPage.setLenderGapInput(lenderGap);
                editAppDealerPage.setLenderWarrantyInput(lenderServiceContract);
                editAppDealerPage.setLenderOtherInput(lenderOther);
                editAppDealerPage.setDealerGapInput(dealerGap);
                editAppDealerPage.setDealerWarrantyInput(dealerWarranty);
                editAppDealerPage.setDealerOtherInput(dealerOther);
                Thread.sleep(2000);
                System.out.println("unpaidBalanceDealer = " + editAppDealerPage.getUnpaidBalanceInput());
                System.out.println("calculedpaymentDealer = " + editAppDealerPage.getCalculatedPaymentInput());
                System.out.println("TotalCheckLender = " + editAppDealerPage.getTotalCheckLenderInput());
                System.out.println("AmountFinancedLender = " + editAppDealerPage.getAmountFinancedLenderInput());
            } else {
                editAppDealerPage.setLenderGapLeaseInput(lenderGap);
                editAppDealerPage.setLenderWarrantyLeaseInput(lenderServiceContract);
                editAppDealerPage.setLenderOtherLeaseInput(lenderOther);
                editAppDealerPage.setDealerGapLeaseInput(dealerGap);
                editAppDealerPage.setDealerWarrantyLeaseInput(dealerWarranty);
                editAppDealerPage.setDealerOtherLeaseInput(dealerOther);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Dealer Updating commission values in the New Application", false);
        }
    }

    public void validateCalculatedPayment(WebDriver driver, String typeApplication) {
        try {
            EditAppDealerPage editAppDealerPage = new EditAppDealerPage(driver);
            Thread.sleep(3000);


            if (typeApplication.equalsIgnoreCase("loan")) {
                String unpaidBalance = editAppDealerPage.getUnpaidBalanceInput();
                String calculatedPayment = editAppDealerPage.getCalculatedPaymentInput();
                Assert.assertTrue("UnpaidBalance was not calculated correctly: " + unpaidBalance, Double.parseDouble(unpaidBalance.replaceAll("[$,]", "")) > 40000 && Double.parseDouble(unpaidBalance.replaceAll("[$,]", "")) < 50000);
                Assert.assertTrue("CalculatedPayment was not calculated correctly: " + calculatedPayment, Double.parseDouble(calculatedPayment.replaceAll("[$,]", "")) > 1000 && Double.parseDouble(calculatedPayment.replaceAll("[$,]", "")) < 2000);
            } else {
                String actualCashRequired = editAppDealerPage.getActualCashRequiredLeaseInput();
                String calculatedPaymentLease = editAppDealerPage.getCalculatedPaymentLeaseInput();
                Assert.assertTrue("ActualCashRequired was not calculated correctly: " + actualCashRequired, Double.parseDouble(actualCashRequired.replaceAll("[$,]", "")) > 10000 && Double.parseDouble(actualCashRequired.replaceAll("[$,]", "")) < 12000);
                Assert.assertTrue("CalculatedPayment was not calculated correctly: " + calculatedPaymentLease, Double.parseDouble(calculatedPaymentLease.replaceAll("[$,]", "")) > 1000 && Double.parseDouble(calculatedPaymentLease.replaceAll("[$,]", "")) < 3000);
            }


        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error validateCalculatedPayment", false);
        }
    }

    public void validateTotalCheck(WebDriver driver, String typeApplication) {
        try {
            EditAppDealerPage editAppDealerPage = new EditAppDealerPage(driver);
            Thread.sleep(3000);


            if (typeApplication.equalsIgnoreCase("loan")) {
                String totalCheckLender = editAppDealerPage.getTotalCheckLenderInput();
                String amountFinanced = editAppDealerPage.getAmountFinancedLenderInput();
                Assert.assertTrue("TotalCheckLender was not calculated correctly: " + totalCheckLender, Double.parseDouble(totalCheckLender.replaceAll("[$,]", "")) > 40000 && Double.parseDouble(totalCheckLender.replaceAll("[$,]", "")) < 50000);
                Assert.assertTrue("AmountFinanced was not calculated correctly: " + amountFinanced, Double.parseDouble(amountFinanced.replaceAll("[$,]", "")) > 40000 && Double.parseDouble(amountFinanced.replaceAll("[$,]", "")) < 50000);

            } else {
                String totalCheckLeaseLender = editAppDealerPage.getTotalCheckLenderLeaseInput();
                Assert.assertTrue("TotalCheckLender was not calculated correctly: " + totalCheckLeaseLender, Double.parseDouble(totalCheckLeaseLender.replaceAll("[$,]", "")) > 40000 && Double.parseDouble(totalCheckLeaseLender.replaceAll("[$,]", "")) < 80000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error validateTotalCheck", false);
        }
    }

    public void fillOutForm_OthersFields(WebDriver driver, String numberOfLender, String numberOfDeader, String firstName, String lastName, String dateOfBirth, String socialSecurity, String state, String zipCode, String incomeApplicant) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.setMiddleNameInput(faker.name().firstName());
            newAppPage.setSuffixInput(faker.name().suffix());
            newAppPage.setDriversLicenseInput("012345678");
            newAppPage.setLicenseExpirationInput("07/22/2000");
            newAppPage.setSecundaryEmailInput(String.format("appmoto-1fcbe8+App%s@inbox.mailtrap.io", new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime())));
            newAppPage.setSecundaryPhoneNumberInput("9159969739");
            //newAppPage.setHomeAddressLine2Input("4379 Everette Alley");
            newAppPage.setHomeAddressLine2Input("8392 South 22nd Cir");
            newAppPage.setYearsAtAddressInput("2");
            newAppPage.setMonthsAtAddressInput("4");
            newAppPage.setHousingStatusIdInput("Rent");
            newAppPage.setLandlordOrMTGHolderInput(faker.name().firstName());
            newAppPage.setMonthlyPaymentInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            newAppPage.setIncomeEmployerNameInput(faker.name().name());
            newAppPage.setIncomeWorkPhoneNumberInput("7864206154");
            newAppPage.setIncomeExtInput("123");
            newAppPage.setIncomeHomeAddressInput(faker.address().fullAddress());
            newAppPage.setIncomeHomeAddressLine2Input(faker.address().secondaryAddress());
            newAppPage.setIncomeHomeSuiteNumberInput("1007");
            newAppPage.setIncomeZipCodeInput("10001");
            newAppPage.setIncomeSupervisorNameInput("Rohan");
            newAppPage.setIncomePositionDepartmentInput(faker.job().position());
            newAppPage.setIncomeApplicant_employmentStatusInput("Active Military"); //Todo review this field is messing for Unregistered applicant
            newAppPage.setIncomeApplicant_yearsAtJobInputInput("4");
            newAppPage.setIncomeMonthsAtJobInput("2");
            //newAppPage.setIncomeApplicantFrequencyIdInput("Yearly"); // Todo In Mandatory fields
            newAppPage.setDateInput("07/22/2000");
            //Vehicle info
/*            newAppPage.setVehicleInfoVinInput("JH4DB1570PS000858"); // 1FTFW1ETODFA97477- WAUHGAFC6DNO30356  - 1FTFW1ETODFA97477
            newAppPage.setVehicleInfoBodyStyleOrTrimInput("PU LTZ");
            newAppPage.setVehicleInfoMilesInput("47000");
            newAppPage.setVehicleInfoColorInput("Aluminum");
            newAppPage.setVehicleInfoGvwInput("003500");  // Todo It is submitted with a Enter
            newAppPage.setVehicleInfoGvwrInput("517");   // Todo field does not accept the value (517 KG) It shoud show up the addcional information
            newAppPage.setVehicleInfoMsrpInput("17000");
            newAppPage.setVehicleInfoWeightInput("1524");
            newAppPage.setVehicleInfoIsComercialVehicleInput(true);
            newAppPage.setVehicleInfoIsNewInput(false);*/
            //newAppPage.setTradeInVinInput("1FTFW1ETODFA97477");  //No found
            newAppPage.setTradeInVinInput("1G4GD5EDXBF330171"); //OK
            newAppPage.setTradeInBodyStyleOrTrimInput("PU LTZ");
            newAppPage.setTradeInfoColorInput("Aluminum");
            newAppPage.setTradeInMilesInput("47000");
        } catch (Exception e) {
            e.printStackTrace();
            //Assert.assertTrue("Error filling out the others fields for full Application : ", false);
            internalAction.logError("Error when filling out the other fields for full Application", e);

        }
    }


    public void fillOutForm_OthersFields22(WebDriver driver, String numberOfLender, String numberOfDeader, String firstName, String lastName, String dateOfBirth, String socialSecurity, String state, String zipCode, String incomeApplicant) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.setMiddleNameInput(faker.name().firstName());
            newAppPage.setSuffixInput(faker.name().suffix());
            newAppPage.setDriversLicenseInput("012345678");
            newAppPage.setLicenseExpirationInput("07/22/2000");
            newAppPage.setSecundaryEmailInput(String.format("appmoto-1fcbe8+App%s@inbox.mailtrap.io", new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime())));
            newAppPage.setSecundaryPhoneNumberInput("9159969739");
            //newAppPage.setHomeAddressLine2Input("4379 Everette Alley");
            newAppPage.setHomeAddressLine2Input("8392 South 22nd Cir");
            newAppPage.setYearsAtAddressInput("2");
            newAppPage.setMonthsAtAddressInput("4");
            newAppPage.setHousingStatusIdInput("Rent");
            newAppPage.setLandlordOrMTGHolderInput(faker.name().firstName());
            newAppPage.setMonthlyPaymentInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            newAppPage.setIncomeEmployerNameInput(faker.name().name());
            newAppPage.setIncomeWorkPhoneNumberInput("7864206154");
            newAppPage.setIncomeExtInput("123");
            newAppPage.setIncomeHomeAddressInput(faker.address().fullAddress());
            newAppPage.setIncomeHomeAddressLine2Input(faker.address().secondaryAddress());
            newAppPage.setIncomeHomeSuiteNumberInput("1007");
            newAppPage.setIncomeZipCodeInput("10001");
            newAppPage.setIncomeSupervisorNameInput("Rohan");
            newAppPage.setIncomePositionDepartmentInput(faker.job().position());
            newAppPage.setIncomeApplicant_employmentStatusInput("Active Military"); //Todo review this field is messing for Unregistered applicant
            newAppPage.setIncomeApplicant_yearsAtJobInputInput("4");
            newAppPage.setIncomeMonthsAtJobInput("2");
            //newAppPage.setIncomeApplicantFrequencyIdInput("Yearly"); // Todo In Mandatory fields
            newAppPage.setDateInput("07/22/2000");
            //Vehicle info
/*            newAppPage.setVehicleInfoVinInput("JH4DB1570PS000858"); // 1FTFW1ETODFA97477- WAUHGAFC6DNO30356  - 1FTFW1ETODFA97477
            newAppPage.setVehicleInfoBodyStyleOrTrimInput("PU LTZ");
            newAppPage.setVehicleInfoMilesInput("47000");
            newAppPage.setVehicleInfoColorInput("Aluminum");
            newAppPage.setVehicleInfoGvwInput("003500");  // Todo It is submitted with a Enter
            newAppPage.setVehicleInfoGvwrInput("517");   // Todo field does not accept the value (517 KG) It shoud show up the addcional information
            newAppPage.setVehicleInfoMsrpInput("17000");
            newAppPage.setVehicleInfoWeightInput("1524");
            newAppPage.setVehicleInfoIsComercialVehicleInput(true);
            newAppPage.setVehicleInfoIsNewInput(false);*/
            //newAppPage.setTradeInVinInput("1FTFW1ETODFA97477");  //No found
            newAppPage.setTradeInVinInput("1G4GD5EDXBF330171"); //OK
            newAppPage.setTradeInBodyStyleOrTrimInput("PU LTZ");
            newAppPage.setTradeInfoColorInput("Aluminum");
            newAppPage.setTradeInMilesInput("47000");
        } catch (Exception e) {
            e.printStackTrace();
            //Assert.assertTrue("Error filling out the others fields for full Application : ", false);
            internalAction.logError("Error when filling out the other fields for full Application", e);

        }
    }

    public void fillOutForm_OthersFields2(WebDriver driver, String numberOfLender, String numberOfDeader, String firstName, String lastName, String dateOfBirth, String socialSecurity, String state, String zipCode, String incomeApplicant) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.setMiddleNameInput(faker.name().firstName());
            newAppPage.setSuffixInput(faker.name().suffix());
            newAppPage.setDriversLicenseInput("012345678");
            newAppPage.setLicenseExpirationInput("07/22/2000");
            newAppPage.setSecundaryEmailInput("fake_email+" + faker.number().numberBetween(10, 100) + faker.internet().emailAddress());
            newAppPage.setSecundaryPhoneNumberInput("9159969739");
            newAppPage.setHomeAddressLine2Input("4379 Everette Alley");
            newAppPage.setYearsAtAddressInput("2");
            newAppPage.setMonthsAtAddressInput("4");
            newAppPage.setHousingStatusIdInput("Rent");
            newAppPage.setLandlordOrMTGHolderInput(faker.name().firstName());
            newAppPage.setMonthlyPaymentInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            newAppPage.setIncomeEmployerNameInput(faker.name().name());
            newAppPage.setIncomeWorkPhoneNumberInput("7864206154");
            newAppPage.setIncomeExtInput("123");
            newAppPage.setIncomeHomeAddressInput(faker.address().fullAddress());
            newAppPage.setIncomeHomeAddressLine2Input(faker.address().secondaryAddress());
            newAppPage.setIncomeHomeSuiteNumberInput("1007");
            newAppPage.setIncomeZipCodeInput("10001");
            newAppPage.setIncomeSupervisorNameInput("Rohan");
            newAppPage.setIncomePositionDepartmentInput(faker.job().position());
            //newAppPage.setIncomeApplicant_employmentStatusInput("Active Military"); Todo review this field is messing for Unregistered applicant
            newAppPage.setIncomeApplicant_yearsAtJobInputInput("4");
            newAppPage.setIncomeMonthsAtJobInput("2");
            newAppPage.setIncomeApplicantFrequencyIdInput("Yearly");
            newAppPage.setDateInput("07/22/2000");
            newAppPage.clickOnNext(); //for unregistered applicant
            //Vehicle info
/*            newAppPage.setVehicleInfoVinInput("2FABP7EV7BX127047");
            newAppPage.setVehicleInfoBodyStyleOrTrimInput("PU LTZ");
            newAppPage.setVehicleInfoMilesInput("47000");
            newAppPage.setVehicleInfoColorInput("Aluminum");
            newAppPage.setVehicleInfoGvwInput("003500");  // Todo It is submitted with a Enter
            newAppPage.setVehicleInfoGvwrInput("517");   // Todo field does not accept the value (517 KG) It shoud show up the addcional information
            newAppPage.setVehicleInfoMsrpInput("17000");
            newAppPage.setVehicleInfoWeightInput("1524");
            newAppPage.setVehicleInfoIsComercialVehicleInput(true);
            newAppPage.setVehicleInfoIsNewInput(false);*/
            newAppPage.setTradeInVinInput("2FABP7EV7BX127047");
            newAppPage.setTradeInBodyStyleOrTrimInput("PU LTZ");
            newAppPage.setTradeInfoColorInput("Aluminum");
            newAppPage.setTradeInMilesInput("47000");

            //newAppPage.clickOnSubmit3();

        } catch (Exception e) {
            e.printStackTrace();
            //Assert.assertTrue("Error filling out the others fields for full Application", false);
            internalAction.logError("Error filling out the others fields for full Application", e);
        }
    }

    public void validateCalculator(WebDriver driver, String DTI, String PTI, String LTVTradeIn, String LTVWithoutProducts, String LTVRetail, String LTVWithoutProductsRetail) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.clickJDPowerButton();
            System.out.println("");
            System.out.println("");
            System.out.format("PTI Expected                      = %s    ----> vs PTI                      = %s \n", PTI, newAppPage.getPTI_Input());
            System.out.format("LTVTradeIn Expected               = %s    ----> vs LTVTradeIn               = %s \n", LTVTradeIn, newAppPage.getLTVTradeIn_Input());
            System.out.format("LTVWithoutProducts Expected       = %s    ----> vs LTVWithoutProducts       = %s \n", LTVWithoutProducts, newAppPage.getLTVWithoutProducts_Input());
            System.out.format("LTVRetail Expected                = %s    ----> vs LTVRetail                = %s \n", LTVRetail, newAppPage.getLTVRetail_Input());
            System.out.format("LTVWithoutProductsRetail Expected = %s    ----> vs LTVWithoutProductsRetail = %s \n\n", LTVWithoutProductsRetail, newAppPage.getLTVWithoutProductsRetail_Input());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error validating DTI and PTI values", false);
        }
    }

    public void searchApplicationHome(WebDriver driver, String appNumber) {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickHomeOpc();
            homePage.searchAppHomeApplicant(appNumber);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Search New Application in Home", false);
        }
    }

    public void validateApproveLabel(WebDriver driver) {
        try {
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            Assert.assertEquals("The Application was not Approve", "Approved", appInfoPage.verifyApprovedLabel());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Validating Approve Label", false);
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
            WebAction webAction = new WebAction(driver);
            webAction.validateRequiredAlert();
            Assert.assertTrue("Error getting the successfully notification message: " + e, false);
        }
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


    public void validateOTTOInsureNotificationMsj(WebDriver driver) {
        try {
            String notificationStatus = "";
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            notificationStatus = appInfoPage.verifyNotificationSuccessfully();
            Assert.assertTrue("The notification message was not successfully : " + notificationStatus, notificationStatus.contains("email inbox to complete the process"));
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            WebAction webAction = new WebAction(driver);
            webAction.validateRequiredAlert();
            Assert.assertTrue("Error getting the successfully notification message", false);
        }
    }

    public void sendAppToUnregisteredApplicant(WebDriver driver, String unRegisterApplicantEmail) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.clickOnSendApplication();
            Thread.sleep(2000);
            newAppPage.selectBranchInput();
            newAppPage.selectOfficeInput();
            newAppPage.setApplicantFirstNameInput("Jua");
            newAppPage.setApplicantPhoneNumberInput("8052969593");
            newAppPage.setApplicantEmailInput(unRegisterApplicantEmail);
            newAppPage.clickOnOk();
            Assert.assertTrue("Error getting the notification message", newAppPage.verifySuccessfullyNotification());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Sending Application to Unregistered Applicant: " + e, false);
        }
    }

    public void validateCode(WebDriver driver, String verificationCode) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.setVerificationCode(verificationCode);
            newAppPage.clickOnValidate();
            //Assert.assertTrue("Notification Success Company Validated is not displayed", planPage.validateNotificationSuccessCompanyValidated());
            Thread.sleep(10000); // Todo wait next email
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void validateTotalRecordLabel(WebDriver driver) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            Assert.assertTrue("The form information was not sent", newAppPage.validateAppSubmitted());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> generateJDPowerValues(WebDriver driver) {
        List<String> jdPowerValues = new ArrayList<>();
        boolean isValuesOk = false;
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.clickOnPullVehicleInfo();
            Thread.sleep(4000);
            jdPowerValues = newAppPage.getJDPowerValues();

            for (String jdPowerValue : jdPowerValues) {
                isValuesOk = isValuesOk || (Integer.parseInt(jdPowerValue) > 0);
                if (isValuesOk) {
                    break;
                }
            }

            Assert.assertTrue(String.format("JDPower values are equal to zero"), isValuesOk);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(String.format("Error getting the JD Power values: " + e), false);
        }
        return jdPowerValues;
    }

    public List<String> tryGetJDPowerInfo(WebDriver driver) {
        List<String> jdPowerValues = new ArrayList<>();
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.clickOnPullVehicleInfo();
            Thread.sleep(2000);
            jdPowerValues = newAppPage.getJDPowerValues();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(String.format("Error getting the JD Power values " + e), false);
        }
        return jdPowerValues;
    }

    public List<String> getUpdateJDPowerValues(WebDriver driver) {
        List<String> jdPowerValues = new ArrayList<>();
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            Thread.sleep(2000);
            jdPowerValues = newAppPage.getJDPowerValues();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(String.format("Error getting the update JD Power values"), false);
        }
        return jdPowerValues;
    }

    public void validateJDPowerValues(WebDriver driver, List<String> jdPowerValuesPrevious) {
        List<String> jdPowerValuesCurrent;
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            Thread.sleep(2000);
            jdPowerValuesCurrent = newAppPage.getJDPowerValues();
            Assert.assertTrue(String.format("JD Power values did not save correctly"), jdPowerValuesPrevious.equals(jdPowerValuesCurrent));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(String.format("Error validating the JD Power values " + e), false);
        }
    }

    public void validateUpdateJDPowerValues(WebDriver driver, List<String> jdPowerValuesPrevious) {
        List<String> jdPowerValuesCurrent;
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            Thread.sleep(2000);
            newAppPage.clickTradeInVinInput();
            jdPowerValuesCurrent = newAppPage.getJDPowerValues();
            Assert.assertTrue(String.format("JD Power values did not save correctly"), jdPowerValuesPrevious.equals(jdPowerValuesCurrent));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(String.format("Error validating the JD Power values have been updated" + e), false);
        }
    }

    public void checkPowerOptions(WebDriver driver, List<String> jdPowerValuesPrevious) {
        List<String> jdPowerValuesCurrent;
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            int count = 0;
            boolean isValuesOk = false;
            Thread.sleep(2000);
            //newAppPage.clickOnJDPowerTrimLevel();
            //newAppPage.clickOnAllJDPowerTrimLevels();
            newAppPage.clickOnJDPowerOption();
            newAppPage.clickOnAllJDPowerOptions();
            jdPowerValuesCurrent = newAppPage.getJDPowerValues();

            for (String jdPowerValue : jdPowerValuesCurrent) {
                isValuesOk = isValuesOk || (Integer.parseInt(jdPowerValue) > 0);
                if (isValuesOk) {
                    break;
                }
            }
            //Assert.assertTrue(String.format("JD Power values did not save correctly"), !jdPowerValuesPrevious.equals(jdPowerValuesCurrent));
            Assert.assertTrue(String.format("JD Power values did not save correctly"), isValuesOk);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(String.format("Error selecting the JD Power Trim Levels and Options"), false);
        }
    }


    public void fillOutDealerFormOttoinspector(WebDriver driver) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.setDriversLicenseInput("012345678");
            newAppPage.setIncomePositionDepartmentInput(faker.job().position());
            newAppPage.setTradeInVinInput("1C6RD6KT4CS332867");
            //newAppPage.setTradeInBodyStyleOrTrimInput("PU LTZ");
            newAppPage.setTradeInfoColorInput("Aluminum");
            newAppPage.setTradeInMilesInput("47000");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error fillOutDealerFormOttoinspector: " + e, false);
        }
    }

    public void fillOutLenderFormOttoinspector(WebDriver driver) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.setVinInfoInput("1C6RD6KT4CS332867");
            newAppPage.setDriversLicenseInput("012345678");
            newAppPage.setIncomePositionDepartmentInput(faker.job().position());
            newAppPage.setTradeInVinInput("1C6RD6KT4CS332867");
            //newAppPage.setTradeInBodyStyleOrTrimInput("PU LTZ");
            newAppPage.setTradeInfoColorInput("Aluminum");
            newAppPage.setTradeInMilesInput("47000");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error fillOutLenderFormOttoinspector: ", false);
        }
    }

    public void sendOTTOinspectorRequest(WebDriver driver) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.clickOnOTTOinspector();
            newAppPage.clickOnOk();
            //newAppPage.setDealerPhone("7154698569");
            //newAppPage.setDealerPhone("8565768948");
            newAppPage.setDealerPhone("4387733563");
            Thread.sleep(800);
            newAppPage.clickOnSubmitRequest();
            Thread.sleep(800);
            //newAppPage.clickOnSubmitConfirm();
            System.out.println(" = ");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error sending OTTOinspector request", false);
        }
    }

    public void sendOTTOinspectorRequestLender(WebDriver driver) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.clickOnOTTOinspector();
            newAppPage.clickOnOk();
            newAppPage.setLenderPhone("7154698569");
            newAppPage.setDealerPhoneLenderSide("7154698569");
            Thread.sleep(800);
            newAppPage.clickOnSubmitRequest();
            Thread.sleep(800);
            //newAppPage.clickOnSubmitConfirm();
            System.out.println(" = ");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error sending OTTOinspector request", false);
        }
    }

    public void validateOTTOinspectorNotification(WebDriver driver) {
        try {
            String notificationStatus = "";
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            notificationStatus = appInfoPage.verifyNotificationSuccessfully();
            Assert.assertTrue("The notification message was not successfully : " + notificationStatus, notificationStatus.contains("successfully"));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the notificaiton status: " + e, false);
        }
    }

    public void sendOTTOVerifyRequest(WebDriver driver) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.clickOnOTTOverify();
            newAppPage.clickOnOk();
            newAppPage.setEmailOttoVerifyInput("tester.testyng@gmail.com");
            newAppPage.clickOnSendRequest();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error sending OTTOverify  button", false);
        }
    }

    public void validateOTTOVerifyNotification(WebDriver driver) {
        try {
            String notificationStatus = "";
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            notificationStatus = appInfoPage.verifyNotificationSuccessfully();
            Assert.assertTrue("The notification message was not successfully : " + notificationStatus, notificationStatus.contains("successfully"));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the notificaiton status: " + e, false);
        }
    }

    public void validateOTTOVerifyStatus(WebDriver driver) {
        try {
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            Assert.assertTrue("The OTTOverify Status is not Pending", appInfoPage.verifyStatusPending());
            System.out.println("true = " + true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the notificaiton status: " + e, false);
        }
    }

    public void validateOTTOinspectorStatus(WebDriver driver) {
        try {
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            appInfoPage.clickOnLoanTerms();
            Assert.assertTrue("The OTTOverify Status is not Pending", appInfoPage.verifyStatusPending());
            System.out.println("true = " + true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the notificaiton status: " + e, false);
        }
    }

    public void fillOutForm_TypeVihicle(WebDriver driver, String typeVehicle) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            Thread.sleep(1000);
            if (typeVehicle.contains("Passenger")) {
                newAppPage.clickOnPassengerVehicle();
                newAppPage.setVehicleInfoVinInput("JHLRE48518C002529"); // 1FTFW1ETODFA97477- WAUHGAFC6DNO30356  - 1FTFW1ETODFA97477
                newAppPage.setVehicleInfoBodyStyleOrTrimInput("PU LTZ");
                newAppPage.setVehicleInfoMilesInput("47000");
                newAppPage.setVehicleInfoColorInput("Aluminum");
                newAppPage.setVehicleInfoGvwInput("003500");  // Todo It is submitted with a Enter
                newAppPage.setVehicleInfoGvwrInput("517");   // Todo field does not accept the value (517 KG) It shoud show up the addcional information
                newAppPage.setVehicleInfoMsrpInput("17000");
                newAppPage.setVehicleWholeSaleInput("7000");
                newAppPage.setVehicleInfoWeightInput("1524");
                newAppPage.setVehicleInfoIsComercialVehicleInput(true);
                newAppPage.setVehicleInfoIsNewInput(false);
                newAppPage.setVehicleInfoNotesInput("notes");
            } else if (typeVehicle.contains("Recreational")) {
                newAppPage.clickOnRecreationalVehicles();
                newAppPage.setVehicleInformation_vehicle_makeInput("Airstream");
                newAppPage.setVehicleInformation_vehicle_modelNameInput("Ford T");
                newAppPage.setVehicleInformation_vehicle_numberOfSlideOutsInput("2.5");
                newAppPage.setVehicleInformation_vehicle_useInput("Pleasure");
                newAppPage.setVehicleInformation_vehicle_typeOfLoanInput("New");
                newAppPage.setVehicleInformation_vehicle_typeOfRvInput("Motorhome");
                //newAppPage.setVehicleInformation_vehicle_dateInput("2022");
                newAppPage.setVehicleInformation_vehicle_lengthInput("14.5");
                newAppPage.setVehicleInformation_vehicle_milesInput("1213.5");
                newAppPage.setVehicleInformation_vehicle_colorInput("Grey");
                newAppPage.setVehicleInformation_vehicle_bodyInput("Class A");
                newAppPage.setVehicleInformation_vehicle_notesOptionsInput("Note");
            } else if (typeVehicle.contains("Aircraft")) {
                newAppPage.clickOnAircraftVehicle();
                newAppPage.setVehicleInformation_Aircraft_makeInput("Airstream");
                newAppPage.setVehicleInformation_vehicle_modelInput("Rotorcraft");
                //newAppPage.setVehicleInformation_Aircraft_dateInput("2022");
                newAppPage.setVehicleInformation_vehicle_faanInput("N123NC");
                newAppPage.setVehicleInformation_vehicle_snInput("610");
                newAppPage.setVehicleInformation_Aircraft_lastAnnualDateInput("11/01/2022");
                newAppPage.setVehicleInformation_Aircraft_ttafInput("4280");
                newAppPage.setVehicleInformation_Aircraft_reSmohInput("1700");
                newAppPage.setVehicleInformation_vehicle_leSmohInput("1234");
                newAppPage.setVehicleInformation_Aircraft_closingDateInput("11/01/2022");
                newAppPage.setVehicleInformation_vehicle_sellerNameInput("Peter");
                newAppPage.setVehicleInformation_vehicle_sellerPhonenumberInput("6011111111");
                newAppPage.setVehicleInformation_vehicle_currentAircraftInput("BELL");
                newAppPage.setVehicleInformation_vehicle_financedStringInput("ALLISON");
                newAppPage.setVehicleInformation_vehicle_typeOfPilotCertificateOptsInput("Student");
                newAppPage.setVehicleInformation_vehicle_currentHrsInput("3508");
                newAppPage.setVehicleInformation_vehicle_ratingsInput("10");
                newAppPage.setVehicleInformation_Aircraft_endorsementsInput("complex airplane");
                newAppPage.setVehicleInformation_vehicle_aircraftWillBaseInput("NORTH CAROLINA");
                newAppPage.setVehicleInformation_vehicle_howAircraftUtilizedInput("Part 91");
                newAppPage.setVehicleInformation_vehicle_previousExperienceInput(true);
                newAppPage.setVehicleInformation_vehicle_detailsInput("details");

            } else if (typeVehicle.contains("Boat")) {
                newAppPage.clickOnBoatVehicle();
                newAppPage.setVehicleInformation_Aircraft_makeInput("Cobia Boats");
                newAppPage.setVehicleInformation_vehicle_modelInput("Bay Boats");
                //newAppPage.setVehicleInformation_boat_dateInput("2022");
                newAppPage.setVehicleInformation_vehicle_boat_lengthInput("5");
                newAppPage.setVehicleInformation_vehicle_titleNumberInput("Cobia 201 CC");
                newAppPage.setVehicleInformation_vehicle_hullTypeInput("V-Shaped");
                newAppPage.setVehicleInformation_vehicle_hullIdNumberInput("AU-WWA192901");
                newAppPage.setVehicleInformation_vehicle_populsionTypeInput("Inboard");
                newAppPage.setVehicleInformation_vehicle_registrationNumberInput("MD1246BD");
                newAppPage.setVehicleInformation_vehicle_stateRegisteredInput("FL");
                newAppPage.setVehicleInformation_vehicle_hoursInput("3508");
                newAppPage.setVehicleInformation_vehicle_boatValueInput("154000");
                newAppPage.setVehicleInformation_vehicle_outboardMotorValueInput("45000");
                newAppPage.setVehicleInformation_vehicle_notesInput("notes");
            }
            Thread.sleep(3000);
            System.out.println("true = " + true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error fillOutForm_TypeVihicle: " + e, false);
        }
    }

    public void fillOutForm_TypeVihicle2(WebDriver driver, String typeVehicle) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            if (typeVehicle.contains("Passenger")) {
                newAppPage.clickOnPassengerVehicle();
                newAppPage.setVehicleInfoVinInput("JHLRE48518C002529"); // 1FTFW1ETODFA97477- WAUHGAFC6DNO30356  - 1FTFW1ETODFA97477
                newAppPage.setVehicleInfoBodyStyleOrTrimInput("PU LTZ");
                newAppPage.setVehicleInfoMilesInput("47000");
                newAppPage.setVehicleInfoColorInput("Aluminum");
                newAppPage.setVehicleInfoGvwInput("003500");  // Todo It is submitted with a Enter
                newAppPage.setVehicleInfoGvwrInput("517");   // Todo field does not accept the value (517 KG) It shoud show up the addcional information
                newAppPage.setVehicleInfoMsrpInput("17000");
                newAppPage.setVehicleWholeSaleInput("7000");
                newAppPage.setVehicleInfoWeightInput("1524");
                newAppPage.setVehicleInfoIsComercialVehicleInput(true);
                newAppPage.setVehicleInfoIsNewInput(false);
                newAppPage.setVehicleInfoNotesInput("notes");
            } else if (typeVehicle.contains("Recreational")) {
                newAppPage.clickOnRecreationalVehicles();
                newAppPage.clickOnContinue();
                newAppPage.setVehicleInformation_vehicle_makeInput("AirstreamzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_modelNameInput("Ford TzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_numberOfSlideOutsInput("2.5");
                newAppPage.setVehicleInformation_vehicle_useInput("PleasurezARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_typeOfLoanInput("NewzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_typeOfRvInput("MotorhomezARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                //newAppPage.setVehicleInformation_vehicle_dateInput("2022");
                newAppPage.setVehicleInformation_vehicle_lengthInput("14.5");
                newAppPage.setVehicleInformation_vehicle_milesInput("1213.5");
                newAppPage.setVehicleInformation_vehicle_colorInput("GreyzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_bodyInput("Class AzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_notesOptionsInput("NotezARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
            } else if (typeVehicle.contains("Aircraft")) {
                newAppPage.clickOnAircraftVehicle();
                newAppPage.clickOnContinue();
                newAppPage.setVehicleInformation_Aircraft_makeInput("AirstreamzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_modelInput("RotorcraftzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                //newAppPage.setVehicleInformation_Aircraft_dateInput("2022");
                newAppPage.setVehicleInformation_vehicle_faanInput("N123NCzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_snInput("610zARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_Aircraft_lastAnnualDateInput("11/01/2022");
                newAppPage.setVehicleInformation_Aircraft_ttafInput("4280zARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_Aircraft_reSmohInput("1700zARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_leSmohInput("1234zARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_Aircraft_closingDateInput("11/01/2022");
                newAppPage.setVehicleInformation_vehicle_sellerNameInput("PeterzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_sellerPhonenumberInput("6011111111999999999999999999");
                newAppPage.setVehicleInformation_vehicle_currentAircraftInput("BELLzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_financedStringInput("ALLISONzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_typeOfPilotCertificateOptsInput("Student");
                newAppPage.setVehicleInformation_vehicle_currentHrsInput("35089999999999999999");
                newAppPage.setVehicleInformation_vehicle_ratingsInput("109999999999999999");
                newAppPage.setVehicleInformation_Aircraft_endorsementsInput("complex airplanezARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_aircraftWillBaseInput("NORTH CAROLINAzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_howAircraftUtilizedInput("Part 91");
                newAppPage.setVehicleInformation_vehicle_previousExperienceInput(true);
                newAppPage.setVehicleInformation_vehicle_detailsInput("detailszARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");

            } else if (typeVehicle.contains("Boat")) {
                newAppPage.clickOnBoatVehicle();
                newAppPage.clickOnContinue();
                newAppPage.setVehicleInformation_Aircraft_makeInput("Cobia BoatszARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_modelInput("Bay BoatszARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                //newAppPage.setVehicleInformation_boat_dateInput("2022");
                newAppPage.setVehicleInformation_vehicle_boat_lengthInput("5999999999999999999999999999");
                newAppPage.setVehicleInformation_vehicle_titleNumberInput("Cobia 201 CCzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_hullTypeInput("V-ShapedzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_hullIdNumberInput("AU-WWA192901zARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_populsionTypeInput("InboardzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_registrationNumberInput("MD1246BDzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_stateRegisteredInput("FLzARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
                newAppPage.setVehicleInformation_vehicle_hoursInput("3508999999999999999999999999999999");
                newAppPage.setVehicleInformation_vehicle_boatValueInput("154000999999999999999999999999");
                newAppPage.setVehicleInformation_vehicle_outboardMotorValueInput("450009999999999999999");
                newAppPage.setVehicleInformation_vehicle_notesInput("noteszARbeU1Izv8iQ9rDIclvphy0V8WoBnXBkzxITH4NYLOMkPRLPvXIO9X89eEq9kGFqPm539Yl5xMntqEQFcQwaOtyT3I1wqmvRMlsX79Eav1S7RLuh9qwZrJUq534vspjZpuNXqYb13stIeze3LYZos7axsAbcl65FG0h0iA0UJk5hzf5hxpNysKGG0o6LowYsX7BhuSk");
            }

            System.out.println("true = " + true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the notificaiton status: " + e, false);
        }
    }

    public void sendOTTOinsureRequest(WebDriver driver) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.clickOnOTTinsure();
            Thread.sleep(2000);
            //newAppPage.setOttoInsureEmailInput(String.format("appmoto-1fcbe8+uat_dealer%s@inbox.mailtrap.io", new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())));
            newAppPage.setOttoInsureEmailInput("appmoto-1fcbe8+uat_dealer@inbox.mailtrap.io");
            Thread.sleep(2000);
            //newAppPage.setOttoInsurePhoneInput("7705308818"); //Todo 770-530-8818 Athena
            //newAppPage.setOttoInsurePhoneInput("7703623638");
            //newAppPage.setOttoInsurePhoneInput("3022563296");
            //newAppPage.setOttoInsurePhoneInput("6102458232");
            //newAppPage.setOttoInsurePhoneInput("6047850779");
            //newAppPage.setOttoInsurePhoneInput("85592271358");
            //newAppPage.setOttoInsurePhoneInput("7869773737"); //Florida
            //newAppPage.setOttoInsurePhoneInput("8052969593"); //Whatsapp
            //newAppPage.setOttoInsurePhoneInput("2365129507"); //Whatsapp
            newAppPage.setOttoInsurePhoneInput("4077247878"); //Whatsapp
            Thread.sleep(2000);
            newAppPage.clickOnSubmit3();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error sending OTTOinspector button", false);
        }
    }

    public void submitAppForQR(WebDriver driver) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.clickOnNext(); //for unregistered applicant
            newAppPage.setTermsConditionsOption();
            newAppPage.setTermsOfUseOption();
            newAppPage.clickOnSubmit2();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(String.format("Error submitting the mandatory form info: %s", e), false);
        }
    }

    public void positionInVehicleInfo(WebDriver driver, String typeVehicle) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            if (typeVehicle.contains("Passenger")) {
                newAppPage.clickOnPassengerVehicle();
                newAppPage.moveToVehicleInfoNotesInput();

            } else if (typeVehicle.contains("Recreational")) {
                newAppPage.clickOnRecreationalVehicles();
                newAppPage.moveTotVehicleInformation_vehicle_notesOptionsInput();

            } else if (typeVehicle.contains("Aircraft")) {
                newAppPage.clickOnAircraftVehicle();
                newAppPage.moveToVehicleInformation_vehicle_detailsInput();

            } else if (typeVehicle.contains("Boat")) {
                newAppPage.clickOnBoatVehicle();
                newAppPage.moveToVehicleInformation_vehicle_notesInput();
            }
            //newAppPage.moveToVehiclesInfo();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error position in Vehicle INfo: " + e, false);
        }
    }


    public void send700creditConcectRequest(WebDriver driver, String company) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.setIncomeEmployerNameInput(faker.name().name());
            newAppPage.setLoanCashPriceInput("15000", "loan");

            if (company.contains("RouteOne")) {
                newAppPage.clickOnRouteOneCompany();

            } else if (company.contains("CUDL")) {
                newAppPage.clickOnCUDLCompany();

            } else if (company.contains("DealerTrack")) {
                newAppPage.clickOnDealerTrackCompany();

            } else if (company.contains("AppOne")) {
                newAppPage.clickOnAppOneCompany();
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error position in Vehicle INfo: " + e, false);
        }
    }


    public void selectDocumentsDealer(WebDriver driver, String applicationNum) {
        try {
            NewAppPage newAppPage = new NewAppPage(driver);
            newAppPage.clickOnSignDocuments();
            newAppPage.clickOnOk();
            Thread.sleep(4000);
            newAppPage.clickOnLastDocument();
            //newAppPage.setCoApplicantEmail("tester.testyng@gmail.com");
            newAppPage.clickOnSignDocumentButton();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(String.format("Error selecting the documents for the Dealer: %s", e), false);
        }
    }

    public void validateNotificationSentToBeSignedMsj(WebDriver driver) {
        try {
            String notificationStatus = "";
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            Thread.sleep(2000);
            notificationStatus = appInfoPage.verifyNotificationSuccessfullyCopySent();
            Assert.assertTrue("The -Documents sent to be signed- message was not successfully : " + notificationStatus, notificationStatus.contains("to be signed"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the successfully notification -Documents sent to be signed-: " + e, false);
        }
    }

    public void updatedPage(WebDriver driver) {
        try {
            AppInfoPage appInfoPage = new AppInfoPage(driver);
            appInfoPage.refreshPage();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the notificaiton status: " + e, false);
        }
    }

    public void validateAccessToGabiHomePage(WebDriver driver) {
        try {
            GabiPage gabiPage = new GabiPage(driver);
            Assert.assertTrue("OTTOinsure request was sent successfully, but the Gabi access was denied", !gabiPage.deniedTagIsVisible());
        } catch (Exception e) {
            Assert.assertTrue("Error getting the Gabi home page: " + e, false);
        }
    }

    public void fillOutPreviousAdditionalInformation(WebDriver driver) {
        try {

            ApplicantExtraFieldsPage applicantExtraFieldsPage = new ApplicantExtraFieldsPage(driver);

            applicantExtraFieldsPage.setCurrentlyBankruptcyCheckBoxCheckBox();
            applicantExtraFieldsPage.setPreviousResidenceInformationCheckBox();
            applicantExtraFieldsPage.setAdditionalResidenceInformationCheckBox();
            applicantExtraFieldsPage.setPreviousIncomeSourceCheckBox();
            applicantExtraFieldsPage.setAdditionalIncomeSourceCheckBox();
            /******Previous residence information**********/
            applicantExtraFieldsPage.setApplicant_previousHomeAddressInput(faker.address().fullAddress());
            applicantExtraFieldsPage.setApplicant_previousHomeAddressLine2Input(faker.address().fullAddress());
            applicantExtraFieldsPage.setApplicant_previousZipCodeInput("10001");
            applicantExtraFieldsPage.setApplicant_previousYearsAtAddressInput("2022");
            applicantExtraFieldsPage.setApplicant_previousMonthsAtAddressInput("4");
            applicantExtraFieldsPage.setApplicant_previousHousingStatusIdInput("Rent");
            applicantExtraFieldsPage.setApplicant_previousMonthlyPaymentInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            /******Additional residence information**********/
            applicantExtraFieldsPage.setApplicant_anotherHomeAddressInput(faker.address().fullAddress());
            applicantExtraFieldsPage.setApplicant_anotherHomeAddressLine2Input(faker.address().secondaryAddress());
            applicantExtraFieldsPage.setApplicant_anotherZipCodeInput("10001");
            applicantExtraFieldsPage.setApplicant_anotherYearsAtAddressInput("2");
            applicantExtraFieldsPage.setApplicant_anotherMonthsAtAddressInput("2");
            applicantExtraFieldsPage.setApplicant_anotherHousingStatusIdInput("Rent");
            applicantExtraFieldsPage.setApplicant_anotherMonthlyPaymentInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            /******Previous income source information****/
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousEmployerNameInput(faker.name().name());
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousWorkPhoneNumberInput("3864206154");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousExtInput("100");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousHomeAddressInput(faker.address().fullAddress());
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousHomeAddressLine2Input(faker.address().secondaryAddress());
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousHomeSuiteNumberInput("507");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousZipCodeInput("10001");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousSupervisorNameInput(faker.name().name());
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousEmploymentStatusIdInput("Active Military");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousPositionDepartmentInput(faker.job().position());
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousYearsAtJobInput("3");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousMonthsAtJobInput("3");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousGrossIncomeInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            applicantExtraFieldsPage.setApplicant_incomeApplicant_previousFrequencyIdInput("Yearly");
            /******Additional income source information****/
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherEmployerNameInput(faker.name().name());
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherWorkPhoneNumberInput("5011111111");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherExtInput("101");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherHomeAddressInput(faker.address().fullAddress());
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherHomeAddressLine2Input(faker.address().secondaryAddress());
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherHomeSuiteNumberInput("507");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherZipCodeInput("10001");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherSupervisorNameInput(faker.name().name());
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherEmploymentStatusIdInput("Active Military");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherPositionDepartmentInput(faker.job().position());
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherYearsAtJobInput("4");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherMonthsAtJobInput("2");
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherGrossIncomeInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            applicantExtraFieldsPage.setApplicant_incomeApplicant_otherFrequencyIdInput("Yearly");

        } catch (Exception e) {
            Assert.assertTrue("Error previousResidenceInformation: " + e, false);
        }
    }

    public void fillOutPreviousAdditionalInformationCoApp(WebDriver driver) {
        try {

            CoApplicantExtraFieldsPage coApplicantExtraFieldsPage = new CoApplicantExtraFieldsPage(driver);
            coApplicantExtraFieldsPage.selectCoAppTab();
            coApplicantExtraFieldsPage.setCurrentlyBankruptcyCheckBoxCheckBox();
            coApplicantExtraFieldsPage.setPreviousResidenceInformationCheckBox();
            coApplicantExtraFieldsPage.setAdditionalResidenceInformationCheckBox();
            coApplicantExtraFieldsPage.setPreviousIncomeSourceCheckBox();
            coApplicantExtraFieldsPage.setAdditionalIncomeSourceCheckBox();
            /******Previous residence information**********/
            coApplicantExtraFieldsPage.setCoApplicant_previousHomeAddressInput(faker.address().fullAddress());
            coApplicantExtraFieldsPage.setCoApplicant_previousHomeAddressLine2Input(faker.address().fullAddress());
            coApplicantExtraFieldsPage.setCoApplicant_previousZipCodeInput("10001");
            coApplicantExtraFieldsPage.setCoApplicant_previousYearsAtAddressInput("2022");
            coApplicantExtraFieldsPage.setCoApplicant_previousMonthsAtAddressInput("4");
            coApplicantExtraFieldsPage.setCoApplicant_previousHousingStatusIdInput("Rent");
            coApplicantExtraFieldsPage.setCoApplicant_previousMonthlyPaymentInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            /******Additional residence information**********/
            coApplicantExtraFieldsPage.setCoApplicant_anotherHomeAddressInput(faker.address().fullAddress());
            coApplicantExtraFieldsPage.setCoApplicant_anotherHomeAddressLine2Input(faker.address().secondaryAddress());
            coApplicantExtraFieldsPage.setCoApplicant_anotherZipCodeInput("10001");
            coApplicantExtraFieldsPage.setCoApplicant_anotherYearsAtAddressInput("2");
            coApplicantExtraFieldsPage.setCoApplicant_anotherMonthsAtAddressInput("2");
            coApplicantExtraFieldsPage.setCoApplicant_anotherHousingStatusIdInput("Rent");
            coApplicantExtraFieldsPage.setCoApplicant_anotherMonthlyPaymentInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            /******Previous income source information****/
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousEmployerNameInput(faker.name().name());
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousWorkPhoneNumberInput("3864206154");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousExtInput("100");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousHomeAddressInput(faker.address().fullAddress());
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousHomeAddressLine2Input(faker.address().secondaryAddress());
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousHomeSuiteNumberInput("507");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousZipCodeInput("10001");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousSupervisorNameInput(faker.name().name());
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousEmploymentStatusIdInput("Active Military");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousPositionDepartmentInput(faker.job().position());
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousYearsAtJobInput("3");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousMonthsAtJobInput("3");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousGrossIncomeInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_previousFrequencyIdInput("Yearly");
            /******Additional income source information****/
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherEmployerNameInput(faker.name().name());
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherWorkPhoneNumberInput("5011111111");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherExtInput("101");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherHomeAddressInput(faker.address().fullAddress());
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherHomeAddressLine2Input(faker.address().secondaryAddress());
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherHomeSuiteNumberInput("507");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherZipCodeInput("10001");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherSupervisorNameInput(faker.name().name());
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherEmploymentStatusIdInput("Active Military");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherPositionDepartmentInput(faker.job().position());
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherYearsAtJobInput("4");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherMonthsAtJobInput("2");
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherGrossIncomeInput(String.valueOf(faker.number().numberBetween(1000, 10000)));
            coApplicantExtraFieldsPage.setCoApplicant_incomeApplicant_otherFrequencyIdInput("Yearly");
            coApplicantExtraFieldsPage.selectApplicantTab();

        } catch (Exception e) {
            Assert.assertTrue("Error previousResidenceInformation: " + e, false);
        }

    }

    public void selectTPAProvider(WebDriver driver, String tpaProvider) {
        try {
            EditAppDealerPage editAppDealerPage = new EditAppDealerPage(driver);

            if (tpaProvider.equalsIgnoreCase("Alpha Warranty")) {
                editAppDealerPage.selectTPAAlphaWarranty(tpaProvider);

            } else {
                editAppDealerPage.selectTPATruwarranty(tpaProvider);
            }

            editAppDealerPage.clickOTTOProducts();
        } catch (Exception e) {
            Assert.assertTrue("Error selectTPAProvider: " + e, false);
        }
    }

    public void selectTPAProducts(WebDriver driver, String tpaProvider) {
        try {
            EditAppDealerPage editAppDealerPage = new EditAppDealerPage(driver);

            if (tpaProvider.equalsIgnoreCase("Alpha Warranty")) {
                editAppDealerPage.clickProductItemsAlphaWarranty();

            } else {
                editAppDealerPage.clickProductItemsTruwarranty();
            }
            editAppDealerPage.clickCreateContract();
        } catch (Exception e) {
            Assert.assertTrue("Error selectTPAProvider: " + e, false);
        }
    }
}