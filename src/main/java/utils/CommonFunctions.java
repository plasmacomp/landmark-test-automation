package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class CommonFunctions {

    /*Function to click on a mobile element*/
    public boolean clickElement(WebElement element, int timeOutInSsec){

        boolean isElementClicked=false;
        WebDriverWait wait = null;
        try {
            wait=new WebDriverWait(GlobalVars.driver, timeOutInSsec);
            switch(GlobalVars.platform){
                case "android":
                    wait.until(ExpectedConditions.visibilityOf(element));
                    element.click();
                    isElementClicked=true;
                    break;
                case "ios":
                    //IOS code to be written here.
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + GlobalVars.platform);
            }

            //Log.info("Successfully clicked on the element with "+locatorType.toString()+" : "+locator);


        } catch (Exception e) {
            isElementClicked=false;
            /*Log.error("Could not click on the element with "+locatorType.toString()+" : "+locator);
            Log.error("Exception:"+e.getMessage());*/

        }
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
                    //IOS code to be written here.
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + GlobalVars.platform);
            }
        } catch (Exception e) {
            isKeySent=false;
            /*Log.error("Could not click on the element with "+locatorType.toString()+" : "+locator);
            Log.error("Exception:"+e.getMessage());*/

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
        } catch (Exception e) {
            isElementDisplayed=false;
        }
        return isElementDisplayed;
    }


    public void logStepInfo(ExtentTest test, boolean isResult, String stepInfo, int stepNumber) throws IOException, InterruptedException
    {
        if(isResult)
            test.log(Status.PASS, "Step-"+stepNumber+": "+stepInfo+" | Status: Pass");
        else
            test.log(Status.FAIL, "Step-"+stepNumber+": "+stepInfo+" | Status: Fail");
    }
}
