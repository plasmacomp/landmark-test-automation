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
        String transactionType="";
        String saleType="";
        String[] params=globalVars.getParamsData("verifyListingTypeSelection");
        try{
            transactionType=params[0];
            saleType=params[1];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
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
        String[] params=globalVars.getParamsData("verifyFillingListingOverviewDetails");
        String biddingDuration = "",closingSoonStatusDuration="",startingPrice="",description="",reservePrice="",town="";
        try{
            biddingDuration=params[0];
            closingSoonStatusDuration=params[1];
            startingPrice=params[2];
            description=params[3];
            reservePrice=params[4];
            town=params[5];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }

        isResult = listingInfoPage.fillListingOverviewDetails(biddingDuration, closingSoonStatusDuration, startingPrice, description, reservePrice, town);
        Utils.logStepInfo(isResult, "Fill listing overview details");
        Assert.isTrue(isResult, "Step-1: Failed to fill listing overview details!!");
    }
    @Test
    public void verifyFillingWeightsSummaryDetails() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyFillingWeightsSummaryDetails");
        int numberOfHeadWeighted = 0,hoursOffFeed=0,estimatedDressing=0,estimatedDaysToDelivery=0,estimatedWeightGain=0,deliveryAdjustment=0;
        try{
            numberOfHeadWeighted=Integer.parseInt(params[0]);
            hoursOffFeed=Integer.parseInt(params[1]);
            estimatedDressing=Integer.parseInt(params[2]);
            estimatedDaysToDelivery=Integer.parseInt(params[3]);
            estimatedWeightGain=Integer.parseInt(params[4]);
            deliveryAdjustment=Integer.parseInt(params[5]);
        }
        catch (Exception ex){ //It can throw numberFormat as well as ArrayIndexOutOfBounds exceptions
            ex.printStackTrace();
        }

        isResult = listingInfoPage.fillWeightSummaryDetails(numberOfHeadWeighted, hoursOffFeed, estimatedDressing, estimatedDaysToDelivery, estimatedWeightGain, deliveryAdjustment);
        Utils.logStepInfo(isResult, "Fill Weights Summary details");
        Assert.isTrue(isResult, "Step-1: Failed to fill weights summary details!!");
    }

    @Test
    public void verifyFillingAssessmentOverviewDetails() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyFillingAssessmentOverviewDetails");
        String frame="",condition="", agentComment="";
        try{
            frame=params[0];
            condition=params[1];
            agentComment=params[2];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        isResult = listingInfoPage.fillAssessmentOverviewDetails(frame, condition, agentComment);
        Utils.logStepInfo(isResult, "Fill Assessment overview details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Assessment overview details!!");
    }
    @Test
    public void verifyFillingBreedingOverviewDetails() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyFillingBreedingOverviewDetails");
        String vendorBred="",temperament="";
        try{
            vendorBred=params[0];
            temperament=params[1];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        isResult = listingInfoPage.fillBreedingOverviewDetails(vendorBred, temperament);
        Utils.logStepInfo(isResult, "Fill Breeding overview details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Breeding overview details!!");
    }
    @Test
    public void verifyFillingHealthVetDetails() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyFillingHealthVetDetails");
        String hgpTreated="",withinWithholdingPeriod="";
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
    public void verifyFillingDeliveryDetails() {
        boolean isResult=false;
        isResult = listingInfoPage.fillDeliveryDetails();
        Utils.logStepInfo(isResult, "Fill Delivery details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Delivery details!!");
    }
    @Test
    public void verifyFillingLiveWeightDetails() {
        boolean isResult=false;
        int liveWeight=0;
        String fatScore="";
        String[] params=globalVars.getParamsData("verifyFillingLiveWeightDetails");
        try{
            liveWeight=Integer.parseInt(params[0]);
            fatScore=params[1];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
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
