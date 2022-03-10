/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import edu.SprintJava.entities.Produit;
import edu.SprintJava.services.ProduitCRUD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.Scene;
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
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author mariem
 */
public class ProduitfrontController implements Initializable {

  
    
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXListView<Pane> ListView_Produits;
    @FXML
    private TextField rechercher;
    @FXML
    private JFXListView<Pane> ListView_Produits1;
    @FXML
    private ImageView panier;
    @FXML
    private Label nbrnotif;
    @FXML
    private AnchorPane anchor;

    /**
     * Initializes the controller class.
     */
    
   // private boolean Verif;
    public String recherche = "";
    public static int nombreproduits = 0;
   int qtt=0;
    ProduitCRUD service_pr = new ProduitCRUD();
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        //transition.setRate(1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
           transition.play();
                 
                
            
        });
        ListView_Produits.setFocusTraversable( false );
        getShowPane();
         
        //panier
        if (nombreproduits >= 1) {
            nombreproduits--;
            ListeCommande();
        }
        ListView_Produits1.setVisible(false);
        ListView_Produits1.setPrefWidth(ListView_Produits1.getWidth() + 300);
        ListView_Produits1.setPrefHeight(ListView_Produits1.getHeight() + 500);
        
       
         
    }

    public void ListeCommande() {
       ObservableList<Pane> refresh = FXCollections.observableArrayList();
        ListView_Produits1.setItems(refresh);
        nombreproduits = nombreproduits + 1;
        nbrnotif.setText(String.valueOf(nombreproduits));

/////////////////panier ///////////////////////      
        ObservableList<Pane> Panes = FXCollections.observableArrayList();
        for (Produit p3 : Produit.Panier) {

            FileInputStream F1 = null;
            try {
                Pane pane = new Pane();
                pane.setStyle(" -fx-background-color: white");
                Pane pane2 = new Pane();
                pane2.setLayoutX(10);
                pane2.setLayoutY(10);
                pane2.setPrefWidth(pane2.getWidth() + 200);
                pane2.setPrefHeight(pane2.getHeight() + 80);
                pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10 10 10 10;-fx-border-color: #3f2b63;");
                String A = p3.getNom_produit()+".jpg";
               
                A = "C:\\xampp\\htdocs\\imgproj\\images\\" + A;
                F1 = new  FileInputStream(A);
                Image image2 = new Image(F1);
                ImageView image = new ImageView(image2);
                image.setFitWidth(60);
                image.setFitHeight(60);
                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");
                image.setImage(image2);
                image.setLayoutX(10);
                image.setLayoutY(10);
                pane2.getChildren().add(image);
                
                
                
                Pane panequantitet = new Pane();
                panequantitet.setLayoutX(100);
                panequantitet.setLayoutY(40);
                panequantitet.setPrefWidth(panequantitet.getWidth() + 160);
                panequantitet.setPrefHeight(panequantitet.getHeight() + 30);
                Text quan1 = new Text("Quantite : ");
                Label quant2 = new Label(String.valueOf(Produit.getQuantite()));
                quan1.setLayoutX(10);
                quan1.setLayoutY(20);
                quant2.setLayoutX(90);
                quant2.setLayoutY(5);
                quan1.setStyle("-fx-font-weight: bold;-fx-fill : #d82819;-fx-font-size:15px;");
                quant2.setStyle("-fx-font-weight: bold;-fx-fill : #d82819;-fx-font-size:15px;");
                panequantitet.getChildren().addAll(quan1, quant2);
                Text nomt = new Text("Nom: ");
                Label nom = new Label(p3.getNom_produit());
                Text prixt = new Text("prix : ");
                Label prix = new Label(String.valueOf(p3.getPrix()) + " DT");
                nomt.setLayoutX(100);
                nomt.setLayoutY(20);
                nom.setLayoutX(150);
                nom.setLayoutY(10);
                prixt.setLayoutX(100);
                prixt.setLayoutY(35);
                prix.setLayoutX(150);
                prix.setLayoutY(25);
                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                
                pane2.getChildren().addAll(nomt, prixt, nom, prix, panequantitet);
                Panes.add(pane2);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProduitfrontController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    F1.close();
                } catch (IOException ex) {
                    Logger.getLogger(ProduitfrontController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        if (Produit.getPanier().size() == 1) {

            ListView_Produits1.setPrefHeight(ListView_Produits1.getHeight() + 25);
        }
        ListView_Produits1.setItems(Panes);
    }


    public void getShowPane() {
        List<Produit> AllProducts = new ArrayList();
        if (recherche.equals("")) {
            for (Produit p : service_pr.afficher()) {
                AllProducts.add(p);
            }
        } else {
            for (Produit p : service_pr.RechercheProduitParNom(recherche)) {
                AllProducts.add(p);

            }

        }
        int i = 0;
        int j = 0;
        ObservableList<Pane> Panes = FXCollections.observableArrayList();

        List<Produit> ThreeProducts = new ArrayList();
        for (Produit p : AllProducts) {
            if (i == 0) {
                ThreeProducts.add(p);
                i++;
                j++;

                if (j == AllProducts.size()) {
                    Panes.add(AddPane(ThreeProducts));

                    ThreeProducts.clear();
                }

            } else {
                ThreeProducts.add(p);
                i++;
                j++;
                if ((i % 3 == 0) || (j == AllProducts.size())) {
                    Panes.add(AddPane(ThreeProducts));

                    ThreeProducts.clear();

                }
            }
        }

        ObservableList<Pane> refresh = FXCollections.observableArrayList();
        ListView_Produits.setItems(refresh);
        ListView_Produits.setItems(Panes);
    }

    public Pane AddPane(List<Produit> ThreeProduct) {
        Pane pane = new Pane();
        pane.setStyle(" -fx-background-color: white");
        int k = 1;
        for (Produit p3 : ThreeProduct) {
            if (k == 1) {
                FileInputStream F1 = null;
                try {
                    Pane pane2 = new Pane();
                    pane2.setLayoutX(25);
                    pane2.setLayoutY(50);
                    pane2.setPrefWidth(pane2.getWidth() + 215);
                    pane2.setPrefHeight(pane2.getHeight() + 200);
                    pane2.setStyle("-fx-background-radius: 50;");
                    pane2.setStyle(" -fx-border-radius: 10;-fx-border-color:  #3f2b63 ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                    JFXButton t = new JFXButton("");
                    JFXButton t1 = new JFXButton("acheter");
                    t.setStyle("-fx-font-weight: bold; -fx-background-color : white;");
                    t1.setStyle("-fx-font-weight: bold;-fx-background-color : white;");
                    HBox hb = new HBox(t);
                    HBox hb2 = new HBox(t1);
                    hb.setLayoutX(0);
                    hb.setLayoutY(150);
                    hb.setPrefWidth(hb.getWidth() + 200);
                    hb.setPrefHeight(hb.getHeight() + 80);
                    hb.setStyle("-fx-background-color:  #3f2b63; -fx-background-radius: 0 0 0 10;");
                    hb2.setLayoutX(155);
                    hb2.setLayoutY(170);
                    hb2.setPrefWidth(hb.getWidth() + 61);
                    hb2.setPrefHeight(hb.getHeight() + 35);
                    hb2.setStyle("-fx-background-color:  #3f2b63; ; -fx-background-radius: 0 0 10 0;");
                    pane2.getChildren().addAll(hb, hb2);
                    String A = p3.getNom_produit()+".jpg";
                    System.out.println(A);
                    String B = "C:\\xampp\\htdocs\\imgproj\\images\\" + A;
                    F1 = new FileInputStream(B);
                    Image image2 = new Image(F1);
                    ImageView image = new ImageView(image2);
                    image.setFitWidth(140);
                    image.setFitHeight(130);
                    image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");
                    image.setImage(image2);
                    image.setLayoutX(40);
                    image.setLayoutY(-45);
                    pane2.getChildren().add(image);
                    
                    Rating rating = new Rating();
                rating.setPrefWidth(20);
                rating.setPrefHeight(19);
                rating.setLayoutX(50);
                rating.setLayoutY(180);
                
                int rate = 0;
                 rating.onMouseClickedProperty().set(new EventHandler<MouseEvent>()
             {
                  int kk=0;
          @Override
          public void handle(MouseEvent arg0)
          {
             
           kk=kk+1;
                       System.out.println(kk);
                       service_pr.AjouterRating(kk, p3.getId_produit());

          }
        });
                
                    try {
                       
                       rate = service_pr.AfficherRating(p3.getId_produit());
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(ProduitfrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
               
                rating.ratingProperty().setValue(rate);
                rating.setVisible(true);
                    
                    Text nomt = new Text("Nom : ");
                    Label nom = new Label(p3.getNom_produit());
                    Text prixt = new Text("prix : ");
                    Label prix = new Label(String.valueOf(p3.getPrix()) + " DT");
                    nomt.setLayoutX(50);
                    nomt.setLayoutY(160);
                    nom.setLayoutX(100);
                    nom.setLayoutY(145);
                    prixt.setLayoutX(50);
                    prixt.setLayoutY(180);
                    prix.setLayoutX(100);
                    prix.setLayoutY(165);
                    nomt.setStyle("-fx-font-weight: bold;-fx-fill :#d82819");
                    prixt.setStyle("-fx-font-weight: bold;-fx-fill : #d82819");
                    t1.setOnMouseClicked((MouseEvent event) -> {
                      qtt=qtt+1;
                                     Produit.setQuantite(qtt);
                          Produit.setIddd(p3.getId_produit());
                       if(Produit.Panier.stream().anyMatch(p ->p.getId_produit()==Produit.getIddd())== false)
                       {             
                                     
                                   Produit.ajouter_dans_un_panier(p3.getId_produit());
                                      

                                    ListeCommande();
                                    getShowPane();

                               
                    } else {
                         if (p3.getStock() > 0) {
                           
                            System.out.println(p3.getStock());
                            ListeCommande();
                            getShowPane();
                           
                        } 
                    }
                       
                    
                          
                        
                    
                    }); 
                     t.setOnMouseClicked((MouseEvent event) -> {
                        Produit.setId_courant(p3.getId_produit());
                        
                        try {
                            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("panierr.fxml")));
                            
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            Logger logger = Logger.getLogger(getClass().getName());
                            logger.log(Level.SEVERE, "Failed to create new Window.", e);
                        }
                    }); pane.getChildren().addAll(pane2, nomt, prixt, nom, prix,rating);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ProduitfrontController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        F1.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ProduitfrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            ///////////////////////////////////              
            ///////////////////////////////////              
            ///////////////////////////////////              
            ///////////////////////////////////              
            ///////////////////////////////////              
            if (k == 2) {
                Pane pane2 = new Pane();
                pane2.setLayoutX(300);
                pane2.setLayoutY(50);
                pane2.setPrefWidth(pane2.getWidth() + 215);
                pane2.setPrefHeight(pane2.getHeight() + 200);
                pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10 ;-fx-border-color: #3f2b63 ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");

                JFXButton t = new JFXButton("");
                JFXButton t1 = new JFXButton("acheter");
                t.setStyle("-fx-font-weight: bold;-fx-background-color : white;");
                t1.setStyle("-fx-font-weight: bold;-fx-background-color : white;");
                HBox hb = new HBox(t);
                HBox hb2 = new HBox(t1);

                hb.setLayoutX(0);
                hb.setLayoutY(170);
                hb.setPrefWidth(hb.getWidth() + 160);
                hb.setPrefHeight(hb.getHeight() + 35);
                hb.setStyle("-fx-background-color: #3f2b63; -fx-background-radius: 0 0 0 10;");

                hb2.setLayoutX(155);
                hb2.setLayoutY(170);
                hb2.setPrefWidth(hb.getWidth() + 61);
                hb2.setPrefHeight(hb.getHeight() + 35);
                hb2.setStyle("-fx-background-color: #3f2b63; ; -fx-background-radius: 0 0 10 0;");
                pane2.getChildren().addAll(hb, hb2);

                 String A = p3.getNom_produit()+".jpg";
                    System.out.println(A);
                    String B = "C:\\xampp\\htdocs\\imgproj\\images\\" + A;
                   FileInputStream F1;
                try {
                    F1 = new FileInputStream(B);
                    Image image2 = new Image(F1);

                ImageView image = new ImageView();
                image.setFitWidth(140);
                image.setFitHeight(130);
                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                image.setImage(image2);
                image.setLayoutX(40);
                image.setLayoutY(-45);
                pane2.getChildren().add(image);

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ProduitfrontController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Rating rating = new Rating();
                rating.setPrefWidth(20);
                rating.setPrefHeight(19);
                rating.setLayoutX(320);
                rating.setLayoutY(180);
                
                int rate = 0;
                 rating.onMouseClickedProperty().set(new EventHandler<MouseEvent>()
             {
                  int kk=0;
          @Override
          public void handle(MouseEvent arg0)
          {
             
           kk=kk+1;
                       System.out.println(kk);
                       service_pr.AjouterRating(kk, p3.getId_produit());

          }
        });
                
                    try {
                       
                       rate = service_pr.AfficherRating(p3.getId_produit());
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(ProduitfrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
               
                rating.ratingProperty().setValue(rate);
                rating.setVisible(true);
                

                Text nomt = new Text("Nom: ");
                Label nom = new Label(p3.getNom_produit());
                Text prixt = new Text("prix : ");
                Label prix = new Label(String.valueOf(p3.getPrix()) + " DT");
                nomt.setLayoutX(325);
                nomt.setLayoutY(160);
                nom.setLayoutX(375);
                nom.setLayoutY(145);
                prixt.setLayoutX(325);
                prixt.setLayoutY(180);
                prix.setLayoutX(375);
                prix.setLayoutY(165);
                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                t1.setOnMouseClicked((MouseEvent event) -> {
                    
                   qtt=qtt+1;
                                     Produit.setQuantite(qtt);
                          Produit.setIddd(p3.getId_produit());
                       if(Produit.Panier.stream().anyMatch(p ->p.getId_produit()==Produit.getIddd())== false)
                       {             
                                     
                                   Produit.ajouter_dans_un_panier(p3.getId_produit());
                                      

                                    ListeCommande();
                                    getShowPane();

                               
                    } else {
                         if (p3.getStock() > 0) {
                           
                            System.out.println(p3.getStock());
                            ListeCommande();
                            getShowPane();
                           
                         }
                       }
                        
                              
                             
                                
                              
                });
                t.setOnMouseClicked((MouseEvent event) -> {
                   
                });
                                pane.getChildren().addAll(pane2, nomt, prixt, nom, prix,rating);

            }

            if (k == 3) {
                Pane pane2 = new Pane();
                pane2.setLayoutX(575);
                pane2.setLayoutY(50);
                pane2.setPrefWidth(pane2.getWidth() + 215);
                pane2.setPrefHeight(pane2.getHeight() + 200);
                pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10;-fx-border-color: #3f2b63 ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");

                JFXButton t = new JFXButton("");
                JFXButton t1 = new JFXButton("acheter");
                
                t.setStyle("-fx-font-weight: bold;-fx-background-color : white;");
                t1.setStyle("-fx-font-weight: bold;-fx-background-color : white;");
                HBox hb = new HBox(t);
                HBox hb2 = new HBox(t1);

                hb.setLayoutX(0);
                hb.setLayoutY(170);
                hb.setPrefWidth(hb.getWidth() + 160);
                hb.setPrefHeight(hb.getHeight() + 35);
                hb.setStyle("-fx-background-color: #3f2b63; -fx-background-radius: 0 0 0 10;");

                hb2.setLayoutX(155);
                hb2.setLayoutY(170);
                hb2.setPrefWidth(hb.getWidth() + 61);
                hb2.setPrefHeight(hb.getHeight() + 35);
                hb2.setStyle("-fx-background-color: #3f2b63; ; -fx-background-radius: 0 0 10 0;");
                pane2.getChildren().addAll(hb, hb2);

                String A = p3.getImage();
                A = "C:\\xampp\\htdocs\\imgproj\\" + A;
                File F1 = new File(A);
                Image image2 = new Image(F1.toURI().toString());

                ImageView image = new ImageView();
                image.setFitWidth(140);
                image.setFitHeight(130);
                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                image.setImage(image2);
                image.setLayoutX(40);
                image.setLayoutY(-45);
                pane2.getChildren().add(image);

              
              
                Text nomt = new Text("Nom: ");
                Label nom = new Label(p3.getNom_produit());
                Text prixt = new Text("prix : ");
                Label prix = new Label(String.valueOf(p3.getPrix()) + " DT");
                nomt.setLayoutX(600);
                nomt.setLayoutY(160);
                nom.setLayoutX(650);
                nom.setLayoutY(145);
                prixt.setLayoutX(600);
                prixt.setLayoutY(180);
                prix.setLayoutX(650);
                prix.setLayoutY(165);
                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                t1.setOnMouseClicked((MouseEvent event) -> {
                                                        System.out.println("salem");
                    
                       //////IF LE PRODUIT EXISTE DANS LE PANIER INCRIMENTER SA QUANTITE
                    
                        Produit.setIdpr(p3.getId_produit());
                   
                          
                            
                            Produit.setQuantite(1);
                            
                            System.out.println(p3.getStock());
                            
                          
                                  
                         
                                  System.out.println( Produit.ajouter_dans_un_panier(p3.getId_produit()));
                                
                               
                                
                                ListeCommande();
                                
                                 getShowPane();
                                
                           
                                
                          
                });
                t.setOnMouseClicked((MouseEvent event) -> {
                   
                });
                pane.getChildren().addAll(pane2, nomt, prixt, nom, prix);

            }
            k++;

        }
        return pane;
    }

    @FXML
    private void search(KeyEvent event) {
        recherche=rechercher.getText();
        getShowPane();
    }

     @FXML
    private void panierhide(MouseEvent event) {
         
//         ListView_Produits1.setItems(Produit.getPanier());
       ListView_Produits1.setVisible(false);
    }

    @FXML
    private void paniershow(MouseEvent event) {
    //   ListView_Produits1.setItems(Product.getPanier());
       ListView_Produits1.setVisible(true);
    }

    @FXML
    private void hidepanier2(MouseEvent event) {
         ListView_Produits1.setVisible(false);
    }

    @FXML
    private void showpanier2(MouseEvent event) {
             ListView_Produits1.setVisible(true);
    }

    /**
     * @return the anchor
     */
    public AnchorPane getAnchor(AnchorPane anchor) {
        return anchor;
    }

    /**
     * @param anchor the anchor to set
     */
    public void setAnchor(AnchorPane anchor) {
        this.anchor = anchor;
    }

    /**
     * @return the user
     */
  

    public void initializeP(){
    }
     @FXML
    void ButtonAjouterProduit(ActionEvent event) {
        try {
            Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("Panieerr.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(ProduitfrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void ButtonCommande(ActionEvent event) throws IOException {
        Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("HomeClientPannel.fxml"))));
    }

    



   
}
