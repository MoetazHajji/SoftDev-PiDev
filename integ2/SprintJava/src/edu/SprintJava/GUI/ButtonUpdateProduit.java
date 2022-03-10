/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import com.sun.prism.impl.Disposer;
import edu.SprintJava.entities.Produit;
import edu.SprintJava.services.ProduitCRUD;

import java.io.IOException;
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
import javafx.stage.Stage;

/**
 *
 * @author mariem
 */
public class ButtonUpdateProduit extends TableCell<Disposer.Record, Boolean>{
    
    Stage primaryStage;
      private Stage stage;
     private static Launcher instance;
      private Scene scene;
        final Button cellButton = new Button("modifier");
          Produit pp=new Produit();
         ProduitCRUD service_pr=new ProduitCRUD();
        ButtonUpdateProduit(){
         cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    try {
                        // get Selected Item
                        Produit Produitcourant = (Produit) ButtonUpdateProduit.this.getTableView().getItems().get(ButtonUpdateProduit.this.getIndex());
                        //remove selected item from the table list
                        ObservableList<Produit> list= FXCollections.observableArrayList();
                        service_pr.afficher().forEach((p) -> {
                            list.add(p);
                        });
                        
                        System.out.println(Produitcourant.getId_produit());
                        Produit.setId_courant(Produitcourant.getId_produit());
                        Produit.setNomm(Produitcourant.getNom_produit());
                        Produit.setPrixx(Produitcourant.getPrix());
                        Produit.setStockk(Produitcourant.getStock());
                        System.out.println(list);
                        
                        
                    Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("updateProduit.fxml"))));             
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
