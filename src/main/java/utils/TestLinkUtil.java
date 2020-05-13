package utils;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import java.net.URL;
import java.time.LocalDateTime;

public class TestLinkUtil{

    private static String buildName;
    private static int testplan_id;
    private static TestLinkAPI testlinkAPIClient;
    private static GlobalVars globalVars;


    //setResult method called by TestMethodListener class for success,failure and skipped test case
    synchronized public static void setResult(int testcaseId, ExecutionStatus status){
        testlinkAPIClient.setTestCaseExecutionResult(testcaseId, null, testplan_id, status, null, null, buildName, null, false, null, null, null, null,false);
    }

    public static void setTestPlan(){
        globalVars=GlobalVars.getInstance();
        try{
            buildName = globalVars.getTestLinkBuildName();
            LocalDateTime localDate = LocalDateTime.now();
            testlinkAPIClient = new TestLinkAPI(new URL(globalVars.getTestLinkUrl()), globalVars.getTestLinkDevKey());
            buildName = buildName + "_" + localDate;
            testlinkAPIClient.createBuild(testplan_id, buildName, "New build according to the date");
        }
        catch (Exception ex){}  //******** MalformedURLException & TestLinkAPIException occured*********

    }
}
