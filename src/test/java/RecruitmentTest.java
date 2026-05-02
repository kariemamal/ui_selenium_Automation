import org.hrm.DashboardPage;
import org.hrm.RecruitmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Date;

public class RecruitmentTest extends TestBase {


    RecruitmentPage recruitmentPage;

    @Test
    public void checkThatRecruitmentIsOpened() {
        System.out.println("Requirement time now is : " + new Date().getTime());
        recruitmentPage = new RecruitmentPage(webDriver);
        DashboardPage dashboardPage = new DashboardPage(webDriver);
        dashboardPage.openRecruitmentPage();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");
    }
}
