package Opportunity.Opp_Record_Listing_Info;

import base.TestBase;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages_ios.ListingInfoPage;
import utils.GlobalVars;
import utils.Utils;

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

    @Test
    public void verifyFillingListingOverviewDetails() {
        boolean isResult=false;
        String biddingDuration="24 hours";
        String closingSoonStatusDuration="3 hours";
        String startingPrice="200";
        String description="Test Description";
        String reservePrice="215";
        String town="BRISBANE";
        isResult = listingInfoPage.fillListingOverviewDetails(biddingDuration, closingSoonStatusDuration, startingPrice, description, reservePrice, town);
        Utils.logStepInfo(isResult, "Fill listing overview details");
        Assert.isTrue(isResult, "Step-1: Failed to fill listing overview details!!");
    }
    @Test
    public void verifyFillingWeightsSummaryDetails() {
        boolean isResult=false;
        int numberOfHeadWeighted=2;
        int hoursOffFeed=4;
        int estimatedDressing=12;
        int estimatedDaysToDelivery=5;
        int estimatedWeightGain=4;
        int deliveryAdjustment=10;

        isResult = listingInfoPage.fillWeightSummaryDetails(numberOfHeadWeighted, hoursOffFeed, estimatedDressing, estimatedDaysToDelivery, estimatedWeightGain, deliveryAdjustment);
        Utils.logStepInfo(isResult, "Fill Weights Summary details");
        Assert.isTrue(isResult, "Step-1: Failed to fill weights summary details!!");
    }

    @Test
    public void verifyFillingAssessmentOverviewDetails() {
        boolean isResult=false;
        String frame="Small";
        String condition="Prime";
        String agentComment="Test agent comment";
        isResult = listingInfoPage.fillAssessmentOverviewDetails(frame, condition, agentComment);
        Utils.logStepInfo(isResult, "Fill Assessment overview details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Assessment overview details!!");
    }
    @Test
    public void verifyFillingBreedingOverviewDetails() {
        boolean isResult=false;
        String vendorBred="Yes";
        String temperament="Quiet";
        isResult = listingInfoPage.fillBreedingOverviewDetails(vendorBred, temperament);
        Utils.logStepInfo(isResult, "Fill Breeding overview details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Breeding overview details!!");
    }
    @Test
    public void verifyFillingHealthVetDetails() {
        boolean isResult=false;
        String hgpTreated="Yes";
        String withinWithholdingPeriod="Yes";
        isResult = listingInfoPage.addHealthVetDetailsDetails(hgpTreated, withinWithholdingPeriod);
        Utils.logStepInfo(isResult, "Fill Health Vet details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Health Vet details!!");
    }
    @Test
    public void verifyFillingDeliveryDetails() {
        boolean isResult=false;
        isResult = listingInfoPage.fillDeliveryDetails();
        Utils.logStepInfo(isResult, "Fill Delivery details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Delivery details!!");
    }
    @Test
    public void verifyFillingLiveWeightDetails() {
        boolean isResult=false;
        int liveWeight=20;
        String fatScore="Fat score 1 (0-2mm)";
        isResult = listingInfoPage.enterLiveWeightToPopulate(liveWeight, fatScore);
        Utils.logStepInfo(isResult, "Fill Live Weight details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Live Weight details!!");
    }

    @Test
    public void verifyPublishListing() {
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
