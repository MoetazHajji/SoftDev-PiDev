/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Admin;
import edu.SprintJava.services.AdminCRUD;
import edu.SprintJava.utils.Notification;
import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class HomeAdminPannelController implements Initializable {

    @FXML
    private Button btnAddUser;
    @FXML
    private Button btnAdminList;
    @FXML
    private Button btnClientList;
    @FXML
    private Button btnLivreurList;
    @FXML
    private Pane pnlLivreur;
    @FXML
    private Pane pnlClient;
    @FXML
    private Pane pnlAdmin;
    @FXML
    private TableView<Admin> TVListeAdmin;
    @FXML
    private TableColumn<Admin, String> TCNom;
    @FXML
    private TableColumn<Admin, String> TCPrenom;
    @FXML
    private TableColumn<Admin, Integer> TCCIN;
    @FXML
    private TableColumn<Admin, String> TCEmail;
    @FXML
    private TableColumn<Admin, String> TCUsername;
    @FXML
    private TableColumn<Admin, String> TCPassword;
    @FXML
    private TableColumn<?, ?> TCRole;

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AdminCRUD adc = new AdminCRUD();
    ObservableList<Admin> liste = FXCollections.observableArrayList();
            liste= adc.ListerAdmin();
    remplirTable(liste );
    }

    @FXML
    private void AjouterUser(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("AjouterAdmin.fxml"));
            Scene scene=new Scene(root);
            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AfficherAdminList(ActionEvent event) {
        
            pnlAdmin.toFront();
        
    }

    @FXML
    private void AfficherClientList(ActionEvent event) {
        pnlClient.toFront();
    }

    @FXML
    private void AfficherLivreurList(ActionEvent event) {
        pnlLivreur.toFront();
    }

    private void remplirTable(ObservableList<Admin> liste ){
     TCNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    TCPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    TCCIN.setCellValueFactory(new PropertyValueFactory<>("cin"));
    TCEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    TCUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
    TCPassword.setCellValueFactory(new PropertyValueFactory<>("pass"));
    TCRole.setCellValueFactory(new PropertyValueFactory<>("role"));
    TVListeAdmin.setItems(liste);
    }

    @FXML
    private void SupprimerAdmin(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression Admin");
        alert.setHeaderText("Supprimer"+TVListeAdmin.getSelectionModel().getSelectedItem().getId());
        alert.setContentText("Vous voulez vraiment supprimer l'admin " +TVListeAdmin.getSelectionModel().getSelectedItem().getNom() + " ?");
        Optional<ButtonType> result =alert.showAndWait();
        if(result.get()==ButtonType.OK){
            AdminCRUD adc=new AdminCRUD();
            Admin ad=new Admin();
            ad=TVListeAdmin.getSelectionModel().getSelectedItem();
            adc.SupprimerAdmin(ad.getNom());
            try {
                Notification.main("Admin !", "Admin supprimé avec succé !!");
            } catch (AWTException ex) {
                Logger.getLogger(HomeAdminPannelController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ObservableList<Admin> liste=FXCollections.observableArrayList();
                liste=adc.ListerAdmin();
                remplirTable(liste);
        }
        if(result.get()==ButtonType.CANCEL){
            alert.close();
        }
    }

    

}
