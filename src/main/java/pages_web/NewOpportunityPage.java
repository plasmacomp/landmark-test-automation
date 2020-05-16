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
    public boolean verifyDashBoardElements() {
        return false;
    }
}
