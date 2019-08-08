import generic_pages.CommonLoginPage;
import listener.AnnotationTransformer;
import listener.Retry;
import logger.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.util.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class DemoTest extends TestBase{

    /**
     * @param
     * @summary:
     * Pre-requisite: The application should be launched
     * Step-1: Go to login page, enter the user name and password and click login button
     * 		   Verify that the user has successfully logged in.
     *
     */
    @Test
    public void loginTest() {
        boolean isResult=false;
        SoftAssert softAssert= new SoftAssert();
        String username="";
        String password="";
        System.out.println("In LoginTest method");
        String currentMethodName=Thread.currentThread().getStackTrace()[1].getMethodName();
        oCommonLoginPage =new CommonLoginPage(driver);
        username=dataElementMap.get(currentMethodName).getParams().trim().split(",")[0];
        password=dataElementMap.get(currentMethodName).getParams().trim().split(",")[1];
//*****************************************************************************************************//
        isResult = oCommonLoginPage.login(username, password);
        Utils.logStepInfo(isResult, "Go to login page, enter the user name and password and click login button");
        Assert.isTrue(isResult, "Step-1: User failed to login!!");

//*****************************************************************************************************//
        isResult = oCommonLoginPage.verifyHomePagePostLogin();
        Utils.logStepInfo(isResult, "Verify that the user has successfully logged in and home page after login is being shown");
        Assert.isTrue(isResult, "Step-2: Home page verification post login failed!!");

//*****************************************************************************************************//
        isResult = oCommonLoginPage.logout();
        Utils.logStepInfo(isResult, "Click on the drawer icon and logout");
        Assert.isTrue(isResult, "Step-3: User failed to logout!!");
    }

    @Test
    public void loginTest1() {
        boolean isResult=false;
        SoftAssert softAssert= new SoftAssert();
        String username="";
        String password="";
        System.out.println("In LoginTest1 method");
        String currentMethodName=Thread.currentThread().getStackTrace()[1].getMethodName();
        oCommonLoginPage =new CommonLoginPage(driver);
        username=dataElementMap.get(currentMethodName).getParams().trim().split(",")[0];
        password=dataElementMap.get(currentMethodName).getParams().trim().split(",")[1];
//*****************************************************************************************************//
        isResult = oCommonLoginPage.login(username, password);
        Utils.logStepInfo(isResult, "Go to login page, enter the user name and password and click login button");
        Assert.isTrue(isResult, "Step-1: User failed to login!!");

//*****************************************************************************************************//
        isResult = oCommonLoginPage.verifyHomePagePostLogin();
        Utils.logStepInfo(isResult, "Verify that the user has successfully logged in and home page after login is being shown");
        Assert.isTrue(isResult, "Step-2: Home page verification post login failed!!");

//*****************************************************************************************************//
        isResult = oCommonLoginPage.logout();
        Utils.logStepInfo(isResult, "Click on the drawer icon and logout");
        Assert.isTrue(isResult, "Step-3: User failed to logout!!");
    }


}
