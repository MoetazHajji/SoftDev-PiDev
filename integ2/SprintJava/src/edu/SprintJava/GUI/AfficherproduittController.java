/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import com.jfoenix.controls.JFXButton;
import com.sun.prism.impl.Disposer;
import edu.SprintJava.entities.Produit;
import edu.SprintJava.services.ProduitCRUD;
import edu.SprintJava.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
public class AfficherproduittController implements Initializable {

    @FXML
    private TableColumn<?, ?> col_quantite;
      public AfficherproduittController() {
        con = MyConnection.getInstance().getCnx();

    }
        ProduitCRUD service_pr=new ProduitCRUD();
ObservableList<Produit> list= FXCollections.observableArrayList();

Connection con;

    @FXML
    private TableColumn<Produit, String> col_nom;
    @FXML
    private TableView<Produit> tableview;
    @FXML
    private TableColumn<Produit, String> col_id;
    @FXML
    private TableColumn<Produit, String> col_price;
    @FXML
    private TableColumn<Produit, String> col_categorie;
   
 
    @FXML
    private TableColumn<Produit, String> col_image;
  
    @FXML
    private TableColumn<Produit, String> col_stock;
  
    @FXML
    private Label lblStatus;
    @FXML
    private JFXButton Commande;
    @FXML
    private JFXButton Ajouter;

    /**
     * Initializes the controller class.
     */
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        service_pr.afficher().forEach((p) -> {
            list.add(p);
        });

         
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("prix"));
        col_categorie.setCellValueFactory(new PropertyValueFactory<>("type"));
        
        col_image.setCellValueFactory(new PropertyValueFactory<>("image"));
      
        col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
       
        
      TableColumn col_action = new TableColumn<>("supprimer");
        tableview.getColumns().add(col_action);
        
        
        
        
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
                return new ButtonDeleteProduit();
            }
        
        });
                //modifier
        TableColumn col_modifier = new TableColumn<>("modifier");
        tableview.getColumns().add(col_modifier);
        
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
                return new ButtonUpdateProduit();
            }
        
        });
                tableview.setItems(list);

    }
     @FXML
    void ButtonAjouterProduit(ActionEvent event) throws IOException {
         try {
           Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("affichercommande.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(PanieerrController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void ButtonCommande(ActionEvent event) {
        try {
            Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("ajouterproduit.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(AfficherproduittController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void RetourAdminPannel(ActionEvent event) throws IOException {
        Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("HomeAdminPannel.fxml"))));
    }

    
}
