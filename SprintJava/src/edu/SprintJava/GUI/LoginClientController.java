/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Admin;
import edu.SprintJava.entities.Client;
import edu.SprintJava.entities.Session;
import edu.SprintJava.services.AdminCRUD;
import edu.SprintJava.services.ClientCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class LoginClientController implements Initializable {

    @FXML
    private TextField TFUsername;
    @FXML
    private PasswordField TFPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void LoginClient(ActionEvent event) {
        try {
            ClientCRUD adc = new ClientCRUD();
            Client ad = new Client();
            adc.Login1(TFUsername.getText(), TFPassword.getText());
            closeStage();
            loadMain();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void loadMain() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("HomeClientPannel.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Library Assistant");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void closeStage() {
        ((Stage) TFUsername.getScene().getWindow()).close();
    }

    @FXML
    private void SignUp(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("AjouterClient.fxml"));
            Scene scene=new Scene(root);
            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
