package pages_ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctionsMobile;
import utils.GlobalVars;

import java.util.List;

public class NewContractPage {
    private AppiumDriver driver;
    static CommonFunctionsMobile commonFunctions=null;
    private static GlobalVars globalVars;
    private static NewContractPage newContractPage;
    private String valueXpathLotsSummary="(//XCUIElementTypeStaticText[@value='###'])[1]";


    @iOSXCUITFindBy(accessibility = "new contract")
    private static MobileElement newContractTile;
    @iOSXCUITFindBy(accessibility = "Sale Information")
    private static MobileElement salesInformationLabel;
    @iOSXCUITFindBy(accessibility = "Vendor Information")
    private static MobileElement vendorInfoLabel;
    @iOSXCUITFindBy(accessibility = "Buyer Information")
    private static MobileElement buyerInfoLabel;
    @iOSXCUITFindBy(accessibility = "Delivery")
    private static MobileElement deliveryInfoLabel;
    @iOSXCUITFindBy(accessibility = "Additional Charges")
    private static MobileElement additionalChargesLabel;
    @iOSXCUITFindBy(accessibility = "Lots")
    private static MobileElement lotsLabel;
    @iOSXCUITFindBy(accessibility = "Additional Charges")
    private static MobileElement additionalChargeLabel;
    @iOSXCUITFindBy(accessibility = "Commission & Agents")
    private static MobileElement commissionAndAgentsLabel;
    @iOSXCUITFindBy(accessibility = "Attachments")
    private static MobileElement attachmentsLabel;
    @iOSXCUITFindBy(accessibility = "Notes")
    private static MobileElement notesLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='New Contract']")
    private static MobileElement newContractHeaderLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
    private static MobileElement doneButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]") //*** //XCUIElementTypeStaticText[@value='Title *']//preceding-sibling::XCUIElementTypeTextField
    private static MobileElement titleTextbox;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[2]") //****//XCUIElementTypeStaticText[@value='Expected Sale Date ']//preceding-sibling::XCUIElementTypeTextField
    private static MobileElement expectedSaleDateTextbox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
    private static MobileElement nextButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
    private static MobileElement cancelButton;
    @iOSXCUITFindBy(accessibility = "Delete")
    private static MobileElement deleteButtonPopup;
    @iOSXCUITFindBy(accessibility = "Cancel")
    private static MobileElement cancelButtonPopup;
    @iOSXCUITFindBy(accessibility = "LMSearchInputViewCell-button-tap-to-search") //lmkopecesdmovendor//## //XCUIElementTypeTextField
    private static MobileElement vendorInfoTextbox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private static MobileElement vendorInfoTextboxPopup;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther")
    private static MobileElement vendorInfoPopupWindow;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Vendor *']//following-sibling:: XCUIElementTypeButton")
    private static MobileElement vendorName; //to get the name attribute's value for the name of the vendor
    @iOSXCUITFindBy(accessibility = "Customer-SearchBar-0") ////XCUIElementTypeTextField     // ***** Till build-167 //XCUIElementTypeSearchField
    private static MobileElement vendorInfoSearchBoxPopupWindow;
    //******Lots page elements**********
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmoquantity") //## (//XCUIElementTypeTextField)[1]
    private static MobileElement quantityTextBox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    private static MobileElement dropdownPicker;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    private static List<MobileElement> dropdownPickers;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmoproductcat") //# (//XCUIElementTypeTextField)[2]
    private static MobileElement productCategoryDropdown;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmoproduct") //## (//XCUIElementTypeTextField)[3]
    private static MobileElement productDropdown;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmobreed") //## (//XCUIElementTypeTextField)[4]
    private static MobileElement breedDropdown;
    @iOSXCUITFindBy(accessibility = "lmkfmdmocostper") //## (//XCUIElementTypeTextField)[5]
    private static MobileElement priceTypeDropdown;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmopriceaud") //(//XCUIElementTypeTextField)[6]
    private static MobileElement priceGstTextBox;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmosex") //## (//XCUIElementTypeTextField)[7]
    private static MobileElement sexDropdown;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmoage-from") //## (//XCUIElementTypeTextField)[8]
    private static MobileElement ageTextBox1;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmoage-to") //(//XCUIElementTypeTextField)[9]
    private static MobileElement ageTextBox2;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmoagemonyr") //## (//XCUIElementTypeTextField)[10]
    private static MobileElement monthsDropdown;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmolistgdesc") //## //XCUIElementTypeTextView
    private static MobileElement descriptionTextBox;
    @iOSXCUITFindBy(accessibility = "Live Weight Range")
    private static MobileElement liveWeightRangeLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Live Weight Range ']//preceding-sibling:: XCUIElementTypeTextField")
    private static MobileElement liveWeightRangeTextField;
    @iOSXCUITFindBy(accessibility = "Fat Score Range")
    private static MobileElement fatScoreRangeLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Fat Score Range ']//preceding-sibling:: XCUIElementTypeTextField")
    private static MobileElement fatScoreRangeTextField;
    @iOSXCUITFindBy(accessibility = "Have Hormone Growth Promotants Been Used")
    private static MobileElement haveHormoneGrowthPromotantsBeenUsedLabel;
    @iOSXCUITFindBy(accessibility = "Additional Information")
    private static MobileElement additionalInformationLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Additional Information ']//preceding-sibling:: XCUIElementTypeTextView")
    private static MobileElement additionalInformationTextView;
    @iOSXCUITFindBy(accessibility = "Carthage Required")
    private static MobileElement carthageRequiredLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='COMMISSION']")
    private static MobileElement commissionHeaderLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Save & Review']")
    private static MobileElement saveAndReviewButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='LIVESTOCK SUMMARY (SUBJECT TO DELIVERY)']")
    private static MobileElement liveStockSummaryHeader;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Total Quantity']")
    private static MobileElement totalQuantityLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Total Weight')]")
    private static MobileElement totalWeightLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Total Sale Value']")
    private static MobileElement totalSaleValueLabel;
    //@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='###'])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add New Lot']") //XCUIElementTypeButton[@name='Add new Lot']
    private static MobileElement addNewLotButton;

    //********* Attachments elements ************
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Upload Attachments']")
    private static MobileElement uploadAttachtmentsButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Browse Files']")
    private static MobileElement browseFilesButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Camera Roll']")
    private static MobileElement cameraRollButton;
    @iOSXCUITFindBy(accessibility = "Photo Gallery")
    private static MobileElement photoGalleryLink;

    @iOSXCUITFindBy(accessibility = "Photo Gallery")
    private static MobileElement photoGalleryButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]")
    private static MobileElement firstImage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButtonFileUploadWindow;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage)[6]")
    private static MobileElement imagePreviewAttachmentsTab;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Browse']")
    private static MobileElement browseButton;

    @iOSXCUITFindBy(accessibility = "attachment options")
    private static MobileElement attachmentOptionsEllipsis;


    //******** Notes tab elements ***************
    @iOSXCUITFindBy(accessibility = "add")
    private static MobileElement plusIconNotes;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView")
    private static MobileElement notesTextField;
    @iOSXCUITFindBy(accessibility = "send")
    private static MobileElement sendIconNotes;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Validate & Sign Contract']")
    private static MobileElement validateAndSignContractButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit & View Record']")
    private static MobileElement submitAndViewRecordButton;
    //******* New contract sales information elements
    @iOSXCUITFindBy(accessibility = "lmkecondmocontractdate") //  **//XCUIElementTypeStaticText[@name='Contract Date *']//preceding-sibling:: XCUIElementTypeTextField
    private static MobileElement contractDateDropdown;
    @iOSXCUITFindBy(accessibility = "lmkopecdmosaletype") //*** //XCUIElementTypeStaticText[@name='Sale Type *']//preceding-sibling:: XCUIElementTypeTextField
    private static MobileElement salesTypeDropdown;
    @iOSXCUITFindBy(accessibility = "lmkecondmobranch") //## //XCUIElementTypeStaticText[@name=' Branch *']//following-sibling:: XCUIElementTypeButton
    private static MobileElement branchSearchButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private static MobileElement searchTextBoxPopupWindowBranch;
    @iOSXCUITFindBy(accessibility = "Buyer Info")
    private static MobileElement buyerInfoHeaderLabel;
    @iOSXCUITFindBy(accessibility = "lmkecondmobuyer")  // ## //XCUIElementTypeStaticText[@name='Buyer *']//following-sibling::XCUIElementTypeButton
    private static MobileElement buyerInfoSearchButton;
    @iOSXCUITFindBy(accessibility = "Delivery")
    private static MobileElement deliveryHeaderLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Horn Status *']//preceding-sibling:: XCUIElementTypeTextField")
    private static MobileElement hornStatusDropdown;
    @iOSXCUITFindBy(accessibility = "lmkecondmodeliverypoint") // ### //XCUIElementTypeStaticText[@name='Delivery Point *']//preceding-sibling:: XCUIElementTypeTextField
    private static MobileElement deliveryPointTextField;
    @iOSXCUITFindBy(accessibility = "lmkecondmoestfidelidate") //## //XCUIElementTypeStaticText[@name='Est. Final Delivery Date *']//following-sibling:: XCUIElementTypeTextField
    private static MobileElement estimatedFinalDeliveryDateDropdown;
    @iOSXCUITFindBy(accessibility = "Multiple Deliveries?")
    private static MobileElement multipleDeliveriesLabel;
    @iOSXCUITFindBy(accessibility = "Pickup/Delivery Notes")
    private static MobileElement pickUpDeliveryNotesLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pickup/Delivery Notes ']//preceding-sibling::XCUIElementTypeTextView")
    private static MobileElement pickUpDeliveryNotesTextView;
    @iOSXCUITFindBy(accessibility = "Date of Inspection")
    private static MobileElement dateOfInspectionLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Date of Inspection ']//preceding-sibling::XCUIElementTypeTextField")
    private static MobileElement dateOfInspectionDropDown;
    @iOSXCUITFindBy(accessibility = "Location of Inspection")
    private static MobileElement locationOfInspectionLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Location of Inspection ']//preceding-sibling::XCUIElementTypeTextField")
    private static MobileElement locationOfInspectionTextField;
    @iOSXCUITFindBy(accessibility = "Location of Livestock Until Delivery")
    private static MobileElement locationOfLiveStockUntilDeliveryLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Location of Livestock Until Delivery ']//preceding-sibling::XCUIElementTypeTextField")
    private static MobileElement locationOfLiveStockUntilDeliveryTextField;

    @iOSXCUITFindBy(accessibility = "Submit")
    private static MobileElement submitLink;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Done'])[2]")
    private static MobileElement doneButtonWheelPicker;
    @iOSXCUITFindBy(accessibility = "Is this an AuctionPlus Sale?")
    private static MobileElement isThisAnAuctionPlusSaleLabel;
    @iOSXCUITFindBy(accessibility = "Split Agreement Proceeds?")
    private static MobileElement SpitAgreementsProceedsLabel;
    @iOSXCUITFindBy(accessibility = "Add Authorised Representative")
    private static MobileElement addAuthorisedRepresentativeLabel;
    @iOSXCUITFindBy(accessibility = "Split Proceeds With *")
    private static MobileElement splitProceedsWithLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Split Proceeds With *']//preceding-sibling:: XCUIElementTypeTextField")
    private static MobileElement splitProceedsWithTextField;
    @iOSXCUITFindBy(accessibility = "Add Authorised Representative")
    private static MobileElement AddAuthorisedRepresentativeLabel;
    @iOSXCUITFindBy(accessibility = "First Name *")
    private static MobileElement firstNameLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='First Name *']//following-sibling:: XCUIElementTypeTextField")
    private static MobileElement firstNameTextField;
    @iOSXCUITFindBy(accessibility = "Last Name *")
    private static MobileElement lastNameLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Last Name *']//preceding-sibling:: XCUIElementTypeTextField")
    private static MobileElement lastNameTextField;
    @iOSXCUITFindBy(accessibility = "Email *")
    private static MobileElement emailLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Email *']//preceding-sibling:: XCUIElementTypeTextField")
    private static MobileElement emailTextField;
    @iOSXCUITFindBy(accessibility = "Phone *")
    private static MobileElement phoneLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Phone *']//preceding-sibling:: XCUIElementTypeTextField")
    private static MobileElement phoneTextField;


    @iOSXCUITFindBy(accessibility = "Hide keyboard")
    private static IOSElement hideKeyboardButton;




    public NewContractPage() {
        globalVars=GlobalVars.getInstance();
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctionsMobile.getInstance();

    }
    public static NewContractPage getInstance(){
        if(newContractPage ==null){
            newContractPage =new NewContractPage();
        }
        return newContractPage;
    }

    public boolean verifyNewContractNavigation() {
        return commonFunctions.clickElement(newContractTile, 15);
    }


    public boolean verifyNewContractHeaderLabel() {
        return commonFunctions.isElementDisplayed(newContractHeaderLabel, 15);
    }


    public boolean verifySalesInformationLabel() {
        return commonFunctions.isElementDisplayed(salesInformationLabel, 15);
    }


    public boolean verifyVendorInfoLabel() {
        return commonFunctions.isElementDisplayed(vendorInfoLabel, 15);
    }
    public boolean verifyBuyerInfoLabel() {
        return commonFunctions.isElementDisplayed(buyerInfoLabel, 15);
    }
    public boolean verifyDeliveryInfoLabel() {
        return commonFunctions.isElementDisplayed(deliveryInfoLabel, 15);
    }
    public boolean verifyAdditionalChargesLabel() {
        return commonFunctions.isElementDisplayed(additionalChargeLabel, 15);
    }
    public boolean verifyCommissionAndAgentsLabel() {
        return commonFunctions.isElementDisplayed(commissionAndAgentsLabel, 15);
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

    public boolean addVendorInfo(String searchText) {
        boolean isResult=false;

        if(commonFunctions.clickElement(vendorInfoTextbox)) {

            commonFunctions.clickElement(vendorInfoSearchBoxPopupWindow);
            commonFunctions.sendKeyWithActions(vendorInfoSearchBoxPopupWindow, searchText);

            if(commonFunctions.clickElementByAccessibilityId("Trading Name: "+searchText)) {

                if (commonFunctions.clickElement(nextButton, 10)) {
                    isResult = commonFunctions.isElementDisplayed(vendorInfoTextbox, 15);
                }
            }
        }
        return isResult;
    }

    public boolean addBuyerInfo(String searchText) {
        boolean isResult=false;

        if(commonFunctions.clickElement(vendorInfoTextbox)) {

            commonFunctions.clickElement(vendorInfoSearchBoxPopupWindow);
            commonFunctions.sendKeyWithActions(vendorInfoSearchBoxPopupWindow, searchText);

            if(commonFunctions.clickElementByAccessibilityId("Trading Name: "+searchText)) {
                if (commonFunctions.clickElement(nextButton)) {
                    isResult = commonFunctions.isElementDisplayed(deliveryPointTextField, 15);
                }
            }
        }

        return isResult;
    }

    public boolean addDeliveryInfo(String deliveryPoint, String month, int day, int year) {
        boolean isResult=false;
        commonFunctions.rightClickElement(deliveryPointTextField, 10);
        commonFunctions.sendKey(deliveryPointTextField, deliveryPoint);
        //commonFunctions.sendKeyWithActions(deliveryPointTextField, deliveryPoint);

        if(commonFunctions.clickElement(estimatedFinalDeliveryDateDropdown)) {
            //commonFunctions.selectDateFromDatePicker(dropdownPickers, month, day, year);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }
        if(commonFunctions.clickElement(nextButton)){
            isResult=commonFunctions.isElementDisplayed(quantityTextBox, 15);
        }
        return isResult;
    }


    public boolean addLotsInformation(String quantity, String productCategory, String product, String breed, String priceType, String price, String age1, String age2, String monthDropdown, String description) {
        boolean isResult;
        if(commonFunctions.clickElement(quantityTextBox, 20)) {
            commonFunctions.sendKey(quantityTextBox, quantity);
        }

        if(commonFunctions.clickElement(productCategoryDropdown)) {
            commonFunctions.sendKeyToDropDown(dropdownPicker, productCategory);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        if(commonFunctions.clickElement(productDropdown)) {
            commonFunctions.sendKeyToDropDown(dropdownPicker, product);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        if(commonFunctions.clickElement(breedDropdown)) {
            commonFunctions.sendKeyToDropDown(dropdownPicker, breed);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        if(commonFunctions.clickElement(priceTypeDropdown)) {
            commonFunctions.sendKeyToDropDown(dropdownPicker, priceType);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        commonFunctions.sendKey(priceGstTextBox, price);
        commonFunctions.sendKey(ageTextBox1, age1);
        //commonFunctions.sendKey(ageTextBox2, age2);

        if(commonFunctions.clickElement(monthsDropdown)) {
            commonFunctions.sendKeyToDropDown(dropdownPicker, monthDropdown);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        commonFunctions.sendKey(descriptionTextBox, description);

        commonFunctions.clickElement(hideKeyboardButton, 10);

        commonFunctions.clickElement(saveAndReviewButton);

//        if(commonFunctions.clickElement(nextButton, 10)) {
//            commonFunctions.clickElement(saveAndReviewButton);
//        }

        isResult= commonFunctions.isElementDisplayed(addNewLotButton, 10);

        if(isResult) {
            commonFunctions.clickElement(nextButton);
        }
        return isResult;

    }
    public boolean addAdditionalCharges() {
        boolean isResult=false;
        if(commonFunctions.clickElement(nextButton)){
            isResult=commonFunctions.isElementDisplayed(commissionHeaderLabel, 10);
        }
        return isResult;
    }
    public boolean addCommissionAndAgent() {
        boolean isResult=false;
        if(commonFunctions.clickElement(nextButton)){
            isResult=commonFunctions.isElementDisplayed(attachmentsLabel, 10);
        }
        return isResult;
    }


    public boolean verifyLotSummaryPageHeaderLabels() {
        return (commonFunctions.isElementDisplayed(totalQuantityLabel) && commonFunctions.isElementDisplayed(totalWeightLabel) && commonFunctions.isElementDisplayed(totalSaleValueLabel));
    }


    public boolean verifyLotSummaryPageValues(String quantity, String totalWeight, String totalSaleValue) {
        return commonFunctions.isElementDisplayedByXpath(valueXpathLotsSummary.replace("###",quantity)) &&
                commonFunctions.isElementDisplayedByXpath(valueXpathLotsSummary.replace("###",totalWeight)) &&
                commonFunctions.isElementDisplayedByXpath(valueXpathLotsSummary.replace("###",totalSaleValue));
    }


    public boolean addAttachments() {

        boolean isResult=false;
        if(commonFunctions.clickElement(uploadAttachtmentsButton)){
            if(commonFunctions.clickElement(photoGalleryButton)){ // //photoGalleryButton
                try{
                    Thread.sleep(2000);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                if(commonFunctions.clickElementWithActions(firstImage, 10)){   //commonFunctions.clickElement(firstImage)
                    isResult=commonFunctions.clickElement(continueButtonFileUploadWindow, 10);
                }
            }
        }

        return isResult;
    }


    public boolean verifyAttachments() {
        boolean isResult=commonFunctions.isElementDisplayed(attachmentOptionsEllipsis);

        commonFunctions.clickElement(nextButton);

        return isResult;
    }


    public boolean addNotes(String note) {
        commonFunctions.sendKey(notesTextField, note);
        commonFunctions.clickElement(sendIconNotes);
        return commonFunctions.clickElement(sendIconNotes);
    }


    public boolean verifyNotes(String note) {
        boolean isResult;
        String notesTextXpath="//XCUIElementTypeStaticText[contains(@name,'"+note+"')]";
        //XCUIElementTypeStaticText[contains(@name,'Automation note')]
        isResult=commonFunctions.isElementDisplayedByXpath(notesTextXpath);
        commonFunctions.clickElement(validateAndSignContractButton);

        return isResult;
    }

    public boolean fillSalesInformation(String month, int day, int year, String salesType, String branchName){
        boolean isResult=false;
        String branchNameXpath="//XCUIElementTypeStaticText[@name='"+branchName+"']";

        if(commonFunctions.clickElement(contractDateDropdown)) {
            //commonFunctions.selectDateFromDatePicker(dropdownPickers, month, day, year);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        if(commonFunctions.clickElement(salesTypeDropdown)) {
            commonFunctions.sendKeyToDropDown(dropdownPicker, salesType);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        if(commonFunctions.clickElement(branchSearchButton)) {
            commonFunctions.sendKey(searchTextBoxPopupWindowBranch, branchName);
            commonFunctions.clickElementByXpath(branchNameXpath);
        }
        if(commonFunctions.clickElement(nextButton)){
            isResult=commonFunctions.isElementDisplayed(vendorInfoTextbox, 15);
        }
        return isResult;
    }

}

