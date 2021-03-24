package pages_ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.CommonFunctionsMobile;
import utils.GlobalVars;
import utils.Utils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.HashMap;
import java.util.List;

public class NewOpportunityPage {
    private AppiumDriver driver;
    //static CommonFunctions commonFunctions=null;
    static CommonFunctionsMobile commonFunctions=null;
    private static GlobalVars globalVars;
    private static NewOpportunityPage newOpportunityPage;
    private String valueXpathLotsSummary="(//XCUIElementTypeStaticText[@value='###'])[1]";


    @iOSXCUITFindBy(accessibility = "new opportunity")
    private static MobileElement newOpportunityTile;
    @iOSXCUITFindBy(accessibility = "Sale Information")
    private static MobileElement salesInformationLabel;
    @iOSXCUITFindBy(accessibility = "Vendor Information")
    private static MobileElement vendorInfoLabel;
    @iOSXCUITFindBy(accessibility = "Lots")
    private static MobileElement lotsLabel;
    @iOSXCUITFindBy(accessibility = "Attachments")
    private static MobileElement attachmentsLabel;
    @iOSXCUITFindBy(accessibility = "Notes")
    private static MobileElement notesLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='New Opportunity']")
    private static MobileElement newOpportunityHeaderLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
    private static MobileElement doneButton;
    @iOSXCUITFindBy(accessibility = "lmkopesdmotitle") //*** //XCUIElementTypeStaticText[@value='Title *']//preceding-sibling::XCUIElementTypeTextField
    private static MobileElement titleTextbox;
    @iOSXCUITFindBy(accessibility = "lmkoppdmoexpsldt") //****//XCUIElementTypeStaticText[@value='Expected Sale Date ']//preceding-sibling::XCUIElementTypeTextField
    private static MobileElement expectedSaleDateTextbox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
    private static MobileElement nextButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
    private static MobileElement cancelButton;
    @iOSXCUITFindBy(accessibility = "Delete")
    private static MobileElement deleteButtonPopup;
    @iOSXCUITFindBy(accessibility = "Cancel")
    private static MobileElement cancelButtonPopup;
    @iOSXCUITFindBy(accessibility = "LMSearchInputViewCell-button-tap-to-search") //lmkopecesdmovendor## //XCUIElementTypeTextField
    private static MobileElement vendorInfoTextbox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private static MobileElement vendorInfoTextboxPopup;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther")
    private static MobileElement vendorInfoPopupWindow;
    @iOSXCUITFindBy(accessibility = "Customer-SearchBar-0") ////XCUIElementTypeTextField      // ***** Till build-167 //XCUIElementTypeSearchField
    private static MobileElement vendorInfoSearchBoxPopupWindow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Vendor *']//following-sibling:: XCUIElementTypeButton")
    private static MobileElement vendorName; //to get the name attribute's value for the name of the vendor
    //******Lots page elements**********
    @iOSXCUITFindBy(accessibility = "Paste")
    private static MobileElement pasteIconWheelPicker;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Done'])[2]")
    private static MobileElement doneButtonWheelPicker;

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
    @iOSXCUITFindBy(accessibility = "lmkoeelotdmotweight") //(//XCUIElementTypeTextField)[6]
    private static MobileElement totalWeightTextField;
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
    private static MobileElement photoGalleryButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]")
    private static MobileElement firstImage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButtonFileUploadWindow;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage)[6]")
    private static MobileElement imagePreviewAttachmentsTab;
    @iOSXCUITFindBy(accessibility = "attachment options") //(//XCUIElementTypeCell)[6]/*[5]
    private static MobileElement tripleDotImagePreview;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Browse']")
    private static MobileElement browseButton;

    //******** Notes tab elements ***************
    @iOSXCUITFindBy(accessibility = "add")
    private static MobileElement plusIconNotes;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView")
    private static MobileElement notesTextField;
    @iOSXCUITFindBy(accessibility = "send")
    private static MobileElement sendIconNotes;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit & View Record']")
    private static MobileElement submitAndViewRecordButton;
    @iOSXCUITFindBy(accessibility = "Hide keyboard")
    private static IOSElement hideKeyboardButton;



    public NewOpportunityPage() {
        globalVars=GlobalVars.getInstance();
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        //commonFunctions=CommonFunctions.getInstance();
        commonFunctions=CommonFunctionsMobile.getInstance();
    }
    public static NewOpportunityPage getInstance(){
        if(newOpportunityPage ==null){
            newOpportunityPage =new NewOpportunityPage();
        }
        return newOpportunityPage;
    }

    
    public boolean verifyNewOpportunityHeaderLabel() {
        return commonFunctions.isElementDisplayed(newOpportunityHeaderLabel, 15);
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

    
    public boolean verifyNewOpportunityNavigation() {
        return commonFunctions.clickElement(newOpportunityTile, 15);
    }

    
    public boolean addSalesInformation(String title) {
        commonFunctions.sendKey(titleTextbox, title);
        commonFunctions.clickElement(expectedSaleDateTextbox);
        commonFunctions.clickElement(nextButton);
        //commonFunctions.selectDateBySendingKeysToDropDown(dropdownPickers, month, day, year);
        commonFunctions.clickElement(nextButton);
        return commonFunctions.isElementDisplayed(vendorInfoTextbox);
    }

    
    public boolean addVendorInfo(String searchText) {
        boolean isResult=false;

        if(commonFunctions.clickElement(vendorInfoTextbox)) {

            commonFunctions.clickElement(vendorInfoSearchBoxPopupWindow);
            commonFunctions.sendKeyWithActions(vendorInfoSearchBoxPopupWindow, searchText);

            if(commonFunctions.clickElementByAccessibilityId("Trading Name: " + searchText)) {

                if (commonFunctions.clickElement(nextButton, 20)) {
                    isResult = commonFunctions.isElementDisplayed(quantityTextBox, 15);
                }
            }
        }
        return isResult;
    }

    public boolean addVendorInfoForClassified(String searchText) {
        boolean isResult=false;

        if(commonFunctions.clickElement(vendorInfoTextbox)) {

            commonFunctions.clickElement(vendorInfoSearchBoxPopupWindow);

            commonFunctions.sendKeyWithActionsWithWait(vendorInfoSearchBoxPopupWindow, searchText);
            if(commonFunctions.clickElementByAccessibilityId("Trading Name: " + searchText)) {

                if (commonFunctions.clickElement(nextButton, 20)) {
                    isResult = commonFunctions.isElementDisplayed(quantityTextBox, 15);
                }
            }
        }
        return isResult;
    }

//    public boolean addLotsInformation(String quantity, String productCategory, String product, String breed, String priceType, String price, String age1, String age2, String monthDropdown, String description) {
//        boolean isResult=false;
//        commonFunctions.sendKey(quantityTextBox, quantity);
//
//        commonFunctions.clickElement(productCategoryDropdown);
//        movePickerWheel(productCategoryDropdown, productCategory);
//
//        commonFunctions.clickElement(productDropdown);
//        movePickerWheel(productDropdown, product);
//
//        commonFunctions.clickElement(breedDropdown);
//        movePickerWheel(breedDropdown, breed);
//        commonFunctions.clickElement(doneButtonWheelPicker);
//
//        commonFunctions.clickElement(priceTypeDropdown);
//        movePickerWheel(priceTypeDropdown, priceType);
//
//        commonFunctions.sendKey(priceGstTextBox, price);
//        //commonFunctions.scrollDownToElement(ageTextBox1);
//        driver.hideKeyboard();
//        commonFunctions.sendKey(ageTextBox1, age1);
//        driver.hideKeyboard();
//        commonFunctions.sendKey(ageTextBox2, age2);
//        driver.hideKeyboard();
//
//        commonFunctions.clickElement(monthsDropdown);
//        commonFunctions.clickElement(doneButtonWheelPicker);
//        movePickerWheelMonthDropdown(monthsDropdown, monthDropdown);
//
//        commonFunctions.sendKey(descriptionTextBox, description);
//        driver.hideKeyboard();
//        commonFunctions.clickElement(saveAndReviewButton);
//        isResult= commonFunctions.isElementDisplayed(addNewLotButton, 10);
//        return isResult;
//
//    }

    public boolean addLotsInformation(String quantity, String productCategory, String product, String breed, String priceType, String price, String age1, String age2, String monthDropdown, String description) {
        boolean isResult=false;

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
        commonFunctions.clickElement(hideKeyboardButton);
        //driver.hideKeyboard();
        commonFunctions.clickElement(saveAndReviewButton, 10);
//        if(commonFunctions.clickElement(nextButton, 10)) {
//            commonFunctions.clickElement(saveAndReviewButton, 10);
//        }

        isResult= commonFunctions.isElementDisplayed(addNewLotButton, 10);
        //commonFunctions.clickElement(nextButton);
        return isResult;

    }

    private void movePickerWheel(MobileElement element, String val){
        for(int i=0; i<10; i++) {

            //String pickerValue=dropdownPicker.getAttribute("value");
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

    private void movePickerWheelMonthDropdown(MobileElement element, String val){
        for(int i=0; i<2; i++) {
            //String pickerValue=dropdownPicker.getAttribute("value");
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

    private void pickerWheelStep(RemoteWebElement element, String direction, double offset) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("order", direction);
        params.put("offset", offset);
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: selectPickerWheelValue", params);
    }

    public static void copyStringToClipboard(String text){
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    
    public boolean verifyLotSummaryPageHeaderLabels() {
        return (commonFunctions.isElementDisplayed(totalQuantityLabel) && commonFunctions.isElementDisplayed(totalWeightLabel) && commonFunctions.isElementDisplayed(totalSaleValueLabel));
    }

    
    public boolean verifyLotSummaryPageValues(String quantity, String totalWeight, String totalSaleValue) {
        boolean isResult=false;
        isResult= commonFunctions.isElementDisplayedByXpath(valueXpathLotsSummary.replace("###",quantity)) &&
                commonFunctions.isElementDisplayedByXpath(valueXpathLotsSummary.replace("###",totalWeight)) &&
                commonFunctions.isElementDisplayedByXpath(valueXpathLotsSummary.replace("###",totalSaleValue));
        commonFunctions.clickElement(nextButton);
        return isResult;
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

        //****************Commented the above code block as the new build 169 has changes in photo list so currently there's no locator for photos
        return isResult;
    }

    public boolean verifyAttachments() {
        boolean isResult1=false;
        boolean isResult2=false;
        isResult1= commonFunctions.isElementDisplayed(tripleDotImagePreview);
        if(commonFunctions.clickElement(nextButton)){
            isResult2=commonFunctions.isElementDisplayed(notesTextField, 10);
        }
        return isResult1;
    }

    public boolean addNotes(String note) {
        boolean isResult;
        commonFunctions.clickElement(notesTextField);
        commonFunctions.sendKey(notesTextField, note);
        commonFunctions.clickElement(sendIconNotes);
        isResult= commonFunctions.clickElement(sendIconNotes);
        return isResult;
    }

    public boolean verifyNotes(String note) {
        boolean isResult=false;
        //String notesTextXpath="//XCUIElementTypeStaticText[@value='"+note+"']";
        String notesTextXpath="//XCUIElementTypeStaticText[contains(@value,'"+note+"')]";

        isResult=commonFunctions.isElementDisplayedByXpath(notesTextXpath);
        commonFunctions.clickElement(submitAndViewRecordButton);
        return isResult;
    }

    public boolean addLotsInformationOnlyMandatoryFields(String quantity, String productCategory, String product, String breed) {
        boolean isResult=false;
        commonFunctions.sendKey(quantityTextBox, quantity);

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

        //driver.hideKeyboard();
        commonFunctions.clickElement(hideKeyboardButton, 10);
        commonFunctions.clickElement(saveAndReviewButton);

        isResult= commonFunctions.isElementDisplayed(addNewLotButton, 10);
        commonFunctions.clickElement(nextButton);
        return isResult;

    }
    public boolean addLotsInformationTwice(String quantity, String productCategory, String product, String breed, String priceType, String price, String age1, String age2, String monthDropdown, String description) {
        boolean isResult=false;
        String quantity2="15";
        String productCategory2="Sheep";
        String product2="Ewe";
        String breed2="Bond";
        String price2="900";

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
        commonFunctions.clickElement(addNewLotButton);


        isResult= commonFunctions.isElementDisplayed(addNewLotButton, 10);
        commonFunctions.clickElement(nextButton);
        return isResult;

    }
    public boolean selectPerKgInPriceTypeDropDown(String quantity, String productCategory, String product, String breed) {
        String priceType="c/kg";
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
        isResult=commonFunctions.isElementDisplayed(totalWeightTextField, 10);
        return isResult;

    }
    public boolean addValueToPerKgWeightField(String weight) {
        boolean isResult=false;
        commonFunctions.sendKey(totalWeightTextField, weight);
        driver.hideKeyboard();
        isResult=totalWeightTextField.getAttribute("value").trim().equalsIgnoreCase(weight);
        commonFunctions.clickElement(saveAndReviewButton);
        return isResult;

    }

    public boolean addAnotherLotWithExistingLot(String quantity, String productCategory, String product, String breed) {
        boolean isResult=false;
        if(commonFunctions.clickElement(addNewLotButton)){
            isResult=addLotsInformationOnlyMandatoryFields(quantity, productCategory, product, breed);
        }
        return isResult;

    }
    public boolean SubmitAndViewRecord() {
        boolean isResult=false;
        commonFunctions.clickElement(nextButton);
        isResult=commonFunctions.clickElement(submitAndViewRecordButton);
        return isResult;
    }
    public boolean editLotInfo(String newBreed) {
        boolean isResult=false;
        commonFunctions.clickElement(breedDropdown);
        commonFunctions.sendKeyToDropDown(dropdownPicker, newBreed);
        commonFunctions.clickElement(doneButton);
        isResult=commonFunctions.getElementText(breedDropdown, 10).trim().equalsIgnoreCase(newBreed);
        commonFunctions.clickElement(saveAndReviewButton);
        return isResult;
    }
    public boolean verifyWeightValueOnLotGridPage(String totalWeight) {
        boolean isResult=false;
//        String value="";
//        value=commonFunctions.getElementTextByXpath(valueXpathLotsSummary.replace("###",totalWeight), 10);
        isResult= commonFunctions.isElementDisplayedByXpath(valueXpathLotsSummary.replace("###",totalWeight));
        return isResult;
    }
}
