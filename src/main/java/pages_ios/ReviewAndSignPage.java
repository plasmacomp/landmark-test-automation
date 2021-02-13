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


    @iOSXCUITFindBy(accessibility = "ReivewAndSign-PartiesAgreementView-Agent-signature-UIImageView-0")
    private static IOSElement signedForAndOnBehalfOfLandmarkAsAgentTextView;
    @iOSXCUITFindBy(xpath = "ReivewAndSign-PartiesAgreementView-Buyer-signature-UIImageView-0")
    private static IOSElement signedForAndOnBehalfOfBuyerTextView;
    @iOSXCUITFindBy(xpath = "ReivewAndSign-PartiesAgreementView-Vendor-signature-UIImageView-0")
    private static IOSElement signedForAndOnBehalfOfVendorTextView;
    @iOSXCUITFindBy(accessibility = "ReviewAndSign-letterButton")
    private static IOSElement aIconOnSignBelowPage;
    @iOSXCUITFindBy(className = "XCUIElementTypeTextView")
    private static IOSElement signAreaTextField;
    @iOSXCUITFindBy(accessibility = "ReviewAndSign-conditionsCheckbox")
    private static IOSElement agreeToTheTermsAndConditionCheckBox;
    @iOSXCUITFindBy(accessibility = "ReviewAndSign-confirmSwitch")
    private static IOSElement slideToConfirmToggle;
    @iOSXCUITFindBy(accessibility = "lmkecondmoagntsigforvend")
    private static IOSElement agentSignedOnBehalfOfVendorCheckBox;
    @iOSXCUITFindBy(accessibility = "lmkecondmoagntsigforbuyr")
    private static IOSElement buyerAgreementCommunicatedToLandmarkCheckBox;
    @iOSXCUITFindBy(accessibility = "ReivewAndSignController-UIButton-0")
    private static IOSElement emailForSignatureButton;
    @iOSXCUITFindBy(accessibility = "Proceed Signing")
    private static IOSElement proceedSingingPopUpButton;
    @iOSXCUITFindBy(accessibility = "Cancel")
    private static IOSElement cancelSingingPopUpButton;
    @iOSXCUITFindBy(accessibility = "Ok")
    private static IOSElement okButtonPopUp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
    private static IOSElement evidenceOfAgreementPopUpNextButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Return to Dashboard']")
    private static IOSElement returnToDashboardButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Return to Contracts Grid']")
    private static IOSElement returnToContractsGridButton;
    @iOSXCUITFindBy(accessibility = "ReivewAndSignController-UIButton-1")
    private static IOSElement doneButtonReviewAndSignScreen;
    @iOSXCUITFindBy(accessibility = "Save & Close")
    private static IOSElement saveAndCloseButtonReviewAndSignInScreen;
    @iOSXCUITFindBy(accessibility = "Print Contract")
    private static IOSElement printContractButtonReviewAndSignInScreen;
    @iOSXCUITFindBy(accessibility = "Hide keyboard")
    private static IOSElement hideKeyboardButton;



    public boolean signedForAndOnBehalfOfLandmarkAsAgent(String agentSignature, String buyerSignature, String vendorSignature) {
        boolean isSignSuccessful=false;
        try {
            commonFunctions.scrollDownToElement(signedForAndOnBehalfOfLandmarkAsAgentTextView);
            if(commonFunctions.clickElement(signedForAndOnBehalfOfLandmarkAsAgentTextView)){

                sign(agentSignature);
            }

            if(commonFunctions.clickElement(signedForAndOnBehalfOfBuyerTextView)){

                sign(buyerSignature);
            }

            if(commonFunctions.clickElement(signedForAndOnBehalfOfVendorTextView)){

                sign(vendorSignature);
            }

            commonFunctions.clickElement(agentSignedOnBehalfOfVendorCheckBox);
            commonFunctions.clickElement(buyerAgreementCommunicatedToLandmarkCheckBox);

            isSignSuccessful=commonFunctions.clickElement(doneButtonReviewAndSignScreen);

            Utils.logFunctionLevelLogs(isSignSuccessful, "Login"+ globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in Login method"+e.getMessage());
            e.printStackTrace();
        }

        if(isSignSuccessful){
            commonFunctions.clickElement(returnToDashboardButton, 15);
            commonFunctions.clickElement(returnToContractsGridButton, 15);
        }
        return isSignSuccessful;
    }

    public static boolean sign(String signatureText) {
        boolean isSignSuccessful=false;
        try {
            if(commonFunctions.clickElement(aIconOnSignBelowPage)){
                commonFunctions.sendKey(signAreaTextField, signatureText);

                commonFunctions.clickElement(hideKeyboardButton, 8);

                if(commonFunctions.clickElement(agreeToTheTermsAndConditionCheckBox)) {
                    isSignSuccessful = commonFunctions.clickElement(slideToConfirmToggle);
                }
            }
            Utils.logFunctionLevelLogs(isSignSuccessful, "sign"+ globalVars.getPlatform());
        } catch (Exception e) {
            Log.error("Exception occurred in sign method"+e.getMessage());
            e.printStackTrace();
        }

        return isSignSuccessful;
    }
}
