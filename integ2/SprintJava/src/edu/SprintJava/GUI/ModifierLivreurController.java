/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Admin;
import edu.SprintJava.entities.Livreur;
import edu.SprintJava.services.LivreurCRUD;
import edu.SprintJava.utils.Notification;
import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class ModifierLivreurController implements Initializable {

    @FXML
    private TextField TFPrenom;
    @FXML
    private TextField TFEmail;
    @FXML
    private TextField TFUsername;
    @FXML
    private TextField TFNom;
    @FXML
    private PasswordField TFPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TFNom.setText(Livreur.getNomm());
       TFPrenom.setText(Livreur.getPrenomm());
       TFEmail.setText(Livreur.getEmaill());
       TFUsername.setText(Livreur.getUsernamee());
       TFPassword.setText(Livreur.getPasswordd());
    }    

    @FXML
    private void ReturnToAdminPannel(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("HomeAdminPannel.fxml"));
            Scene scene=new Scene(root);
            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void ModifierLivreur(ActionEvent event) throws AWTException {
        LivreurCRUD adc=new LivreurCRUD();
        Livreur ad=new Livreur();
            adc.modifierLivreur(Livreur.getIdd(),TFNom.getText(), TFPrenom.getText(), TFEmail.getText(), TFUsername.getText()
                , TFPassword.getText());
            Notification.main("Livreur !", "Livreur modifié avec succé !!"); 
    }
    
}
