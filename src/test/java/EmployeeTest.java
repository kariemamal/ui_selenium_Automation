import jdk.jfr.Timestamp;
import org.hrm.AddEmployeePage;
import org.hrm.DashboardPage;
import org.hrm.EmployeePage;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

public class EmployeeTest extends TestBase {
    DashboardPage dashboardPage;
    EmployeePage employeePage;


    @Test(priority = 1)
    public void openEmployeePage() throws InterruptedException {
        System.out.println("Session ID: " + LocalDateTime.now().toString());
        employeePage = new EmployeePage(webDriver);
        dashboardPage = new DashboardPage(webDriver);
        dashboardPage.openEmployeePage();
        Assert.assertEquals(getText(employeePage.pageTitle), "PIM", "Failed to open Employee Page: Page title does not match expected value.");
    }

    @Test(priority = 2)
    public void openCreateEmployeePage() {
        AddEmployeePage addEmployeePage = new AddEmployeePage(webDriver);
        employeePage.OpenAddEmployeePage();
        Assert.assertEquals(getText(addEmployeePage.pageTitle), "Add Employee", "Failed to open Create Employee Page: Page title does not match expected value.");
    }

    @Test(priority = 3)
    public void createEmployee() throws InterruptedException {
        AddEmployeePage addEmployeePage = new AddEmployeePage(webDriver);
        addEmployeePage.createEmployee("karim", "gamal", "rashed", faker.name().name(), "karim123", true);
//        Assert.assertTrue(driver.getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/"));
    }
}
