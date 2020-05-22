package Opportunity;

import base.TestBase;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages_ios.NewOpportunityPage;
import utils.GlobalVars;
import utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewOpportunityTest {
    NewOpportunityPage newOpportunityPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization(){
        globalVars = TestBase.setup(this.getClass().getSimpleName());
        newOpportunityPage=NewOpportunityPage.getInstance();
    }

    @Test
    public void verifyNewOpportunityNavigation() {
        boolean isResult=false;
        isResult = newOpportunityPage.verifyNewOpportunityNavigation();
        Utils.logStepInfo(isResult, "Click on New Opportunity tile");
        Assert.isTrue(isResult, "Step-1: Could not click on new opportunity tile!!");
    }
    @Test
    public void verifyNewOpportunityHeaderLabel() {
        boolean isResult=false;
        isResult = newOpportunityPage.verifyNewOpportunityHeaderLabel();
        Utils.logStepInfo(isResult, "Verify that New Opportunity Header label is present");
        Assert.isTrue(isResult, "Step-1:  New Opportunity Header label verification failed!!");
    }
    @Test
    public void verifySalesInformationLabel() {
        boolean isResult=false;
        isResult = newOpportunityPage.verifySalesInformationLabel();
        Utils.logStepInfo(isResult, "Verify that Sales Information label is present");
        Assert.isTrue(isResult, "Step-1:  Sales Information label verification failed!!");
    }
    @Test
    public void verifyVendorInfoLabel() {
        boolean isResult=false;
        isResult = newOpportunityPage.verifyVendorInfoLabel();
        Utils.logStepInfo(isResult, "Verify that Vendor Information label is present");
        Assert.isTrue(isResult, "Step-1:  Vendor Information label verification failed!!");
    }
    @Test
    public void verifyLotsLabel() {
        boolean isResult=false;
        isResult = newOpportunityPage.verifyLotsLabel();
        Utils.logStepInfo(isResult, "Verify that Lots label is present");
        Assert.isTrue(isResult, "Step-1:  Lots label verification failed!!");
    }
    @Test
    public void verifyNotesLabel() {
        boolean isResult=false;
        isResult = newOpportunityPage.verifyNotesLabel();
        Utils.logStepInfo(isResult, "Verify that Notes label is present");
        Assert.isTrue(isResult, "Step-1:  Notes label verification failed!!");
    }
    @Test
    public void verifyAttachmentsLabel() {
        boolean isResult=false;
        isResult = newOpportunityPage.verifyAttachmentsLabel();
        Utils.logStepInfo(isResult, "Verify that Attachments label is present");
        Assert.isTrue(isResult, "Step-1:  Attachments label verification failed!!");
    }


    @Test
    public void verifyNewOpportunityCreation() throws InterruptedException {
        boolean isResult=false;
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String title="Automation_Opp_"+timeStamp;
        String vendorName="";
        String quantity="10";
        String productCategory="CSI";
        String product="Agistment - Buyer";
        String breed="Test_Breed";
        String priceType="$/head";
        String price="10";
        String age1="2";
        String age2="5";
        String monthsDropdown="Month";
        String description="Test Automation Description";
        String noteText="Automation note";

        isResult = newOpportunityPage.addSalesInformation(title);
        Utils.logStepInfo(isResult, "Add sales information and click next");
        Assert.isTrue(isResult, "Step-1: Adding sales information failed!!");

        isResult = newOpportunityPage.addVendorInfo();
        Utils.logStepInfo(isResult, "Add Vendor information and click next");
        Assert.isTrue(isResult, "Step-2: Adding Vendor information failed!!");

        isResult = newOpportunityPage.addLotsInformation(quantity, productCategory, product, breed, priceType, price, age1, age2, monthsDropdown, description);
        Utils.logStepInfo(isResult, "Add Lots information and click next");
        Assert.isTrue(isResult, "Step-3: Adding Lots information failed!!");

        isResult = newOpportunityPage.verifyLotSummaryPageHeaderLabels();
        Utils.logStepInfo(isResult, "Verify lots summary header labels and click next");
        Assert.isTrue(isResult, "Step-4: Lots summary header labels verification failed!!");

        isResult = newOpportunityPage.verifyLotSummaryPageValues(quantity, "0", price);
        Utils.logStepInfo(isResult, "Verify lots summary page values and click next");
        Assert.isTrue(isResult, "Step-5: Lots summary page values verification failed!!");

        isResult = newOpportunityPage.addAttachments();
        Utils.logStepInfo(isResult, "Add an attachment file to the opportunity");
        Assert.isTrue(isResult, "Step-6: Attachment file addition failed!!");

        isResult = newOpportunityPage.verifyAttachments();
        Utils.logStepInfo(isResult, "Verify that the attachment file has been uploaded");
        Assert.isTrue(isResult, "Step-7: Uploaded file verification in attachments tab failed!");

        isResult = newOpportunityPage.addNotes(noteText);
        Utils.logStepInfo(isResult, "Add a note to the opportunity and send it");
        Assert.isTrue(isResult, "Step-8: Adding and sending note failed!!");

        isResult = newOpportunityPage.verifyNotes(noteText);
        Utils.logStepInfo(isResult, "Verify that the note has been sent");
        Assert.isTrue(isResult, "Step-9: Notes verification failed!!");
    }


    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }
}
