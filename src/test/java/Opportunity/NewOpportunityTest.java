package Opportunity;

import base.TestBase;
import generic_pages.CommonDashboardPage;
import generic_pages.CommonNewOpportunityPage;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalVars;
import utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewOpportunityTest {
    CommonNewOpportunityPage commonNewOpportunityPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization(){
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }


    @Test
    public void verifyNewOpportunityNavigation() {
        boolean isResult=false;
        commonNewOpportunityPage = CommonNewOpportunityPage.getInstance();
        isResult = commonNewOpportunityPage.verifyNewOpportunityNavigation();
        Utils.logStepInfo(isResult, "Click on New Opportunity tile");
        Assert.isTrue(isResult, "Step-1: Could not click on new opportunity tile!!");
    }
    @Test
    public void verifyNewOpportunityHeaderLabel() {
        boolean isResult=false;
        commonNewOpportunityPage = CommonNewOpportunityPage.getInstance();
        isResult = commonNewOpportunityPage.verifyNewOpportunityHeaderLabel();
        Utils.logStepInfo(isResult, "Verify that New Opportunity Header label is present");
        Assert.isTrue(isResult, "Step-1:  New Opportunity Header label verification failed!!");
    }
    @Test
    public void verifySalesInformationLabel() {
        boolean isResult=false;
        commonNewOpportunityPage = CommonNewOpportunityPage.getInstance();
        isResult = commonNewOpportunityPage.verifySalesInformationLabel();
        Utils.logStepInfo(isResult, "Verify that Sales Information label is present");
        Assert.isTrue(isResult, "Step-1:  Sales Information label verification failed!!");
    }
    @Test
    public void verifyVendorInfoLabel() {
        boolean isResult=false;
        commonNewOpportunityPage = CommonNewOpportunityPage.getInstance();
        isResult = commonNewOpportunityPage.verifyVendorInfoLabel();
        Utils.logStepInfo(isResult, "Verify that Vendor Information label is present");
        Assert.isTrue(isResult, "Step-1:  Vendor Information label verification failed!!");
    }
    @Test
    public void verifyLotsLabel() {
        boolean isResult=false;
        commonNewOpportunityPage = CommonNewOpportunityPage.getInstance();
        isResult = commonNewOpportunityPage.verifyLotsLabel();
        Utils.logStepInfo(isResult, "Verify that Lots label is present");
        Assert.isTrue(isResult, "Step-1:  Lots label verification failed!!");
    }
    @Test
    public void verifyNotesLabel() {
        boolean isResult=false;
        commonNewOpportunityPage = CommonNewOpportunityPage.getInstance();
        isResult = commonNewOpportunityPage.verifyNotesLabel();
        Utils.logStepInfo(isResult, "Verify that Notes label is present");
        Assert.isTrue(isResult, "Step-1:  Notes label verification failed!!");
    }
    @Test
    public void verifyAttachmentsLabel() {
        boolean isResult=false;
        commonNewOpportunityPage = CommonNewOpportunityPage.getInstance();
        isResult = commonNewOpportunityPage.verifyAttachmentsLabel();
        Utils.logStepInfo(isResult, "Verify that Attachments label is present");
        Assert.isTrue(isResult, "Step-1:  Attachments label verification failed!!");
    }


    @Test
    public void verifyNewOpprtunityCreation() {
        boolean isResult=false;
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String title="Automation_Opp"+timeStamp;
        String vendorName="";
        commonNewOpportunityPage = CommonNewOpportunityPage.getInstance();
        isResult = commonNewOpportunityPage.createNewOpportunity(title, vendorName);

        Utils.logStepInfo(isResult, "Create a new opportunity and verify that the opportunity is successfully created");
        Assert.isTrue(isResult, "Step-1: New Opportunity creation failed!!");
    }


    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }
}
