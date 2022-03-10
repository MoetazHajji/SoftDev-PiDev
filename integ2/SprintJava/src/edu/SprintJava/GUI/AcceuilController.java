/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Evenement;
import edu.SprintJava.services.EvenementCRUD;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khalil
 */
public class AcceuilController implements Initializable {
    
    @FXML
    private ListView<Evenement> tvevent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EvenementCRUD evc = new EvenementCRUD();
        evc.listerEvenement().stream().sorted((e1, e2) -> e2.getNbr_participant() - e1.getNbr_participant())
                .limit(3).forEach(e -> tvevent.getItems().add(e));
        
    }    

    @FXML
    private void Evenement(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherEvent.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Sponsor(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherSpons.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Ticket(ActionEvent event) throws IOException {
        Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("AfficherTic.fxml"))));
        
    }

    @FXML
    private void RetourAdminPannel(ActionEvent event) throws IOException {
        Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("HomeAdminPannel.fxml"))));
    }
}
