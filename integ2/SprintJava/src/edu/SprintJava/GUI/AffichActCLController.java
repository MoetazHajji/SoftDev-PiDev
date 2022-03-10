/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import edu.SprintJava.entities.Activite;
import edu.SprintJava.entities.Commentaire;
import edu.SprintJava.entities.Produit;
import edu.SprintJava.entities.Resteau;
import edu.SprintJava.services.ActiviteCRUD;
import edu.SprintJava.services.CommentaireResteau;
import edu.SprintJava.services.ServiceResteau;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mariem
 */
public class AffichActCLController implements Initializable {

  
    
   public static int index = 0;
        public static int idd=0;

    @FXML
    private Button rechercherRestauFront;
    @FXML
    private JFXListView<Pane> listViewRestau;
    @FXML
    private TextField rechercheRestau;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
        
        
    public void listRestau(){
       // ObservableList<Pane> refresh = FXCollections.observableArrayList();
       // listViewRestau.setItems(refresh);
         ServiceResteau sp = new ServiceResteau();
        ObservableList<Pane> Panes = FXCollections.observableArrayList();
        for (Resteau p3 :  sp.getListResteau())  {
           // System.out.println(p3);
            FileInputStream F1 = null;
            
                Pane pane = new Pane();
                pane.setStyle(" -fx-background-color: white");
                Pane pane2 = new Pane();
                pane2.setLayoutX(150);
                pane2.setLayoutY(150);
                pane2.setPrefWidth(pane2.getWidth() + 250);
                pane2.setPrefHeight(pane2.getHeight() + 150);
                pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10 10 10 10;-fx-border-color: #3f2b63;");
                final Button btnCommenter = new Button("Commentez");    
                btnCommenter.setStyle("-fx-alignment:right");
                btnCommenter.setStyle("-fx-background-color: #B0E0E6;");
                 btnCommenter.setLayoutX(650);
                 btnCommenter.setOnAction(event -> {try{
                Resteau.setIdd(p3.getIdR());
                  CommentaireResteau C = new CommentaireResteau();
             
              //r.setIdR(Resteau.getIdd());
              Commentaire.setIdres(Resteau.getIdd());

            URL fxURL = getClass().getResource("../gui/AddCmntrForm.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
           
            stage.show();
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();


        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }  
               
                              //CommentaireResteau C = new CommentaireResteau();

                           // Commentaire C1 = getTableView().getItems().get(getIndex());
                                                                 
                                                           
                       });
                 
                 
                }
            }
        
    
    



   
}
