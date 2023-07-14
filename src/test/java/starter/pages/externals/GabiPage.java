package starter.pages.externals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import starter.pages.applications.AppInfoPage;
import starter.utils.WebAction;

public class GabiPage {
    private WebDriver driver;

    //private By deniedTag = By.xpath("//*[contains(text(),'Error') or contains(text(),'error') or contains(text(),'Denied') or contains(text(),'denied')]");
    private By deniedTag = By.xpath("//*[contains(text(),'Denied') or contains(text(),'Access denied')]");
    private By gabiIframe = By.id("main-iframe");


    public GabiPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean deniedTagIsVisible() {
        WebAction webAction = new WebAction(driver);
        try {
            driver.switchTo().frame("main-iframe");
            webAction.highlightElement(driver.findElement(deniedTag));
            return driver.findElement(deniedTag).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}
