package starter.utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import starter.pages.applications.HomePage;

import java.time.Duration;

public class WebAction {

    private WebDriver driver;

    public WebAction() {}
    public WebAction(WebDriver driver) {
        this.driver = driver;
    }

    public void validateRequiredAlert() {
        By requiredAlert = By.xpath("//*[@role=\"alert\"][contains(text(),'required')]");
        try {
            if (driver.findElement(requiredAlert).isDisplayed()) {
                WebElement element = driver.findElement(requiredAlert);

                org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
                actions.moveToElement(element).perform();

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.border='3px solid red'", element);

                Assert.assertTrue("A required field is missing", false);
            }
        } catch (Exception e) {
        }
    }

    public void highlightElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='3px solid red'", element);
        } catch (Exception e) {
        }
    }

    /**
     * Waits implementations
     **/
    public void waitToBeClickable(WebDriver driver, By byElement) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(byElement)));
    }

    public void waitToBeClickable(WebDriver driver, WebElement webElement) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitToAttacheToThePageDocument(WebDriver driver, By byElement) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(byElement)));
    }

    public void waitVisibilityOf(WebDriver driver, By byElement) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(byElement)));
    }

    public void waitVisibilityOf(WebDriver driver, By byElement, int timeSeconds) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(timeSeconds))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(byElement)));
    }

    public void waitVisibilityOf(WebDriver driver, WebElement element, int timeSeconds) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(timeSeconds))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitInVisibilityOf(WebDriver driver, By byElement) {
        try {
            FluentWait wait = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(byElement)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitInVisibilityOf(WebDriver driver, By byElement, int timeSeconds) {
        try {
            FluentWait wait = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(timeSeconds))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(byElement)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
