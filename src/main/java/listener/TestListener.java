package listener;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import base.TestBase;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import utils.Constants;
import utils.DataReader;
import utils.GlobalVars;
import utils.JiraOperationsUtil;
import utils.TestLinkUtil;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener extends TestBase implements ITestListener {
//TestListenerAdapter
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    	 if(testLinkFlag){
             if(TestLinkUtil.testLink.get()!=null){
                 for (Integer id : TestLinkUtil.testLink.get()) {
                     TestLinkUtil.setResult(id, ExecutionStatus.PASSED);
                 }
             }
         }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("In Test listener class");
        Class clazz = iTestResult.getTestClass().getRealClass();
        try {
            /*On failure of a test case, raise a bug on JIRA*/
            if(jiraFlag){ //GlobalVars.prop.getProperty(Constants.IS_CREATE_BUG).equalsIgnoreCase("true"
                JiraOperationsUtil.createJiraInstance(GlobalVars.prop.getProperty(Constants.JIRA_URL),
                        GlobalVars.prop.getProperty(Constants.JIRA_USERNAME),
                        GlobalVars.prop.getProperty(Constants.JIRA_PASSWORD));
                String testName=iTestResult.getName();
                JiraOperationsUtil.createNewIssue("Test Automation Bug: " +testName ,
                        "Test failed for test case: " + testName,
                        "AutomatedTestExecutionBug", "ataur.rahman");
            }
            if(testLinkFlag){
                if(TestLinkUtil.testLink.get()!=null){
                    for (Integer id : TestLinkUtil.testLink.get()) {
                        TestLinkUtil.setResult(id, ExecutionStatus.FAILED);
                    }
                }
            }


            // this field name must be present and equals in any testcase
            /*Field field = clazz.getDeclaredField("driver");
            field.setAccessible(true);*/

            //AppiumDriver<?> driver = (AppiumDriver<?>) field.get(iTestResult.getInstance());

            File file = GlobalVars.driver.getScreenshotAs(OutputType.FILE);

            // the filename is the folder name on test.screenshot.path property plus the completeTestName
            String myDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());

            File baseDirectory = new File(".");
            String testDataPath = baseDirectory.getCanonicalPath()+"\\src\\main\\resources\\TestOutput";
            FileUtils.copyFile(file,
                    new File(testDataPath + "/" + composeTestName(iTestResult) +myDate+ ".png"));


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    	if(testLinkFlag){
            if(TestLinkUtil.testLink.get()!=null){
                for (Integer id : TestLinkUtil.testLink.get()) {
                    TestLinkUtil.setResult(id, ExecutionStatus.NOT_RUN);
                }
            }
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }


    private String composeTestName(ITestResult iTestResult) {
        StringBuffer completeFileName = new StringBuffer();

        completeFileName.append(iTestResult.getTestClass().getRealClass().getSimpleName()); // simplified class name
        completeFileName.append("_");
        completeFileName.append(iTestResult.getName()); // method name

        // all the parameters information
        Object[] parameters = iTestResult.getParameters();
        for(Object parameter : parameters) {
            completeFileName.append("_");
            completeFileName.append(parameter);
        }

        // return the complete name and replace : by - (in the case the emulator have port as device name)
        return completeFileName.toString().replace(":", "-");
    }
}

