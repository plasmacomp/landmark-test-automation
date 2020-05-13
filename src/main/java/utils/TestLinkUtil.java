package utils;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionType;
import br.eti.kinoshita.testlinkjavaapi.constants.TestCaseDetails;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import base.TestBase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestLinkUtil extends TestBase{

    private static String buildName=GlobalVars.prop.getProperty(Constants.TESTLINK_BUILDNAME);
    private static int testplan_id=Integer.parseInt(GlobalVars.prop.getProperty(Constants.TESTLINK_TESTPLANID));
   // testplan_id=GlobalVars.prop.getProperty(Constants.TESTLINK_TESTPLANID);
    private static TestLinkAPI testlinkAPIClient;


    //setResult method called by TestMethodListener class for success,failure and skipped test case
    synchronized public static void setResult(int testcaseId, ExecutionStatus status){

        testlinkAPIClient.setTestCaseExecutionResult(testcaseId, null, testplan_id, status, null, null, buildName, null, false, null, null, null, null,false);
    }


    public static void setTestPlan() throws MalformedURLException{


         //  testplan_id = Integer.parseInt(GlobalVars.prop.get(Constants.TESTLINK_TESTPLANID).toString());

           buildName = GlobalVars.prop.getProperty(Constants.TESTLINK_BUILDNAME);

           LocalDateTime localDate = LocalDateTime.now();

           testlinkAPIClient = new TestLinkAPI(new URL(GlobalVars.prop.getProperty(Constants.TESTLINK_URL)),
        		   GlobalVars.prop.getProperty(Constants.TESTLINK_DEVKEY));

           buildName = buildName + "_" + localDate;

           testlinkAPIClient.createBuild(testplan_id, buildName, "new build according to the date");

    }




}
