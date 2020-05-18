package pages_web;

import generic_pages.CommonNewOpportunityPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

import java.util.List;

public class NewOpportunityPage extends CommonNewOpportunityPage {
    private WebDriver webDriver;
    static CommonFunctions commonFunctions=null;
    private static NewOpportunityPage newOpportunityPage;

    @FindBy(className = "icon-hamburger-menu")
    private static WebElement menuToggle;
    @FindBy(xpath = "//div[contains(@class,'menu-item-racing')]")
    private static WebElement racingMenu;
    @FindBy(xpath = "(//span[@class='link-label' and contains(text(),'Racing')])[1]")
    private static WebElement todaysRacingSubMenu;
    @FindBy(xpath = "//a[contains(@class,'race-wrapper')]")
    private static List<WebElement> raceList;
    @FindBy(xpath = "(//div[contains(@class,'animate-field')])[1]")
    private static WebElement winPlace;
    @FindBy(xpath = "//button[contains(text(),'Bet Now')]")
    private static WebElement betNowBtn;




    public NewOpportunityPage() {
        webDriver = globalVars.getWebDriver();
        PageFactory.initElements(webDriver, this);
        commonFunctions=CommonFunctions.getInstance();
    }
    public static NewOpportunityPage getInstance(){
        if(newOpportunityPage==null){
            newOpportunityPage=new NewOpportunityPage();
        }
        return newOpportunityPage;
    }

    @Override
    public boolean addSalesInformation(String title) {
        return false;
    }

    @Override
    public boolean addVendorInfo() {
        return false;
    }

    @Override
    public boolean addLotsInformation(String quantity, String productCategory, String product, String breed, String priceType, String price, String age1, String age2, String monthDropdown, String description) {
        return false;
    }

    @Override
    public boolean verifyLotSummaryPageHeaderLabels() {
        return false;
    }

    @Override
    public boolean verifyLotSummaryPageValues(String quantity, String totalWeight, String totalSaleValue) {
        return false;
    }

    @Override
    public boolean addAttachments() {
        return false;
    }

    @Override
    public boolean verifyAttachments() {
        return false;
    }

    @Override
    public boolean addNotes(String note) {
        return false;
    }

    @Override
    public boolean verifyNotes(String note) {
        return false;
    }

    @Override
    public boolean verifyNewOpportunityHeaderLabel() {
        return false;
    }

    @Override
    public boolean verifySalesInformationLabel() {
        return false;
    }

    @Override
    public boolean verifyVendorInfoLabel() {
        return false;
    }

    @Override
    public boolean verifyLotsLabel() {
        return false;
    }

    @Override
    public boolean verifyNotesLabel() {
        return false;
    }

    @Override
    public boolean verifyAttachmentsLabel() {
        return false;
    }

    @Override
    public boolean verifyNewOpportunityNavigation() {
        return false;
    }
}
