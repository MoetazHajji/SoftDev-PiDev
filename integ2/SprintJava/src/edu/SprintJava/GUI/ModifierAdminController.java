/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Admin;
import edu.SprintJava.services.AdminCRUD;
import edu.SprintJava.utils.Notification;
import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class ModifierAdminController implements Initializable {

    @FXML
    private TextField TFPrenom;
    @FXML
    private TextField TFEmail;
    @FXML
    private TextField TFUsername;
    @FXML
    private TextField TFNom;
    @FXML
    private TextField TFCIN;
    @FXML
    private PasswordField TFPassword;
    @FXML
    private ComboBox<String> CBROLE;
    
    ObservableList<String> Roles = FXCollections.observableArrayList("Master","Evenement", "Produit", "Hebergement", "Restaurant", "Activité", "Patrimoine");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       TFNom.setText(Admin.getNomm());
       TFPrenom.setText(Admin.getPrenomm());
       TFCIN.setText(Integer.toString(Admin.getCinn()));
       TFEmail.setText(Admin.getEmaill());
       TFUsername.setText(Admin.getUsernamee());
       TFPassword.setText(Admin.getPasss());
    }    

    @FXML
    private void ReturnToClientPannel(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("HomeAdminPannel.fxml"));
            Scene scene=new Scene(root);
            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        
    }

    @FXML
    private void ModifierAdmin(ActionEvent event) throws AWTException {
        AdminCRUD adc=new AdminCRUD();
        Admin ad=new Admin();
            adc.modifierAdmin(Admin.getIdd(),TFNom.getText(), TFPrenom.getText(), Integer.parseInt(TFCIN.getText()), TFUsername.getText()
                , TFEmail.getText(), TFPassword.getText());
            Notification.main("Admin !", "Admin modifié avec succé !!");  
            
    }
    
}
