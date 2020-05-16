package pages_ios;

import generic_pages.CommonNewOpportunityPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

public class NewOpportunityPage extends CommonNewOpportunityPage {
    private AppiumDriver driver;
    static CommonFunctions commonFunctions=null;
    private static NewOpportunityPage newOpportunityPage;

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

















    public NewOpportunityPage() {
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctions.getInstance();
    }
    public static NewOpportunityPage getInstance(){
        if(newOpportunityPage ==null){
            newOpportunityPage =new NewOpportunityPage();
        }
        return newOpportunityPage;
    }

    @Override
    public boolean verifyNewOpportunityHeaderLabel() {
        return commonFunctions.isElementDisplayed(newOpportunityHeaderLabel, 15);
    }

    @Override
    public boolean verifySalesInformationLabel() {
        return commonFunctions.isElementDisplayed(salesInformationLabel, 15);
    }

    @Override
    public boolean verifyVendorInfoLabel() {
        return commonFunctions.isElementDisplayed(vendorInfoLabel, 15);
    }

    @Override
    public boolean verifyLotsLabel() {
        return commonFunctions.isElementDisplayed(lotsLabel, 15);
    }

    @Override
    public boolean verifyNotesLabel() {
        return commonFunctions.isElementDisplayed(notesLabel, 15);
    }

    @Override
    public boolean verifyAttachmentsLabel() {
        return commonFunctions.isElementDisplayed(attachmentsLabel, 15);
    }

    @Override
    public boolean verifyNewOpportunityNavigation() {
        return commonFunctions.clickElement(newOpportunityTile, 15);
    }

    @Override
    public boolean createNewOpportunity(String title, String vendorName) {
        commonFunctions.sendKey(titleTextbox, title);
        commonFunctions.clickElement(expectedSaleDateTextbox);
        commonFunctions.clickElement(nextButton);commonFunctions.clickElement(nextButton);
        commonFunctions.clickElement(vendorInfoTextbox);
        commonFunctions.clickElement(vendorInfoPopupWindow);
        commonFunctions.clickElement(nextButton);


        return true;
    }
}
