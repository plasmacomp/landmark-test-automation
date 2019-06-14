import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.DataReader;
import utils.GlobalVars;
import utils.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase extends GlobalVars{

    static String driverUrl="";


    public TestBase(){

        initGlobalVars();
        initialization();
    }
    public void initGlobalVars(){
        try {
            prop=new Properties();

            workingDir = System.getProperty("user.dir");
            String configPropFilePath = workingDir+"\\src\\main\\java\\utils\\config.properties";
            FileInputStream ip=new FileInputStream(configPropFilePath);
            prop.load(ip);
            //This is to initialize the test data before execution of any test case
            DataReader oDataReader=new DataReader();
            oDataReader.setupDataSheet();

        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void initialization() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", GlobalVars.deviceNameAndroid);
        capabilities.setCapability("platformVersion", GlobalVars.platformVersionAndroid);
        capabilities.setCapability("platformName", GlobalVars.platform);
        capabilities.setCapability("newCommandTimeout", 50000);
        capabilities.setCapability("automationName", "uiautomator");
        capabilities.setCapability("appPackage", "com.hdfcfund.investor.uat");

        capabilities.setCapability("appActivity", "com.hdfcfund.investor.splash.SplashActivity");
        capabilities.setCapability("appWaitPackage", "com.hdfcfund.investor.uat");
        driverUrl="http://"+GlobalVars.appiumServerIp+":"+GlobalVars.appiumServerPort+"/wd/hub";

        switch(platform)
        {
            case "android":

                //File classpathRoot = new File(System.getProperty("user.dir"));
                //File appDir = new File(classpathRoot, "/Apps/");
                //File app = new File(appDir, TestUtil.apkFileName);

                try
                {
                    driver=new AndroidDriver(new URL(driverUrl), capabilities);
                    driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
                }
                catch(Exception ex)
                {
                    //Log code to be written here in case of failure in driver initialization
                    ex.printStackTrace();
                }
                break;

            case "ios":
                try
                {
                    capabilities.setCapability("deviceName", GlobalVars.deviceNameIOS);
                    capabilities.setCapability("platformVersion", GlobalVars.platformVersionIOS);
                    capabilities.setCapability("automationName", "IOS_XCUI_TEST");
                    capabilities.setCapability("connectHardwareKeyboard", false);
                    driver = new IOSDriver<>(new URL(driverUrl), capabilities);
                    driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
                }
                catch(Exception ex)
                {
                    //Log code to be written here in case of failure in driver initialization
                    ex.printStackTrace();
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + platform);
        }

    }

}
