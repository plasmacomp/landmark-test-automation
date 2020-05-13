package pages_web;

import generic_pages.CommonLoginPage;
import logger.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.Utils;


public class LoginPage extends CommonLoginPage
{
    private WebDriver webDriver;
    static CommonFunctions commonFunctions=null;
    private static LoginPage loginPage;

    public LoginPage() {
        this.webDriver = globalVars.getWebDriver();
        PageFactory.initElements(webDriver, this);
        commonFunctions=CommonFunctions.getInstance();
    }
    public static LoginPage getLoginPageInstance(){
        if(loginPage==null){
            loginPage=new LoginPage();
        }
        return loginPage;
    }


    @FindBy(xpath = "//input[@placeholder='Account number' and @data-testid]")
    private static WebElement accountTextbox;
    @FindBy(xpath = "//input[@placeholder='Password' and @data-testid]")
    private static WebElement passwordTextbox;
    @FindBy(xpath = "//button[contains(@class,'login')]//tab-t[text()='Login']")
    private static WebElement loginBtnHomePage;
    @FindBy(xpath = "//button[contains(@class,'_')]//tab-t[text()='Login']")
    private static WebElement loginBtnPopup;


    @Override
    public boolean login(String username, String password) {
        boolean isUserLoggedIn=false;
        logger.info("*************login method started *************");
        try {
            if(commonFunctions.clickElement(loginBtnHomePage, 5)){
                Thread.sleep(500);
                commonFunctions.sendKey(accountTextbox, username, 5);
                Thread.sleep(500);
                commonFunctions.sendKey(passwordTextbox, password, 5);
                Thread.sleep(500);
                isUserLoggedIn=commonFunctions.clickElement(loginBtnPopup, 5);
                Thread.sleep(6000);
            }
            Utils.logFunctionLevelLogs(isUserLoggedIn, "Login"+ globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in Login method"+e.getMessage());
            e.printStackTrace();
        }
        logger.info("*************login method ended *************");
        return isUserLoggedIn;
    }

    @Override
    public boolean logout() {
        boolean isUserLoggedOut=false;
        try {
            Utils.logFunctionLevelLogs(isUserLoggedOut, "verifyHomePagePostLogin"+ globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in verifyHomePagePostLogin method"+e.getMessage());
            e.printStackTrace();
        }
        return isUserLoggedOut;
    }
}

