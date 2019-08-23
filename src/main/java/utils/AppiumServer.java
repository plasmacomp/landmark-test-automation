package utils;
import java.io.*;

public class AppiumServer
{
    public static void startServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
            Thread.sleep(10000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void stopServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
            runtime.exec("taskkill /F /IM cmd.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* public static void main(String[] args)
    {
        try {
            AppiumServer appiumServer = new AppiumServer();
            appiumServer.startServer();
            System.out.println("Appium Server Started");
            Thread.sleep(500);

            appiumServer.stopServer();
            System.out.println("Appium Server Stopped");
            Thread.sleep(200);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

        //appiumServer.stopServer();
    }
*/
}
