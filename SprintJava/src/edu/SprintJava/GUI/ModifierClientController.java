/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Client;
import edu.SprintJava.entities.Session;
import edu.SprintJava.services.ClientCRUD;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class ModifierClientController implements Initializable {

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
    private PasswordField TFPassword;
    @FXML
    private DatePicker DateNaissance;
    @FXML
    private Label lbdate;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TFUsername.setText(Session.getUser().getUsername());
        TFPassword.setText(Session.getUser().getPass());
        ClientCRUD c = new ClientCRUD();
        c.afficherClient(Session.getUser().getUsername()).get(0).getNom();
        TFNom.setText(c.afficherClient(Session.getUser().getUsername()).get(0).getNom());
        TFPrenom.setText(c.afficherClient(Session.getUser().getUsername()).get(0).getPrenom());
        TFEmail.setText(c.afficherClient(Session.getUser().getUsername()).get(0).getEmail());
        lbdate.setText(c.afficherClient(Session.getUser().getUsername()).get(0).getDate_naissance().toString());
        TFMobile.setText(String.valueOf(c.afficherClient(Session.getUser().getUsername()).get(0).getMobile()));
    }

    @FXML
    private void ModifierClientt(ActionEvent event) throws AWTException, IOException {
        ClientCRUD clc = new ClientCRUD();
        LocalDate ldd = DateNaissance.getValue();
        Date dateD = Date.valueOf(ldd);
        ControleSaisie cs = new ControleSaisie();
        if (!cs.testNomPrenom(TFNom.getText())) {
            JOptionPane.showMessageDialog(null, "nom incorrect");
        } else if (!cs.testNomPrenom(TFPrenom.getText())) {
            JOptionPane.showMessageDialog(null, "prenom incorrect");
        } else if (!cs.Mobile(TFMobile.getText())) {
            JOptionPane.showMessageDialog(null, "Mobile incorrect");
        } else {
            clc.modifierClient(TFNom.getText(), TFPrenom.getText(), dateD, Integer.parseInt(TFMobile.getText()),TFEmail.getText(),Session.getUser().getUsername(), TFPassword.getText());
            Notification.main("Client !", TFNom.getText() + " Ajouté avec succé :) ");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeClientPannel.fxml"));
            Parent root = loader.load();
            TFNom.getScene().setRoot(root);
        }
    }

    @FXML
    private void ReturnToClientPannel(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HomeClientPannel.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ViderLabel(ActionEvent event) {
        lbdate.toBack();
    }

}
