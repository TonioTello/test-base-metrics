package starter.pages.settings;

import org.openqa.selenium.*;
import starter.utils.WebAction;

public class SettingsPage {

    private WebDriver driver;


    private By settingsOpc = By.xpath("//*[contains(text(),'Settings')]");
    private By newDiscountCouponOpc = By.xpath("//*[@id='status']//following::*[contains(text(),'New Discount Coupon')]");
    private By discountCouponsBtn = By.xpath("//*[contains(text(),'Discount Coupons')]");
    private By codeCouponInput = By.id("code");
    private By typeCouponInput = By.id("type");
    private By valueOpc = By.xpath("//*[contains(@title,\"Percentage\")]//following-sibling::div");
    private By useCouponInput = By.id("use");
    private By useMultipleCouponOpc = By.xpath("//*[contains(@title,'Multiple')]");
    private By valueCouponInput = By.id("value");
    private By startDateCouponInput = By.xpath("(//*[@id='value']//following::input)[1]");
    // private By startDateCouponInput_ = By.id("mui-5");
    private By startDateCouponInput_ = By.xpath("//*[@id=\"mui-11\" or @id=\"mui-5\"]");
    private By okButton = By.xpath("//*[contains(@title,'OK') or contains(@title,'Ok')]");

    private By dateCouponYearInput_ = By.xpath("//button[contains(text(),'2023')]");
    private By dateCouponMonthInput_ = By.xpath("//button[contains(text(),'Mar')]");
    private By dateCouponDayInput_ = By.xpath("(//button[contains(text(),'20')])[1]");
    private By endDateCouponInput = By.xpath("(//*[@id='value']//following::input)[2]");
    private By endDateCouponInput_ = By.xpath("(//input[@id=\"status\"]//preceding::input)[last()]");
    private By statusCouponInput = By.id("status");
    private By observationCouponInput = By.id("observation");
    private By submitBtn = By.xpath("//*[contains(text(),'Submit') or contains(text(),'submit')]");
    private By searchInput = By.xpath("//*[contains(@placeholder, 'Search')]");
    private By totalRecordsLabel = By.xpath("//*[contains(text(),'Total records')]");
    private By advertisingOpc = By.xpath("//*[contains(text(),'Advertising')]");
    private By newCampaignOpc = By.xpath("//*[contains(text(),'New Campaign')]");
    private By campaignNameInput = By.id("campaignName");
    private By startDateCampaignInput = By.xpath("(//*[@id='campaignName']//following::input)[1]");
    private By dateCampaignYearInput_ = By.xpath("//button[contains(text(),'2022')]");
    private By dateCampaignMonthInput_ = By.xpath("//button[contains(text(),'Nov')]");
    private By dateCampaignDayInput_ = By.xpath("(//button[contains(text(),'23')])[1]");
    private By endDateCampaignInput = By.xpath("(//*[@id='campaignName']//following::input)[2]");
    private By endDateCampaignInput_ = By.xpath("(//input[@id=\"status\"]//preceding::input)[last()]");
    private By typeOfCompanyInput = By.id("typeOfCompany");
    private By companyNameInput = By.id("companyName");
    private By exposureTimeInput = By.id("exposureTime");
    private By statusCampaignInput = By.id("status");
    private By configurationStateInput = By.xpath("(//*[@id=\"status\"]//following::input)[1]");
    private By configurationTypeUsersInput = By.xpath("(//*[@id=\"status\"]//following::input)[2]");
    private By urlInput = By.id("url");
    private By campaignImageDesktopInput = By.id("campaignImageDesktop");
    private By campaignImageMobileInput = By.id("campaignImageMobile");
    private By uploadInput1 = By.xpath("(//*[contains(@class,'upload-picture')])[1]//*[contains(text(),'Upload')]");
    private By uploadInput2 = By.xpath("(//*[contains(@class,'upload-picture')])[2]//*[contains(text(),'Upload')]");

    //Education session
    private By educationOpc = By.xpath("//*[contains(text(),'Education')]");

    private By newNewBlogPostOpc = By.xpath("//*[contains(text(),'New blog post')]");

    private By blogTitleInput = By.id("title");
    private By bodyTextInput = By.xpath("//*[@id=\"body\"]//following::*[contains(@class,'ql-editor')]");
    private By blogPostImageInput = By.xpath("//input[@type=\"file\"]");
    private By blogPostDetails = By.xpath("//*[contains(text(),'View details')]");
    private By notificationStatus = By.xpath("//*[@role=\"status\"]");





    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSettingsOpc() {
        driver.findElement(settingsOpc).click();
    }

    public void clickOnNewDiscountCouponOpc() {
        driver.findElement(newDiscountCouponOpc).click();
    }

    public void clickOnDiscountCouponsBtn() {
        driver.findElement(discountCouponsBtn).click();
    }

    public void setCodeCouponInput(String codeCoupon) {
        driver.findElement(codeCouponInput).sendKeys(codeCoupon);
    }

    public void setTypeCouponInput(String typeCoupon) throws InterruptedException {
        driver.findElement(typeCouponInput).click();
        Thread.sleep(800);
        //driver.findElement(valueOpc).click();
        driver.findElement(typeCouponInput).sendKeys(Keys.ENTER);

    }

    public void setUseCouponInput(String useCoupon) throws InterruptedException {
        driver.findElement(useCouponInput).click();
        Thread.sleep(800);
        //driver.findElement(useMultipleCouponOpc).click();
        driver.findElement(useCouponInput).sendKeys(Keys.ENTER);
    }

    public void setValueCouponInput(String valueCoupon) {
        driver.findElement(valueCouponInput).sendKeys(valueCoupon);
    }

    public void setStartDateCouponInput(String startDateCoupon) throws InterruptedException {
        Thread.sleep(500);
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, startDateCouponInput);
        driver.findElement(startDateCouponInput).click();
        Thread.sleep(500);
        driver.findElement(dateCouponYearInput_).click();
        Thread.sleep(500);
        driver.findElement(dateCouponMonthInput_).click();
        Thread.sleep(500);
        driver.findElement(dateCouponDayInput_).click();
        Thread.sleep(500);

    }

    public void setEndDateCouponInput(String endDateCoupon) throws InterruptedException {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, endDateCouponInput_);
        driver.findElement(endDateCouponInput_).click();
        Thread.sleep(500);
        driver.findElement(dateCouponYearInput_).click();
        Thread.sleep(500);
        driver.findElement(dateCouponMonthInput_).click();
        Thread.sleep(500);
        driver.findElement(dateCouponDayInput_).click();
        Thread.sleep(500);

    }

    public void setStatusCouponInput(String statusCoupon) throws InterruptedException {
        driver.findElement(statusCouponInput).click();
        Thread.sleep(500);
        driver.findElement(statusCouponInput).sendKeys(Keys.ENTER);
    }

    public void setObservationCouponInput(String observationCoupon) {
        driver.findElement(observationCouponInput).sendKeys(observationCoupon);
    }

    public void clickOnSubmit() {
        WebAction webAction = new WebAction(driver);
        webAction.highlightElement(driver.findElement(submitBtn));
        driver.findElement(submitBtn).click();
    }

    public void setSearchInput(String code) {
        driver.findElement(searchInput).sendKeys(code);
    }

    public boolean getTotalRecords() {
        return driver.findElement(totalRecordsLabel).isDisplayed();
    }

    public void clickOnAdvertisingOpc() {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, advertisingOpc);
        driver.findElement(advertisingOpc).click();
    }

    public void clickOnNewCampaign() {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, newCampaignOpc);
        driver.findElement(newCampaignOpc).click();
    }

    public void setCampaignNameInput(String campaignName) {
        driver.findElement(campaignNameInput).sendKeys(campaignName);
    }

    public void setStartDateCampaignInput(String startDateCampaign) {
        driver.findElement(startDateCampaignInput).sendKeys(startDateCampaign);
    }

    public void setEndDateCampaignInput(String endDateCampaign) {
        driver.findElement(endDateCampaignInput).sendKeys(endDateCampaign);
    }

    public void setTypeOfCompanyInput(String typeOfCompany) {
        driver.findElement(typeOfCompanyInput).click();
        driver.findElement(typeOfCompanyInput).sendKeys(Keys.ENTER);
    }

    public void setCompanyNameInput(String companyName) {
        driver.findElement(companyNameInput).sendKeys(companyName);
    }

    public void setExposureTimeInput(String exposureTime) {
        driver.findElement(exposureTimeInput).click();
        driver.findElement(exposureTimeInput).sendKeys(Keys.ENTER);
    }

    public void setStatusCampaignInput(String status) {
        driver.findElement(statusCampaignInput).click();
        driver.findElement(statusCampaignInput).sendKeys(Keys.ENTER);

    }

    public void setConfigurationStateInput(String configurationState) {
        driver.findElement(configurationStateInput).click();
        driver.findElement(configurationStateInput).sendKeys(Keys.ENTER);
    }

    public void setConfigurationTypeUsersInput(String configurationTypeUsers) {
        driver.findElement(configurationTypeUsersInput).click();
        driver.findElement(configurationTypeUsersInput).sendKeys(Keys.ENTER);
    }

    public void setUrlInput(String url) {
        driver.findElement(urlInput).sendKeys(url);
    }
    public void setCampaignImageDesktopInput(String campaignImageDesktop) {
        driver.findElement(campaignImageDesktopInput).sendKeys(campaignImageDesktop);
    }

    public void setCampaignImageMobileInput(String campaignImageMobile) {
        driver.findElement(campaignImageMobileInput).sendKeys(campaignImageMobile);
    }

    public void setUploadInput1(String upload) {
        driver.findElement(uploadInput1).click();

    }

    public void setUploadInput2(String upload) {
        driver.findElement(uploadInput2).click();
    }


    public void setBlogPostTitleInput(String blogPostTitle) {
        driver.findElement(blogTitleInput).sendKeys(blogPostTitle);

    }

    public void setBlogPostBodyTextInput(String blogPostText) {
        driver.findElement(bodyTextInput).sendKeys(blogPostText);

    }

    public void setBlogPostImage(String carLoanBlogImage) {
        driver.findElement(blogPostImageInput).sendKeys(carLoanBlogImage);
    }

    public void clickOnNewBlogPost() {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, newNewBlogPostOpc);
        driver.findElement(newNewBlogPostOpc).click();
    }

    public void clickOnEducationOpc() {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, educationOpc);
        driver.findElement(educationOpc).click();
    }

    public void clickOnViewBlogDetails() {
        WebAction webAction = new WebAction(driver);
        webAction.waitToBeClickable(driver, blogPostDetails);
        driver.findElement(blogPostDetails).click();
    }

    public void waitNotificationInvisibility() {
        WebAction webAction = new WebAction(driver);
        webAction.waitVisibilityOf(driver, notificationStatus);
        webAction.waitInVisibilityOf(driver, notificationStatus);
    }
}
