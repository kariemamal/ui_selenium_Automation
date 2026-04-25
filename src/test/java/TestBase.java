import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {

    protected static final String EXECUTION_MODE = System.getProperty("execution.mode",
            System.getenv("EXECUTION_MODE"));
    protected static final String REMOTE_URL = System.getProperty("grid.url",
            System.getenv("GRID_URL"));


    WebDriver driver;
    Wait<WebDriver> wait;

    @BeforeTest
    public void setupWebDriver() throws MalformedURLException {
        boolean isRemote = "remote".equalsIgnoreCase(EXECUTION_MODE);

        if (isRemote) {
            String gridUrl = REMOTE_URL != null ? REMOTE_URL : "http://localhost:4444/wd/hub";
            driver = createRemoteDriver(gridUrl);
        } else {
            driver = createLocalDriver();
        }

        driver.manage().window().maximize();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class).withMessage("Element not found after waiting for 30 seconds")
                .ignoring(ElementNotInteractableException.class).withMessage("Element not interactable after waiting for 30 seconds")
                .ignoring(ElementClickInterceptedException.class).withMessage("Element click intercepted after waiting for 30 seconds");
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    private WebDriver createLocalDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    private WebDriver createRemoteDriver(String gridUrl) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--headless=new");
        options.setCapability("browserName", "chrome");
        return new RemoteWebDriver(new URL(gridUrl), options);
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
