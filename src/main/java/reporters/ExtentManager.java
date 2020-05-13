package reporters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
	
	private static ExtentReports extent;

	public static String extentpath;
	 
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            
            String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            timeStamp="ExtentReport_"+timeStamp;

            extentpath = workingDir+"\\ExtentReports\\" + timeStamp + ".html";
            ExtentHtmlReporter html = new ExtentHtmlReporter(extentpath);

            //ExtentHtmlReporter html = new ExtentHtmlReporter(workingDir+"\\ExtentReports\\" + timeStamp + ".html");
            //ExtentXReporter extentx = new ExtentXReporter("localhost");

            extent = new ExtentReports();
            extent.attachReporter(html);

        }
        return extent;


    }
    
    

}
