/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Commentaire;
import edu.SprintJava.entities.Evenement;
import edu.SprintJava.entities.Session;
import edu.SprintJava.entities.Ticket;
import edu.SprintJava.services.TicketCRUD;
import edu.SprintJava.utils.ControleSaisie;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author khalil
 */
public class AjouterTicController implements Initializable {

    ObservableList<String> types = FXCollections.observableArrayList("GOLD", "SILVER",
            "BRONZE ");

    @FXML
    private TextField tfId_event;
    @FXML
    private TextField tfPrix;
    @FXML
    private ChoiceBox<String> cbtype;
    @FXML
    private TextField tfId_Admin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Ticket.setId_usss(Session.getUser().getId());
        System.out.println(Session.getUser().getId());
        tfId_Admin.setText(Integer.toString(Session.getUser().getId()));
        System.out.println(Evenement.getIdeee());
         
        tfId_event.setText(Integer.toString(Evenement.getIdeee()));
        cbtype.setItems(types);
        cbtype.setValue("GOLD");
    }

    @FXML
    private void AjouterTicket(ActionEvent event) throws IOException {
        TicketCRUD tc = new TicketCRUD();
        Ticket t= new Ticket();
        ControleSaisie cs = new ControleSaisie();
        Ticket.setId_usss(Session.getUser().getId());
             if (!cs.testNum(tfPrix.getText())) {
            JOptionPane.showMessageDialog(null, "Le prix est incorrect, pas de caractére!");
        } else {
            Ticket t1 = new Ticket(Evenement.getIdeee(),
                    Integer.parseInt(tfPrix.getText()) ,cbtype.getValue() );
            tc.ajouterTicket();
//            t.setId_event(Evenement.getId());
//            t.setPrix(Integer.parseInt(tfPrix.getText()));
//            t.setPacket(cbtype.getValue());
            
            JOptionPane.showMessageDialog(null, "Ticket ajouté ✓");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterTic.fxml"));
            Parent root = loader.load();
            tfPrix.getScene().setRoot(root);
        }
    }

    @FXML
    private void GestionTicket(ActionEvent event
    ) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherTic.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
