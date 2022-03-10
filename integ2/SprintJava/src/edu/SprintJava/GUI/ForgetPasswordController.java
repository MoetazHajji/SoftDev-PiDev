/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Client;
import edu.SprintJava.entities.mailing;
import edu.SprintJava.services.ClientCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class ForgetPasswordController implements Initializable {

    @FXML
    private TextField TFUsername;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Recuperer(ActionEvent event) throws SQLException {
        
            ClientCRUD client = new ClientCRUD();
            mailing m=new mailing();
            m.send("asmaoudherfi91@gmail.com","esmaesprit2000", client.afficherEmail(TFUsername.getText()).get(0).getEmail(), "CULTUN", "This your password "+client.afficherEmail(TFUsername.getText()).get(0).getPassword());
            ((Stage) TFUsername.getScene().getWindow()).close();
        
        
    }

    @FXML
    private void CloseLoginClient(ActionEvent event) {
    }

    @FXML
    private void BackToLogin(ActionEvent event) throws IOException {
        Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("LogiClient.fxml"))));
    }
    
}
