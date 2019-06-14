import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import logger.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.util.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.DemoPage;
import pages.LoginPage;
import reporters.ExtentManager;
import utils.DataElements;
import utils.DataReader;
import utils.GlobalVars;
import utils.Utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

//@Listeners(listener.TestListener.class)
public class DemoTest extends TestBase{

    static String className=null;
    Map<String, DataElements> dataElementMap = null;
    ExtentReports extent=null;
    DemoPage oDemoPage=null;
    LoginPage oLoginPage=null;
    DataReader oDataReader=null;
    static String methodToBeExecuted;


    @BeforeClass
    public void classDataInitializer() throws IOException
    {
        className=this.getClass().getSimpleName();
        extent= ExtentManager.getReporter();
        oDemoPage=new DemoPage();
        oDataReader=new DataReader();
        oDataReader.setupDataSheet();
        dataElementMap = oDataReader.getClassData(className);
        //DOMConfigurator.configure("log4j.xml");
    }

    @BeforeMethod
    public void initializeDriver(){
        System.out.println("*********Executing "+ Utils.methodToBeExecuted.get(0)+" Test Case********");
        String params[]=dataElementMap.get(Utils.methodToBeExecuted.get(0)).getParams().trim().split(",");
        if(driver==null){
            initialization();
        }
        Utils.methodToBeExecuted.remove(0);
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
        //Log.startTestCase("loginTest");
        //end region

        try{
            oLoginPage=new LoginPage(driver);
            username=dataElementMap.get(method.getName()).getParams().trim().split(",")[0];
            password=dataElementMap.get(method.getName()).getParams().trim().split(",")[1];
//*****************************************************************************************************//
            /*
             * Step-1: Go to login page, enter the user name and password and click login button
             * 		   Verify that the user has successfully logged in.
             */

            isResult = oLoginPage.login(username, password);

            if(isResult)
                test.log(Status.PASS, "Step-1: User has successfully logged in");
            else
                test.log(Status.FAIL, "Step-1: User failed to login!!");

            //softAssert.assertTrue(isResult, "Step-1: User failed to login!!");
            Assert.isTrue(isResult, "Step-1: User failed to login!!");

//*****************************************************************************************************//
            /*
             * Step-1: Verify that the user has successfully logged in and home page after login is being shown
             *
             */

            isResult = oLoginPage.verifyHomePagePostLogin();

            if(isResult)
                test.log(Status.PASS, "Step-2: Home page verification post login successful");
            else
                test.log(Status.FAIL, "Step-2: Home page verification post login failed!!");

            Assert.isTrue(isResult, "Step-2: Home page verification post login failed!!");

//*****************************************************************************************************//
            /*
             * Step-1: Click on the drawer icon and logout.
             * 		   Verify that the user has successfully logged out.
             */

            isResult = oLoginPage.logout();

            if(isResult)
                test.log(Status.PASS, "Step-3: User has successfully logged out");
            else
                test.log(Status.FAIL, "Step-3: User failed to logout!!");

            Assert.isTrue(isResult, "Step-1: User failed to logout!!");

//*****************************************************************************************************//
        }
        catch(Exception e){e.printStackTrace();}

        finally{

            extent.flush();
            //Log.endTestCase("loginTest");
        }

    }



    @AfterMethod
    public void quitDriver() throws IOException, InterruptedException
    {
        //driver.quit();
        System.out.println("In After method");
    }

    @AfterClass
    public void closeDriver() throws IOException, InterruptedException
    {
        System.out.println("In After class method");
        driver.quit();
    }

}
