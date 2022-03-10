/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Sponsor;
import edu.SprintJava.services.SponsorCRUD;
import edu.SprintJava.utils.ControleSaisie;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author khalil
 */
public class ModifierSponsController implements Initializable {
        ObservableList<String> types = FXCollections.observableArrayList("Matériel", "Immatériel");

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfTel;
    private TextField tfType;
    @FXML
    private ChoiceBox<String> cbType_aide;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbType_aide.setItems(types);
        cbType_aide.setValue("Matériel");
        // TODO
        tfNom.setText(Sponsor.getNom_s());
        tfPrenom.setText(Sponsor.getPrenom_s());
        tfTel.setText(Integer.toString(Sponsor.getN_s()));
    }

    @FXML
    private void ModifierSpons(ActionEvent event) throws IOException {
        SponsorCRUD sc = new SponsorCRUD();
        ControleSaisie cs = new ControleSaisie();

        if (tfNom.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "veuillez remplir le champ nom");
        } else if (tfPrenom.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "veuillez remplir le champ prenom");
        } else if (tfTel.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "veuillez remplir le champ numero");
        } else if (!cs.testNomPrenom(tfNom.getText())) {
            JOptionPane.showMessageDialog(null, "Le nom est incorrect!");
        } else if (!cs.testNomPrenom(tfPrenom.getText())) {
            JOptionPane.showMessageDialog(null, "Le prenom est incorrect!");
        } else if (!cs.GSM(tfTel.getText())) {
            JOptionPane.showMessageDialog(null, "Le numero est incorrect!");
        } else {
            Sponsor t = new Sponsor();

            sc.modifierSponsor(Sponsor.getId_s(),tfNom.getText(), tfPrenom.getText(), Integer.parseInt(tfTel.getText()), cbType_aide.getValue());
            JOptionPane.showMessageDialog(null, "Sponsor modifié ✓");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierSpons.fxml"));
            Parent root = loader.load();
            tfNom.getScene().setRoot(root);
        }

    }

    @FXML
    private void GestionSponsor(ActionEvent event) {
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
