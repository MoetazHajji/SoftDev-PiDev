/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import com.jfoenix.controls.JFXButton;
import com.sun.prism.impl.Disposer;
import edu.SprintJava.entities.Commande;
import edu.SprintJava.entities.Produit;
import edu.SprintJava.services.CommandeCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author mariem
 */
public class AffichercommandeController implements Initializable {

      @FXML
    private TableView<Commande> tabcmd;
    
    @FXML
    private TableColumn<Commande,Integer> num;

    @FXML
    private TableColumn<Commande,Integer> id_user;

    @FXML
    private TableColumn<Produit,Integer> produitt;

    @FXML
    private TableColumn<Commande,String> nom;

    @FXML
    private TableColumn<Commande,String> adresse;

    @FXML
    private TableColumn<Commande,Integer> tel;

    @FXML
    private TableColumn<Commande,String> etat;

    @FXML
    private TableColumn<Commande,String> date_commande;

    @FXML
    private TableColumn<Commande,Float> total_prix;

    @FXML
    private JFXButton Accueil;

    @FXML
    private JFXButton Produits;


    @FXML
    private Label lblStatus;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Commande> list= FXCollections.observableArrayList();
        
        CommandeCRUD service_pr=new CommandeCRUD();
        service_pr.afficher().forEach((p) -> {
            list.add(p);
        });
        
        System.out.println(list);
      
        num.setCellValueFactory(new PropertyValueFactory<>("num"));
        id_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        produitt.setCellValueFactory(new PropertyValueFactory<>("produit"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
      
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
         etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
          date_commande.setCellValueFactory(new PropertyValueFactory<>("date_commande"));
          total_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
       

          TableColumn col_action = new TableColumn<>("supprimer");
            tabcmd.getColumns().add(col_action);
        
        
        
        
        col_action.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_action.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

    
                    
             @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new Buttondeletecommande();
            }
        
        });
        
                //modifier
        TableColumn col_modifier = new TableColumn<>("valider");
        tabcmd.getColumns().add(col_modifier);
        
        col_modifier.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_modifier.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonUpdateetat();
            }
        
        });
          TableColumn col_sms = new TableColumn<>("envoyer sms");
        tabcmd.getColumns().add(col_sms);
        
        col_modifier.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_sms.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new buttonsms();
            }
        
        });
                tabcmd.setItems(list);

    }
     void ButtonAjouterProduit(ActionEvent event) throws IOException {
        Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("ajouterproduit.fxml"))));
    }

    void ButtonCommande(ActionEvent event) {
        try {
          Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("ajouterproduit.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(AfficherproduittController.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }    

    @FXML
    private void buttonaccuiel(ActionEvent event) {
          try {
            Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("HomeAdminPannel.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(AfficherproduittController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void buttonProduit(ActionEvent event) {
          try {
          Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("afficherproduitt.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(AfficherproduittController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
