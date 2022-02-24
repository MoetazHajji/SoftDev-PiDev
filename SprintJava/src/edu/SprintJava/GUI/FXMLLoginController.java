/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.services.AdminCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private TextField TFUsername;

    @FXML
    private TextField TFPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void Login(ActionEvent event) {
        try {
            AdminCRUD adc=new AdminCRUD();
            adc.Login(TFUsername.getText(), TFPassword.getText());
        } catch (Exception ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AdminLogin(ActionEvent event) {
    }

}
