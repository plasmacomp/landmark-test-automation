package Opportunity.Dashboard;

import base.TestBase;
import generic_pages.CommonDashboardPage;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalVars;
import utils.Utils;

public class DashboardTest {
    CommonDashboardPage commonDashboardPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization(){
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }


    @Test
    public void verifyNewOpprtunity() {
        boolean isResult=false;
        commonDashboardPage = CommonDashboardPage.getInstance();
        isResult = commonDashboardPage.verifyNewOpportunity();
        Utils.logStepInfo(isResult, "Verify that New Opportunity tile is present");
        Assert.isTrue(isResult, "Step-1: New Opportunity tile verification failed!!");
    }
    @Test
    public void verifyOpprtunities() {
        boolean isResult=false;
        commonDashboardPage = CommonDashboardPage.getInstance();
        isResult = commonDashboardPage.verifyOpportunities();
        Utils.logStepInfo(isResult, "Verify that Opportunities tile is present");
        Assert.isTrue(isResult, "Step-1: Opportunities tile verification failed!!");
    }
    @Test
    public void verifyNewContract() {
        boolean isResult=false;
        commonDashboardPage = CommonDashboardPage.getInstance();
        isResult = commonDashboardPage.verifyNewContract();
        Utils.logStepInfo(isResult, "Verify that New Contract tile is present");
        Assert.isTrue(isResult, "Step-1: New Contract tile verification failed!!");
    }
    @Test
    public void verifyContracts() {
        boolean isResult=false;
        commonDashboardPage = CommonDashboardPage.getInstance();
        isResult = commonDashboardPage.verifyContracts();
        Utils.logStepInfo(isResult, "Verify that Contracts tile is present");
        Assert.isTrue(isResult, "Step-1: Contracts tile verification failed!!");
    }
    @Test
    public void verifySearch() {
        boolean isResult=false;
        commonDashboardPage = CommonDashboardPage.getInstance();
        isResult = commonDashboardPage.verifySearch();
        Utils.logStepInfo(isResult, "Verify that Search tile is present");
        Assert.isTrue(isResult, "Step-1: Search tile verification failed!!");
    }
    @Test
    public void verifyHamburger() {
        boolean isResult=false;
        commonDashboardPage = CommonDashboardPage.getInstance();
        isResult = commonDashboardPage.verifyHamburger();
        Utils.logStepInfo(isResult, "Verify that Hamnburger icon is present");
        Assert.isTrue(isResult, "Step-1: Hamnburger icon verification failed!!");
    }
    @Test
    public void verifyDashboardHeaderLabel() {
        boolean isResult=false;
        commonDashboardPage = CommonDashboardPage.getInstance();
        isResult = commonDashboardPage.verifyDashboardHeaderLabel();
        Utils.logStepInfo(isResult, "Verify that Dashboard Header label is present");
        Assert.isTrue(isResult, "Step-1: Dashboard Header label verification failed!!");
    }
    @Test
    public void verifyProfileIcon() {
        boolean isResult=false;
        commonDashboardPage = CommonDashboardPage.getInstance();
        isResult = commonDashboardPage.verifyProfileIcon();
        Utils.logStepInfo(isResult, "Verify that User Profile icon is present");
        Assert.isTrue(isResult, "Step-1: User Profile icon verification failed!!");
    }

    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }
}
