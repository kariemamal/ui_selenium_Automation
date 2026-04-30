import org.hrm.DashboardPage;
import org.hrm.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void login() throws InterruptedException {
        loginPage = new LoginPage(webDriver);
        dashboardPage = new DashboardPage(webDriver);
        loginPage.login("Admin", "admin123");
        Assert.assertEquals(getText(dashboardPage.dashboardItem), "Dashboard", "Login failed: Dashboard header text does not match expected value.");
    }
}
