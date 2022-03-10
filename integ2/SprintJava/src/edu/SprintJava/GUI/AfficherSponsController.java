/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Evenement;
import edu.SprintJava.entities.Sponsor;
import edu.SprintJava.services.EvenementCRUD;
import edu.SprintJava.services.SponsorCRUD;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khalil
 */
public class AfficherSponsController implements Initializable {

    @FXML
    private TableView<Sponsor> tvSponsor;
    @FXML
    private TableColumn<Sponsor, String> tcNom_spons;
    @FXML
    private TableColumn<Sponsor, String> tcPrenom_spons;
    @FXML
    private TableColumn<Sponsor, Integer> tcNum_spons;
    @FXML
    private TableColumn<Sponsor, String> tcType_spons;
    @FXML
    private TableColumn<Sponsor, Integer> tcId_event;
    @FXML
    private TableView<Evenement> TVEvent;
    @FXML
    private TableColumn<Evenement, String> TCEvent;
    @FXML
    private TableColumn<Evenement, String> TCNomEvent;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SponsorCRUD sc = new SponsorCRUD();
        EvenementCRUD ec = new EvenementCRUD();
        ObservableList<Sponsor> list = FXCollections.observableArrayList();
        ObservableList<Evenement> list1 = FXCollections.observableArrayList();
        list = sc.listerSponsor();
        list1 = ec.listerEvenement();
        remplirTableSponsor(list);
        remplirTableEvenement(list1);
        // TODO
    }

    private void remplirTableEvenement(ObservableList<Evenement> list) {

        tcId_event.setCellValueFactory(new PropertyValueFactory("id_event"));
        TCNomEvent.setCellValueFactory(new PropertyValueFactory("nom_event"));

        TVEvent.setItems(list);
    }

    private void remplirTableSponsor(ObservableList<Sponsor> list) {

        tcNom_spons.setCellValueFactory(new PropertyValueFactory("nom_sponsor "));
        tcPrenom_spons.setCellValueFactory(new PropertyValueFactory("prenom_sponsor "));
        tcNum_spons.setCellValueFactory(new PropertyValueFactory("num_sponsor"));
        tcType_spons.setCellValueFactory(new PropertyValueFactory("type_sponsor"));
        tcId_event.setCellValueFactory(new PropertyValueFactory("id_event "));

        tvSponsor.setItems(list);
    }

    @FXML
    private void SupprimerSponsor(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression Sponsor");
        alert.setHeaderText("Supprimer" + tvSponsor.getSelectionModel().getSelectedItem().getNom_sponsor());
        alert.setContentText("Vous voulez vraiment supprimer le sponsor " + tvSponsor.getSelectionModel().getSelectedItem().getNom_sponsor() + " ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            SponsorCRUD sc = new SponsorCRUD();
            Sponsor s = new Sponsor();
            s = tvSponsor.getSelectionModel().getSelectedItem();
            sc.supprimerSponsor(s.getNom_sponsor());
            ObservableList<Sponsor> list = FXCollections.observableArrayList();
            list = sc.listerSponsor();
            remplirTableSponsor(list);
        }
        if (result.get() == ButtonType.CANCEL) {
            alert.close();
        }

    }

    @FXML
    private void ModifierSponsor(ActionEvent event) {

        try {
            SponsorCRUD evc = new SponsorCRUD();
            Sponsor ev = new Sponsor();
            ev = tvSponsor.getSelectionModel().getSelectedItem();
            Sponsor.setId_s(ev.getId_sponsor());
            Sponsor.setId_e(ev.getId_event());
            Sponsor.setN_s(ev.getNum_sponsor());
            Sponsor.setNom_s(ev.getNom_sponsor());
            Sponsor.setPrenom_s(ev.getPrenom_sponsor());
            Sponsor.setType_s(ev.getType_sponsor());

            System.out.println(ev);
            Parent root = FXMLLoader.load(getClass().getResource("ModifierSpons.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void AjouterSponsor(ActionEvent event) {

        try {
            EvenementCRUD evc = new EvenementCRUD();
            Evenement ev = new Evenement();
            ev = TVEvent.getSelectionModel().getSelectedItem();
            Evenement.setIdeee(ev.getId_event());
            Evenement.setNom(ev.getNom_event());
            Parent root = FXMLLoader.load(getClass().getResource("AjouterSpons.fxml"));
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

    @FXML
    private void EnvoyerSms(ActionEvent event) {

        try {
            SponsorCRUD evc = new SponsorCRUD();
            Sponsor ev = new Sponsor();
            ev = tvSponsor.getSelectionModel().getSelectedItem();
            Sponsor.setNom_s(ev.getNom_sponsor());
            Sponsor.setN_s(ev.getNum_sponsor());

            Parent root = FXMLLoader.load(getClass().getResource("EnvoyerSms.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
