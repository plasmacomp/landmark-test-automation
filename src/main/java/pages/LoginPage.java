package pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage
{
    private AndroidDriver<AndroidElement> driver;
    public LoginPage() {
    }
    public LoginPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.Button")
    private AndroidElement investorLoginElement;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/et_username")
    private AndroidElement userIdElement;
    @AndroidFindBy(id = "com.hdfcfund.investor.uat:id/et_password")
    private AndroidElement passwordElement;
    @AndroidFindBy(className = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.Button")
    private AndroidElement loginElement;
    public boolean isDisplayed() {
        return loginElement.isDisplayed();
    }

    public void hideKeyboardIfVisible() {
        if (keyboard != null) {
           // driver.pressKeyCode(AndroidKeyCode.KEYCODE_ESCAPE);
        }
    }
    public void login (String name, String password) {

        if(driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.Button").size()!=0) {
            investorLoginElement.click();
            try {
                driver.wait(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        hideKeyboardIfVisible();
        userIdElement.sendKeys("Ajay_yadav_3");
        passwordElement.sendKeys("Test@123");
        loginElement.click();

        //validate the dashboard text
    }
}

