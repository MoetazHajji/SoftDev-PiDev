/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.utils;

import com.jfoenix.controls.JFXButton;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author moete
 */
public class ControleSaisie {
    Connection mc=MyConnection.getInstance().getCnx();
    public String masque;
    
    //********************************Nom et Prenom contiennent que des alphabets****************//
    public boolean testNomPrenom(String nom){
        masque="^[a-zA-Z]+[a-z]";
        Pattern pattern=Pattern.compile(masque);
        Matcher controller = pattern.matcher(nom);
        return controller.matches();
    }
    
    //********************************PASSWORD 8 CHIFFRES ****************//
    public boolean testPassword(String password){
        return (password.length()>=8);
    }
    
    public boolean testNum(String num){
        masque="[0-9]+";
        Pattern pattern=Pattern.compile(masque);
        Matcher controller=pattern.matcher(num);
        if(controller.matches()){
            return true;
        }
        return false;
    }
    
    //********************************NUMERO TELEPHONE NE PASSE PAS 8 CHIFFRES **************************************//
    public boolean GSM(String num){
        masque="[0-9]{8}$";
        Pattern pattern=Pattern.compile(masque);
        Matcher controller=pattern.matcher(num);
        if(controller.matches()){
            return true;
        }
        return false;
    }
    public static boolean validateEmailAddress(String emailID) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(emailID).matches();
    }
    
    //******************************TEST FORMAT EMAIL**************************************************//
    public boolean mailFormat(String mail){
        masque ="^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
        Pattern pattern=Pattern.compile(masque);
        Matcher controller = pattern.matcher(mail);
        return controller.matches();
    }
    // *********************************** TEST LOGIN FORAMT ************************************************************
    
    public boolean testUsername(String login){
        masque="^[a-zA-Z]+[a-zA-Z0-9]";
        Pattern pattern=Pattern.compile(masque);
        Matcher controller = pattern.matcher(login);
        return controller.matches();
    }
    /***************************************Test Mail FORMAT***********************************************************/
    
    public Date convert(String date) throws ParseException{
            SimpleDateFormat sdf=new SimpleDateFormat("DD/MM/YYYY");
            Date date1 =(Date) sdf.parse(date);
            
        return  date1;
    }
    //********************************Cin contient 8 chiffres **************************************/

	public boolean Cin(String num) {
		String masque = "[0-9]{8}$";
		Pattern pattern = Pattern.compile(masque);
		Matcher controler = pattern.matcher(num);
		if (controler.matches()) {
			return true;
		}
		return false;
	}
    //********************************Cin contient 8 chiffres **************************************/

	public boolean Mobile(String num) {
		String masque = "[0-9]{8}$";
		Pattern pattern = Pattern.compile(masque);
		Matcher controler = pattern.matcher(num);
		if (controler.matches()) {
			return true;
		}
		return false;
	}
        
        public static final String ICON_IMAGE_LOC = "/img/logo.png";
    public static final String MAIL_CONTENT_LOC = "/resources/mail_content.html";
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public static void setStageIcon(Stage stage) {
        stage.getIcons().add(new Image(ICON_IMAGE_LOC));
    }

    public static String formatDateTimeString(Date date) {
        return DATE_TIME_FORMAT.format(date);
    }

    public static String formatDateTimeString(Long time) {
        return DATE_TIME_FORMAT.format(new Date(time));
    }

    public static String getDateString(Date date) {
        return DATE_FORMAT.format(date);
    }


    public static void openFileWithDesktop(File file) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(ControleSaisie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public boolean testEmplacement(String adr) {
		String masque = "^[a-zA-Z]+[a-zA-Z0-9]";
		Pattern pattern = Pattern.compile(masque);
		Matcher controler = pattern.matcher(adr);
		return controler.matches();
	}
    
    public boolean testAdr(String adr) {
		String masque = "^[a-zA-Z]+[a-zA-Z0-9]";
		Pattern pattern = Pattern.compile(masque);
		Matcher controler = pattern.matcher(adr);
		return controler.matches();
	}
}
