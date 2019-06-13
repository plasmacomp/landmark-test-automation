package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        boolean isElementClicked=false;
        WebDriverWait wait = null;
        try {
            wait=new WebDriverWait(GlobalVars.driver, timeOutInSsec);
            switch(GlobalVars.platform){
                case "android":
                    wait.until(ExpectedConditions.visibilityOf(element));
                    element.clear();
                    element.sendKeys(key);
                    break;
                case "ios":
                    //IOS code to be written here.
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + GlobalVars.platform);
            }
        } catch (Exception e) {
            isElementClicked=false;
            /*Log.error("Could not click on the element with "+locatorType.toString()+" : "+locator);
            Log.error("Exception:"+e.getMessage());*/

        }
        return isElementClicked;
    }
}
