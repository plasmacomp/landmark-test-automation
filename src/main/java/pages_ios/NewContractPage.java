package pages_ios;

import io.appium.java_client.AppiumDriver;
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
    private static WebElement newContractTile;
    @iOSXCUITFindBy(accessibility = "Sale Information")
    private static WebElement salesInformationLabel;
    @iOSXCUITFindBy(accessibility = "Vendor Info")
    private static WebElement vendorInfoLabel;
    @iOSXCUITFindBy(accessibility = "Buyer Info")
    private static WebElement buyerInfoLabel;
    @iOSXCUITFindBy(accessibility = "Delivery")
    private static WebElement deliveryInfoLabel;
    @iOSXCUITFindBy(accessibility = "Additional Charges")
    private static WebElement additionalChargesLabel;
    @iOSXCUITFindBy(accessibility = "Lots")
    private static WebElement lotsLabel;
    @iOSXCUITFindBy(accessibility = "Additional Charges")
    private static WebElement additionalChargeLabel;
    @iOSXCUITFindBy(accessibility = "Commission & Agents")
    private static WebElement commissionAndAgentsLabel;
    @iOSXCUITFindBy(accessibility = "Attachments")
    private static WebElement attachmentsLabel;
    @iOSXCUITFindBy(accessibility = "Notes")
    private static WebElement notesLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='New Contract']")
    private static WebElement newContractHeaderLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
    private static WebElement doneButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]") //*** //XCUIElementTypeStaticText[@value='Title *']//preceding-sibling::XCUIElementTypeTextField
    private static WebElement titleTextbox;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[2]") //****//XCUIElementTypeStaticText[@value='Expected Sale Date ']//preceding-sibling::XCUIElementTypeTextField
    private static WebElement expectedSaleDateTextbox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
    private static WebElement nextButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
    private static WebElement cancelButton;
    @iOSXCUITFindBy(accessibility = "Delete")
    private static WebElement deleteButtonPopup;
    @iOSXCUITFindBy(accessibility = "Cancel")
    private static WebElement cancelButtonPopup;
    @iOSXCUITFindBy(accessibility = "lmkopecesdmovendor") //## //XCUIElementTypeTextField
    private static WebElement vendorInfoTextbox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private static WebElement vendorInfoTextboxPopup;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther")
    private static WebElement vendorInfoPopupWindow;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Vendor *']//following-sibling:: XCUIElementTypeButton")
    private static WebElement vendorName; //to get the name attribute's value for the name of the vendor
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")      // ***** Till build-167 //XCUIElementTypeSearchField
    private static WebElement vendorInfoSearchBoxPopupWindow;
    //******Lots page elements**********
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmoquantity") //## (//XCUIElementTypeTextField)[1]
    private static WebElement quantityTextBox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    private static WebElement dropdownPicker;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    private static List<WebElement> dropdownPickers;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmoproductcat") //# (//XCUIElementTypeTextField)[2]
    private static WebElement productCategoryDropdown;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmoproduct") //## (//XCUIElementTypeTextField)[3]
    private static WebElement productDropdown;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmobreed") //## (//XCUIElementTypeTextField)[4]
    private static WebElement breedDropdown;
    @iOSXCUITFindBy(accessibility = "lmkfmdmocostper") //## (//XCUIElementTypeTextField)[5]
    private static WebElement priceTypeDropdown;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmopriceaud") //(//XCUIElementTypeTextField)[6]
    private static WebElement priceGstTextBox;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmosex") //## (//XCUIElementTypeTextField)[7]
    private static WebElement sexDropdown;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmoage-from") //## (//XCUIElementTypeTextField)[8]
    private static WebElement ageTextBox1;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmoage-to") //(//XCUIElementTypeTextField)[9]
    private static WebElement ageTextBox2;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmoagemonyr") //## (//XCUIElementTypeTextField)[10]
    private static WebElement monthsDropdown;
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmolistgdesc") //## //XCUIElementTypeTextView
    private static WebElement descriptionTextBox;
    @iOSXCUITFindBy(accessibility = "Live Weight Range")
    private static WebElement liveWeightRangeLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Live Weight Range ']//preceding-sibling:: XCUIElementTypeTextField")
    private static WebElement liveWeightRangeTextField;
    @iOSXCUITFindBy(accessibility = "Fat Score Range")
    private static WebElement fatScoreRangeLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Fat Score Range ']//preceding-sibling:: XCUIElementTypeTextField")
    private static WebElement fatScoreRangeTextField;
    @iOSXCUITFindBy(accessibility = "Have Hormone Growth Promotants Been Used")
    private static WebElement haveHormoneGrowthPromotantsBeenUsedLabel;
    @iOSXCUITFindBy(accessibility = "Additional Information")
    private static WebElement additionalInformationLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Additional Information ']//preceding-sibling:: XCUIElementTypeTextView")
    private static WebElement additionalInformationTextView;
    @iOSXCUITFindBy(accessibility = "Carthage Required")
    private static WebElement carthageRequiredLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='COMMISSION']")
    private static WebElement commissionHeaderLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Save & Review']")
    private static WebElement saveAndReviewButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='LIVESTOCK SUMMARY (SUBJECT TO DELIVERY)']")
    private static WebElement liveStockSummaryHeader;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Total Quantity']")
    private static WebElement totalQuantityLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Total Weight')]")
    private static WebElement totalWeightLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Total Sale Value']")
    private static WebElement totalSaleValueLabel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='###'])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add New Lot']") //XCUIElementTypeButton[@name='Add new Lot']
    private static WebElement addNewLotButton;

    //********* Attachments elements ************
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Upload Attachments']")
    private static WebElement uploadAttachtmentsButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Browse Files']")
    private static WebElement browseFilesButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Camera Roll']")
    private static WebElement cameraRollButton;
    @iOSXCUITFindBy(accessibility = "Photo Gallery")
    private static WebElement photoGalleryLink;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[1]")
    private static WebElement firstImage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static WebElement continueButtonFileUploadWindow;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage)[6]")
    private static WebElement imagePreviewAttachmentsTab;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Browse']")
    private static WebElement browseButton;

    //******** Notes tab elements ***************
    @iOSXCUITFindBy(accessibility = "add")
    private static WebElement plusIconNotes;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView")
    private static WebElement notesTextField;
    @iOSXCUITFindBy(accessibility = "send")
    private static WebElement sendIconNotes;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Validate & Sign Contract']")
    private static WebElement validateAndSignContractButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit & View Record']")
    private static WebElement submitAndViewRecordButton;
//******* New contract sales information elements
    @iOSXCUITFindBy(accessibility = "lmkecondmocontractdate") //  **//XCUIElementTypeStaticText[@name='Contract Date *']//preceding-sibling:: XCUIElementTypeTextField
    private static WebElement contractDateDropdown;
    @iOSXCUITFindBy(accessibility = "lmkopecdmosaletype") //*** //XCUIElementTypeStaticText[@name='Sale Type *']//preceding-sibling:: XCUIElementTypeTextField
    private static WebElement salesTypeDropdown;
    @iOSXCUITFindBy(accessibility = "lmkecondmobranch") //## //XCUIElementTypeStaticText[@name=' Branch *']//following-sibling:: XCUIElementTypeButton
    private static WebElement branchSearchButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private static WebElement searchTextBoxPopupWindowBranch;
    @iOSXCUITFindBy(accessibility = "Buyer Info")
    private static WebElement buyerInfoHeaderLabel;
    @iOSXCUITFindBy(accessibility = "lmkecondmobuyer")  // ## //XCUIElementTypeStaticText[@name='Buyer *']//following-sibling::XCUIElementTypeButton
    private static WebElement buyerInfoSearchButton;
    @iOSXCUITFindBy(accessibility = "Delivery")
    private static WebElement deliveryHeaderLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Horn Status *']//preceding-sibling:: XCUIElementTypeTextField")
    private static WebElement hornStatusDropdown;
    @iOSXCUITFindBy(accessibility = "lmkecondmodeliverypoint") // ### //XCUIElementTypeStaticText[@name='Delivery Point *']//preceding-sibling:: XCUIElementTypeTextField
    private static WebElement deliveryPointTextField;
    @iOSXCUITFindBy(accessibility = "lmkecondmoestfidelidate") //## //XCUIElementTypeStaticText[@name='Est. Final Delivery Date *']//following-sibling:: XCUIElementTypeTextField
    private static WebElement estimatedFinalDeliveryDateDropdown;
    @iOSXCUITFindBy(accessibility = "Multiple Deliveries?")
    private static WebElement multipleDeliveriesLabel;
    @iOSXCUITFindBy(accessibility = "Pickup/Delivery Notes")
    private static WebElement pickUpDeliveryNotesLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pickup/Delivery Notes ']//preceding-sibling::XCUIElementTypeTextView")
    private static WebElement pickUpDeliveryNotesTextView;
    @iOSXCUITFindBy(accessibility = "Date of Inspection")
    private static WebElement dateOfInspectionLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Date of Inspection ']//preceding-sibling::XCUIElementTypeTextField")
    private static WebElement dateOfInspectionDropDown;
    @iOSXCUITFindBy(accessibility = "Location of Inspection")
    private static WebElement locationOfInspectionLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Location of Inspection ']//preceding-sibling::XCUIElementTypeTextField")
    private static WebElement locationOfInspectionTextField;
    @iOSXCUITFindBy(accessibility = "Location of Livestock Until Delivery")
    private static WebElement locationOfLiveStockUntilDeliveryLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Location of Livestock Until Delivery ']//preceding-sibling::XCUIElementTypeTextField")
    private static WebElement locationOfLiveStockUntilDeliveryTextField;

    @iOSXCUITFindBy(accessibility = "Submit")
    private static WebElement submitLink;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Done'])[2]")
    private static WebElement doneButtonWheelPicker;
    @iOSXCUITFindBy(accessibility = "Is this an AuctionPlus Sale?")
    private static WebElement isThisAnAuctionPlusSaleLabel;
    @iOSXCUITFindBy(accessibility = "Split Agreement Proceeds?")
    private static WebElement SpitAgreementsProceedsLabel;
    @iOSXCUITFindBy(accessibility = "Add Authorised Representative")
    private static WebElement addAuthorisedRepresentativeLabel;
    @iOSXCUITFindBy(accessibility = "Split Proceeds With *")
    private static WebElement splitProceedsWithLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Split Proceeds With *']//preceding-sibling:: XCUIElementTypeTextField")
    private static WebElement splitProceedsWithTextField;
    @iOSXCUITFindBy(accessibility = "Add Authorised Representative")
    private static WebElement AddAuthorisedRepresentativeLabel;
    @iOSXCUITFindBy(accessibility = "First Name *")
    private static WebElement firstNameLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='First Name *']//following-sibling:: XCUIElementTypeTextField")
    private static WebElement firstNameTextField;
    @iOSXCUITFindBy(accessibility = "Last Name *")
    private static WebElement lastNameLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Last Name *']//preceding-sibling:: XCUIElementTypeTextField")
    private static WebElement lastNameTextField;
    @iOSXCUITFindBy(accessibility = "Email *")
    private static WebElement emailLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Email *']//preceding-sibling:: XCUIElementTypeTextField")
    private static WebElement emailTextField;
    @iOSXCUITFindBy(accessibility = "Phone *")
    private static WebElement phoneLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Phone *']//preceding-sibling:: XCUIElementTypeTextField")
    private static WebElement phoneTextField;






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
        String vendorNameXpath="(//XCUIElementTypeStaticText[contains(@value,'"+searchText+"')])[1]";
        commonFunctions.clickElement(vendorInfoTextbox);
        //commonFunctions.sendKey(vendorInfoSearchBoxPopupWindow, searchText);
        //commonFunctions.clickElementByXpath(vendorNameXpath);
        //commonFunctions.clickElement(vendorInfoPopupWindow);
        if(commonFunctions.clickElement(nextButton)){
            isResult=commonFunctions.isElementDisplayed(buyerInfoSearchButton, 15);
        }
        return isResult;
    }
    public boolean addBuyerInfo(String searchText) {
        boolean isResult=false;
        String buyerNameXpath="(//XCUIElementTypeStaticText[contains(@value,'"+searchText+"')])[1]";
        commonFunctions.clickElement(buyerInfoSearchButton);
//        commonFunctions.sendKey(vendorInfoSearchBoxPopupWindow, searchText);
//        commonFunctions.clickElementByXpath(buyerNameXpath);
        //commonFunctions.clickElement(vendorInfoPopupWindow);
        if(commonFunctions.clickElement(nextButton)){
            isResult=commonFunctions.isElementDisplayed(deliveryPointTextField, 15);
        }
        return isResult;
    }

    public boolean addDeliveryInfo(String deliveryPoint, String month, int day, int year) {
        boolean isResult=false;
        commonFunctions.sendKey(deliveryPointTextField, deliveryPoint);
        commonFunctions.clickElement(estimatedFinalDeliveryDateDropdown);
        //commonFunctions.selectDateFromDatePicker(dropdownPickers, month, day, year);
        commonFunctions.clickElement(doneButtonWheelPicker);
        if(commonFunctions.clickElement(nextButton)){
            isResult=commonFunctions.isElementDisplayed(quantityTextBox, 15);
        }
        return isResult;
    }

    
    public boolean addLotsInformation(String quantity, String productCategory, String product, String breed, String priceType, String price, String age1, String age2, String monthDropdown, String description) {
        boolean isResult=false;
        commonFunctions.sendKey(quantityTextBox, quantity);
        commonFunctions.clickElement(productCategoryDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, productCategory);
        commonFunctions.clickElement(doneButtonWheelPicker);

        commonFunctions.clickElement(productDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, product);
        commonFunctions.clickElement(doneButtonWheelPicker);

        commonFunctions.clickElement(breedDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, breed);
        commonFunctions.clickElement(doneButtonWheelPicker);

        commonFunctions.clickElement(priceTypeDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, priceType);
        commonFunctions.clickElement(doneButtonWheelPicker);

        commonFunctions.sendKey(priceGstTextBox, price);
        commonFunctions.sendKey(ageTextBox1, age1);
        commonFunctions.sendKey(ageTextBox2, age2);

        commonFunctions.clickElement(monthsDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, monthDropdown);
        commonFunctions.clickElement(doneButtonWheelPicker);

        commonFunctions.sendKey(descriptionTextBox, description);
        driver.hideKeyboard();
        commonFunctions.clickElement(saveAndReviewButton);

        isResult= commonFunctions.isElementDisplayed(addNewLotButton, 10);
        commonFunctions.clickElement(nextButton);
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
            if(commonFunctions.clickElement(photoGalleryLink)){ //cameraRollButton
                if(commonFunctions.clickElement(firstImage)){
                    isResult=commonFunctions.clickElement(continueButtonFileUploadWindow);
                }
            }
        }
        return isResult;
    }

    
    public boolean verifyAttachments() {
        boolean isResult=false;
//        if(commonFunctions.isElementDisplayed(imagePreviewAttachmentsTab)){
//            if(commonFunctions.clickElement(nextButton)){
//                isResult=commonFunctions.isElementDisplayed(notesTextField);
//            }
//        }

        if(commonFunctions.clickElement(nextButton)){
            isResult=commonFunctions.isElementDisplayed(notesTextField);
        }
        return isResult;
    }

    
    public boolean addNotes(String note) {
        commonFunctions.sendKey(notesTextField, note);
        commonFunctions.clickElement(sendIconNotes);
        return commonFunctions.clickElement(sendIconNotes);
    }

    
    public boolean verifyNotes(String note) {
        boolean isResult=false;
        String notesTextXpath="//XCUIElementTypeStaticText[@value='"+note+"']";
        commonFunctions.isElementDisplayedByXpath(notesTextXpath);
        isResult=commonFunctions.clickElement(validateAndSignContractButton);
            try{
                Thread.sleep(15000);
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        return isResult;
    }

    public boolean fillSalesInformation(String month, int day, int year, String salesType, String branchName){
        boolean isResult=false;
        String branchNameXpath="//XCUIElementTypeStaticText[@name='"+branchName+"']";

        commonFunctions.clickElement(contractDateDropdown);
        //commonFunctions.selectDateFromDatePicker(dropdownPickers, month, day, year);
        commonFunctions.clickElement(doneButtonWheelPicker);

        commonFunctions.clickElement(salesTypeDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, salesType);
        //commonFunctions.movePickerWheel(dropdownPicker, salesTypeDropdown, salesType);
        commonFunctions.clickElement(doneButtonWheelPicker);

        if(commonFunctions.clickElement(branchSearchButton)) {
//            commonFunctions.sendKey(searchTextBoxPopupWindowBranch, branchName);
//            commonFunctions.clickElementByXpath(branchNameXpath);
        }
        if(commonFunctions.clickElement(nextButton)){
            isResult=commonFunctions.isElementDisplayed(vendorInfoTextbox, 15);
        }
        return isResult;
    }
    
}
