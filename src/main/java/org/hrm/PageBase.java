package org.hrm;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {


    WebDriver driver;
    Wait<WebDriver> wait;
    WebElement webElement;

    By loader = By.cssSelector(".oxd-form-loader");


    public PageBase(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(ElementClickInterceptedException.class).withMessage("Element click intercepted after waiting for 30 seconds")
                .ignoring(NoSuchElementException.class).withMessage("Element not found after waiting for 30 seconds")
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class).withMessage("Element not interactable after waiting for 30 seconds");

//                .ignoring(Exception.class).withMessage("An unexpected exception occurred after waiting for 30 seconds");
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Initialize WebDriverWait with a 20-second timeout by explicitly waiting for specific conditions to be met before proceeding with actions on the page.
    }


    public void click(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        wait.until(driver -> driver.findElement(locator)).click();
    }

    public void type(By locator, String text) {
        wait.until(driver -> driver.findElement(locator)).sendKeys(text);
    }

    public String getText(By locator) {
        return wait.until(driver -> driver.findElement(locator)).getText();
    }


}
