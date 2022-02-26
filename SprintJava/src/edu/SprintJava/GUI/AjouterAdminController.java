/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Admin;
import edu.SprintJava.services.AdminCRUD;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

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
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AdminCRUD ad =new AdminCRUD();
        
    }    

    @FXML
    private void AjouterAdmin(ActionEvent event) {
        AdminCRUD adc=new AdminCRUD();
        Admin ad=new Admin();
        ad.setNom(TFnom.getText());
        ad.setPrenom(TFprenom.getText());
        ad.setCin(TFCIN.getLength());
        ad.setEmail(TFemail.getText());
        ad.setUsername(TFlogin.getText());
        ad.setPass(TFpassword.getText());
        adc.ajouterAdmin(ad);
    }

    @FXML
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
    
}
