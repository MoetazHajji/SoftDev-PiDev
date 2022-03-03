/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import tn.edu.esprit.models.Resteau;
import tn.edu.esprit.services.ServiceResteau;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class RestauAddFormController implements Initializable {

    @FXML
    private TextField tfNomR;
    @FXML
    private TextField tfAdR;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfPays;
    @FXML
    private TextField tfTel;
    @FXML
    private Label lbAfficheR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           
    }    

    
    
   boolean verifiervide()
           
    {
       
        if(tfNomR.getText().equals("")) {  
             
            tfNomR.setText("il faut remplir les champs");
           
           return true;
        }
        else if(tfAdR.getText().equals("")) {
           tfAdR.setText("il faut remplir les champs");
           return true;
         
            //usernameTick.setVisible(true);
        }
                else if(tfPays.getText().equals("")) {
           tfPays.setText("il faut remplir les champs");
           return true;
         
            //usernameTick.setVisible(true);
        }
                         else if(tfTel.getText().equals("")) {
           tfTel.setText("il faut remplir les champs");
           return true;
         
            //usernameTick.setVisible(true);
        }
                
        else if(tfType.getText().equals("")){
             tfType.setText("il faut remplir les champs");
       
        return true;
       
        }
       
        return false;
   
   
   
    }
    boolean verifiernom()
    {
        Pattern regexPattern = Pattern.compile(Resteau.REGEX);
       Matcher matcher;
        matcher =regexPattern.matcher( tfNomR.getText());
         if(matcher.find()==false)
        {
           
       
               tfNomR.setText("");
             tfNomR.setText("nom invalide");
             return true;
             
        }
         else
         {
           
              //nomlabel.setText("valide");
         
             
             return false;
         
         }
         

   
   
    }
    boolean verifiertel()
    {
        Pattern regexPattern = Pattern.compile(Resteau.REGEXnumber);
       Matcher matcher;
        matcher =regexPattern.matcher(tfTel.getText());
         if (matcher.find()==false)
        {
           
            
            
             tfTel.setText("");
             tfTel.setText("numTel invalide");
              return true;
             
            
        }
         
               
            
             
             return false;
         
         
         

   
   
    }
 
    
    
    @FXML
    private void AjouterResteau(ActionEvent event) {
        if((verifiernom()==false)&&(verifiertel()==false))
        {
         ServiceResteau sp = new ServiceResteau();
               Resteau R1 = new Resteau();
               R1.setNomR(tfNomR.getText()); 
               R1.setTypeR(tfType.getText()); 
               R1.setAdressR(tfAdR.getText()); 
               R1.setPaysR(tfPays.getText()); 
               R1.setTelR(tfTel.getText()); 
               sp.ajouter(R1);
               Alert alert =new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("succes");
               alert.setHeaderText("Ajouté");
               alert.setContentText("restau Ajouté avec succés !");
            Notifications notificationBuilder = Notifications.create()
                        .title(" Restaurant  Ajoutée")
                        .text("Saved in your DATABASE").darkStyle()
             .graphic(null)
   // .graphic(null)
                        
                        .hideAfter(Duration.seconds(15))
                        .position(Pos.TOP_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               System.out.println("Clicked on notification");
            }
        });
                notificationBuilder.darkStyle();
                notificationBuilder.show();
               alert.showAndWait();
    }
    }


    }
    

