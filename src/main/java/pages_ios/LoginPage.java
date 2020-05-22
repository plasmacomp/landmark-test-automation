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


public class LoginPage
{
    private  AppiumDriver driver;
    static CommonFunctions commonFunctions=null;
    private static GlobalVars globalVars;
    private static LoginPage loginPage;

    public LoginPage() {
        globalVars=GlobalVars.getInstance();
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctions.getInstance();
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


    public  void hideKeyboardIfVisible() {
    	boolean isKeyboardShown = ((HasOnScreenKeyboard) driver).isKeyboardShown();
        if ( isKeyboardShown ==true){
        	driver.hideKeyboard();
       }
    }

    public boolean login(String username, String password) {
        boolean isUserLoggedIn=false;
        //Log.info("**********Login method started"+GlobalVars.platform+"*********");
        try {
            commonFunctions.sendKey(emailTextbox, username);
            commonFunctions.sendKey(passwordTextbox, password);
            if(commonFunctions.clickElement(loginButton)){
                isUserLoggedIn=commonFunctions.isElementDisplayed(userIcon, 55);
            }
            Utils.logFunctionLevelLogs(isUserLoggedIn, "Login"+ globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in Login method"+e.getMessage());
            e.printStackTrace();
        }
        return isUserLoggedIn;
    }

    public boolean logout() {
        return false;
    }

}

