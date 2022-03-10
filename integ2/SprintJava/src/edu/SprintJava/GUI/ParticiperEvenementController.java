/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Evenement;
import edu.SprintJava.entities.Ticket;
import edu.SprintJava.services.TicketCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author moete
 */
public class ParticiperEvenementController implements Initializable {

    @FXML
    private TextField TFNombreTicket;
    @FXML
    private Label LBSommePrix;
    @FXML
    private TextField tfNom_event;
    @FXML
    private AnchorPane RBgold;
    @FXML
    private RadioButton RBgoldd;
    @FXML
    private RadioButton RBsilver;
    @FXML
    private RadioButton RBbronze;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            tfNom_event.setText(Ticket.getNom_event());
        TFNombreTicket.setText("1");

        // TODO
    }

    @FXML
    private void BackToFrontEvent(ActionEvent event) {
        
        

    }

    @FXML
    private void SommeGold(ActionEvent event) {
        Ticket.setType("GOLD");
        int somme = Integer.parseInt(TFNombreTicket.getText())*300;
         LBSommePrix.setText("");

        LBSommePrix.setText("prix ticket :300 * " + TFNombreTicket.getText() + "=" + somme);
         Ticket.setPrixx(somme);

    }

    @FXML
    private void SommeSilver(ActionEvent event) {
        Ticket.setType("SILVER");
                 LBSommePrix.setText("");

        int somme = Integer.parseInt(TFNombreTicket.getText())*200;
        

        LBSommePrix.setText("prix ticket :200 * " + TFNombreTicket.getText() + "=" + somme);
        Ticket.setPrixx(somme);

    }

    @FXML
    private void SommeBronze(ActionEvent event) {
        Ticket.setType("BRONZE");
            LBSommePrix.setText("");

           int somme = Integer.parseInt(TFNombreTicket.getText())*100;
        

        LBSommePrix.setText("prix ticket :100 * " + TFNombreTicket.getText() + "=" + somme);
        Ticket.setPrixx(somme);

    }

    @FXML
    private void AjouterTicket(ActionEvent event) {
        TicketCRUD tt=new TicketCRUD();
        
            tt.ajouterTicket();
    }

}
