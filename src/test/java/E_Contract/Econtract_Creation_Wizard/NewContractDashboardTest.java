package E_Contract.Econtract_Creation_Wizard;

import base.TestBase;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages_ios.GridPage;
import pages_ios.NewContractPage;
import pages_ios.ReviewAndSignPage;
import utils.GlobalVars;
import utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewContractDashboardTest {
    private static NewContractPage newContractPage;
    private static GridPage gridPage;
    private static ReviewAndSignPage reviewAndSignPage;
    GlobalVars globalVars;



    @BeforeTest
    public void initialization(){
        globalVars = TestBase.setup(this.getClass().getSimpleName());
        newContractPage = NewContractPage.getInstance();
        gridPage=GridPage.getInstance();
        reviewAndSignPage=ReviewAndSignPage.getInstance();
    }

    @Test
    public void verifyNewContractNavigation() {
        boolean isResult=false;
        isResult = newContractPage.verifyNewContractNavigation();
        Utils.logStepInfo(isResult, "Click on New Contract tile");
        Assert.isTrue(isResult, "Step-1: Could not click on new Contract tile!!");
    }
    @Test
    public void verifyNewContractHeaderLabel() {
        boolean isResult=false;
        isResult = newContractPage.verifyNewContractHeaderLabel();
        Utils.logStepInfo(isResult, "Verify that New Contract Header label is present");
        Assert.isTrue(isResult, "Step-1:  New Contract Header label verification failed!!");
    }
    @Test
    public void verifyNewContractSalesInformationLabel() {
        boolean isResult=false;
        isResult = newContractPage.verifySalesInformationLabel();
        Utils.logStepInfo(isResult, "Verify that Sales Information label is present");
        Assert.isTrue(isResult, "Step-1:  Sales Information label verification failed!!");
    }
    @Test
    public void verifyNewContractVendorInfoLabel() {
        boolean isResult=false;
        isResult = newContractPage.verifyVendorInfoLabel();
        Utils.logStepInfo(isResult, "Verify that Vendor Information label is present");
        Assert.isTrue(isResult, "Step-1:  Vendor Information label verification failed!!");
    }
    @Test
    public void verifyBuyerInfoLabel() {
        boolean isResult=false;
        isResult = newContractPage.verifyBuyerInfoLabel();
        Utils.logStepInfo(isResult, "Verify that Buyer Information label is present");
        Assert.isTrue(isResult, "Step-1:  Buyer Information label verification failed!!");
    }
    @Test
    public void verifyDeliveryInfoLabel() {
        boolean isResult=false;
        isResult = newContractPage.verifyDeliveryInfoLabel();
        Utils.logStepInfo(isResult, "Verify that Delivery Information label is present");
        Assert.isTrue(isResult, "Step-1:  Delivery Information label verification failed!!");
    }
    @Test
    public void verifyNewContractLotsLabel() {
        boolean isResult=false;
        isResult = newContractPage.verifyLotsLabel();
        Utils.logStepInfo(isResult, "Verify that Lots label is present");
        Assert.isTrue(isResult, "Step-1:  Lots label verification failed!!");
    }
    @Test
    public void verifyAdditionalChargesLabel() {
        boolean isResult=false;
        isResult = newContractPage.verifyAdditionalChargesLabel();
        Utils.logStepInfo(isResult, "Verify that additional charges label is present");
        Assert.isTrue(isResult, "Step-1:  additional charges label verification failed!!");
    }
    @Test
    public void verifyCommissionAndAgentsLabel() {
        boolean isResult=false;
        isResult = newContractPage.verifyCommissionAndAgentsLabel();
        Utils.logStepInfo(isResult, "Verify that Commission And Agents label is present");
        Assert.isTrue(isResult, "Step-1:  Commission And Agents label verification failed!!");
    }
    @Test
    public void verifyNewContractNotesLabel() {
        boolean isResult=false;
        isResult = newContractPage.verifyNotesLabel();
        Utils.logStepInfo(isResult, "Verify that Notes label is present");
        Assert.isTrue(isResult, "Step-1:  Notes label verification failed!!");
    }
    @Test
    public void verifyNewContractAttachmentsLabel() {
        boolean isResult=false;
        isResult = newContractPage.verifyAttachmentsLabel();
        Utils.logStepInfo(isResult, "Verify that Attachments label is present");
        Assert.isTrue(isResult, "Step-1:  Attachments label verification failed!!");
    }
    @Test
    public void verifyNewContractAddSalesInformation() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyNewContractAddSalesInformation");
        String salesType="",branchName="", month="";
        int day=0;
        int year=0;
        try{
            salesType=params[0];
            branchName=params[1];
            month=params[2];
            day=Integer.parseInt(params[3]);
            year=Integer.parseInt(params[4]);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        isResult = newContractPage.fillSalesInformation(month, day, year, salesType, branchName);
        Utils.logStepInfo(isResult, "Add sales information and click next");
        Assert.isTrue(isResult, "Step-1: Adding sales information failed!!");
    }
    @Test
    public void verifyNewContractAddVendorInfo() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyNewContractAddVendorInfo");
        String vendorName=params[0];
        isResult = newContractPage.addVendorInfo(vendorName);
        Utils.logStepInfo(isResult, "Add Vendor information and click next");
        Assert.isTrue(isResult, "Step-1: Adding Vendor information failed!!");
    }
    @Test
    public void verifyAddBuyerInfo() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyAddBuyerInfo");
        String buyerName=params[0];
        isResult = newContractPage.addBuyerInfo(buyerName);
        Utils.logStepInfo(isResult, "Add Buyer information and click next");
        Assert.isTrue(isResult, "Step-1: Adding Buyer information failed!!");
    }
    @Test
    public void verifyAddDeliveryInfo() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyAddDeliveryInfo");
        String deliveryPoint="",month="";
        int day=0;
        int year=0;
        try{
            deliveryPoint=params[0];
            month=params[1];
            day=Integer.parseInt(params[2]);
            year=Integer.parseInt(params[3]);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        isResult = newContractPage.addDeliveryInfo(deliveryPoint, month, day, year);
        Utils.logStepInfo(isResult, "Add Delivery information and click next");
        Assert.isTrue(isResult, "Step-1: Adding Delivery information failed!!");
    }
    @Test
    public void verifyNewContractAddLotsInfo() {
        boolean isResult=false;

        String[] params=globalVars.getParamsData("verifyNewContractAddLotsInfo");
        String quantity = "",productCategory="",product="",breed="",priceType="",price="",age1="",age2="",monthsDropdown="",description="";
        try{
            quantity=params[0];
            productCategory=params[1];
            product=params[2];
            breed=params[3];
            priceType=params[4];
            price=params[5];
            age1=params[6];
            age2=params[7];
            monthsDropdown=params[8];
            description=params[9];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        isResult = newContractPage.addLotsInformation(quantity, productCategory, product, breed, priceType, price, age1, age2, monthsDropdown, description);
        Utils.logStepInfo(isResult, "Add Lots information and click next");
        Assert.isTrue(isResult, "Step-1: Adding Lots information failed!!");
    }
    @Test
    public void verifyAddAdditionalCharges() {
        boolean isResult=false;
        isResult = newContractPage.addAdditionalCharges();
        Utils.logStepInfo(isResult, "Add Additional Charges information and click next");
        Assert.isTrue(isResult, "Step-1: Adding Additional Charges failed!!");
    }
    @Test
    public void verifyAddCommissionAndAgents() {
        boolean isResult=false;
        isResult = newContractPage.addCommissionAndAgent();
        Utils.logStepInfo(isResult, "Add Commission And Agent information and click next");
        Assert.isTrue(isResult, "Step-1: Adding Commission And Agent information failed!!");
    }

//    @Test
//    public void verifyNewContractAddAttachments() {
//        boolean isResult=false;
//        isResult = newContractPage.addAttachments();
//        Utils.logStepInfo(isResult, "Add an attachment file to the Contract");
//        Assert.isTrue(isResult, "Step-1: Attachment file addition failed!!");
//    }
    @Test
    public void verifyNewContractAttachments() {
        boolean isResult=false;
        isResult = newContractPage.verifyAttachments();
        Utils.logStepInfo(isResult, "Verify that the attachment file has been uploaded");
        Assert.isTrue(isResult, "Step-1: Uploaded file verification in attachments tab failed!");
    }
    @Test
    public void verifyNewContractAddNotes() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyNewContractAddNotes");
        String noteText=params[0];
        isResult = newContractPage.addNotes(noteText);
        Utils.logStepInfo(isResult, "Add a note to the Contract and send it");
        Assert.isTrue(isResult, "Step-8: Adding and sending note failed!!");
    }
    @Test
    public void verifyNewContractNotes() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyNewContractNotes");
        String noteText=params[0];
        isResult = newContractPage.verifyNotes(noteText);
        Utils.logStepInfo(isResult, "Verify that the note has been sent");
        Assert.isTrue(isResult, "Step-9: Notes verification failed!!");
    }
    @Test
    public void verifyValidateContract() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyValidateContract");
        String signatureText=params[0];
        isResult = reviewAndSignPage.signedForAndOnBehalfOfLandmarkAsAgent(signatureText);
        Utils.logStepInfo(isResult, "Verify that user is able to sign the contract");
        Assert.isTrue(isResult, "Step-9: Failed to sign contract!!");
    }


    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }
}
