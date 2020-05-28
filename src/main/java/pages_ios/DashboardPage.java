package pages_ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.aop.framework.adapter.GlobalAdvisorAdapterRegistry;
import utils.CommonFunctions;
import utils.CommonFunctionsMobile;
import utils.GlobalVars;


public class DashboardPage
{
    private AppiumDriver driver;
    static CommonFunctionsMobile commonFunctions=null;
    private static GlobalVars globalVars;
    private static DashboardPage dashboardPage;

    @iOSXCUITFindBy(accessibility = "menu")
    private static WebElement hamburgerIcon;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Dashboard']")
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
        globalVars=GlobalVars.getInstance();
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctionsMobile.getInstance();
    }
    public static DashboardPage getInstance(){
        if(dashboardPage ==null){
            dashboardPage =new DashboardPage();
        }
        return dashboardPage;
    }

    
    public boolean verifyNewOpportunity() {
        return commonFunctions.isElementDisplayed(newOpportunityTile, 15);
    }

    
    public boolean verifyOpportunities() {
        return commonFunctions.isElementDisplayed(opportunitiesTile, 15);
    }

    
    public boolean verifyNewContract() {
        return commonFunctions.isElementDisplayed(newContractTile, 15);
    }

    
    public boolean verifyContracts() {
        return commonFunctions.isElementDisplayed(contractsTile, 15);
    }

    
    public boolean verifySearch() {
        return commonFunctions.isElementDisplayed(searchTile, 15);
    }

    
    public boolean verifyHamburger() {
        return commonFunctions.isElementDisplayed(hamburgerIcon, 15);
    }

    
    public boolean verifyDashboardHeaderLabel() {
        return commonFunctions.isElementDisplayed(dashboardLabel, 15);
    }

    
    public boolean verifyProfileIcon() {
        return commonFunctions.isElementDisplayed(userIcon, 15);
    }
}

