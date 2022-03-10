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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.management.Notification;

/**
 * FXML Controller class
 *
 * @author khalil
 */
public class AfficherEventController implements Initializable {

    @FXML
    private TableColumn<Evenement, String> tcNom;
    @FXML
    private TableColumn<Evenement, Integer> tcNbre_participants;
    @FXML
    private TableColumn<Evenement, String> tcDate_deb;
    @FXML
    private TableColumn<Evenement, String> tcDate_fin;
    @FXML
    private TableColumn<Evenement, String> tcEmplacement;
    @FXML
    private TableColumn<Evenement, String> tcDescription;
    @FXML
    private TableColumn<Evenement, String> tcTheme;
    @FXML
    private TableView<Evenement> tvEvenement;
    @FXML
    private TableColumn<Evenement, String> image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EvenementCRUD lie = new EvenementCRUD();
        ObservableList<Evenement> list = FXCollections.observableArrayList();
        list = lie.listerEvenement();
        remplirTableEvent(list);
        // TODO
    }

    private void remplirTableEvent(ObservableList<Evenement> list) {
        tcNom.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
        tcNbre_participants.setCellValueFactory(new PropertyValueFactory<>("nbr_participant"));
        tcDate_deb.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        tcDate_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        tcEmplacement.setCellValueFactory(new PropertyValueFactory<>("emplacement"));
        tcDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcTheme.setCellValueFactory(new PropertyValueFactory<>("theme"));
         image.setCellValueFactory(new PropertyValueFactory<>("img"));
        
        tvEvenement.setItems(list);
    }

    @FXML
    private void supprimerEvenement(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression Evenement");
        alert.setHeaderText("Supprimer" + tvEvenement.getSelectionModel().getSelectedItem().getNom_event());
        alert.setContentText("Vous voulez vraiment supprimer l'evenement " + tvEvenement.getSelectionModel().getSelectedItem().getNom_event() + " ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            EvenementCRUD evc = new EvenementCRUD();
            Evenement ev = new Evenement();
            ev = tvEvenement.getSelectionModel().getSelectedItem();
            evc.supprimerEvenementByName(ev.getNom_event());
            ObservableList<Evenement> list = FXCollections.observableArrayList();
            list = evc.listerEvenement();
            remplirTableEvent(list);
        }
        if (result.get() == ButtonType.CANCEL) {
            alert.close();
        }

    }

    @FXML
    private void ModifierEvent(ActionEvent event) {

        try {
            EvenementCRUD evc = new EvenementCRUD();
            Evenement ev = new Evenement();
            ev = tvEvenement.getSelectionModel().getSelectedItem();
            Evenement.setId(ev.getId_event());
            Evenement.setNom(ev.getNom_event());
            Evenement.setD_deb(ev.getDate_debut());
            Evenement.setD_f(ev.getDate_fin());
            Evenement.setDescrip(ev.getDescription());
            Evenement.setTeme(ev.getTheme());
            Evenement.setNbr(ev.getNbr_participant());
            Evenement.setPlace(ev.getEmplacement());
            System.out.println(ev);

            Parent root = FXMLLoader.load(getClass().getResource("ModifierEvent.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void AjouterEvent(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("AjouterEvent.fxml"));
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
