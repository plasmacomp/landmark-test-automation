package pages_android;
import generic_pages.CommonLoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import utils.Utils;

public class LoginPage extends CommonLoginPage
{
    //private AndroidDriver<AndroidElement> driver;


    private AppiumDriver driver;
    //TODO: Does this need to be static
    static CommonFunctions commonFunctions;
    private static LoginPage loginPage;


    @AndroidFindBy(id = "android:id/button1")
    private static AndroidElement okButton18PlusPage;
    @AndroidFindBy(id = "au.com.tabcorp.tab_android_androidx:id/next_button")
    private static AndroidElement nextButtonWhatsNewPage;
    @AndroidFindBy(id = "android:id/button1")
    private static AndroidElement okButtonFeedbackPage;
    @AndroidFindBy(id = "au.com.tabcorp.tab_android_androidx:id/btn_login")
    private static AndroidElement loginButtonHomePage;
    @AndroidFindBy(id = "au.com.tabcorp.tab_android_androidx:id/editTextUsername")
    private static AndroidElement userNameTextField;
    @AndroidFindBy(id = "au.com.tabcorp.tab_android_androidx:id/editTextPassword")
    private static AndroidElement passwordTextField;
    @AndroidFindBy(id = "au.com.tabcorp.tab_android_androidx:id/submit")
    private static AndroidElement loginButtonLoginPage;



    public LoginPage() {
        driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctions.getInstance();
    }
    //TODO: getInstance simply is less DRY
    public static LoginPage getLoginPageInstance(){
        if(loginPage==null){
            loginPage=new LoginPage();
        }
        return loginPage;
    }

    @Override
    public boolean login(String username, String password) {
        boolean isUserLoggedIn=false;
        //Log.info("**********Login method started"+GlobalVars.platform+"*********");
        try {
            if(homePageSetup()){
                if(commonFunctions.clickElement(loginButtonHomePage, 5)){
                    commonFunctions.sendKey(userNameTextField, username, 5);
                    commonFunctions.sendKey(passwordTextField, password, 5);
                    isUserLoggedIn=commonFunctions.clickElement(loginButtonLoginPage, 5);
                    Thread.sleep(6000);
                }
            }
            Utils.logFunctionLevelLogs(isUserLoggedIn, "Login"+ globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in Login method"+e.getMessage());
            e.printStackTrace();
        }
        //Log.info("**********Login method ended"+GlobalVars.platform+"*********");
        return isUserLoggedIn;
    }

    public boolean homePageSetup() {
        int maxRetryNetworkError=0;
        try {

            while (commonFunctions.isElementDisplayed(okButton18PlusPage, 5)){
                maxRetryNetworkError++;
                commonFunctions.clickElement(okButton18PlusPage, 5);
                if(maxRetryNetworkError>4)
                    break;

            }

            while (commonFunctions.isElementDisplayed(nextButtonWhatsNewPage, 5)){
                commonFunctions.clickElement(nextButtonWhatsNewPage, 5);
            }
            //commonFunctions.clickElement(okButtonFeedbackPage, 5);
            commonFunctions.clickElement(okButton18PlusPage, 5);//ok button feedback page

            globalVars.setIsHomePageSetup(commonFunctions.isElementDisplayed(loginButtonHomePage, 5));
            Utils.logFunctionLevelLogs(globalVars.getIsHomePageSetup(), "Login"+ globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in homePageSetup method"+e.getMessage());
            e.printStackTrace();
        }
        //Log.info("**********Login method ended"+GlobalVars.platform+"*********");
        return globalVars.getIsHomePageSetup();
    }


    /*Function to verify whether the user has successfully logged in*/
    /*public boolean verifyHomePagePostLogin() {
        boolean isUserLoggedIn=false;
        try {
            //isUserLoggedIn=commonFunctions.isElementDisplayed(portFolio, 10);
            Thread.sleep(4000);
            Utils.logFunctionLevelLogs(isUserLoggedIn, "verifyHomePagePostLogin"+ GlobalVars.platform);
        } catch (Exception e) {
            Log.error("Exception occurred in verifyHomePagePostLogin method"+e.getMessage());
            e.printStackTrace();
        }
        return isUserLoggedIn;
    }*/


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

