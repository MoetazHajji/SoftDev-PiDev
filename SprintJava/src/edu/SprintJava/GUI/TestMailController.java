/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.MailServerInfo;
import edu.SprintJava.utils.AlertMarker;
import edu.SprintJava.utils.ControleSaisie;
import edu.SprintJava.utils.GenericCallback;
import edu.SprintJava.utils.MailUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class TestMailController implements Initializable {
    private final static Logger LOGGER = LogManager.getLogger(TestMailController.class.getName());
    
    @FXML
    private ProgressBar PBProgressBar;
    @FXML
    private TextField TFAdressInput;
    
    private MailServerInfo mailServerInfo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleStartButton(ActionEvent event) {
        String toAddress = TFAdressInput.getText();
        if (ControleSaisie.validateEmailAddress(toAddress)) {
            MailUser.sendMail(mailServerInfo, toAddress);
            PBProgressBar.setVisible(true);
        } else {
            AlertMarker.showErrorMessage("Failed", "Invalid email address!");
        }
    }
    
    
    public Object taskCompleted(Object val) {
        LOGGER.log(Level.INFO, "Callback received from Email Sender client {}", val);
        boolean result = (boolean) val;
        Platform.runLater(() -> {
            if (result) {
                AlertMarker.showSimpleAlert("Success", "Email successfully sent!");
            } else {
                AlertMarker.showErrorMessage("Failed", "Something went wrong!");
            }
            PBProgressBar.setVisible(false);
        });
        return true;
    }
    
}
