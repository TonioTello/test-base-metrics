package starter.controllers.applications;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import starter.controllers.ApiController;
import starter.controllers.NavigateController;
import starter.pages.applications.HomePage;
import starter.pages.applications.LoginPage;
import starter.pages.companies.NewCompanyPage;
import starter.pages.companies.PlanPage;
import starter.utils.WebAction;

import java.util.concurrent.TimeUnit;

public class StartAppController {
    private WebDriver driver;

    @Managed(driver = "chrome")
    WebDriver webDriver; //serenity
    NavigateController navigateController;
    EnvironmentVariables environmentVariables;

    ApiController apiController = new ApiController();
    String currentEmailId = apiController.getlastEmailId(driver);


    public void starApp(WebDriver driver, String url, String feature, String scenario) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Todo
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        setSystemOp();
        ChromeOptions o = new ChromeOptions();
        o.addArguments("headless", "no-sandbox");
        DesiredCapabilities c = new DesiredCapabilities();
        c.setCapability(ChromeOptions.CAPABILITY, o);
        driver = new ChromeDriver(o);
        return driver;
    }

    public void setSystemOp() {
        String sSistemaOperativo = System.getProperty("os.name");
        if (sSistemaOperativo.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/windows/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/windows/chromedriver");
        }
    }

    public void inputCredentials(WebDriver driver, String username, String password) {
        try {
            LoginPage loginPage = new LoginPage(driver);
            //driver.manage().window().maximize();
            loginPage.clickLogInTab();
            loginPage.setUsernameField(username);
            loginPage.setPasswordField(password);
            loginPage.clickLoginButton();
            //loginPage.waitDataLoad();
            Thread.sleep(3000); // Wait data load
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error Log in : " + e);
        }
    }

    public void authorizationValidation(WebDriver driver) {

        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickOnSendRequestEmail();
            Thread.sleep(5000);
            String authenticationCode = apiController.getEmailAuthorizationCode(driver, currentEmailId);
            currentEmailId = apiController.getlastEmailId(driver);
            loginPage.setVerificationCode(authenticationCode);
            loginPage.clickOnValidate();
        } catch (Exception e) {
            Assert.fail("Error authorizationValidation: " + e);
        }

    }

    public void handleAutoLogOut(WebDriver driver, String username, String password) {
        try {
            LoginPage loginPage = new LoginPage(driver);
            if (driver.getCurrentUrl().contains("login")) {
                Thread.sleep(30000);
                loginPage.setUsernameField(username);
                loginPage.setPasswordField(password);
                loginPage.clickLoginButton();
                authorizationValidation(driver);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error handleAutoLogOut: " + e, false);
        }
    }

    public void inputCredentialsAfterPlan(WebDriver driver, String username, String password, String typeCompany) {
        try {
            LoginPage loginPage = new LoginPage(driver);
            //driver.manage().window().maximize();
            loginPage.closeNewUpdatePopup();
            loginPage.setUsernameField(username);
            loginPage.setPasswordField(password);
            loginPage.clickLoginButton();
            if (typeCompany.equalsIgnoreCase("lender")) {
                Assert.assertTrue("The \"Hello and Welcome to OTTOMOTO\" was not displayed", loginPage.validateMessageLender());
                loginPage.clickOnOkWelcomePopup();
            } else {
                Assert.assertTrue("Home page was not displayed", loginPage.getCheckOutLabel());
                Thread.sleep(3000); // Wait data load
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Log in : " + e, false);
        }


    }

    public void inputCredentialsAfterSetNewUser(WebDriver driver, String username, String password) {
        try {
            LoginPage loginPage = new LoginPage(driver);
            //driver.manage().window().maximize();
            loginPage.setUsernameField(username);
            loginPage.setPasswordField(password);
            loginPage.clickLoginButton();
            //loginPage.closeNewUpdatePopup();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Log in : " + e, false);
        }
    }

    public void closeRefreshNewUpdatePopup(WebDriver driver) {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.closeNewUpdatePopup();
            loginPage.waitDataLoad();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error closeRefreshNewUpdatePopup: " + e, false);
        }
    }


    public WebDriver login(String rol) {
        String username = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(String.format("user.username.%s", rol));
        String password = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(String.format("user.password.%s", rol));
        navigateController.toTheAppmotoHomePage();
        //driver.manage().window().maximize();
        inputCredentials(driver, username, password);
        return webDriver;
    }

    public void closeWelcomePopup(WebDriver driver) {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.closePopup();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error Welcome Popup", false);
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
            Assert.assertTrue("Error Logout: " + e, false);
        }
    }

    public void createPassword(WebDriver driver, String password) {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setNewPassword(password);
            loginPage.setConfirmPassword(password);
            loginPage.setTermsOfUseAgreement();
            loginPage.clickOnAccept();
            loginPage.clickOnSavePassword();
            Assert.assertTrue("Notification Success Company Validated is not displayed", true);
            //loginPage.closeNewUpdatePopup();
            System.out.println(" = ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeWelcomePopUp(WebDriver driver) {
        try {
            NewCompanyPage newCompanyPage = new NewCompanyPage(driver);
            newCompanyPage.clickOnDontShowAgain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hitRecoverPassword(WebDriver driver) {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickOnRecoverMyPassword();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void confirmEmail(WebDriver driver, String email) {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUsernameField(email);
            loginPage.clickOnValidateEmail();
            loginPage.clickOnEmailAddressOption();
            loginPage.clickOnRecoverMyPassword();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void validateNotificationMsj(WebDriver driver, String expectedStatus) {
        try {
            String notificationStatus = "";
            LoginPage loginPage = new LoginPage(driver);
            //Thread.sleep(1000);
            notificationStatus = loginPage.getNotificationStatus();
            Assert.assertTrue(String.format("Expected status: %s \nReceived Status: %s", expectedStatus, notificationStatus), notificationStatus.contains(expectedStatus));
            //Assert.assertTrue(String.format("Expected status: %s \nReceived Status: %s", expectedStatus, notificationStatus)  , true);
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            WebAction webAction = new WebAction(driver);
            webAction.validateRequiredAlert();
            Assert.fail(String.format("Error getting the status: %s :", e));
        }
    }


}
