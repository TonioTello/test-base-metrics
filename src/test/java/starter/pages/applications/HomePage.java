package starter.pages.applications;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.utils.WebAction;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;
    private By popUp = By.id("___reactour");
    private By newUpdatePopUp = By.xpath("//*[contains(text(), 'New update')]");
    private By close_xOption = By.xpath("//*[contains(@class, 'close-x')]");

    private By closeOption = By.xpath("//*[contains(text(), 'show again')]");
    private By newAppButton = By.xpath("//*[contains(text(), 'New application') or contains(text(), 'New Application')]");
    private By numberApplications = By.xpath("//*[contains(text(), 'Total records')]");
    private By noApplications = By.xpath("//*[contains(text(), 'No Data')]");
    private By applicationNum = By.xpath("//tbody/tr[2]/td[1]/div//button");
    private By applicationNum_ = By.xpath("//tbody/tr[2]/td[1]/div//span");
    private By applicationNumLender = By.xpath("//tbody/tr[2]/td[1]/span/div/a");
    private By homeOpc = By.xpath("//*[contains(text(), 'Home')]");
    private By OTTOMOTOmaxOpc = By.xpath("//*[contains(text(), 'OTTOMOTOmax')]");
    private By companiesOpc = By.xpath("//*[@href=\"/company\" and contains(text(),'Companies')]");
    private By searchInput = By.xpath("//*[@placeholder=\"Search by App #, Applicant LN...\" or @id=\"search\"]");
    private By appStatusLabel = By.xpath("//*[contains(text(), 'Approved') or contains(text(), 'Submitted')]");
    private By appFoundOTTOmax = By.xpath("//tbody//button");
    private By appFoundHome = By.xpath("//tbody//a");
    private By appFoundHomeDealer = By.xpath("//tbody//span");
    private By checkAppFound = By.xpath("//*[contains(text(),'Total records 1')]");
    private By spinIcons = By.xpath("//*[@class=\"ant-spin-dot-item\"]");
    private By appFoundHomeApplicant = By.xpath("//tbody//span");
    private By editAppButton1 = By.xpath("//*[contains(text(),'Edit application')]");
    private By editAppButton2 = By.xpath("(//*[contains(text(),'Edit application')])[2]");
    private By logOutOpc = By.xpath("//*[contains(text(),'Logout')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewAppButton() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf( driver, newAppButton);
        driver.findElement(newAppButton).click();
    }

    public int getNumberApplications() throws InterruptedException {
        Thread.sleep(2000);
        int numberApp = 0;
        String textLabel = "";
        try {
            textLabel = driver.findElement(numberApplications).getText();
            numberApp = Integer.parseInt(textLabel.replaceAll("[^0-9]", ""));

        } catch (Exception e) {
            return numberApp;
        }

        return numberApp;
    }

    public void clickOTTOMOTOmaxOpc() {
        driver.findElement(OTTOMOTOmaxOpc).click();
    }

    public void clickHomeOpc() {
        driver.findElement(homeOpc).click();
    }

    public void searchApp(String appNumber, Boolean isValidation) throws InterruptedException {
        driver.findElement(searchInput).sendKeys(appNumber);
        Thread.sleep(2000);
        Integer.parseInt(appNumber); //Thrown a NumberFormatException
        if (isValidation) {
            driver.findElement(appFoundOTTOmax).click();
        } else {
            driver.findElement(appFoundHome).click();
        }
    }

    public void searchAppHomeApplicant(String appNumber) throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        driver.findElement(searchInput).sendKeys(appNumber);
        Thread.sleep(500);
        webAction.waitInVisibilityOf(driver, spinIcons);
        driver.findElement(appFoundHomeApplicant).click();
    }

    public void searchAppHomeDealer(String appNumber) throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, searchInput);
        driver.findElement(searchInput).sendKeys(appNumber);
        Thread.sleep(500);
        webAction.waitInVisibilityOf(driver, spinIcons);
        webAction.waitVisibilityOf(driver,checkAppFound);
        webAction.waitToBeClickable(driver, appFoundHomeDealer);
        driver.findElement(appFoundHomeDealer).click();
    }

    public void searchAppHomeLender(String appNumber) throws InterruptedException {
        driver.findElement(searchInput).sendKeys(appNumber);
        Thread.sleep(2000);
        driver.findElement(appFoundHomeDealer).click();
    }

    public String getAppLabelStatus(String status) throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(appStatusLabel).getText();
    }

    public void clickCompaniesOption() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(companiesOpc).click();
    }

    public String getNewApplicationNum() {
        return driver.findElement(applicationNum_).getText();
    }

    public String getNewApplicationNumLender() {
        return driver.findElement(applicationNumLender).getText();
    }

    public void closePopup() {
        try {
            if (driver.findElement(popUp).isDisplayed()) {
                driver.findElement(closeOption).click();
            }
        } catch (Exception e) {

        }
    }

    public void clickEditApplication() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(editAppButton2).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(editAppButton2).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(editAppButton2).sendKeys(Keys.ARROW_DOWN);

        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, editAppButton2);

        webAction.highlightElement(driver.findElement(editAppButton2));
        driver.findElement(editAppButton2).click();
    }

    public void clickEditApplicationOriginal() throws InterruptedException {
        Thread.sleep(2000);
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, editAppButton1);

        driver.findElement(editAppButton1).click();
    }

    public void logout() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(logOutOpc)).click().perform();
    }


    public void isLogOutVisible() {
        WebAction webAction = new WebAction(driver);
        try {
            Thread.sleep(2000);
            System.out.println("Time before" );
            //webAction.waitVisibilityOf(driver, logOutOpc, 5);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Logout')]")));
            driver.findElement(logOutOpc).click();
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("Time after" );

            System.out.println("e = " + e);

        }
    }
}
