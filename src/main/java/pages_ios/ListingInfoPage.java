package pages_ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctionsMobile;
import utils.GlobalVars;

import java.util.HashMap;

public class ListingInfoPage {

    private AppiumDriver driver;
    static CommonFunctionsMobile commonFunctions=null;
    private static GlobalVars globalVars;
    private static ListingInfoPage listingInfoPage;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    private static IOSElement dropdownPicker;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Done'])[2]")
    private static IOSElement doneButtonWheelPicker;
    @iOSXCUITFindBy(accessibility = "Sale Information")
    private static IOSElement salesInformationLabel;
    @iOSXCUITFindBy(accessibility = "Vendor Info")
    private static IOSElement vendorInfoLabel;
    @iOSXCUITFindBy(accessibility = "Lots")
    private static IOSElement lotsLabel;
    @iOSXCUITFindBy(accessibility = "Listing Information")
    private static IOSElement listingInformationLabel;
    @iOSXCUITFindBy(accessibility = "Attachments")
    private static IOSElement attachmentsLabel;
    @iOSXCUITFindBy(accessibility = "Notes")
    private static IOSElement notesLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Bid & Offer'])[2]")
    private static IOSElement bidAndOfferLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Classified'])[2]")
    private static IOSElement classifiedLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmololistingtype-Bid & Offer")
    private static IOSElement bidAndOfferRadioButton;
    @iOSXCUITFindBy(accessibility = "lmkopesdmololistingtype-Classified")
    private static IOSElement classifiedRadioButton;
    @iOSXCUITFindBy(accessibility = "Transaction Type")
    private static IOSElement transactionTypeLabel;
    @iOSXCUITFindBy(accessibility = "Sale Type *")
    private static IOSElement saleTypeLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transaction Type ']//preceding-sibling::*")
    private static IOSElement transactionTypeDropdown;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sale Type *']//preceding-sibling::*")
    private static IOSElement saleTypeDropdown;
    @iOSXCUITFindBy(accessibility = "Classified Listing Status")
    private static IOSElement classifiedListingStatusLabel;
    @iOSXCUITFindBy(accessibility = "Available")
    private static IOSElement availableLabel;
    @iOSXCUITFindBy(accessibility = "Sold")
    private static IOSElement soldLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmolistingstatus-Available")
    private static IOSElement availableRadioButton;
    @iOSXCUITFindBy(accessibility = "lmkopesdmolistingstatus-Sold")
    private static IOSElement soldRadioButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='elipsis'])[1]")
    private static IOSElement firstEllipsisLotsPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='elipsis'])[2]")
    private static IOSElement secondEllipsisLotsPage;
    @iOSXCUITFindBy(accessibility = "Edit Lot")
    private static IOSElement editLinkLotsPagePopup;
    @iOSXCUITFindBy(accessibility = "Delete Lot")
    private static IOSElement deleteLinkLotsPagePopup;

    //*********Listing info tab locators
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LISTING OVERVIEW']")
    private static IOSElement listingOverviewHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Bidding Start Date/Time *")
    private static IOSElement biddingStartDateTimeLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[2]")
    private static IOSElement biddingStartDateTimeDropdown;
    @iOSXCUITFindBy(accessibility = "Bidding Duration *")
    private static IOSElement biddingDurationLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
    private static IOSElement biddingDurationDropdown;

    @iOSXCUITFindBy(accessibility = "Closing Soon Status Duration *")
    private static IOSElement closingSoonStatusDurationLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[3]")
    private static IOSElement closingSoonStatusDurationDropdown;

    @iOSXCUITFindBy(accessibility = "Starting Price (exGST) *")
    private static IOSElement startingPriceLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[4]")
    private static IOSElement startingPriceTextBox;

    @iOSXCUITFindBy(accessibility = "Description *")
    private static IOSElement descriptionLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmolistingdesc") //(//XCUIElementTypeTextView)[1]
    private static IOSElement descriptionTextView;

    @iOSXCUITFindBy(accessibility = "Reserve Price (exGST) *")
    private static IOSElement reservePriceLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[5]")
    private static IOSElement reservePriceTextBox;

    @iOSXCUITFindBy(accessibility = "Town")
    private static IOSElement townLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmotown-town-btn") //(//XCUIElementTypeButton)[6]
    private static IOSElement townTextBoxButton;
    @iOSXCUITFindBy(className = "XCUIElementTypeSearchField")
    private static IOSElement townSearchBox;
    @iOSXCUITFindBy(accessibility = "lmkopesdmotown-post-btn")
    private static IOSElement postCodeTextField;

    //Xpath of search result on town search window: //XCUIElementTypeStaticText[@value="BRISBANE QLD, 9010"]
    //************* Need to search with the place name only, however, for clicking on the search result, need to provide name, region and pin
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LOT DETAILS']")
    private static IOSElement lotDetailsHeaderLabel;

    @iOSXCUITFindBy(accessibility = "Pregnancy Status")
    private static IOSElement pregnancyStatusLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[8]")
    private static IOSElement pregnancyStatusTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='WEIGHTS SUMMARY']")
    private static IOSElement weightsSummaryHeaderLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Enter liveweight to populate']") //Enter liveweight to populate
    private static IOSElement enterLiveWeightToPopulateButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Liveweight (kg)'])[1]")
    private static IOSElement liveWeightKgLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]") //(//XCUIElementTypeStaticText[@name='Liveweight (kg)'])[1]//following-sibling::XCUIElementTypeTextField
    private static IOSElement liveWeightKgTextField;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Number of Head'])[1]")
    private static IOSElement numberOfHeadLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[2]")
    private static IOSElement numberOfHeadTextField;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Fat Score'])[1]")
    private static IOSElement fatScoreLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[3]") //(//XCUIElementTypeStaticText[@name='Fat Score'])[1]//following-sibling::XCUIElementTypeTextField
    private static IOSElement fatScoreTextField;
    @iOSXCUITFindBy(accessibility = "add 1")
    private static IOSElement plusIcon;

    @iOSXCUITFindBy(accessibility = "Number of Head Weighed *")
    private static IOSElement numberOfHeadWeighedLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesnumfheadsweighed") ////XCUIElementTypeStaticText[@name='Number of Head Weighed *']//preceding-sibling::XCUIElementTypeTextField
    private static IOSElement numberOfHeadWeighedTextBox;
    @iOSXCUITFindBy(accessibility = "High kg *")
    private static IOSElement highKgLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmoweightshighkg") //(//XCUIElementTypeTextField)[12]
    private static IOSElement highKgTextBox;
    @iOSXCUITFindBy(accessibility = "Low kg *") //(//XCUIElementTypeTextField)[12]
    private static IOSElement lowKgLabel;
    @iOSXCUITFindBy(xpath = "lmkopesdmoweightslowkg")
    private static IOSElement lowKgTextBox;
    @iOSXCUITFindBy(accessibility = "Average kg *") //(//XCUIElementTypeTextField)[12]
    private static IOSElement averageKgLabel;
    @iOSXCUITFindBy(xpath = "lmkopesdmoaveragekg")
    private static IOSElement averageKgTextField;

    @iOSXCUITFindBy(accessibility = "Hours off Feed *")
    private static IOSElement hoursOffFeedLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmohoursofffeed") //XCUIElementTypeStaticText[@name='Hours off Feed *']//preceding-sibling::XCUIElementTypeTextField
    private static IOSElement hoursOffFeedTextBox;
    @iOSXCUITFindBy(accessibility = "Estimated Dressing % *")
    private static IOSElement estimatedDressingLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmodressing") //XCUIElementTypeStaticText[@name='Estimated Dressing % *']//preceding-sibling::XCUIElementTypeTextField
    private static IOSElement estimatedDressingTextBox;
    @iOSXCUITFindBy(accessibility = "Estimated Average Dressed Weight at Assessment (kg) *")
    private static IOSElement estimatedAverageDressedWeightAtAssessmentLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesestavgdrssdwght") //(//XCUIElementTypeTextField)[15]
    private static IOSElement estimatedAverageDressedWeightAtAssessmentTextBox;
    @iOSXCUITFindBy(accessibility = "Estimated Days to Delivery *")
    private static IOSElement estimatedDaysToDeliveryLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmoestdaystodlvry") //XCUIElementTypeStaticText[@name='Estimated Days to Delivery *']//preceding-sibling::XCUIElementTypeTextField
    private static IOSElement estimatedDaysToDeliveryTextBox;
    @iOSXCUITFindBy(accessibility = "Estimated Weight Gain (kg/Day) *")
    private static IOSElement estimatedWeightGainLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmoestweightgain") //XCUIElementTypeStaticText[@name='Estimated Weight Gain (kg/Day) *']//preceding-sibling::XCUIElementTypeTextField
    private static IOSElement estimatedWeightGainTextBox;
    @iOSXCUITFindBy(accessibility = "Delivery Adjustment % *")
    private static IOSElement deliveryAdjustmentLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdeladjustpercent") //XCUIElementTypeStaticText[@name='Delivery Adjustment % *']//preceding-sibling::XCUIElementTypeTextField
    private static IOSElement deliveryAdjustmentTextBox;

    @iOSXCUITFindBy(accessibility = "Estimated Average Live Weight at Delivery (kg) *")
    private static IOSElement estimatedAverageLiveWeightAtDeliveryLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesestavglivedelwght") //(//XCUIElementTypeTextField)[19]
    private static IOSElement estimatedAverageLiveWeightAtDeliveryTextBox;
    @iOSXCUITFindBy(accessibility = "Estimated Average Dressed Weight at Delivery (kg) *")
    private static IOSElement estimatedAverageDressedWeightAtDeliveryLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesestavgdrssdelwght") //(//XCUIElementTypeTextField)[20]
    private static IOSElement estimatedAverageDressedWeightAtDeliveryTextBox;
    @iOSXCUITFindBy(accessibility = "Shedding Breed *")
    private static IOSElement sheddingBreedLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmoshddngbreed")
    private static IOSElement sheddingBreedDropDown;
    @iOSXCUITFindBy(accessibility = "Any Known Contact With Shedding Breeds? *")
    private static IOSElement anyKnownContactWithSheddingBreedsLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesanyknowncontct")
    private static IOSElement anyKnownContactWithSheddingBreedsDropDown;
    @iOSXCUITFindBy(accessibility = "Last Shearing Date *")
    private static IOSElement lastShearingDateLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmolastsheardate")
    private static IOSElement lastShearingDateDropDown;
    @iOSXCUITFindBy(accessibility = "Approximate Wool Cut (kg/head)")
    private static IOSElement approximateWoolCutLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmoapproxwoolcut")
    private static IOSElement approximateWoolCutTextField;
    @iOSXCUITFindBy(accessibility = "Mulesed *")
    private static IOSElement mulesedLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmomulesed")
    private static IOSElement mulesedDropDown;
    @iOSXCUITFindBy(accessibility = "Crutched *")
    private static IOSElement crutchedLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmocrutched")
    private static IOSElement crutchedDropDown;
    @iOSXCUITFindBy(accessibility = "lmkopesdmodegreeofburr")
    private static IOSElement degreeOfBurrDropDown;
    @iOSXCUITFindBy(accessibility = "lmkopesdmotypeofburr")
    private static IOSElement typeOfBurrTextField;
    @iOSXCUITFindBy(accessibility = "lmkopesdmodegreeofseed")
    private static IOSElement degreeOfSeedDropDown;
    @iOSXCUITFindBy(accessibility = "lmkopesdmotypeofseed")
    private static IOSElement typeOfSeedTextField;
    @iOSXCUITFindBy(accessibility = "lmkopesgenwoolskincomm")
    private static IOSElement generalWoolCommentsTextField;
    @iOSXCUITFindBy(accessibility = "lmkopesdmoshjoiningstats")
    private static IOSElement joiningStatusDropDown;
    @iOSXCUITFindBy(accessibility = "lmkopesdmoshlotnohpg")
    private static IOSElement numberOfHeadScannedInLambTextField;
    @iOSXCUITFindBy(accessibility = "lmkopesflockfreevfootrot")
    private static IOSElement sheepAreFreeOfFootrotDropDown;
    @iOSXCUITFindBy(accessibility = "lmkopesflockfreebfootrot")
    private static IOSElement sheepHaveNoHistoryOfFootrotDropDown;
    @iOSXCUITFindBy(accessibility = "lmkopessheeplicefreeflck")
    private static IOSElement sheepAreFreeOfLicetDropDown;
    @iOSXCUITFindBy(accessibility = "lmkopeswthwithholdgprd")
    private static IOSElement withinWithHoldingPeriodDropDown;
    @iOSXCUITFindBy(accessibility = "lmkopesbioseplanavail")
    private static IOSElement bioSecurityPlanAvailableDropDown;
    @iOSXCUITFindBy(accessibility = "lmkopesapprvdojdvaccnts")
    private static IOSElement approvedOJDVaccineDropDown;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='ASSESSMENT OVERVIEW']")
    private static IOSElement assessmentOverviewHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Frame")
    private static IOSElement frameLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Frame ']//preceding-sibling::XCUIElementTypeTextField")
    private static IOSElement frameTextBox;
    @iOSXCUITFindBy(accessibility = "Condition")
    private static IOSElement conditionLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Condition ']//preceding-sibling::XCUIElementTypeTextField")
    private static IOSElement conditionTextBox;
    @iOSXCUITFindBy(accessibility = "Agent Comments *")
    private static IOSElement agentCommentsLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Agent Comments *']//preceding-sibling::XCUIElementTypeTextView")
    private static IOSElement agentCommentsTextView;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='ADDITIONAL LOT DETAILS']")
    private static IOSElement additionalLotDetailsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Dentition")
    private static IOSElement durationLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[23]")
    private static IOSElement durationTextBox;
    @iOSXCUITFindBy(accessibility = "Describe Any Worn or Broken Mouths")
    private static IOSElement describeAnyWornOrBrokenMouthsLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[3]")
    private static IOSElement describeAnyWornOrBrokenMouthsTextView;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='NUMBER OF HEADS MOUTHED']")
    private static IOSElement numberOfHeadsMouthedHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Milk")
    private static IOSElement milkLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[24]")
    private static IOSElement milkTextBox;
    @iOSXCUITFindBy(accessibility = "2T")
    private static IOSElement twoTLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[25]")
    private static IOSElement twoTTextBox;
    @iOSXCUITFindBy(accessibility = "4T")
    private static IOSElement fourTLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[26]")
    private static IOSElement fourTTextBox;
    @iOSXCUITFindBy(accessibility = "6T")
    private static IOSElement sixTLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[27]")
    private static IOSElement sixTTextBox;
    @iOSXCUITFindBy(accessibility = "8T")
    private static IOSElement eightTLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[28]")
    private static IOSElement eightTTextBox;
    @iOSXCUITFindBy(accessibility = "Worn")
    private static IOSElement wornLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[29]")
    private static IOSElement wornTextBox;
    @iOSXCUITFindBy(accessibility = "Broken")
    private static IOSElement brokenLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[30]")
    private static IOSElement brokenTextBox;
    @iOSXCUITFindBy(accessibility = "Total")
    private static IOSElement totalLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[31]")
    private static IOSElement totalTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='BREEDING OVERVIEW']")
    private static IOSElement breedingOverviewHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Vendor Bred *")
    private static IOSElement vendorBredLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Vendor Bred *']//preceding-sibling::XCUIElementTypeTextField")
    private static IOSElement vendorBredDropdown;
    @iOSXCUITFindBy(accessibility = "Bloodlines")
    private static IOSElement bloodLinesLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[33]")
    private static IOSElement bloodLinesTextBox;
    @iOSXCUITFindBy(accessibility = "Additional Stock History")
    private static IOSElement additionalStockHistoryLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[4]")
    private static IOSElement additionalStockHistoryTextBox;
    @iOSXCUITFindBy(accessibility = "Breeding Quality")
    private static IOSElement breedingQualityLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[34]")
    private static IOSElement breedingQualityDropdown;
    @iOSXCUITFindBy(accessibility = "Horn Status")
    private static IOSElement hornStatusLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmoshhornstatus") ////XCUIElementTypeStaticText[@name='Horn Status *']//preceding-sibling::XCUIElementTypeTextField
    private static IOSElement hornStatusDropdown;
    @iOSXCUITFindBy(accessibility = "Temperament *")
    private static IOSElement temperamentLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Temperament *']//preceding-sibling::XCUIElementTypeTextField")
    private static IOSElement temperamentDropdown;
    @iOSXCUITFindBy(accessibility = "Temperament in Crush")
    private static IOSElement temperamentInCrushLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[37]")
    private static IOSElement temperamentInCrushTextBox;
    @iOSXCUITFindBy(accessibility = "Temperament in Yards")
    private static IOSElement temperamentInYardsLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[38]")
    private static IOSElement temperamentInYardsTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='BREEDING DETAILS']")
    private static IOSElement breedingDetailsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Add details")
    private static IOSElement addDetailsButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='HEALTH VET DETAILS']")
    private static IOSElement healthVetDetailsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "HGP Treated *")
    private static IOSElement hgpTreatedLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='HGP Treated *']//following-sibling::XCUIElementTypeTextField")
    private static IOSElement hgpTreatedDropdown;
    @iOSXCUITFindBy(accessibility = "Product")
    private static IOSElement productLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[40]")
    private static IOSElement productTextBox;
    @iOSXCUITFindBy(accessibility = "Within Withholding Period (WHP) or Export Slaughter Intervals (ESI) *")
    private static IOSElement withinWithholdingPeriodOrExportSlaughterIntervalsLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Within Withholding Period (WHP) or Export Slaughter Intervals (ESI) *']//preceding-sibling::XCUIElementTypeTextField")
    private static IOSElement withinWithholdingPeriodOrExportSlaughterIntervalsDropdown;
    @iOSXCUITFindBy(accessibility = "Market Eligibility Details")
    private static IOSElement marketEligibilityLabel;
    @iOSXCUITFindBy(accessibility = "PCAS eligible")
    private static IOSElement PCASEligibleLabel;
    @iOSXCUITFindBy(accessibility = "Russian eligible")
    private static IOSElement russianEligibleLabel;
    @iOSXCUITFindBy(accessibility = "Saudi eligible")
    private static IOSElement saudiEligibleLabel;
    @iOSXCUITFindBy(accessibility = "Slaughter only")
    private static IOSElement slaughterOnlyLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='TREATMENTS']")
    private static IOSElement treatmentsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Dipped")
    private static IOSElement dippedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[42]")
    private static IOSElement dippedDropdown;
    @iOSXCUITFindBy(accessibility = "Drenched")
    private static IOSElement drenchedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[43]")
    private static IOSElement drenchedDropdown;
    @iOSXCUITFindBy(accessibility = "Vaccinated")
    private static IOSElement vaccinatedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[44]")
    private static IOSElement vaccinatedDropdown;
    @iOSXCUITFindBy(accessibility = "Backlined")
    private static IOSElement backLinedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[45]")
    private static IOSElement backLinedDropdown;
    @iOSXCUITFindBy(accessibility = "Other")
    private static IOSElement otherLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[46]")
    private static IOSElement otherDropdown;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[1]")
    private static IOSElement productsUsedLabel1;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[1]//preceding-sibling::XCUIElementTypeTextView")
    private static IOSElement productsUsedTextView1;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[2]")
    private static IOSElement productsUsedLabel2;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[2]//preceding-sibling::XCUIElementTypeTextView")
    private static IOSElement productsUsedTextView2;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[1]")
    private static IOSElement productsUsedLabel3;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[3]//preceding-sibling::XCUIElementTypeTextView")
    private static IOSElement productsUsedTextView3;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[4]")
    private static IOSElement productsUsedLabel4;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Products Used '])[4]//preceding-sibling::XCUIElementTypeTextView")
    private static IOSElement productsUsedTextView4;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='ACCREDITATIONS']")
    private static IOSElement accreditationsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "National Cattle Health Declaration Available")
    private static IOSElement nationalCattleHealthDeclarationAvailableLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[47]")
    private static IOSElement nationalCattleHealthDeclarationAvailableDropdown;
    @iOSXCUITFindBy(accessibility = "JBAS Score")
    private static IOSElement JBASScoreLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[48]")
    private static IOSElement JBASScoreDropdown;
    @iOSXCUITFindBy(accessibility = "Accreditations")
    private static IOSElement accreditationsLabel;
    @iOSXCUITFindBy(accessibility = "EU")
    private static IOSElement EULabel;
    @iOSXCUITFindBy(accessibility = "MSA")
    private static IOSElement MSALabel;
    @iOSXCUITFindBy(accessibility = "LPA")
    private static IOSElement LPALabel;
    @iOSXCUITFindBy(accessibility = "Organic")
    private static IOSElement organicLabel;
    @iOSXCUITFindBy(accessibility = "PCAS")
    private static IOSElement PCASLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='SPECIAL CONDITIONS']")
    private static IOSElement specialConditionsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Special Conditions")
    private static IOSElement specialConditionsLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Special Conditions ']//preceding-sibling::XCUIElementTypeTextView")
    private static IOSElement specialConditionsTextView;
    @iOSXCUITFindBy(accessibility = "Movement Restrictions")
    private static IOSElement movementRestrictionsLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Movement Restrictions ']//preceding-sibling::XCUIElementTypeTextField")
    private static IOSElement movementRestrictionTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='DELIVERY DETAILS']")
    private static IOSElement deliveryDetailsHeaderLabel;
    @iOSXCUITFindBy(accessibility = "Forward Supply")
    private static IOSElement forwardSupplyLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Forward Supply ']//preceding-sibling::XCUIElementTypeTextField")
    private static IOSElement forwardSupplyTextBox;
    @iOSXCUITFindBy(accessibility = "Estimated Final Delivery Date *")
    private static IOSElement estimatedFinalDeliveryDateLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesexpdeliverydate") ////XCUIElementTypeStaticText[@name='Estimated Final Delivery Date *']//preceding-sibling::XCUIElementTypeTextField
    private static IOSElement estimatedFinalDeliveryDateTextBox;
    @iOSXCUITFindBy(accessibility = "Comments")
    private static IOSElement commentsLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Comments ']//preceding-sibling::XCUIElementTypeTextView")
    private static IOSElement commentsTextView;
    @iOSXCUITFindBy(accessibility = "Weighing Instructions")
    private static IOSElement weighingInstructionsLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Weighing Instructions ']//preceding-sibling::XCUIElementTypeTextView")
    private static IOSElement weighingInstructionsTextView;
    @iOSXCUITFindBy(accessibility = "Actions")
    private static IOSElement actionButtonListingInfoPage;
    @iOSXCUITFindBy(accessibility = "Publish Listing")
    private static IOSElement publishListingLink;
    @iOSXCUITFindBy(accessibility = "Hide keyboard")  ////XCUIElementTypeKey[@name='space']//following-sibling::*[3]
    private static IOSElement hideKeyboardButton;

    //************ Classified type specific locators
    @iOSXCUITFindBy(accessibility = "Classified Duration *")
    private static IOSElement classifiedDurationLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Classified Duration *']//preceding-sibling::XCUIElementTypeTextField")
    private static IOSElement classifiedDurationDropdown;
    @iOSXCUITFindBy(accessibility = "Price (ex GST) *")
    private static IOSElement priceLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Price (ex GST) *']//preceding-sibling::XCUIElementTypeTextField")
    private static IOSElement priceTextBox;
    @iOSXCUITFindBy(accessibility = "Description *")
    private static IOSElement descriptionClassifiedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[1]")
    private static IOSElement descriptionClassifiedTextView;
    @iOSXCUITFindBy(accessibility = "Weight Range - Low *")
    private static IOSElement weightRangeLowLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Weight Range - Low *']//following-sibling::XCUIElementTypeTextField")
    private static IOSElement weightRangeLowTextBox;
    @iOSXCUITFindBy(accessibility = "Weight Range - High *")
    private static IOSElement weightRangeHighLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Weight Range - High *']//preceding-sibling::XCUIElementTypeTextField")
    private static IOSElement weightRangeHighTextBox;
    @iOSXCUITFindBy(accessibility = "HGP Treated *")
    private static IOSElement hgpTreatedClassifiedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[17]")
    private static IOSElement hgpTreatedClassifiedDropdown;
    @iOSXCUITFindBy(accessibility = "Within Withholding Period (WHP) or Export Slaughter Intervals (ESI) *")
    private static IOSElement withinWithholdingPeriodOrExportSlaughterIntervalsClassifiedLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[18]")
    private static IOSElement withinWithholdingPeriodOrExportSlaughterIntervalsClassifiedDropdown;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Vendor Name']//following-sibling::XCUIElementTypeStaticText[1]")
    private static IOSElement recordIdText;

    //********** Sheep specific locators *****************
    @iOSXCUITFindBy(accessibility = "Number of Lambs at Foot *")
    private static IOSElement numberOfLambsAtFootLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmonumlambsfoot")
    private static IOSElement numberOfLambsAtFootTextField;
    @iOSXCUITFindBy(accessibility = "Lambs at Foot Sired By *")
    private static IOSElement lambsAtFootSiredByLabel;
    @iOSXCUITFindBy(accessibility = "lmkopeslabmsatftsiredby")
    private static IOSElement lambsAtFootSiredByTextField;
    @iOSXCUITFindBy(accessibility = "Age of Lambs *")
    private static IOSElement ageOfLambsLabel;
    @iOSXCUITFindBy(accessibility = "lmkopesdmoageoflambs")
    private static IOSElement ageOfLambsTextField;




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
        return commonFunctions.clickElement(classifiedRadioButton);
    }
    public boolean verifyBidAndOfferListingType() {
        return commonFunctions.clickElement(bidAndOfferRadioButton);
    }

    public boolean verifyListingTypeSelection(boolean isClassifiedTrue, String transactionType, String saleType) {
        boolean isResult=false;
        if(isClassifiedTrue){
            if(commonFunctions.clickElement(classifiedRadioButton)){
                commonFunctions.clickElement(availableRadioButton);
            }
            isResult=commonFunctions.isElementDisplayed(availableLabel, 10);

        }
        else{
            commonFunctions.clickElement(transactionTypeDropdown);
            //movePickerWheel(transactionTypeDropdown, transactionType);
            commonFunctions.sendKeyToDropDown(dropdownPicker, transactionType);
            commonFunctions.clickElement(doneButtonWheelPicker, 10);

            commonFunctions.clickElement(saleTypeDropdown);
            //movePickerWheel(saleTypeDropdown, saleType);
            commonFunctions.sendKeyToDropDown(dropdownPicker, saleType);
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

    private void movePickerWheelFatScore(WebElement element, String val){
        for(int i=0; i<7; i++) {
            pickerWheelStep(dropdownPicker, "next", 0.15);
            String pickerValue=commonFunctions.getElementText(element, 10);
            if(pickerValue.trim().contains(val)) {
                break;
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
        String townNameXpath="(//XCUIElementTypeStaticText[contains(@name,'"+town+"')])[1]";
        commonFunctions.clickElement(biddingStartDateTimeDropdown);
        commonFunctions.clickElement(doneButtonWheelPicker);
        //movePickerWheel(biddingDurationDropdown, biddingDuration);
        commonFunctions.clickElement(biddingDurationDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, biddingDuration);
        commonFunctions.clickElement(doneButtonWheelPicker, 10);

        commonFunctions.clickElement(closingSoonStatusDurationDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, closingSoonStatusDuration);
        commonFunctions.clickElement(doneButtonWheelPicker, 10);

        //movePickerWheel(closingSoonStatusDurationDropdown, closingSoonStatusDuration);
        commonFunctions.sendKey(startingPriceTextBox, startingPrice);
        commonFunctions.sendKey(reservePriceTextBox, reservePrice);
        commonFunctions.sendKey(descriptionTextView, description);
        commonFunctions.clickElement(townTextBoxButton);
        commonFunctions.sendKey(townSearchBox, town);
        commonFunctions.clickElementByXpath(townNameXpath);
        townText=commonFunctions.getElementText(townTextBoxButton, 10).trim();
        return town.contains(townText);
    }
    public boolean fillLotDetails(String pregStatus) {
        commonFunctions.sendKey(pregnancyStatusTextBox, pregStatus);
        return commonFunctions.getElementText(pregnancyStatusTextBox, 10).trim().equalsIgnoreCase(pregStatus);
    }
    public boolean enterLiveWeightToPopulate(int liveWeightKg, String fatScore) {
        boolean isResult=false;
        commonFunctions.scrollUpToElement(enterLiveWeightToPopulateButton);
        if(commonFunctions.clickElement(enterLiveWeightToPopulateButton)){
            commonFunctions.sendKey(liveWeightKgTextField, liveWeightKg+"");
            commonFunctions.clickElement(fatScoreTextField);
            //movePickerWheelFatScore(fatScoreTextField, fatScore);
            commonFunctions.sendKeyToDropDown(dropdownPicker, fatScore);
            commonFunctions.clickElement(doneButtonWheelPicker, 10);
            isResult=commonFunctions.clickElement(plusIcon);
            commonFunctions.dragAndDropFromTopToBottom();
        }
        return isResult;
    }

    public boolean enterLiveWeightToPopulateForSheep(String liveWeightKg, String numberOfHead, String fatScore) {
        boolean isResult=false;
        commonFunctions.scrollUpToElement(enterLiveWeightToPopulateButton);
        if(commonFunctions.clickElement(enterLiveWeightToPopulateButton)){
            commonFunctions.sendKey(liveWeightKgTextField, liveWeightKg);
            commonFunctions.sendKey(numberOfHeadTextField, numberOfHead);
            if(commonFunctions.clickElement(fatScoreTextField)){
                commonFunctions.sendKeyToDropDown(dropdownPicker, fatScore);
                commonFunctions.clickElement(doneButtonWheelPicker);
            }
            isResult=commonFunctions.clickElement(plusIcon);
            commonFunctions.dragAndDropFromTopToBottom();
        }
        return isResult;
    }

    public boolean fillWeightSummaryDetails(int numberOfHeadWeighted, int hoursOffFeed, int estimatedDressing, int estimatedDaysToDelivery, int estimatedWeightGain, int deliveryAdjustment) {
        commonFunctions.scrollDownToElement(numberOfHeadWeighedTextBox);
        commonFunctions.sendKey(numberOfHeadWeighedTextBox, numberOfHeadWeighted+"");

        commonFunctions.clickElement(hideKeyboardButton);

        commonFunctions.scrollDownToElement(hoursOffFeedTextBox);
        commonFunctions.sendKey(hoursOffFeedTextBox, hoursOffFeed+"");


        commonFunctions.sendKey(estimatedDressingTextBox, estimatedDressing+"");

        //driver.hideKeyboard();
        commonFunctions.clickElement(hideKeyboardButton);
        //commonFunctions.scrollDownToElement(estimatedDaysToDeliveryTextBox);

        commonFunctions.sendKey(estimatedDaysToDeliveryTextBox, estimatedDaysToDelivery+"");
        //driver.hideKeyboard();
        commonFunctions.clickElement(hideKeyboardButton);
        commonFunctions.sendKey(estimatedWeightGainTextBox, estimatedWeightGain+"");
        //driver.hideKeyboard();
        commonFunctions.clickElement(hideKeyboardButton);
        commonFunctions.sendKey(deliveryAdjustmentTextBox, deliveryAdjustment+"");
        //driver.hideKeyboard();
        commonFunctions.clickElement(hideKeyboardButton);
        return true;
        //return !commonFunctions.getElementText(deliveryAdjustmentTextBox, 10).isEmpty();
    }
    public boolean fillAssessmentOverviewDetails(String frame, String condition, String agentComments) {
        commonFunctions.scrollDownToElement(agentCommentsTextView);
//        commonFunctions.clickElement(frameTextBox);
//        movePickerWheel(frameTextBox, frame);
//        commonFunctions.clickElement(doneButtonWheelPicker);
//        commonFunctions.clickElement(conditionTextBox);
//        movePickerWheel(conditionTextBox, condition);
//        commonFunctions.clickElement(doneButtonWheelPicker);
        commonFunctions.sendKey(agentCommentsTextView, agentComments);
        //driver.hideKeyboard();
        commonFunctions.clickElement(hideKeyboardButton);
        return !commonFunctions.getElementText(agentCommentsTextView, 10).isEmpty();
    }
    public boolean fillAssessmentOverviewDetailsForSheep(String agentComments) {
        commonFunctions.scrollDownToElement(agentCommentsTextView);
        commonFunctions.sendKey(agentCommentsTextView, agentComments);
        return commonFunctions.clickElement(hideKeyboardButton);
        //return !commonFunctions.getElementText(agentCommentsTextView, 10).isEmpty();
    }
    public boolean fillAdditionalLotDetails() {
        return false;
    }
    public boolean fillNumberOfHeadsMouthedDetails() {
        return false;
    }
    public boolean fillBreedingOverviewDetails(String vendorBred, String temperament) {
        commonFunctions.scrollDownToElement(vendorBredDropdown);

        commonFunctions.clickElement(vendorBredDropdown);
        //movePickerWheel(vendorBredDropdown, vendorBred);
        commonFunctions.sendKeyToDropDown(dropdownPicker, vendorBred);
        commonFunctions.clickElement(doneButtonWheelPicker, 10);

        commonFunctions.scrollDownToElement(temperamentDropdown);
        commonFunctions.clickElement(temperamentDropdown);
        //movePickerWheel(temperamentDropdown, temperament);
        commonFunctions.sendKeyToDropDown(dropdownPicker, temperament);
        commonFunctions.clickElement(doneButtonWheelPicker, 10);

        return !commonFunctions.getElementText(temperamentDropdown, 10).isEmpty();
    }
    public boolean fillBreedingOverviewDetailsForSheep(String vendorBred, String sheddingBreed, String anyKnownContactWithSheddingBreed) {
        commonFunctions.scrollDownToElement(vendorBredDropdown);

        commonFunctions.clickElement(vendorBredDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, vendorBred);
        commonFunctions.clickElement(doneButtonWheelPicker, 10);

        commonFunctions.scrollDownToElement(sheddingBreedLabel);
        commonFunctions.clickElement(sheddingBreedDropDown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, sheddingBreed);
        commonFunctions.clickElement(doneButtonWheelPicker, 10);

        commonFunctions.clickElement(anyKnownContactWithSheddingBreedsDropDown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, anyKnownContactWithSheddingBreed);
        commonFunctions.clickElement(doneButtonWheelPicker, 10);

        return !commonFunctions.getElementText(anyKnownContactWithSheddingBreedsDropDown, 10).isEmpty();
    }
    public boolean addBreedingDetailsDetails() {
        return false;
    }
    public boolean addHealthVetDetailsDetails(String hgpTreated, String withinWithholdingPeriod) {
        boolean isResult=false;
        commonFunctions.scrollDownToElement(hgpTreatedDropdown);
        //movePickerWheel(hgpTreatedDropdown, hgpTreated);
        //commonFunctions.clickElement(doneButtonWheelPicker, 10);
        commonFunctions.clickElement(withinWithholdingPeriodOrExportSlaughterIntervalsDropdown);
        //movePickerWheel(withinWithholdingPeriodOrExportSlaughterIntervalsDropdown, withinWithholdingPeriod);
        commonFunctions.sendKeyToDropDown(dropdownPicker, withinWithholdingPeriod);
        commonFunctions.clickElement(doneButtonWheelPicker, 10);

        commonFunctions.clickElement(hgpTreatedDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, hgpTreated);
        isResult=commonFunctions.clickElement(doneButtonWheelPicker, 10);
        return isResult;
        //return !commonFunctions.getElementText(withinWithholdingPeriodOrExportSlaughterIntervalsDropdown, 10).isEmpty();
    }
    public boolean fillTreatmentDetails() {
        return false;
    }
    public boolean fillSpecialConditionsDetails() {
        return false;
    }
    public boolean fillDeliveryDetails() {
        commonFunctions.scrollDownToElement(estimatedFinalDeliveryDateTextBox);
        commonFunctions.clickElement(estimatedFinalDeliveryDateTextBox);
        commonFunctions.clickElement(doneButtonWheelPicker);
        return !commonFunctions.getElementText(estimatedFinalDeliveryDateTextBox, 10).isEmpty();
    }
    public boolean publishListing() {
        boolean isResult=false;
        globalVars.setRecordId(commonFunctions.getElementText(recordIdText, 10).trim());
        if(commonFunctions.clickElement(actionButtonListingInfoPage)){
            isResult=commonFunctions.clickElement(publishListingLink);
            try{
                Thread.sleep(5000); //Static wait to see the screen after publishing
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        return isResult;
    }

    public boolean fillClassifiedListingOverviewDetails(String classifiedDuration, int price, String description) {
        commonFunctions.clickElement(classifiedDurationDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, classifiedDuration);
        //movePickerWheel(classifiedDurationDropdown, classifiedDuration);
        commonFunctions.clickElement(doneButtonWheelPicker);

        commonFunctions.sendKey(priceTextBox, price+"");
        commonFunctions.sendKey(descriptionTextView, description);
        return commonFunctions.clickElement(hideKeyboardButton, 8);
    }
    public boolean fillClassifiedListingOverviewDetailsForSheep(String classifiedDuration, String price, String description, String town) {
        String townText="";
        String townNameXpath="(//XCUIElementTypeStaticText[contains(@name,'"+town+"')])[1]";

        commonFunctions.clickElement(classifiedDurationDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, classifiedDuration);
        commonFunctions.clickElement(doneButtonWheelPicker);

        commonFunctions.sendKey(priceTextBox, price);
        commonFunctions.sendKey(descriptionTextView, description);
        commonFunctions.clickElement(hideKeyboardButton);

        if(commonFunctions.clickElement(townTextBoxButton)){
            commonFunctions.sendKey(townSearchBox, town);
            if(commonFunctions.clickElementByXpath(townNameXpath)){
                townText=commonFunctions.getElementText(townTextBoxButton, 10).trim();
            }
        }
        return town.contains(townText);

    }
    public boolean fillClassifiedLotDetails(String hornStatus, String weightRangeLow, String weightRangeHigh) {
        //movePickerWheel(hornStatusDropdown, hornStatus);
        commonFunctions.clickElement(hornStatusDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, hornStatus);
        commonFunctions.clickElement(doneButtonWheelPicker, 10);

        commonFunctions.scrollDownToElement(weightRangeLowLabel);
        commonFunctions.sendKey(weightRangeLowTextBox, weightRangeLow);
        commonFunctions.sendKey(weightRangeHighTextBox, weightRangeHigh);
        return commonFunctions.clickElement(hideKeyboardButton, 8);
    }
    public boolean checkListingTypeDisabled() {
        return bidAndOfferRadioButton.getAttribute("enabled").trim().equalsIgnoreCase("false") &&
                classifiedRadioButton.getAttribute("enabled").trim().equalsIgnoreCase("false");
    }
    public boolean checkListingTypeEnabled() {
        return bidAndOfferRadioButton.getAttribute("enabled").trim().equalsIgnoreCase("true") &&
                classifiedRadioButton.getAttribute("enabled").trim().equalsIgnoreCase("true");
    }
    public boolean moveToLotsSection() {
        return commonFunctions.clickElement(lotsLabel);
    }
    public boolean moveToSalesInformationSection() {
        return commonFunctions.clickElement(salesInformationLabel);
    }
    public boolean ClickEditLot() {
        boolean isResult=false;
        if(commonFunctions.clickElement(firstEllipsisLotsPage)){
            isResult=commonFunctions.clickElement(editLinkLotsPagePopup);
        }
        return isResult;
    }
    public boolean deleteFirstLot() {
        boolean isResult=false;
        if(commonFunctions.clickElement(firstEllipsisLotsPage)){
            isResult=commonFunctions.clickElement(deleteLinkLotsPagePopup);
        }
        return isResult;
    }
    public boolean deleteSecondLot() {
        boolean isResult=false;
        if(commonFunctions.clickElement(secondEllipsisLotsPage)){
            isResult=commonFunctions.clickElement(deleteLinkLotsPagePopup);
        }
        return isResult;
    }

    public boolean fillLambsAtFootDetailsForSheep(String numberOfLambsAtFoot, String lambsAtFootSiredBy, String ageOfLambs) {
        commonFunctions.scrollDownToElement(ageOfLambsTextField);
        commonFunctions.sendKey(numberOfLambsAtFootTextField, numberOfLambsAtFoot);
        commonFunctions.clickElement(hideKeyboardButton);
        commonFunctions.sendKey(lambsAtFootSiredByTextField, lambsAtFootSiredBy);
        commonFunctions.clickElement(hideKeyboardButton);
        commonFunctions.sendKey(ageOfLambsTextField, ageOfLambs);
        commonFunctions.clickElement(hideKeyboardButton);
        return !commonFunctions.getElementText(ageOfLambsTextField, 10).isEmpty();
    }

    public boolean fillWoolSkinDetailsForSheep(String lastShearingDate, String mulesed, String crutched, String degreeOfBurr, String typeOfBurr, String degreeOfSeed, String typeOfSeed, String comments) {
        commonFunctions.scrollDownToElement(lastShearingDateLabel);
        if(commonFunctions.clickElement(lastShearingDateDropDown)){
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        //commonFunctions.selectDateBySendingKeysToDropDown(dropdownPickers, lastShearingDate);

        commonFunctions.scrollDownToElement(mulesedDropDown);

        if(commonFunctions.clickElement(mulesedDropDown)){
            commonFunctions.sendKeyToDropDown(dropdownPicker, mulesed);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        commonFunctions.clickElement(crutchedDropDown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, crutched);
        commonFunctions.clickElement(doneButtonWheelPicker, 10);

        if(commonFunctions.clickElement(degreeOfBurrDropDown)){
            commonFunctions.sendKeyToDropDown(dropdownPicker, degreeOfBurr);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }


        //commonFunctions.scrollDownToElement(typeOfBurrTextField);

        commonFunctions.sendKey(typeOfBurrTextField, typeOfBurr);
        commonFunctions.clickElement(hideKeyboardButton);

        if(commonFunctions.clickElement(degreeOfSeedDropDown)){
            commonFunctions.sendKeyToDropDown(dropdownPicker, degreeOfSeed);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }


        commonFunctions.sendKey(typeOfSeedTextField, typeOfSeed);
        commonFunctions.clickElement(hideKeyboardButton);

        commonFunctions.sendKey(generalWoolCommentsTextField, comments);
        commonFunctions.clickElement(hideKeyboardButton);

        return !commonFunctions.getElementText(typeOfSeedTextField, 10).isEmpty();
    }

    public boolean fillMulesedFieldWoolSkinDetailsForSheep() {

        commonFunctions.scrollDownToElement(mulesedDropDown);

        if(commonFunctions.clickElement(mulesedDropDown)){
            commonFunctions.sendKeyToDropDown(dropdownPicker, "Yes");
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        return true;

    }

    public boolean fillJoiningDetails(String joiningStatus, String numberOfHeadsScanned) {
        commonFunctions.scrollDownToElement(joiningStatusDropDown);

        commonFunctions.clickElement(joiningStatusDropDown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, joiningStatus);
        commonFunctions.clickElement(doneButtonWheelPicker, 10);

        commonFunctions.sendKey(numberOfHeadScannedInLambTextField, numberOfHeadsScanned);
        return commonFunctions.clickElement(hideKeyboardButton);
    }

    public boolean fillHealthVetDetailsDetails(String sheepAreFreeOfFootrot, String sheepHaveNoHistoryOfFootrot, String sheepAreFreeOfLice, String withinWithHoldingPeriod) {
        boolean isResult=false;
        commonFunctions.scrollDownToElement(sheepHaveNoHistoryOfFootrotDropDown);

        if(commonFunctions.clickElement(sheepAreFreeOfFootrotDropDown)){
            commonFunctions.sendKeyToDropDown(dropdownPicker, sheepAreFreeOfFootrot);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        if(commonFunctions.clickElement(sheepHaveNoHistoryOfFootrotDropDown)){
            commonFunctions.sendKeyToDropDown(dropdownPicker, sheepHaveNoHistoryOfFootrot);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        if(commonFunctions.clickElement(sheepAreFreeOfLicetDropDown)){
            commonFunctions.sendKeyToDropDown(dropdownPicker, sheepAreFreeOfLice);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        if(commonFunctions.clickElement(withinWithHoldingPeriodDropDown)){
            commonFunctions.sendKeyToDropDown(dropdownPicker, withinWithHoldingPeriod);
            isResult=commonFunctions.clickElement(doneButtonWheelPicker);
        }

        return isResult;
    }

    public boolean fillAccreditationDetails(String bioSecurityPlanAvailable, String approvedOJDVaccines) {

        boolean isResult=false;
        commonFunctions.scrollDownToElement(bioSecurityPlanAvailableDropDown);

        if(commonFunctions.clickElement(bioSecurityPlanAvailableDropDown)){
            commonFunctions.sendKeyToDropDown(dropdownPicker, bioSecurityPlanAvailable);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }
        if(commonFunctions.clickElement(approvedOJDVaccineDropDown)){
            commonFunctions.sendKeyToDropDown(dropdownPicker, approvedOJDVaccines);
            isResult=commonFunctions.clickElement(doneButtonWheelPicker);
        }

        return isResult;
    }

}
