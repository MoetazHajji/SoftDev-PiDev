/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import edu.SprintJava.entities.Commentaire;
import edu.SprintJava.entities.Resteau;
import edu.SprintJava.entities.Session;
import edu.SprintJava.services.CommentaireResteau;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AddCmntrFormController implements Initializable {

    @FXML
    private TextField lblcontenucmntr;
    @FXML
    private TextField lblIdR;
    @FXML
    private TextField lbliduser;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Commentaire.setIdus(Session.getUser().getId());
        System.out.println(Session.getUser().getId());
        lbliduser.setText(Integer.toString(Session.getUser().getId()));
        // TODO   
    }    

    @FXML
    private void ajoutercmntrR(MouseEvent event) {
        
                  CommentaireResteau C = new CommentaireResteau();
           Commentaire C1=new Commentaire();
           Commentaire.setIdus(Session.getUser().getId());
           
               //C1.setIdR(parseInt(lblIdR.getText())); 
               C1.setIdR(Resteau.getIdd());
               C1.setid_user(parseInt(lbliduser.getText()));
               C1.setContenuCommentaireR(lblcontenucmntr.getText());  
               C.AjouterCommentaire(C1);
               Alert alert =new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("succes");
               alert.setHeaderText("Ajouté");
               alert.setContentText("commentaire  Ajouté avec succés !");
            
               alert.showAndWait();
    }

    @FXML
    private void backToFrontRestau(ActionEvent event) throws IOException {
        
            Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("FrontRestau.fxml"))));
        
    }
    
}
