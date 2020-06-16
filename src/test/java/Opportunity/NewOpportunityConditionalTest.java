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

    @BeforeTest
    public void initialization(){
        globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    @Test
    public void VerifyCreateNewOpportunityWithTwoLots() {
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

        String[] params=globalVars.getParamsData("VerifyCreateNewOpportunityWithTwoLots");
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

        isResult = newOpportunityPage.addLotsInformationTwice(quantity, productCategory, product, breed, priceType, price, age1, age2, monthsDropdown, description);
        newOpportunityPage.verifyLotSummaryPageValues(quantity, "0", price);
        Utils.logStepInfo(isResult, "Add Lots information and click next");
        softAssert.assertTrue(isResult, "Step-1: Adding Lots information failed!!");

        isResult = newOpportunityPage.addAttachments();
        newOpportunityPage.verifyAttachments();
        Utils.logStepInfo(isResult, "Add an attachment file to the opportunity");
        softAssert.assertTrue(isResult, "Step-1: Attachment file addition failed!!");

        isResult = newOpportunityPage.addNotes(noteText);
        newOpportunityPage.verifyNotes(noteText);
        Utils.logStepInfo(isResult, "Add a note to the opportunity and send it");
        softAssert.assertTrue(isResult, "Step-8: Adding and sending note failed!!");

    }

    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }
}
