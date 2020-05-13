package pages_ios;

import generic_pages.CommonDashboardPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;


public class DashboardPage extends CommonDashboardPage
{
    private AppiumDriver driver;
    static CommonFunctions commonFunctions=null;
    private static DashboardPage dashboardPage;

    @iOSXCUITFindBy(xpath = "//input[@placeholder='Account number' and @data-testid]")
    private static WebElement hamburgerIcon;
    @iOSXCUITFindBy(xpath = "//input[@placeholder='Password' and @data-testid]")
    private static WebElement dashboardLabel;
    @iOSXCUITFindBy(xpath = "//button[contains(@class,'login')]//tab-t[text()='Login']")
    private static WebElement notificationIcon;
    @iOSXCUITFindBy(xpath = "//button[contains(@class,'_')]//tab-t[text()='Login']")
    private static WebElement userIcon;
    @iOSXCUITFindBy(xpath = "//button[contains(@class,'_')]//tab-t[text()='Login']")
    private static WebElement newOpportunityTile;
    @iOSXCUITFindBy(xpath = "//button[contains(@class,'_')]//tab-t[text()='Login']")
    private static WebElement opportunitiesTile;
    @iOSXCUITFindBy(xpath = "//button[contains(@class,'_')]//tab-t[text()='Login']")
    private static WebElement newContactTile;
    @iOSXCUITFindBy(xpath = "//button[contains(@class,'_')]//tab-t[text()='Login']")
    private static WebElement contactsTile;
    @iOSXCUITFindBy(xpath = "//button[contains(@class,'_')]//tab-t[text()='Login']")
    private static WebElement searchTile;




    public DashboardPage() {
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctions.getInstance();
    }
    public static DashboardPage getHomePageInstance(){
        if(dashboardPage ==null){
            dashboardPage =new DashboardPage();
        }
        return dashboardPage;
    }

    @Override
    public boolean verifyDashBoardElements() {

        return false;

    }

    @Override
    public boolean verifyNewOpportunity() {
        return commonFunctions.isElementDisplayed(newOpportunityTile, 15);
    }

    @Override
    public boolean verifyOpportunities() {
        return commonFunctions.isElementDisplayed(newOpportunityTile, 15);
    }

    @Override
    public boolean verifyNewContact() {
        return commonFunctions.isElementDisplayed(newOpportunityTile, 15);
    }

    @Override
    public boolean verifyContacts() {
        return commonFunctions.isElementDisplayed(newOpportunityTile, 15);
    }

    @Override
    public boolean verifySearch() {
        return commonFunctions.isElementDisplayed(newOpportunityTile, 15);
    }

}

