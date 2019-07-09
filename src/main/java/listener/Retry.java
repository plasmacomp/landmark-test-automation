package listener;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import reporters.ExtentTestManager;
import utils.GlobalVars;

public class Retry implements IRetryAnalyzer, ITestNGListener {

    private int retryCount = 0;
    private int maxRetryCount = 1;

    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            System.out.println("Retrying test " + result.getName() + " with status "
                    + (result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }
 
    /*public void extendReportsFailOperations (ITestResult iTestResult) {
        //Object testClass = iTestResult.getInstance();
        AppiumDriver driver=null;
        driver= GlobalVars.driver;
        //webDriver = ((BaseTest) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        *//*ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));*//*

    }*/
}
