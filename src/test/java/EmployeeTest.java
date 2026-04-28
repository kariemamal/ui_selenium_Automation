import org.hrm.AddEmployeePage;
import org.hrm.DashboardPage;
import org.hrm.EmployeePage;
import org.hrm.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    EmployeePage employeePage;

    @Test(priority = 1)
    public void login() throws InterruptedException {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage.login("Admin", "admin123");
        Assert.assertEquals(getText(dashboardPage.dashboardItem), "Dashboard", "Login failed: Dashboard header text does not match expected value.");
    }

    @Test(priority = 2)
    public void openEmployeePage() throws InterruptedException {
        employeePage = new EmployeePage(driver);
//        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.openEmployeePage();
        Assert.assertEquals(getText(employeePage.pageTitle), "PIM", "Failed to open Employee Page: Page title does not match expected value.");
    }

    @Test(priority = 3)
    public void openCreateEmployeePage() {
        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
        employeePage.OpenAddEmployeePage();
        Assert.assertEquals(getText(addEmployeePage.pageTitle), "Add Employee", "Failed to open Create Employee Page: Page title does not match expected value.");
    }

    @Test(priority = 4)
    public void createEmployee() throws InterruptedException {
        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
        addEmployeePage.createEmployee("karim", "gamal", "rashed", faker.name().name(), "karim123" , true);
//        Assert.assertTrue(driver.getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/"));
    }
}
