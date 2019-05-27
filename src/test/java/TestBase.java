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
        capabilities.setCapability("deviceName", GlobalVars.deviceName);
        capabilities.setCapability("platformVersion", GlobalVars.platformVersion);
        capabilities.setCapability("platformName", GlobalVars.platform);
        capabilities.setCapability("newCommandTimeout", 50000);
        capabilities.setCapability("automationName", "uiautomator");
        capabilities.setCapability("appPackage", "com.irdeto.kplus.stage");

        capabilities.setCapability("appActivity", "com.irdeto.kplus.activity.ActivitySplash");
        capabilities.setCapability("appWaitPackage", "com.irdeto.kplus.stage");
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
