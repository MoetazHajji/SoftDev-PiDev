/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.SprintJava.entities.Produit;
import edu.SprintJava.services.ProduitCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author mariem
 */
public class UpdateProduitController implements Initializable {

    @FXML
    private Button update;
    @FXML
    private JFXTextField prix_pr;
    @FXML
    private JFXTextField stock_pr;
    @FXML
    private ImageView image_p;
    @FXML
    private JFXTextField nom_pr;
    @FXML
    private Label lblStatus;
    @FXML
    private JFXButton Produits;
    @FXML
    private JFXButton Commande;

    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        Produit p = new Produit();
        System.out.println(Produit.getId_courant());
         nom_pr.setText(Produit.getNomm());
            
       prix_pr.setText(Float.toString(Produit.getPrixx()));
       
      
               
       stock_pr.setText(Integer.toString(Produit.getStockk()));
       
    }    

    @FXML
    private void update(ActionEvent event) {
        
        
       
       
        
         ProduitCRUD sp = new ProduitCRUD();
          int id=Produit.getId_courant();
      
       
        String nom= nom_pr.getText();
        float prix=Integer.parseInt(prix_pr.getText());

        
       int stock=Integer.parseInt(stock_pr.getText());
        
       
        
     
        sp.modifier(id, nom, prix, stock);
         nom_pr.setText("");
            
       prix_pr.setText("");
       
      
               
       stock_pr.setText("");
       
    }

    @FXML
    private void ButtonProduit(ActionEvent event) {
         try {
            Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("afficherproduitt.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(UpdateProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ButtonCommande(ActionEvent event) {
       
    }


    private void ButtonAjouterProduit(ActionEvent event) {
        try {
           Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("ajouterproduit.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(UpdateProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RetourProduitPannel(ActionEvent event) {
    }
    
}
