package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IosBase extends TestBase{
    static DesiredCapabilities capabilities;
    static String driverUrl;
    static GlobalVars globalVars;
    static AppiumDriver driver;

    @Override
    public void initializeDriver() {
        globalVars=GlobalVars.getInstance();
        driverUrl="http://"+globalVars.getAppiumServerIp()+":"+globalVars.getAppiumServerPort()+"/wd/hub";
        capabilities=new DesiredCapabilities();
        if(driver==null){
            if(globalVars.getIsAwsRun())
                initializeDriverWithoutCapabilities();
            else
                initializeDriverWithCapabilities();
        }

    }

    public static void initializeDriverWithoutCapabilities() {
        try{
            globalVars.setDriver(new IOSDriver<>(new URL(driverUrl), capabilities));
            driver = globalVars.getDriver();
            driver.manage().timeouts().implicitlyWait(globalVars.getImplicitWait(), TimeUnit.SECONDS);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void initializeDriverWithCapabilities() {
        try
        {
            capabilities.setCapability(Constants.DEVICE_NAME, globalVars.getDeviceNameIOS());
            //capabilities.setCapability(Constants.PLATFORM_VERSION, globalVars.getPlatformVersionIOS());
            capabilities.setCapability(Constants.PLATFORM_VERSION, "13.0");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capabilities.setCapability("newCommandTimeout", 300);
            //capabilities.setCapability(Constants.UDID, globalVars.getUdid());
            //capabilities.setCapability(Constants.BUNDLE_ID, globalVars.getUpdateWDABundleId());
            capabilities.setCapability(Constants.PLATFORM_NAME, Constants.IOS.toUpperCase());
            capabilities.setCapability(Constants.APP, globalVars.getIpaFileName());
            //capabilities.setCapability(Constants.APP, "/Users/ataurrahman/Documents/Landmark.app");

            //capabilities.setCapability("xcodeOrgId", GlobalVars.xcodeOrgId);
            //capabilities.setCapability("xcodeSigningId", GlobalVars.xcodeSigningId);
            //capabilities.setCapability("updateWDABundleId", GlobalVars.updateWDABundleId);
            //capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            if(driver==null){
                globalVars.setDriver(new IOSDriver<>(new URL(driverUrl), capabilities));
                driver = globalVars.getDriver();
                driver.manage().timeouts().implicitlyWait(globalVars.getImplicitWait(), TimeUnit.SECONDS);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }


    @Override
    public void closeDriver(){
        if(driver!=null)
            driver.quit();

    }
}
