import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import generic_pages.CommonLoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import logger.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import utils.*;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase extends GlobalVars{

    static String driverUrl="";
    private static ExtentTest test;
    private static ExtentReports extent;
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    private static final String BREAK_LINE = "</br>";
    static String className = null;
    Map<String, DataElements> dataElementMap = null;
    //DemoPage oDemoPage = null;
    CommonLoginPage oCommonLoginPage = null;
    DataReader oDataReader = null;
    TestBase oTestBase = null;
    CommonFunctions ocommonFunctions = null;


    public TestBase(){

        initGlobalVars();
        //initializeDriver();
    }
    public void initGlobalVars(){
        try {
            prop=new Properties();

            workingDir = System.getProperty("user.dir");
            //String configPropFilePath = workingDir+"\\src\\main\\java\\utils\\config.properties";
            String configPropFilePath = workingDir+"//src//main//java//utils//config.properties";
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

    public static void initializeDriver() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
       
        driverUrl="http://"+GlobalVars.appiumServerIp+":"+GlobalVars.appiumServerPort+"/wd/hub";

        switch(platform)
        {
            case "android":

                //File classpathRoot = new File(System.getProperty("user.dir"));
                //File appDir = new File(classpathRoot, "/Apps/");
                //File app = new File(appDir, TestUtil.apkFileName);

                try
                {
                	 capabilities.setCapability("deviceName", GlobalVars.deviceNameAndroid);
                     capabilities.setCapability("platformVersion", GlobalVars.platformVersionAndroid);
                     capabilities.setCapability("platformName", GlobalVars.platform);
                     capabilities.setCapability("newCommandTimeout", 50000);
                     capabilities.setCapability("automationName", "uiautomator");
                     capabilities.setCapability("appPackage", "com.hdfcfund.investor.uat");

                     capabilities.setCapability("appActivity", "com.hdfcfund.investor.splash.SplashActivity");
                     capabilities.setCapability("appWaitPackage", "com.hdfcfund.investor.uat");
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
                String path=System.getProperty("user.dir")+"/"+GlobalVars.ipaFileName;
                File app = new File(path);

                try
                {
                    capabilities.setCapability("deviceName", GlobalVars.deviceNameIOS);
                    capabilities.setCapability("platformVersion", GlobalVars.platformVersionIOS);
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
                    capabilities.setCapability("udid", GlobalVars.udid);
                    capabilities.setCapability("xcodeOrgId", GlobalVars.xcodeOrgId);
                    capabilities.setCapability("xcodeSigningId", GlobalVars.xcodeSigningId);
                    capabilities.setCapability("updateWDABundleId", GlobalVars.updateWDABundleId);
                    capabilities.setCapability("platformName", GlobalVars.platformNameIOS);
                    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                    driver = new IOSDriver<>(new URL(driverUrl), capabilities);
                    driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + platform);
        }

    }


    @BeforeSuite
    public void before() {
        //extent= ExtentManager.getReporter();
        Utils.initializeExtentReport();
        initializeDriver();
        DOMConfigurator.configure("log4j.xml");
        Log.initializeLogProperties();
        //extent = new ExtentReports("target/surefire-reports/ExtentReport.html", true);
    }


    @BeforeClass
    public void classDataInitializer() throws IOException {
        className = this.getClass().getSimpleName();
        oDataReader = new DataReader();
        dataElementMap = oDataReader.getClassData(className);
        oTestBase = new TestBase();
        ocommonFunctions = new CommonFunctions();
    }


    public void logStepInfo(String message) {
        test.log(Status.PASS, message);
        logger.info("Message: " + message);
        Reporter.log(message);
    }


    @BeforeMethod
    public void initializeExtentTest(Method method) {
        Utils.initializeExtentTest(method.getName());
        Log.startTestCase(method.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException, InterruptedException {

        if (result.getStatus() == ITestResult.FAILURE) {
            Utils.captureScreenshot(result);
            //captureScreenshot(result);
        }
        /*extent.endTest(test);*/
        Utils.closeExtentTest();
        Log.endTestCase(result.getTestName());
        //driver.quit();
        System.out.println("****************************************");
    }



    @AfterClass
    public void closeDriver() throws IOException, InterruptedException {
        //driver.quit();
    }

    @AfterSuite
    public void tearDownSuite() {
        // extent.endReport();
        //driver.quit();
        Utils.closeExtentTest();
        driver.quit();
        //extent.flush();
        //extent.close();
    }

}
