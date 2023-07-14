package starter.pages.companies;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import starter.utils.WebAction;

import java.time.Duration;

public class CompaniesPage {
    private WebDriver driver;

    private By newCompanyBtn = By.xpath("//*[@href=\"/company/new\"]");
    private By searchInput = By.xpath("//*[@placeholder=\"Search by App #, Applicant LN...\" or @id=\"search\"]");
    private By numCompaniesMatched = By.xpath("//*[contains(text(), 'Total records')]");
    private By editCompanyBtn = By.xpath("//*[@aria-label=\"Edit company\"]");

    private By checkAppFound = By.xpath("//*[contains(text(),'Total records 1')]");



    public CompaniesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewCompanyBton() {
        driver.findElement(newCompanyBtn).click();
    }

    public boolean searchCreatedCompany(String companyName) throws InterruptedException {
        int numberApp = 0;
        String totalRecordsText = "";
        driver.findElement(searchInput).sendKeys(companyName);
        Thread.sleep(2000);
        // I can get several companies
        try {
            totalRecordsText = driver.findElement(numCompaniesMatched).getText();
            numberApp = Integer.parseInt(totalRecordsText.replaceAll("[^0-9]", ""));
        } catch (Exception e) {
            return false;
        }
        return numberApp >= 1 ? true : false;
    }

    public void goTOEditCompany() {
        driver.findElement(editCompanyBtn).click();
    }

}