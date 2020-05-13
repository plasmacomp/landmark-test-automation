package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.*;

import java.util.concurrent.TimeUnit;

public class WebBase extends TestBase{
    static WebDriver webDriver;
    static GlobalVars globalVars;

    @Override
    public void initializeDriver() {
        globalVars=GlobalVars.getInstance();
        if(webDriver==null){
            initializeWebDriver();
        }
    }

    public static void initializeWebDriver(){
        try{
            System.setProperty(Constants.WEB_DRIVER_CHROME, globalVars.getWebDriverPath());
            globalVars.setWebDriver(new ChromeDriver());
            webDriver=globalVars.getWebDriver();
            webDriver.manage().window().maximize();
            webDriver.get(globalVars.getUatUrl());
            webDriver.manage().timeouts().implicitlyWait(globalVars.getImplicitWait(), TimeUnit.SECONDS);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void closeDriver(){
        if(webDriver!=null)
            webDriver.quit();

    }
}
