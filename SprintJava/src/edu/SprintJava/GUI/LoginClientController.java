/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Admin;
import edu.SprintJava.entities.Client;
import edu.SprintJava.entities.Session;
import edu.SprintJava.entities.User;
import edu.SprintJava.services.AdminCRUD;
import edu.SprintJava.services.ClientCRUD;
import edu.SprintJava.services.User_service;
import edu.SprintJava.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

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
    @FXML
    private Label LBErrorMessage;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void LoginClient(ActionEvent event) {
        User_service us = new User_service();
        User u = new User();
        u.setUsername(TFUsername.getText());
        u.setPass(PFPassword.getText());
        int attempt = 1;
        if (us.Authentification(u)) {
            Parent home_page_parent;
            System.err.println(us.checkRole(TFUsername.getText()));
            if (us.checkRole(TFUsername.getText()).equals("Admin") && attempt < 4) {
                try {
                    Session.getFirstInstance(Session.getUser());
                    home_page_parent = FXMLLoader.load(getClass().getResource("HomeAdminPannel.fxml"));
                    Scene home_page_scene = new Scene(home_page_parent);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (us.checkRole(TFUsername.getText()).equals("Client") && attempt < 4) {
                home_page_parent = FXMLLoader.load(getClass().getResource("Home.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show();

            } else if (us.checkRole(TFUsername.getText()).equals("Owner") && attempt < 4) {
                Session.getFirstInstance(Session.getUser());
                int ide = Session.getUser().getId();
                System.out.println(ide);
                home_page_parent = FXMLLoader.load(getClass().getResource("Profile.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show();

            } else if (attempt != 4) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Denied!" + attempt);
                alert.showAndWait();
                attempt--;

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("attempt exceed!" + attempt);
                alert.showAndWait();

                TFPassword.setDisable(true);
                TFUsername.setEditable(false);
            }

            attempt++;

        }

    }
    
    void loadMain() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("HomeClientPannel.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("CULTUN");
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
    
    @FXML
    private void CloseLoginClient(ActionEvent event) {
    }

}
