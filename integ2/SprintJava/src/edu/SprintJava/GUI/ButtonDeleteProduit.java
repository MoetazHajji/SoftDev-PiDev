/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import com.sun.prism.impl.Disposer.Record;
import edu.SprintJava.entities.Produit;
import edu.SprintJava.services.ProduitCRUD;

//import com.larvard.Entity.Product;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

//import com.larvard.Service.ServiceProduct;
//import com.larvard.test.LarvardPI;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 *
 * @author mouhamed
 */

class ButtonDeleteProduit extends TableCell<Record, Boolean> {
    Stage primaryStage;
      private Stage stage;
     private static Launcher instance;
      private Scene scene;
        final Button cellButton = new Button("supprimer");
        
         ProduitCRUD service_pr=new ProduitCRUD();
        ButtonDeleteProduit(){
         cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    try {
                        // get Selected Item
                        Produit Produitcourant = (Produit) ButtonDeleteProduit.this.getTableView().getItems().get(ButtonDeleteProduit.this.getIndex());
                        //remove selected item from the table list
                        ObservableList<Produit> list= FXCollections.observableArrayList();
                        service_pr.afficher().forEach((p) -> {
                            list.add(p);
                        });
                        System.out.println(Produitcourant);
                        list.remove(Produitcourant);
                        service_pr.supprimer(Produitcourant);
                        System.out.println(list);
                      Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("Afficherproduitt.fxml"))));             
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonDeleteProduit.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
        
                    }
        
        

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
               // setGraphic(cellButton2);
                setGraphic(cellButton);
            }
        }
         
    }
    