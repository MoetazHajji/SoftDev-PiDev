/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.mailing;
import edu.SprintJava.services.ClientCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class MailController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Envoyer(ActionEvent event) {
        ClientCRUD ac=new ClientCRUD();
        mailing m=new mailing();
        m.send("asmaoudherfi91@gmail.com","esmaesprit2000", , "qsddqsdq", "Hello ");
    }
    
}
