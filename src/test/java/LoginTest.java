import generic_pages.CommonDashboardPage;
import generic_pages.CommonLoginPage;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import base.TestBase;
import utils.*;

public class LoginTest {
    CommonLoginPage commonLoginPage;
    CommonDashboardPage commonDashboardPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization(){
       globalVars = TestBase.setup(this.getClass().getSimpleName());
    }

    /**
     * @summary:
     * Pre-requisite: The application should be launched and navigated to home page
     * Step-1: Go to login page, enter the user name and password and click login button
     * 		   Verify that the user has successfully logged in.
     */
    @Test
    public void loginTest() {
        boolean isResult=false;
        String username="";
        String password="";
        String currentMethodName="loginTest";
        commonLoginPage =CommonLoginPage.getInstance();
        username=globalVars.getUsername(currentMethodName);
        password=globalVars.getPassword(currentMethodName);

        isResult = commonLoginPage.login(username, password);
        Utils.logStepInfo(isResult, "Go to login page, enter the user name and password and click login button");
        Assert.isTrue(isResult, "Step-1: User failed to login!!");
    }

    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }

}
