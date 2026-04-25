import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {


    WebDriver driver;

   Wait<WebDriver> wait;


    @BeforeTest
    public void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class).withMessage("Element not found after waiting for 30 seconds")
                .ignoring(ElementNotInteractableException.class).withMessage("Element not interactable after waiting for 30 seconds")
                .ignoring(ElementClickInterceptedException.class).withMessage("Element click intercepted after waiting for 30 seconds");
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    public String getText(By locator) {
        return wait.until(driver -> driver.findElement(locator)).getText();
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
