/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Evenement;
import edu.SprintJava.services.EvenementCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author khalil
 */
public class ParticiperEventController implements Initializable {

    @FXML
    private TableView<Evenement> tvEvenement;
    @FXML
    private TableColumn<Evenement, String>tcNom;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EvenementCRUD lie = new EvenementCRUD();
        ObservableList<Evenement> list = FXCollections.observableArrayList();
        list = lie.listerEvenement();
        remplirTableEvent(list);
    }    
    private void remplirTableEvent(ObservableList<Evenement> list) {
        tcNom.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
        tcNbre_participants.setCellValueFactory(new PropertyValueFactory<>("nbr_participant"));
        tcDate_deb.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        tcDate_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        tcEmplacement.setCellValueFactory(new PropertyValueFactory<>("emplacement"));
        tcDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcTheme.setCellValueFactory(new PropertyValueFactory<>("theme"));
        tvEvenement.setItems(list);
    }
    
}
