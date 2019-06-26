import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.springframework.util.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DemoPage;
import pages.LoginPage;
import pages_IOS.LoginPage_IOS;
import reporters.ExtentManager;
import utils.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

//@Listeners(listener.TestListener.class)
public class DemoTest_IOS extends TestBase{

    static String className=null;
    Map<String, DataElements> dataElementMap = null;
    ExtentReports extent=null;
    DemoPage oDemoPage=null;
    LoginPage_IOS oLoginPage=null;
    DataReader oDataReader=null;
    TestBase oTestBase=null;
    CommonFunctions ocommonFunctions=null;
    static String methodToBeExecuted;


    @BeforeClass
    public void classDataInitializer() throws IOException
    {
        className=this.getClass().getSimpleName();
        extent= ExtentManager.getReporter();
        oDataReader=new DataReader();
        dataElementMap = oDataReader.getClassData(className);
        oTestBase=new TestBase();
        ocommonFunctions=new CommonFunctions();
        //DOMConfigurator.configure("log4j.xml");
    }

    @BeforeMethod
    public void initializeDriver(){
        System.out.println("*********Executing "+ Utils.methodToBeExecuted.get(0)+" Test Case********");
        Utils.methodToBeExecuted.remove(0);
        if(driver==null)
            initialization();
    }


    /**
     * @param method
     * @summary:
     * Pre-requisite: The application should be launched
     * Step-1: Go to login page, enter the user name and password and click login button
     * 		   Verify that the user has successfully logged in.
     *
     */
    @Test
    public void loginTest(Method method)
    {
        //region Initialization
        boolean isResult=false;
        SoftAssert softAssert= new SoftAssert();
        ExtentTest test=extent.createTest("loginTest |  "+ GlobalVars.platform, method.getName()+"| JIRA ID: None");
        String username="";
        String password="";
        String stepInfo="";
        //Log.startTestCase("loginTest");
        //end region

        try{
            oLoginPage=new LoginPage_IOS(driver);
            username=dataElementMap.get(method.getName()).getParams().trim().split(",")[0];
            password=dataElementMap.get(method.getName()).getParams().trim().split(",")[1];
//*****************************************************************************************************//
            /*
             * Step-1: Go to login page, enter the user name and password and click login button
             * 		   Verify that the user has successfully logged in.
             */
            stepInfo="Go to login page, enter the user name and password and click login button";
            isResult = oLoginPage.login(username, password);

            ocommonFunctions.logStepInfo(test, isResult, stepInfo, 1);
            //softAssert.assertTrue(isResult, "Step-1: User failed to login!!");
            Assert.isTrue(isResult, "Step-1: User failed to login!!");

//*****************************************************************************************************//
            /*
             * Step-2: Verify that the user has successfully logged in and home page after login is being shown
             *
             */
            stepInfo="Verify that the user has successfully logged in and home page after login is being shown";
            isResult = oLoginPage.verifyHomePagePostLogin();

            ocommonFunctions.logStepInfo(test, isResult, stepInfo, 2);
            Assert.isTrue(isResult, "Step-2: Home page verification post login failed!!");

//*****************************************************************************************************//
            /*
             * Step-3: Click on the drawer icon and logout.
             * 		   Verify that the user has successfully logged out.
             */
            stepInfo="Click on the drawer icon and logout.";
            isResult = oLoginPage.logout();

            ocommonFunctions.logStepInfo(test, isResult, stepInfo, 3);
            Assert.isTrue(isResult, "Step-3: User failed to logout!!");

//*****************************************************************************************************//
        }
        catch(Exception e){e.printStackTrace();}

        finally{

            extent.flush();
            //Log.endTestCase("loginTest");
        }

    }

    @AfterClass
    public void closeDriver() throws IOException, InterruptedException
    {
        driver.quit();
    }

}
