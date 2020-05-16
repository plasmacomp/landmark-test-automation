package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import pages_ios.DashboardPage;
import utils.Constants;
import utils.GlobalVars;


public abstract class CommonDashboardPage {

    private static CommonDashboardPage commonDashboardPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonDashboardPage getInstance(){
        globalVars=GlobalVars.getInstance();
        logger= Log.getInstance();
        if(commonDashboardPage ==null){
            switch(globalVars.getPlatform()){
                case Constants.IOS:
                    commonDashboardPage = DashboardPage.getHomePageInstance();
                    break;
                case Constants.WEB:
                    commonDashboardPage = pages_web.DashboardPage.getHomePageInstance();
            }
        }
        return commonDashboardPage;

    }

    public abstract boolean verifyNewOpportunity();
    public abstract boolean verifyOpportunities();
    public abstract boolean verifyNewContract();
    public abstract boolean verifyContracts();
    public abstract boolean verifySearch();
    public abstract boolean verifyHamburger();
    public abstract boolean verifyDashboardHeaderLabel();
    public abstract boolean verifyProfileIcon();

}

