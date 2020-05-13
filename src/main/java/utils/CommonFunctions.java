package utils;

import base.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CommonFunctions extends TestBase {

    /*Function to click on a mobile element*/
    public boolean clickElement(WebElement element, int timeOutInSsec){

        boolean isElementClicked=false;
        WebDriverWait wait = null;
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);//Setting the implicit wait as zero as implicit and explicit wait do not work together
            wait=new WebDriverWait(GlobalVars.driver, timeOutInSsec);
            switch(GlobalVars.platform){
                case "android":
                    wait.until(ExpectedConditions.visibilityOf(element));
                    element.click();
                    isElementClicked=true;
                    break;
                case "ios":
                	wait.until(ExpectedConditions.visibilityOf(element));
                    element.click();
                    isElementClicked=true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + GlobalVars.platform);
            }

            Utils.logFunctionLevelLogs(isElementClicked, "clickElement");
            //Log.info("Successfully clicked on the element with "+locatorType.toString()+" : "+locator);


        } catch (Exception e) {
            isElementClicked=false;
            Log.error("Exception occurred in clickElement method: "+e.getMessage());
            driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
            /*Log.error("Could not click on the element with "+locatorType.toString()+" : "+locator);
            Log.error("Exception:"+e.getMessage());*/

        }
        driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        return isElementClicked;

    }

    /*Function to send key to an element*/
    public boolean sendKey(WebElement element, String key,  int timeOutInSsec){

        boolean isKeySent=false;
        WebDriverWait wait = null;
        try {
            wait=new WebDriverWait(GlobalVars.driver, timeOutInSsec);
            switch(GlobalVars.platform){
                case "android":
                    wait.until(ExpectedConditions.visibilityOf(element));
                    element.clear();
                    element.sendKeys(key);
                    isKeySent=true;
                    break;
                case "ios":
                	 wait.until(ExpectedConditions.visibilityOf(element));
                     element.clear();
                     element.sendKeys(key);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + GlobalVars.platform);
            }
            Utils.logFunctionLevelLogs(isKeySent, "sendKey");
        } catch (Exception e) {
            isKeySent=false;
            Log.error("Exception occurred in sendKey method"+e.getMessage());
        }
        return isKeySent;
    }

    /*Function to send key to an element*/
    public boolean isElementDisplayed(WebElement element, int timeOutInSsec){

        boolean isElementDisplayed=false;
        WebDriverWait wait = null;
        try {
            wait=new WebDriverWait(GlobalVars.driver, timeOutInSsec);
            switch(GlobalVars.platform){
                case "android":
                    wait.until(ExpectedConditions.visibilityOf(element));
                    isElementDisplayed=element.isDisplayed();
                    break;
                case "ios":
                    //IOS code to be written here.
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + GlobalVars.platform);
            }
            Utils.logFunctionLevelLogs(isElementDisplayed, "isElementDisplayed");

        } catch (Exception e) {
            Log.error("Exception occurred in isElementDisplayed method"+e.getMessage());
            isElementDisplayed=false;
        }
        return isElementDisplayed;
    }

    /*Function to get the text of a mobile element*/
    public String getElementText(WebElement element, int timeOutInSsec){
        WebDriverWait wait = null;
        String text="";
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);//Setting the implicit wait as zero as implicit and explicit wait do not work together
            wait=new WebDriverWait(GlobalVars.driver, timeOutInSsec);
            switch(GlobalVars.platform){
                case "android":
                    wait.until(ExpectedConditions.visibilityOf(element));
                    text=element.getText();
                    break;
                case "ios":
                    //IOS code goes here
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + GlobalVars.platform);
            }
            Utils.logFunctionLevelLogs(true, "Text of the element is : "+text);
        } catch (Exception e) {
            Log.error("Exception occurred in clickElement method: "+e.getMessage());
            driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        }
        driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        return text;

    }

    public void logStepInfo(ExtentTest test, boolean isResult, String stepInfo, int stepNumber) throws IOException, InterruptedException
    {
        if(isResult)
            test.log(Status.PASS, "Step-"+stepNumber+": "+stepInfo+" | Status: Pass");
        else
            test.log(Status.FAIL, "Step-"+stepNumber+": "+stepInfo+" | Status: Fail");
    }
}
