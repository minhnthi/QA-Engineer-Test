package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.JobPage;
import pages.ApplyPage;

public class EasyApplyTest extends BaseTest {

    LoginPage login;
    JobPage job;
    ApplyPage apply;

    @BeforeMethod
    public void initPages() {

        login = new LoginPage(driver);
        job = new JobPage(driver);
        apply = new ApplyPage(driver);
    }
    @Test
    public void testEasyApplyFlow() {

        String email = System.getenv("LINKEDIN_EMAIL");
        String password = System.getenv("LINKEDIN_PASSWORD");

        login.openLoginPage();
        login.login(email, password);

        job.openJobs();
        job.searchJob("QA Engineer");
        job.filterEasyApply();
        job.clickEasyApply();

        apply.validateRequiredFields();
        apply.validateSubmitDisabled();

    }
}
