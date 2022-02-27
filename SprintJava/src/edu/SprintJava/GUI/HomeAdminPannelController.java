/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Admin;
import edu.SprintJava.entities.Client;
import edu.SprintJava.entities.Livreur;
import edu.SprintJava.services.AdminCRUD;
import edu.SprintJava.services.ClientCRUD;
import edu.SprintJava.services.LivreurCRUD;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    private TableColumn<Admin, String> TCRole;
    @FXML
    private Label TitreAdmin;
    @FXML
    private TableView<Client> TVClient;
    @FXML
    private TableColumn<Client, String> TCNomClient;
    @FXML
    private TableColumn<Client, String> TCPrenomClient;
    @FXML
    private TableColumn<Client, String> TCDateNaissance;
    @FXML
    private TableColumn<Client, String> TCPaysVille;
    @FXML
    private TableColumn<Client, Integer> TCMobile;
    @FXML
    private TableColumn<Client, String> TCEmailClient;
    @FXML
    private TableColumn<Client, String> TCUsernameClient;
    @FXML
    private TableColumn<Client, String> TCPasswordClient;
    @FXML
    private TableColumn<Client, String> TCGenre;
    @FXML
    private TableView<Livreur> TVLivreur;
    @FXML
    private TableColumn<Livreur, String> TCNomLivreur;
    @FXML
    private TableColumn<Livreur, String> TCPrenomLivreur;
    @FXML
    private TableColumn<Livreur, String> TCEmailLivreur;
    @FXML
    private TableColumn<Livreur, String> TCUsernameLivreur;
    @FXML
    private TableColumn<Livreur, String> TCPasswordLivreur;
    @FXML
    private TextField TFNomLivreur;
    @FXML
    private TextField TFPrenomLivreur;
    @FXML
    private TextField TFEmailLivreur;
    @FXML
    private TextField TFUsernameLivreur;
    @FXML
    private PasswordField TFPasswordLivreur;
    @FXML
    private TextField TFUpdAdNom;
    @FXML
    private TextField TFUpdAdPrenom;
    @FXML
    private TextField TFUpdAdEmail;
    @FXML
    private TextField TFUpdAdPassword;
    @FXML
    private TextField TFUpdAdUsername;
    @FXML
    private TextField TFUpdAdCIN;
    @FXML
    private TextField TFUpdAdRole;
    @FXML
    private Pane pnlModifyAdmin;

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //******** Lister dans table admin *****************/
        AdminCRUD adc = new AdminCRUD();
        ObservableList<Admin> liste = FXCollections.observableArrayList();
        liste= adc.ListerAdmin();
        remplirTableAdmin(liste );
        //************ Lister dans table Client ***********/
        ClientCRUD clc = new ClientCRUD();
        ObservableList<Client> listeClient=FXCollections.observableArrayList();
        listeClient=clc.ListerClient();
        remplirTableClient(listeClient);
        //************ Lister dans table Livreur ***********/
        LivreurCRUD  lic = new LivreurCRUD();
        ObservableList<Livreur> listeLivreur=FXCollections.observableArrayList();
        listeLivreur=lic.ListerLivreur();
        remplirTableLivreur(listeLivreur);
//        LoadDataLivreur();
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
    
    @FXML
    private void AfficherAdminModify(ActionEvent event) {
        pnlModifyAdmin.toFront();
    }
    
    private void remplirTableAdmin(ObservableList<Admin> liste ){
     TCNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    TCPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    TCCIN.setCellValueFactory(new PropertyValueFactory<>("cin"));
    TCEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    TCUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
    TCPassword.setCellValueFactory(new PropertyValueFactory<>("pass"));
    TCRole.setCellValueFactory(new PropertyValueFactory<>("role"));
    TVListeAdmin.setItems(liste);
    }
    private void remplirTableClient(ObservableList<Client> listeClients ){
     TCNomClient.setCellValueFactory(new PropertyValueFactory<>("nom"));
    TCPrenomClient.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    TCDateNaissance.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
    TCPaysVille.setCellValueFactory(new PropertyValueFactory<>("pays_ville"));
    TCMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    TCEmailClient.setCellValueFactory(new PropertyValueFactory<>("email"));
    TCUsernameClient.setCellValueFactory(new PropertyValueFactory<>("username"));
    TCPasswordClient.setCellValueFactory(new PropertyValueFactory<>("password"));
    TCGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
    TVClient.setItems(listeClients);
    }
    private void remplirTableLivreur(ObservableList<Livreur> listeLivreur ){
     TCNomLivreur.setCellValueFactory(new PropertyValueFactory<>("nom"));
    TCPrenomLivreur.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    TCEmailLivreur.setCellValueFactory(new PropertyValueFactory<>("email"));
    TCUsernameLivreur.setCellValueFactory(new PropertyValueFactory<>("username"));
    TCPasswordLivreur.setCellValueFactory(new PropertyValueFactory<>("password"));
    TVLivreur.setItems(listeLivreur);
    }

    @FXML
    private void SupprimerAdmin(ActionEvent event) throws Exception {
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
                Notification.main("Admin !", "Admin supprimé avec succé !!");       
                ObservableList<Admin> liste=FXCollections.observableArrayList();
                liste=adc.ListerAdmin();
                remplirTableAdmin(liste);
        }
        if(result.get()==ButtonType.CANCEL){
            alert.close();
        }
    }

    @FXML
    private void Logout(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root=loader.load();
            TitreAdmin.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeAdminPannelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AjouterLivreur(ActionEvent event) {
        LivreurCRUD lic=new LivreurCRUD();
        Livreur li=new Livreur();
        li.setNom(TFNomLivreur.getText());
        li.setPrenom(TFPrenomLivreur.getText());
        li.setEmail(TFEmailLivreur.getText());
        li.setUsername(TFUsernameLivreur.getText());
        li.setPassword(TFPasswordLivreur.getText());
        lic.ajouterLivreur(li);
    }

    @FXML
    private void LoadDataLivreur()  {
        LivreurCRUD lic = new LivreurCRUD();
        TVLivreur.setItems(lic.ListerLivreur());
        TCNomLivreur.setCellFactory(new PropertyValueFactory<>("nom"));
        TCPrenomLivreur.setCellFactory(new PropertyValueFactory<>("prenom"));
        TCEmailLivreur.setCellFactory(new PropertyValueFactory<>("email"));
        TCUsernameLivreur.setCellFactory(new PropertyValueFactory<>("username"));
        TCPasswordLivreur.setCellFactory(new PropertyValueFactory<>("password"));
        
            TVLivreur.getSelectionModel().getSelectedItem();
            TCNomLivreur.setCellFactory(TextFieldTableCell.forTableColumn());
            TCNomLivreur.setOnEditCommit(e->{
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setNom(e.getNewValue());
            });
            
            TCPrenomLivreur.setCellFactory(TextFieldTableCell.forTableColumn());
            TCPrenomLivreur.setOnEditCommit(e->{
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setPrenom(e.getNewValue());
            });
            
            TCEmailLivreur.setCellFactory(TextFieldTableCell.forTableColumn());
            TCEmailLivreur.setOnEditCommit(e->{
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setEmail(e.getNewValue());
            });
            
            TCUsernameLivreur.setCellFactory(TextFieldTableCell.forTableColumn());
            TCUsernameLivreur.setOnEditCommit(e->{
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setUsername(e.getNewValue());
            });
            
            TCPasswordLivreur.setCellFactory(TextFieldTableCell.forTableColumn());
            TCPasswordLivreur.setOnEditCommit(e->{
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setPassword(e.getNewValue());
            });
            
       TVLivreur.setEditable(true);
    }

//    @FXML
//    private void LoadDataClient(SortEvent<C> event) {
//        
//    }

    @FXML
    private void ModifierAdmin() {
        TableColumn<Admin , Void> colBtn =new TableColumn("Edit");
        
        Callback<TableColumn<Admin , Void>,TableCell<Admin , Void>> cellFactory=(final TableColumn<Admin , Void> param)->{
            final TableCell<Admin , Void> cell=new TableCell<Admin , Void>(){
                private final Button btn =new Button("Update");
                {
                    btn.setOnAction((ActionEvent event)-> {
                        Admin data = getTableView().getItems().get(getIndex());
                        AdminCRUD adc= new AdminCRUD();
                        adc.modifierAdmin(data.getNom(), data.getPrenom(), data.getCin(), data.getUsername(), data.getEmail(), data.getPass(), data.getRole());
                            System.out.println("Selected Data : "+data);
                    });
                }
                
                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            };
            return cell;
        };
        colBtn.setCellFactory(cellFactory);
        
        TVListeAdmin.getColumns().add(colBtn);
    }

   

    

    

    

}
