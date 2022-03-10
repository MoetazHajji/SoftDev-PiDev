/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

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
public class ModifierTicController implements Initializable {

    ObservableList<String> types = FXCollections.observableArrayList("GOLD", "SILVER",
            "BRONZE");

    private TextField tfId;
    private TextField tfPacket;
    @FXML
    private TextField tfPrix;
    @FXML
    private ChoiceBox<String> cbPacket;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbPacket.setItems(types);
        cbPacket.setValue("GOLD");
        // TODO
        tfPrix.setText(Integer.toString(Ticket.getPr()));
    }

    @FXML
    private void ModifierTic(ActionEvent event) throws IOException {
        TicketCRUD tc = new TicketCRUD();
        ControleSaisie cs = new ControleSaisie();
        if (tfPrix.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "veuillez remplir le champ prix");
        } else if (!cs.testNum(tfPrix.getText())) {
            JOptionPane.showMessageDialog(null, "Le prix incorrect, pas de caractére!");
        } else {
            Ticket t = new Ticket();

            tc.modifierTicket(Ticket.getId_t() ,cbPacket.getValue(), Integer.parseInt(tfPrix.getText()));
            JOptionPane.showMessageDialog(null, "Ticket modifier  ✓");
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierTic.fxml"));
//            Parent root = loader.load();
        }

    }

    @FXML
    private void GestionTic(ActionEvent event) {
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
