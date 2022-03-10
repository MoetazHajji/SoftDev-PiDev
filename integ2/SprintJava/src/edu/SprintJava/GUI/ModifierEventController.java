/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Evenement;
import edu.SprintJava.services.EvenementCRUD;
import edu.SprintJava.utils.ControleSaisie;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author khalil
 */
public class ModifierEventController implements Initializable {

    ObservableList<String> types = FXCollections.observableArrayList("musique", "Fête foraine",
            "Industriel", "Street Art", "Cinéma", "Gastronomie");
    @FXML
    private TextField tfemplacement;
    @FXML
    private TextField tfnom_event;
    private TextField tfdate_debut;
    private TextField tfdate_fin;
    @FXML
    private TextField tfnombre_participants;
    @FXML
    private TextField tfdescription;
    @FXML
    private ChoiceBox<String> cbtype;
    @FXML
    private DatePicker dateDebut;
    @FXML
    private DatePicker dateFin;
    @FXML
    private Label Label_dd;
    @FXML
    private Label Label_df;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbtype.setItems(types);
        cbtype.setValue("Cinéma");

        // TODO
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate_d = dateFormat.format(Evenement.getD_deb());
        String strDate_f = dateFormat.format(Evenement.getD_f());

        tfnom_event.setText(Evenement.getNom());
        tfdescription.setText(Evenement.getDescrip());
        tfnombre_participants.setText(Integer.toString(Evenement.getNbr()));
        tfemplacement.setText(Evenement.getPlace());
        Label_dd.setText(strDate_d);
        Label_df.setText(strDate_f);
        System.out.println(strDate_d);
                System.out.println(strDate_f);


    }

    @FXML
    private void ModifierEvent(ActionEvent event) {

        LocalDate ldd = dateDebut.getValue();
        LocalDate ldd1 = dateFin.getValue();
//        Date dateDD = Date.valueOf(ldd);
//        Date dateDF = Date.valueOf(ldd1);
        EvenementCRUD evc = new EvenementCRUD();
        ControleSaisie cs = new ControleSaisie();
        if (tfnom_event.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "veuillez remplir le champ nom");
        } else if (tfemplacement.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "veuillez remplir le champ emplacement");
        } else if (tfnombre_participants.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "veuillez remplir le champ nombre de participants");
        } else if (!cs.testNomPrenom(tfnom_event.getText())) {
            JOptionPane.showMessageDialog(null, "Le nom de cet evenement est incorrect");
        } else if (!cs.testEmplacement(tfemplacement.getText())) {
            JOptionPane.showMessageDialog(null, "L'emplacement saisie est incorrect");
        } else {
            evc.modifierEvenement(Evenement.getId(), tfnom_event.getText(),
                    Integer.parseInt(tfnombre_participants.getText()), Date.valueOf(ldd),
                    Date.valueOf(ldd1), tfemplacement.getText(), tfdescription.getText(), cbtype.getValue());
            JOptionPane.showMessageDialog(null, "Evenement modifié ✓");

        }
    }

    @FXML
    private void GestionEvent(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherEvent.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Effacer(ActionEvent event) {
        Label_dd.setText("");
    }

    @FXML
    private void EffacerF(ActionEvent event) {
                Label_df.setText("");

    }

}
