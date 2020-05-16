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

    @iOSXCUITFindBy(accessibility = "menu")
    private static WebElement hamburgerIcon;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Dashboard']")
    private static WebElement dashboardLabel;
    @iOSXCUITFindBy(accessibility = "notification")
    private static WebElement notificationIcon;
    @iOSXCUITFindBy(accessibility = "profile")
    private static WebElement userIcon;
    @iOSXCUITFindBy(accessibility = "new opportunity")
    private static WebElement newOpportunityTile;
    @iOSXCUITFindBy(accessibility = "opportunities")
    private static WebElement opportunitiesTile;
    @iOSXCUITFindBy(accessibility = "new contract")
    private static WebElement newContractTile;
    @iOSXCUITFindBy(accessibility = "contracts")
    private static WebElement contractsTile;
    @iOSXCUITFindBy(accessibility = "client search")
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
    public boolean verifyNewOpportunity() {
        return commonFunctions.isElementDisplayed(newOpportunityTile, 15);
    }

    @Override
    public boolean verifyOpportunities() {
        return commonFunctions.isElementDisplayed(newOpportunityTile, 15);
    }

    @Override
    public boolean verifyNewContract() {
        return commonFunctions.isElementDisplayed(newOpportunityTile, 15);
    }

    @Override
    public boolean verifyContracts() {
        return commonFunctions.isElementDisplayed(newOpportunityTile, 15);
    }

    @Override
    public boolean verifySearch() {
        return commonFunctions.isElementDisplayed(newOpportunityTile, 15);
    }

    @Override
    public boolean verifyHamburger() {
        return commonFunctions.isElementDisplayed(hamburgerIcon, 15);
    }

    @Override
    public boolean verifyDashboardHeaderLabel() {
        return commonFunctions.isElementDisplayed(dashboardLabel, 15);
    }

    @Override
    public boolean verifyProfileIcon() {
        return commonFunctions.isElementDisplayed(userIcon, 15);
    }
}

