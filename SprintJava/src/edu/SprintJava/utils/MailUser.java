/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import edu.SprintJava.entities.MailServerInfo;
import edu.SprintJava.services.User_service;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author moete
 */
public class MailUser {
       
      
       public static void sendMail(String recepient) throws Exception{
        System.out.println("Preparing to send:");
        Properties properties = new Properties();
        
        
       
        
        properties.put("com.hof.email.starttime","20170519094544");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.connectiontimeout","60000");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","25");
        properties.put("mail.smtp.ssl.trust","*");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.timeout","60000");
        properties.put("mail.transport.protocol","smtp");
        
         String myAccountEmail ="moetezh20@gmail.com";
         String password ="Taztaz07";
        
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        Message message = prepareMessage(session,myAccountEmail,recepient);
        
        Transport.send(message);
        System.out.println("message send successfully");
    }
    
    
    private static Message prepareMessage(Session session, String myAccountEmail, String recepient){
        try {
            User_service Act = new User_service();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("La listes des User");
            message.setText("hey There , \n Look my email");
            //message.setText(Act.getListActivite2().toString());
            return message;
        } catch (MessagingException ex) {
            java.util.logging.Logger.getLogger(MailUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }

}
