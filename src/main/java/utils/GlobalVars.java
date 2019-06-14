package utils;


import io.appium.java_client.AppiumDriver;

import java.util.Map;
import java.util.Properties;

//This class will have all the global variables to be used across the classes and packages
public class GlobalVars {
    public static AppiumDriver driver;
    public static Properties prop;
    public static String workingDir;
    public static String platform;
    public static String deviceNameAndroid;
    public static String platformVersionAndroid;
    public static String appiumServerIp;
    public static String appiumServerPort;
    public static String apkFileName;
    public static String deviceNameIOS;
    public static String platformVersionIOS;
    public static String ipaFileName;
    public static String udid;
    public static Map<String, DataElements> dataElementMap = null;
}
