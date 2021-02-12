package pages_ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HasOnScreenKeyboard;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.CommonFunctionsMobile;
import utils.GlobalVars;
import utils.Utils;


public class LoginPage
{
    private  AppiumDriver driver;
    static CommonFunctionsMobile commonFunctions=null;
    private static GlobalVars globalVars;
    private static LoginPage loginPage;

    public LoginPage() {
        globalVars=GlobalVars.getInstance();
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctionsMobile.getInstance();
    }

    public static LoginPage getInstance(){
        if(loginPage==null){
            loginPage=new LoginPage();
        }
        return loginPage;
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private static IOSElement emailTextbox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    private static IOSElement passwordTextbox;
    @iOSXCUITFindBy( xpath= "//XCUIElementTypeButton[@name='Login']")
    private static IOSElement loginButton;
    @iOSXCUITFindBy(accessibility = "profile")
    private static IOSElement userIcon;
    @iOSXCUITFindBy(accessibility = "LoginButton")
    private static IOSElement loginButtonNew;



    public boolean login(String username, String password) {
        boolean isUserLoggedIn=false;
        //Log.info("**********Login method started"+GlobalVars.platform+"*********");
        try {
//            commonFunctions.sendKey(emailTextbox, username);
//            commonFunctions.sendKey(passwordTextbox, password);
//            if(commonFunctions.clickElement(loginButton)){
//                isUserLoggedIn=commonFunctions.isElementDisplayed(userIcon, 55);
//            }

            //***** After new build changes of SSO removal

            if(commonFunctions.clickElement(loginButtonNew)){
                Thread.sleep(40000);
                isUserLoggedIn=commonFunctions.isElementDisplayed(userIcon, 80);
            }
            Utils.logFunctionLevelLogs(isUserLoggedIn, "Login"+ globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in Login method"+e.getMessage());
            e.printStackTrace();
        }
        return isUserLoggedIn;
    }

}

