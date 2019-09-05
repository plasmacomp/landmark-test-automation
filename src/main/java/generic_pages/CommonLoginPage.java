package generic_pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.Constants;
import utils.GlobalVars;
import utils.Utils;

public class CommonLoginPage {

    private AppiumDriver driver;
    pages_android.LoginPage oLoginPageAndroid=null;
    pages_ios.LoginPage oLoginPageIos=null;

    public CommonLoginPage(AppiumDriver driver) {
        switch(GlobalVars.platform){
            case Constants.ANDROID:
                oLoginPageAndroid=new pages_android.LoginPage(driver);
                break;
            case Constants.IOS:
                oLoginPageIos=new pages_ios.LoginPage(driver);
                break;
        }
    }

    /*Function to login on both android and IOS platform*/
    public boolean login(String username, String password) {
        boolean isUserLoggedIn=false;
        switch(GlobalVars.platform){
            case Constants.ANDROID:
                isUserLoggedIn=oLoginPageAndroid.login(username, password);
                break;
            case Constants.IOS:
                isUserLoggedIn=oLoginPageIos.login(username, password);
                break;
        }
        Utils.logFunctionLevelLogs(isUserLoggedIn, "Login");
        return isUserLoggedIn;
    }

    /*Function to check whether the user has successfully landed on Home page after login*/
    public boolean verifyHomePagePostLogin() {
        boolean hasUserLandedOnHomePage=false;
        switch(GlobalVars.platform) {
            case Constants.ANDROID:
                hasUserLandedOnHomePage = oLoginPageAndroid.verifyHomePagePostLogin();
                break;
            case Constants.IOS:
                hasUserLandedOnHomePage = oLoginPageIos.verifyHomePagePostLogin();
                break;
        }
        Utils.logFunctionLevelLogs(hasUserLandedOnHomePage, "verifyHomePagePostLogin");
        return hasUserLandedOnHomePage;
    }

    /*Function to check the equity amount on dashboard and inside the dashboard is same*/
    public boolean verifyEquityFromDashboard() {
        boolean isEquityVerificationPassed=false;
        switch(GlobalVars.platform) {
            case Constants.ANDROID:
                isEquityVerificationPassed = oLoginPageAndroid.verifyEquityFromDashboard();
                break;
            case Constants.IOS:
                //isEquityVerificationPassed = oLoginPageIos.verifyEquityFromDashboard();
                break;
        }
        Utils.logFunctionLevelLogs(isEquityVerificationPassed, "verifyEquityFromDashboard");
        return isEquityVerificationPassed;
    }


    /*Function to logout*/
    public boolean logout(){
        boolean hasUserLoggedOut=false;
        switch(GlobalVars.platform) {
            case Constants.ANDROID:
                hasUserLoggedOut = oLoginPageAndroid.logout();
                break;
            case Constants.IOS:
                hasUserLoggedOut = oLoginPageIos.logout();
                break;
        }
        Utils.logFunctionLevelLogs(hasUserLoggedOut, "logout");
        return hasUserLoggedOut;
    }
}

