package com.ttn.framework.utils;

import com.ttn.framework.tests.base.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.ITestResultNotifier;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class SendMailSSLWithAttachmentUtil extends BaseClass {

    public static void sendEmail(ITestContext context) {

        // Create object of Property file
        Properties props = new Properties();

        // this will set host of server- you can change based on your requirement
        props.put("mail.smtp.host", "smtp.gmail.com");

        // set the port of socket factory
        props.put("mail.smtp.socketFactory.port", "465");

        // set socket factory
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

        // set the authentication to true
        props.put("mail.smtp.auth", "true");

        // set the port of SMTP server
        props.put("mail.smtp.port", "465");

        // This will handle the complete authentication
        Session session = Session.getDefaultInstance(props,

                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(properties.getProperty(GlobalContants.EMAIL_ID),
                                DecodeUtil.decode(properties.getProperty(GlobalContants.EMAIL_PASSWORD)));

                    }

                });

        try {

            // Create object of MimeMessage class
            Message message = new MimeMessage(session);

            // Set the from address
            message.setFrom(new InternetAddress("testautomationuser@tothenew.com"));

            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("sunil.mahakur@tothenew.com, vibhor.agarwal@tothenew.com"));


            // Add the subject link
            message.setSubject(GlobalContants.REPORT_NAME);

            // Create object to add multimedia type content
            BodyPart messageBodyPart1 = new MimeBodyPart();



            messageBodyPart1.setContent(
                    "<h3>TEST EXECUTION SUMMARY</h3>\n" +
                            "<p style=\"color:black;\"><b>TOTAL TESTCASES : "+ GlobalContants.TEST_RESULT_COUNT.size()+"</b></p>\n"+
                            "<p style=\"color:green;\">PASS : "+ context.getPassedTests().size()+"</p>" +
                            "<p style=\"color:red;\">FAIL : "+context.getFailedTests().size()+"</p>"+
                            "<p style=\"color:orange;\">SKIP : "+ context.getSkippedTests().size()+"</p>" +
                            "<p style=\"color:black;\"><b><u>Job Overall Status : </u></b></p>\n\n" +
                            "<p style=\"color:black;\">=>>  Please refer attached report for execution details</p>",

                    "text/html");


            // Create another object to add another content
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            File file = new File(GlobalContants.REPORT_PATH);

            // Mention the file which you want to send
            String filename = file.getPath();


            // Create data source and pass the filename
            DataSource source = new FileDataSource(filename);

            // set the handler
            messageBodyPart2.setDataHandler(new DataHandler(source));

            // set the file
            messageBodyPart2.setFileName(GlobalContants.REPORT_NAME+ ".html");

            // Create object of MimeMultipart class
            Multipart multipart = new MimeMultipart();

            // add body part 1
            multipart.addBodyPart(messageBodyPart2);

            // add body part 2
            multipart.addBodyPart(messageBodyPart1);

            // set the content
            message.setContent(multipart);

            // finally send the email
            Transport.send(message);

            System.out.println("=====Email Sent Successfully =====");
        } catch (MessagingException e) {

            throw new RuntimeException(e);

        }

    }

}