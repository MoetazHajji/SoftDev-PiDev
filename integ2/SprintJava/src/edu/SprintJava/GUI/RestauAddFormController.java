/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import edu.SprintJava.entities.Resteau;
import edu.SprintJava.services.ServiceResteau;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
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
 private Path pathfrom;
    private Path pathto;
    private File Current_file;
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
               R1.setImgR(Resteau.pathfile);
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
    public static String pathfile; 
    public static String filename="";
    @FXML
    private void addimage(ActionEvent event) throws IOException {
    
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("imgR", ".jpeg",".png" , "*.jpg"));
        File f = fc.showOpenDialog(null);
        if (f != null) {
            String img = f.getAbsoluteFile().toURI().toString();
            Image imgR = new Image(img);
            //imgviewRestau.setImage(imgR);
            Resteau.pathfile = f.getAbsolutePath();
            Resteau.filename = f.getAbsolutePath();
            String path = "C:\\Users\\moete\\OneDrive\\Desktop\\3eme\\Semester 2\\integ2\\SprintJava\\src\\edu\\SprintJava\\uploads\\1.jpg";
            File uploads = new File(path);
            String imagecomp = f.getAbsolutePath();
            int index = imagecomp.lastIndexOf('\\');
            if (index > 0) {
                  pathfile = imagecomp.substring(index + 1);
            }          
            File sf = null;
            sf = new File(filename);
            File dest = null;
            Random rand = new Random();
            int n = rand.nextInt(50);
            String newpath =  path + pathfile ;
            dest = new File(newpath);
            Files.copy(sf.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            pathfile =  newpath ;
            System.out.println(pathfile);
        } 
}
}
    

