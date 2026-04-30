import org.hrm.RecruitmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecruitmentTest extends TestBase {


    RecruitmentPage recruitmentPage;

    @Test
    public void checkThatRecruitmentIsOpened() {
        recruitmentPage = new RecruitmentPage(webDriver);
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");
    }
}
