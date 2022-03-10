/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Client;
import edu.SprintJava.entities.User;
import edu.SprintJava.enumm.Genre;
import edu.SprintJava.services.ClientCRUD;
import edu.SprintJava.services.User_service;
import edu.SprintJava.utils.ControleSaisie;
import edu.SprintJava.utils.Notification;
import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class AjouterClientController implements Initializable {

    @FXML
    private TextField TFPassword;
    @FXML
    private TextField TFPrenom;
    @FXML
    private TextField TFMobile;
    @FXML
    private TextField TFEmail;
    @FXML
    private TextField TFUsername;
    @FXML
    private TextField TFNom;
    @FXML
    private TextField TFPaysVille;
    @FXML
    private TextField TFGenre;
    Genre gn;
    @FXML
    private DatePicker DateNaissance;
    @FXML
    private RadioButton Homme;
    @FXML
    private RadioButton Femme;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gn=Genre.Male;
        
    }    

    @FXML
    private void AjouterClientt(ActionEvent event) throws IOException, AWTException {
        ClientCRUD clc=new ClientCRUD();
        LocalDate ldd=DateNaissance.getValue();
        Date dateD=Date.valueOf(ldd);
        
        ControleSaisie cs = new ControleSaisie();
        if(!cs.testNomPrenom(TFNom.getText())){
            JOptionPane.showMessageDialog(null,"nom incorrect");
        }
        else if(!cs.testNomPrenom(TFPrenom.getText())){
            JOptionPane.showMessageDialog(null,"prenom incorrect");
        }
        else if(!cs.Mobile(TFMobile.getText())){
            JOptionPane.showMessageDialog(null,"Mobile incorrect");
        }
//        else if(!cs.mailFormat(dateD.toString())){
//            JOptionPane.showMessageDialog(null,"Email incorrect");
//        }
        else if(!cs.testNomPrenom(TFUsername.getText())){
           JOptionPane.showMessageDialog(null,"Username incorrect");
       }
       else if(!cs.testPassword(TFPassword.getText())){
            JOptionPane.showMessageDialog(null,"Password incorrect");
        }
        else{
            Client cl = new Client(TFNom.getText(), TFPrenom.getText(), dateD, TFPaysVille.getText(), Integer.parseInt(TFMobile.getText())
                    , TFEmail.getText(), TFUsername.getText(), TFPassword.getText(), gn);
            clc.ajouterClient(cl);
            User_service us = new User_service();
            us.ajouterUser(new User(TFUsername.getText(),TFPassword.getText(),"Client"));
            Notification.main("Client !", TFNom.getText()+" Ajouté avec succé :) ");
            FXMLLoader loader= new FXMLLoader(getClass().getResource("LoginClient.fxml"));
            Parent root = loader.load();
            TFNom.getScene().setRoot(root);
        }
    }

    @FXML
    private void ReturnToLogin(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("LoginClient.fxml"));
            Scene scene=new Scene(root);
            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GetGenre(ActionEvent event) {
        if(Homme.isSelected()){
              gn = Genre.Male;
          }
          if(Femme.isSelected()){
              gn = Genre.Female;
          }
    }

   
    
}
