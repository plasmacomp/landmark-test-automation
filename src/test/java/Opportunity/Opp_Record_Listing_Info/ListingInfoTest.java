package Opportunity.Opp_Record_Listing_Info;

import base.TestBase;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages_ios.ListingInfoPage;
import pages_ios.NewOpportunityPage;
import utils.GlobalVars;
import utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListingInfoTest {

    ListingInfoPage listingInfoPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization(){
        globalVars = TestBase.setup(this.getClass().getSimpleName());
        listingInfoPage=ListingInfoPage.getInstance();
    }

    @Test
    public void verifyListingTypeOptions() {
        boolean isResult=false;
        isResult = listingInfoPage.verifyListingTypeOptions();
        Utils.logStepInfo(isResult, "Verify that the page has two listing options: Bid & Offer and Classified");
        Assert.isTrue(isResult, "Step-1: Listing type options verification failed!!");
    }
    @Test
    public void verifyClassifiedListingType() {
        boolean isResult=false;
        isResult = listingInfoPage.verifyClassifiedListingType();
        Utils.logStepInfo(isResult, "Click on the classified listing type radio button and verify that the respective options appear");
        Assert.isTrue(isResult, "Step-1: Classified listing type verification failed!!");
    }
    @Test
    public void verifyBidAndOfferListingType() {
        boolean isResult=false;
        isResult = listingInfoPage.verifyBidAndOfferListingType();
        Utils.logStepInfo(isResult, "Click on the Bid & Offer listing type radio button and verify that the respective options appear");
        Assert.isTrue(isResult, "Step-1: Bid & Offer listing type verification failed!!");
    }

    @Test
    public void verifyListingTypeSelection() {
        boolean isResult=false;
        String transactionType="Online";
        String saleType="Dairy";
        isResult = listingInfoPage.verifyListingTypeSelection(false, transactionType, saleType);
        Utils.logStepInfo(isResult, "Select the required listing type option given as parameter");
        Assert.isTrue(isResult, "Step-1: Required listing type selection failed!!");
    }
    @Test
    public void verifyListingInfoNavigation() {
        boolean isResult=false;
        isResult = listingInfoPage.verifyListingInfoNavigation();
        Utils.logStepInfo(isResult, "Click on the listing info tab to navigate to listing info page");
        Assert.isTrue(isResult, "Step-1: Failed to navigate to listing info page!!");
    }


    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }
}
