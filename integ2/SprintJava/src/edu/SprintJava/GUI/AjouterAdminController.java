/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Admin;
import edu.SprintJava.entities.Attachement;
import edu.SprintJava.entities.User;
import edu.SprintJava.services.AdminCRUD;
import edu.SprintJava.services.AttachementService;
import edu.SprintJava.services.User_service;
import edu.SprintJava.utils.ControleSaisie;
import edu.SprintJava.utils.Notification;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 * 
 * @author moete
 */
public class AjouterAdminController implements Initializable {
    @FXML
    private javafx.scene.control.TextField TFnom;
    @FXML
    private javafx.scene.control.TextField TFprenom;
    @FXML
    private javafx.scene.control.TextField TFCIN;
    @FXML
    private javafx.scene.control.TextField TFemail;
    @FXML
    private javafx.scene.control.TextField TFlogin;
    @FXML
    private javafx.scene.control.TextField TFpassword;
    @FXML
    private javafx.scene.control.TextField TFAvatar;
    @FXML
    private ImageView imgAvatar;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AdminCRUD adc =new AdminCRUD();
//        Admin ad=new Admin();
//        AttachementService as = new AttachementService();
//        Attachement a = as.findById(ad.getAvatar());
//        //System.out.println((Session.getUser().getAvatar()));
//        File file = new File(a.getPath());
//        javafx.scene.image.Image image = new javafx.scene.image.Image(file.toURI().toString());
//        imgAvatar.setImage(image);
        
    }    

    @FXML
    private void AjouterAdmin(ActionEvent event) throws IOException, AWTException, SQLException {
       AdminCRUD adc=new AdminCRUD();
        ControleSaisie cs = new ControleSaisie();
        if(!cs.testNomPrenom(TFnom.getText())){
            JOptionPane.showMessageDialog(null,"First name is non Valid please enter only Alphabet !! ");
        }
        else if(!cs.testNomPrenom(TFprenom.getText())){
            JOptionPane.showMessageDialog(null,"Last name is non Valid please enter only Alphabet !! ");
        }
        else if(!cs.testNomPrenom(TFemail.getText())){
            JOptionPane.showMessageDialog(null,"Invalid Email !!");
        }
        else if(!cs.Cin(TFCIN.getText())){
            JOptionPane.showMessageDialog(null,"CIN Invalid u need to enter 8 numbers");
        }
        else if(!cs.testUsername(TFlogin.getText())){
            JOptionPane.showMessageDialog(null,"Username Invalid ");
        }
        else if(!cs.testPassword(TFpassword.getText())){
            JOptionPane.showMessageDialog(null,"Password is not Strong ");
        }
        
        else{
            Admin ad = new Admin(TFnom.getText(), TFprenom.getText(),  Integer.parseInt(TFCIN.getText()), TFlogin.getText()
                    , TFemail.getText(), TFpassword.getText(),TFAvatar.getText());
            adc.ajouterAdmin(ad);
            User_service us = new User_service();
            us.ajouterUser(new User(TFlogin.getText(),TFpassword.getText(),"Admin",TFAvatar.getText()));
            JOptionPane.showMessageDialog(null,"Admin ajouté");
            Notification.main("Admin !!", "New Admin "+TFlogin.getText()+"added Succefuly ");
            FXMLLoader loader= new FXMLLoader(getClass().getResource("HomeAdminPannel.fxml"));
            Parent root = loader.load();
            TFnom.getScene().setRoot(root);
        }
        
    }

    private void BackToMainWindow(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene=new Scene(root);
            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RetourAdminPannel(ActionEvent event) {
         try {
            Parent root=FXMLLoader.load(getClass().getResource("HomeAdminPannel.fxml"));
            Scene scene=new Scene(root);
            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int idA,idC; 
    @FXML
    private void upload(ActionEvent event) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        Attachement a1 = new Attachement();
        AttachementService as = new AttachementService();
        a1.setName("");
        a1.setPath(filename);
       idA =  as.ajouterAttachement(a1);
       Image image = new Image(f.toURI().toString());
       imgAvatar.setImage(image);
       TFAvatar.setText(filename);
    }
    
}
