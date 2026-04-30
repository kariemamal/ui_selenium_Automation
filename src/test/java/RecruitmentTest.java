import org.hrm.RecruitmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class RecruitmentTest extends TestBase {


    RecruitmentPage recruitmentPage;

    @Test
    public void checkThatRecruitmentIsOpened() {
        System.out.println("Requirement time now is : " + new Date().getTime());
        recruitmentPage = new RecruitmentPage(webDriver);
        dashboardPage.openRecruitmentPage();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");
    }
}
