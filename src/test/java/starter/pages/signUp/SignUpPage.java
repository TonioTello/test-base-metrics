package starter.pages.signUp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class SignUpPage {
    private WebDriver driver;

    private By signUpBtn = By.xpath("//*[contains(text(),'Sign up')]");
    private By signUpDealerBtn = By.xpath("//*[contains(text(),'Sign up as dealer')]");
    private By signUpLenderBtn = By.xpath("//*[contains(text(),'Sign up as lender')]");
    private By signUpApplicantBtn = By.xpath("//*[contains(text(),'Sign up as applicant')]");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSign(){
        driver.findElement(signUpBtn).click();
    }
    public void clickOnSignDealer(){
        driver.findElement(signUpDealerBtn).click();
    }
    public void clickOnSignLender(){
        driver.findElement(signUpLenderBtn).click();
    }
    public void clickOnSignApplicant(){
        driver.findElement(signUpApplicantBtn).click();
    }
    private By refreshBtn = By.xpath("//*[contains(text(), 'Refresh')]");


    public void closeNewUpdatePopup() {
        try {
            FluentWait wait = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(refreshBtn)));
            driver.findElement(refreshBtn).click();
            Thread.sleep(3000);
        } catch (Exception e) {

        }
    }
}
