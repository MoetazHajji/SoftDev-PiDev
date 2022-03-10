/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import edu.SprintJava.entities.Commande;
import edu.SprintJava.entities.Produit;
import static edu.SprintJava.entities.Produit.Panier;
import edu.SprintJava.services.CommandeCRUD;
import edu.SprintJava.services.ConcatPDFFiles;
import edu.SprintJava.services.Pdf;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author mariem
 */
public class PanieerrController implements Initializable {

     @FXML
    private AnchorPane anchorpane;
    @FXML
    private Pane pane;
    @FXML
    private Text prix_total;
    @FXML
    private Button valider;
    @FXML
    private JFXButton Commande;
    @FXML
    private JFXButton Ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
     ObservableList<Produit> panier = FXCollections.observableArrayList();
        for (Produit p : Produit.Panier) {
            panier.add(p);
        }
        cart_table(panier);
           

       
    }
 

    public void cart_table(ObservableList<Produit> panier) {
        ObservableList<Produit> panier2 = FXCollections.observableArrayList();
       for(int i=0;i<Produit.Panier.size();i++) {
            panier2.add(Produit.Panier.get(i));
        }
        float prixtotal = 0;
        int prixtotal_cell = 0;
        int k = 0;
        int total_p = 0;
        int i = 0;
        int width = 0;

        //pane pour les produit selectione
        ObservableList<Produit> achat = FXCollections.observableArrayList();
        Pane pane = new Pane();
        pane.setLayoutX(269);
        pane.setLayoutY(106);
        anchorpane.getChildren().add(pane);
        while (i < panier2.size()) //for (int i = 0; i < panier.size(); i++) 
        {

            Produit get = panier2.get(i);

           // achat.add(get);
           
           
            prixtotal = (float) (prixtotal=prixtotal+(panier2.get(i).getPrix()*Produit.getQuantite()));
            
            prix_total.setText(String.valueOf(prixtotal));
            
           Produit.setTotal(prixtotal);
            prixtotal_cell = (int) (prixtotal);
            Group group = new Group();
            group.setLayoutX(0);
            HBox hbglobal = new HBox();
            HBox hb1 = new HBox();
            HBox hb1_1 = new HBox();
            HBox hb2 = new HBox();
            HBox hb3 = new HBox();
            HBox hb4 = new HBox();
            HBox hb5 = new HBox();
            hbglobal.setLayoutX(0);
            hb1.setLayoutX(0);
            hb1_1.setLayoutX(50);
            hb2.setLayoutX(177);
            hb3.setLayoutX(305);
            hb4.setLayoutX(412);
            hb5.setLayoutX(525);
            hbglobal.setLayoutY(20 + k);
            hb1.setLayoutY(65 + k);
            hb1_1.setLayoutY(65 + k);
            hb2.setLayoutY(65 + k);
            hb3.setLayoutY(65 + k);
            hb4.setLayoutY(65 + k);
            hb5.setLayoutY(65 + k);
            /**
             * ********************************
             */
            FontAwesomeIconView delete = new FontAwesomeIconView(FontAwesomeIcon.TIMES_CIRCLE);
            delete.setSize("20");
            delete.setFill(Color.RED);

            delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
                
                @Override
                
                public void handle(MouseEvent event) {
                    pane.getChildren().remove(group);
                    anchorpane.getChildren().remove(pane);
                    Produit.Panier.remove(get);
                    float a =Float.parseFloat(prix_total.getText());
                    prix_total.setText(String.valueOf(a - (Produit.getQuantite() * get.getPrix())));
                 // produitfrontController.nombreproduits = AfficheProduitFrontController.nombreproduits - Produit.getQuantite();
                    cart_table(panier2);
                }
            });

            String A = get.getNom_produit()+".jpg";
            A = "C:\\xampp\\htdocs\\imgproj\\images\\" + A;
            FileInputStream F1;
            try {
                F1 = new FileInputStream (A);
                Image image2 = new Image(F1);
            ImageView image = new ImageView();
            image.setFitWidth(60);
            image.setFitHeight(60);
            image.setImage(image2);
             hb1_1.getChildren().addAll(image);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PanieerrController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Text t2 = new Text(get.getNom_produit());
            Text t3 = new Text(String.valueOf(get.getPrix()));
            TextField t4 = new TextField(String.valueOf(Produit.getQuantite()));
              Produit.setQuantite(Integer.parseInt(t4.getText()));
            t4.setPrefWidth(45);
            Produit pp= new Produit();
            total_p = (int) (pp.getPrix()*Produit.getQuantite());
            Button moin = new Button("-");
            Button plus = new Button("+");
            Text t5 = new Text(String.valueOf(get.getPrix()*Produit.getQuantite()));
            moin.setOnMouseClicked((MouseEvent event) -> {
                int qnt = Integer.parseInt(t4.getText());
                qnt=qnt-1;
                
                Produit.setQuantite(qnt);
             
                t4.setText(String.valueOf(qnt));
                t5.setText(String.valueOf(qnt * get.getPrix()));
                Double a = Double.parseDouble(prix_total.getText());
                prix_total.setText(String.valueOf(a - get.getPrix()));
                Produit.setTotal(Float.valueOf(prix_total.getText()));
               
               
               // AfficheProduitFrontController.nombreproduits--;
               
                
              
              
                
            });
            plus.setOnMouseClicked((MouseEvent event) -> {
                int qnt = Integer.parseInt(t4.getText());
                qnt=qnt+1;
                Produit.setQuantite(qnt);
                t4.setText(String.valueOf(qnt));
                t5.setText(String.valueOf(qnt * get.getPrix()));
                Double a = Double.parseDouble(prix_total.getText());
                prix_total.setText(String.valueOf(a + get.getPrix()));
                 Produit.setTotal(Float.valueOf(prix_total.getText()));
                Produit.setQuantite(qnt);
                pp.decrementerstock(get.getId_produit(),Produit.getQuantite());
               // AfficheProduitFrontController.nombreproduits++;
            });

            /**
             * **********************************
             */
            hb1.getChildren().addAll(delete);
           
            hb1.setStyle("-fx-padding : 15 0 0 15");
            hb1_1.setStyle("-fx-padding : 5 0 0 15");
            hb2.getChildren().add(t2);
            hb2.setStyle("-fx-padding : 15 0 0 15");
            hb3.getChildren().add(t3);
            hb3.setStyle("-fx-padding : 15 0 0 15");
            hb4.getChildren().addAll(moin, t4, plus);
            hb4.setStyle("-fx-padding : 15 0 0 0");
            hb5.getChildren().add(t5);
            hb5.setStyle("-fx-padding : 15 0 0 15");
            group.getChildren().addAll(hb1, hb1_1, hb2, hb3, hb4, hb5);
            Separator sep = new Separator(Orientation.HORIZONTAL);
            sep.setLayoutX(0);
            sep.setLayoutY(144 + k);
            sep.setPrefWidth(sep.getWidth() + 690);
            Separator sep2 = new Separator(Orientation.VERTICAL);
            sep2.setLayoutX(0);
            sep2.setLayoutY(66 + k);
            sep2.setPrefHeight(sep2.getHeight() + 75);
            Separator sep1 = new Separator(Orientation.VERTICAL);
            sep1.setLayoutX(693);
            sep1.setLayoutY(66 + k);
            sep1.setPrefHeight(sep1.getHeight() + 75);
            //pane.getChildren().addAll(hb1,hb2,hb3,hb4,hb5,sep);
            pane.getChildren().addAll(group, sep, sep1, sep2);
            k = k + 80;
            i++;
            
        }
       // panier = (ObservableList<Produit>) achat;
       
      

     //   Produit.Panier = panier;

        //return panier;
    }
    

   
   
        // TODO
        

    @FXML
    private void validationCommande(ActionEvent event) throws IOException {
       // Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("ajoutercommande.fxml"))));
       CommandeCRUD sp = new CommandeCRUD();
        Commande p = new Commande();
         sp.ajouter_commande(p);
    System.out.println("COMMANDE "+Produit.Panier);
    Produit pp=new Produit();
        ObservableList<Produit> commande = Produit.Panier;
        ObservableList<Produit> commande2 = null;
        for (Produit produit : commande) {
            int idp = produit.getId_produit();
            int idc=2;
            produit.setStock(produit.getStock() - produit.getQuantite());
            pp.decrementerstock(produit.getId_produit(),Produit.getQuantite());
            Commande c=new Commande();
            Double prixt = Double.parseDouble(prix_total.getText());
            
           
               java.util.Date date = new java.util.Date();
            java.sql.Date dateSql = new java.sql.Date(date.getTime());
            //     User u ;
           //  u.setId(SignInController.userIden);
                    //       u.setId(1);
            Pdf.TotaleCommande=prixt;
           Pdf.listpanier.addAll(commande);
        Pdf pdf = new Pdf();
        pdf.createpdf();
               
            ConcatPDFFiles concatPdf = new ConcatPDFFiles();
               concatPdf.concat();
        
        }

        ObservableList<Produit> pa = FXCollections.observableArrayList();
        cart_table(pa);
        Produit.Panier = commande2;
        System.out.println("commande after validation "+Panier);
    //    AfficheProduitFrontController.nombreproduits = 0;
      
       
    }


    @FXML
    private void ButtonCommande(ActionEvent event) {
          try {
           Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("produitfront.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(PanieerrController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

    @FXML
    private void ButtonAjouterProduit(ActionEvent event) {
         try {
            Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("produitfront.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(PanieerrController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
