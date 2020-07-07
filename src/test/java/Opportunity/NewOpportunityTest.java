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
        boolean isResult;
        isResult = newOpportunityPage.verifyNewOpportunityNavigation();
        Utils.logStepInfo(isResult, "Click on New Opportunity tile");
        Assert.isTrue(isResult, "Step-1: Could not click on new opportunity tile!!");
    }
    @Test
    public void verifyNewOpportunityHeaderLabel() {
        boolean isResult;
        isResult = newOpportunityPage.verifyNewOpportunityHeaderLabel();
        Utils.logStepInfo(isResult, "Verify that New Opportunity Header label is present");
        Assert.isTrue(isResult, "Step-1:  New Opportunity Header label verification failed!!");
    }
    @Test
    public void verifySalesInformationLabel() {
        boolean isResult;
        isResult = newOpportunityPage.verifySalesInformationLabel();
        Utils.logStepInfo(isResult, "Verify that Sales Information label is present");
        Assert.isTrue(isResult, "Step-1:  Sales Information label verification failed!!");
    }
    @Test
    public void verifyVendorInfoLabel() {
        boolean isResult;
        isResult = newOpportunityPage.verifyVendorInfoLabel();
        Utils.logStepInfo(isResult, "Verify that Vendor Information label is present");
        Assert.isTrue(isResult, "Step-1:  Vendor Information label verification failed!!");
    }
    @Test
    public void verifyLotsLabel() {
        boolean isResult;
        isResult = newOpportunityPage.verifyLotsLabel();
        Utils.logStepInfo(isResult, "Verify that Lots label is present");
        Assert.isTrue(isResult, "Step-1:  Lots label verification failed!!");
    }
    @Test
    public void verifyNotesLabel() {
        boolean isResult;
        isResult = newOpportunityPage.verifyNotesLabel();
        Utils.logStepInfo(isResult, "Verify that Notes label is present");
        Assert.isTrue(isResult, "Step-1:  Notes label verification failed!!");
    }
    @Test
    public void verifyAttachmentsLabel() {
        boolean isResult;
        isResult = newOpportunityPage.verifyAttachmentsLabel();
        Utils.logStepInfo(isResult, "Verify that Attachments label is present");
        Assert.isTrue(isResult, "Step-1:  Attachments label verification failed!!");
    }

    @Test
    public void verifyAddSalesInformation() {
        boolean isResult;
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String title="Automation_Opp_"+timeStamp;
        isResult = newOpportunityPage.addSalesInformation(title);
        Utils.logStepInfo(isResult, "Add sales information and click next");
        Assert.isTrue(isResult, "Step-1: Adding sales information failed!!");
    }
    @Test
    public void verifyAddVendorInfo() {
        boolean isResult;
        String[] params=globalVars.getParamsData("verifyAddVendorInfo");
        String searchText=params[0];
        isResult = newOpportunityPage.addVendorInfo(searchText);
        Utils.logStepInfo(isResult, "Add Vendor information and click next");
        Assert.isTrue(isResult, "Step-1: Adding Vendor information failed!!");
    }
    @Test
    public void verifyAddLotsInfo() {
        boolean isResult;
        String[] params=globalVars.getParamsData("verifyAddLotsInfo");
        String quantity = "",productCategory="",product="",breed="",priceType="",price="",age1="",age2="",monthsDropdown="",description="";
        try{
            quantity=params[0];productCategory=params[1];product=params[2];breed=params[3];priceType=params[4];
            price=params[5];age1=params[6];age2=params[7];monthsDropdown=params[8];description=params[9];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        isResult = newOpportunityPage.addLotsInformation(quantity, productCategory, product, breed, priceType, price, age1, age2, monthsDropdown, description);
        Utils.logStepInfo(isResult, "Add Lots information and click next");
        Assert.isTrue(isResult, "Step-1: Adding Lots information failed!!");
    }
    @Test
    public void verifyLotSummaryPageHeaderLabels() {
        boolean isResult;
        isResult = newOpportunityPage.verifyLotSummaryPageHeaderLabels();
        Utils.logStepInfo(isResult, "Verify lots summary header labels and click next");
        Assert.isTrue(isResult, "Step-1: Lots summary header labels verification failed!!");
    }
    @Test
    public void verifyLotSummaryPageValues() {
        boolean isResult;
        String[] params=globalVars.getParamsData("verifyLotSummaryPageValues");
        String quantity="",price="", weight="";
        try{
            quantity=params[0];
            price=params[1];
            weight=params[2];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        isResult = newOpportunityPage.verifyLotSummaryPageValues(quantity, weight, price);
        Utils.logStepInfo(isResult, "Verify lots summary page values and click next");
        Assert.isTrue(isResult, "Step-1: Lots summary page values verification failed!!");
    }
    @Test
    public void verifyAddAttachments() {
        boolean isResult;
        isResult = newOpportunityPage.addAttachments();
        Utils.logStepInfo(isResult, "Add an attachment file to the opportunity");
        Assert.isTrue(isResult, "Step-1: Attachment file addition failed!!");
    }
    @Test
    public void verifyAttachments() {
        boolean isResult;
        isResult = newOpportunityPage.verifyAttachments();
        Utils.logStepInfo(isResult, "Verify that the attachment file has been uploaded");
        Assert.isTrue(isResult, "Step-1: Uploaded file verification in attachments tab failed!");
    }
    @Test
    public void verifyAddNotes() {
        boolean isResult;
        String[] params=globalVars.getParamsData("verifyAddNotes");
        String noteText=params[0];
        isResult = newOpportunityPage.addNotes(noteText);
        Utils.logStepInfo(isResult, "Add a note to the opportunity and send it");
        Assert.isTrue(isResult, "Step-8: Adding and sending note failed!!");
    }
    @Test
    public void verifyNotes() {
        boolean isResult;
        String[] params=globalVars.getParamsData("verifyNotes");
        String noteText=params[0];
        isResult = newOpportunityPage.verifyNotes(noteText);
        Utils.logStepInfo(isResult, "Verify that the note has been sent");
        Assert.isTrue(isResult, "Step-9: Notes verification failed!!");
    }


    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }
}
