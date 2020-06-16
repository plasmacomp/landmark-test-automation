package pages_ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctionsMobile;
import utils.GlobalVars;
import utils.Utils;

public class ReviewAndSignPage {
    private AppiumDriver driver;
    static CommonFunctionsMobile commonFunctions=null;
    private static GlobalVars globalVars;
    private static ReviewAndSignPage reviewAndSignPage;

    public ReviewAndSignPage() {
        globalVars=GlobalVars.getInstance();
        this.driver = globalVars.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions=CommonFunctionsMobile.getInstance();
    }

    public static ReviewAndSignPage getInstance(){
        if(reviewAndSignPage ==null){
            reviewAndSignPage =new ReviewAndSignPage();
        }
        return reviewAndSignPage;
    }


    @iOSXCUITFindBy(xpath = "//###################")
    private static IOSElement signedForAndOnBehalfOfLandmarkAsAgentTextView;
    @iOSXCUITFindBy(xpath = "//###################")
    private static IOSElement signedForAndOnBehalfOfBuyer;
    @iOSXCUITFindBy(xpath = "//###################")
    private static IOSElement signedForAndOnBehalfOfVendor;
    @iOSXCUITFindBy(xpath = "//###################")
    private static IOSElement aIconOnSignBelowPage;
    @iOSXCUITFindBy(xpath = "//###################")
    private static IOSElement signAreaTextField;
    @iOSXCUITFindBy(xpath = "//###################")
    private static IOSElement agreeToTheTermsAndConditionCheckBox;
    @iOSXCUITFindBy(xpath = "//###################")
    private static IOSElement slideToConfirmToggle;
    @iOSXCUITFindBy(xpath = "//###################")
    private static IOSElement agentSignedOnBehalfOfVendorCheckBox;
    @iOSXCUITFindBy(xpath = "//###################")
    private static IOSElement buyerAgreementCommunicatedToLandmarkCheckBox;
    @iOSXCUITFindBy(xpath = "//###################")
    private static IOSElement emailForSignatureButton;



    public boolean signedForAndOnBehalfOfLandmarkAsAgent(String signatureText) {
        boolean isSignSuccessful=false;
        try {
            commonFunctions.scrollDownToElement(signedForAndOnBehalfOfLandmarkAsAgentTextView);
            if(commonFunctions.clickElement(signedForAndOnBehalfOfLandmarkAsAgentTextView)){
                if(commonFunctions.clickElement(aIconOnSignBelowPage)){
                    commonFunctions.sendKey(signAreaTextField, signatureText);
                    commonFunctions.clickElement(agreeToTheTermsAndConditionCheckBox);
                    if(commonFunctions.clickElement(slideToConfirmToggle)){
                        commonFunctions.clickElement(agentSignedOnBehalfOfVendorCheckBox);
                        commonFunctions.clickElement(buyerAgreementCommunicatedToLandmarkCheckBox);
                        isSignSuccessful=commonFunctions.clickElement(emailForSignatureButton);
                    }
                }
            }
            Utils.logFunctionLevelLogs(isSignSuccessful, "Login"+ globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in Login method"+e.getMessage());
            e.printStackTrace();
        }
        return isSignSuccessful;
    }
}
