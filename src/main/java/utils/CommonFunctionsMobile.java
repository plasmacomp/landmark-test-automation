package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.NetworkSpeed;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import logger.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonFunctionsMobile {
    static AppiumDriver driver;
    private static GlobalVars globalVars;
    WebDriverWait wait;
    private static CommonFunctionsMobile commonFunctionsMobile;
    public static Logger logger;

    public static CommonFunctionsMobile getInstance(){
        globalVars=GlobalVars.getInstance();
        driver=globalVars.getDriver();
        logger= Log.getInstance();
        if(commonFunctionsMobile==null){
            commonFunctionsMobile=new CommonFunctionsMobile();
        }
        return commonFunctionsMobile;
    }
    public boolean clickElement(WebElement element, int timeOutInSsec) {
        boolean isElementClicked=false;
        try{
            manageImplicitTimeOut(0);
            wait=new WebDriverWait(driver, timeOutInSsec);
            wait.until(ExpectedConditions.visibilityOf(element)).click();
            isElementClicked=true;
        }
        catch (Exception e) {
            logger.error("Exception occurred in clickElement method: "+e.getMessage());
            manageImplicitTimeOut(globalVars.getImplicitWait());
        }
        manageImplicitTimeOut(globalVars.getImplicitWait());
        Utils.logFunctionLevelLogs(isElementClicked, "clickElement");
        return isElementClicked;
    }
    public boolean clickElement(WebElement element) {
        boolean isElementClicked=false;
        try{
            element.click();
            isElementClicked=true;
        }
        catch (Exception e) {
            logger.error("Exception occurred in clickElement method: "+e.getMessage());
        }
        Utils.logFunctionLevelLogs(isElementClicked, "clickElement");
        return isElementClicked;
    }
    public boolean clickElementByXpath(String xpath) {
        boolean isElementClicked=false;
        try{
            driver.findElement(By.xpath(xpath)).click();
            isElementClicked=true;
        }
        catch (Exception e) {
            logger.error("Exception occurred in clickElement method: "+e.getMessage());
        }
        Utils.logFunctionLevelLogs(isElementClicked, "clickElement");
        return isElementClicked;
    }
    public boolean clickElementByAccessibilityId(String id) {
        boolean isElementClicked=false;
        try{
            driver.findElementByAccessibilityId(id).click();
            isElementClicked=true;
        }
        catch (Exception e) {
            logger.error("Exception occurred in clickElementByAccessibilityId method: "+e.getMessage());
        }
        Utils.logFunctionLevelLogs(isElementClicked, "clickElementByAccessibilityId");
        return isElementClicked;
    }


    public void sendKey(WebElement element, String key) {
        try {
            //element.click();
            element.clear();
            element.sendKeys(key);
            Utils.logFunctionLevelLogs(true, "sendKey");
        } catch (Exception e) {
            logger.error("Exception occurred in sendKey method: "+e.getMessage());
        }
    }

    public void sendKeyByJs(WebElement element, String key) {
        try {
            JavascriptExecutor jsExec = (JavascriptExecutor) driver;
            try {
                jsExec.executeScript("arguments[0].setAttribute('value', 'abcd');");
                element.sendKeys(key);
            } finally {
                jsExec.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                        "abcde");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendKey(WebElement element, String key, int timeOutInSsec) {
        try {
            manageImplicitTimeOut(0);//Setting the implicit wait as zero as implicit and explicit wait do not work together
            wait=new WebDriverWait(driver, timeOutInSsec);
            wait.until(ExpectedConditions.visibilityOf(element)).clear();element.sendKeys(key);
            Utils.logFunctionLevelLogs(true, "sendKey");
        } catch (Exception e) {
            logger.error("Exception occurred in sendKey method: "+e.getMessage());
            manageImplicitTimeOut(globalVars.getImplicitWait());
        }
        finally {
            manageImplicitTimeOut(globalVars.getImplicitWait());
        }
    }
    public boolean isElementDisplayedByXpath(String xpath) {
        boolean isElementDisplayed=false;
        try {
            isElementDisplayed=driver.findElement(By.xpath(xpath)).isDisplayed();

        } catch (Exception e) {
            isElementDisplayed=false;
            logger.error("Exception occurred in isElementDisplayed method: "+e.getMessage());
        }
        Utils.logFunctionLevelLogs(isElementDisplayed, "isElementDisplayed");
        return isElementDisplayed;
    }
    public boolean isElementDisplayed(WebElement element) {
        boolean isElementDisplayed=false;
        try {
            isElementDisplayed=element.isDisplayed();

        } catch (Exception e) {
            isElementDisplayed=false;
            logger.error("Exception occurred in isElementDisplayed method: "+e.getMessage());
        }
        Utils.logFunctionLevelLogs(isElementDisplayed, "isElementDisplayed");
        return isElementDisplayed;
    }
    public boolean isElementDisplayed(WebElement element, int timeOutInSsec) {
        boolean isElementDisplayed=false;
        try {
            manageImplicitTimeOut(0);
            wait=new WebDriverWait(driver, timeOutInSsec);
            isElementDisplayed=wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

        } catch (Exception e) {
            isElementDisplayed=false;
            logger.error("Exception occurred in isElementDisplayed method: "+e.getMessage());
        }
        finally {
            manageImplicitTimeOut(globalVars.getImplicitWait());
        }
        Utils.logFunctionLevelLogs(isElementDisplayed, "isElementDisplayed");
        return isElementDisplayed;
    }
    public String getElementText(WebElement element, int timeOutInSsec) {
        String text="";
        try {
            manageImplicitTimeOut(0);
            wait=new WebDriverWait(driver, timeOutInSsec);
            text=wait.until(ExpectedConditions.visibilityOf(element)).getText();

        } catch (Exception e) {
            logger.error("Exception occurred in getElementText method: "+e.getMessage());
            manageImplicitTimeOut(globalVars.getImplicitWait());
        }
        manageImplicitTimeOut(globalVars.getImplicitWait());
        logger.info("Element text found :"+ text);
        return text;
    }
    public void manageImplicitTimeOut(long timeOutInSsec) {
        try {
            driver.manage().timeouts().implicitlyWait(timeOutInSsec, TimeUnit.SECONDS);//Setting the implicit wait as zero as implicit and explicit wait do not work together
        } catch (Exception e) {
            logger.error("Exception occurred in manageImplicitTimeOut method: "+e.getMessage());
        }
    }
    public void scrollDownToElement(WebElement elementToScroll) {
        /*JavascriptExecutor js=(JavascriptExecutor)driver;
        RemoteWebElement element = (RemoteWebElement)elementToScroll;
        String elementID=element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID); // Only for ‘scroll in element’
        scrollObject.put("direction", "down");
        scrollObject.put("predicateString","label == 'elementLabel'");
        driver.executeScript("mobile:swipe", scrollObject);
        driver.executeScript("mobile:scroll", scrollObject);*/

        for(int i=0; i<4; i++){
            new TouchAction(driver).press(PointOption.point(500, 700)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                    moveTo(PointOption.point(500, 400)).release().perform();
            if(isElementDisplayed(elementToScroll, 8))
                break;
        }

    }
    public void scrollUpToElement(WebElement elementToScroll) {
        for(int i=0; i<7; i++){
            new TouchAction(driver).press(PointOption.point(500, 400)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                    moveTo(PointOption.point(500, 1000)).release().perform();
            if(isElementDisplayed(elementToScroll, 8))
                break;
        }

    }

    public void clickElementByCoordinates(int x, int y) {
        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(x, y));
        action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
        action.release();
        action.perform();
    }

    public void dragAndDropFromTopToBottom() {
        new TouchAction(driver).press(PointOption.point(500, 300)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).
                moveTo(PointOption.point(500, 1000)).release().perform();
    }

    public void movePickerWheel(WebElement dropdownPicker, WebElement element, String val){
        for(int i=0; i<10; i++) {
            String pickerValue=getElementText(element, 10);
            if(pickerValue.trim().contains(val)) {
                break;
            }
            else{
                clickElement(element);
                pickerWheelStep(dropdownPicker, "next", 0.15);
            }
        }
    }

    public void pickerWheelStep(WebElement element, String direction, double offset) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("order", direction);
        params.put("offset", offset);
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: selectPickerWheelValue", params);
    }

}
