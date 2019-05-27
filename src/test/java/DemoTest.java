import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import logger.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.util.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DemoPage;
import reporters.ExtentManager;
import utils.DataElements;
import utils.GlobalVars;
import utils.Utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class DemoTest extends TestBase{

    static String className=null;
    Map<String, DataElements> dataElementMap = null;
    ExtentReports extent=null;
    DemoPage oDemoPage=null;
    static String methodToBeExecuted;

    @BeforeClass
    public void classDataInitializer() throws IOException
    {
        className=this.getClass().getSimpleName();
        extent= ExtentManager.getReporter();
        oDemoPage=new DemoPage();
        DOMConfigurator.configure("log4j.xml");
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
        Log.startTestCase("loginTest");
        //end region

        try{

//*****************************************************************************************************//
            /*
             * Step-1: Go to login page, enter the user name and password and click login button
             * 		   Verify that the user has successfully logged in.
             */

            isResult = oDemoPage.login();

            if(isResult)
                test.log(Status.PASS, "Step-1: User has successfully logged in");
            else
                test.log(Status.FAIL, "Step-1: User failed to login!!");

            //softAssert.assertTrue(isResult, "Step-1: User failed to login!!");
            Assert.isTrue(isResult, "Step-1: User failed to login!!");


//*****************************************************************************************************//

        }
        catch(Exception e){e.printStackTrace();}

        finally{

            extent.flush();
            Log.endTestCase("loginTest");

        }

    }



    @AfterMethod
    public void quitDriver() throws IOException, InterruptedException
    {
        driver.quit();
    }

}
