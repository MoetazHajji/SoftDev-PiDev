/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import com.jfoenix.controls.JFXTimePicker;
import edu.SprintJava.entities.Resteau;
import edu.SprintJava.entities.Session;
import edu.SprintJava.entities.mailing;
import edu.SprintJava.entities.reservationR;
import edu.SprintJava.services.ClientCRUD;
import edu.SprintJava.services.cReservationR;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AjouterReservationRFrontController implements Initializable {

    @FXML
    private TextField lblidR;
    
    @FXML
    private TextField llbltimeR;
    @FXML
    private DatePicker lblDateR;
    @FXML
    private TextField lblnbpR;
    @FXML
    private JFXTimePicker timer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Resteau.setIduu(Session.getUser().getId());
      
        System.out.println(Resteau.getIduu());
    }    

    private void ReserverRestau(MouseEvent event) {
                cReservationR RE = new cReservationR();
    reservationR RE1= new reservationR();
             // RE1.setIdR(parseInt(lblidR.getText())); 
              RE1.setIdR(Resteau.getIdd());
              
               RE1.setId_user(Session.getUser().getId());
               RE1.setNbrPersonneR(parseInt(lblnbpR.getText()));
              RE1.setTimeR(timer.getValue().toString()); 
              RE1.setDateR(String.valueOf(lblDateR.getValue()));  
               RE.AjouterReservationR(RE1);
               Alert alert =new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("succes");
               alert.setHeaderText("Ajouté");
               alert.setContentText("reservation  Ajouté avec succés !");
            
               alert.showAndWait();
    }

    private void affichageReserv(MouseEvent event) {
         try{
            URL fxURL = getClass().getResource("ShowReservationForm.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ajout de Restau");
            stage.show();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void ReserverR(ActionEvent event) throws SQLException {
        cReservationR RE = new cReservationR();
    reservationR RE1= new reservationR();
             // RE1.setIdR(parseInt(lblidR.getText())); 
              RE1.setIdR(Resteau.getIdd());
              
               RE1.setId_user(Session.getUser().getId());
               RE1.setNbrPersonneR(parseInt(lblnbpR.getText()));
              RE1.setTimeR(timer.getValue().toString()); 
              RE1.setDateR(String.valueOf(lblDateR.getValue()));  
               RE.AjouterReservationR(RE1);
                ClientCRUD client = new ClientCRUD();
               mailing m=new mailing();
                m.send("asmaoudherfi91@gmail.com","esmaesprit2000",client.afficherEmail(Session.getUser().getUsername()).get(0).getEmail() , "CULTUN"
                        , "Congradulation  "+client.afficherClient(Session.getUser().getUsername()).get(0).getNom()+" your reservation is saved ");
               
                Alert alert =new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("succes");
               alert.setHeaderText("Ajouté");
               alert.setContentText("reservation  Ajouté avec succés !");
            
               alert.showAndWait();
    }
    
    }
    

