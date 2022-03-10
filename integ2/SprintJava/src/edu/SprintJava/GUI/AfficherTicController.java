/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Evenement;
import edu.SprintJava.entities.Ticket;
import edu.SprintJava.services.EvenementCRUD;
import edu.SprintJava.services.TicketCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * =
 * FXML Controller class
 *
 * @author khalil
 */
public class AfficherTicController implements Initializable {

    @FXML
    private TableView<Ticket> tvTicket;
    @FXML
    private TableColumn<Ticket, Integer> tcId_ticket;
    @FXML
    private TableColumn<Ticket, String> tcPack;
    @FXML
    private TableColumn<Ticket, Integer> tcPrix;
    @FXML
    private TableColumn<Ticket, Integer> tcId_client;
    @FXML
    private TableView<Evenement> TVevent;
    @FXML
    private TableColumn<Evenement, Integer> TCeVENTID;
    @FXML
    private TableColumn<Ticket, Integer> tcId_event;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TicketCRUD lie = new TicketCRUD();
        EvenementCRUD ec = new EvenementCRUD();
        ObservableList<Ticket> list = FXCollections.observableArrayList();
        ObservableList<Evenement> list1 = FXCollections.observableArrayList();
        list = lie.listerTicket();
        remplirTableTic(list);
        list1 = ec.listerEvenement();
        remplirTableTicEvent(list1);
        // TODO*/
    }

    private void remplirTableTicEvent(ObservableList<Evenement> list) {
        TCeVENTID.setCellValueFactory(new PropertyValueFactory<>("id_event"));
        TVevent.setItems(list);
    }

    private void remplirTableTic(ObservableList<Ticket> list) {

        tcId_ticket.setCellValueFactory(new PropertyValueFactory<>("id_ticket"));
        tcPack.setCellValueFactory(new PropertyValueFactory<>("Packet"));
        tcPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tcId_event.setCellValueFactory(new PropertyValueFactory<>("id_event"));
        tcId_client.setCellValueFactory(new PropertyValueFactory<>("id_c"));

        tvTicket.setItems(list);
    }

    @FXML
    private void supprimerTicket(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression Ticket");
        alert.setHeaderText("Supprimer" + tvTicket.getSelectionModel().getSelectedItem().getId_ticket());
        alert.setContentText("Vous voulez vraiment supprimer le ticket " + tvTicket.getSelectionModel().getSelectedItem().getId_ticket() + " ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            TicketCRUD evc = new TicketCRUD();
            Ticket ev = new Ticket();
            ev = tvTicket.getSelectionModel().getSelectedItem();
            evc.supprimerTicket(ev.getId_ticket());
            ObservableList<Ticket> list = FXCollections.observableArrayList();
            list = evc.listerTicket();
            remplirTableTic(list);
        }
        if (result.get() == ButtonType.CANCEL) {
            alert.close();
        }

    }

    @FXML
    private void ModifierTic(ActionEvent event) {

        try {
            TicketCRUD tc = new TicketCRUD();
            Ticket t = new Ticket();
            t = tvTicket.getSelectionModel().getSelectedItem();
            Ticket.setPr(t.getPrix());
            Ticket.setId_cl(t.getId_c());
            Ticket.setId_e(t.getId_event());
            Ticket.setId_t(t.getId_ticket());
            Ticket.setPac(t.getPacket());

            System.out.println(t);

            Parent root = FXMLLoader.load(getClass().getResource("ModifierTic.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void AjouterTicket(ActionEvent event) {

        try {
            EvenementCRUD evc = new EvenementCRUD();
            Evenement ev = new Evenement();
            ev = TVevent.getSelectionModel().getSelectedItem();
            Evenement.setIdeee(ev.getId_event());
            Parent root = FXMLLoader.load(getClass().getResource("AjouterTic.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Acceuil(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
