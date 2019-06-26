package pages_IOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

//import io.appium.java_client.android.AndroidKeyCode;

public class LoginPage_IOS
{
    //private AndroidDriver<AndroidElement> driver;
    private AppiumDriver driver;
    CommonFunctions oCommonFunctions=null;
    public LoginPage_IOS() {
    }
    public LoginPage_IOS(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        oCommonFunctions=new CommonFunctions();

    }



    @iOSXCUITFindBy(xpath = "//*[@class='android.widget.Button' and @text='Investor Login']")
    private IOSElement investorLoginElement;
    @iOSXCUITFindBy(id = "com.hdfcfund.investor.uat:id/et_username")
    private IOSElement userIdElement;
    @iOSXCUITFindBy(id = "com.hdfcfund.investor.uat:id/et_password")
    private IOSElement passwordElement;
    @iOSXCUITFindBy(xpath = "//*[@class='android.widget.Button' and @text='Login']")
    private IOSElement loginElement;
    @iOSXCUITFindBy(id = "com.hdfcfund.investor.uat:id/tv_skip")
    private IOSElement skipButton;
    @iOSXCUITFindBy(id = "com.hdfcfund.investor.uat:id/ll_home_1")
    private IOSElement portFolio;
    @iOSXCUITFindBy(id = "com.hdfcfund.investor.uat:id/iv_header_logo")
    private IOSElement drawerIcon;
    @iOSXCUITFindBy(xpath = "//*[@resource-id='com.hdfcfund.investor.uat:id/design_menu_item_text' and @text='Logout']")
    private IOSElement logOut;
    @iOSXCUITFindBy(id = "com.hdfcfund.investor.uat:id/btn_yes")
    private IOSElement yesBtnLogoutPopup;



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
        try {
            oCommonFunctions.clickElement(investorLoginElement, 20);
            oCommonFunctions.sendKey(userIdElement, username, 5);
            oCommonFunctions.sendKey(passwordElement, password, 5);
            oCommonFunctions.clickElement(loginElement, 20);
            isUserLoggedIn=oCommonFunctions.clickElement(skipButton, 20);
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUserLoggedOut;
    }
}

