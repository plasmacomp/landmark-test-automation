package pages_ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HasOnScreenKeyboard;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.GlobalVars;
import utils.Utils;

//import io.appium.java_client.android.AndroidKeyCode;

public class LoginPage
{
    //private AndroidDriver<AndroidElement> driver;
    private  AppiumDriver driver;
    static CommonFunctions oCommonFunctions=null;
    public LoginPage() {
    }
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        oCommonFunctions=new CommonFunctions();

    }


    @iOSXCUITFindBy(accessibility = "Get Started")
    private static IOSElement getStartedButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Investor Login')]")
    private static IOSElement investorLoginElement;
    @iOSXCUITFindBy(xpath = "//*[@value='User ID']")
    private static IOSElement userIdElement;
    @iOSXCUITFindBy(xpath="//*[@value='Password']")
    private static IOSElement passwordElement;
    @iOSXCUITFindBy( xpath= "//*[@name='Login']")
    private static IOSElement loginElement;
    @iOSXCUITFindBy(id = "com.hdfcfund.investor.uat:id/tv_skip")
    private static IOSElement skipButton;
    @iOSXCUITFindBy(id = "com.hdfcfund.investor.uat:id/ll_home_1")
    private static IOSElement portFolio;
    @iOSXCUITFindBy(id = "com.hdfcfund.investor.uat:id/iv_header_logo")
    private static IOSElement drawerIcon;
    @iOSXCUITFindBy(xpath = "//*[@resource-id='com.hdfcfund.investor.uat:id/design_menu_item_text' and @text='Logout']")
    private static IOSElement logOut;
    @iOSXCUITFindBy(id = "com.hdfcfund.investor.uat:id/btn_yes")
    private static IOSElement yesBtnLogoutPopup;



    public boolean isDisplayed() {
        return loginElement.isDisplayed();
    }

    public  void hideKeyboardIfVisible() {
    	boolean isKeyboardShown = ((HasOnScreenKeyboard) driver).isKeyboardShown();
        if ( isKeyboardShown ==true){
        	driver.hideKeyboard();
       }
        }
    
    public boolean login(String username, String password) {
        boolean isUserLoggedIn=false;
        try {
        	oCommonFunctions.clickElement(getStartedButton, 20);
            oCommonFunctions.clickElement(investorLoginElement, 20);
            oCommonFunctions.sendKey(userIdElement, username, 5);
            oCommonFunctions.sendKey(passwordElement, password, 5);
            hideKeyboardIfVisible();
            oCommonFunctions.clickElement(loginElement, 20);
           // isUserLoggedIn=oCommonFunctions.clickElement(skipButton, 20);
            Utils.logFunctionLevelLogs(isUserLoggedIn, "Login"+ GlobalVars.platform);
        } catch (Exception e) {
            Log.error("Exception occurred in Login method"+e.getMessage());
            e.printStackTrace();
        }
        return isUserLoggedIn;
        //hideKeyboardIfVisible();
    }

    public boolean verifyHomePagePostLogin() {
        boolean isUserLoggedIn=false;
        try {
            isUserLoggedIn=oCommonFunctions.isElementDisplayed(portFolio, 20);
            Thread.sleep(4000);
            Utils.logFunctionLevelLogs(isUserLoggedIn, "verifyHomePagePostLogin"+ GlobalVars.platform);
        } catch (Exception e) {
            Log.error("Exception occurred in Login method"+e.getMessage());
            e.printStackTrace();
        }
        return isUserLoggedIn;
    }

    public boolean logout() {
        boolean isUserLoggedOut=false;
        try {
            if(oCommonFunctions.clickElement(drawerIcon, 20)){
                if(oCommonFunctions.clickElement(logOut, 5)){
                    isUserLoggedOut=oCommonFunctions.clickElement(yesBtnLogoutPopup, 5);
                }
                Thread.sleep(5000);
            }
            Utils.logFunctionLevelLogs(isUserLoggedOut, "verifyHomePagePostLogin"+ GlobalVars.platform);
        } catch (Exception e) {
            Log.error("Exception occurred in Login method"+e.getMessage());
            e.printStackTrace();
        }
        return isUserLoggedOut;
    }
}

