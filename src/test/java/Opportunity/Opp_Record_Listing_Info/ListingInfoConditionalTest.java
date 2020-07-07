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

public class ListingInfoConditionalTest {
    ListingInfoPage listingInfoPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization(){
        globalVars = TestBase.setup(this.getClass().getSimpleName());
        listingInfoPage=ListingInfoPage.getInstance();
    }

    @Test
    public void verifyBidAndOfferListingTypeSelection() {
        boolean isResult=false;
        String transactionType="";
        String saleType="";
        String[] params=globalVars.getParamsData("verifyBidAndOfferListingTypeSelection");
        try{
            transactionType=params[0];
            saleType=params[1];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        if(listingInfoPage.verifyBidAndOfferListingType()){
            isResult = listingInfoPage.verifyListingTypeSelection(false, transactionType, saleType);
        }
        Utils.logStepInfo(isResult, "Select Bid and Offer listing type option and respective field values");
        Assert.isTrue(isResult, "Step-1: Required option selection for Bid and Offer failed!!");
    }

    @Test
    public void verifyFillingListingOverviewDetailsForSheep() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyFillingListingOverviewDetailsForSheep");
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
        if(listingInfoPage.verifyListingInfoNavigation()){
            isResult = listingInfoPage.fillListingOverviewDetails(biddingDuration, closingSoonStatusDuration, startingPrice, description, reservePrice, town);
        }

        Utils.logStepInfo(isResult, "Fill listing overview details");
        Assert.isTrue(isResult, "Step-1: Failed to fill listing overview details!!");
    }

    @Test
    public void verifyFillingWeightsSummaryDetailsForSheep() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyFillingWeightsSummaryDetailsForSheep");
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
    public void verifyFillingAssessmentOverviewDetailsForSheep() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyFillingAssessmentOverviewDetailsForSheep");
        String agentComment=params[0];

        isResult = listingInfoPage.fillAssessmentOverviewDetailsForSheep(agentComment);
        Utils.logStepInfo(isResult, "Fill Assessment overview details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Assessment overview details!!");
    }
    @Test
    public void verifyFillingLambsAtFootDetailsForSheep() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyFillingLambsAtFootDetailsForSheep");
        String numberOfLambsAtFoot = "",lambsAtFootSiredBy="",ageOfLambs="";
        try{
            numberOfLambsAtFoot=params[0];
            lambsAtFootSiredBy=params[1];
            ageOfLambs=params[2];
        }
        catch (Exception ex){ //It can throw numberFormat as well as ArrayIndexOutOfBounds exceptions
            ex.printStackTrace();
        }

        isResult = listingInfoPage.fillLambsAtFootDetailsForSheep(numberOfLambsAtFoot, lambsAtFootSiredBy, ageOfLambs);
        Utils.logStepInfo(isResult, "Fill and verify Lambs At Foot details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Lambs At Foot details!!");
    }

    @Test
    public void verifyFillingBreedingOverviewDetailsForSheep() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyFillingBreedingOverviewDetailsForSheep");
        String vendorBred="",sheddingBreed="", anyKnownContactWithSheddingBreed="";
        try{
            vendorBred=params[0];
            sheddingBreed=params[1];
            anyKnownContactWithSheddingBreed=params[2];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        isResult = listingInfoPage.fillBreedingOverviewDetailsForSheep(vendorBred, sheddingBreed, anyKnownContactWithSheddingBreed);
        Utils.logStepInfo(isResult, "Fill Breeding overview details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Breeding overview details!!");
    }

    @Test
    public void verifyFillingWoolSkinDetailsForSheep() {
        boolean isResult=false;
        String[] params=globalVars.getParamsData("verifyFillingWoolSkinDetailsForSheep");
        String lastShearingDate="",mulesed="", crutched="", degreeOfBurr="", typeOfBurr="", degreeOfSeed, typeOfSeed, comments;
        try{
            lastShearingDate=params[0];mulesed=params[1];crutched=params[2];degreeOfBurr=params[3];
            typeOfBurr=params[4];degreeOfSeed=params[5];typeOfSeed=params[6];comments=params[7];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        //isResult = listingInfoPage.fillWoolSkinDetailsForSheep(lastShearingDate, mulesed, crutched);
        Utils.logStepInfo(isResult, "Fill Breeding overview details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Breeding overview details!!");
    }

    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }
}
