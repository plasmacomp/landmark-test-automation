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
            isUserLoggedIn=true;//Here validation needs to be done
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUserLoggedIn;
        //hideKeyboardIfVisible();
    }
}

