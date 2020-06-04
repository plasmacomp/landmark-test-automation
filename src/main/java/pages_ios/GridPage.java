package pages_ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.aop.framework.adapter.GlobalAdvisorAdapterRegistry;
import utils.CommonFunctionsMobile;
import utils.GlobalVars;

public class GridPage {
    private static GridPage gridPage;
    private AppiumDriver driver;
    static CommonFunctionsMobile commonFunctions=null;
    private static GlobalVars globalVars;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    private static WebElement dropdownPicker;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Done'])[2]")
    private static WebElement doneButtonWheelPicker;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Actions']")
    private static WebElement actionButtonListingInfoPage;
    @iOSXCUITFindBy(accessibility = "New Contract")
    private static WebElement newContractLink;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Vendor Name']//following-sibling::XCUIElementTypeStaticText[1]")
    private static WebElement recordIdText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Contract Date *']//preceding-sibling:: XCUIElementTypeTextField")
    private static WebElement contractDateDropdown;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sale Type *']//preceding-sibling:: XCUIElementTypeTextField")
    private static WebElement salesTypeDropdown;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=' Branch *']//following-sibling:: XCUIElementTypeButton")
    private static WebElement branchSearchButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private static WebElement searchTextBoxPopupWindowBranch;
    @iOSXCUITFindBy(accessibility = "Buyer Info")
    private static WebElement buyerInfoHeaderLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Buyer *']//following-sibling::XCUIElementTypeButton")
    private static WebElement buyerInfoSearchButton;
    @iOSXCUITFindBy(accessibility = "Delivery")
    private static WebElement deliveryHeaderLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Horn Status *']//preceding-sibling:: XCUIElementTypeTextField")
    private static WebElement hornStatusDropdown;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Delivery Point *']//preceding-sibling:: XCUIElementTypeTextField")
    private static WebElement deliveryPointTextField;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Est. Final Delivery Date *']//following-sibling:: XCUIElementTypeTextField")
    private static WebElement estimatedFinalDeliveryDateDropdown;
    @iOSXCUITFindBy(accessibility = "Submit")
    private static WebElement submitLink;






    public GridPage() {
        globalVars= GlobalVars.getInstance();
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions= CommonFunctionsMobile.getInstance();

    }
    public static GridPage getInstance(){
        if(gridPage ==null){
            gridPage =new GridPage();
        }
        return gridPage;
    }

    public boolean goToOpportunityIdFromGrid(String oppId){
        //return commonFunctions.clickElementByAccessibilityId(oppId);
        return true;
    }

    public boolean goToNewContractFromListingPage(){
        boolean isResult=false;
        if(commonFunctions.clickElement(actionButtonListingInfoPage)){
            isResult=commonFunctions.clickElement(newContractLink);
        }
        return isResult;
    }

    public boolean fillContractDetailsFromListingPage(String oppId, String salesType, String branchName, String buyerName, String deliveryPoint){
        boolean isResult=false;
        String recordIdXpath="//*[@value='"+oppId+"']";
        String branchNameXpath="//XCUIElementTypeStaticText[@name='"+branchName+"']";
        String buyerhNameXpath="//XCUIElementTypeStaticText[@name='"+buyerName+"']";

//        if(commonFunctions.clickElementByXpath(recordIdXpath)){
//        }

        commonFunctions.clickElementByXpath(recordIdXpath);
        commonFunctions.clickElement(contractDateDropdown);
        commonFunctions.clickElement(doneButtonWheelPicker);
        commonFunctions.clickElement(salesTypeDropdown);
        commonFunctions.movePickerWheel(dropdownPicker, salesTypeDropdown, salesType);
        commonFunctions.clickElement(doneButtonWheelPicker);

        if(commonFunctions.clickElement(branchSearchButton)) {
            commonFunctions.sendKey(searchTextBoxPopupWindowBranch, branchName);
            commonFunctions.clickElementByXpath(branchNameXpath);
        }

        if(commonFunctions.clickElement(buyerInfoHeaderLabel)){
            commonFunctions.clickElement(buyerInfoSearchButton);
            commonFunctions.sendKey(searchTextBoxPopupWindowBranch, buyerName, 15);
            commonFunctions.clickElementByXpath(buyerhNameXpath);
        }

        if(commonFunctions.clickElement(deliveryHeaderLabel)){
            commonFunctions.sendKey(deliveryPointTextField, deliveryPoint);
            commonFunctions.clickElement(estimatedFinalDeliveryDateDropdown);
            commonFunctions.clickElement(doneButtonWheelPicker);
        }

        if(commonFunctions.clickElement(actionButtonListingInfoPage)){
            isResult=commonFunctions.clickElement(submitLink);
            try{
                Thread.sleep(10000);
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        return isResult;
    }



}
