package pages_web;

import generic_pages.CommonDashboardPage;
import logger.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.Constants;
import utils.Utils;

import java.util.List;


public class DashboardPage extends CommonDashboardPage
{
    private WebDriver webDriver;
    static CommonFunctions commonFunctions=null;
    private static DashboardPage homePage;

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




    public DashboardPage() {
        webDriver = globalVars.getWebDriver();
        PageFactory.initElements(webDriver, this);
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

