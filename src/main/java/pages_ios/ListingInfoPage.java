package pages_ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.CommonFunctionsMobile;
import utils.GlobalVars;

import java.util.HashMap;

public class ListingInfoPage {

    private AppiumDriver driver;
    static CommonFunctionsMobile commonFunctions=null;
    private static GlobalVars globalVars;
    private static ListingInfoPage listingInfoPage;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    private static WebElement dropdownPicker;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Done'])[2]")
    private static WebElement doneButtonWheelPicker;
    @iOSXCUITFindBy(accessibility = "Sale Information")
    private static WebElement salesInformationLabel;
    @iOSXCUITFindBy(accessibility = "Vendor Info")
    private static WebElement vendorInfoLabel;
    @iOSXCUITFindBy(accessibility = "Lots")
    private static WebElement lotsLabel;
    @iOSXCUITFindBy(accessibility = "Listing Information")
    private static WebElement listingInformationLabel;
    @iOSXCUITFindBy(accessibility = "Attachments")
    private static WebElement attachmentsLabel;
    @iOSXCUITFindBy(accessibility = "Notes")
    private static WebElement notesLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Bid & Offer'])[2]")
    private static WebElement bidAndOfferLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Classified'])[2]")
    private static WebElement classifiedLabel;
    @iOSXCUITFindBy(xpath = "###################################")
    private static WebElement bidAndOfferRadioButton;
    @iOSXCUITFindBy(xpath = "################################")
    private static WebElement classifiedRadioButton;
    @iOSXCUITFindBy(accessibility = "Transaction Type")
    private static WebElement transactionTypeLabel;
    @iOSXCUITFindBy(accessibility = "Sale Type *")
    private static WebElement saleTypeLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transaction Type ']//preceding-sibling::*")
    private static WebElement transactionTypeDropdown;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sale Type *']//preceding-sibling::*")
    private static WebElement saleTypeDropdown;
    @iOSXCUITFindBy(accessibility = "Classified Listing Status")
    private static WebElement classifiedListingStatusLabel;
    @iOSXCUITFindBy(accessibility = "Available")
    private static WebElement availableLabel;
    @iOSXCUITFindBy(accessibility = "Sold")
    private static WebElement soldLabel;

    //*********Listing info tab locators
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LISTING OVERVIEW']")
    private static WebElement listingOverviewHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Bidding Start Date/Time *")
    private static WebElement biddingStartDateTimeLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[2]")
    private static WebElement biddingStartDateTimeDropdown;
    @iOSXCUITFindBy(accessibility = "Bidding Duration *")
    private static WebElement biddingDurationLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
    private static WebElement biddingDurationDropdown;

    @iOSXCUITFindBy(accessibility = "Closing Soon Status Duration *")
    private static WebElement closingSoonStatusDurationLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[3]")
    private static WebElement closingSoonStatusDurationDropdown;

    @iOSXCUITFindBy(accessibility = "Starting Price (exGST) *")
    private static WebElement startingPriceLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[4]")
    private static WebElement startingPriceTextBox;

    @iOSXCUITFindBy(accessibility = "Description *")
    private static WebElement descriptionLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[1]")
    private static WebElement descriptionTextView;

    @iOSXCUITFindBy(accessibility = "Reserve Price (exGST) *")
    private static WebElement reservePriceLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[5]")
    private static WebElement reservePriceTextBox;

    @iOSXCUITFindBy(accessibility = "Town")
    private static WebElement townLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[6]")
    private static WebElement townTextBoxButton;
    @iOSXCUITFindBy(className = "XCUIElementTypeSearchField")
    private static WebElement townSearchBox;

    //Xpath of search result on town search window: //XCUIElementTypeStaticText[@value="BRISBANE QLD, 9010"]
    //************* Need to search with the place name only, however, for clicking on the search result, need to provide name, region and pin
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LOT DETAILS']")
    private static WebElement lotDetailsHeaderLabel;

    @iOSXCUITFindBy(accessibility = "Pregnancy Status")
    private static WebElement pregnancyStatusLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[8]")
    private static WebElement pregnancyStatusTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='WEIGHTS SUMMARY']")
    private static WebElement weightsSummaryHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Enter liveweight to populate")
    private static WebElement enterLiveWeightToPopulateButton;
    @iOSXCUITFindBy(accessibility = "Number of Head Weighed *")
    private static WebElement numberOfHeadWeighedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[9]")
    private static WebElement numberOfHeadWeighedTextBox;
    @iOSXCUITFindBy(accessibility = "Low kg *")
    private static WebElement lowKgLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[10]")
    private static WebElement lowKgTextBox;
    @iOSXCUITFindBy(accessibility = "Average kg *")
    private static WebElement averageKgLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[11]")
    private static WebElement averageKgTextBox;
    @iOSXCUITFindBy(accessibility = "High kg *")
    private static WebElement highKgLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[12]")
    private static WebElement highKgTextBox;
    @iOSXCUITFindBy(accessibility = "Hours off Feed *")
    private static WebElement hoursOffFeedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[13]")
    private static WebElement hoursOffFeedTextBox;
    @iOSXCUITFindBy(accessibility = "Estimated Dressing % *")
    private static WebElement estimatedDressingLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[14]")
    private static WebElement estimatedDressingTextBox;
    @iOSXCUITFindBy(accessibility = "Estimated Average Dressed Weight at Assessment (kg) *")
    private static WebElement estimatedAverageDressedWeightAtAssessmentLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[15]")
    private static WebElement estimatedAverageDressedWeightAtAssessmentTextBox;
    @iOSXCUITFindBy(accessibility = "Estimated Days to Delivery *")
    private static WebElement estimatedDaysToDeliveryLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[16]")
    private static WebElement estimatedDaysToDeliveryTextBox;
    @iOSXCUITFindBy(accessibility = "Estimated Weight Gain (kg/Day) *")
    private static WebElement estimatedWeightGainLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[17]")
    private static WebElement estimatedWeightGainTextBox;
    @iOSXCUITFindBy(accessibility = "Delivery Adjustment % *")
    private static WebElement deliveryAdjustmentLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[18]")
    private static WebElement deliveryAdjustmentTextBox;

    @iOSXCUITFindBy(accessibility = "Estimated Average Live Weight at Delivery (kg) *")
    private static WebElement estimatedAverageLiveWeightAtDeliveryLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[19]")
    private static WebElement estimatedAverageLiveWeightAtDeliveryTextBox;
    @iOSXCUITFindBy(accessibility = "Estimated Average Dressed Weight at Delivery (kg) *")
    private static WebElement estimatedAverageDressedWeightAtDeliveryLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[20]")
    private static WebElement estimatedAverageDressedWeightAtDeliveryTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='ASSESSMENT OVERVIEW']")
    private static WebElement assessmentOverviewHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Frame")
    private static WebElement frameLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[21]")
    private static WebElement frameTextBox;
    @iOSXCUITFindBy(accessibility = "Condition")
    private static WebElement conditionLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[22]")
    private static WebElement conditionTextBox;
    @iOSXCUITFindBy(accessibility = "Agent Comments *")
    private static WebElement agentCommentsLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[2]")
    private static WebElement agentCommentsTextView;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='ADDITIONAL LOT DETAILS']")
    private static WebElement additionalLotDetailsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Dentition")
    private static WebElement durationLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[23]")
    private static WebElement durationTextBox;
    @iOSXCUITFindBy(accessibility = "Describe Any Worn or Broken Mouths")
    private static WebElement describeAnyWornOrBrokenMouthsLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[3]")
    private static WebElement describeAnyWornOrBrokenMouthsTextView;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='NUMBER OF HEADS MOUTHED']")
    private static WebElement numberOfHeadsMouthedHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Milk")
    private static WebElement milkLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[24]")
    private static WebElement milkTextBox;
    @iOSXCUITFindBy(accessibility = "2T")
    private static WebElement twoTLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[25]")
    private static WebElement twoTTextBox;
    @iOSXCUITFindBy(accessibility = "4T")
    private static WebElement fourTLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[26]")
    private static WebElement fourTTextBox;
    @iOSXCUITFindBy(accessibility = "6T")
    private static WebElement sixTLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[27]")
    private static WebElement sixTTextBox;
    @iOSXCUITFindBy(accessibility = "8T")
    private static WebElement eightTLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[28]")
    private static WebElement eightTTextBox;
    @iOSXCUITFindBy(accessibility = "Worn")
    private static WebElement wornLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[29]")
    private static WebElement wornTextBox;
    @iOSXCUITFindBy(accessibility = "Broken")
    private static WebElement brokenLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[30]")
    private static WebElement brokenTextBox;
    @iOSXCUITFindBy(accessibility = "Total")
    private static WebElement totalLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[31]")
    private static WebElement totalTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='BREEDING OVERVIEW']")
    private static WebElement breedingOverviewHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Vendor Bred *")
    private static WebElement vendorBredLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[32]")
    private static WebElement vendorBredDropdown;
    @iOSXCUITFindBy(accessibility = "Bloodlines")
    private static WebElement bloodLinesLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[33]")
    private static WebElement bloodLinesTextBox;
    @iOSXCUITFindBy(accessibility = "Additional Stock History")
    private static WebElement additionalStockHistoryLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[4]")
    private static WebElement additionalStockHistoryTextBox;
    @iOSXCUITFindBy(accessibility = "Breeding Quality")
    private static WebElement breedingQualityLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[34]")
    private static WebElement breedingQualityDropdown;
    @iOSXCUITFindBy(accessibility = "Horn Status")
    private static WebElement hornStatusLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[35]")
    private static WebElement hornStatusDropdown;
    @iOSXCUITFindBy(accessibility = "Temperament *")
    private static WebElement temperamentLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[36]")
    private static WebElement temperamentDropdown;
    @iOSXCUITFindBy(accessibility = "Temperament in Crush")
    private static WebElement temperamentInCrushLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[37]")
    private static WebElement temperamentInCrushTextBox;
    @iOSXCUITFindBy(accessibility = "Temperament in Yards")
    private static WebElement temperamentInYardsLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[38]")
    private static WebElement temperamentInYardsTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='BREEDING DETAILS']")
    private static WebElement breedingDetailsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Add details")
    private static WebElement addDetailsButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='HEALTH VET DETAILS']")
    private static WebElement healthVetDetailsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "HGP Treated *")
    private static WebElement hgpTreatedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[39]")
    private static WebElement hgpTreatedDropdown;
    @iOSXCUITFindBy(accessibility = "Product")
    private static WebElement productLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[40]")
    private static WebElement productTextBox;
    @iOSXCUITFindBy(accessibility = "Within Withholding Period (WHP) or Export Slaughter Intervals (ESI) *")
    private static WebElement withinWithholdingPeriodOrExportSlaughterIntervalsLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[41]")
    private static WebElement withinWithholdingPeriodOrExportSlaughterIntervalsDropdown;
    @iOSXCUITFindBy(accessibility = "Market Eligibility Details")
    private static WebElement marketEligibilityLabel;
    @iOSXCUITFindBy(accessibility = "PCAS eligible")
    private static WebElement PCASEligibleLabel;
    @iOSXCUITFindBy(accessibility = "Russian eligible")
    private static WebElement russianEligibleLabel;
    @iOSXCUITFindBy(accessibility = "Saudi eligible")
    private static WebElement saudiEligibleLabel;
    @iOSXCUITFindBy(accessibility = "Slaughter only")
    private static WebElement slaughterOnlyLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='TREATMENTS']")
    private static WebElement treatmentsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Dipped")
    private static WebElement dippedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[42]")
    private static WebElement dippedDropdown;
    @iOSXCUITFindBy(accessibility = "Drenched")
    private static WebElement drenchedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[43]")
    private static WebElement drenchedDropdown;
    @iOSXCUITFindBy(accessibility = "Vaccinated")
    private static WebElement vaccinatedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[44]")
    private static WebElement vaccinatedDropdown;
    @iOSXCUITFindBy(accessibility = "Backlined")
    private static WebElement backLinedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[45]")
    private static WebElement backLinedDropdown;
    @iOSXCUITFindBy(accessibility = "Other")
    private static WebElement otherLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[46]")
    private static WebElement otherDropdown;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[1]")
    private static WebElement productsUsedLabel1;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[1]//preceding-sibling::XCUIElementTypeTextView")
    private static WebElement productsUsedTextView1;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[2]")
    private static WebElement productsUsedLabel2;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[2]//preceding-sibling::XCUIElementTypeTextView")
    private static WebElement productsUsedTextView2;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[1]")
    private static WebElement productsUsedLabel3;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[3]//preceding-sibling::XCUIElementTypeTextView")
    private static WebElement productsUsedTextView3;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[4]")
    private static WebElement productsUsedLabel4;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[4]//preceding-sibling::XCUIElementTypeTextView")
    private static WebElement productsUsedTextView4;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='ACCREDITATIONS']")
    private static WebElement accreditationsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "National Cattle Health Declaration Available")
    private static WebElement nationalCattleHealthDeclarationAvailableLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[47]")
    private static WebElement nationalCattleHealthDeclarationAvailableDropdown;
    @iOSXCUITFindBy(accessibility = "JBAS Score")
    private static WebElement JBASScoreLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[48]")
    private static WebElement JBASScoreDropdown;
    @iOSXCUITFindBy(accessibility = "Accreditations")
    private static WebElement accreditationsLabel;
    @iOSXCUITFindBy(accessibility = "EU")
    private static WebElement EULabel;
    @iOSXCUITFindBy(accessibility = "MSA")
    private static WebElement MSALabel;
    @iOSXCUITFindBy(accessibility = "LPA")
    private static WebElement LPALabel;
    @iOSXCUITFindBy(accessibility = "Organic")
    private static WebElement organicLabel;
    @iOSXCUITFindBy(accessibility = "PCAS")
    private static WebElement PCASLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='SPECIAL CONDITIONS']")
    private static WebElement specialConditionsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Special Conditions")
    private static WebElement specialConditionsLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Special Conditions ']//preceding-sibling::XCUIElementTypeTextView")
    private static WebElement specialConditionsTextView;
    @iOSXCUITFindBy(accessibility = "Movement Restrictions")
    private static WebElement movementRestrictionsLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Movement Restrictions ']//preceding-sibling::XCUIElementTypeTextField")
    private static WebElement movementRestrictionTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='DELIVERY DETAILS']")
    private static WebElement deliveryDetailsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Forward Supply")
    private static WebElement forwardSupplyLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Forward Supply ']//preceding-sibling::XCUIElementTypeTextField")
    private static WebElement forwardSupplyTextBox;
    @iOSXCUITFindBy(accessibility = "Estimated Final Delivery Date *")
    private static WebElement estimatedFinalDeliveryDateLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Estimated Final Delivery Date *']//preceding-sibling::XCUIElementTypeTextField")
    private static WebElement estimatedFinalDeliveryDateTextBox;
    @iOSXCUITFindBy(accessibility = "Comments")
    private static WebElement commentsLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Comments ']//preceding-sibling::XCUIElementTypeTextView")
    private static WebElement commentsTextView;
    @iOSXCUITFindBy(accessibility = "Weighing Instructions")
    private static WebElement weighingInstructionsLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Weighing Instructions ']//preceding-sibling::XCUIElementTypeTextView")
    private static WebElement weighingInstructionsTextView;






    public ListingInfoPage() {
        globalVars=GlobalVars.getInstance();
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctionsMobile.getInstance();
    }
    public static ListingInfoPage getInstance(){
        if(listingInfoPage ==null){
            listingInfoPage =new ListingInfoPage();
        }
        return listingInfoPage;
    }


    public boolean verifySalesInformationLabel() {
        return commonFunctions.isElementDisplayed(salesInformationLabel, 15);
    }

    public boolean verifyVendorInfoLabel() {
        return commonFunctions.isElementDisplayed(vendorInfoLabel, 15);
    }


    public boolean verifyLotsLabel() {
        return commonFunctions.isElementDisplayed(lotsLabel, 15);
    }


    public boolean verifyNotesLabel() {
        return commonFunctions.isElementDisplayed(notesLabel, 15);
    }


    public boolean verifyAttachmentsLabel() {
        return commonFunctions.isElementDisplayed(attachmentsLabel, 15);
    }

    public boolean verifyListingTypeOptions() {
        return commonFunctions.isElementDisplayed(bidAndOfferLabel, 30) && commonFunctions.isElementDisplayed(classifiedLabel, 30);
    }
    public boolean verifyClassifiedListingType() {
        Point point=classifiedLabel.getLocation();
        int x=point.x-8;
        int y=point.y;
        commonFunctions.clickElementByCoordinates(x, y);
//        return commonFunctions.isElementDisplayed(classifiedListingStatusLabel, 8) && commonFunctions.isElementDisplayed(availableLabel, 8)
//                && commonFunctions.isElementDisplayed(soldLabel, 8);
        return true;
    }
    public boolean verifyBidAndOfferListingType() {
        Point point=bidAndOfferLabel.getLocation();
        int x=point.x-8;
        int y=point.y;
        commonFunctions.clickElementByCoordinates(x, y);
//        return commonFunctions.isElementDisplayed(transactionTypeLabel, 8) && commonFunctions.isElementDisplayed(transactionTypeDropdown, 8)
//                && commonFunctions.isElementDisplayed(saleTypeLabel, 8) && commonFunctions.isElementDisplayed(saleTypeDropdown, 8);
        return true;
    }

    public boolean verifyListingTypeSelection(boolean isClassifiedTrue, String transactionType, String saleType) {
        boolean isResult=false;
        if(isClassifiedTrue){
            Point point=classifiedLabel.getLocation();
            int x=point.x-8;
            int y=point.y;
            commonFunctions.clickElementByCoordinates(x, y);
            Point point1=availableLabel.getLocation();
            int x1=point1.x-8;
            int y1=point1.y;
            commonFunctions.clickElementByCoordinates(x1, y1);
            isResult=commonFunctions.isElementDisplayed(availableLabel, 10);

        }
        else{
            commonFunctions.clickElement(transactionTypeDropdown);
            movePickerWheel(transactionTypeDropdown, transactionType);
            commonFunctions.clickElement(saleTypeDropdown);
            movePickerWheel(saleTypeDropdown, saleType);
            commonFunctions.clickElement(doneButtonWheelPicker, 10);
            isResult=commonFunctions.getElementText(saleTypeDropdown, 10).trim().equalsIgnoreCase(saleType);
        }
        return isResult;
    }

    private void movePickerWheel(WebElement element, String val){
        for(int i=0; i<10; i++) {
            String pickerValue=commonFunctions.getElementText(element, 10);
            if(pickerValue.trim().contains(val)) {
                break;
            }
            else{
                commonFunctions.clickElement(element);
                pickerWheelStep(dropdownPicker, "next", 0.15);
            }
        }
    }

    private void pickerWheelStep(WebElement element, String direction, double offset) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("order", direction);
        params.put("offset", offset);
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: selectPickerWheelValue", params);
    }
    public boolean verifyListingInfoNavigation() {
        commonFunctions.clickElement(listingInformationLabel);
        return commonFunctions.isElementDisplayed(listingOverviewHeaderLabel, 25);
    }
    public boolean fillListingOverviewDetails(String biddingDuration, String closingSoonStatusDuration, String startingPrice, String description, String reservePrice, String town) {
        String townText="";
        commonFunctions.clickElement(biddingStartDateTimeDropdown);
        commonFunctions.clickElement(doneButtonWheelPicker);
        movePickerWheel(biddingDurationDropdown, biddingDuration);
        movePickerWheel(closingSoonStatusDurationDropdown, closingSoonStatusDuration);
        commonFunctions.sendKey(startingPriceTextBox, startingPrice);
        commonFunctions.sendKey(descriptionTextView, description);
        commonFunctions.sendKey(reservePriceTextBox, reservePrice);
        commonFunctions.clickElement(townTextBoxButton);
        commonFunctions.sendKey(townSearchBox, town);
        townText=commonFunctions.getElementText(townTextBoxButton, 10).trim();
        return town.contains(townText);
    }
    public boolean fillLotDetails(String pregStatus) {
        commonFunctions.sendKey(pregnancyStatusTextBox, pregStatus);
        return commonFunctions.getElementText(pregnancyStatusTextBox, 10).trim().equalsIgnoreCase(pregStatus);
    }
    public boolean enterLiveWeightToPopulate() {
        commonFunctions.clickElement(enterLiveWeightToPopulateButton);
        return true;
    }
    public boolean fillWeightSummaryDetails(int numberOfHeadWeighted, int hoursOffFeed, int estimatedDressing, int estimatedDaysToDelivery, int estimatedWeightGain, int deliveryAdjustment) {
        commonFunctions.scrollDownToElement(highKgLabel);
        commonFunctions.sendKey(numberOfHeadWeighedTextBox, numberOfHeadWeighted+"");
        commonFunctions.scrollDownToElement(estimatedDaysToDeliveryLabel);
        commonFunctions.sendKey(hoursOffFeedTextBox, hoursOffFeed+"");
        commonFunctions.sendKey(estimatedDressingTextBox, estimatedDressing+"");
        commonFunctions.sendKey(estimatedDaysToDeliveryTextBox, estimatedDaysToDelivery+"");
        commonFunctions.sendKey(estimatedWeightGainTextBox, estimatedWeightGain+"");
        commonFunctions.sendKey(deliveryAdjustmentTextBox, deliveryAdjustment+"");
        return !commonFunctions.getElementText(deliveryAdjustmentTextBox, 10).isEmpty();
    }
    public boolean fillAssessmentOverviewDetails(String frame, String condition, String agentComments) {
        commonFunctions.scrollDownToElement(agentCommentsLabel);
        commonFunctions.clickElement(frameTextBox);
        movePickerWheel(frameTextBox, frame);
        commonFunctions.clickElement(conditionTextBox);
        movePickerWheel(conditionTextBox, condition);
        commonFunctions.sendKey(agentCommentsTextView, agentComments);
        return !commonFunctions.getElementText(agentCommentsTextView, 10).isEmpty();
    }
    public boolean fillAdditionalLotDetails() {
        return false;
    }
    public boolean fillNumberOfHeadsMouthedDetails() {
        return false;
    }
    public boolean fillBreedingOverviewDetails(String vendorBred, String temprament) {
        commonFunctions.scrollDownToElement(additionalStockHistoryLabel);
        commonFunctions.clickElement(vendorBredDropdown);
        movePickerWheel(vendorBredDropdown, vendorBred);
        commonFunctions.clickElement(temperamentDropdown);
        movePickerWheel(temperamentDropdown, temprament);
        return !commonFunctions.getElementText(temperamentDropdown, 10).isEmpty();
    }
    public boolean addBreedingDetailsDetails() {
        return false;
    }
    public boolean addHealthVetDetailsDetails(String hgpTreated, String withinWithholdingPeriod) {
        commonFunctions.scrollDownToElement(withinWithholdingPeriodOrExportSlaughterIntervalsLabel);
        commonFunctions.clickElement(hgpTreatedDropdown);
        movePickerWheel(hgpTreatedDropdown, hgpTreated);
        commonFunctions.clickElement(withinWithholdingPeriodOrExportSlaughterIntervalsDropdown);
        movePickerWheel(withinWithholdingPeriodOrExportSlaughterIntervalsDropdown, withinWithholdingPeriod);
        return !commonFunctions.getElementText(withinWithholdingPeriodOrExportSlaughterIntervalsDropdown, 10).isEmpty();
    }
    public boolean fillTreatmentDetails() {
        return false;
    }
    public boolean fillAccreditationDetails() {
        return false;
    }
    public boolean fillSpecialConditionsDetails() {
        return false;
    }
    public boolean fillDeliveryDetails() {
        commonFunctions.scrollDownToElement(weighingInstructionsLabel);
        commonFunctions.clickElement(estimatedFinalDeliveryDateTextBox);
        commonFunctions.clickElement(doneButtonWheelPicker);
        return !commonFunctions.getElementText(estimatedFinalDeliveryDateTextBox, 10).isEmpty();
    }

}
