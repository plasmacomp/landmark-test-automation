package utils;

import io.appium.java_client.AppiumDriver;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonFunctionsWeb extends CommonFunctions{
    static WebDriver driver;
    WebDriverWait wait;

    @Override
    public void assignDriverObject() {
        driver=globalVars.getWebDriver();
    }
    @Override
    public boolean clickElement(WebElement element, int timeOutInSec) {
        boolean isElementClicked=false;
        try{
            //manageImplicitTimeOut(0);
            wait=new WebDriverWait(driver, timeOutInSec);
            wait.until(ExpectedConditions.visibilityOf(element)).click();
            isElementClicked=true;
        }
        catch (Exception e) {
            logger.error("Exception occurred in clickElement method: "+e.getMessage());
            //manageImplicitTimeOut(globalVars.getImplicitWait());
        }
        //manageImplicitTimeOut(globalVars.getImplicitWait());
        Utils.logFunctionLevelLogs(isElementClicked, "clickElement");
        return isElementClicked;
    }

    @Override
    public boolean clickElement(WebElement element) {
        return false;
    }

    @Override
    public void sendKey(WebElement element, String key) {

    }

    @Override
    public boolean isElementDisplayed(WebElement element) {
        return false;
    }

    @Override
    public boolean isElementDisplayedByXpath(String xpath) {
        return false;
    }

    @Override
    public void sendKey(WebElement element, String key, int timeOutInSec) {
        try {
            manageImplicitTimeOut(0);//Setting the implicit wait as zero as implicit and explicit wait do not work together
            wait=new WebDriverWait(driver, timeOutInSec);
            wait.until(ExpectedConditions.visibilityOf(element)).clear();element.sendKeys(key);
            Utils.logFunctionLevelLogs(true, "sendKey");
        } catch (Exception e) {
            logger.error("Exception occurred in sendKey method: "+e.getMessage());
            manageImplicitTimeOut(globalVars.getImplicitWait());
        }
        manageImplicitTimeOut(globalVars.getImplicitWait());
    }

    @Override
    public boolean isElementDisplayed(WebElement element, int timeOutInSec) {
        boolean isElementDisplayed=false;
        try {
            manageImplicitTimeOut(0);
            wait=new WebDriverWait(driver, timeOutInSec);
            isElementDisplayed=wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

        } catch (Exception e) {
            isElementDisplayed=false;
            logger.error("Exception occurred in isElementDisplayed method: "+e.getMessage());
            manageImplicitTimeOut(globalVars.getImplicitWait());
        }
        manageImplicitTimeOut(globalVars.getImplicitWait());
        Utils.logFunctionLevelLogs(isElementDisplayed, "isElementDisplayed");
        return isElementDisplayed;
    }

    @Override
    public String getElementText(WebElement element, int timeOutInSec) {
        String text="";
        try {
            manageImplicitTimeOut(0);
            wait=new WebDriverWait(driver, timeOutInSec);
            text=wait.until(ExpectedConditions.visibilityOf(element)).getText();

        } catch (Exception e) {
            logger.error("Exception occurred in getElementText method: "+e.getMessage());
            manageImplicitTimeOut(globalVars.getImplicitWait());
        }
        manageImplicitTimeOut(globalVars.getImplicitWait());
        logger.info("Element Text found : "+text);
        return text;
    }

    @Override
    public void manageImplicitTimeOut(long timeOutInSec) {
        try {
            driver.manage().timeouts().implicitlyWait(timeOutInSec, TimeUnit.SECONDS);//Setting the implicit wait as zero as implicit and explicit wait do not work together
        } catch (Exception e) {
            logger.error("Exception occurred in manageImplicitTimeOut method: "+e.getMessage());
        }
    }
}
