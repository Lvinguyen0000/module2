package utility;

import entities.user.User;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Properties;
import io.github.cdimascio.dotenv.Dotenv;

public class EmailHandler {
    private final Session session;
    private final Dotenv dotenv = Dotenv.configure().filename("data/variable.env").load();
    private final String username = "lamvinguyen0000@gmail.com";
    public static final String BOOKING_EXPORT_PATH = System.getProperty("user.dir") + "\\data\\excel\\booking.xlsx";

    private static EmailHandler emailHandler = null;

    private EmailHandler(){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Add this line to enable TLS

        // Get the Session object
        session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, dotenv.get("GMAIL_TOKEN"));
            }
        });
    }

    public static EmailHandler getInstance(){
        if (emailHandler == null){
            emailHandler = new EmailHandler();
        }
        return emailHandler;
    }

    public void sendEmail() throws MessagingException{
        String to = username;

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("Test Email");
        message.setText("This is a test email");

        Transport.send(message);
    }

    public void sendEmailAsync() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                sendEmail();
            } catch (MessagingException e) {
                System.out.println("Error sending email: " + e.getMessage());
            }
        });
        executor.shutdown();
    }

    public void sendForgotPassword (String sendTo, String password) throws MessagingException{
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendTo));
        message.setSubject("Forgot password");
        message.setText("This is your password: " + password);

        Transport.send(message);
    }

    public void sendForgotPasswordAsync(String sendTo, String password) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                sendForgotPassword(sendTo, password);
            } catch (MessagingException e) {
                System.out.println("Error sending email: " + e.getMessage());
            }
        });
        executor.shutdown();
    }

    public void sendExcelFile (String sendTo, User user) throws MessagingException, IOException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendTo));
        message.setSubject("Booking information excel file");

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Attachment");

        ExcelExport.getInstance().exportUserBooking(user);

        MimeBodyPart attachmentPart = new MimeBodyPart();
        attachmentPart.attachFile(new File(BOOKING_EXPORT_PATH));

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachmentPart);

        message.setContent(multipart);
        Transport.send(message);
    }

    public void sendExcelFileAsync(String sendTo, User user) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                sendExcelFile(sendTo, user);
            } catch (MessagingException e) {
                System.out.println("Error sending email: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error with the file: " + e.getMessage());
            }
        });
        executor.shutdown();
    }
}
