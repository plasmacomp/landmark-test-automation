package pages_android;

import generic_pages.CommonDashboardPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;


public class DashboardPage extends CommonDashboardPage
{
    private AppiumDriver driver;
    static CommonFunctions commonFunctions=null;
    private static DashboardPage homePage;

    @AndroidFindBy(xpath = "//input[@placeholder='Account number' and @data-testid]")
    private static WebElement accountTextbox;
    @AndroidFindBy(xpath = "//input[@placeholder='Password' and @data-testid]")
    private static WebElement passwordTextbox;
    @AndroidFindBy(xpath = "//button[contains(@class,'login')]//tab-t[text()='Login']")
    private static WebElement loginBtnHomePage;
    @AndroidFindBy(xpath = "//button[contains(@class,'_')]//tab-t[text()='Login']")
    private static WebElement loginBtnPopup;


    public DashboardPage() {
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctions.getInstance();
    }
    public static DashboardPage getHomePageInstance(){
        if(homePage==null){
            homePage=new DashboardPage();
        }
        return homePage;
    }

    @Override
    public boolean verifyDashBoardElements() {
        return false;
    }

    @Override
    public boolean verifyNewOpportunity() {
        return false;
    }

    @Override
    public boolean verifyOpportunities() {
        return false;
    }

    @Override
    public boolean verifyNewContact() {
        return false;
    }

    @Override
    public boolean verifyContacts() {
        return false;
    }

    @Override
    public boolean verifySearch() {
        return false;
    }

}


