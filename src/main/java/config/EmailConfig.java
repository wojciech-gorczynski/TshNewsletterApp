package config;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailConfig {
    private final Config config;

    public EmailConfig() {
        config = new Config();
    }

    private final Session session = Session.getInstance(mailSetup(), new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(config.getMailTrapUsername(), config.getMailTrapPassword());
        }
    });

    public Properties mailSetup() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "2525");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

        return prop;
    }

    public void sendEmail(String emailId) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("e2eTest@e2eTest.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(config.getMailTrapRecipient()));
            message.setSubject("This is the e2eTest Subject for email with ID" + emailId);
            message.setText("This is e2eTest email");
            Transport.send(message);
            System.out.println("Sent e2eTest message successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
