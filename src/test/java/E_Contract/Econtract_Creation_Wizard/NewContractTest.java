package E_Contract.Econtract_Creation_Wizard;

import base.TestBase;
import org.springframework.util.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages_ios.GridPage;
import pages_ios.NewContractPage;
import utils.GlobalVars;
import utils.Utils;


public class NewContractTest {
    private static NewContractPage newContractPage;
    private static GridPage gridPage;
    GlobalVars globalVars;



    @BeforeTest
    public void initialization(){
        globalVars = TestBase.setup(this.getClass().getSimpleName());
        newContractPage = NewContractPage.getInstance();
        gridPage=GridPage.getInstance();
    }

    @Test
    public void verifyOpportunityIdNavigationFromGridPage() {
        boolean isResult=false;
        isResult = gridPage.goToOpportunityIdFromGrid(globalVars.getRecordId());
        Utils.logStepInfo(isResult, "Verify that New Opportunity Header label is present");
        Assert.isTrue(isResult, "Step-1:  New Opportunity Header label verification failed!!");
    }

    @Test
    public void verifyNewContractNavigationFromListingPage() {
        boolean isResult=false;
        isResult = gridPage.goToNewContractFromListingPage();
        Utils.logStepInfo(isResult, "Click on New Opportunity tile");
        Assert.isTrue(isResult, "Step-1: Could not click on new opportunity tile!!");
    }

    @Test
    public void verifyFillingNewContract() {
        boolean isResult=false;
        String salesType="Agent settlement";
        String branchName="Alexandra";
        String buyerName="AJ Pointon & AW Pointon";
        String deliveryPoint="Test Point";
        String updatedRecordId=globalVars.getRecordId();
        isResult = gridPage.fillContractDetailsFromListingPage(updatedRecordId, salesType, branchName, buyerName, deliveryPoint);
        Utils.logStepInfo(isResult, "Verify that Sales Information label is present");
        Assert.isTrue(isResult, "Step-1:  Sales Information label verification failed!!");
    }

    @AfterTest
    public void closeDriver(ITestContext context){
        TestBase.tearDownSuite(context);
    }
}
