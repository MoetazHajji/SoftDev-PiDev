/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import edu.SprintJava.entities.Sponsor;
import edu.SprintJava.utils.ControleSaisie;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author khalil
 */
public class EnvoyerSmsController implements Initializable {

    @FXML
    private TextField fxTo;
    @FXML
    private TextArea fxMessage;
    @FXML
    private FontAwesomeIconView tfBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                fxTo.setText(Integer.toString(Sponsor.getN_s()));

    }

    @FXML
    public void envoyersms(ActionEvent event) {
        api ap = new api();
        ControleSaisie cs = new ControleSaisie();
        if (fxTo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "veuillez entrer un numero");
        } else if (fxMessage.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "veuillez remplir le champ Message");
        } else  {
            ap.sms("khaliloo", "khalil123*", fxTo.getText(), fxMessage.getText());
            JOptionPane.showMessageDialog(null, "Message envoyé ✓");

        }
    }
    

    @FXML
    private void GestionSponsor(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherSpons.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
