package pages_android;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.GlobalVars;
import utils.Utils;

public class LoginPage
{
    //private AndroidDriver<AndroidElement> driver;
    private AppiumDriver driver;
    static CommonFunctions oCommonFunctions=null;
    public LoginPage() {
    }
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        oCommonFunctions=new CommonFunctions();

    }


    ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.Button
    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='Investor Login']")
    private static AndroidElement investorLoginElement;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/et_username")
    private static AndroidElement userIdElement;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/et_password")
    private static AndroidElement passwordElement;
    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='Login']")
    private static AndroidElement loginElement;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/tv_skip")
    private static AndroidElement skipButton;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/ll_home_1")
    private static AndroidElement portFolio;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/iv_header_logo")
    private static AndroidElement drawerIcon;
    @AndroidFindBy(xpath = "//*[@resource-id='com.hdfcfund.investor.uat:id/design_menu_item_text' and @text='Logout']")
    private static AndroidElement logOut;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/btn_yes")
    private static AndroidElement yesBtnLogoutPopup;



    public boolean isDisplayed() {
        return loginElement.isDisplayed();
    }

    public void hideKeyboardIfVisible() {
        /*if (keyboard != null) {
           // driver.pressKeyCode(AndroidKeyCode.KEYCODE_ESCAPE);
        }*/
    }
    public boolean login(String username, String password) {
        boolean isUserLoggedIn=false;
        //Log.info("**********Login method started"+GlobalVars.platform+"*********");
        try {
            if(oCommonFunctions.clickElement(investorLoginElement, 20)){
                oCommonFunctions.sendKey(userIdElement, username, 5);
                oCommonFunctions.sendKey(passwordElement, password, 5);
                driver.navigate().back();
                if(oCommonFunctions.clickElement(loginElement, 20))
                    isUserLoggedIn=oCommonFunctions.clickElement(skipButton, 20);
            }
            Utils.logFunctionLevelLogs(isUserLoggedIn, "Login"+ GlobalVars.platform);
        } catch (Exception e) {
            Log.error("Exception occurred in Login method"+e.getMessage());
            e.printStackTrace();
        }
        //Log.info("**********Login method ended"+GlobalVars.platform+"*********");
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
            Log.error("Exception occurred in verifyHomePagePostLogin method"+e.getMessage());
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
            Log.error("Exception occurred in verifyHomePagePostLogin method"+e.getMessage());
            e.printStackTrace();
        }
        return isUserLoggedOut;
    }
}

