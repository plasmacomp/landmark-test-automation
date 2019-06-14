package pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class LoginPage
{
    //private AndroidDriver<AndroidElement> driver;
    private AppiumDriver driver;
    CommonFunctions oCommonFunctions=null;
    public LoginPage() {
    }
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        oCommonFunctions=new CommonFunctions();

    }


    ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.Button
    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='Investor Login']")
    private AndroidElement investorLoginElement;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/et_username")
    private AndroidElement userIdElement;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/et_password")
    private AndroidElement passwordElement;
    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='Login']")
    private AndroidElement loginElement;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/tv_skip")
    private AndroidElement skipButton;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/ll_home_1")
    private AndroidElement portFolio;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/iv_header_logo")
    private AndroidElement drawerIcon;
    @AndroidFindBy(xpath = "//*[@resource-id='com.hdfcfund.investor.uat:id/design_menu_item_text' and @text='Logout']")
    private AndroidElement logOut;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/btn_yes")
    private AndroidElement yesBtnLogoutPopup;



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

