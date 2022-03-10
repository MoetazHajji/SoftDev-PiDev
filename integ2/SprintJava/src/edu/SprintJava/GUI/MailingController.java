/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import edu.SprintJava.entities.mailing;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MailingController implements Initializable {

    @FXML
    private TextField form;
    @FXML
    private TextField password;
    @FXML
    private TextField to;
    @FXML
    private TextField sub;
    @FXML
    private TextField msg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void SendMail(ActionEvent event) throws MessagingException {
        mailing m = new mailing();
        m.send("asmaoudherfi91@gmail.com","esmaesprit2000", "elaa.boulifi@esprit.tn", "qsddqsdq", "sdqdqs");
    }
   
}