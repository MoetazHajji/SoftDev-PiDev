/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.GUI;

import edu.SprintJava.entities.Activite;
import edu.SprintJava.entities.Reservation;
import edu.SprintJava.entities.Session;
import edu.SprintJava.entities.Transport;
import edu.SprintJava.services.ActiviteCRUD;
import edu.SprintJava.services.ReservationCRUD;
import edu.SprintJava.services.TransportCRUD;
import edu.SprintJava.utils.ControleSaisie;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Soulaymen
 */
public class AjouterReservationController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfNbre_places;
    @FXML
    private TextField tfNum_tel;
    @FXML
    private TextField tfEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Reservation.setIdcll(Session.getUser().getId());
    }

    @FXML
    private void PlacerReservation(ActionEvent event) throws IOException, SQLException {
        int s;
        ControleSaisie cs = new ControleSaisie();
        if (!cs.testNomPrenom(tfNom.getText())) {
            JOptionPane.showMessageDialog(null, "Insérer un nom correct");
        } else if (!cs.testNomPrenom(tfPrenom.getText())) {
            JOptionPane.showMessageDialog(null, "Insérer un prénom correct");
        } else if ((!cs.GSM(tfNum_tel.getText()))) {
            JOptionPane.showMessageDialog(null, "Insérer un numéro valide SVP ");
        } else if ((!cs.mailFormat(tfEmail.getText()))) {
            JOptionPane.showMessageDialog(null, "Insérer un Email valide SVP ");
        } else {

            ReservationCRUD pcd = new ReservationCRUD();
            Reservation a = new Reservation();
            ActiviteCRUD act = new ActiviteCRUD();
            Activite ac = new Activite();
            TransportCRUD tra = new TransportCRUD();
            Transport tr = new Transport();
            a.setNom_cl(tfNom.getText());
            a.setPrenom_cl(tfPrenom.getText());
if (Transport.getIdd() > 0) {
                a.setReftra(Transport.getIdd());
                 s=tra.GetPrix(Transport.getIdd());
                 tra.EliminerPlacestr(Transport.getIdd(), Integer.parseInt(tfNbre_places.getText()));
               // tra.EliminerPlacestr(Transport.getIdd(), Integer.parseInt(tfNbre_places.getText()));
            } else {
                a.setReftra(0);
              s=0;
            };
            
            a.setNbr_places(Integer.parseInt(tfNbre_places.getText()));
            act.EliminerPlaces(Activite.getIdd(), Integer.parseInt(tfNbre_places.getText()));
            a.setTel_cl(Integer.parseInt(tfNum_tel.getText()));
            a.setPrix_res((act.GetPrix(Activite.getIdd())+s) * Integer.parseInt(tfNbre_places.getText()));
 act.EliminerPlaces(Activite.getIdd(), Integer.parseInt(tfNbre_places.getText()));
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
           
            a.setDate_res(strDate);
            a.setEmail_cl(tfEmail.getText());
            a.setRefact(Activite.getIdd());

            pcd.ajouterReservation(a);

            //act.EliminerPlaces(Activite.getIdd(), Integer.parseInt(tfNbre_places.getText()));
            
                Parent root = FXMLLoader.load(getClass().getResource("AfficherReservation.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            
        }
    }
    

    private void back(ActionEvent event) throws IOException{
       
            Parent root = FXMLLoader.load(getClass().getResource("AfficherReservation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        
    }

    @FXML
    private void backToFrontActivite(ActionEvent event) throws IOException {
        Launcher.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("FrontActivite.fxml"))));
    }
}
