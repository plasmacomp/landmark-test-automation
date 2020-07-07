package Opportunity.Opp_Record_Listing_Info;

import base.TestBase;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages_ios.ListingInfoPage;
import pages_ios.LoginPage;
import pages_ios.NewOpportunityPage;
import utils.GlobalVars;
import utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListingInfoClassifiedTest {
    ListingInfoPage listingInfoPage;
    LoginPage loginPage;
    NewOpportunityPage newOpportunityPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization(){
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test
    public void CreateOpportunityForClassified() {
        TestBase.quitDriver();
        initialization();
        listingInfoPage=new ListingInfoPage();
        loginPage=new LoginPage();
        newOpportunityPage=new NewOpportunityPage();
        boolean isResult;
        String username=globalVars.getUsername("loginTest");
        String password=globalVars.getPassword("loginTest");

        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String title="Automation_Opp_"+timeStamp;

        String[] params=globalVars.getParamsData("CreateOpportunityForClassified");
        String vendorName="", quantity = "",productCategory="",product="",breed="",priceType="",price="",age1="",age2="",monthsDropdown="",description="",noteText="";
        try{
            vendorName=params[0];quantity=params[1];productCategory=params[2];product=params[3];breed=params[4];priceType=params[5];
            price=params[6];age1=params[7];age2=params[8];monthsDropdown=params[9];description=params[10];noteText=params[11];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }

        isResult = loginPage.login(username, password);
        Utils.logStepInfo(isResult, "Go to login page, enter the user name and password and click login button");
        //Assert.isTrue(isResult, "Step-1: User failed to login!!");

        isResult = newOpportunityPage.verifyNewOpportunityNavigation();
        Utils.logStepInfo(isResult, "Click on New Opportunity tile");
        //Assert.isTrue(isResult, "Step-2: Could not click on new opportunity tile!!");

        isResult = newOpportunityPage.addSalesInformation(title);
        Utils.logStepInfo(isResult, "Add sales information and click next");
        //Assert.isTrue(isResult, "Step-1: Adding sales information failed!!");

        isResult = newOpportunityPage.addVendorInfo(vendorName);
        Utils.logStepInfo(isResult, "Add Vendor information and click next");
        //Assert.isTrue(isResult, "Step-1: Adding Vendor information failed!!");

        isResult = newOpportunityPage.addLotsInformation(quantity, productCategory, product, breed, priceType, price, age1, age2, monthsDropdown, description);
        newOpportunityPage.verifyLotSummaryPageValues(quantity, "0", price);
        Utils.logStepInfo(isResult, "Add Lots information and click next");
        //Assert.isTrue(isResult, "Step-1: Adding Lots information failed!!");

        isResult = newOpportunityPage.addAttachments();
        newOpportunityPage.verifyAttachments();
        Utils.logStepInfo(isResult, "Add an attachment file to the opportunity");
        //Assert.isTrue(isResult, "Step-1: Attachment file addition failed!!");

        isResult = newOpportunityPage.addNotes(noteText);
        newOpportunityPage.verifyNotes(noteText);
        Utils.logStepInfo(isResult, "Add a note to the opportunity and send it");
        Assert.isTrue(isResult, "Step-8: Adding and sending note failed!!");

    }

    @Test
    public void verifyListingTypeSelectionClassified() {
        boolean isResult=false;
        String transactionType="";
        String saleType="";
        String[] params=globalVars.getParamsData("verifyListingTypeSelectionClassified");
        try{
            transactionType=params[0];
            saleType=params[1];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        isResult = listingInfoPage.verifyListingTypeSelection(true, transactionType, saleType);
        Utils.logStepInfo(isResult, "Select the required listing type option given as parameter");
        Assert.isTrue(isResult, "Step-1: Required listing type selection failed!!");
    }
    @Test
    public void verifyListingInfoNavigationClassified() {
        boolean isResult=false;
        isResult = listingInfoPage.verifyListingInfoNavigation();
        Utils.logStepInfo(isResult, "Click on the listing info tab to navigate to listing info page");
        Assert.isTrue(isResult, "Step-1: Failed to navigate to listing info page!!");
    }

    @Test
    public void verifyFillingClassifiedListingOverviewDetails() {
        boolean isResult;
        String classifiedDuration="";
        int price=150;
        String description="";
        String[] params=globalVars.getParamsData("verifyFillingClassifiedListingOverviewDetails");
        try{
            classifiedDuration=params[0];
            price=Integer.parseInt(params[1]);
            description=params[2];
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        isResult = listingInfoPage.fillClassifiedListingOverviewDetails(classifiedDuration, price, description);
        Utils.logStepInfo(isResult, "Fill listing overview details");
        Assert.isTrue(isResult, "Step-1: Failed to fill listing overview details!!");
    }

    @Test
    public void verifyFillingClassifiedLotDetails() {
        boolean isResult=false;
        String hornStatus="";
        int weightRangeLow=0;
        int weightRangeHigh=0;
        String[] params=globalVars.getParamsData("verifyFillingClassifiedLotDetails");
        try{
            hornStatus=params[0];
            weightRangeLow=Integer.parseInt(params[1]);
            weightRangeHigh=Integer.parseInt(params[2]);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        isResult = listingInfoPage.fillClassifiedLotDetails(hornStatus,weightRangeLow+"", weightRangeHigh+"");
        Utils.logStepInfo(isResult, "Fill Breeding overview details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Breeding overview details!!");
    }
    @Test
    public void verifyFillingClassifiedHealthVetDetails() {
        boolean isResult=false;
        String hgpTreated="";
        String withinWithholdingPeriod="";
        String[] params=globalVars.getParamsData("verifyFillingClassifiedHealthVetDetails");
        try{
            hgpTreated=params[0];
            withinWithholdingPeriod=params[1];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        isResult = listingInfoPage.addHealthVetDetailsDetails(hgpTreated, withinWithholdingPeriod);
        Utils.logStepInfo(isResult, "Fill Health Vet details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Health Vet details!!");
    }

    @Test
    public void verifyClassifiedPublishListing() {
        boolean isResult=false;

        isResult = listingInfoPage.publishListing();
        Utils.logStepInfo(isResult, "Click on publish listing to publish the opportunity");
        Assert.isTrue(isResult, "Step-1: Failed to publish listing!!");
    }

    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }
}
