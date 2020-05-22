package pages_ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.GlobalVars;

public class NewContractPage {
    private AppiumDriver driver;
    static CommonFunctions commonFunctions=null;
    private static GlobalVars globalVars;
    private static NewContractPage newContractPage;
    private String valueXpathLotsSummary="(//XCUIElementTypeStaticText[@value='###'])[1]";


    @iOSXCUITFindBy(accessibility = "new opportunity")
    private static WebElement newOpportunityTile;
    @iOSXCUITFindBy(accessibility = "Sale Information")
    private static WebElement salesInformationLabel;
    @iOSXCUITFindBy(accessibility = "Vendor Info")
    private static WebElement vendorInfoLabel;
    @iOSXCUITFindBy(accessibility = "Lots")
    private static WebElement lotsLabel;
    @iOSXCUITFindBy(accessibility = "Attachments")
    private static WebElement attachmentsLabel;
    @iOSXCUITFindBy(accessibility = "Notes")
    private static WebElement notesLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='New Opportunity']")
    private static WebElement newOpportunityHeaderLabel;
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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private static WebElement vendorInfoTextbox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private static WebElement vendorInfoTextboxPopup;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther")
    private static WebElement vendorInfoPopupWindow;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Vendor *']//following-sibling:: XCUIElementTypeButton")
    private static WebElement vendorName; //to get the name attribute's value for the name of the vendor
    //******Lots page elements**********
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
    private static WebElement quantityTextBox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    private static WebElement dropdownPicker;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[2]")
    private static WebElement productCategoryDropdown;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[3]")
    private static WebElement productDropdown;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[4]")
    private static WebElement breedDropdown;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[5]")
    private static WebElement priceTypeDropdown;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[6]")
    private static WebElement priceGstTextBox;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[7]")
    private static WebElement sexDropdown;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[8]")
    private static WebElement ageTextBox1;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[9]")//****** Index of this drop down to be checked
    private static WebElement ageTextBox2;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[10]")
    private static WebElement monthsDropdown;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView")
    private static WebElement descriptionTextBox;
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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add new Lot']")
    private static WebElement addNewLotButton;

    //********* Attachments elements ************
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Upload Attachments']")
    private static WebElement uploadAttachtmentsButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Browse Files']")
    private static WebElement browseFilesButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Camera Roll']")
    private static WebElement cameraRollButton;
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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit & View Record']")
    private static WebElement submitAndViewRecordButton;




    public NewContractPage() {
        globalVars=GlobalVars.getInstance();
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctions.getInstance();
        
    }
    public static NewContractPage getInstance(){
        if(newContractPage ==null){
            newContractPage =new NewContractPage();
        }
        return newContractPage;
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
        commonFunctions.clickElement(nextButton);commonFunctions.clickElement(nextButton);
        return commonFunctions.isElementDisplayed(vendorInfoTextbox);
    }

    
    public boolean addVendorInfo() {
        commonFunctions.clickElement(vendorInfoTextbox);
        commonFunctions.clickElement(vendorInfoPopupWindow);
        commonFunctions.clickElement(nextButton);
        return commonFunctions.isElementDisplayed(quantityTextBox);
    }

    
    public boolean addLotsInformation(String quantity, String productCategory, String product, String breed, String priceType, String price, String age1, String age2, String monthDropdown, String description) {
        commonFunctions.sendKey(quantityTextBox, quantity);
        commonFunctions.clickElement(productCategoryDropdown);
        commonFunctions.sendKey(dropdownPicker, productCategory);
        commonFunctions.clickElement(productDropdown);
        commonFunctions.sendKey(dropdownPicker, product);
        commonFunctions.clickElement(breedDropdown);
        commonFunctions.sendKey(dropdownPicker, breed);
        commonFunctions.clickElement(priceTypeDropdown);
        commonFunctions.sendKey(dropdownPicker, priceType);
        commonFunctions.sendKey(priceGstTextBox, price);
        commonFunctions.sendKey(ageTextBox1, age1);
        commonFunctions.sendKey(ageTextBox2, age2);
        commonFunctions.clickElement(monthsDropdown);
        commonFunctions.sendKey(dropdownPicker, monthDropdown);
        commonFunctions.sendKey(descriptionTextBox, description);
        commonFunctions.clickElement(saveAndReviewButton);
        return commonFunctions.isElementDisplayed(addNewLotButton);

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
            if(commonFunctions.clickElement(cameraRollButton)){
                if(commonFunctions.clickElement(firstImage)){
                    isResult=commonFunctions.clickElement(continueButtonFileUploadWindow);
                }
            }
        }
        return isResult;
    }

    
    public boolean verifyAttachments() {
        boolean isResult=false;
        if(commonFunctions.isElementDisplayed(imagePreviewAttachmentsTab)){
            if(commonFunctions.clickElement(nextButton)){
                isResult=commonFunctions.isElementDisplayed(notesTextField);
            }
        }
        return isResult;
    }

    
    public boolean addNotes(String note) {
        commonFunctions.sendKey(notesTextField, note);
        return commonFunctions.clickElement(sendIconNotes);
    }

    
    public boolean verifyNotes(String note) {
        boolean isResult=false;
        String notesTextXpath="//XCUIElementTypeStaticText[@value='"+note+"']";
        if(commonFunctions.isElementDisplayedByXpath(notesTextXpath)){
            isResult=commonFunctions.clickElement(submitAndViewRecordButton);
        }
        return isResult;
    }
    
}
