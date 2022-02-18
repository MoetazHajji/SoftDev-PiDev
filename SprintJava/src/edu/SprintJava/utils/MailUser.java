/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.utils;

import edu.SprintJava.services.AdminCRUD;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author moete
 */
public class MailUser {
    public static void senMail(String id_user , String body) {
        try {
            System.out.println("Preparing to send Mail :");
            Properties propertie = new Properties();
            
            String myAccountEmail ="SofDev01@gmail.com";
            String password="Sofdev123";
            
            propertie.put("com.hof.email.starttime", "20170519094544");
            propertie.put("mail.smtp.auth", "true");
            propertie.put("mail.smtp.connectiontimeout", "60000");
            propertie.put("mail.smtp.host", "smtp.gmail.com");
            propertie.put("mail.smtp.port", "25");
            propertie.put("mail.smtp.trust", "*");
            propertie.put("mail.smtp.ssl.trust", "true");
            propertie.put("mail.smtp.timeout", "60000");
            propertie.put("mail.smtp.protocol", "smtp");
            
            
            Session session = Session.getInstance(propertie,new Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(myAccountEmail, password);
                }
            });
            
            Message message=prepareMessage(session,myAccountEmail,id_user,body);
            Transport.send(message);
            System.out.println("Message send successfully");
        } catch (MessagingException ex) {
            Logger.getLogger(MailUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static Message prepareMessage(Session session,String myAccountEmail,String recepient,String Body){
        try {
            AdminCRUD adc = new AdminCRUD();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Information de compte ");
            message.setText(Body);
            
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(MailUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
