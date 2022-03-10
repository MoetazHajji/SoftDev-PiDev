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
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author mariem
 */
public class AjouterproduitController implements Initializable {
private Desktop desktop = Desktop.getDesktop();
    private String file_image;
     final FileChooser fileChooser = new FileChooser();
    @FXML
    private Button ajout;
    @FXML
    private JFXTextField stock;
    @FXML
    private JFXButton fichier;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXTextField tnom;
    @FXML
    private RadioButton vet1;
    @FXML
    private RadioButton art2;
    @FXML
    private RadioButton acc3;
    @FXML
    private ImageView image_p;
    @FXML
    private ImageView nomTick;
    @FXML
    private ImageView prixTick;
    @FXML
    private ImageView stockTick;
    @FXML
    private ImageView croixnom;
    @FXML
    private ImageView croixprix;
    @FXML
    private ImageView croixstock;
    @FXML
    private Label nomlabel;
    @FXML
    private Label prixlabel;
    @FXML
    private Label labelstock;
    @FXML
    private Pane pnlStatus;
    @FXML
    private Label lblStatus;
    @FXML
    private JFXButton Commande;
    @FXML
    private JFXButton Statistique;
       private Path pathfrom;
    private Path pathto;
    private File Current_file;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         tnom.setVisible(true);
        prix.setVisible(true);
        stock.setVisible(true);
       nomTick.setVisible(false);
       prixTick.setVisible(false);
       stockTick.setVisible(false);
     croixnom.setVisible(false);
       croixprix.setVisible(false);
       croixstock.setVisible(false);
          
        
        //categorie_pr<String> list = categorie_pr.

//comboBox.setItems(list);
        // TODO
    }
      @FXML
    private void controlUsername(KeyEvent event) {
         ProduitCRUD ps = new ProduitCRUD();
       

    }
    
    
     @FXML
    private String radioSelected(ActionEvent event) {
        String type = "";
        if (vet1.isSelected()) {
         type=vet1.getText();
        }
        if (acc3.isSelected()) {
            type= acc3.getText();
        }
        return type;
    }
    
    boolean verifiervide()
            
    {
        
        if(tnom.getText().equals("")) {  
              
            nomlabel.setText("il faut remplir les champs");
           
           return true;
        }
        else if(prix.getText().equals("")) {
           prixlabel.setText("il faut remplir les champs");
           return true;
          
            //usernameTick.setVisible(true);
        }
        else if(stock.getText().equals("")){
             labelstock.setText("il faut remplir les champs");
        
        return true;
        
        }
        
        return false;
    
    
    
    }
    boolean verifiernom()
    {
        Pattern regexPattern = Pattern.compile(Produit.REGEX);
       Matcher matcher;
        matcher =regexPattern.matcher(tnom.getText());
         if(matcher.find()==false)
        {
            
             croixnom.setVisible(true);
              nomlabel.setText("");
             nomlabel.setText("nom invalide");
             return true;
             
        }
         else
         {
            croixnom.setVisible(false);
              nomlabel.setText("");
             nomTick.setVisible(true);
             
             return false;
         
         }
         

    
    
    }
    boolean verifierprix()
    {
        Pattern regexPattern = Pattern.compile(Produit.REGEXnumber);
       Matcher matcher;
        matcher =regexPattern.matcher(prix.getText());
         if(matcher.find()==false)
        {
            
             croixprix.setVisible(true);
              prixlabel.setText("");
             prixlabel.setText("prix invalide");
             return true;
             
        }
         else
         {
             croixprix.setVisible(false);
               prixlabel.setText("");
             prixTick.setVisible(true);
             
             return false;
         
         }
         

    
    
    }
   boolean verifierstock()
    {
    
      Pattern regexPattern = Pattern.compile(Produit.REGEXnumber);
       Matcher matcher;
        matcher =regexPattern.matcher(stock.getText());
         if(matcher.find()==false)
        {
            
             croixstock.setVisible(true);
              labelstock.setText("");
             labelstock.setText("stock invalide");
             return true;
             
        }
         else
         {
             croixstock.setVisible(false);
               labelstock.setText("");
             stockTick.setVisible(true);
             
             return false;
         
         }
    
    }

    @FXML
    private void ajout(ActionEvent event) {
   //String REGEX = "[a-zA-Z]"   ; 
    //String pattern = "[a-zA-Z]*log[a-zA-Z]*";
       
      ProduitCRUD sp = new ProduitCRUD();
        
        
       
          if((verifiervide()==false) && (verifiernom()==false) && (verifierprix()==false) &&  verifierstock()==false)
          {
        try {
            
            String typpe= radioSelected(event);
            
            
            Produit p = new Produit();
            
            
            p.setNom_produit(tnom.getText());
            p.setStock(Integer.parseInt(stock.getText()));
            p.setPrix(Integer.parseInt(prix.getText()));
            p.setType(typpe);
            //p.setImage("hahah");
           // sp.ajouterproduit(p);
            // file_image = + file_image;
            
            p.setImage(file_image);

        pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
        pathto = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\imgproj\\images\\" + Current_file.getName());
        Path targetDir = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\imgproj\\images\\");

        Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);

        sp.ajouterproduit(p);

       Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("Ajouterproduit.fxml"))));
            // p.setType(categorie_pr.getValue().);
        } catch (IOException ex) {
            Logger.getLogger(AjouterproduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    
    }
    }
    

   

    @FXML
    private void fichier_image(ActionEvent event) throws MalformedURLException {
        Current_file = fileChooser.showOpenDialog(Launcher.getInstance().getStage());
        if (Current_file != null) {
//                        openFile(file);
            System.out.println(Current_file.toURI().toURL().toExternalForm());
            file_image = Current_file.getName();
        }

        Image image2 = new Image(Current_file.toURI().toString());

        image_p.setImage(image2);

     /*   final GridPane inputGridPane = new GridPane();
        GridPane.setConstraints(fichier, 0, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));*/
    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {

            // Logger.getLogger(
            //     afficheproduit.class.getName()).log(
            //   Level.SEVERE, null, ex
            // );
        }
    }
      @FXML
    void ButtonStaistique(ActionEvent event) {
         try {
            Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("affichercommande.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(PanieerrController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    void ButtonCommande(ActionEvent event) {
        try {
            Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("afficherproduitt.fxml"))));
        } catch (IOException ex) {
            Logger.getLogger(AjouterproduitController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    

}
