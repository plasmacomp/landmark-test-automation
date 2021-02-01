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
        if(listingInfoPage.verifyBidAndOfferListingType()){
            isResult = listingInfoPage.verifyListingTypeSelection(false, "Online", "Diary");
        }
        Utils.logStepInfo(isResult, "Select Bid and Offer listing type option and respective field values");
        Assert.isTrue(isResult, "Step-1: Required option selection for Bid and Offer failed!!");
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
