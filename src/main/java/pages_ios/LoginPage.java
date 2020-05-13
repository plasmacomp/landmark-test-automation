package pages_ios;

import generic_pages.CommonLoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HasOnScreenKeyboard;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.Utils;


public class LoginPage extends CommonLoginPage
{
    private  AppiumDriver driver;
    static CommonFunctions commonFunctions=null;
    private static LoginPage loginPage;

    public LoginPage() {
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctions.getInstance();
    }

    public static LoginPage getLoginPageInstance(){
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
    @iOSXCUITFindBy(xpath = "//button[contains(@class,'_')]//tab-t[text()='Login']")
    private static IOSElement userIcon;


    public  void hideKeyboardIfVisible() {
    	boolean isKeyboardShown = ((HasOnScreenKeyboard) driver).isKeyboardShown();
        if ( isKeyboardShown ==true){
        	driver.hideKeyboard();
       }
    }

    @Override
    public boolean login(String username, String password) {
        boolean isUserLoggedIn=false;
        logger.info("**********Login method started"+globalVars.getPlatform()+"*********");
        //Log.info("**********Login method started"+GlobalVars.platform+"*********");
        try {
            commonFunctions.sendKey(emailTextbox, username, 5);
            commonFunctions.sendKey(passwordTextbox, password, 5);
            if(commonFunctions.clickElement(loginButton, 5)){
                isUserLoggedIn=true;
                //isUserLoggedIn=commonFunctions.isElementDisplayed(userIcon, 30);
            }
            //Thread.sleep(1000);
            Utils.logFunctionLevelLogs(isUserLoggedIn, "Login"+ globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in Login method"+e.getMessage());
            e.printStackTrace();
        }
        return isUserLoggedIn;
    }

    @Override
    public boolean logout() {
        return false;
    }

}

