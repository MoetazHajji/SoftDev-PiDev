/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

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
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class HomeClientPannelController implements Initializable {

    @FXML
    private Pane pnlClient;
    @FXML
    private Label LBNom;
    @FXML
    private Label LBPrenom;
    @FXML
    private Label LBMobile;
    @FXML
    private Label LBUsername;
    @FXML
    private Label LBPassword;
    @FXML
    private Label LBEmail;
    @FXML
    private Label LBPaysVille;
    @FXML
    private Pane pnlActualite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pnlActualite.toFront();
    }    

    @FXML
    private void AfficherSettingsPane(ActionEvent event) {
        pnlClient.toFront();
    }

    @FXML
    private void ModifierClient(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("ModifierClient.fxml"));

            Scene scene=new Scene(root);
            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SupprimerClient(ActionEvent event) {
    }

    @FXML
    private void AfficherPaneActua(ActionEvent event) {
        pnlActualite.toFront();
    }
    
}
