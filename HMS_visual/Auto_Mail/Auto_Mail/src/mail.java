/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Gagan
 */
public class mail {
    
    public static void sendMail(String recepient) throws Exception{
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "iphms2020@gmail.com";
        String password = "9553653624";
        
        Session session= Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        Message message = prepareMessage(session, myAccountEmail, recepient);
        
        Transport.send(message);
        System.out.println("Mail Sent Succesfully");
    }
    
    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try{
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
        message.setSubject("Hello!");
        message.setText("Thank you For reaching us out");
        return  message;
        } catch (Exception ex) {
            Logger.getLogger(mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
