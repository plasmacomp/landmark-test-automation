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


public class ListingInfoSheepClassified {
    ListingInfoPage listingInfoPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization(){
        globalVars = TestBase.setup(this.getClass().getSimpleName());
        listingInfoPage=ListingInfoPage.getInstance();
    }

    @Test
    public void verifyListingTypeSelectionClassifiedSheep() {
        boolean isResult;
        isResult = listingInfoPage.verifyListingTypeSelection(true, "", "");
        Utils.logStepInfo(isResult, "Select Classified listing type option given as parameter");
        Assert.isTrue(isResult, "Step-1: Classified listing listing type selection failed!!");
    }
    @Test
    public void verifyListingInfoNavigationClassifiedSheep() {
        boolean isResult;
        isResult = listingInfoPage.verifyListingInfoNavigation();
        Utils.logStepInfo(isResult, "Click on the listing info tab to navigate to listing info page");
        Assert.isTrue(isResult, "Step-1: Failed to navigate to listing info page!!");
    }

    @Test
    public void verifyFillingClassifiedListingOverviewDetailsSheep() {
        boolean isResult;
        String classifiedDuration="", price="", description="", town="";
        String[] params=globalVars.getParamsData("verifyFillingClassifiedListingOverviewDetailsSheep");
        try{
            classifiedDuration=params[0];
            price=params[1];
            description=params[2];
            town=params[3];
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        isResult = listingInfoPage.fillClassifiedListingOverviewDetailsForSheep(classifiedDuration, price, description, town);
        Utils.logStepInfo(isResult, "Fill listing overview details");
        Assert.isTrue(isResult, "Step-1: Failed to fill listing overview details!!");
    }

    @Test
    public void verifyFillingClassifiedLotDetailsSheep() {
        boolean isResult=false;
        String hornStatus="";
        int weightRangeLow=0;
        int weightRangeHigh=0;
        String[] params=globalVars.getParamsData("verifyFillingClassifiedLotDetailsSheep");
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
    public void verifyFillingClassifiedHealthVetDetailsSheep() {
        boolean isResult;
        String sheepAreFreeOfFootrot="Yes";
        String sheepHaveNoHistoryOfFootrot="Yes";
        String sheepAreFreeOfLice="Yes";
        String withinWithHoldingPeriod="No";

        isResult = listingInfoPage.fillHealthVetDetailsForSheep(sheepAreFreeOfFootrot, sheepHaveNoHistoryOfFootrot, sheepAreFreeOfLice, withinWithHoldingPeriod);

        Utils.logStepInfo(isResult, "Fill Health Vet details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Health Vet details!!");
    }

    @Test
    public void verifyFillingClassifiedAccreditationDetailsForSheep() {
        boolean isResult;
        String bioSecurityPlanAvailable="No";
        String approvedOJDVaccines="No";
        isResult = listingInfoPage.fillAccreditationDetails(bioSecurityPlanAvailable, approvedOJDVaccines);
        Utils.logStepInfo(isResult, "Fill Accreditation details");
        Assert.isTrue(isResult, "Step-1: Failed to fill Accreditation details!!");
    }

    @Test
    public void verifyClassifiedPublishListingSheep() {
        boolean isResult;
        isResult = listingInfoPage.publishListing();
        Utils.logStepInfo(isResult, "Click on publish listing to publish the opportunity");
        Assert.isTrue(isResult, "Step-1: Failed to publish listing!!");
    }

    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }
}
