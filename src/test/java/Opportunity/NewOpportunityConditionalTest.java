package Opportunity;

import base.TestBase;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages_ios.ListingInfoPage;
import pages_ios.LoginPage;
import pages_ios.NewOpportunityPage;
import utils.GlobalVars;
import utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewOpportunityConditionalTest {
    NewOpportunityPage newOpportunityPage;
    GlobalVars globalVars;
    LoginPage loginPage;
    ListingInfoPage listingInfoPage;

    @BeforeTest
    public void initialization(){
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test
    public void VerifyAddingSalesAndVendorInfo() {
        TestBase.quitDriver();
        initialization();
        loginPage=new LoginPage();
        newOpportunityPage=new NewOpportunityPage();
        SoftAssert softAssert=new SoftAssert();
        boolean isResult=false;
        String username=globalVars.getUsername("loginTest");
        String password=globalVars.getPassword("loginTest");

        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String title="Automation_Opp_"+timeStamp;

        String[] params=globalVars.getParamsData("VerifyAddingSalesAndVendorInfo");
        String vendorName=params[0];

        isResult = loginPage.login(username, password);
        Utils.logStepInfo(isResult, "Go to login page, enter the user name and password and click login button");
        softAssert.assertTrue(isResult, "Step-1: User failed to login!!");

        isResult = newOpportunityPage.verifyNewOpportunityNavigation();
        Utils.logStepInfo(isResult, "Click on New Opportunity tile");
        softAssert.assertTrue(isResult, "Step-2: Could not click on new opportunity tile!!");

        isResult = newOpportunityPage.addSalesInformation(title);
        Utils.logStepInfo(isResult, "Add sales information and click next");
        softAssert.assertTrue(isResult, "Step-1: Adding sales information failed!!");

        isResult = newOpportunityPage.addVendorInfo(vendorName);
        Utils.logStepInfo(isResult, "Add Vendor information and click next");
        softAssert.assertTrue(isResult, "Step-1: Adding Vendor information failed!!");

//        isResult = newOpportunityPage.addLotsInformationTwice(quantity, productCategory, product, breed, priceType, price, age1, age2, monthsDropdown, description);
//        newOpportunityPage.verifyLotSummaryPageValues(quantity, "0", price);
//        Utils.logStepInfo(isResult, "Add Lots information and click next");
//        softAssert.assertTrue(isResult, "Step-1: Adding Lots information failed!!");

//        isResult = newOpportunityPage.addAttachments();
//        newOpportunityPage.verifyAttachments();
//        Utils.logStepInfo(isResult, "Add an attachment file to the opportunity");
//        softAssert.assertTrue(isResult, "Step-1: Attachment file addition failed!!");
//
//        isResult = newOpportunityPage.addNotes(noteText);
//        newOpportunityPage.verifyNotes(noteText);
//        Utils.logStepInfo(isResult, "Add a note to the opportunity and send it");
//        softAssert.assertTrue(isResult, "Step-8: Adding and sending note failed!!");

    }
    @Test
    public void verifyPerKGConditionInLot() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyPerKGConditionInLot");
        String quantity = "",productCategory="",product="",breed="";
        try{
            quantity=params[0];productCategory=params[1];product=params[2];breed=params[3];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }

        isResult = newOpportunityPage.selectPerKgInPriceTypeDropDown(quantity, productCategory, product, breed);
        Utils.logStepInfo(isResult, "Select per kg in the price type drop down and verify that a new text field for total weight appears");
        Assert.isTrue(isResult, "Step-1: Per kg text field verification failed !!!!");
    }
    @Test
    public void verifyAddingValueToPerKGFieldInLot() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyAddingValueToPerKGFieldInLot");
        String weight =params[0];

        isResult = newOpportunityPage.addValueToPerKgWeightField(weight);
        Utils.logStepInfo(isResult, "Enter value in Total weight text field and verify that the value has been successfully entered ");
        Assert.isTrue(isResult, "Step-1: Total weight value enter failed !!!!");
    }
    @Test
    public void verifyWeightValueOnLotGridPage() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyWeightValueOnLotGridPage");
        String weight =params[0];
        String perHeadWeight = "", quantity="";
        int totalWeight=0;
        try{
            quantity=params[0];perHeadWeight=params[1];
            totalWeight=Integer.parseInt(quantity)*Integer.parseInt(perHeadWeight);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        isResult = newOpportunityPage.verifyWeightValueOnLotGridPage(totalWeight+"");
        Utils.logStepInfo(isResult, "verify that the correct weight value has been successfully populated ");
        Assert.isTrue(isResult, "Step-1: Total weight value verification on lot grid screen failed !!!!");
    }
    @Test
    public void verifyAddingSecondLotInTheSameOpportunity() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyAddingSecondLotInTheSameOpportunity");
        String quantity = "",productCategory="",product="",breed="";
        try{
            quantity=params[0];productCategory=params[1];product=params[2];breed=params[3];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }

        isResult = newOpportunityPage.addAnotherLotWithExistingLot(quantity, productCategory, product, breed);
        Utils.logStepInfo(isResult, "Add all mandatory fields on new lot screen");
        Assert.isTrue(isResult, "Step-1: Adding values to all mandatory fields on new lot screen failed !!!!");
    }
    @Test
    public void verifyDisabledListingType() {
        boolean isResult=false;
        listingInfoPage=ListingInfoPage.getInstance();

        if(newOpportunityPage.SubmitAndViewRecord()){
            isResult=listingInfoPage.checkListingTypeDisabled();
        }
        Utils.logStepInfo(isResult, "Verify that bid & offer and classified listing info type options are disabled");
        Assert.isTrue(isResult, "Step-1: Disabled listing info type verification failed !!!!");
    }
    @Test
    public void VerifyEditingLotsInfo() {
        boolean isResult=false;
        listingInfoPage=ListingInfoPage.getInstance();
        String[] params=globalVars.getParamsData("VerifyEditingLotsInfo");
        String newBreed =params[0];

        if(listingInfoPage.moveToLotsSection()){
            if(listingInfoPage.ClickEditLot()){
                isResult= newOpportunityPage.editLotInfo(newBreed);
            }
        }
        Utils.logStepInfo(isResult, "Edit lot and verify that the lot info has been edited successfully");
        Assert.isTrue(isResult, "Step-1: Editing lot info failed !!!!");
    }
    @Test
    public void VerifyDeletingLot() {
        boolean isResult=false;
        listingInfoPage=ListingInfoPage.getInstance();

        isResult= listingInfoPage.deleteFirstLot();

        Utils.logStepInfo(isResult, "Delete lot and verify that the lot info has been deleted successfully");
        Assert.isTrue(isResult, "Step-1: Deletion of lot failed !!!!");
    }
    @Test
    public void verifyEnabledListingType() {
        boolean isResult=false;
        listingInfoPage=ListingInfoPage.getInstance();

        if(listingInfoPage.moveToSalesInformationSection()){
            isResult= listingInfoPage.checkListingTypeEnabled();
        }
        Utils.logStepInfo(isResult, "Now Move to Sales Information part and verify that Bid & Offer and Classified Radio buttons are enabled");
        Assert.isTrue(isResult, "Step-1: Enabled radio buttons verification failed !!!!");
    }

    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }
}
