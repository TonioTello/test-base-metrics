package starter.controllers.signUp;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import starter.pages.companies.PlanPage;
import starter.pages.signUp.SignUpPage;

public class SignUpController {
    public void goToSignUp(WebDriver driver, String typeCompany) {
        try {
            SignUpPage signUpPage = new SignUpPage(driver);
            //driver.manage().window().maximize();
            signUpPage.clickOnSign();
            if (typeCompany.equalsIgnoreCase("dealer")) {
                signUpPage.clickOnSignDealer();
            } else if (typeCompany.equalsIgnoreCase("lender")) {
                signUpPage.clickOnSignLender();
            } else if (typeCompany.equalsIgnoreCase("applicant")) {
                signUpPage.clickOnSignApplicant();
            } else {
                Assert.assertTrue("This role is not valid", false);
            }
            signUpPage.closeNewUpdatePopup();
            Thread.sleep(3000); // Wait data load
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
