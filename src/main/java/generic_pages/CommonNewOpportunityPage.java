package generic_pages;

import logger.Log;
import org.apache.log4j.Logger;
import pages_ios.NewOpportunityPage;
import utils.Constants;
import utils.GlobalVars;

public abstract class CommonNewOpportunityPage {
    private static CommonNewOpportunityPage commonNewOpportunityPage;
    public static GlobalVars globalVars;
    public static Logger logger;

    public static CommonNewOpportunityPage getInstance(){
        globalVars=GlobalVars.getInstance();
        logger= Log.getInstance();
        if(commonNewOpportunityPage ==null){
            switch(globalVars.getPlatform()){
                case Constants.IOS:
                    commonNewOpportunityPage = NewOpportunityPage.getInstance();
                    break;
                case Constants.WEB:
                    commonNewOpportunityPage = pages_web.NewOpportunityPage.getInstance();
            }
        }
        return commonNewOpportunityPage;

    }

    public abstract boolean createNewOpportunity(String title, String vendorName);
    public abstract boolean verifyNewOpportunityHeaderLabel();
    public abstract boolean verifySalesInformationLabel();
    public abstract boolean verifyVendorInfoLabel();
    public abstract boolean verifyLotsLabel();
    public abstract boolean verifyNotesLabel();
    public abstract boolean verifyAttachmentsLabel();
    public abstract boolean verifyNewOpportunityNavigation();
}
