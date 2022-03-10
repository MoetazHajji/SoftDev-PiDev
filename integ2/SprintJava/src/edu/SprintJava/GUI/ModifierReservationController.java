/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Activite;
import edu.SprintJava.entities.Reservation;
import edu.SprintJava.services.ActiviteCRUD;
import edu.SprintJava.services.ReservationCRUD;
import edu.SprintJava.utils.ControleSaisie;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Soulaymen
 */
public class ModifierReservationController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfNbre_places;
    @FXML
    private TextField tfNum;
    @FXML
    private TextField tfEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierRes(ActionEvent event) throws IOException {
         ControleSaisie cs = new ControleSaisie();
        if (!cs.testNomPrenom(tfNom.getText())) {
            JOptionPane.showMessageDialog(null, "Insérer un nom correct");
        } else if (!cs.testNomPrenom(tfPrenom.getText())) {
            JOptionPane.showMessageDialog(null, "Insérer un prénom correct");
        } else if ( (!cs.GSM(tfNum.getText()))) {
            JOptionPane.showMessageDialog(null, "Insérer un numéro valide SVP ");
        } else if ((!cs.mailFormat(tfEmail.getText()))) {
            JOptionPane.showMessageDialog(null, "Insérer un Email valide SVP ");
        } else {
         ReservationCRUD act = new ReservationCRUD();
            Reservation a = new Reservation();

            act.modifierReservation(tfNom.getText(), tfPrenom.getText(),"20/03/2022",
                    50, Integer.parseInt(tfNbre_places.getText()),
                   Integer.parseInt(tfNum.getText()), tfEmail.getText());
            //Notification.main("Activite !", "Activité modifié avec succé !!");  
            
                Parent root = FXMLLoader.load(getClass().getResource("AfficherReservation.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         
                Parent root = FXMLLoader.load(getClass().getResource("AfficherReservation.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            
    }
    
}
